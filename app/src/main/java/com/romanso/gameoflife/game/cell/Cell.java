package com.romanso.gameoflife.game.cell;

public abstract class Cell {

    protected boolean mAlive;

    protected Cell(boolean alive) {
        mAlive = alive;
    }

    @Override
    public String toString() {
        return mAlive ? "O" : "x";
    }

    public void kill() {
        mAlive = false;
    }

    public void revive() {
        mAlive = true;
    }

    public boolean isAlive() {
        return mAlive;
    }
}
