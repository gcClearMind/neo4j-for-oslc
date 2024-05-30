package neo4j.dao;

import com.zjut.entity.Journal;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalDao extends Neo4jRepository<Journal,Long> {


    @Query(value = "match (o:Organization{name:{0}})--(n:Scholar)-[r:Publish]->(m:Article)-[p:Published]->(j:Journal) " +
            "where j:ZJUT_TOP100 " +
            "return distinct(j) order by j.weight desc" )
    List<Journal> findJournalByOrganization(String OrganizationName);
}
