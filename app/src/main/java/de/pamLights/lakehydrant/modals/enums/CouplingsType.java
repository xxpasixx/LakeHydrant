package de.pamLights.lakehydrant.modals.enums;

import java.util.Arrays;

public enum CouplingsType {
    STORZ("Storz"),
    UNI("uni");

    private final String value;

    private CouplingsType(String value) {
        this.value = value;
    }

    /**
     * @return the Enum representation for the given string.
     * @throws IllegalArgumentException if unknown string.
     */
    public static CouplingsType fromString(String s) throws IllegalArgumentException {
        return Arrays.stream(CouplingsType.values())
                .filter(v -> v.value.equals(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown value: " + s));
    }
}
