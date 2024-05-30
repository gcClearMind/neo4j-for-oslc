package neo4j.service.Impl;

import com.zjut.dao.ArticleDao;
import com.zjut.entity.Article;
import com.zjut.entity.SearchCount;
import com.zjut.entity.SearchCountByYear;
import com.zjut.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;


    @Override
    @Transactional(readOnly = true)
    public List<SearchCount> findArticleQuantity() {
        return articleDao.findArticleByOrganization();
    }

    @Override
    @Transactional(readOnly = true)
    public List<SearchCountByYear> findArticleQuantityByOrganizationNameAndEveryYear(String OrganizationName) {
        return articleDao.findArticleByOrganizationAndEveryYear(OrganizationName);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Article> findArticleByOrganization(String OrganizationName) {
        return  articleDao.findArticleByOrganization(OrganizationName);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SearchCountByYear> findArticleByOrganizationAndKeyEveryYear(String OrganizationName,String keyword) {
        return articleDao.findArticleByOrganizationAndKeyEveryYear(OrganizationName, keyword);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Article> findTopArticleByOrganization(String OrganizationName) {
        return articleDao.findTopArticleByOrganization(OrganizationName);
    }

}
