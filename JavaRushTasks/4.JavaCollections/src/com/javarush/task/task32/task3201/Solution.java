package com.javarush.task.task32.task3201;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        if (args.length != 3) return;
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        if (number > raf.length()) {
            raf.seek(raf.length());
        }
        else {
            raf.seek(number);
        }
        raf.write(text.getBytes());
    }
}
