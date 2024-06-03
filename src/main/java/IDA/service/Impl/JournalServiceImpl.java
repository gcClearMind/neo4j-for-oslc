package IDA.service.Impl;

import IDA.dao.JournalDao;
import IDA.entity.Journal;
import IDA.service.JournalService;
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
