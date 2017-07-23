package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize = -1;
    private int maxSize = -1;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String fileName = file.getFileName().toString();
        boolean isTrue = true;
        // файл не соответствует имени
        if (partOfName != null &&
                !(fileName.contains(partOfName))) {
            isTrue = false;
            // файл не соответствует минимальному размеру
        }
        if (minSize > -1 &&
                Files.size(file) < minSize) {
            isTrue = false;
            // файл не соответствует максимальному размеру
        }
        if (maxSize > -1 &&
                Files.size(file) > maxSize) {
            isTrue = false;
            // проверка содержимого
        }
        if (partOfContent != null) {
            String contentOfFile = new String(Files.readAllBytes(file));
            if (!(contentOfFile.contains(partOfContent))) {
                isTrue = false;
            }
        }
        if (isTrue) {
            foundFiles.add(file);
        }
        return FileVisitResult.CONTINUE;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
