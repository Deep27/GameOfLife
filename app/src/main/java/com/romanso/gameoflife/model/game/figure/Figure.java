package com.romanso.gameoflife.model.game.figure;

// @TODO get rid of unchecked warnings
public abstract class Figure<D> {

    protected D[][] mFigure;

    @SuppressWarnings("unchecked")
    public Figure(int y, int x) {
        mFigure = (D[][]) new Object[y][x];
    }
}
