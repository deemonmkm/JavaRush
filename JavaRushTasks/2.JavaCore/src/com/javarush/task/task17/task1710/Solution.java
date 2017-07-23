package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        //start here - начни тут
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        switch (args[0]) {
            case "-c":
            {
                if (args[2].equals("м"))
                {
                    allPeople.add(Person.createMale(args[1], sdf.parse(args[3])));
                    System.out.println(allPeople.size()-1);
                }
                else if (args[2].equals("ж"))
                {
                    allPeople.add(Person.createFemale(args[1], sdf.parse(args[3])));
                    System.out.println(allPeople.size()-1);
                }
            }
                break;
            case "-u":
            {
                int id = Integer.parseInt(args[1]);
                if (args[3].equals("м"))
                {
                    allPeople.get(id).setName(args[2]);
                    allPeople.get(id).setSex(Sex.MALE);
                    allPeople.get(id).setBirthDay(sdf.parse(args[4]));
                }
                else if (args[3].equals("ж"))
                {
                    allPeople.get(id).setName(args[2]);
                    allPeople.get(id).setSex(Sex.FEMALE);
                    allPeople.get(id).setBirthDay(sdf.parse(args[4]));
                }
            }
                break;
            case "-d":
            {
                int id = Integer.parseInt(args[1]);
                allPeople.get(id).setName(null);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setBirthDay(null);
            }
                break;
            case "-i":
            {
                SimpleDateFormat dateFormatOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                int id = Integer.parseInt(args[1]);
                Person person = allPeople.get(id);
                if (person.getSex().equals(Sex.MALE))
                {
                    System.out.println(person.getName() + " м " + dateFormatOut.format(person.getBirthDay()));
                }
                else if (person.getSex().equals(Sex.FEMALE))
                {
                    System.out.println(person.getName() + " ж " + dateFormatOut.format(person.getBirthDay()));
                }
            }
                break;
        }
    }
}
