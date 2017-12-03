package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        if (data != null) statisticStorage.put(data);
    }

    public Map<String, Double> getAdvStatistic() {
        Map<String, Double> result = new TreeMap<>(Collections.reverseOrder());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        List<EventDataRow> list = statisticStorage.getData().get(EventType.SELECTED_VIDEOS);

        for (EventDataRow eventDataRow : list) {
            VideoSelectedEventDataRow videoSelectedEventDataRow = (VideoSelectedEventDataRow) eventDataRow;
            String date = simpleDateFormat.format(videoSelectedEventDataRow.getDate());
            double amount = (double) videoSelectedEventDataRow.getAmount() / 100;

            if (result.containsKey(date)) result.put(date, result.get(date) + amount);
            else result.put(date, amount);
        }
        return result;
    }

    public Map<String, Map<String, Integer>> getCookStatistic() {
        Map<String, Map<String, Integer>> result = new TreeMap<>(Collections.reverseOrder());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        List<EventDataRow> list = statisticStorage.getData().get(EventType.COOKED_ORDER);

        for (EventDataRow eventDataRow : list) {
            CookedOrderEventDataRow cookedOrderEventDataRow = (CookedOrderEventDataRow) eventDataRow;
            String date = simpleDateFormat.format(cookedOrderEventDataRow.getDate());
            String cookName = cookedOrderEventDataRow.getCookName();
            int cookingTime = cookedOrderEventDataRow.getTime();
            int cookingTimeMin = (cookingTime % 60 == 0) ? (cookingTime /60) : (cookingTime /60 + 1);

            if (result.containsKey(date)) {
                Map<String, Integer> temp = result.get(date);
                if (temp.containsKey(cookName)) temp.put(cookName, temp.get(cookName) + cookingTimeMin);
                else temp.put(cookName, cookingTimeMin);
                result.put(date, temp);
            }
            else {
                Map<String, Integer> temp = new TreeMap<>();
                temp.put(cookName, cookingTimeMin);
                result.put(date, temp);
            }
        }
        return result;
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        private Map<EventType, List<EventDataRow>> getData() {
            return storage;
        }
    }
}
