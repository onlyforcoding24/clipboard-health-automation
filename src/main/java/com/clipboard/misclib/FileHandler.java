package com.clipboard.misclib;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author jitendra.pisal
 */
public class FileHandler {

    public FileHandler() {
    }

    public List<String> toReadAnyFile(String filePathWithFileName) {
        List<String> fileData = null;

        try {
            fileData = Files.readAllLines(Paths.get(filePathWithFileName));
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        return fileData;
    }
}
