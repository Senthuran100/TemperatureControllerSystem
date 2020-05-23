package com.company;

public class CentralSystem {

    public static void main(String[] args) {

        TemperatureController temperatureController=new TemperatureController();
        System.out.println("---------- Creating First Floor Thermostat ----------");
        int first[]={23,20,23,27};
        Thermostat firstfloor=new Thermostat("First",first);
        System.out.println("-------------------------------------------------\n");

        System.out.println("---------- Creating First Floor Thermostat ----------");
        int ground[]={23,16,15,27};
        Thermostat groundfloor=new Thermostat("Ground",ground);
        System.out.println("-------------------------------------------------\n");


        System.out.println("---------- Creating First Floor Thermostat ----------");
        int attic[]={23,30,29,27};
        Thermostat atticfloor=new Thermostat("Attic",attic);
        System.out.println("-------------------------------------------------\n");

        firstfloor.start();
        groundfloor.start();
        atticfloor.start();

    }
}
