package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        int count = 0;
        if (args.length>0)
        {
            FileInputStream in = new FileInputStream(args[0]);

            while (in.available()>0)
            {
                char data = (char)in.read();
                if ((data >= 'A' && data <= 'Z') || (data >= 'a' && data <= 'z'))
                {
                    count++;
                }
            }
            in.close();
        }
        System.out.println(count);
    }
}
