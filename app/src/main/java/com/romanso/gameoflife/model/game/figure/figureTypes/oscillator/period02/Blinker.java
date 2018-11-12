package com.romanso.gameoflife.model.game.figure.figureTypes.oscillator.period02;

import com.romanso.gameoflife.model.game.figure.figureTypes.oscillator.Oscillator;

public final class Blinker<D> extends Oscillator<D> {

    public Blinker(Class<D> cellClass) {
        super(cellClass, 3, 3);
    }
}
