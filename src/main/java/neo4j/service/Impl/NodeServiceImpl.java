package neo4j.service.Impl;

import neo4j.dao.NodeDao;
import neo4j.entity.Node;
import neo4j.entity.NodeResult;
import neo4j.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.stereotype.Service;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.neo4j.driver.*;

import static neo4j.tool.ConventToNode.ConventToNode;

@Service
public class NodeServiceImpl implements NodeService {
    @Autowired
    private NodeDao nodeDao;
    @Autowired
    private Neo4jClient neo4jClient;

    public List<Node> findAllNodes() {

//        List<NodeResult> nodeResult = nodeDao.findAllNodes();
//        List<Node> nodes = new ArrayList<>();
//        for(NodeResult result : nodeResult) {
//            nodes.add(ConventToNode(result));
//        }
//        return nodes;
        List<org.neo4j.driver.types.Node> Nodes = nodeDao.findAllNodes();
        List<Node> nodes = new ArrayList<>();
        for(org.neo4j.driver.types.Node node: Nodes) {
            nodes.add(ConventToNode(node));
        }
        return nodes;
//        return nodeDao.findAllNodes();
    }
}
