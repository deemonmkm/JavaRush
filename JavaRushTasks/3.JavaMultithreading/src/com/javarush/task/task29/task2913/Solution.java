package com.javarush.task.task29.task2913;

import java.util.ArrayList;
import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;
    private  static ArrayList<Integer> list = new ArrayList<>();
    private  static ArrayList<Integer> list2 = new ArrayList<>();

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder sb = new StringBuilder();
        if (a < b)
        {
            for (int i = a; i <= b; i++)
            {
                sb.append(i).append(" ");
            }
            return sb.toString().trim();
        }
        else if (a > b)
        {
            for (int i = a; i >= b; i--)
            {
                sb.append(i).append(" ");
            }
            return sb.toString().trim();
        }
        return null;
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt() % 1_000;
        numberB = random.nextInt() % 10_000;
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}