package neo4j.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
@Data
@NoArgsConstructor
@ToString
public class ScholarAndArticle {
    private Scholar scholar;
    private Integer count;
    private Integer countA;
    private Integer citeCount;
    public void setName(Scholar scholar) {
        this.scholar = scholar;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setCountA(Integer countA) {
        this.countA = countA;
    }

    public void setCiteCount(Integer citeCount) {
        this.citeCount = citeCount;
    }
}
