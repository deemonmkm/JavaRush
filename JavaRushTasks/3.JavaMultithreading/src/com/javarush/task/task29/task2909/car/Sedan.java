package com.javarush.task.task29.task2909.car;

/**
 * Created by fr0ze on 02.03.2017.
 */
public class Sedan extends Car {
    public Sedan(int numberOfPassengers) {
        super(Car.SEDAN, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        final int MAX_CABRIOLET_SPEED = 120;
        return MAX_CABRIOLET_SPEED;
    }
}
