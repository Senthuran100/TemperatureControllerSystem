package com.company;

public class TemperatureController implements Temperatures {
    private int GFtemp=18;
    private int FFtemp=20;
    private int AAtemp=21;

    @Override
    public synchronized void setGFtemp(int newgftemp) {
        int retry=3;
        while(retry>0) {
            if (newgftemp < FFtemp) {
                this.GFtemp = newgftemp;
                retry=0;
            } else {
                try {
                    wait(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                retry--;
            }
        }
    }

    @Override
    public synchronized void setFFtemp(int newfftemp) {
        int retry=3;
        while(retry>0) {
            if (GFtemp < newfftemp && newfftemp <= AAtemp) {
                this.FFtemp = newfftemp;
                retry=0;
            } else {
                try {
                    wait(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                retry--;
            }
        }
    }

    @Override
    public synchronized void setATtemp(int newattemp) {
        int retry=3;
        while(retry>0) {
            if (FFtemp <= newattemp) {
                this.AAtemp = newattemp;
                retry=0;
            } else {
                try {
                    wait(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                retry--;
            }
        }
    }


    @Override
    public void displayTemperatures() {
        System.out.println("-------------------------------------------------\n");
        System.out.println("Temperature AT Ground Floor "+ GFtemp);
        System.out.println("Temperature AT First Floor "+ FFtemp);
        System.out.println("Temperature AT Attic "+ AAtemp);
        System.out.println("-------------------------------------------------\n");
    }
}
