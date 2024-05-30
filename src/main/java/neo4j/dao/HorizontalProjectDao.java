package neo4j.dao;

import com.zjut.entity.HorizontalProject;
import com.zjut.entity.SearchCount;
import com.zjut.entity.SearchCountByYear;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorizontalProjectDao extends Neo4jRepository<HorizontalProject,Long> {

    @Query(value = "match (a:Organization{name:{0}})--(b:Scholar)-->(c:HorizontalProject) return a.name as OrganizationName,count(c) as count")
    List<SearchCount> findHorizontalProjectByOrganization(String OrganizationName);

    //通过组织/学科以及年份 查找横向项目项目
    @Query(value = "match (a:Organization{name:{0}})--(b:Scholar)-->(c:HorizontalProject) " +
            "where exists(c.approvalDate) return c.approvalDate as year, count(c) as count" +
            " order by year asc")
    List<SearchCountByYear> findHorizontalProjectByOrganizationAndEveryYear(String OrganizationName);


}
