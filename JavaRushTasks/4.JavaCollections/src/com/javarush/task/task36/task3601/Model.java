package com.javarush.task.task36.task3601;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by fr0ze on 11.04.2017.
 */
public class Model {
    Service service = new Service();

    public List<String> getStringDataList() {
        return service.getData();
    }
}
