package com.romanso.gameoflife.game.figure.figureTypes.spaceship;

public final class Glider<D> extends Spaceship<D> {

    /**
     *  x x o
     *  o x o
     *  x o o
     */
    public Glider(Class<D> cellClass) {
        super(cellClass, 3, 3);
    }
}
