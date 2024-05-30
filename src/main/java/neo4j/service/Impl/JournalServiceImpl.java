package neo4j.service.Impl;

import neo4j.dao.JournalDao;
import neo4j.entity.Journal;
import neo4j.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JournalServiceImpl implements JournalService {
    @Autowired
    private JournalDao journalDao;

    @Override
    @Transactional(readOnly = true)
    public List<Journal> findJournal(String OrganizationName) {
        return journalDao.findJournalByOrganization(OrganizationName);
    }

}
