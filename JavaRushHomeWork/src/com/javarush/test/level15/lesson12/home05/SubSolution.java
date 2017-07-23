package com.javarush.test.level15.lesson12.home05;

/**
 * Created by jukov on 08.11.2016.
 */
public class SubSolution extends Solution
{
    public SubSolution()
    {
    }

    public SubSolution(String s1, String s2)
    {
        super(s1, s2);
    }

    public SubSolution(String s1, String s2, String s3)
    {
        super(s1, s2, s3);
    }

    protected SubSolution(int i1)
    {
        super(i1);
    }

    protected SubSolution(int i1, int i2)
    {
        super(i1, i2);
    }

    protected SubSolution(int i1, int i2, int i3)
    {
        super(i1, i2, i3);
    }

    SubSolution(boolean b1)
    {
        super(b1);
    }

    SubSolution(boolean b1, boolean b2)
    {
        super(b1, b2);
    }

    SubSolution(boolean b1, boolean b2, boolean b3)
    {
        super(b1, b2, b3);
    }

    private SubSolution (short o1) {super(o1);}
    private SubSolution (short o1, short o2 ) {super(o1,o2);}
    private SubSolution (short o1, short o2 , short o3) {super(o1,o2,o3);}
}
