package neo4j.dao;

import neo4j.entity.Scholar;
import neo4j.entity.ScholarAndArticle;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScholarDao extends Neo4jRepository<Scholar,Long> {


    @Query(value = "match (m:Organization{name:{0}})--(n:Scholar)-->(a:Article) " +
            "return n as scholar,count(a) as count, 0 as countA, sum(toInteger(a.citeCount)) as citeCount" +
            " order by count desc")
    List<ScholarAndArticle>  findScholarAndAllArticleByOrganizationName(String OrganizationName);

    @Query(value = "MATCH (n:Scholar)-->(m:Organization{name:{0}}) \n" +
            "match (n)-->(a:Article)-->(j:Journal) where j.type='A' return n as scholar,count(a) as count, 0 as countA, sum(toInteger(a.citeCount)) as citeCount\n" +
            "order by count desc")
    List<ScholarAndArticle>  findScholarAndArticleOfTypeAByOrganizationName(String OrganizationName);

    @Query(value = "match (m:Organization{name:{0}})--(n:Scholar)-->(a:Article) return n LIMIT 1")
    List<Scholar>  findScholarOrganizationName(String OrganizationName);

    @Query(value = "match (n:Scholar{name:{0}})-->(a:Article)-->(j:Journal) where j.type='A' return count(a)")
    Integer findArticleOfAByScholarName(String ScholarName);
}
