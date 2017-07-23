package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by fr0ze on 22.02.2017.
 */
public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run()
    {
        try
        {
            int i = 0;
            while (true)
            {
                i++;
                map.put(String.valueOf(i), "Some text for " +i);
                Thread.sleep(500);
            }
        }
        catch (Exception e)
        {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}