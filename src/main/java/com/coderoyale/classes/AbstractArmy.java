package com.coderoyale.classes;

public abstract class AbstractArmy {

    static public BarrackType BARRACK_TYPE;
    static public int PV;

    public AbstractArmy(BarrackType barrackType, int Pv) {
        BARRACK_TYPE = barrackType;
        PV = Pv;
    }
}
