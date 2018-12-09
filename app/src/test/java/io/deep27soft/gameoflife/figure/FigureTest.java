package io.deep27soft.gameoflife.figure;

import io.deep27soft.gameoflife.model.game.cell.BooleanCell;
import io.deep27soft.gameoflife.model.game.figure.figureType.spaceship.Glider;

import org.junit.Test;

public class FigureTest {

    @Test
    public void testGliderFigure() {

        Glider<BooleanCell> glider = new Glider<>(new BooleanCell(true), new BooleanCell(false));
        System.out.println(glider);
    }
}
