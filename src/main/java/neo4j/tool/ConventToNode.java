package neo4j.tool;

import neo4j.entity.Node;
import neo4j.entity.NodeResult;

import java.util.Collections;
import java.util.List;

public class ConventToNode {
    public static Node ConventToNode(NodeResult nodeResult) {
        Node node = new Node();
        node.setId(nodeResult.getId());
        node.setLabels(nodeResult.getLabels());
        node.setKeys(nodeResult.getKeys());
        node.setProperties(nodeResult.getProperties());
        return node;
    }

    public static Node ConventToNode( org.neo4j.driver.types.Node nodeResult) {
        Node node = new Node();
        node.setId(nodeResult.id());

        node.setLabels((List<String>) nodeResult.labels());
        node.setKeys((List<String>) nodeResult.keys());
        node.setProperties(nodeResult.asMap());
        return node;
    }


}
