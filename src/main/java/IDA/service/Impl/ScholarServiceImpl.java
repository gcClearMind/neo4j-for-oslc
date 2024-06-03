package IDA.service.Impl;

import IDA.dao.ScholarDao;
import IDA.entity.Scholar;
import IDA.entity.ScholarAndArticle;
import IDA.service.ScholarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScholarServiceImpl implements ScholarService {
    @Autowired
    private ScholarDao scholarDao;

    @Override
    @Transactional(readOnly = true)
    public List<ScholarAndArticle> findScholarAndAllArticleByOrganizationName(String OrganizationName) {
        return scholarDao.findScholarAndAllArticleByOrganizationName(OrganizationName);
    }
    @Override
    @Transactional(readOnly = true)
    public List<ScholarAndArticle>  findScholarAndArticleOfTypeAByOrganizationName(String OrganizationName) {
        return scholarDao.findScholarAndArticleOfTypeAByOrganizationName(OrganizationName);
    }

    @Override
    @Transactional(readOnly = false)
    public List<Scholar> findScholarOrganizationName(String OrganizationName) {
        return scholarDao.findScholarOrganizationName(OrganizationName);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer findArticleOfAByScholarName(String ScholarName) {
        return scholarDao.findArticleOfAByScholarName(ScholarName);
    }
}
