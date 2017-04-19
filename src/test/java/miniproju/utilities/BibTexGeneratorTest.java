package miniproju.utilities;

import java.util.HashMap;
import java.util.Map;
import miniproju.utilities.BibtexGenerator;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author matleino
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BibTexGeneratorTest {
    private HashMap<String, Object> emptyMap;
    
    private HashMap<String, Object> unemptyMap;
    
    @Before
    public void setUp() {
        emptyMap = new HashMap<>();
        
        unemptyMap = new HashMap<>();
        unemptyMap.put("author", "Milton {Abramowitz}");
        unemptyMap.put("title", "Handbook of Mathematical Functions with Formulas, Graphs, and Mathematical Tables");
        unemptyMap.put("publisher", "Dover");
    }
    
    @Test
    public void toBibTexWorksWithEmptyMap() {
        String v = "@Book{123\n}";
        assertEquals(v, BibtexGenerator.toBibtex("Book", "123", emptyMap));
    }
    
    @Test
    public void toBibTexWorksWithUnemptyMap() {
        String v = "@Book{123,\nauthor = {{M}ilton {{A}bramowitz}},\npublisher = {{D}over},\ntitle = {{H}andbook of {M}athematical {F}unctions with {F}ormulas, {G}raphs, and {M}athematical {T}ables}\n}";
        assertEquals(v, BibtexGenerator.toBibtex("Book", "123", unemptyMap));
    }
    
    @Test
    public void toBibTexWorkdWithSkands() {
        //TODO
    }
}
