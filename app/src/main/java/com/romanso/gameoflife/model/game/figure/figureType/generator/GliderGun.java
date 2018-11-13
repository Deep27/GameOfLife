package com.romanso.gameoflife.model.game.figure.figureType.generator;

import com.romanso.gameoflife.model.game.cell.Cell;

public final class GliderGun<D extends Cell> extends Generator {

    public GliderGun(D liveCell, D deadCell) {

        super(liveCell, deadCell, 9, 36);

        putLiveCell(4, 0);
        putLiveCell(4, 1);
        putLiveCell(5, 0);
        putLiveCell(5, 1);

        putLiveCell(2, 12);
        putLiveCell(2, 13);
        putLiveCell(3, 11);
        putLiveCell(3, 15);
        putLiveCell(4, 10);
        putLiveCell(4, 16);
        putLiveCell(5, 10);
        putLiveCell(5, 14);
        putLiveCell(5, 16);
        putLiveCell(5, 17);
        putLiveCell(6, 10);
        putLiveCell(6, 16);
        putLiveCell(7, 11);
        putLiveCell(7, 15);
        putLiveCell(8, 12);
        putLiveCell(8, 13);

        putLiveCell(0, 24);
        putLiveCell(1, 22);
        putLiveCell(1, 24);
        putLiveCell(2, 20);
        putLiveCell(2, 21);
        putLiveCell(3, 20);
        putLiveCell(3, 21);
        putLiveCell(4, 20);
        putLiveCell(4, 21);
        putLiveCell(5, 22);
        putLiveCell(5, 24);
        putLiveCell(6, 24);

        putLiveCell(2, 34);
        putLiveCell(2, 35);
        putLiveCell(3, 34);
        putLiveCell(3, 35);
    }
}
