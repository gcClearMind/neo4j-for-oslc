package neo4j.controller;

import com.alibaba.fastjson.JSON;
import com.zjut.entity.Journal;
import com.zjut.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalController {
    @Autowired
    private JournalService journalService;

    @RequestMapping("/getJournal")
    @ResponseBody
    public JSON getJournal(String organizationName) {
        List<Journal> journals = journalService.findJournal(organizationName);
        JSON json = (JSON) JSON.toJSON(journals);
        return json;
    }
}
