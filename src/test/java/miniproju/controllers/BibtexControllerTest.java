package miniproju.controllers;

import miniproju.models.Reference;
import miniproju.services.ReferenceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BibtexControllerTest {

    @Autowired
    BibtexController controller;

    @Autowired
    ReferenceService refService;

    @Test
    public void bibtexHasYearField() {
        Reference r = new Reference();
        r.setYear(1917);
        refService.create(r);
        assertTrue(fileContents().contains("1917"));
    }

    @Test
    public void bibtexFirstRowHasTypeAndKey() {
        Reference r = new Reference();
        r.setEntryType("inproceedings");
        r.setEntryKey("IAM2015");
        refService.create(r);
        assertTrue(fileContents().contains("@inproceedings{IAM2015"));
    }

    @Test
    public void bibtexNordicLettersNotUsed() {
        Reference r = new Reference();
        r.setSchool("ö");
        refService.create(r);
        assertFalse(fileContents().contains("\\\"o"));
    }

    @Test
    public void bibtexNordicLettersEscaped() {
        Reference r = new Reference();
        r.setSeries("å");
        refService.create(r);
        assertTrue(fileContents().contains(""));
    }

    private String fileContents() {
        HttpEntity<byte[]> file = controller.getBibtexFile(new HashMap<>());
        return new String(file.getBody());
    }
}
