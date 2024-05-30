package neo4j.dao;

import com.zjut.entity.SearchCount;
import com.zjut.entity.SearchCountByYear;
import com.zjut.entity.VerticalProject;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerticalProjectDao extends Neo4jRepository<VerticalProject,Long> {

    @Query(value = "match (a:Organization{name:{0}})--(b:Scholar)-->(c:VerticalProject) return a.name as OrganizationName,count(c) as count")
    List<SearchCount> findVerticalProjectByOrganization(String OrganizationName);

    //通过组织/学科以及年份 查找横向项目项目
    @Query(value = "match (a:Organization{name:{0}})--(b:Scholar)-->(c:VerticalProject) " +
            "where exists(c.approvalDate) return c.approvalDate as year, count(c) as count" +
            " order by year asc")
    List<SearchCountByYear> findVerticalProjectByOrganizationAndEveryYear(String OrganizationName);

}
