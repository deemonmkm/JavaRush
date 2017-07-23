package com.javarush.task.task36.task3605;

import java.io.*;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<String> set = new TreeSet<>();

        File file = new File(args[0]);
        int b = 0;
        try (InputStream is = new FileInputStream(file)) {
            while (is.available() > 0) {
                b = is.read();
                if ((b >= 97 && b <= 122) || (b >= 65 && b <= 90)) {
                    set.add(String.valueOf((char)b).toLowerCase());
                }
            }
        }
        int i = 0;
        for (String s : set) {
            if (i++ >= 5) {
                break;
            }
            System.out.print(s);
        }
    }
}
