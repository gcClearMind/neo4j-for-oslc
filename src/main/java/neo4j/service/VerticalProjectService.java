package neo4j.service;

import neo4j.entity.SearchCount;
import neo4j.entity.SearchCountByYear;

import java.util.List;

public interface VerticalProjectService {
    List<SearchCount> findVerticalProjectQuantity(String OrganizationName);
    List<SearchCountByYear> findVerticalProjectQuantityByOrganizationNameAndEveryYear(String OrganizationName);
}
