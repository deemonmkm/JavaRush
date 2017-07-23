package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        String s = Integer.toString(number);
        char[] ch = s.toCharArray();
        int count=0;
        for (int i=0; i<ch.length; i++)
        {
            count+=Integer.parseInt(String.valueOf(ch[i]));
        }
        return count;
    }
}