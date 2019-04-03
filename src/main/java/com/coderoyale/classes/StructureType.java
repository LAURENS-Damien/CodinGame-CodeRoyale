package com.coderoyale.classes;

public enum StructureType {

    NoBuildingConstructed(-1),
    Barrack(2);

    private int structureType;

    StructureType(int structureType) {
        this.structureType = structureType;
    }

    public int toInt() {
        return structureType;
    }
}
