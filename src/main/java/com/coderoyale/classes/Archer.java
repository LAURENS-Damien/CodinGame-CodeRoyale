package com.coderoyale.classes;

public class Archer {
    final static public int COST = 100;
    public int PV = 45;
    final static public BarrackType BARRACK_TYPE = BarrackType.ARCHER;

    public int getPV() {
        return PV;
    }

    public void setPV(int PV) {
        this.PV = PV;
    }
}
