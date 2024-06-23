package neo4j.dao;

import neo4j.entity.Block;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockDao extends Neo4jRepository<Block,Long> {

    @Query(value = "match(n:`Blocks:Block`)" +
            " return n" +
            " order by n.name asc")
    List<Block> findAllBlock();

    @Query(value = "match(n:`Blocks:Block`{name:{0})-[:ownedAttribute]->()-[:type]->(m:`Blocks:Block`)" +
            " return m" +
            "order by m.name asc")
    List<Block>  findNearbyBlocks(String name);


    @Query(value = "match(n:`Blocks:Block`) return n.name as name, n.`xmi:type` as type  order by name asc")
    List<Block> test_for_block();
}
