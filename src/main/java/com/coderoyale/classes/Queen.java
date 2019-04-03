package com.coderoyale.classes;

import org.junit.platform.commons.util.StringUtils;

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
        return this.nearestEmptySite;
    }

    public void setNearestEmptySite(List<Site> sites) {

        int deltaXMax = GameCard.XCoordinate.toInt();

        for (Site site : sites) {
            if (site.isFree()) {
                int deltaX;
                // On détermine la coordonnée X la plus proche
                if (site.getxCoordinate() <= this.getxCoordinate()) {
                    deltaX = this.getxCoordinate() - site.getxCoordinate();
                } else {
                    deltaX =  site.getxCoordinate() - this.getxCoordinate();
                }

                if (deltaX < deltaXMax) {
                    this.nearestEmptySite = site.getSiteId();
                    deltaXMax = deltaX;
                }
            }
        }
    }

    public String moveToNearestEmptySite(List<Site> sites) {
        String moveCommand = Commands.MOVE.toString() + " " + sites.get(this.nearestEmptySite).getxCoordinate() + " " + sites.get(this.nearestEmptySite).getyCoordinate();
        System.out.println(moveCommand);

        return moveCommand;
    }

    public boolean isInContactWithSite() {
        return this.touchedId < 0;
    }

    public String launchBarrackConstruction() {
        String moveCommand = Commands.BUILD.toString() + " " + this.getNearestEmptySite() + " " + BarrackType.ARCHER;
        System.out.println(moveCommand);

        return  moveCommand;
    }
}
