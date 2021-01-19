package com.company;

public class Change {


    public static <T> void ChangeM(T Mass[],int A,int B){
        T Local=Mass[A];
        Mass[A]=Mass[B];
        Mass[B]=Local;


      //  return (T)Mass ;
    }
}
