package com.javarush.test.level14.lesson06.home01;

/**
 * Created by jukov on 15.11.2016.
 */
public class UkrainianHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 3;
    }

    @Override
    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + "яиц в месяц.";
    }
}
