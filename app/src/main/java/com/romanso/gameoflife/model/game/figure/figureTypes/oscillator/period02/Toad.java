package com.romanso.gameoflife.model.game.figure.figureTypes.oscillator.period02;

import com.romanso.gameoflife.model.game.cell.Cell;
import com.romanso.gameoflife.model.game.figure.figureTypes.oscillator.Oscillator;

public final class Toad<D extends Cell> extends Oscillator {

    public Toad(D deadCell, D liveCell) {
        super(deadCell, liveCell, 4, 4);
    }
}
