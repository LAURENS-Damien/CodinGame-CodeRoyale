package com.coderoyale.classes;

public class Building {
    private int structureType;
    private BarrackType barrackType;
    private int owner;

    public Building(int structureType, BarrackType barrackType, int owner) {
        this.structureType = structureType;
        this.barrackType = barrackType;
        this.owner = owner;
    }

    public int getStructureType() {
        return structureType;
    }

    public void setStructureType(int structureType) {
        this.structureType = structureType;
    }

    public BarrackType getBarrackType() {
        return barrackType;
    }

    public int getCost() {
        if(barrackType.toString().equals(Archer.BARRACK_TYPE.toString())) {
            return Archer.COST;
        } else if(barrackType.toString().equals(Knight.BARRACK_TYPE.toString())) {
            return Knight.COST;
        } else {
            return 0;
        }
    }
}
