package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TestOrder extends Order {
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        dishes = new ArrayList<>();

        int len = (int) (Math.random() * Dish.values().length);

        for (int i = 0; i < len; i++) {
            int random = (int) (Math.random() * Dish.values().length);
            dishes.add(Dish.values()[random]);
        }
    }
}
