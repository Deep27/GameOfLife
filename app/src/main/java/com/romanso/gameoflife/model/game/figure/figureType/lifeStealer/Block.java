package com.romanso.gameoflife.model.game.figure.figureType.lifeStealer;

import com.romanso.gameoflife.model.game.cell.Cell;

public final class Block<D extends Cell> extends LifeStealer {

    public Block(D liveCell, D deadCell) {
        super(liveCell, deadCell, 2, 2);
        putLiveCell(0, 0);
        putLiveCell(0, 1);
        putLiveCell(1, 0);
        putLiveCell(1, 1);
    }
}
