package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by fr0ze on 06.03.2017.
 */
public class BotClient extends Client {

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет! Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] messageSplit = message.split(": ");
            if (messageSplit.length == 2) {
                String messageAuthor = messageSplit[0];
                String messageText = messageSplit[1].toLowerCase();
                String dateFormat = null;
                switch (messageText) {
                    case "дата" : {
                        dateFormat = "d.MM.YYYY";
                        break;
                    }
                    case "день" : {
                        dateFormat = "d";
                        break;
                    }
                    case "месяц" : {
                        dateFormat = "MMMM";
                        break;
                    }
                    case "год" : {
                        dateFormat = "YYYY";
                        break;
                    }
                    case "время" : {
                        dateFormat = "H:mm:ss";
                        break;
                    }
                    case "час" : {
                        dateFormat = "H";
                        break;
                    }
                    case "минуты" : {
                        dateFormat = "m";
                        break;
                    }
                    case "секунды" : {
                        dateFormat = "s";
                        break;
                    }
                }
                if (dateFormat != null) {
                    String reply = String.format("Информация для %s: %s", messageAuthor, new SimpleDateFormat(dateFormat).format(Calendar.getInstance().getTime()));
                    sendTextMessage(reply);
                }
            }
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        String botName = "date_bot_" + (int) (Math.random() * 100);
        return botName;
    }

    public static void main (String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
