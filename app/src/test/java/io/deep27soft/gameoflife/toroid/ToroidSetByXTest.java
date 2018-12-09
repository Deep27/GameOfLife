package io.deep27soft.gameoflife.toroid;

import io.deep27soft.gameoflife.model.ds.Toroid;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ToroidSetByXTest {

    private Toroid<Integer> mToroid;

    @Before
    public void setUp() {

        mToroid = new Toroid<>(5, 3);
        mToroid.setXData(0, 1, 2, 3);
        mToroid.setXData(1, 4, 5, 6);
        mToroid.setXData(2, 7, 8, 9);
        mToroid.setXData(3, 10, 11, 12);
        mToroid.setXData(4, 13, 14, 15);
        System.out.println("Toroid set by X:\n" + mToroid);
    }

    @Test
    public void testGetY2() {

        ArrayList<Integer> testArray = new ArrayList<Integer>(5) {{
            add(3); add(6); add(9); add(12); add(15);
        }};
        ArrayList<Integer> actualArray = mToroid.getYData(2);

        System.out.println("Actual arr: " + actualArray);
        System.out.println("Test arr: " + testArray);

        assertTrue(actualArray.equals(testArray));
    }

    @Test
    public void testGetX3() {

        ArrayList<Integer> testArray = new ArrayList<Integer>(3) {{
            add(10); add(11); add(12);
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
        assertEquals(actualData, 12);
    }

    @Test
    public void testGetY5X15() {

        int actualData = mToroid.get(5, 14);
        System.out.println("Toroid[5][14]: " + actualData);
        assertEquals(actualData, 15);
    }
}
