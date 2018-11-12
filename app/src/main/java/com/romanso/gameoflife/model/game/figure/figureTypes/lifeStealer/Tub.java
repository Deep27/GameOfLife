package com.romanso.gameoflife.model.game.figure.figureTypes.lifeStealer;

import com.romanso.gameoflife.model.game.cell.Cell;

public final class Tub<D extends Cell> extends LifeStealer {

    public Tub(D deadCell, D liveCell, int y, int x) {
        super(deadCell, liveCell, 3, 3);
    }
}
