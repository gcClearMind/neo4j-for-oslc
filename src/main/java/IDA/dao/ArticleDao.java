package IDA.dao;

import IDA.entity.Article;
import IDA.entity.SearchCount;
import IDA.entity.SearchCountByYear;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

;

@Repository
public interface ArticleDao extends Neo4jRepository<Article,Long> {



    //各个组织/学科 论文总数量
    @Query(value = "match (a:Organization)--(b:Scholar)-->(c:Article)" +
            " return a.name as OrganizationName,count(c) as count " +
            "order by count desc")
    List<SearchCount> findArticleByOrganization();

    //通过组织/学科以及年份 查找论文数量
    @Query(value = "match (a:Organization{name:{0}})--(b:Scholar)-->(c:Article) " +
            "where exists(c.year) return c.year as year, count(c) as count" +
            " order by year asc")
    List<SearchCountByYear> findArticleByOrganizationAndEveryYear(String OrganizationName);

    //通过组织/学科
    @Query(value = "match (a:Organization{name:{0}})--(b:Scholar)-->(c:Article) " +
            "where c.keyWord <> ''" +
            " return c order by c.year asc")
    List<Article> findArticleByOrganization(String OrganizationName);

    @Query(value = "match (a:Organization{name:{0}})--(b:Scholar)-->(c:Article) " +
            "where exists(c.year) and c.keyWord contains {1}" +
            "return c.year as year, count(c) as count, c.keyWord as keyword " +
            "order by year asc")
    List<SearchCountByYear> findArticleByOrganizationAndKeyEveryYear(String OrganizationName,String keyword);

    @Query(value = "match (a:Organization{name:{0}})--(b:Scholar)-->(c:Article)-->(j:Journal) where j:ZJUT_TOP100 " +
            "with c,j return c order by j.weight desc")
    List<Article> findTopArticleByOrganization(String OrganizationName);
}
