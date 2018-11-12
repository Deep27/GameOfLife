package com.romanso.gameoflife.model.game.figure.figureTypes.lifeStealer;

public final class Tub<D> extends LifeStealer<D> {

    public Tub(Class<D> cellClass) {
        super(cellClass, 3, 3);
    }
}
