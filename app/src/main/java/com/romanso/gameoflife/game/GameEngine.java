package com.romanso.gameoflife.game;

import android.annotation.SuppressLint;

import com.romanso.gameoflife.ds.Toroid;

public class GameEngine {

    private Toroid<Cell> mField;
    private int mCells;
    private int mLiveCells = 0;

    public GameEngine(int x, int y) {
        this (x, y, 0.3);
    }

    public GameEngine(int x , int y, double fillPercentage) {

        if (fillPercentage < 0 || fillPercentage > 1) {
            throw new IllegalArgumentException("Fill percentage must be in [0:1]!");
        }

        mField = new Toroid<>(x, y);
        mCells = mField.size();

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (Math.random() <= fillPercentage) {
                    mField.set(j, i, new BooleanCell(true));
                    mLiveCells++;
                } else {
                    mField.set(j, i, new BooleanCell(false));
                }
            }
        }
    }

    @SuppressLint("DefaultLocale")
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Cells: %d\nX cells: %d\nY cells: %d\nLive cells: %d\n",
                mField.size(), mField.xSize(), mField.ySize(), mLiveCells));

        for (int i = 0; i < mField.ySize(); i++) {
            for (int j = 0; j < mField.xSize(); j++) {
                sb.append(mField.get(i, j)).append("\t");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public int getLiveCells() {
        return mLiveCells;
    }

    public int getDeadCells() {
        return mCells - mLiveCells;
    }

    public void nextStep() {

    }
}
