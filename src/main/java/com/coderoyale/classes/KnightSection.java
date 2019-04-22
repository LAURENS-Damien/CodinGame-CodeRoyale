package com.coderoyale.classes;

public class KnightSection extends AbstractSection {

    public KnightSection() {
        for(int i = 0; i < KNIGHTS_SECTION_NUMBER; i++) {
            section.add(new Knight());
        }
    }
}
