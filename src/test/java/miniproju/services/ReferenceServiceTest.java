package miniproju.services;

import miniproju.models.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReferenceServiceTest {

    @Autowired
    private ReferenceService rf;

//    @Test
//    public void newRepoIsEmpty() {        
//        assertEquals(0, rf.findAll().size());
//    }
    @Test
    public void addNewReferenceIsFound() {
        Reference original = rf.create(new Reference("joo"));
        Reference found = rf.findWithId(original.getId());
        assertEquals(original.getTitle(), found.getTitle());
    }

    @Test
    public void addNewRefIncrementsSize() {
        int size = rf.findAll().size();
        rf.create(new Reference());
        assertEquals(size + 1, rf.findAll().size());
    }

    @Test
    public void editRefWorks() {
        Reference ref = rf.create(new Reference("testaus"));
        ref.setTitle("EDIT");
        rf.update(ref);
        assertEquals("EDIT", rf.findWithId(ref.getId()).getTitle());
    }

    @Test
    public void findAllInBibtexContainsReferenceJournalField() {
        Reference ref = new Reference();
        ref.setJournal("ieee");
        rf.create(ref);
        String bibtex = rf.findAllInBibtex();
        assertTrue(bibtex.contains("ieee"));
    }

    @Test
    public void deleteRefWorks() {
        rf.create(new Reference("one"));
        int size = rf.findAll().size();
        Reference two = new Reference("two");
        rf.create(two);
        rf.remove(two.getId());

        assertEquals(size, rf.findAll().size());
    }

    @Test
    public void entryKeyIsGeneratedWhenNoEntryKeyWasSetByUser() {
        Reference ref = new Reference();
        ref.setAuthor("Surname, Firstname");
        ref.setYear(2000);
        rf.create(ref);

        assertEquals("S2000", ref.getEntryKey());
    }

    @Test
    public void newUniqueEntryKeyIsGeneratedWhenEntryKeyWasUsedBefore() {
        Reference ref = new Reference();
        ref.setAuthor("Surname, Firstname");
        ref.setYear(1000);
        rf.create(ref);

        Reference ref2 = new Reference();
        ref2.setAuthor("Surname, Firstname");
        ref2.setYear(1000);
        rf.create(ref2);

        assertEquals("S1000-2", ref2.getEntryKey());
    }

    @Test
    public void findWithPageableReturnsCorrectPagination() {
        for (int size = 1; size < rf.findAll().size(); size++) {
            Pageable pageable = new PageRequest(0, size);
            Page<Reference> page = rf.findWithPage(pageable);

            // correct amount of references on a page
            assertEquals(size, page.getNumberOfElements());

            // all
            assertEquals(rf.findAll().size(), page.getTotalElements());

            // number of pages
            assertEquals((int) Math.ceil((double) rf.findAll().size() / size), page.getTotalPages());
        }

    }
}
