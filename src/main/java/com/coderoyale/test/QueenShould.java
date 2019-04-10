package com.coderoyale.test;

import com.coderoyale.classes.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class QueenShould {

    private static List<Site> sites = new ArrayList<>();
    private static Queen queen = new Queen();

    @BeforeEach
    public void initAll() {
        // Liste des sites
        sites = new ArrayList<>();
        sites.add(new Site(1, 50, 100, 50));
        sites.add(new Site(2, 10, 10, 50));
        sites.add(new Site(3, 584, 478, 50));
        sites.add(new Site(4, 1900, 896, 50));

        // Coordonnées d'origine de la reine
        queen.setxCoordinate(0);
    }

    @Test
    public void setNearestEmptySite() {
        queen.setxCoordinate(154);
        queen.setyCoordinate(253);
        sites.add(new Site(5, 154, 389, 64));
        sites.add(new Site(23, 223, 165, 75));
        queen.setNearestEmptySite(sites);
        assertEquals(sites.get(4).getSiteId(), queen.getNearestEmptySite());
        queen.setxCoordinate(45);
        queen.setNearestEmptySite(sites);
        assertEquals(sites.get(0).getSiteId(), queen.getNearestEmptySite());
        queen.setxCoordinate(1880);
        queen.setNearestEmptySite(sites);
        assertEquals(sites.get(3).getSiteId(), queen.getNearestEmptySite());
        queen.setxCoordinate(1714);
        queen.setNearestEmptySite(sites);
        assertEquals(sites.get(4).getSiteId(), queen.getNearestEmptySite());
    }

    @Test
    public void moveToNearestEmptySite() {
        queen.setxCoordinate(0);
        queen.setNearestEmptySite(sites);
        assertEquals(queen.moveToNearestEmptySite(sites), Commands.MOVE.toString() + " " + sites.get(queen.getNearestEmptySite()).getxCoordinate() + " " + sites.get(queen.getNearestEmptySite()).getyCoordinate());
        queen.setNearestEmptySite(sites);
        //assertEquals(queen.getxCoordinate(), sites.get(1).getxCoordinate());
    }

    @Test
    public void launchBarrackConstruction() {
        assertEquals(queen.buildBarrack(BarrackType.ARCHER, sites), Commands.BUILD.toString() + " " + queen.getNearestEmptySite() + " " + BarrackType.ARCHER);
        assertEquals(queen.buildBarrack(BarrackType.KNIGHT, sites), Commands.BUILD.toString() + " " + queen.getNearestEmptySite() + " " + BarrackType.KNIGHT);
    }

    @Test
    public void waitAMoment() {
        assertEquals(queen.waitAMoment(), Commands.WAIT.toString());
    }

    @Test
    void canTrainArmy() {
        queen.buildBarrack(BarrackType.ARCHER, sites);
        queen.setGold(Archer.COST);
        assertEquals(queen.canTrain(sites.get(queen.getNearestEmptySite())), true);
        queen.setGold(Archer.COST-1);
        assertEquals(queen.canTrain(sites.get(queen.getNearestEmptySite())), false);
    }

    @Test
    public void trainArmys() {
        sites.get(0).setBuilding(new Building(StructureType.Barrack.toInt(), BarrackType.ARCHER, Owner.AlliedBuilding.toInt()));
        sites.get(1).setBuilding(new Building(StructureType.Barrack.toInt(), BarrackType.KNIGHT, Owner.AlliedBuilding.toInt()));
        queen.setGold(300);
        assertEquals(queen.trainArmy(sites, archers, knights), Commands.TRAIN.toString() + " 1 2");
        queen.setGold(70);
        assertEquals(queen.trainArmy(sites, archers, knights), Commands.TRAIN.toString());
        queen.setGold(170);
        assertEquals(queen.trainArmy(sites, archers, knights), Commands.TRAIN.toString() + " 1");
    }
}
