package com.romanso.gameoflife.model.game.figure.figureTypes.spaceship;

public final class LightweightSpaceship<D> extends Spaceship<D> {

    /**
     *  o x x o x
     *  x x x x o
     *  o x x x o
     *  x o o o o
     */
    public LightweightSpaceship() {
        super(4, 5);
    }
}
