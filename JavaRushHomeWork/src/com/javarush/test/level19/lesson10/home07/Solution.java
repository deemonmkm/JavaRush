package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Users\\jukov\\Desktop\\j\\1.txt"));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter("C:\\Users\\jukov\\Desktop\\j\\2.txt"));

        StringBuilder sb = new StringBuilder();
        String line;
        while (fileReader.ready())
        {
            line = fileReader.readLine();
            String[] words = line.split(" ");
            for (String word : words)
            {
                if (word.length() > 6)
                {
                    sb.append(word + ",");
                }
            }
        }
        sb.deleteCharAt(sb.length()-1);
        fileWriter.write(sb.toString());
        fileReader.close();
        fileWriter.close();
    }
}
