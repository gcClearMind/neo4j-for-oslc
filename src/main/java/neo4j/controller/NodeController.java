package neo4j.controller;

import com.alibaba.fastjson2.JSON;
import neo4j.entity.Block;
import neo4j.entity.Node;
import neo4j.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/node")
public class NodeController {
    @Autowired
    private NodeService nodeService;
    @RequestMapping("/getAllNodes")
    public Object getAllNodes() {
        List<Node> nodes = nodeService.findAllNodes();
//        List<Node> nodes = nodeService.test();
        return JSON.toJSON(nodes);
    }
}
