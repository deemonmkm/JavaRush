package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws IOException {
        List<Tablet> tablets = new ArrayList<>();

        Cook cook = new Cook("Amigo");
        cook.setQueue(orderQueue);
        Cook cook2 = new Cook("Pedro");
        cook2.setQueue(orderQueue);

        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        cook2.addObserver(waiter);

        for (int i = 1; i <= 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderQueue);
            tablets.add(tablet);
        }

        RandomOrderGeneratorTask randomOrderGeneratorTask = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
        Thread cookThread = new Thread(randomOrderGeneratorTask);
        cookThread.start();

        Thread cook1Thread = new Thread(cook);
        cook1Thread.start();
        Thread cook2Thread = new Thread(cook2);
        cook2Thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        cookThread.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
