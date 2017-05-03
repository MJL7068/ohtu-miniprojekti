package miniproju.repositories;

import miniproju.models.Reference;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ReferenceRepository extends JpaRepository<Reference, Long> {

    public boolean existsByEntryKey(String entryKey);

}
