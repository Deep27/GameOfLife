package com.romanso.gameoflife.model.game.figure.figureTypes.spaceship;

import com.romanso.gameoflife.model.game.cell.Cell;
import com.romanso.gameoflife.model.game.figure.Figure;

public abstract class Spaceship<D extends Cell> extends Figure {

    public Spaceship(D liveCell, D deadCell, int y, int x) {
        super(liveCell, deadCell, y, x);
    }
}
