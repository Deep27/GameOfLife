package com.romanso.gameoflife.model.game.figure.figureTypes.oscillator.period03;

import com.romanso.gameoflife.model.game.cell.Cell;
import com.romanso.gameoflife.model.game.figure.figureTypes.oscillator.Oscillator;

public final class Pulsar<D extends Cell> extends Oscillator {

    public Pulsar(D deadCell, D liveCell) {
        super(deadCell, liveCell, 15, 15);
    }
}
