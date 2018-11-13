package com.romanso.gameoflife.model.game.figure.figureType.oscillator;

import com.romanso.gameoflife.model.game.cell.Cell;
import com.romanso.gameoflife.model.game.figure.Figure;

public abstract class Oscillator<D extends Cell> extends Figure {

    public Oscillator(D deadCell, D liveCell, int y, int x) {
        super(deadCell, liveCell, y, x);
    }
}
