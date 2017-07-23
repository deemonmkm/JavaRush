package com.javarush.test.level14.lesson08.home09;

public abstract class Money
{
    public Money(double amount)
    {
        this.bablo=amount;
    }

    private double bablo;
    public double getAmount()
    {
        return bablo;
    }

    public abstract String getCurrencyName();
}

