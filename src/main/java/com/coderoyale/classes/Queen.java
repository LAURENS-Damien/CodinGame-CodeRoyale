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
    private int nearestSite;

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

    public int getNearestSite() {
        return nearestSite;
    }

    public void setNearestSite(List<Site> sites) {

        int nearestSiteDeltaX = 0;
        int nearestSiteDeltaY = 0;
        int deltaX = 0;
        int deltaY = 0;

        for (Site site : sites) {
            //Math.max(site.getxCoordinate(), site.getyCoordinate());
//            deltaX = site.getxCoordinate()- this.getxCoordinate();
//            deltaY = site.getyCoordinate() - this.getyCoordinate();
//            deltaX = Math.max(deltaX, (site.getxCoordinate() - this.getxCoordinate()));
//            deltaY = Math.max(deltaY, (site.getyCoordinate() - this.getyCoordinate()));


            // On détermine la coordonnée X la plus proche
            if (site.getxCoordinate() <= this.getxCoordinate()) {
                deltaX = this.getxCoordinate() - site.getxCoordinate();
            } else {
                deltaX =  site.getxCoordinate() - this.getxCoordinate();
            }

            // On détermine la coordonnée Y la plus proche
            if (site.getyCoordinate() <= this.getyCoordinate()) {
                deltaY = this.getyCoordinate() - site.getyCoordinate();
            } else {
                deltaY =  site.getyCoordinate() - this.getyCoordinate();
            }

            if (deltaX > nearestSiteDeltaX) {
                this.nearestSite = site.getSiteId();
            }
        }
    }
}
