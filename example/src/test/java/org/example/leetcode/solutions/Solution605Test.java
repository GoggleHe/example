package org.example.leetcode.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution605Test {

    private Solution605 solution = new Solution605();

    @ParameterizedTest
    @MethodSource("org.example.leetcode.solutions.Solution605Test#parameterProvider")
    void canPlaceFlowers1(int[] flowerbed, int n, boolean expected) {
        boolean actual = solution.canPlaceFlowers1(flowerbed, n);
        assertEquals(expected, actual);


    }

    @ParameterizedTest
    @MethodSource("org.example.leetcode.solutions.Solution605Test#parameterProvider")
    void canPlaceFlowers2(int[] flowerbed, int n, boolean expected) {
        boolean actual = solution.canPlaceFlowers2(flowerbed, n);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 0, 0, 0, 1}, 1, true),
                Arguments.of(new int[]{1, 0, 0, 0, 1}, 2, false)
        );
    }
}
