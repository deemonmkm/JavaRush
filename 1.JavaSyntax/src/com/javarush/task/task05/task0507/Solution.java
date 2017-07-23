package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        double sum=0;
        double count=0;
        for(int i=0; ; i++)
        {
            int a = sc.nextInt();
            if (a!=-1)
            {
                sum+=(double)a;
                count++;
            }
            else
            {
                System.out.println(sum/count);
                break;
            }
        }
    }
}