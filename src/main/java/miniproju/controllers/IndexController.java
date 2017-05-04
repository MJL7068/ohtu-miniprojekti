package miniproju.controllers;

import miniproju.models.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import miniproju.services.ReferenceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class IndexController {

    @Autowired
    private ReferenceService referenceService;

    @RequestMapping(value = "/", method = GET)
    public String listRef(@PageableDefault(size = 15,
            direction = Sort.Direction.ASC,
            sort = "entryKey") Pageable pageable, Model model) {

        Page<Reference> refs = referenceService.findWithPage(pageable);
        model.addAttribute("allRefs", refs);
        model.addAttribute("current", refs.getNumber());
        model.addAttribute("end", refs.getTotalPages());
        model.addAttribute("onlyOne", (refs.getTotalPages() <= 1));

        return "index";
    }

}
