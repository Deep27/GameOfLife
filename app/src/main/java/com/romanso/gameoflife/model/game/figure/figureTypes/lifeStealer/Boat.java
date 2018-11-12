package com.romanso.gameoflife.model.game.figure.figureTypes.lifeStealer;

import com.romanso.gameoflife.model.game.cell.Cell;

public final class Boat<D extends Cell> extends LifeStealer {

    public Boat(D deadCell, D liveCell) {
        super(deadCell, liveCell, 3, 3);
    }
}
