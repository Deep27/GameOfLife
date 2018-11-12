package com.romanso.gameoflife.game.figure.figureTypes.lifeStealer;

public final class Loaf<D> extends LifeStealer<D> {

    public Loaf(Class<D> cellClass) {
        super(cellClass, 4, 4);
    }
}
