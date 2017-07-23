package com.javarush.task.task36.task3601;

/**
 * Created by fr0ze on 11.04.2017.
 */
public class View {
    Controller controller = new Controller();

    public void fireEventShowData() {
        System.out.println(controller.onDataListShow());
    }
}
