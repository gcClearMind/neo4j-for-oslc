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

    private Long id;

    private List<String> labels;

    private List<String> keys;

    private List<List<String>> properties;
}
