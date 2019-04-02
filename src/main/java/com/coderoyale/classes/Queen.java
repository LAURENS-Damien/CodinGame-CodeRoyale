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
    private int nearestEmptySite;

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

    public int getNearestEmptySite() {
        return nearestEmptySite;
    }

    public void setNearestEmptySite(List<Site> sites) {

        int deltaX;

        for (Site site : sites) {
            // On détermine la coordonnée X la plus proche
            if (site.getxCoordinate() <= this.getxCoordinate()) {
                deltaX = this.getxCoordinate() - site.getxCoordinate();
            } else {
                deltaX =  site.getxCoordinate() - this.getxCoordinate();
            }

            if (deltaX < sites.get(this.nearestEmptySite).getxCoordinate()) {
                this.nearestEmptySite = site.getSiteId();
            }
        }
    }
}
