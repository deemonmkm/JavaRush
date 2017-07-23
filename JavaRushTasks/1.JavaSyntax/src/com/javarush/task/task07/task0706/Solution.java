package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] a = new int[15];
        int even=0;
        int odd=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < a.length; i++)
        {
            int b = Integer.parseInt(reader.readLine());
            if (i%2==0) even+=b;
            else odd+=b;
        }
        if (even > odd) System.out.println("В домах с четными номерами проживает больше жителей.");
        else if (even < odd) System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
