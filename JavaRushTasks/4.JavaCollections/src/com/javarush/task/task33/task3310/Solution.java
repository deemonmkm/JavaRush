package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        StorageStrategy strategy = new HashMapStorageStrategy();
        testStrategy(strategy, 10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> set = new HashSet<>();
        for (String s : strings) {
            set.add(shortener.getId(s));
        }
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> set = new HashSet<>();
        for (Long l : keys) {
            set.add(shortener.getString(l));
        }
        return set;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            set.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);

        Set<Long> ids = new HashSet<>();
        Date startDate1 = new Date();
        ids = getIds(shortener, set);
        Date finishDate1 = new Date();

        long delay1 = finishDate1.getTime() - startDate1.getTime();
        Helper.printMessage(String.valueOf(delay1));

        Set<String> strings = new HashSet<>();
        Date startDate2 = new Date();
        strings = getStrings(shortener, ids);
        Date finishDate2 = new Date();

        long delay2 = finishDate2.getTime() - startDate2.getTime();
        Helper.printMessage(String.valueOf(delay2));

        if (strings.equals(set)) Helper.printMessage("Тест пройден.");
        else Helper.printMessage("Тест не пройден.");
    }
}
