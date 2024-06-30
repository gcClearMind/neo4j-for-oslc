package neo4j.service.Impl;

import neo4j.dao.BlockDao;
import neo4j.entity.Block;
import neo4j.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {
    @Autowired
    private BlockDao blockDao;

    @Override
    @Transactional(readOnly = true)
    public List<Block> findAllBlock(){
        return blockDao.findAllBlock();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Block> findBlockById(Long id){
        return blockDao.findBlockById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Block> findBlockByName(String name){
        return blockDao.findBlockByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Block>  findNearbyBlocks(String name){
        return blockDao.findNearbyBlocks(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Block> test_for_block(){
        return blockDao.test_for_block();
    }
}
