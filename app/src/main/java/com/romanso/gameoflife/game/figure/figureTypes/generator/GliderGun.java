package com.romanso.gameoflife.game.figure.figureTypes.generator;

public final class GliderGun<D> extends Generator<D> {

    public GliderGun(Class<D> cellClass) {
        super(cellClass, 9, 36);
    }
}
