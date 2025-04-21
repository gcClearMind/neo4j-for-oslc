package neo4j.service;


import neo4j.entity.Block;
import neo4j.entity.Node;

import java.util.List;

public interface NodeService {
    List<Node> findAllNodes();
    List<Node> test();

    List<Node> findNodeById(long id);
    List<Node> findNodeByName(String name);
}
