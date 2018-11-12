package com.romanso.gameoflife.model.game.figure;

public abstract class Figure<D> {

    protected D[][] figure;

    public Figure(Class<D> cellClass, int y, int x) {

    }
}
