package miniproju.services;

import miniproju.models.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReferenceServiceTest {

    @Autowired
    private ReferenceService rf;

    @Test
    public void newRepoIsEmpty() {
        assertEquals(0, rf.findAll().size());
    }

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
}
