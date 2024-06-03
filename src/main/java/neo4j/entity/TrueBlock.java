package neo4j.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NoArgsConstructor
@NodeEntity
@ToString
@JsonIgnoreProperties(value = {"xmi:id","xmi:type"})
public class TrueBlock {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String visibility;
    private String citeCount;

}
