package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() +
            ".resources.common_en");
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException
    {
        String message = "";
        try
        {
            message = bis.readLine();
            if (message.equalsIgnoreCase("EXIT")) throw new InterruptOperationException();
        }
        catch (IOException ignored)
        {
        }
        return message;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        String enterString;
        writeMessage("Enter currency code: ");
        while (true) {
            enterString = readString();
            if (enterString.length() == 3) {
                break;
            }
            else {
                writeMessage("Invalid data. Code must have 3 characters. Try again");
            }
        }
        return enterString.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String[] array;
        writeMessage("Choose denomination and count format");
        while (true) {
            String s = readString();
            array = s.split(" ");
            int denomination = 0;
            int count = 0;
            try {
                denomination = Integer.parseInt(array[0]);
                count = Integer.parseInt(array[1]);
            } catch (Exception e) {
                writeMessage("Invalid data. Try again");
                continue;
            }
            if (denomination <= 0 || count <= 0 || array.length != 2) {
                writeMessage("Invalid data. Try again");
                continue;
            }
            break;
        }
        return array;
    }

    public static Operation askOperation() throws InterruptOperationException {
        while (true) {
            String str = readString();
            if (str.matches("^[1-4]$")) return Operation.getAllowableOperationByOrdinal(Integer.parseInt(str));
            else writeMessage("Invalid data. Try again");
        }
    }

    public static void printExitMessage() {
        ConsoleHelper.writeMessage("Bye-bye");
    }
}

