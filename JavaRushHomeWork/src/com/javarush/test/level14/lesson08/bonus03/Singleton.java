package com.javarush.test.level14.lesson08.bonus03;

import java.util.Objects;

/**
 * Created by jukov on 05.11.2016.
 */
public class Singleton
{
    private Singleton() {
    }
    private static Singleton instance;

    public static Singleton getInstance() {
        if (instance==null) {
            instance = new Singleton();
        }
        return instance;
    }
}