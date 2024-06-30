package neo4j.service;

import neo4j.entity.Block;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BlockService {
    List<Block> findAllBlock();

    List<Block> findBlockById(Long id);

    List<Block> findBlockByName(String name);

    List<Block>  findNearbyBlocks(String name);

    List<Block> test_for_block();
}
