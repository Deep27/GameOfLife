package com.romanso.gameoflife;

import com.romanso.gameoflife.ds.Toroid;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ToroidSetByYTest {

    private Toroid<Integer> mToroid;

    @Before
    public void setUp() {

        mToroid = new Toroid<>(Integer.class, 5, 3);
        mToroid.setYData(0, 1, 2, 3, 4, 5);
        mToroid.setYData(1, 6, 7, 8, 9, 10);
        mToroid.setYData(2, 11, 12, 13, 14, 15);
        System.out.println("Toroid set by Y:\n" + mToroid);
    }

    @Test
    public void testGetY2() {

        ArrayList<Integer> testArray = new ArrayList<Integer>(5) {{
            add(11); add(12); add(13); add(14); add(15);
        }};
        ArrayList<Integer> actualArray = mToroid.getYData(2);

        System.out.println("Actual arr: " + actualArray);
        System.out.println("Test arr: " + testArray);

        assertTrue(actualArray.equals(testArray));
    }

    @Test
    public void testGetX3() {

        ArrayList<Integer> testArray = new ArrayList<Integer>(3) {{
            add(4); add(9); add(14);
        }};
        ArrayList<Integer> actualArray = mToroid.getXData(3);

        System.out.println("Actual arr: " + actualArray);
        System.out.println("Test arr: " + testArray);

        assertTrue(actualArray.equals(testArray));
    }

    @Test
    public void testGetY2X3() {

        int actualData = mToroid.get(2, 3);
        System.out.println("Toroid[2][3]: " + actualData);
        assertEquals(actualData, 14);
    }

    @Test
    public void testGetY5X15() {

        int actualData = mToroid.get(5, 14);
        System.out.println("Toroid[5][14]: " + actualData);
        assertEquals(actualData, 15);
    }
}