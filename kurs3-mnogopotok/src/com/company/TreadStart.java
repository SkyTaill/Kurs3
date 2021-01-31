package com.company;

public class TreadStart implements Runnable {
private String Word;
    Object object;
    WordABC wordABC;
public TreadStart(String Word,WordABC wordABC){
    this.Word=Word;
    object=new Object();
    this.wordABC=wordABC;
}
    @Override
    public void run() {

        try {
            wordABC.printWord(Word,object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
