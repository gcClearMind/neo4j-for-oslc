package IDA.service;

import IDA.entity.Article;
import IDA.entity.SearchCount;
import IDA.entity.SearchCountByYear;

import java.util.List;

public interface ArticleService {
    List<SearchCount> findArticleQuantity();
    List<SearchCountByYear> findArticleQuantityByOrganizationNameAndEveryYear(String OrganizationName);
    List<Article> findArticleByOrganization(String OrganizationName);
    List<SearchCountByYear> findArticleByOrganizationAndKeyEveryYear(String OrganizationName,String keyword);
    List<Article> findTopArticleByOrganization(String OrganizationName);
}
