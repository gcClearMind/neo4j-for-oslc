package neo4j.service;

import com.zjut.entity.Article;
import com.zjut.entity.SearchCount;
import com.zjut.entity.SearchCountByYear;

import java.util.List;

public interface ArticleService {
    List<SearchCount> findArticleQuantity();
    List<SearchCountByYear> findArticleQuantityByOrganizationNameAndEveryYear(String OrganizationName);
    List<Article> findArticleByOrganization(String OrganizationName);
    List<SearchCountByYear> findArticleByOrganizationAndKeyEveryYear(String OrganizationName,String keyword);
    List<Article> findTopArticleByOrganization(String OrganizationName);
}
