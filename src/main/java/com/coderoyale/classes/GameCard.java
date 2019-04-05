package com.coderoyale.classes;

public enum GameCard {

    XCoordinate(1920),
    YCoordinate(1000);

    private int unity;

    GameCard(int unity) {
        this.unity = unity;
    }

    public int toInt() {
        return unity;
    }
}
