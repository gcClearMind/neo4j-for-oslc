package neo4j.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
@Data
@NoArgsConstructor
@ToString
public class SearchCount implements Comparable<SearchCount>{
    private String OrganizationName;
//    private String year;
    private Integer count;

    public Integer getCount() {
        return this.count;
    }

    @Override
    public int compareTo(SearchCount o) {
        return this.count.compareTo(o.getCount());
    }
}
