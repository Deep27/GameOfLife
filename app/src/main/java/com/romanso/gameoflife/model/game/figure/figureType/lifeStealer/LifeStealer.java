package com.romanso.gameoflife.model.game.figure.figureType.lifeStealer;

import com.romanso.gameoflife.model.game.cell.Cell;
import com.romanso.gameoflife.model.game.figure.Figure;

public abstract class LifeStealer<D extends Cell> extends Figure {

    public LifeStealer(D deadCell, D liveCell, int y, int x) {
        super(deadCell, liveCell, y, x);
    }
}
