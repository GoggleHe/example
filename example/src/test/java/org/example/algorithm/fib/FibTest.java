package org.example.algorithm.fib;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibTest {

    private Fib fib = new Fib();

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void fib(int n) {
        int ans = fib.fib(n);
        assertEquals(validFib(n), ans);
    }


    int validFib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return validFib(n - 1) + validFib(n - 2);
    }
}
