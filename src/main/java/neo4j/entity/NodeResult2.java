package neo4j.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.Property;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NodeResult2 {

    @Property(name = "id")
    private Long id;

    @Property(name = "labels")
    private List<String> labels;

    @Property(name = "keys")
    private List<String> keys;

    @Property(name = "properties")
    private List<List<Object>> properties;
}
