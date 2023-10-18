package org.example.unittest;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OrderedTestsDemo {
    @Test
    @Order(1)
    void nullValues() {
        // perform assertions against null values
        System.out.println(1);
    }

    @Test
    @Order(2)
    void emptyValues() {
        // perform assertions against empty values
        System.out.println(2);
    }

    @Test
    @Order(3)
    void validValues() {
        // perform assertions against valid values
        System.out.println(3);
    }
}
