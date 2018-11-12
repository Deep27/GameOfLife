package com.romanso.gameoflife.model.game.figure.figureTypes.oscillator;

import com.romanso.gameoflife.model.game.figure.Figure;

public abstract class Oscillator<D> extends Figure<D> {

    public Oscillator(int y, int x) {
        super(y, x);
    }
}
