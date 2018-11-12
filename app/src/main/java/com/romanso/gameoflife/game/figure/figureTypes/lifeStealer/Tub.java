package com.romanso.gameoflife.game.figure.figureTypes.lifeStealer;

public final class Tub<D> extends LifeStealer<D> {

    public Tub(Class<D> cellClass) {
        super(cellClass, 3, 3);
    }
}
