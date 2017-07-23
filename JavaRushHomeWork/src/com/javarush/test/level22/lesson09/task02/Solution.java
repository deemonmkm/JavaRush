package com.javarush.test.level22.lesson09.task02;

import java.util.Map;
import java.util.TreeMap;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution
{
    private static Map<String, String> map;

    static
    {
        map = new TreeMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
    }

    public static StringBuilder getCondition(Map<String, String> params)
    {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet())
        {
            if (entry.getValue() != null)
            {
                if (sb.toString().equals(""))
                {
                    sb.append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
                }
                else
                {
                    sb.append(" and ").append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
                }
            }
        }
        return sb;
    }
    public static void main(String[] args)
    {
        System.out.println(getCondition(map).toString());
    }
}
