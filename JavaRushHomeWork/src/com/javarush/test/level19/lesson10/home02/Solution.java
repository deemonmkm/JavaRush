package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Map<String, Double> map = new HashMap<>();
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String[] symbols;
        String line;
        Double currentValue;

        while ((line = bufferedReader.readLine()) != null)
        {
            symbols = line.split(" ");
            if (map.containsKey(symbols[0]))
            {
                currentValue = map.get(symbols[0]);
                map.put(symbols[0], Double.parseDouble(symbols[1]) + currentValue);
            }
            else
            {
                map.put(symbols[0], Double.parseDouble(symbols[1]));
            }
        }
        bufferedReader.close();
        Double max = Double.MIN_VALUE;
        Double value;
        for (String s : map.keySet())
        {
            value = map.get(s);
            if (value > max)
            {
                max = value;
            }
        }
        for (String s1 : map.keySet())
        {
            value = map.get(s1);
            if (value == max)
            {
                System.out.println(s1);
            }
        }
    }
}