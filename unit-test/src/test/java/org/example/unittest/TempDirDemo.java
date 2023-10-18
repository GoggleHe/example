package org.example.unittest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.CleanupMode;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TempDirDemo {

    @TempDir
    File file;

    @Test
    void testTempDirAnnotation(@TempDir(cleanup = CleanupMode.ALWAYS) Path tempDir)
            throws IOException {
        Path numbers = tempDir.resolve("numbers.txt");

        List<String> lines = Arrays.asList("1", "2", "3");
        Files.write(numbers, lines);
        assertAll(
                () -> assertTrue(Files.exists(numbers), "File should exist"),
                () -> assertLinesMatch(lines, Files.readAllLines(numbers)));

        File file = new File("haha.txt");
        file.createNewFile();
        assertTrue(file.exists());
    }
}
