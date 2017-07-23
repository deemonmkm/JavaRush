package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> s = new ArrayList<>();
        for (int i=0; i < 10; i++)
        {
            s.add(reader.readLine());
        }
        int min = s.get(0).length();
        int max = s.get(0).length();
        for (int i=0; i < s.size(); i++)
        {
            if (s.get(i).length() < min) min = s.get(i).length();
            if (s.get(i).length() > max) max = s.get(i).length();
        }
        for (String str : s)
        {
            if (str.length()==min)
            {
                System.out.println(str);
                break;
            }
            else if (str.length()==max)
            {
                System.out.println(str);
                break;
            }
        }
    }
}
