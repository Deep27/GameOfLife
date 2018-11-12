package com.romanso.gameoflife.game.figure.figureTypes.oscillator.period02;

import com.romanso.gameoflife.game.figure.figureTypes.oscillator.Oscillator;

public final class Toad<D> extends Oscillator<D> {

    public Toad(Class<D> cellClass) {
        super(cellClass, 4, 4);
    }
}
