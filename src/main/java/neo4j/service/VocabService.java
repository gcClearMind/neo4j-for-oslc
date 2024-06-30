package neo4j.service;

import java.io.IOException;

public interface VocabService {
    String getVocab(String filePath) throws IOException;
}
