package neo4j.service;

import neo4j.entity.Journal;

import java.util.List;

public interface JournalService {
    List<Journal> findJournal(String OrganizationName);
}
