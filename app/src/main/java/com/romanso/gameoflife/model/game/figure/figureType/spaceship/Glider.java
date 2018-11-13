package com.romanso.gameoflife.model.game.figure.figureType.spaceship;

import com.romanso.gameoflife.model.game.cell.Cell;

public final class Glider<D extends Cell> extends Spaceship {

    /**
     *  x x o
     *  o x o
     *  x o o
     */
    public Glider(D liveCell, D deadCell) {

        super(liveCell, deadCell, 3, 3);

        putLiveCell(0, 2);
        putLiveCell(1, 0);
        putLiveCell(1, 2);
        putLiveCell(2, 1);
        putLiveCell(2, 2);
    }
}
