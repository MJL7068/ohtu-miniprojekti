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
        ref = new Reference("Cognitive apprenticeship: making thinking visible");
        ref.setEntryType("Article");
        ref.setEntryKey("123");
        ref.setAuthor("Allan Collins and John Seely Brown and Ann Holum");
        ref.setJournal("American Educator");
        ref.setYear(1991);
        ref.setVolume("6");
        ref.setPages("38-46");
    }
    
    @Test
    public void toBibtexStringReturnsCorrectString() {
        String v = "@Article{123,\nauthor = {{A}llan {C}ollins and {J}ohn {S}eely {B}rown and {A}nn {H}olum},\njournal = {{A}merican {E}ducator},\npages = {38-46},\ntitle = {{C}ognitive apprenticeship: making thinking visible},\nvolume = {6},\nyear = {1991}\n}";
        assertEquals(v, ref.toBibtexString());
    }
    
    @Test
    public void authorSurnamesReturnedCorrectly() {
        ref.setAuthor("FirstSurname, Name and SecondSurname, Name and ThirdSurname, Name");
        assertEquals("FirstSurname", ref.getAuthorSurnames().get(0));
        assertEquals("SecondSurname", ref.getAuthorSurnames().get(1));
        assertEquals("ThirdSurname", ref.getAuthorSurnames().get(2));
    }
}
