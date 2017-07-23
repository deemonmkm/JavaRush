package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        FileInputStream file2 = new FileInputStream(s2);

        RandomAccessFile rand = new RandomAccessFile(s1,"rw");
        byte[] array = new byte[(int)rand.length()];
        rand.read(array);
        rand.seek(0);

        while (file2.available()>0)
        {
            rand.write(file2.read());
        }
        rand.write(array);

        reader.close();
        rand.close();
        file2.close();
    }
}
