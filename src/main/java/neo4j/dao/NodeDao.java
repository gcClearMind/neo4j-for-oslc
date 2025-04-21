package neo4j.dao;

import neo4j.entity.Block;
import neo4j.entity.Node;
import neo4j.entity.NodeResult;
import neo4j.entity.NodeResult2;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NodeDao extends Neo4jRepository<Block,Long> {
//    @Query(value = "MATCH (n) where id(n) = 0 " +
//            "WITH n, keys(n) AS keys, [k IN keys(n) | [k, n[k]]] AS properties " +
//            "RETURN id(n) AS id, labels(n) AS labels, keys, properties")

//    @Query(value = "MATCH (n) where id(n) = 0 " +
//            "RETURN id(n) AS id, labels(n) AS labels, keys(n) as keys,properties(n) as  properties")
//    @Query("MATCH (n) " +
//            "    WITH n, keys(n) AS keys " +
//            "       RETURN id(n) AS id, labels(n) AS labels, keys, " +
//            "       [key IN keys | [key,n[key]]] AS properties")
//    @Query("MATCH (n) " +
//            "WITH n, keys(n) AS keys " +
//            "RETURN id(n) AS id, labels(n) AS labels, keys, " +
//            "[key IN keys | key + ' &&& ' + n[key]] AS properties")
    @Query("match(n) " +
            "WITH n, keys(n) AS keys, elementId(n) as elementId,split(elementId(n),':') as parts " +
            "return  toInteger(parts[size(parts) - 1]) as identity, labels(n) as labels, [key IN keys | key + ' &&& ' + n[key]] AS properties,elementId")
    List<NodeResult> findAllNodes();

    @Query("MATCH (n) " +
            "WITH n, keys(n) AS keys " +
            "RETURN id(n) AS id, labels(n) AS labels, keys, " +
            "properties(n) AS properties")
    List<Node> test();

    @Query(value = "match(n)" +
            " WITH n, keys(n) AS keys, elementId(n) as elementId,split(elementId(n),':') as parts" +
            " where toInteger(parts[size(parts) - 1]) = $id " +
            " return toInteger(parts[size(parts) - 1]) as identity, labels(n) as labels, [key IN keys | key + ' &&& ' + n[key]] AS properties,elementId")
    List<NodeResult> findNodeById(@Param(value = "id") Long id);
    @Query(value = "match(n{name:$name})" +
            " WITH n, keys(n) AS keys, elementId(n) as elementId,split(elementId(n),':') as parts" +
            " return toInteger(parts[size(parts) - 1]) as identity, labels(n) as labels, [key IN keys | key + ' &&& ' + n[key]] AS properties,elementId" +
            " order by n.name")
    List<NodeResult> findNodeByName(@Param(value = "name") String name);
}
