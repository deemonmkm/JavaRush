package com.javarush.test.level21.lesson16.big01;

        import java.util.ArrayList;

/**
 * Created by jukov on 02.12.2016.
 */
public class Hippodrome
{
    ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();
        Horse horse1 = new Horse("Katya", 3, 0);
        Horse horse2 = new Horse("Lenka", 3, 0);
        Horse horse3 = new Horse("Mashka", 3, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        game.printWinner();
    }

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run() throws InterruptedException
    {
        for (int i=1; i<=100; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move()
    {
        for (Horse h : getHorses())
        {
            h.move();
        }
    }
    public void print()
    {
        for (Horse h : getHorses())
        {
            h.print();
            //System.out.println();
            //System.out.println();
        }
        System.out.println();
    }
    public Horse getWinner()
    {
        Horse winner = horses.get(0);
        for (Horse hor : getHorses())
        {
            if (hor.getDistance() > winner.getDistance())
            {
                winner = hor;
            }
        }
        return winner;
    }
    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
