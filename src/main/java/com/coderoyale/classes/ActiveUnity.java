package com.coderoyale.classes;

public class ActiveUnity {
    private int xCoordinate;
    private int yCoordinate;
    private int owner;
    private int unitType;
    private int health;

    public ActiveUnity(int xCoordinate, int yCoordinate, int owner, int unitType, int health) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.owner = owner;
        this.unitType = unitType;
        this.health = health;
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

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getUnitType() {
        return unitType;
    }

    public void setUnitType(int unitType) {
        this.unitType = unitType;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlliedQueen() {
        return unitType==-1 && owner==0;
    }
}
