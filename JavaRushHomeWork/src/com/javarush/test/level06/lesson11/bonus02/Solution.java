package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: дедушку(папин папа), бабушку(мамина мама), папу, маму, сына, дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String dedushkaName = reader.readLine();
        Cat dedyshka = new Cat(dedushkaName);

        String babyshkaName = reader.readLine();
        Cat babyshka = new Cat(babyshkaName);

        String fatherName = reader.readLine();
        Cat father = new Cat(fatherName, dedyshka, null);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, null, babyshka);

        String sonName = reader.readLine();
        Cat son = new Cat(sonName, father, catMother);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, father, catMother);

        System.out.println(dedyshka);
        System.out.println(babyshka);
        System.out.println(father);
        System.out.println(catMother);
        System.out.println(son);
        System.out.println(catDaughter);
    }

    public static class Cat
    {
        private String name;
        private Cat parentF;
        private Cat parentM;

        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat parent, Cat parent2)
        {
            this.name = name;
            this.parentF = parent;
            this.parentM = parent2;
        }

        @Override
        public String toString()
        {
            if (parentF == null && parentM == null)
                return "Cat name is " + name + ", no mother, no father";
            else if (parentM == null)
                return "Cat name is " + name + ", no mother, father is " + parentF.name;
            else if (parentF == null)
                return "Cat name is " + name + ", mother is " + parentM.name + ", no father";
            else
                return "Cat name is " + name + ", mother is " + parentM.name + ", father is " + parentF.name;
        }
    }
}
