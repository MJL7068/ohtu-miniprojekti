/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproju.controllers;

import miniproju.models.Ref;
import miniproju.services.RefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ilkka
 */
@Controller
public class RefController {
    
    @Autowired
    private RefService refService;
    
        
    /*  RequestMapping
        - map all HTTP verbs to /greeting to this method
        - narrow down ala @RequestMapping(method=GET)                 
    
        Requestparam
        - bind query parameter 'name' to method parameter 'name'
    
        PathVariable
        - bind pathvariable to method parameter 'id'
    */
    @RequestMapping("refs/view/{id}")
    public String view(@PathVariable("id") int id, Model model) {
        Ref ref = refService.findWithId(id);
        model.addAttribute("ref", ref);
        
        return "refs/view";
    }
}
