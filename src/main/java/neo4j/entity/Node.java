package neo4j.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.driver.Value;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor

@ToString
public class Node{
    @Property(name = "id")
    private Long id;
    @Property(name = "labels")
    private List<String> labels;
    @Property(name = "keys")
    private List<String> keys;
    @Property(name = "properties")
    private Map<String, Object> properties;

}