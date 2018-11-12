package com.romanso.gameoflife.model.game.figure.figureTypes.spaceship;

import com.romanso.gameoflife.model.game.cell.Cell;

public final class LightweightSpaceship<D extends Cell> extends Spaceship {

    /**
     *  o x x o x
     *  x x x x o
     *  o x x x o
     *  x o o o o
     */
    public LightweightSpaceship(Cell liveCell, Cell deadCell) {
        super(liveCell, deadCell, 4, 5);
    }
}
