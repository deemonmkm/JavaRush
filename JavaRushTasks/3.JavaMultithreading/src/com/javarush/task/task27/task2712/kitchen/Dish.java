package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        Dish[] dish = Dish.values();
        String result = "";
        for (Dish d : dish) {
            result += d.toString() + ", ";
        }
        return result.substring(0, result.length()-2);
    }
}
