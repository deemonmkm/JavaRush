package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution
{
    public Solution () {}
    public Solution (String s1, String s2 ) {}
    public Solution (String s1, String s2 , String s3) {}
    protected Solution (int i1) {}
    protected Solution (int i1, int i2 ) {}
    protected Solution (int i1, int i2 , int i3) {}
    Solution (boolean b1) {}
    Solution (boolean b1, boolean b2) {}
    Solution (boolean b1, boolean b2, boolean b3) {}
    private Solution (short o1) {}
    private Solution (short o1, short o2 ) {}
    private Solution (short o1, short o2 , short o3) {}
}