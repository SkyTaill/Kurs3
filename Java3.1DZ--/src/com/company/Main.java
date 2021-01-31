package com.company;

import com.company.Fruit.Apple;
import com.company.Fruit.Box;
import com.company.Fruit.Orange;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main (String[] args)  {
	// write your code here

        Character[] a=new Character[]{'d','f','e','z','f'};
       Change.ChangeM( a,1,2);                    //1 пункт дз
        List<Character> arrayList = new ArrayList<>();
        arrayList = ToListD.ChangeD(a);                 //2 пункт дз


        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Orange o1 = new Orange();
        Orange o2 = new Orange();
        Orange o3 = new Orange();
        appleBox.put(apple1,apple2);
        orangeBox.put(o1, o2,o3);
        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());


    }




}
