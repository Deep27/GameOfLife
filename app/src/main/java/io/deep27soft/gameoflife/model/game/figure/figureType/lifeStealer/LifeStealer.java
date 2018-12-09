package io.deep27soft.gameoflife.model.game.figure.figureType.lifeStealer;

import io.deep27soft.gameoflife.model.game.cell.Cell;
import io.deep27soft.gameoflife.model.game.figure.Figure;

public abstract class LifeStealer<D extends Cell> extends Figure {

    public LifeStealer(D deadCell, D liveCell, int y, int x) {
        super(deadCell, liveCell, y, x);
    }
}
