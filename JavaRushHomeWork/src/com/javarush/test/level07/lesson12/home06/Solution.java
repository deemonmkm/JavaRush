package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human petro = new Human();
        petro.name = "Петро";
        petro.age = 45;
        petro.sex = true;
        System.out.println(petro.toString());

        Human dusya = new Human();
        dusya.name = "Дуся";
        dusya.age = 42;
        dusya.sex = false;
        System.out.println(dusya.toString());

        Human fedya = new Human();
        fedya.name = "Федя";
        fedya.age = 47;
        fedya.sex = true;
        System.out.println(fedya.toString());

        Human marfa = new Human();
        marfa.name = "Марфа";
        marfa.age = 42;
        marfa.sex = false;
        System.out.println(marfa.toString());

        Human ivan = new Human();
        ivan.name = "Иван";
        ivan.age = 25;
        ivan.sex = true;
        ivan.father = petro;
        ivan.mother = dusya;
        System.out.println(ivan.toString());

        Human marya = new Human();
        marya.name = "Марья";
        marya.age = 23;
        marya.sex = false;
        marya.father = fedya;
        marya.mother = marfa;
        System.out.println(marya.toString());

        Human sasha = new Human();
        sasha.name = "Саша";
        sasha.age = 5;
        sasha.sex = true;
        sasha.father = ivan;
        sasha.mother = marya;
        System.out.println(sasha.toString());

        Human pasha = new Human();
        pasha.name = "Паша";
        pasha.age = 7;
        pasha.sex = true;
        pasha.father = ivan;
        pasha.mother = marya;
        System.out.println(pasha.toString());

        Human dasha = new Human();
        dasha.name = "Даша";
        dasha.age = 13;
        dasha.sex = false;
        dasha.father = ivan;
        dasha.mother = marya;
        System.out.println(dasha.toString());
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
