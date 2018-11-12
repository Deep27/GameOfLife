package com.romanso.gameoflife.model.game.figure.figureTypes.lifeStealer;

public final class Block<D> extends LifeStealer<D> {

    public Block(Class<D> cellClass) {
        super(cellClass, 2, 2);
    }
}
