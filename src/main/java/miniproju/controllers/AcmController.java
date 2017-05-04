package miniproju.controllers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import miniproju.utilities.BibtexGenerator;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class AcmController {

    private String BASE_URL = "http://dl.acm.org/exportformats.cfm?expformat=bibtex&id=";

    @ResponseBody
    @RequestMapping(value = "/acm/**", method = GET, produces = "text/plain")
    public String bibtexFromAcm(HttpServletResponse res, @RequestParam("id") String rawId) {
        String id = parseId(rawId);
        try {
            String bibtex = fetchContent(id);
            if (!bibtex.isEmpty()) {
                return BibtexGenerator.fromBibtex(bibtex);
            }
            res.setStatus(404);
        } catch (Exception e) {
            res.setStatus(400);
        }
        return "";
    }

    private String fetchContent(String id) throws Exception {
        Document doc = Jsoup.connect(BASE_URL + id).get();
        return doc.select("#" + id).text();
    }

    private String parseId(String url) {
        String[] ids = url.split("\\.");
        return ids[ids.length - 1];
    }

}
