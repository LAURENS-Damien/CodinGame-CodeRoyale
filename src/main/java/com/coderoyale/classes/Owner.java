package com.coderoyale.classes;

public enum Owner {

    NoBuildingConstructed(-1),
    AlliedBuilding(0),
    EnnemyBuilding(1);

    private int owner;

    Owner(int owner) {
        this.owner = owner;
    }

    public int toInt() {
        return owner;
    }
}
