package de.pamLights.lakehydrant.modals.enums;

import java.util.Arrays;

public enum AwwaClass {
    AA("aa"),
    A("a"),
    B("b"),
    C("c");

    private final String value;

    private AwwaClass(String value) {
        this.value = value;
    }

    /**
     * @return the Enum representation for the given string.
     * @throws IllegalArgumentException if unknown string.
     */
    public static AwwaClass fromString(String s) throws IllegalArgumentException {
        return Arrays.stream(AwwaClass.values())
                .filter(v -> v.value.equals(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown value: " + s));
    }
}
