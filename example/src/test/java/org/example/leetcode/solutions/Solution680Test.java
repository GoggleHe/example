package org.example.leetcode.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution680Test {

    private Solution680 solution = new Solution680();

    @ParameterizedTest
    @MethodSource("org.example.leetcode.solutions.Solution680Test#parameterProvider")
    void validPalindrome(String s, boolean expected) {
        boolean actual = solution.validPalindrome(s);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.of("aba", true),
                Arguments.of("abca", true),
                Arguments.of("abc", false)
        );
    }


}
