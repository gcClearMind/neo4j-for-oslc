package neo4j.controller;

import neo4j.service.BlockService;
import neo4j.service.VocabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class vocabController {

    @Autowired
    private VocabService vocabService;
    @RequestMapping(value = "/neo4j-vocab", produces = "text/turtle")
    String getVocab(HttpServletResponse response) {
        try{
            String rdfContent = vocabService.getVocab("vocabulary.rdf");
            return rdfContent;
        }catch (IOException e) {
            // 处理异常情况
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Error reading RDF file";
        }
    }
}
