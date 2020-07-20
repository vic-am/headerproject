package com.victoramaral.recyclerviewheader.common;

import com.victoramaral.recyclerviewheader.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CommonJava {

    public static final int VIEWTYPE_GROUP = 0;
    public static final int VIEWTYPE_PERSON = 1;
    public static final int RESULT_CODE = 1000;

    public static List<String> alphabetAvaiable = new ArrayList<>();

    //Function to sort person list name by alphabet
    public static ArrayList<Person> sortList(ArrayList<Person> people) {
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                return person.getName().compareTo(t1.getName());
            }
        });
        return people;
    }

    //After sorted, this function will add alphabet character to list
    public static ArrayList<Person> addAlphabets(ArrayList<Person> list) {
        int i = 0;
        ArrayList<Person> customList = new ArrayList<>();
        Person firstPosition = new Person();
        firstPosition.setName(String.valueOf(list.get(0).getName().charAt(0)));
        firstPosition.setViewType(Common.VIEWTYPE.INSTANCE.getVIEWTYPE_GROUP());
        alphabetAvaiable.add(String.valueOf(list.get(0).getName().charAt(0)));

        customList.add(firstPosition);

        for (i = 0; i < list.size() - 1; i++) {
            Person person = new Person();
            char name1 = list.get(i).getName().charAt(0);
            char name2 = list.get(i + 1).getName().charAt(0);
            if (name1 == name2) {
                list.get(i).setViewType(VIEWTYPE_PERSON);
                customList.add(list.get(i));
                person.setName(String.valueOf(name2));
                person.setViewType(VIEWTYPE_GROUP);
                alphabetAvaiable.add(String.valueOf(name2));
                customList.add(person);
            }
        }

        list.get(i).setViewType(VIEWTYPE_PERSON);
        customList.add(list.get(i));
        return customList;

    }

    //This function with return position of string in list
    public static int findPositionWithName(String name, ArrayList<Person> list){
        for(int i=0; i<list.size(); i++){
            if (list.get(i).getName().equals(name))
                return i;
        }
        return -1;
    }

    //This function will generate an alphabet list
    public static ArrayList<String> generateAlphabet(){
        ArrayList<String> result = new ArrayList<>();
        for(int i = 65; i<=90; i++) // 65 in ASCII code = A, 90 = Z
        {
            char character = (char)i;
            result.add(String.valueOf(character));
        }
        return result;
    }



    //This function will create an person group with random name
    public static List<Person> genPeopleGroup() {
        List<Person> personList = new ArrayList<Person>() {
        };

        Person person = new Person("Andy", "Director", -1);
        personList.add(person);
                 person = new Person("Carlos", "Tio", -1);
        personList.add(person);
                 person = new Person("Victor", "Eu", -1);
        personList.add(person);
                 person = new Person("Thais", "Amor", -1);
        personList.add(person);
                 person = new Person("Ana", "Filha", -1);
        personList.add(person);
                 person = new Person("Roberto", "Tecnico", -1);
        personList.add(person);
                 person = new Person("Luiza", "Tia", -1);
        personList.add(person);
                 person = new Person("Paulo", "Pai", -1);
        personList.add(person);
                 person = new Person("Solange", "Mãe", -1);
        personList.add(person);
                 person = new Person("Marcelo", "Tio", -1);
        personList.add(person);
                 person = new Person("André", "Primo", -1);
        personList.add(person);

        return personList;

    }
}
