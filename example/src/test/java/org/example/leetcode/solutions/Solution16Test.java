package org.example.leetcode.solutions;

import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution16Test {

    private Solution16 solution = new Solution16();

    @MethodSource("org.example.leetcode.solutions.Solution16Test#parameter")
    @ParameterizedTest(name = "target={1},expected={2},nums={0}")
    void threeSumClosest(int[] nums, int target, int expected, TestReporter testReporter) {
        int actual = solution.threeSumClosest(nums, target);

        Map<String, String> map = new HashMap<>();
        map.put("nums", Arrays.toString(nums));
        map.put("target", target + "");
        map.put("expected", expected + "");
        testReporter.publishEntry(map);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> parameter() {
        return Stream.of(
                Arguments.of(new int[]{-1, 2, 1, -4}, 1, 2),
                Arguments.of(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2, -2));
    }
}