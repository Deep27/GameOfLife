package com.romanso.gameoflife.model.game;

import android.annotation.SuppressLint;

import com.romanso.gameoflife.model.ds.Toroid;
import com.romanso.gameoflife.model.game.cell.BooleanCell;
import com.romanso.gameoflife.model.game.cell.Cell;
import com.romanso.gameoflife.model.game.figure.Figure;

public class GameEngine {

    private Toroid<Cell> mField;
    private int mCells;
    private int mLiveCells = 0;
    private GameState mState = GameState.INITIALIZING;

    public GameEngine(int size) {
        this (size, size, 0.15);
    }

    public GameEngine(int x , int y, double fillPercentage) {

        if (fillPercentage < 0 || fillPercentage > 1) {
            throw new IllegalArgumentException("Fill percentage must be in [0:1]!");
        }

        mField = new Toroid<>(x, y);
        mCells = mField.size();

        // @TODO proper way of initialization
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

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                mField.set(i, j, new BooleanCell(false));
            }
        }

//        // glider
//        mField.set(8, 4, new BooleanCell(true));
//        mField.set(9, 5, new BooleanCell(true));
//        mField.set(10, 3, new BooleanCell(true));
//        mField.set(10, 4, new BooleanCell(true));
//        mField.set(10, 5, new BooleanCell(true));

        // Gosper glider gun
        mField.set(25, 2, new BooleanCell(true));
        mField.set(25, 3, new BooleanCell(true));
        mField.set(26, 2, new BooleanCell(true));
        mField.set(26, 3, new BooleanCell(true));

        mField.set(23, 14, new BooleanCell(true));
        mField.set(23, 15, new BooleanCell(true));
        mField.set(24, 13, new BooleanCell(true));
        mField.set(24, 17, new BooleanCell(true));
        mField.set(25, 12, new BooleanCell(true));
        mField.set(25, 18, new BooleanCell(true));
        mField.set(26, 12, new BooleanCell(true));
        mField.set(26, 16, new BooleanCell(true));
        mField.set(26, 18, new BooleanCell(true));
        mField.set(26, 19, new BooleanCell(true));
        mField.set(27,12, new BooleanCell(true));
        mField.set(27, 18, new BooleanCell(true));
        mField.set(28, 13, new BooleanCell(true));
        mField.set(28, 17, new BooleanCell(true));
        mField.set(29, 14, new BooleanCell(true));
        mField.set(29, 15, new BooleanCell(true));

        mField.set(21, 26, new BooleanCell(true));
        mField.set(22, 24, new BooleanCell(true));
        mField.set(22, 26, new BooleanCell(true));
        mField.set(23, 22, new BooleanCell(true));
        mField.set(23, 23, new BooleanCell(true));
        mField.set(24, 22, new BooleanCell(true));
        mField.set(24, 23, new BooleanCell(true));
        mField.set(25, 22, new BooleanCell(true));
        mField.set(25, 23, new BooleanCell(true));
        mField.set(26, 24, new BooleanCell(true));
        mField.set(26, 26, new BooleanCell(true));
        mField.set(27, 26, new BooleanCell(true));

        mField.set(23, 36, new BooleanCell(true));
        mField.set(23, 37, new BooleanCell(true));
        mField.set(24, 36, new BooleanCell(true));
        mField.set(24, 37, new BooleanCell(true));
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

    public void putFigure(Figure figure, int y, int x) {

    }

    public GameState getGameState() {
        return mState;
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

    public void start() {
        mState = GameState.STARTED;
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
