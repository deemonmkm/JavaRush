package com.javarush.test.level15.lesson12.home04;


/**
 * Created by fr0zen on 06.11.2016.
 */
public class Sun implements Planet
{
    private Sun() {
    }
    private static Sun instance;

    public static Sun getInstance() {
        if (instance==null) {
            instance = new Sun();
        }
        return instance;
    }
}
