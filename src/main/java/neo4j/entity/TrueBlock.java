package neo4j.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Node("Blocks:Block")
@ToString
@JsonIgnoreProperties(value = {"xmi:id","xmi:type"})

public class TrueBlock {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String visibility;
    public TrueBlock(String name, String visibility) {
        this.name = name;
        this.visibility = visibility;
    }

}
