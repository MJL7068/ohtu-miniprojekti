package miniproju.services;

import miniproju.models.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReferenceServiceTest {

    @Autowired
    private ReferenceService rf;

    @Test
    public void newRepoIsEmpty() {
        assertTrue(rf.findAll().isEmpty());
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
}
