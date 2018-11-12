package com.romanso.gameoflife.game.figure.figureTypes.oscillator.period15;

import com.romanso.gameoflife.game.figure.figureTypes.oscillator.Oscillator;

public final class Pentadecathlon<D> extends Oscillator<D> {

    public Pentadecathlon(Class<D> cellClass) {
        super(cellClass, 16, 9);
    }
}
