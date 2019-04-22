package com.coderoyale.classes;

public class ArcherSection extends AbstractSection {

    public ArcherSection() {
        for(int i = 0; i < ARCHERS_SECTION_NUMBER; i++) {
            section.add(new Archer());
        }
    }
}
