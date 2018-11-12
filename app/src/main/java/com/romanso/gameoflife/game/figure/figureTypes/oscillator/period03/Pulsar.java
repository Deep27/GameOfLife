package com.romanso.gameoflife.game.figure.figureTypes.oscillator.period03;

import com.romanso.gameoflife.game.figure.figureTypes.oscillator.Oscillator;

public final class Pulsar<D> extends Oscillator<D> {

    public Pulsar(Class<D> cellClass) {
        super(cellClass, 15, 15);
    }
}
