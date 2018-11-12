package com.romanso.gameoflife.game.figure.figureTypes.spaceship;

import com.romanso.gameoflife.game.figure.Figure;

public abstract class Spaceship<D> extends Figure<D> {

    public Spaceship(Class<D> cellClass, int y, int x) {
        super(cellClass, y, x);
    }
}
