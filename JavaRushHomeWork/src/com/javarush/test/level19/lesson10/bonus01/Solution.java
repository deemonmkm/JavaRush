package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка5            ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static List<String> file1 = new ArrayList<>();
    public static List<String> file2 = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1Reader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader file2Reader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        while (file1Reader.ready())
        {
            file1.add(file1Reader.readLine());
        }
        while (file2Reader.ready())
        {
            file2.add(file2Reader.readLine());
        }
        file1Reader.close();
        file2Reader.close();

        try
        {
            for (int i = 0; i < file1.size(); i++)
            {
                if (file1.get(i).equals(file2.get(i)))
                {
                    lines.add(new LineItem(Type.SAME, file2.get(i)));
                }
                else if (file1.get(i).equals(""))
                {
                    lines.add(new LineItem(Type.ADDED, file2.get(i)));
                }
                else if (file2.get(i).equals(""))
                {
                    lines.add(new LineItem(Type.REMOVED, file1.get(i)));
                }
            }
        }
        catch (Exception e)
        {

        }
        for (LineItem l : lines)
        {
            System.out.println(l.type + " " + l.line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
