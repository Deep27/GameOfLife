package com.romanso.gameoflife.model.game.figure.figureTypes.spaceship;

import com.romanso.gameoflife.model.game.figure.Figure;

public abstract class Spaceship<D> extends Figure<D> {

    public Spaceship(int y, int x) {
        super(y, x);
    }
}
