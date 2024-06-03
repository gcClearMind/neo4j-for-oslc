package IDA.service;

import IDA.entity.Scholar;
import IDA.entity.ScholarAndArticle;

import java.util.List;

public interface ScholarService {
    List<ScholarAndArticle>  findScholarAndAllArticleByOrganizationName(String OrganizationName);
    List<ScholarAndArticle>  findScholarAndArticleOfTypeAByOrganizationName(String OrganizationName);
    List<Scholar> findScholarOrganizationName(String OrganizationName);
    Integer findArticleOfAByScholarName(String ScholarName);
}
