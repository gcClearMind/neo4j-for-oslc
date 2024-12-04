package neo4j.service.Impl;

import neo4j.dao.NodeDao;
import neo4j.entity.Node;
import neo4j.entity.NodeResult;
import neo4j.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.neo4j.driver.*;

import static neo4j.tool.ConventToNode.ConventToNode;

@Service
public class NodeServiceImpl implements NodeService {
    @Autowired
    private NodeDao nodeDao;


    public List<Node> findAllNodes() {

        List<NodeResult> Nodes = nodeDao.findAllNodes();
        List<Node> nodes = new ArrayList<>();
        for(NodeResult node: Nodes) {
            nodes.add(ConventToNode(node));
        }
        return nodes;

    }
    public List<Node> test() {
        return nodeDao.test();
    }
}
