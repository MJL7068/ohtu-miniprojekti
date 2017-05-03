package miniproju.controllers;

import java.util.Map;
import miniproju.services.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BibtexController {

    @Autowired
    private ReferenceService refService;

    @RequestMapping(value = "/references/download", method = GET)
    public String download_view() {

        return "references/download";
    }

    @RequestMapping(value = "/references/download", method = POST)
    public HttpEntity<byte[]> getBibtexFile(@RequestParam Map<String, String> params) {
        String filename = "newfile.bib";
        if (params.get("filename") != "") {
            filename = params.get("filename") + ".bib";
        }

        byte[] bibtexData = refService.findAllInBibtex().getBytes();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        headers.setContentLength(bibtexData.length);
        headers.add("Content-Disposition", "attachment; filename=" + filename);

        return new HttpEntity<byte[]>(bibtexData, headers);
    }
}
