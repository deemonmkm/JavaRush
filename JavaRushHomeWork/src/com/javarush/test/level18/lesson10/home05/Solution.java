package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader in = new BufferedReader(new FileReader(file1));
        BufferedWriter out = new BufferedWriter(new FileWriter(file2));

        while (in.ready())
        {
            String readedString = in.readLine();
            String[] numbers = readedString.split(" ");
            for (int i=0; i<numbers.length; i++)
            {
                double templateDouble = Double.parseDouble(numbers[i]);
                double newDouble = new BigDecimal(templateDouble).setScale(0, RoundingMode.HALF_UP).doubleValue();
                out.write((int) newDouble + " ");
            }
            out.newLine();
        }
        in.close();
        out.close();
    }
}
