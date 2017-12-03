package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.CashMachine.RESOURCE_PATH;

class InfoCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "info_en");

    @Override
    public void execute() {

        boolean money = false;
        ConsoleHelper.writeMessage(res.getString("before"));
        for (CurrencyManipulator currencyManipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
            if (currencyManipulator.hasMoney()) {
                if (currencyManipulator.getTotalAmount() > 0) {
                    ConsoleHelper.writeMessage(currencyManipulator.getCurrencyCode() + " - " +
                            currencyManipulator.getTotalAmount());
                    money = true;
                }
            }
        }
        if (!money) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}
