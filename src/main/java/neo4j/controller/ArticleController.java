package neo4j.controller;

import com.alibaba.fastjson.JSON;
import com.zjut.entity.Article;
import com.zjut.entity.SearchCount;
import com.zjut.entity.SearchCountByYear;
import com.zjut.service.ArticleService;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/getAllArticle")
    @ResponseBody
    public JSON getAllArticle() {
        List<SearchCount> x = articleService.findArticleQuantity();
        JSON json = (JSON) JSON.toJSON(x);
//        System.out.println(json.toJSONString());
        return json;
    }

    @RequestMapping("/getTopArticle")
    @ResponseBody
    public JSON getTopArticle(String organizationName) {
        List<Article> x = articleService.findTopArticleByOrganization(organizationName);
        JSON json = (JSON) JSON.toJSON(x);
//        System.out.println(json.toJSONString());
        return json;
    }

    @RequestMapping("/getArticleEveryYear")
    @ResponseBody
    //获取该学科每一年的论文数
    public JSON getArticleByOrganizationNameEveryYear(String organizationName) {
        List<SearchCountByYear> x = articleService.findArticleQuantityByOrganizationNameAndEveryYear(organizationName);
        List<SearchCountByYear> res = new ArrayList<>();
        int index = 0;
        for(SearchCountByYear sc : x) {
            if(sc.getYear().contains(".")) {
                sc.setYear(sc.getYear().substring(0, 4));
            }
            if(index == 0) {
                res.add(sc);
                index++;
            }else {
                SearchCountByYear last = res.get(index - 1);
                if(last.getYear().compareTo(sc.getYear()) == 0) {
                    res.get(index - 1).setCount(last.getCount() + sc.getCount());
                }
                else {
                    res.add(sc);
                    index++;
                }
            }

        }
        JSON json = (JSON) JSON.toJSON(res);
        return json;
    }

    @RequestMapping("/getKeyWord")
    @ResponseBody
    //获取该学科的论文前20关键词
    public JSON getArticle(String organizationName) {
        List<Article> articles = articleService.findArticleByOrganization(organizationName);
        HashMap<String, Integer> keywords = new HashMap<String, Integer>();
        @ToString
        class p implements Comparable<p> {
            private String keyword;
            private Integer count;
            p(String keyword) {
                this.keyword = keyword;
                this.count = keywords.get(keyword);
            }
            @Override
            public int compareTo(p o) {
                if(this.count == o.getCount()) {
                    return this.keyword.compareTo(o.getKeyword());
                }
                else {
                    return this.count < o.getCount() ? 1 : -1;
                }

            }

            public String getKeyword() {
                return keyword;
            }
            public Integer getCount() {
                return count;
            }
        }
        List<p> keylist = new ArrayList<>();
        Set<String> keys = new HashSet<String>();
        for(Article article : articles) {

            String[] spt = new String[20];
            String kwd = article.getKeyWord();
            if(kwd.contains(" ；")) {
                spt = kwd.split(" ；");
            }
            else if(kwd.contains(",")) {
                spt = kwd.split(",");
            }
            else if(kwd.contains(", ")) {
                spt = kwd.split(", ");
            }
            else {
                spt = kwd.split(" ");
            }
//            System.out.println(article.getKeyWord());

            for(String keyword: spt) {
                keys.add(keyword);
//                System.out.print(keyword + " ");
                if(keywords.containsKey(keyword)) {
                    keywords.put(keyword, keywords.get(keyword) + 1);
                }
                else {
                    keywords.put(keyword, 1);
                }
            }
//            System.out.println();
        }
        for(String key : keys) {
            keylist.add(new p(key));
        }

        Collections.sort(keylist);
        List<p> res = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            res.add(keylist.get(i));
//            System.out.println(keylist.get(i));
        }
        JSON json = (JSON) JSON.toJSON(res);
        return json;
    }
    @RequestMapping("/getKeyWordTop")
    @ResponseBody
    //获取该学科的论文前5关键词的每年次数
    public JSON getArticleTop(String organizationName) {
        List<Article> articles = articleService.findArticleByOrganization(organizationName);
        HashMap<String, Integer> keywords = new HashMap<String, Integer>();
        @ToString
        class p implements Comparable<p> {
            private String keyword;
            private Integer count;
            p(String keyword) {
                this.keyword = keyword;
                this.count = keywords.get(keyword);
            }
            @Override
            public int compareTo(p o) {
                if(this.count == o.getCount()) {
                    return this.keyword.compareTo(o.getKeyword());
                }
                else {
                    return this.count < o.getCount() ? 1 : -1;
                }

            }

            public String getKeyword() {
                return keyword;
            }
            public Integer getCount() {
                return count;
            }
        }
        List<p> keylist = new ArrayList<>();
        Set<String> keys = new HashSet<String>();
        for(Article article : articles) {

            String[] spt = new String[20];
            String kwd = article.getKeyWord();
            if(kwd.contains(" ；")) {
                spt = kwd.split(" ；");
            }
            else if(kwd.contains(",")) {
                spt = kwd.split(",");
            }
            else if(kwd.contains(", ")) {
                spt = kwd.split(", ");
            }
            else {
                spt = kwd.split(" ");
            }
//            System.out.println(article.getKeyWord());

            for(String keyword: spt) {
                keys.add(keyword);
//                System.out.print(keyword + " ");
                if(keywords.containsKey(keyword)) {
                    keywords.put(keyword, keywords.get(keyword) + 1);
                }
                else {
                    keywords.put(keyword, 1);
                }
            }
//            System.out.println();
        }
        for(String key : keys) {
            keylist.add(new p(key));
        }
        Collections.sort(keylist);
        List<p> res = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            res.add(keylist.get(i));
        }
        @ToString
        class keyOfYear {
            public String year;
            public Integer count;
            public String keyword;
            keyOfYear(String keyword, String year, Integer count) {
                this.keyword = keyword;
                this.count = count;
                this.year = year;
            }
        }
        List ra = new ArrayList<>();
        for(p x: res) {
//            System.out.println(x.getKeyword());
            List<SearchCountByYear> k1 = articleService.findArticleByOrganizationAndKeyEveryYear(organizationName, x.getKeyword());
            List<SearchCountByYear> k2 = new ArrayList<>();
            int index = 0;

            for(SearchCountByYear sc : k1) {
                if(sc.getYear().contains(".")) {
                    sc.setYear(sc.getYear().substring(0, 4));
                }
                if(index == 0) {
                    k2.add(sc);
                    index++;
                }else {
                    SearchCountByYear last = k2.get(index - 1);
                    if(last.getYear().compareTo(sc.getYear()) == 0) {
                        k2.get(index - 1).setCount(last.getCount() + sc.getCount());
                    }
                    else {
                        k2.add(sc);
                        index++;
                    }
                }
            }
            for(SearchCountByYear sc : k2) {
                List sx = new ArrayList();
                sx.add(sc.getYear()); sx.add(sc.getCount()); sx.add(x.getKeyword());
                ra.add(sx);
            }
        }
//        @ToString
//        class keyOfYear {
//            public List<SearchCountByYear> sc;
//            public String keyword;
//            keyOfYear(String keyword) {
//                this.keyword = keyword;
//                sc = new ArrayList<>();
//            }
//        }
//        List<keyOfYear> ra = new ArrayList<>();
////        System.out.println("test");
////        System.out.println(res);
//        int firstYear = 9999;
//        int lastYear = 1949;
//        for(p x: res) {
//            keyOfYear a = new keyOfYear(x.getKeyword());
////            System.out.println(x.getKeyword());
//            List<SearchCountByYear> k1 = articleService.findArticleByOrganizationAndKeyEveryYear(organizationName, a.keyword);
//            List<SearchCountByYear> k2 = new ArrayList<>();
//            int index = 0;
//
//            for(SearchCountByYear sc : k1) {
//                if(sc.getYear().contains(".")) {
//                    sc.setYear(sc.getYear().substring(0, 4));
//                }
//                if(index == 0) {
//                    k2.add(sc);
//                    index++;
//                }else {
//                    SearchCountByYear last = k2.get(index - 1);
//                    if(last.getYear().compareTo(sc.getYear()) == 0) {
//                        k2.get(index - 1).setCount(last.getCount() + sc.getCount());
//                    }
//                    else {
//                        k2.add(sc);
//                        index++;
//                    }
//                }
//            }
//            firstYear = Math.min(firstYear, Integer.valueOf(k2.get(0).getYear()));
//            lastYear = Math.max(lastYear, Integer.valueOf(k2.get(k2.size() - 1).getYear()));
//            a.sc = k2;
//            ra.add(a);
//        }
////        System.out.println(ra);
//        List<Integer> years = new ArrayList<>();
//        int now = firstYear;
//        while(now <= lastYear) {
//            years.add(now);
//            if(now >= lastYear) {
//                break;
//            }
//            if(now % 10 != 0) {
//                now = (now / 10) * 10 + 10;
//            }
//            else {
//                now += 10;
//                if(now > lastYear) {
//                    now = lastYear;
//                }
//            }
//        }
////        System.out.println(years);
//        int size = years.size();
//        int pos = 0;
//        for(int i = 0 ; i < ra.size(); i++) {
//            keyOfYear kof = ra.get(i);
//            pos = 0;
//            List<SearchCountByYear> fis = new ArrayList<>();
//            SearchCountByYear tp = new SearchCountByYear();
//            tp.setYear(String.valueOf(years.get(pos)));
//            tp.setCount(0);
//            for(SearchCountByYear scy : kof.sc) {
//                Integer year = Integer.valueOf(scy.getYear());
//                if(pos == size - 1) {
//                    tp.setCount(tp.getCount() + scy.getCount());
//                    continue;
//                }
//                while(pos <= size - 2 && Math.abs(year - years.get(pos)) > Math.abs(year - years.get(pos + 1))) {
//                    pos += 1;
//                    SearchCountByYear item = new SearchCountByYear();
//                    item.setCount(tp.getCount());
//                    item.setYear(tp.getYear());
//                    fis.add(item);
//                    tp.setYear(String.valueOf(years.get(pos)));
//                    tp.setCount(0);
//                }
//                tp.setCount(tp.getCount() + scy.getCount());
//            }
//            while(pos <= size - 1) {
//                SearchCountByYear item = new SearchCountByYear();
//                item.setCount(tp.getCount());
//                item.setYear(tp.getYear());
//                fis.add(item);
//                if(pos == size - 1) {
//                    break;
//                }
//                pos++;
//                tp.setYear(String.valueOf(years.get(pos)));
//                tp.setCount(0);
//            }
//            ra.get(i).sc = fis;
//        }
        JSON json = (JSON) JSON.toJSON(ra);
//        System.out.println(ra);
        return json;
    }
 }
