package com.coderoyale.classes;

public class Queen {
    final static private int RADIUS = 30;
    final static private int MAX_MOUVEMENT = 60;
    final static private int PV = 100;
    private int gold;
    private int touchedId;
    private int xCoordinate;
    private int yCoordinate;
    private int nearestEmptySite;

    public int getTouchedId() {
        return touchedId;
    }

    public void setTouchedId(int touchedId) {
        this.touchedId = touchedId;
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

    public void setNearestEmptySite() {

        int deltaXMax = GameCard.XCoordinate.toInt();
        int deltaYMax = GameCard.YCoordinate.toInt();
        int deltaQueenXY = this.xCoordinate+this.yCoordinate;

        for (Site site : SiteUtil.getSites()) {
            if (site.isFree()) {
                int deltaX;
                int deltaY;
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

        System.err.println("Id du site le plus proche : " + this.nearestEmptySite);
    }

    public String moveToNearestEmptySite() {
        String moveCommand = Commands.MOVE.toString() + " " + SiteUtil.getSites().get(this.nearestEmptySite).getxCoordinate() + " " + SiteUtil.getSites().get(this.nearestEmptySite).getyCoordinate();
        System.out.println(moveCommand);

        return moveCommand;
    }

    public boolean isInContactWithSite() {
        return this.touchedId > -1 && this.touchedId == this.nearestEmptySite;
    }

    public String buildBarrack(BarrackType barrackType) {
        String buildCommand = "";
        try {
            SiteUtil.getSite(this.getTouchedId()).setBuilding(new Building(StructureType.Barrack.toInt(), barrackType, Owner.AlliedBuilding.toInt()));
            buildCommand = new StringBuilder().append(Commands.BUILD.toString()).append(" ").append(this.getTouchedId()).append(" ").append(barrackType.toString()).toString();
            System.out.println(buildCommand);
        } catch (NoSiteFoundException e) {
            System.err.println(e.getMessage());
        }

        return  buildCommand;
    }

    public String waitAMoment() {
        String waitCommand = Commands.WAIT.toString();
        System.out.println(waitCommand);

        return waitCommand;
    }

    public String trainArmy() {
        StringBuilder sitesId = new StringBuilder();
        for (int index=0; index < SiteUtil.getSites().size(); index++) {
            Site site = SiteUtil.getSites().get(index);
            //System.err.println("Le site numéro " + site.getSiteId() +  " possède une structure \nde type " + site.getBuilding().getStructureType());
            if (site.getBuilding().getBarrackType() == BarrackType.ARCHER && canTrain(site)) {
                //System.err.println("Le site numéro " + site.getSiteId() +  " peut entrainer : " + canTrain(site));
                this.setGold(this.getGold()-ArcherSection.ARCHERS_SECTION_COST);
                AlliedDashboard.archersSections.add(new ArcherSection());
                sitesId.append(" ").append(site.getSiteId());
            } else if (site.getBuilding().getBarrackType() == BarrackType.KNIGHT && canTrain(site) && AlliedDashboard.archersSections.size() > 0) {
                //System.err.println("Le site numéro " + site.getSiteId() +  " peut entrainer : " + canTrain(site));
                this.setGold(this.getGold()-KnightSection.KNIGHTS_SECTION_COST);
                AlliedDashboard.knightsSections.add(new KnightSection());
                sitesId.append(" ").append(site.getSiteId());
            }
        }
        String trainCommand = Commands.TRAIN.toString() + sitesId;
        System.out.println(trainCommand);

        return trainCommand;
    }


    public boolean canTrain(Site site) {
        if (site.getBuilding().getBarrackType().name().equals(BarrackType.KNIGHT.name())) {
            return this.gold >= KnightSection.KNIGHTS_SECTION_COST;
        } else if (site.getBuilding().getBarrackType().name().equals(BarrackType.ARCHER.name())) {
            return this.gold >= ArcherSection.ARCHERS_SECTION_COST;
        } else {
            return false;
        }
    }
}
