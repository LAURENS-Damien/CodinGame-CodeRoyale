package com.coderoyale.classes;

public class Building {
    private int structureType;
    private int owner;

    public Building(int structureType, int owner) {
        this.structureType = structureType;
        this.owner = owner;
    }

    public int getStructureType() {
        return structureType;
    }

    public void setStructureType(int structureType) {
        this.structureType = structureType;
    }
}
