package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nod;
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        if (a > b)
        {
               nod = b;
        }
        else
        {
           nod = a;
        }
        while (true)
        {
            if (a % nod == 0 && b % nod == 0)
            {
                break;
            }
            else
            {
                nod -= 1;
            }
        }
        System.out.println(nod);
    }
}

