package io.deep27soft.gameoflife.model.game.figure.figureType.generator;

import io.deep27soft.gameoflife.model.game.cell.Cell;
import io.deep27soft.gameoflife.model.game.figure.Figure;

public abstract class Generator<D extends Cell> extends Figure {

    public Generator(D liveCell, D deadCell, int y, int x) {
        super(liveCell, deadCell, y, x);
    }
}
