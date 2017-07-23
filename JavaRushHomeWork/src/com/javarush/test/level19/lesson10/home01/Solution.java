package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static com.sun.org.apache.xerces.internal.impl.dtd.XMLDTDLoader.LOCALE;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];
        ArrayList<String> fileList = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String input;
        while ((input = fileReader.readLine()) != null)
        {
            fileList.add(input);
        }
        fileReader.close();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> values = new ArrayList<>();
        String[] stringArray;
        for (String s : fileList)
        {
            stringArray = s.split(" ");
            names.add(stringArray[0]);
            values.add(Double.parseDouble(stringArray[1]));
        }
        Map<String,Double> map = new HashMap<>();
        for (int i=0; i<names.size(); i++)
        {
            map.put(names.get(i), values.get(i));
        }
        ArrayList<String> ignoreNames = new ArrayList<>();
        for (int i=0; i<names.size()-1; i++)
        {
            for (int j=i+1; j<names.size(); j++)
            {
                if (names.get(i).equals(names.get(j)) && !ignoreNames.contains(names.get(i)))
                {
                    double sum = values.get(i) + values.get(j);
                    map.put(names.get(i), sum);
                    ignoreNames.add(names.get(i));
                }
            }
        }
        for (Map.Entry<String, Double> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}