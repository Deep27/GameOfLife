package io.deep27soft.gameoflife.model.game.figure.figureType.oscillator.period02;

import io.deep27soft.gameoflife.model.game.cell.Cell;
import io.deep27soft.gameoflife.model.game.figure.figureType.oscillator.Oscillator;

public final class Beacon<D extends Cell> extends Oscillator {

    public Beacon(D deadCell, D liveCell) {
        super(deadCell, liveCell, 4, 4);
    }
}
