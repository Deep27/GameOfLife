package io.deep27soft.gameoflife.model.game.figure.figureType.spaceship;

import io.deep27soft.gameoflife.model.game.cell.Cell;
import io.deep27soft.gameoflife.model.game.figure.Figure;

public abstract class Spaceship<D extends Cell> extends Figure {

    public Spaceship(D liveCell, D deadCell, int y, int x) {
        super(liveCell, deadCell, y, x);
    }
}
