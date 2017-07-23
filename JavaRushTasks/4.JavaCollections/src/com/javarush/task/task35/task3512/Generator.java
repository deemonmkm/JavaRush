package com.javarush.task.task35.task3512;

public class Generator<T> {
    Class<T> c;

    public Generator(Class<T> clas) {
        this.c = clas;
    }

    T newInstance() throws IllegalAccessException, InstantiationException {
        return c.newInstance();
    }
}
