package com.company;

import java.util.ArrayList;
import java.util.List;

public class ToListD {
    public static <T> List<T> ChangeD(T Mass[]) {
        ArrayList<T> arrayList = new ArrayList<>();
        for(T i:Mass){
            arrayList.add(i);
        }
        return arrayList;
    }
}
