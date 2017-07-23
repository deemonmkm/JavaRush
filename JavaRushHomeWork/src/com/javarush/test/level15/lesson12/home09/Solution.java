package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Double.parseDouble;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String url = reader.readLine();
        String [] s1 = url.split( "\\?");
        String [] s2 = s1[1].split( "&");

        for (String x : s2)
        {
            String[] temp = x.split( "=");
            for (int i=0; i<temp.length; i++)
            {
                if (i%2==0)
                {
                    System.out.print(temp[i] + " ");
                }
            }
        }
        for (String x : s2)
        {
            if (x.contains( "obj"))
            {
                String[] temp = x.split( "=");
                if (temp[1].contains( "."))
                {
                    System.out.println();
                    alert(Double.parseDouble(temp[1]));
                }
                else
                {
                    System.out.println();
                    alert(temp[1]);
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
