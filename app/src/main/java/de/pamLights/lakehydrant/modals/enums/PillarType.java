package de.pamLights.lakehydrant.modals.enums;

import java.util.Arrays;

public enum PillarType {
    DRY("dry_barrel"),
    WET("wet_barrel");

    public final String value;

    PillarType(String value) {
        this.value = value;
    }

    /**
     * @return the Enum representation for the given string.
     * @throws IllegalArgumentException if unknown string.
     */
    public static PillarType fromString(String s) throws IllegalArgumentException {
        return Arrays.stream(PillarType.values())
                .filter(v -> v.value.equals(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown value: " + s));
    }
}
