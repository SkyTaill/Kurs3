package com.company;

public class Main {

    public static void main (String[] args) {
	// write your code hereT
        WordABC wordABC=new WordABC();

            Thread tread1 = new Thread(new TreadStart("A", wordABC));
            Thread tread2 = new Thread(new TreadStart("B", wordABC));
            Thread tread3 = new Thread(new TreadStart("C", wordABC));
            tread1.start();
            tread2.start();
            tread3.start();
        
    }

}
