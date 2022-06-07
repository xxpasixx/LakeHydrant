package de.pamLights.lakehydrant.modals.enums;

import java.util.Arrays;

public enum HydrantPosition {
    LANE("lane"),
    GREEN("green"),
    SIDEWALK("sidewalk"),
    PARKING_LOT("parking_lot");

    private final String value;

    private HydrantPosition(String value) {
        this.value = value;
    }

    /**
     * @return the Enum representation for the given string.
     * @throws IllegalArgumentException if unknown string.
     */
    public static HydrantPosition fromString(String s) throws IllegalArgumentException {
        return Arrays.stream(HydrantPosition.values())
                .filter(v -> v.value.equals(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown value: " + s));
    }
}
