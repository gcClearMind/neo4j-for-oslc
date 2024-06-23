package neo4j.service;

import neo4j.entity.Block;

import java.util.List;

public interface BlockService {
    List<Block> findAllBlock();

    List<Block>  findNearbyBlocks(String name);

    List<Block> test_for_block();
}
