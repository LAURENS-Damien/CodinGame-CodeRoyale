package com.coderoyale.classes;

import java.util.List;
import java.util.stream.Collectors;

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
        return this.touchedId > -1;
    }

    public String buildBarrack(BarrackType barrackType) {
        String moveCommand = Commands.BUILD.toString() + " " + this.getNearestEmptySite() + " " + barrackType.toString();
        System.out.println(moveCommand);

        return  moveCommand;
    }

    public boolean canBuild(BarrackType barrackType) {
        if (barrackType.name().equals(BarrackType.KNIGHT.name())) {
            return this.gold >= Knight.COST;
        } else if (barrackType.name().equals(BarrackType.ARCHER.name())) {
            return this.gold >= Archer.COST;
        } else {
            return false;
        }
    }

    public String waitAMoment() {
        String waitCommand = Commands.WAIT.toString();
        System.out.println(waitCommand);

        return waitCommand;
    }

    public String trainArmy(List<Site> sites) {
        StringBuilder sitesId = new StringBuilder();
        for (int index=0; index < sites.size(); index++) {
            Site site = sites.get(index);
            System.err.println("Le site numéro " + site.getSiteId() +  " possède une structure de type " + site.getBuilding().getStructureType());
            if (site.getBuilding().getStructureType() != StructureType.NoBuildingConstructed.toInt()) {
                sitesId.append(" ").append(site.getSiteId());
            }
        }
        String trainCommand = Commands.TRAIN.toString() + sitesId;
        //String trainCommand = Commands.TRAIN.toString() + " " + this.getNearestEmptySite();
        System.out.println(trainCommand);

        return trainCommand;
    }
}
