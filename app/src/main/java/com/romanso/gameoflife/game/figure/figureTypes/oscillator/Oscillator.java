package com.romanso.gameoflife.game.figure.figureTypes.oscillator;

import com.romanso.gameoflife.game.figure.Figure;

public abstract class Oscillator<D> extends Figure<D> {

    public Oscillator(Class<D> cellClass, int y, int x) {
        super(cellClass, y, x);
    }
}
