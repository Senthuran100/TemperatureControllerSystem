package com.company;

import java.util.Random;

public class Thermostat extends Thread {
    private TemperatureController temperatureController;
    private String floor;
    private int temp;
    private int[] temperature=new int[4];

    public Thermostat(String floor,int[] temp){
        this.floor=floor;
        this.temperature=temp;
    }

    @Override
    public void run() {
        TemperatureController temperatureController=new TemperatureController();

        Random numGen = new Random();

        for(int i=0;i<temperature.length;i++) {
            if (floor.equals("Ground")) {
                temperatureController.setGFtemp(temperature[i]);
            } else if (floor.equals("First")) {
                temperatureController.setFFtemp(temperature[i]);
            } else if (floor.equals("Attic")) {
                temperatureController.setATtemp(temperature[i]);
            }

            try {
                int time = numGen.nextInt(4000) + 1000;
                System.out.println("Thread[ " + this.floor + " ] waiting for " + time / 1000 + " seconds");
                Thread.sleep(time);
                temperatureController.displayTemperatures();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }

    }

