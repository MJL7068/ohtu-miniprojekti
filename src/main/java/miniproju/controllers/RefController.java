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
import org.springframework.web.bind.annotation.RequestMethod;
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
    @RequestMapping("references/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        Reference ref = referenceService.findWithId(id);
        model.addAttribute("ref", ref);
        
        return "references/view";
    }

    @RequestMapping(value = "/references/book_new", method = GET)
    public String newBook() {

        return "references/book_new";
    }

    @RequestMapping(value = "/references/book_new", method = RequestMethod.POST)
    public String saveBookRef(@RequestParam Map<String, String> params) {

        Reference newRef = new Reference(params.get("title"));
//        newRef.setTitle(params.get("title"));
//        newRef.setTitle("test");
        referenceService.create(newRef);

        return "redirect:/";
    }

}
