package de.pamLights.lakehydrant.modals.enums;

import java.util.Arrays;

public enum WaterSource {
    LANE("main"),
    TUBE_WELL("tube_well"),
    WATER_WORKS("water_works"),
    TAP("tap"),
    GROUNDWATER("groundwater"),
    WATER_TANK("water_tank"),
    POND("pond"),
    POWERED_PUMP("powered_pump"),
    WELL("well"),
    RIVER("river"),
    STREAM("stream"),
    LAKE("lake");

    private final String value;

    private WaterSource(String value) {
        this.value = value;
    }

    /**
     * @return the Enum representation for the given string.
     * @throws IllegalArgumentException if unknown string.
     */
    public static WaterSource fromString(String s) throws IllegalArgumentException {
        return Arrays.stream(WaterSource.values())
                .filter(v -> v.value.equals(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown value: " + s));
    }
}
