package com.romanso.gameoflife.game;

import android.annotation.SuppressLint;

import com.romanso.gameoflife.ds.Toroid;
import com.romanso.gameoflife.game.cell.BooleanCell;
import com.romanso.gameoflife.game.cell.Cell;

public class GameEngine {

    private Toroid<Cell> mField;
    private int mCells;
    private int mLiveCells = 0;
    private GameState mState = GameState.INITIALIZING;

    public GameEngine(int x, int y) {
        this (x, y, 0.15);
    }

    public GameEngine(int x , int y, double fillPercentage) {

        if (fillPercentage < 0 || fillPercentage > 1) {
            throw new IllegalArgumentException("Fill percentage must be in [0:1]!");
        }

        mField = new Toroid<>(x, y);
        mCells = mField.size();

//        for (int i = 0; i < y; i++) {
//            for (int j = 0; j < x; j++) {
//                if (Math.random() <= fillPercentage) {
//                    mField.set(i, j, new BooleanCell(true));
//                    mLiveCells++;
//                } else {
//                    mField.set(i, j, new BooleanCell(false));
//                }
//            }
//        }

        // glider
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                mField.set(i, j, new BooleanCell(false));
            }
        }
        mField.set(6, 4, new BooleanCell(true));
        mField.set(7, 5, new BooleanCell(true));
        mField.set(8, 3, new BooleanCell(true));
        mField.set(8, 4, new BooleanCell(true));
        mField.set(8, 5, new BooleanCell(true));
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

    public GameState getGameState() {
        return mState;
    }

    public void setGameState(GameState gs) {
        mState = gs;
    }

    public int getYSize() {
        return mField.ySize();
    }

    public int getXSize() {
        return mField.xSize();
    }

    public boolean isCellAlive(int y, int x) {
        return mField.get(y, x).isAlive();
    }

    public int getLiveCells() {
        return mLiveCells;
    }

    public int getDeadCells() {
        return mCells - mLiveCells;
    }

    public void nextStep() {
        defineCellsState();
    }

    private void defineCellsState() {

        Toroid<Cell> newField = new Toroid<>(mField.xSize(), mField.ySize());

        int aliveNeighbours;
        mLiveCells = 0;

        for (int i = 0; i < newField.ySize(); i++) {
            for (int j = 0; j < newField.xSize(); j++) {

                BooleanCell currentCell = (BooleanCell) mField.get(i, j);

                aliveNeighbours = countAliveNeighbours(i, j);

                if (currentCell.isAlive()) {
                    if (aliveNeighbours < 2 || aliveNeighbours > 3) {
                        newField.set(i, j, new BooleanCell(false));
                    } else {
                        newField.set(i, j, new BooleanCell(true));
                        mLiveCells++;
                    }
                } else {
                    if (aliveNeighbours == 3) {
                        newField.set(i, j, new BooleanCell(true));
                        mLiveCells++;
                    } else {
                        newField.set(i, j, new BooleanCell(false));
                    }
                }
            }
        }

        mField = newField;
        mCells = mField.size();

        System.out.println("New field\n" + this);
    }

    private int countAliveNeighbours(int y, int x) {

        return getTopAliveNeighbours(y, x)
                + getBottomAliveNeighbours(y, x)
                + getLeftAndRightAliveNeighbours(y, x);
    }

    private int getTopAliveNeighbours(int y, int x) {

        int aliveNeighbours = 0;

        for (int i = -1; i < 2; i++) {
            if (mField.get(y - 1, x + i).isAlive()) {
                aliveNeighbours++;
            }
        }

        return aliveNeighbours;
    }

    private int getBottomAliveNeighbours(int y, int x) {

        int aliveNeighbours = 0;

        for (int i = -1; i < 2; i++) {
            if (mField.get(y + 1, x + i).isAlive()) {
                aliveNeighbours++;
            }
        }

        return aliveNeighbours;
    }

    private int getLeftAndRightAliveNeighbours(int y, int x) {

        int aliveNeighbours = 0;
        if (mField.get(y, x - 1).isAlive()) {
            aliveNeighbours++;
        }
        if (mField.get(y, x + 1).isAlive()) {
            aliveNeighbours++;
        }

        return aliveNeighbours;
    }
}
