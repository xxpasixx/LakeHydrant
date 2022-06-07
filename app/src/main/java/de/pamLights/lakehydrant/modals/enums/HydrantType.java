package de.pamLights.lakehydrant.modals.enums;

import java.util.Arrays;

public enum HydrantType {
    UNDERGROUND("underground"),
    PILLAR("pillar"),
    PIPE("pipe"),
    WALL("wall");

    private final String value;

    HydrantType(String value) {
        this.value = value;
    }

    /**
     * @return the Enum representation for the given string.
     * @throws IllegalArgumentException if unknown string.
     */
    public static HydrantType fromString(String s) throws IllegalArgumentException {
        return Arrays.stream(HydrantType.values())
                .filter(v -> v.value.equals(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown value: " + s));
    }
}
