package org.example.unittest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleTest {

    @Test
    void getArea() {
        Rectangle rectangle = new Rectangle(3, 4);
        assertEquals(rectangle.getArea(), 3 * 4,"area not equals");
    }
}