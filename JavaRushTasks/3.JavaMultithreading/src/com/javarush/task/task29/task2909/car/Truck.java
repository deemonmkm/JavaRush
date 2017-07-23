package com.javarush.task.task29.task2909.car;

/**
 * Created by fr0ze on 02.03.2017.
 */
public class Truck extends Car {
    public Truck(int numberOfPassengers) {
        super(Car.TRUCK, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        final int MAX_CABRIOLET_SPEED = 80;
        return MAX_CABRIOLET_SPEED;
    }
}
