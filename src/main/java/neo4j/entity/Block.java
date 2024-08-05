package neo4j.entity;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Node("Blocks:Block")
@ToString
public class Block {
    @Id
    @GeneratedValue
    private Long id;
    @Property(name = "elementId")
    private String elementId;
    @Property(name = "name")
    private String name;
    @Property(name = "xmi:type")
    private String XmiType;
    @Property(name = "xmi:id")
    private String XmiId;
    @Property(name = "visibility")
    private String visibility;
}
