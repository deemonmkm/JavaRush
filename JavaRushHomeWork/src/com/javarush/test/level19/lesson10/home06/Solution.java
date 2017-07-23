package com.javarush.test.level19.lesson10.home06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки. Не использовать try-with-resources

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static
    {
        map.put(0,"zero");
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        map.put(4,"four");
        map.put(5,"five");
        map.put(6,"six");
        map.put(7,"seven");
        map.put(8,"eight");
        map.put(9,"nine");
        map.put(10,"ten");
        map.put(11,"eleven");
        map.put(12,"twelwe");
    }

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new FileReader(sc.nextLine()));
        sc.close();
        while (in.ready()) {
            String s = in.readLine();
            String[] words = s.split(" ");
            StringBuilder lineNumReplaced = new StringBuilder();
            for (String word : words) {
                String nunmStr = "";
                try {
                    if ((nunmStr = map.get(Integer.parseInt(word))) != null)
                        word = nunmStr;
                } catch (NumberFormatException e) { /*do nothing */ }
                lineNumReplaced.append(word + " ");
            }
            if (lineNumReplaced.length() > 0 ) lineNumReplaced.deleteCharAt(lineNumReplaced.length() - 1);
            System.out.println(lineNumReplaced.toString());
        }
        in.close();
    }
}