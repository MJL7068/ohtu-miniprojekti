/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproju.controllers;

import java.util.List;
import miniproju.models.Ref;
import miniproju.services.RefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ilkka
 */
@Controller
public class IndexContoller {
    
    @Autowired
    private RefService refService;
    
    @RequestMapping("/")
    public String index(Model model) {
        List<Ref> allRefs = refService.findAll();
        model.addAttribute("allRefs", allRefs);
        
        return "index";
    }
}
