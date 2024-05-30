package neo4j.service.Impl;

import neo4j.dao.VerticalProjectDao;
import neo4j.entity.SearchCount;
import neo4j.entity.SearchCountByYear;
import neo4j.service.VerticalProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VerticalProjectServiceImpl implements VerticalProjectService {
    @Autowired
    private VerticalProjectDao verticalProjectDao;


    @Override
    @Transactional(readOnly = true)
    public List<SearchCount> findVerticalProjectQuantity(String OrganizationName) {
        return verticalProjectDao.findVerticalProjectByOrganization(OrganizationName);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SearchCountByYear> findVerticalProjectQuantityByOrganizationNameAndEveryYear(String OrganizationName) {
        return verticalProjectDao.findVerticalProjectByOrganizationAndEveryYear(OrganizationName);
    }
}
