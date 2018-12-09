package io.deep27soft.gameoflife.model.game.figure;

import io.deep27soft.gameoflife.model.ds.Toroid;
import io.deep27soft.gameoflife.model.game.cell.Cell;

// @TODO get rid of unchecked warnings
public abstract class Figure<D extends Cell> {

    private D mLiveCell;
    private D mDeadCell;
    protected D[][] mFigure;

    @SuppressWarnings("unchecked")
    public Figure(D liveCell, D deadCell, int y, int x) {

        if (y < 1 || x < 1) {
            throw new IllegalArgumentException("Figure size must be 1x1 or more!");
        }

        mLiveCell = liveCell;
        mDeadCell = deadCell;

        mFigure = (D[][]) new Cell[y][x];
        fillCellsWithSpecificType(deadCell);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < mFigure.length; i++) {
            for (int j = 0; j < mFigure[0].length; j++) {
                sb.append(mFigure[i][j]).append("\t");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    protected void putLiveCell(int y, int x) {
        mFigure[y][x] = (D) mLiveCell.clone();
    }

    private D getCell(int y, int x) {
        return mFigure[y][x];
    }

    private int ySize() {
        return mFigure.length;
    }

    private int xSize() {
        return mFigure[0].length;
    }

    @SuppressWarnings("unchecked")
    private void fillCellsWithSpecificType(D deadCell) {

        for (int i = 0; i < mFigure.length; i++) {
            for (int j = 0; j < mFigure[0].length; j++) {
                {
                    mFigure[i][j] = (D) deadCell.clone();
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void putToToroid(Toroid t, Figure f, int yOffset, int xOffset) {

        int y = 0;
        int x = 0;

        while (y < f.ySize()) {
            while (x < f.xSize()) {
                t.set(t.handleY(y + yOffset), t.handleX(x + xOffset), f.getCell(y, x).clone());
                x++;
            }
            x = 0;
            y++;
        }
    }
}
