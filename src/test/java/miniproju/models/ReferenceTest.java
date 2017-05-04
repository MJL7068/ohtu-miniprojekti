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
    public void gettersAndSettersWork() {
        Reference r = new Reference("Test");
        r.setEntryType("Article");
        r.setEntryKey("123");
        r.setAuthor("Allan Collins and John Seely Brown and Ann Holum");
        r.setJournal("American Educator");
        r.setYear(1991);
        r.setVolume("6");
        r.setPages("38-46");
        r.setId(Long.MIN_VALUE);
        r.setAddress("Osoite");
        r.setAnnote("annote");
        r.setBooktitle("Book title");
        r.setChapter("3");
        r.setCrossref("Cross ref");
        r.setEdition("22");
        r.setEditor("Editor");
        r.setHowpublished("Pub");
        r.setInstitution("institution");
        r.setKey("2");
        r.setMonth("12");
        r.setNote("Note");
        r.setNumber("123");
        r.setOrganization("organization");
        r.setPublisher("Publisher");
        r.setSchool("School");
        r.setSeries("7");
        r.setType("Type");
        
        assertEquals("Test", r.getTitle());
        assertEquals("Article", r.getEntryType());
        assertEquals("123", r.getEntryKey());
        assertEquals("Allan Collins and John Seely Brown and Ann Holum", r.getAuthor());
        assertEquals("American Educator", r.getJournal());
        assertEquals(1991, r.getYear());
        assertEquals("6", r.getVolume());
        assertEquals("38-46", r.getPages());
        assertEquals("" + Long.MIN_VALUE, "" + r.getId());
        assertEquals("Osoite", r.getAddress());
        assertEquals("annote", r.getAnnote());
        assertEquals("Book title", r.getBooktitle());
        assertEquals("3", r.getChapter());
        assertEquals("Cross ref", r.getCrossref());
        assertEquals("22", r.getEdition());
        assertEquals("Editor", r.getEditor());
        assertEquals("Pub", r.getHowpublished());
        assertEquals("institution", r.getInstitution());
        assertEquals("2", r.getKey());
        assertEquals("12", r.getMonth());
        assertEquals("Note", r.getNote());
        assertEquals("123", r.getNumber());
        assertEquals("organization", r.getOrganization());
        assertEquals("Publisher", r.getPublisher());
        assertEquals("School", r.getSchool());
        assertEquals("7", r.getSeries());
        assertEquals("Type", r.getType());
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
