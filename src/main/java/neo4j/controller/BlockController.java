package neo4j.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import neo4j.entity.Block;
import neo4j.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/block")
public class BlockController {
    @Autowired
    private BlockService blockService;

    @RequestMapping("/getAllBlocks")
    public Object getAllBlocks() {

        List<Block> blocks = blockService.findAllBlock();
        return JSON.toJSON(blocks);
    }
    @RequestMapping("/getNearbyBlocks/{name}")
    public Object getNearbyBlocks(@PathVariable(name = "name") String name) {
        List<Block> blocks = blockService.findNearbyBlocks(name);
        return JSON.toJSON(blocks);
    }

    @RequestMapping("getBlockById/{id}")
    public Object getBlockById(@PathVariable(name = "id") String id) {
        List<Block> blocks = blockService.findBlockById(Long.parseLong(id));
        return JSON.toJSON(blocks);
    }

    @RequestMapping("/{id}")
    public Object getBlockByIdPart2(@PathVariable(name = "id") String id) {
        List<Block> blocks = blockService.findBlockById(Long.parseLong(id));
        return JSON.toJSON(blocks);
    }

    @RequestMapping("/getBlockByName/{name}")
    public Object getBlockByName(@PathVariable(name = "name") String name) {
        List<Block> blocks = blockService.findBlockByName(name);
        return JSON.toJSON(blocks);
    }

    @RequestMapping("/test")
    public Object test() {
        List<Block> blocks = blockService.test_for_block();
        return JSON.toJSON(blocks);
    }
}
