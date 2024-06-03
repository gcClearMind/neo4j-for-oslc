package IDA.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
@Data
@NoArgsConstructor
@ToString
public class SearchCountByYear implements Comparable<SearchCountByYear>{
    private String year;
    private Integer count;

    public String getYear() {
        return year;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public int compareTo(SearchCountByYear o) {
        return this.year.compareTo(o.getYear());
    }
}
