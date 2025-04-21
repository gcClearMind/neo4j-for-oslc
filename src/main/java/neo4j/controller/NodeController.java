package neo4j.controller;

import com.alibaba.fastjson2.JSON;
import neo4j.entity.Block;
import neo4j.entity.Node;
import neo4j.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import static neo4j.servlet.RoadServlet.findRoads;

@Controller
@RequestMapping("/node")
public class NodeController {
    @Autowired
    private NodeService nodeService;

    @ResponseBody
    @RequestMapping("/getAllNodes")
    public Object getAllNodes() {
        List<Node> nodes = nodeService.findAllNodes();
//        List<Node> nodes = nodeService.test();
        return JSON.toJSON(nodes);
    }
    @RequestMapping("/getPaths")
    public Object findPath(Model model) throws IOException {
        Map<String, Vector<String>> swrl_map = findRoads();
        System.out.println(swrl_map);
        model.addAttribute("swrl_map", swrl_map);
        return "test";
    }
//    @RequestMapping("/getNearbynodes/{name}")
//    public Object getNearbyNodes(@PathVariable(name = "name") String name) {
//        List<Node> nodes = nodeService.findNearbynodes(name);
//        return JSON.toJSON(nodes);
//    }
    @ResponseBody
    @RequestMapping("/getNodeById/{id}")
    public Object getNodeById(@PathVariable(name = "id") String id) {
        List<Node> nodes = nodeService.findNodeById(Long.parseLong(id));
        return JSON.toJSON(nodes);
    }
    @ResponseBody
    @RequestMapping("/{id}")
    public Object getNodeByIdPart2(@PathVariable(name = "id") String id) {
        List<Node> nodes = nodeService.findNodeById(Long.parseLong(id));
        return JSON.toJSON(nodes);
    }
    @ResponseBody
    @RequestMapping("/getNodeByName/{name}")
    public Object getNodeByName(@PathVariable(name = "name") String name) {
        List<Node> nodes = nodeService.findNodeByName(name);
        return JSON.toJSON(nodes);
    }
}
