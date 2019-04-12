package com.coderoyale.main;

import com.coderoyale.classes.*;

import java.util.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int numSites = in.nextInt();

        // Initilisation
        List<Site> sites = new ArrayList<>();
        List<Archer> archers = new ArrayList<>();
        List<Knight> knights = new ArrayList<>();
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
                    queen.setxCoordinate(x);
                    queen.setyCoordinate(y);
                    queen.setNearestEmptySite(sites);
                }

                if (activeUnity.isAlliedKnight()) {
                    //System.err.println("Santé des chevaliers : " + activeUnity.getHealth());
                }

                if (activeUnity.isAlliedArcher()) {
//                    for (Archer archer : archers) {
//                        System.err.println("Nombre d'archés : " + archers.size());
//                        if (activeUnity.getHealth() == 1) {
//                            archers.remove(archer);
//                            System.err.println("On supprime les archés");
//                        } else {
//                            System.err.println("Santé des archés : " + activeUnity.getHealth());
//                        }
//                    }
                    if (activeUnity.getHealth() == 1) {
                        archers.clear();
                    }
                }
            }

            // Si on est arrivé sur un site à construire
            if (queen.isInContactWithSite() && sites.get(queen.getTouchedId()).isFree()) {
//                System.err.println("On est arrivé sur un\nsite à construire : " + queen.getTouchedId());
//                System.err.println("Nombre de chevaliers : " + knights.size());
//                System.err.println("Nombre d'archers : " + archers.size());
                // On construit une caserne
                // D'archés en priorité
                if (archers.size() <1) {
                    System.err.println("On construit un arché");
                    queen.buildBarrack(BarrackType.ARCHER, sites);
                    archers.add(new Archer());
                    archers.add(new Archer());
                    sites.get(queen.getTouchedId()).setBuilding(new Building(StructureType.Barrack.toInt(), BarrackType.ARCHER, Owner.AlliedBuilding.toInt()));
                // Sinon de chevaliers
                } else if (knights.size() < 2) {
                    System.err.println("On construit un chevalier");
                    queen.buildBarrack(BarrackType.KNIGHT, sites);
                    knights.add(new Knight());
                    sites.get(queen.getTouchedId()).setBuilding(new Building(StructureType.Barrack.toInt(), BarrackType.KNIGHT, Owner.AlliedBuilding.toInt()));
                // Sinon on attend
                } else {
                    System.err.println("On attend");
                    queen.waitAMoment();
                }
            // sinon on bouge tant que l'on a pas atteint un site
            } else {
                System.err.println("On bouge vers le site\nnuméro : " + queen.getNearestEmptySite());
                queen.setNearestEmptySite(sites);
                queen.moveToNearestEmptySite(sites);
            }

            // On entraine des unités
            queen.trainArmy(sites, archers, knights);
        }
    }
}
