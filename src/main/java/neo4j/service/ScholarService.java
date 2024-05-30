package neo4j.service;

import com.zjut.entity.Scholar;
import com.zjut.entity.ScholarAndArticle;

import java.util.List;

public interface ScholarService {
    List<ScholarAndArticle>  findScholarAndAllArticleByOrganizationName(String OrganizationName);
    List<ScholarAndArticle>  findScholarAndArticleOfTypeAByOrganizationName(String OrganizationName);
    List<Scholar> findScholarOrganizationName(String OrganizationName);
    Integer findArticleOfAByScholarName(String ScholarName);
}
