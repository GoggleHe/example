package org.example.algorithm.sort.bubble;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class BubbleSorterTest {

    @ParameterizedTest
    @MethodSource("org.example.algorithm.sort.bubble.BubbleSorterTest#parameterProvider")
    void sort(int[] ints) {
        BubbleSorter bubbleSorter = new BubbleSorter();
        bubbleSorter.sort(ints);

        int[] sorted = Arrays.copyOf(ints, ints.length);
        Arrays.sort(sorted);

        Assertions.assertArrayEquals(sorted, ints);
    }

    static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}),
                Arguments.of(new int[]{5, 3, 10, 56, 6, 17, 3, 2, 9})
        );
    }
}
