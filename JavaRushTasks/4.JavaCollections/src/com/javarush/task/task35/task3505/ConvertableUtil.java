package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <T> Map convert(List<? extends Convertable<T>> list) {
        Map<T, Convertable<T>> result = new HashMap<>();
        for (Convertable<T> value: list) {
            result.put(value.getKey(), value);
        }
        return result;
    }
}
