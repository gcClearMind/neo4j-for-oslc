package IDA.service;

import IDA.entity.SearchCount;
import IDA.entity.SearchCountByYear;

import java.util.List;

public interface VerticalProjectService {
    List<SearchCount> findVerticalProjectQuantity(String OrganizationName);
    List<SearchCountByYear> findVerticalProjectQuantityByOrganizationNameAndEveryYear(String OrganizationName);
}
