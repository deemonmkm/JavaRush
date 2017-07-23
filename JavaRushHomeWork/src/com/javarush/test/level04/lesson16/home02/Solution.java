package com.javarush.test.level04.lesson16.home02;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a1 = reader.readLine(), b1 = reader.readLine(), c1 = reader.readLine();
        int a = Integer.parseInt(a1), b = Integer.parseInt(b1), c = Integer.parseInt(c1);
        if (b>a&&a>c) System.out.println(a);
        else if(b<a&&a<c) System.out.println(a);
        else if(a>b&&b>c) System.out.println(b);
        else if(a<b&&b<c) System.out.println(b);
        else if(a>c&&c>b) System.out.println(c);
        else if(a<c&&c<b) System.out.println(c);
    }
}
