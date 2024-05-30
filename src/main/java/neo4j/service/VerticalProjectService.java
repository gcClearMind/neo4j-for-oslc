package neo4j.service;

import com.zjut.entity.SearchCount;
import com.zjut.entity.SearchCountByYear;

import java.util.List;

public interface VerticalProjectService {
    List<SearchCount> findVerticalProjectQuantity(String OrganizationName);
    List<SearchCountByYear> findVerticalProjectQuantityByOrganizationNameAndEveryYear(String OrganizationName);
}
