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
}
