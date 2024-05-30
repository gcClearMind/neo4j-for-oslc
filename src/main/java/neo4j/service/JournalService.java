package neo4j.service;

import com.zjut.entity.Journal;

import java.util.List;

public interface JournalService {
    List<Journal> findJournal(String OrganizationName);
}
