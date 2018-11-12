package com.romanso.gameoflife.figure;

import com.romanso.gameoflife.model.game.cell.BooleanCell;
import com.romanso.gameoflife.model.game.figure.figureTypes.spaceship.Glider;

import org.junit.Test;

public class FigureTest {

    @Test
    public void testGliderFigure() {

        Glider<BooleanCell> glider = new Glider<>(new BooleanCell(true), new BooleanCell(false));
        System.out.println(glider);
    }
}
