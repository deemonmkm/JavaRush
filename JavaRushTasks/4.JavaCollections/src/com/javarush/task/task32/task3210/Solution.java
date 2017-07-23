package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        //if (args.length != 3) return;

        //String fileName = args[0];
        //int number = Integer.parseInt(args[1]);
        //String text = args[2];

        try {
            RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
            raf.seek(Integer.parseInt(args[1]));

            byte[] buffer = new byte[args[2].length()];
            raf.read(buffer, 0, args[2].length());
            raf.seek(raf.length());
            String text2 = new String(buffer);

            if (args[2].equals(text2)) {
                raf.write("true".getBytes());
            } else {
                raf.write("false".getBytes());
            }
        } catch (Exception e) {

        }
    }
}
