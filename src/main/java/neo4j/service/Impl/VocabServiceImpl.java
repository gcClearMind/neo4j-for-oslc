package neo4j.service.Impl;

import neo4j.service.VocabService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class VocabServiceImpl implements VocabService {
    /**
     * @param filePath
     * @return
     * @throws IOException
     */
    @Override
    public String getVocab(String filePath) throws IOException {
        return Files.readString(Path.of(filePath), StandardCharsets.UTF_8);
    }

}
