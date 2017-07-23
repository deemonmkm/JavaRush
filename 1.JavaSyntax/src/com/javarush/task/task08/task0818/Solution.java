package com.javarush.task.task08.task0818;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<10; i++)
        {
            map.put("name"+i, i*100);
        }
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> copy = new HashMap<String, Integer>(map);
        for (Map.Entry<String, Integer> s : copy.entrySet())
        {
            if (s.getValue() < 500) map.remove(s.getKey());
        }
    }

    public static void main(String[] args) {
    }
}