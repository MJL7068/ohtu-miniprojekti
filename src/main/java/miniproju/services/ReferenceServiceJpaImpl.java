package miniproju.services;

import java.util.List;
import miniproju.models.Reference;
import miniproju.repositories.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReferenceServiceJpaImpl implements ReferenceService {

    @Autowired
    private ReferenceRepository referenceRepository;

    @Override
    public List<Reference> findAll() {
        return this.referenceRepository.findAll();
    }

    @Override
    public Reference findWithId(Long id) {
        return this.referenceRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        this.referenceRepository.delete(id);
    }

    @Override
    public Reference create(Reference ref) {
        autoUniqueEntryKey(ref);
        return this.referenceRepository.save(ref);
    }

    @Override
    public Reference update(Reference ref) {
        return this.referenceRepository.save(ref);
    }

    @Override
    public String findAllInBibtex() {
        StringBuilder sb = new StringBuilder();
        for (Reference reference : findAll()) {
            sb.append(reference.toBibtexString());
            sb.append("\n");
        }

        return sb.toString();
    }

    @Override
    public Page<Reference> findWithPage(Pageable pageable) {
        return referenceRepository.findAll(pageable);
    }

    /**
     * Ensure unique entry keys in db
     *
     * @param ref
     */
    private void autoUniqueEntryKey(Reference ref) {
        String entryKey = ref.getEntryKey();

        if (entryKey == null) {
            entryKey = generateEntryKeyByAuthorsAndYear(ref);
        }

        if (referenceRepository.existsByEntryKey(entryKey)) {
            entryKey = appendExistingEntryKey(entryKey);
        }

        ref.setEntryKey(entryKey);
    }

    private String generateEntryKeyByAuthorsAndYear(Reference ref) {
        StringBuilder sb = new StringBuilder();
        ref.getAuthorSurnames().forEach(surname -> sb.append(surname.toUpperCase().charAt(0)));

        try {
            sb.append(ref.getYear());

        } catch (Exception e) {
        }

        return sb.toString();
    }

    private String appendExistingEntryKey(String entryKey) {
        int uniqueNumber = 2;

        while (referenceRepository.existsByEntryKey(entryKey + "-" + uniqueNumber)) {
            uniqueNumber++;
        }

        return entryKey + "-" + uniqueNumber;
    }

}
