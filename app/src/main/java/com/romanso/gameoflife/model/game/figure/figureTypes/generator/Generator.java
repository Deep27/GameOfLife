package com.romanso.gameoflife.model.game.figure.figureTypes.generator;

import com.romanso.gameoflife.model.game.cell.Cell;
import com.romanso.gameoflife.model.game.figure.Figure;

public abstract class Generator<D extends Cell> extends Figure {

    public Generator(D liveCell, D deadCell, int y, int x) {
        super(liveCell, deadCell, y, x);
    }
}
