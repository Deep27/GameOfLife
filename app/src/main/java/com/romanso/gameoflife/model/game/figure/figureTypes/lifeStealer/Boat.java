package com.romanso.gameoflife.model.game.figure.figureTypes.lifeStealer;

public final class Boat<D> extends LifeStealer<D> {

    public Boat(Class<D> cellClass) {
        super(cellClass, 3, 3);
    }
}
