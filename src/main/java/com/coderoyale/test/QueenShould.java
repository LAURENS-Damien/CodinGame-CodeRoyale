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
        sites.add(new Site(5, 154, 389, 64));
        sites.add(new Site(6, 223, 165, 75));
        SiteUtil.setSites(sites);

        // On réinitialise les sections de chevaliers et d'archés
        AlliedDashboard.knightsSections.clear();
        AlliedDashboard.archersSections.clear();

        // Coordonnées d'origine de la reine
        queen.setxCoordinate(0);
    }

    @Test
    public void setNearestEmptySite() {
        queen.setxCoordinate(154);
        queen.setyCoordinate(253);
        queen.setNearestEmptySite();
        assertEquals(SiteUtil.getSites().get(4).getSiteId(), queen.getNearestEmptySite());
        queen.setxCoordinate(45);
        queen.setyCoordinate(120);
        queen.setNearestEmptySite();
        assertEquals(SiteUtil.getSites().get(0).getSiteId(), queen.getNearestEmptySite());
        queen.setxCoordinate(1880);
        queen.setyCoordinate(900);
        queen.setNearestEmptySite();
        assertEquals(SiteUtil.getSites().get(3).getSiteId(), queen.getNearestEmptySite());
    }

    @Test
    public void moveToNearestEmptySite() {
        queen.setxCoordinate(0);
        queen.setyCoordinate(0);
        queen.setNearestEmptySite();
        assertEquals(queen.moveToNearestEmptySite(), Commands.MOVE.toString() + " " + SiteUtil.getSites().get(queen.getNearestEmptySite()).getxCoordinate() + " " + SiteUtil.getSites().get(queen.getNearestEmptySite()).getyCoordinate());
        queen.setxCoordinate(789);
        queen.setyCoordinate(100);
        queen.setNearestEmptySite();
        assertEquals(queen.moveToNearestEmptySite(), Commands.MOVE.toString() + " " + SiteUtil.getSites().get(queen.getNearestEmptySite()).getxCoordinate() + " " + SiteUtil.getSites().get(queen.getNearestEmptySite()).getyCoordinate());
    }

    @Test
    public void launchBarrackConstruction() {
        queen.setTouchedId(1);
        assertEquals(queen.buildBarrack(BarrackType.ARCHER), Commands.BUILD.toString() + " " + queen.getTouchedId() + " " + BarrackType.ARCHER);
        queen.setTouchedId(2);
        assertEquals(queen.buildBarrack(BarrackType.KNIGHT), Commands.BUILD.toString() + " " + queen.getTouchedId() + " " + BarrackType.KNIGHT);
    }

    @Test
    public void waitAMoment() {
        assertEquals(queen.waitAMoment(), Commands.WAIT.toString());
    }

    @Test
    void canTrainArmy() {
        // Assez d'argent pour contruire une armée d'archés
        queen.setGold(ArcherSection.ARCHERS_SECTION_COST);
        queen.setTouchedId(1);
        queen.buildBarrack(BarrackType.ARCHER);
        try {
            assertEquals(queen.canTrain(SiteUtil.getSite(queen.getTouchedId())), true);
        } catch (NoSiteFoundException e) {
            System.err.println(e.getMessage());
        }

        // Pas assez d'argent pour construire une armée d'archés
        queen.setGold(ArcherSection.ARCHERS_SECTION_COST-1);
        try {
            assertEquals(queen.canTrain(SiteUtil.getSite(queen.getTouchedId())), false);
        } catch (NoSiteFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void trainArmys() {
        try {
            SiteUtil.getSite(1).setBuilding(new Building(StructureType.Barrack.toInt(), BarrackType.ARCHER, Owner.AlliedBuilding.toInt()));
            SiteUtil.getSite(2).setBuilding(new Building(StructureType.Barrack.toInt(), BarrackType.KNIGHT, Owner.AlliedBuilding.toInt()));
        } catch (NoSiteFoundException e) {
            System.err.println(e.getMessage());
        }
        queen.setGold(300);
        assertEquals(queen.trainArmy(), Commands.TRAIN.toString() + " 1 2");
        assertEquals(AlliedDashboard.knightsSections.size(), 1);
        assertEquals(AlliedDashboard.archersSections.size(), 1);
        queen.setGold(70);
        assertEquals(queen.trainArmy(), Commands.TRAIN.toString());
        assertEquals(AlliedDashboard.knightsSections.size(), 1);
        assertEquals(AlliedDashboard.archersSections.size(), 1);
        queen.setGold(KnightSection.KNIGHTS_SECTION_COST);
        assertEquals(queen.trainArmy(), Commands.TRAIN.toString() + " 2");
        assertEquals(AlliedDashboard.knightsSections.size(), 2);
        assertEquals(AlliedDashboard.archersSections.size(), 1);
    }
}
