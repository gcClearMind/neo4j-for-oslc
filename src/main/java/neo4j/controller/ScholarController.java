package neo4j.controller;

import com.alibaba.fastjson.JSON;
import neo4j.entity.Scholar;
import neo4j.entity.ScholarAndArticle;
import neo4j.service.ScholarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scholar")
public class ScholarController {
    @Autowired
    private ScholarService scholarService;

    @RequestMapping("/JournalAndArticleDataAll")
    @ResponseBody
    public JSON JournalAndArticleDataAll(String organizationName) {
        List<ScholarAndArticle> allData = scholarService.findScholarAndAllArticleByOrganizationName(organizationName);
        for(ScholarAndArticle sc : allData) {
            sc.setCountA(scholarService.findArticleOfAByScholarName(sc.getScholar().getName()));
        }
        JSON json = (JSON) JSON.toJSON(allData);
        return json;
    }

    @RequestMapping("/JournalAndArticleDataTypeA")
    @ResponseBody
    public JSON JournalAndArticleDataTypeA(String organizationName) {
        List<ScholarAndArticle> AData = scholarService.findScholarAndAllArticleByOrganizationName(organizationName);
        JSON json = (JSON) JSON.toJSON(AData);
        return json;
    }

    @RequestMapping("/getScholar")
    @ResponseBody
    public JSON getScholar(String organizationName) {
        List<Scholar> allData = scholarService.findScholarOrganizationName(organizationName);
        JSON json = (JSON) JSON.toJSON(allData);
        return json;
    }
}
