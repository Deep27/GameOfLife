package com.romanso.gameoflife.model.game.figure.figureType.oscillator.period02;

import com.romanso.gameoflife.model.game.cell.Cell;
import com.romanso.gameoflife.model.game.figure.figureType.oscillator.Oscillator;

public final class Beacon<D extends Cell> extends Oscillator {

    public Beacon(D deadCell, D liveCell) {
        super(deadCell, liveCell, 4, 4);
    }
}
