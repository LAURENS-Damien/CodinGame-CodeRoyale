package com.coderoyale.test;

import com.coderoyale.classes.BarrackType;
import com.coderoyale.classes.Commands;
import com.coderoyale.classes.Queen;
import com.coderoyale.classes.Site;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class QueenShould {

    private static List<Site> sites = new ArrayList<>();
    private static Queen queen = new Queen();

    @BeforeAll
    public static void initAll() {
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
        queen.setNearestEmptySite(sites);
        assertEquals(sites.get(1).getSiteId(), queen.getNearestEmptySite());
        queen.setxCoordinate(45);
        queen.setNearestEmptySite(sites);
        assertEquals(sites.get(0).getSiteId(), queen.getNearestEmptySite());
        queen.setxCoordinate(1800);
        queen.setNearestEmptySite(sites);
        assertEquals(sites.get(3).getSiteId(), queen.getNearestEmptySite());
    }

    @Test
    public void moveToNearestEmptySite() {
        queen.setxCoordinate(0);
        queen.setNearestEmptySite(sites);
        assertEquals(queen.moveToNearestEmptySite(sites), Commands.MOVE.toString() + " " + sites.get(queen.getNearestEmptySite()).getxCoordinate() + " " + sites.get(queen.getNearestEmptySite()).getyCoordinate());
    }

    @Test void launchBarrackConstruction() {
        assertEquals(queen.launchBarrackConstruction(BarrackType.ARCHER), Commands.BUILD.toString() + " " + queen.getNearestEmptySite() + " " + BarrackType.ARCHER);
        assertEquals(queen.launchBarrackConstruction(BarrackType.KNIGHT), Commands.BUILD.toString() + " " + queen.getNearestEmptySite() + " " + BarrackType.KNIGHT);
    }
}
