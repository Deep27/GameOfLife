package io.deep27soft.gameoflife.model.game.figure.figureType.lifeStealer;

import io.deep27soft.gameoflife.model.game.cell.Cell;

public final class Loaf<D extends Cell> extends LifeStealer {

    public Loaf(D deadCell, D liveCell, int y, int x) {
        super(deadCell, liveCell, 4, 4);
    }
}
