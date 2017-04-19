package miniproju.services;

import miniproju.models.Owner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService us;

    @Test
    public void newRepoIsEmpty() {
        assertEquals(0, us.findAll().size());
    }

    @Test
    public void addUserIncrementsSize() {
        int size = us.findAll().size();
        us.create(new Owner());
        assertEquals(size + 1, us.findAll().size());
    }
}
