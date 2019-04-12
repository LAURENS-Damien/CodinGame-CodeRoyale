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
        return this.nearestEmptySite;
    }

    public void setNearestEmptySite(List<Site> sites) {

        int deltaXMax = GameCard.XCoordinate.toInt();
        int deltaYMax = GameCard.YCoordinate.toInt();
        int deltaQueenXY = this.xCoordinate+this.yCoordinate;

        for (Site site : sites) {
            if (site.isFree()) {
                int deltaX = site.getxCoordinate();
                int deltaY = site.getyCoordinate();
                // On détermine le site le plus proche
                if (site.getxCoordinate() <= this.getxCoordinate()) {
                    deltaX = this.getxCoordinate() - site.getxCoordinate();
                } else {
                    deltaX =  site.getxCoordinate() - this.getxCoordinate();
                }

                if (site.getyCoordinate() <= this.getyCoordinate()) {
                    deltaY = this.getyCoordinate() - site.getyCoordinate();
                } else {
                    deltaY =  site.getyCoordinate() - this.getyCoordinate();
                }

                int deltaSiteXY = deltaX+deltaY;

                if (deltaSiteXY < deltaXMax) {
                    this.nearestEmptySite = site.getSiteId();
                    deltaXMax = deltaSiteXY;
                }
            }
        }

        System.err.println("Voici l'id du site le plus proche : " + this.nearestEmptySite);
    }

    public String moveToNearestEmptySite(List<Site> sites) {
        String moveCommand = Commands.MOVE.toString() + " " + sites.get(this.nearestEmptySite).getxCoordinate() + " " + sites.get(this.nearestEmptySite).getyCoordinate();
        System.out.println(moveCommand);

        return moveCommand;
    }

    public boolean isInContactWithSite() {
        return this.touchedId > -1 && this.touchedId == this.nearestEmptySite;
    }

    public String buildBarrack(BarrackType barrackType, List<Site> sites) {
        String buildCommand = Commands.BUILD.toString() + " " + this.getTouchedId() + " " + barrackType.toString();
        sites.get(this.getTouchedId()).setBuilding(new Building(StructureType.Barrack.toInt(), barrackType, Owner.AlliedBuilding.toInt()));
        System.out.println(buildCommand);

        return  buildCommand;
    }

    public String waitAMoment() {
        String waitCommand = Commands.WAIT.toString();
        System.out.println(waitCommand);

        return waitCommand;
    }

    public String trainArmy(List<Site> sites, List<Archer> archers, List<Knight> knights) {
        StringBuilder sitesId = new StringBuilder();
        for (int index=0; index < sites.size(); index++) {
            Site site = sites.get(index);
            //System.err.println("Le site numéro " + site.getSiteId() +  " possède une structure \nde type " + site.getBuilding().getStructureType());
            if (site.getBuilding().getBarrackType() == BarrackType.ARCHER && canTrain(site)) {
                System.err.println("Le site numéro " + site.getSiteId() +  " peut entrainer : " + canTrain(site));
                sitesId.append(" ").append(site.getSiteId());
                this.setGold(this.getGold()-site.getBuilding().getCost());
            } else if (site.getBuilding().getBarrackType() == BarrackType.KNIGHT && canTrain(site) && archers.size() > 0) {
                System.err.println("Le site numéro " + site.getSiteId() +  " peut entrainer : " + canTrain(site));
                sitesId.append(" ").append(site.getSiteId());
                this.setGold(this.getGold()-site.getBuilding().getCost());
            }
        }
        String trainCommand = Commands.TRAIN.toString() + sitesId;
        //String trainCommand = Commands.TRAIN.toString() + " " + this.getNearestEmptySite();
        System.out.println(trainCommand);

        return trainCommand;
    }


    public boolean canTrain(Site site) {
        if (site.getBuilding().getBarrackType().name().equals(BarrackType.KNIGHT.name())) {
            return this.gold >= Knight.COST;
        } else if (site.getBuilding().getBarrackType().name().equals(BarrackType.ARCHER.name())) {
            return this.gold >= Archer.COST;
        } else {
            return false;
        }
    }
}
