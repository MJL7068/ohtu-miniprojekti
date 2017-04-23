/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproju.controllers;

import java.util.Map;

import miniproju.models.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import miniproju.services.ReferenceService;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ilkka
 */
@Controller
public class RefController {

    @Autowired
    private ReferenceService referenceService;

    /*  RequestMapping
        - map all HTTP verbs to /greeting to this method
        - narrow down ala @RequestMapping(method=GET)                 
    
        Requestparam
        - bind query parameter 'name' to method parameter 'name'
    
        PathVariable
        - bind pathvariable to method parameter 'id'
     */
    @RequestMapping("/references/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        Reference ref = referenceService.findWithId(id);
        model.addAttribute("ref", ref);
        
        return "references/view";
    }

    @RequestMapping(value = "/references/book_new", method = GET)
    public String newBook() {

        return "references/book_new";
    }

    @RequestMapping(value = "/references/book_new", method = POST)
    public String saveBookRef(@RequestParam Map<String, String> params) {
        params.values().removeIf(v -> v.equals(""));

        Reference r = new Reference();
        setFields(params, r);
        referenceService.create(r);
        return "redirect:/";
    }

    private void setFields(Map<String, String> params, Reference r) {
        r.setEntryType(params.get("entrytype"));
        r.setEntryKey(params.get("entrykey"));

        r.setAddress(params.get("address"));
        r.setAnnote(params.get("annote"));
        r.setAuthor(params.get("author"));
        r.setBooktitle(params.get("booktitle"));
        r.setChapter(params.get("chapter"));
        r.setCrossref(params.get("crossref"));
        r.setEdition(params.get("edition"));
        r.setEditor(params.get("editor"));
        r.setHowpublished(params.get("howpublished"));
        r.setInstitution(params.get("institution"));
        r.setJournal(params.get("journal"));
        r.setKey(params.get("key"));
        r.setMonth(params.get("month"));
        r.setNote(params.get("note"));
        r.setNumber(params.get("number"));
        r.setOrganization(params.get("organization"));
        r.setPages(params.get("pages"));
        r.setPublisher(params.get("publisher"));
        r.setSchool(params.get("school"));
        r.setSeries(params.get("series"));
        r.setTitle(params.get("title"));
        r.setType(params.get("type"));
        r.setVolume(params.get("volume"));
        String yearText = params.get("year");
        r.setYear(yearText == null ? null : Integer.parseInt(yearText));
    }

}
