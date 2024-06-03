package IDA.service;

import IDA.entity.SearchCount;
import IDA.entity.SearchCountByYear;

import java.util.List;

public interface HorizontalProjectService {
    List<SearchCount> findHorizontalProjectQuantity(String OrganizationName);
    List<SearchCountByYear> findHorizontalProjectQuantityByOrganizationNameAndEveryYear(String OrganizationName);
}
