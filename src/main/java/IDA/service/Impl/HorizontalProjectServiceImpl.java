package IDA.service.Impl;

import IDA.dao.HorizontalProjectDao;
import IDA.entity.SearchCount;
import IDA.entity.SearchCountByYear;
import IDA.service.HorizontalProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HorizontalProjectServiceImpl implements HorizontalProjectService {
    @Autowired
    private HorizontalProjectDao horizontalProjectDao;


    @Override
    @Transactional(readOnly = true)
    public List<SearchCount> findHorizontalProjectQuantity(String OrganizationName) {
        return horizontalProjectDao.findHorizontalProjectByOrganization(OrganizationName);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SearchCountByYear> findHorizontalProjectQuantityByOrganizationNameAndEveryYear(String OrganizationName) {
        return horizontalProjectDao.findHorizontalProjectByOrganizationAndEveryYear(OrganizationName);
    }
}
