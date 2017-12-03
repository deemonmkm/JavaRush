package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.List;
import java.util.Map;

public class DirectorTablet {

    public void printAdvertisementProfit() {
        Map<String, Double> map = StatisticManager.getInstance().getAdvStatistic();
        double totalAmount = 0;

        for (Map.Entry<String, Double> entry : map.entrySet())
        {
            totalAmount += entry.getValue();
            System.out.println(entry.getKey() + " - " + String.format("%.2f", entry.getValue()));
        }
        System.out.println(String.format("Total - %.2f", totalAmount));
    }

    public void printCookWorkloading() {
        Map<String, Map<String, Integer>> map = StatisticManager.getInstance().getCookStatistic();

        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            for (Map.Entry<String, Integer> entry1 : entry.getValue().entrySet()) {
                System.out.println(entry1.getKey() + " - " + entry1.getValue() + " min");
            }
        }
    }

    public void printActiveVideoSet() {
        List<Advertisement> list = StatisticAdvertisementManager.getInstance().getActiveAdvertisements(true);
        for (Advertisement ad : list) {
            ConsoleHelper.writeMessage(ad.getName() + " - " + ad.getHits());
        }
    }

    public void printArchivedVideoSet() {
        List<Advertisement> list = StatisticAdvertisementManager.getInstance().getActiveAdvertisements(false);
        for (Advertisement ad : list) {
            ConsoleHelper.writeMessage(ad.getName());
        }
    }
}
