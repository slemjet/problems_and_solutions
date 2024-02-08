package pl.slemjet.katas.minperimeterrectangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinPerimeterRectangleTest {

    @Test
    void getMinPerimeter() {
        assertEquals(22, MinPerimeterRectangle.solution(30));
    }
}
