package com.coderoyale.classes;

public abstract class AbstractDashboard {
    private int knightnumber = 0;
    private int archerNumber = 0;
    private int sitesNumber = 0;

    public int getKnightnumber() {
        return knightnumber;
    }

    public void setKnightnumber(int knightnumber) {
        this.knightnumber = knightnumber;
    }

    public int getArcherNumber() {
        return archerNumber;
    }

    public void setArcherNumber(int archerNumber) {
        this.archerNumber = archerNumber;
    }
}
