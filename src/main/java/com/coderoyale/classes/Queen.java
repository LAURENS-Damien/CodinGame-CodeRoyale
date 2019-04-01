package com.coderoyale.classes;

import java.util.List;

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

    public void goToNearestSite(List<Site> sites) {

        int nearestSite = 0;
        int deltaX = 0;
        int deltaY = 0;

        for (Site site : sites) {
            //Math.max(site.getxCoordonate(), site.getyCoordonate());
            deltaX = site.getxCoordonate()- this.getxCoordinate();
            deltaY = site.getyCoordonate() - this.getyCoordinate();
            if (Math.max(deltaX, (site.getxCoordonate() - this.getxCoordinate())) >= deltaX) {

            }
        }
    }
}
