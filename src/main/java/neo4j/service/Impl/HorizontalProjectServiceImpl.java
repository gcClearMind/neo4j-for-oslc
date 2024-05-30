package neo4j.service.Impl;

import com.zjut.dao.HorizontalProjectDao;
import com.zjut.entity.SearchCount;
import com.zjut.entity.SearchCountByYear;
import com.zjut.service.HorizontalProjectService;
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
