package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        ArrayList<String> words = new ArrayList<>();
        while (fileReader.ready())
        {
            words.addAll(Arrays.asList(fileReader.readLine().split(" ")));
        }
        fileReader.close();
        for (int i=0; i<words.size(); i++)
        {
            for (int j=0; j<words.size(); j++)
            {
                if (words.get(i)==null || words.get(j)==null) continue;
                StringBuilder sb = new StringBuilder(words.get(i)).reverse();
                Pair pair = new Pair();

                if (sb.toString().equals(words.get(j)) && i != j)
                {
                    pair.first = words.get(i);
                    pair.second = words.get(j);
                    result.add(pair);
                    words.set(i,null);
                    words.set(j,null);
                }
            }
        }
        System.out.println(result);
        reader.close();
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }
}
