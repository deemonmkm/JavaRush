package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args)
    {
        String str = "JavaRush - лучший сервис обучения Java.";
        System.out.println();
        System.out.println(getPartOfString(str));
    }

    public static String getPartOfString(String string) {
        if (string == null || string.isEmpty())
        {
            throw new TooShortStringException();
        }
        int indexFirstSpace = string.indexOf(" ") + 1;
        char[] chars = string.toCharArray();
        int countSpaces = 0;
        int indexLastSpace = 0;
        for (int i=0; i<string.length();i++)
        {
            if (chars[i] == ' ')
            {
                countSpaces++;
                if (countSpaces == 4)
                {
                    indexLastSpace = string.length();
                }
                else if (countSpaces == 5)
                {
                    indexLastSpace = i;
                    break;
                }
            }
        }
        if (countSpaces < 4)
        {
            throw new TooShortStringException();
        }
        return string.substring(indexFirstSpace, indexLastSpace);
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
