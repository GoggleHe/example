package org.example.unittest;

import java.util.Objects;

public class NumberHelper {
    public static final int ZERO = 0;

    public static boolean isPositive(Integer value) {
        return Objects.nonNull(value) && value > ZERO;
    }
}
