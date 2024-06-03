package neo4j.dao;

import neo4j.entity.Block;
import neo4j.entity.TrueBlock;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockDao extends Neo4jRepository<Block,Long> {

    @Query(value = "match(n:`Blocks:Block`) return n.name as name" +
            " order by name asc")
    List<Block> findAllBlock();

    @Query(value = "match(n:`Blocks:Block`{name:{0}})-[:ownedAttribute]->()-[:type]->(m:`Blocks:Block`)" +
            "  return m.name as name " +
            "order by name asc")
    List<Block>  findNearbyBlocks(String name);

}
