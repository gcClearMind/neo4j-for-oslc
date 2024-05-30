package neo4j.service;

import neo4j.entity.SearchCount;
import neo4j.entity.SearchCountByYear;

import java.util.List;

public interface HorizontalProjectService {
    List<SearchCount> findHorizontalProjectQuantity(String OrganizationName);
    List<SearchCountByYear> findHorizontalProjectQuantityByOrganizationNameAndEveryYear(String OrganizationName);
}
