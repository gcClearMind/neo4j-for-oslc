package neo4j.tool;

import neo4j.entity.Node;
import neo4j.entity.NodeResult;
import neo4j.entity.NodeResult2;

import java.util.*;

public class ConventToNode {
    public static Node ConventToNode(NodeResult nodeResult) {
        Node node = new Node();
        System.out.println(nodeResult.getId());
        node.setId(nodeResult.getId());
        node.setLabels(nodeResult.getLabels());
        node.setKeys(nodeResult.getKeys());
        Map<String, Object> properties = new HashMap<>();
        for(String infos : nodeResult.getProperties()) {

            String[]info = infos.split(" &&& ");
            if(info.length == 2) {
                properties.put(info[0], info[1]);
            }
            else {
                System.out.println("123" + infos);
                properties.put(info[0],"");
            }
        }
        node.setProperties(properties);
//        node.setProperties();
        return node;
    }

    public static Node ConventToNode(NodeResult2 nodeResult2) {
        Node node = new Node();
        System.out.println(nodeResult2.getId());
        node.setId(nodeResult2.getId());
        node.setLabels(nodeResult2.getLabels());
        node.setKeys(nodeResult2.getKeys());
        Map<String, Object> properties = new HashMap<>();
        System.out.println(nodeResult2.getProperties());
        for(List<Object> list : nodeResult2.getProperties()) {
            String key = list.get(0).toString();
            properties.put(key, list.get(1));
        }
        node.setProperties(properties);
//        node.setProperties();
        return node;
    }

    public static Node ConventToNode( org.neo4j.driver.types.Node nodeResult) {
        Node node = new Node();
//        node.setId(nodeResult.id());

        node.setLabels((List<String>) nodeResult.labels());
        node.setKeys((List<String>) nodeResult.keys());
        node.setProperties(nodeResult.asMap());
        return node;
    }


}
