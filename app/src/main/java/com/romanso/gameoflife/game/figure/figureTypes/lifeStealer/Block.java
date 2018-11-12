package com.romanso.gameoflife.game.figure.figureTypes.lifeStealer;

public final class Block<D> extends LifeStealer<D> {

    public Block(Class<D> cellClass) {
        super(cellClass, 2, 2);
    }
}
