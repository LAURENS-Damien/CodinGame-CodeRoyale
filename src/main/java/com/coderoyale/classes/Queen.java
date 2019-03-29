package com.coderoyale.classes;

public class Queen {
    final private int RADIUS = 30;
    final private int MAX_MOUVEMENT = 60;
    private int gold;
    private int touchedId;
    private int pv = 100;
    private int xCoordinate;
    private int yCoordinate;

    public int getRADIUS() {
        return RADIUS;
    }

    public int getMAX_MOUVEMENT() {
        return MAX_MOUVEMENT;
    }

    public int getTouchedId() {
        return touchedId;
    }

    public void setTouchedId(int touchedId) {
        this.touchedId = touchedId;
    }

    public int getPv() {
        return pv;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
