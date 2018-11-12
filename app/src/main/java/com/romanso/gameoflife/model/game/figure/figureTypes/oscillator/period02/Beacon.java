package com.romanso.gameoflife.model.game.figure.figureTypes.oscillator.period02;

import com.romanso.gameoflife.model.game.figure.figureTypes.oscillator.Oscillator;

public final class Beacon<D> extends Oscillator<D> {

    public Beacon(Class<D> cellClass) {
        super(cellClass, 4, 4);
    }
}
