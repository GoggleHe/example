package org.example.algorithm.sort.quick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class QuickSorterTest {

    @ParameterizedTest
    @MethodSource("org.example.algorithm.sort.quick.QuickSorterTest#parameterProvider")
    void sort(int[] ints) {
        QuickSorter quickSorter = new QuickSorter();
        quickSorter.sort(ints);
        System.out.println(Arrays.toString(ints));

        int[] newInts = Arrays.copyOf(ints, ints.length);
        Arrays.sort(newInts);

        Assertions.assertArrayEquals(ints, newInts);

    }

    static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}),
                Arguments.of(new int[]{5, 3, 10, 56, 6, 17, 3, 2, 9})
        );
    }
}
