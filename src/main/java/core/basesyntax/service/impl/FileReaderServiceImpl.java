package core.basesyntax.service.impl;

import core.basesyntax.exception.InvalidPathException;
import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public String readFromFile(String path) {
        if (path == null) {
            throw new InvalidPathException("Path can't be null");
        }
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            throw new InvalidPathException("Can't read file " + path, e);
        }
    }
}