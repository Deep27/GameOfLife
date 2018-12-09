package io.deep27soft.gameoflife.model.game.figure.figureType.lifeStealer;

import io.deep27soft.gameoflife.model.game.cell.Cell;

public final class Block<D extends Cell> extends LifeStealer {

    public Block(D liveCell, D deadCell) {
        super(liveCell, deadCell, 2, 2);
        putLiveCell(0, 0);
        putLiveCell(0, 1);
        putLiveCell(1, 0);
        putLiveCell(1, 1);
    }
}
