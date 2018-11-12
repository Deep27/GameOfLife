package com.romanso.gameoflife.game.figure.figureTypes.lifeStealer;

import com.romanso.gameoflife.game.figure.Figure;

public abstract class LifeStealer<D> extends Figure<D> {

    public LifeStealer(Class<D> cellClass, int y, int x) {
        super(cellClass, y, x);
    }
}
