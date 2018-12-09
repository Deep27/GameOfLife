package io.deep27soft.gameoflife.model.game.figure.figureType.oscillator.period15;

import io.deep27soft.gameoflife.model.game.cell.Cell;
import io.deep27soft.gameoflife.model.game.figure.figureType.oscillator.Oscillator;

public final class Pentadecathlon<D extends Cell> extends Oscillator {

    public Pentadecathlon(D deadCell, D liveCell) {
        super(deadCell, liveCell, 16, 9);
    }
}
