package com.romanso.gameoflife.game.figure.figureTypes.generator;

import com.romanso.gameoflife.game.figure.Figure;

public abstract class Generator<D> extends Figure<D> {

    public Generator(Class<D> cellClass, int y, int x) {
        super(cellClass, y, x);
    }
}
