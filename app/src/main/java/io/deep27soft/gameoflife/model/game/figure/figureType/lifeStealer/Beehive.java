package io.deep27soft.gameoflife.model.game.figure.figureType.lifeStealer;

import io.deep27soft.gameoflife.model.game.cell.Cell;

public final class Beehive<D extends Cell> extends LifeStealer {

    public Beehive(D deadCell, D liveCell) {
        super(deadCell, liveCell, 3, 4);
    }
}
