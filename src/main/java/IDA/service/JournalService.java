package IDA.service;

import IDA.entity.Journal;

import java.util.List;

public interface JournalService {
    List<Journal> findJournal(String OrganizationName);
}
