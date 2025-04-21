package neo4j.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NodeResult {

    @Property(name = "identity")
    private Long identity;

    @Property(name = "labels")
    private List<String> labels;

//    @Property(name = "keys")
//    private List<String> keys;

    @Property(name = "properties")
    private List<String> properties;

    @Property(name = "elementId")
    private String elementId;
}
