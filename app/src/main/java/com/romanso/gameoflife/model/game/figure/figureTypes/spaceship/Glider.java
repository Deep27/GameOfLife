package com.romanso.gameoflife.model.game.figure.figureTypes.spaceship;

public final class Glider<D> extends Spaceship<D> {

    /**
     *  x x o
     *  o x o
     *  x o o
     */
    public Glider() {
        super(3, 3);
    }
}
