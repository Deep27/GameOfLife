package io.deep27soft.gameoflife.toroid;

import io.deep27soft.gameoflife.model.ds.Toroid;

import org.junit.Before;
import org.junit.Test;

public class HandleXY {

    private Toroid<Integer> mToroid;

    @Before
    public void setUp() {
        mToroid = new Toroid<>(10, 10);
    }

    @Test
    public void testHandleY() {
        System.out.println("10\t" + mToroid.handleY(10));
        System.out.println("1\t" + mToroid.handleY(1));
        System.out.println("-2\t" + mToroid.handleY(-2));
        System.out.println("23\t" + mToroid.handleY(23));
        System.out.println("-23\t" + mToroid.handleY(-23));
    }
}
