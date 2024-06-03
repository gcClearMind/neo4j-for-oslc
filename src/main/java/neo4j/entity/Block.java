package neo4j.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.neo4j.annotation.QueryResult;
@QueryResult
@Data
@NoArgsConstructor
@ToString
public class Block {
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
