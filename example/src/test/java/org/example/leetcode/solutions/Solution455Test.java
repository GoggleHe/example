package org.example.leetcode.solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution455Test {

    private Solution455 solution = new Solution455();

    @ParameterizedTest
    @MethodSource("org.example.leetcode.solutions.Solution455Test#parameterProvider")
    void findContentChildren(int[] g, int[] s, int expect) {
        int cnt = solution.findContentChildren(g, s);
        assertEquals(expect, cnt);
    }

    static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 1}, 1),
                Arguments.of(new int[]{1, 2}, new int[]{1, 2, 3}, 2)
        );
    }
}
