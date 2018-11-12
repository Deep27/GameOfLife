package com.romanso.gameoflife.model.game.cell;

public abstract class Cell implements Cloneable {

    protected boolean mAlive;

    protected Cell(boolean alive) {
        mAlive = alive;
    }

    @Override
    public String toString() {
        return mAlive ? "x" : "-";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not clone cell!");
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
