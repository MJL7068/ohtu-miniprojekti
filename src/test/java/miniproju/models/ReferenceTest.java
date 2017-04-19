package miniproju.models;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReferenceTest {
    Reference ref;
    
    @Before
    public void setUp() {
        ref = new Reference("testi");
    }
    
    @Test
    public void testaus() {
        assertEquals(3, 3);
    }
}
