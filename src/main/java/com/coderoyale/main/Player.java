package com.coderoyale.main;

import com.coderoyale.classes.ActiveUnity;
import com.coderoyale.classes.Queen;
import com.coderoyale.classes.Site;

import java.util.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int numSites = in.nextInt();

        // Initilisation
        List<Site> sites = new ArrayList<>();
        for (int i = 0; i < numSites; i++) {
            int siteId = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int radius = in.nextInt();
            Site site = new Site(siteId, x, y, radius);
            sites.add(site);
        }
        Queen queen = new Queen();
        // game loop
        while (true) {
            int gold = in.nextInt();
            int touchedSite = in.nextInt(); // -1 if none
            queen.setGold(gold);
            queen.setTouchedId(touchedSite);
            for (int i = 0; i < numSites; i++) {
                int siteId = in.nextInt();
                int ignore1 = in.nextInt(); // used in future leagues
                int ignore2 = in.nextInt(); // used in future leagues
                int structureType = in.nextInt(); // -1 = No structure, 2 = Barracks
                int owner = in.nextInt(); // -1 = No structure, 0 = Friendly, 1 = Enemy
                int param1 = in.nextInt();
                int param2 = in.nextInt();
            }
            int numUnits = in.nextInt();
            for (int i = 0; i < numUnits; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                int owner = in.nextInt();
                int unitType = in.nextInt(); // -1 = QUEEN, 0 = KNIGHT, 1 = ARCHER
                int health = in.nextInt();
                ActiveUnity activeUnity = new ActiveUnity(x, y, owner, unitType, health);
                if (activeUnity.isAlliedQueen()) {
                    System.err.println("Position actuelle de la reine " + unitType + " : x :" + x + " et y : " + y);
                    queen.setxCoordinate(x);
                    queen.setyCoordinate(y);
                }
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            // First line: A valid queen action
            // Second line: A set of training instructions
            //System.out.println("WAIT");
            System.out.println("MOVE " + (queen.getxCoordinate()+30) + " " + (queen.getyCoordinate()+30));
            System.out.println("TRAIN");
        }
    }
}