package com.romanso.gameoflife.game.figure.figureTypes.spaceship;

public final class LightweightSpaceship<D> extends Spaceship<D> {

    /**
     *  o x x o x
     *  x x x x o
     *  o x x x o
     *  x o o o o
     */
    public LightweightSpaceship(Class<D> cellClass) {
        super(cellClass, 4, 5);
    }
}
