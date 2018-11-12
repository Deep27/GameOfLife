package com.romanso.gameoflife.model.game.figure.figureTypes.lifeStealer;

import com.romanso.gameoflife.model.game.cell.Cell;

public final class Loaf<D extends Cell> extends LifeStealer {

    public Loaf(D deadCell, D liveCell, int y, int x) {
        super(deadCell, liveCell, 4, 4);
    }
}
