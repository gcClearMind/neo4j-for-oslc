package neo4j.service;

import neo4j.entity.Article;
import neo4j.entity.SearchCount;
import neo4j.entity.SearchCountByYear;

import java.util.List;

public interface ArticleService {
    List<SearchCount> findArticleQuantity();
    List<SearchCountByYear> findArticleQuantityByOrganizationNameAndEveryYear(String OrganizationName);
    List<Article> findArticleByOrganization(String OrganizationName);
    List<SearchCountByYear> findArticleByOrganizationAndKeyEveryYear(String OrganizationName,String keyword);
    List<Article> findTopArticleByOrganization(String OrganizationName);
}
