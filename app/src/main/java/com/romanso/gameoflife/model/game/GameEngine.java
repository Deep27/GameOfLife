package com.romanso.gameoflife.model.game;

import android.annotation.SuppressLint;

import com.romanso.gameoflife.model.ds.Toroid;
import com.romanso.gameoflife.model.game.cell.BooleanCell;
import com.romanso.gameoflife.model.game.cell.Cell;
import com.romanso.gameoflife.model.game.figure.Figure;
import com.romanso.gameoflife.model.game.figure.figureType.generator.GliderGun;

public class GameEngine {

    private final static String TAG = GameEngine.class.getSimpleName();

    private Toroid<Cell> mField;
    private int mCells;
    private int mAliveCells = 0;
    private int mMaxAliveCells = 0, mMaxDeadCells = 0;
    private GameState mState = GameState.INITIALIZING;

    public GameEngine(int ySize, int xSize) {

        initEmptyField(ySize, xSize);

        GliderGun<BooleanCell> gliderGun = new GliderGun<>(
                new BooleanCell(true),
                new BooleanCell(false)
        );
        putFigure(gliderGun, 15, 3);
    }

    public GameEngine(int ySize , int xSize, double fillPercentage) {

        if (fillPercentage < 0 || fillPercentage > 1) {
            throw new IllegalArgumentException("Fill percentage must be in [0:1]!");
        }

        initEmptyField(ySize, xSize);

        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                if (Math.random() <= fillPercentage) {
                    mField.set(y, x, new BooleanCell(true));
                }
            }
        }
    }

    private void initEmptyField(int ySize, int xSize) {

        mField = new Toroid<>(ySize, xSize);
        mCells = mField.size();

        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                mField.set(y, x, new BooleanCell(false));
            }
        }
    }

    @SuppressLint("DefaultLocale")
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Cells: %d\nX cells: %d\nY cells: %d\nLive cells: %d\n",
                mField.size(), mField.xSize(), mField.ySize(), mAliveCells));

        for (int i = 0; i < mField.ySize(); i++) {
            for (int j = 0; j < mField.xSize(); j++) {
                sb.append(mField.get(i, j)).append("\t");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public void putFigure(Figure f, int y, int x) {
        Figure.putToToroid(mField, f, y, x);
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

    public int getTotalCells() {
        return mCells;
    }

    public boolean isCellAlive(int y, int x) {
        return mField.get(y, x).isAlive();
    }

    public int getAliveCells() {
        return mAliveCells;
    }

    public int getDeadCells() {
        return mCells - mAliveCells;
    }

    public int getMaxAliveCells() {
        return mMaxAliveCells;
    }

    public int getMaxDeadCells() {
        return mMaxDeadCells;
    }

    public void start() {
        mState = GameState.RUNNING;
    }

    public void pause() {
        mState = GameState.PAUSED;
    }

    public void resume() {
        mState = GameState.RUNNING;
    }

    public void nextStep() {
        defineCellsState();
    }

    private void defineCellsState() {

        Toroid<Cell> newField = new Toroid<>(mField.ySize(), mField.xSize());

        int aliveNeighbours;
        mAliveCells = 0;

        for (int y = 0; y < newField.ySize(); y++) {
            for (int x = 0; x < newField.xSize(); x++) {

                BooleanCell currentCell = (BooleanCell) mField.get(y, x);

                aliveNeighbours = countAliveNeighbours(y, x);

                if (currentCell.isAlive()) {
                    if (aliveNeighbours < 2 || aliveNeighbours > 3) {
                        newField.set(y, x, new BooleanCell(false));
                    } else {
                        newField.set(y, x, new BooleanCell(true));
                        mAliveCells++;
                    }
                } else {
                    if (aliveNeighbours == 3) {
                        newField.set(y, x, new BooleanCell(true));
                        mAliveCells++;
                    } else {
                        newField.set(y, x, new BooleanCell(false));
                    }
                }
            }
        }

        if (mAliveCells > mMaxAliveCells) {
            mMaxAliveCells = mAliveCells;
        }

        if (mCells - mAliveCells > mMaxDeadCells) {
            mMaxDeadCells = mCells - mAliveCells;
        }

        mField = newField;
        mCells = mField.size();
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
