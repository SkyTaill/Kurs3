package com.company.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    private List<T> getFruits() {
        return fruits;
    }


    public double getWeight() {
    T local;
    double sumFruit=0;
        for(int i=0;i<fruits.size();i++) {
           local= fruits.<T>get(i);
            sumFruit+=local.getWeight();
        }
        return sumFruit;
    }

    public void put(T fruit) {
        fruits.add(fruit);
    }

    public void put(T... fruit) {   //добавление множества фруктов в коробку
        fruits.addAll(Arrays.asList(fruit));
    }



    public <E extends Fruit> boolean compare(Box<E> box) {
        return getWeight() == box.getWeight();
    }
}
