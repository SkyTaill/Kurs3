package com.company;

import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static int Win=0;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public CountDownLatch cdl;

    public Car(Race race, int speed, CountDownLatch cdl) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cdl=cdl;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            Main.startRace();
            cdl.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {

            cdl.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        woIsWin();

    }
     public void woIsWin(){    
        Win++;
        if(Win==1){
            System.out.println("Win");
        }
        if(Win==4){
            Main.endRace();
        }
     }
}