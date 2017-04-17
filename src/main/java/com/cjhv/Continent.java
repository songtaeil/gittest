package com.cjhv;

public enum Continent {

    EUROPE("Europe - paris"),
    ASIA("Asia - korea - pusan"),
    AFRICA("Africa - somalia"),
    SOUTH_AMERICA("South America - washingtone"),
    NORTH_AMERICA("North America"),
    AUSTRALIA_OCEANIA("Australia and Oceania");
    private String label;

    Continent(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}