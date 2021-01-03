package edu.prahlad.java.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileWriteRunner {
    public static void main(String[] args) throws IOException {
        Path pathFileToWrite = Paths.get("./src/main/resources/file-write.txt");

        List<String> list = List.of("Apple", "Boy", "Car");
        Files.write(pathFileToWrite, list);

    }
}
