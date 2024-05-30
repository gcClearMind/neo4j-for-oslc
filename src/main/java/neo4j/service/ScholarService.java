package neo4j.service;

import neo4j.entity.Scholar;
import neo4j.entity.ScholarAndArticle;

import java.util.List;

public interface ScholarService {
    List<ScholarAndArticle>  findScholarAndAllArticleByOrganizationName(String OrganizationName);
    List<ScholarAndArticle>  findScholarAndArticleOfTypeAByOrganizationName(String OrganizationName);
    List<Scholar> findScholarOrganizationName(String OrganizationName);
    Integer findArticleOfAByScholarName(String ScholarName);
}
