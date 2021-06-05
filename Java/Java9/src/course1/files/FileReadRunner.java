package course1.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReadRunner {
    public static void main(String[] args) throws IOException {
        Path pathFileToRead = Paths.get("./resources/file-read.txt");

        //Good for small course1.files
        List<String> lines = Files.readAllLines(pathFileToRead);
        System.out.println(lines);

        //Multiple lines - Millions/Billions
        Files.lines(pathFileToRead)
                .map(String::toLowerCase)
                .filter(str -> str.contains("a"))
                .forEach(System.out::println);
    }
}
