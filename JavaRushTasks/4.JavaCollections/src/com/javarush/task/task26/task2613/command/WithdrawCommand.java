package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.CashMachine.RESOURCE_PATH;

class WithdrawCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {
        String curr = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(curr);
        while (true) {
            ConsoleHelper.writeMessage(res.getString("before"));
            int amount = 0;
            String s = ConsoleHelper.readString();
            try {
                amount = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
                continue;
            }
            if (amount <= 0) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
            if (!currencyManipulator.isAmountAvailable(amount)) {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }
            try {
                currencyManipulator.withdrawAmount(amount);
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, curr));
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                continue;
            }
            break;
        }
    }
}
