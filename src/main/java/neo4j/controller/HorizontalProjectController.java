package neo4j.controller;

import com.alibaba.fastjson.JSON;
import com.zjut.entity.SearchCount;
import com.zjut.entity.SearchCountByYear;
import com.zjut.service.HorizontalProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class HorizontalProjectController {
    @Autowired
    private HorizontalProjectService horizontalProjectService;

    @RequestMapping("/getHorizontalProject")
    @ResponseBody
    public void getHorizontalProjectByOrganization() {
        List<SearchCount> x = horizontalProjectService.findHorizontalProjectQuantity("计算机科学与技术学院");
        if(!x.equals(null))
            System.out.println(x);
        else
            System.out.println("error");
    }


    @RequestMapping("/getHorizontalProjectEveryYear")
    @ResponseBody
    public JSON getHorizontalProjectByOrganizationNameEveryYear(String organizationName) {
        List<SearchCountByYear> x = horizontalProjectService.findHorizontalProjectQuantityByOrganizationNameAndEveryYear(organizationName);
        for(SearchCountByYear o: x) {
            o.setYear(o.getYear().substring(0,4));
        }
        Collections.sort(x);
        List<SearchCountByYear> result = new ArrayList<>();
        String now = null;
        int pos = -1;
        for(int i = 0; i < x.size(); i++) {
            if(x.get(i).getYear().length() < 4) {
                continue;
            }
            if(pos == -1) {
                result.add(x.get(i));
                pos = 0;
                now = x.get(i).getYear();
                continue;
            }
            if(x.get(i).getYear().equals(now)) {
                result.get(pos).setCount(result.get(pos).getCount() + x.get(i).getCount());
            }
            else {
                result.add(x.get(i));
                pos++;
                now = x.get(i).getYear();
            }
        }
        JSON json = (JSON) JSON.toJSON(result);
        return json;
    }
}
