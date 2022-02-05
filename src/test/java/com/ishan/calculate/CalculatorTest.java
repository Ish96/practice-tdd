package com.ishan.calculate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testSample(){
        Calculate c = new Calculate();
        int actualResult = c.add("1,2");
        int expectedResult = 3;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testSample2(){
        Calculate c = new Calculate();
        int actualResult = c.add("1");
        int expectedResult = 1;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testSample3(){
        Calculate c = new Calculate();
        int actualResult = c.add("");
        int expectedResult = 0;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testSample4(){
        Calculate c = new Calculate();
        int actualResult = c.add("1,2,3,4,5,6,7,8,9,10");
        int expectedResult = 55;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testSample5(){
        Calculate c = new Calculate();
        int actualResult = c.add("//;\n1;2");
        int expectedResult = 3;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testSample6(){
        Calculate c = new Calculate();
        int actualResult = c.add("1\n2,2");
        int expectedResult = 5;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testSample7() {
        Calculate c = new Calculate();
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> c.add("-1\n-22,2"), "negatives not allowed -1");
        assertEquals(runtimeException.getMessage(), "negatives not allowed -1,-22");
    }

    @Test
    public void testSample8(){
        Calculate c =new Calculate();
        RuntimeException exception = assertThrows(RuntimeException.class, ()->c.add("1,\\n"));
        assertEquals(exception.getMessage(), "Not valid String");
    }
}
