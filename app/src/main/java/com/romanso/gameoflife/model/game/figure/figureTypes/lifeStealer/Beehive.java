package com.romanso.gameoflife.model.game.figure.figureTypes.lifeStealer;

public final class Beehive<D> extends LifeStealer<D> {

    public Beehive(Class<D> cellClass) {
        super(cellClass, 3, 4);
    }
}
