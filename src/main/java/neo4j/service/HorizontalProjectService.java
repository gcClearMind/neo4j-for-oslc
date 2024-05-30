package neo4j.service;

import com.zjut.entity.SearchCount;
import com.zjut.entity.SearchCountByYear;

import java.util.List;

public interface HorizontalProjectService {
    List<SearchCount> findHorizontalProjectQuantity(String OrganizationName);
    List<SearchCountByYear> findHorizontalProjectQuantityByOrganizationNameAndEveryYear(String OrganizationName);
}
