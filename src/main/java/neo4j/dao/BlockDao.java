package neo4j.dao;

import neo4j.entity.Block;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockDao extends Neo4jRepository<Block,Long> {

    @Query(value = "match(n:`Blocks:Block`)" +
            " return n" +
            " order by n.name asc")
    List<Block> findAllBlock();

    @Query(value = "match(n:`Blocks:Block`)" +
            " where id(n) = $id" +
            " return n")
    List<Block> findBlockById(@Param(value = "id") Long id);
    @Query(value = "match(n:`Blocks:Block`{name:$name})" +
            " return n" +
            " order by n.name")
    List<Block> findBlockByName(@Param(value = "name") String name);

    @Query(value = "match(n:`Blocks:Block`{name:$name})-[*2]-(m:`Blocks:Block`)" +
            " return m" +
            " order by m.name asc")
    List<Block>  findNearbyBlocks(@Param(value = "name") String name);


    @Query(value = "match(n:`Blocks:Block`)" +
            " return n.name as name, n.`xmi:type` as type" +
            " order by name asc")
    List<Block> test_for_block();


}
