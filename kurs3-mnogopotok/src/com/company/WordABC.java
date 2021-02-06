package com.company;

import java.util.Arrays;

public class WordABC {
   static public String FirstWord="C";
   static private String[] PrimWord={"A","B","C"};
    public void printWord(String word, Object object) throws InterruptedException {
     //   for(int i=0;i<10;i++){
        synchronized (object){
            for(int i=0;i<10;i++){
            try {


                int index = Arrays.binarySearch(PrimWord, word);
                int index2 = Arrays.binarySearch(PrimWord, FirstWord);
                if (index2 == PrimWord.length - 1) {
                    index2 = -1;
                }

                if (index2 + 1 == index) {
                    System.out.println(word);
                    FirstWord = word;
                    Thread.sleep(1);
                    object.notifyAll();
                } else {
                    object.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

            }

        }

}

