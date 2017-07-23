package com.javarush.task.task25.task2506;

/**
 * Created by fr0ze on 20.02.2017.
 */
public class LoggingStateThread extends Thread {
    Thread target;

    public LoggingStateThread(Thread target)
    {
        setDaemon(true);
        this.target = target;
    }

    @Override
    public void run() {
        State state = target.getState();
        System.out.println(state);

        while (state != State.TERMINATED)
        {
            if (state != target.getState())
            {
                state = target.getState();
                System.out.println(state);
            }
        }
    }
}
