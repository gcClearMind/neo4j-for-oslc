package neo4j.controller;

import com.alibaba.fastjson.JSON;
import neo4j.entity.Block;
import neo4j.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/block")
public class BlockController {
    @Autowired
    private BlockService blockService;

    @RequestMapping("/getAllBlocks")
    @ResponseBody
    public JSON getAllBlocks() {
        List<Block> blocks = blockService.findAllBlock();
        return (JSON) JSON.toJSON(blocks);
    }
    @RequestMapping("/getNearbyBlocks")
    @ResponseBody
    public JSON getNearbyBlocks(String name) {
        List<Block> blocks = blockService.findNearbyBlocks(name);
        return (JSON) JSON.toJSON(blocks);
    }
}
