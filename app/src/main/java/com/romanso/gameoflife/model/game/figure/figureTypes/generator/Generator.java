package com.romanso.gameoflife.model.game.figure.figureTypes.generator;

import com.romanso.gameoflife.model.game.figure.Figure;

public abstract class Generator<D> extends Figure<D> {

    public Generator(int y, int x) {
        super(y, x);
    }
}
