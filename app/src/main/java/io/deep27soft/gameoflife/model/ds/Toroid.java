package io.deep27soft.gameoflife.model.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

// @TODO get rid of @SuppressWarnings("unchecked") ?
public class Toroid<D> {

    private final Object[][] mData;

    public Toroid(int y, int x) {

        if (x < 2 || y < 2) {
            throw new IllegalArgumentException("Size of toroid must be 2x2 or more!");
        }

        mData = new Object[y][x];
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (Object[] yData : mData) {
            for (int x = 0; x < mData[0].length; x++) {
                sb.append(yData[x]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void set(int y, int x, D data) {
        y = handleY(y);
        x = handleX(x);
        mData[y][x] = data;
    }

    /**
     *  Replaces y-axis with input data
     *
     *  y = 1, data.size() = 4
     *
     *  2   2   4   5   1
     *  1   x   x   x   x
     *  0   1   5   9   7
     *      0   1   2   3
     *
     * @param y - y-axis point
     * @param data - data to set on y-axis point
     */
    public void setYData(int y, ArrayList<D> data) {

        if (data.size() != mData[0].length) {
            throw new IllegalArgumentException("New data size is not the same as the old one's!");
        }

        y = handleY(y);

        for (int i = 0; i < mData[0].length; i++) {
            mData[y][i] = data.get(i);
        }
    }

    public void setYData(int y, D... data) {
        setYData(y, new ArrayList<>(Arrays.asList(data)));
    }

    /**
     *  Replaces x-axis with input data
     *
     *  x = 2, data.size() = 3
     *
     *  2   2   4   x   1
     *  1   4   6   x   2
     *  0   1   5   x   7
     *      0   1   2   3
     *
     * @param x - x-axis point
     * @param data - data to set on x-axis point
     */
    public void setXData(int x, ArrayList<D> data) {

        if (data.size() != mData.length) {
            throw new IllegalArgumentException("New data size is not the same as the old one's!");
        }

        x = handleX(x);

        for (int i = 0; i < mData.length; i++) {
            mData[i][x] = data.get(i);
        }
    }

    @SuppressWarnings("unchecked")
    public void setXData(int x, D... data) {
        setXData(x, new ArrayList<>(Arrays.asList(data)));
    }

    @SuppressWarnings("unchecked")
    public D get(int y, int x) {
        y = handleY(y);
        x = handleX(x);
        Object data = mData[y][x];
        return (D) data;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<D> getYData(int y) {
        return new ArrayList<>((Collection<? extends D>) Arrays.asList(mData[y % mData.length]));
    }

    @SuppressWarnings("unchecked")
    public ArrayList<D> getXData(int x) {

        x = handleX(x);

        ArrayList<D> xData = new ArrayList<>(mData[0].length);
        for (Object[] aMData : mData) {
            xData.add((D) aMData[x]);
        }
        return xData;
    }

    public int size() {
        return mData.length * mData[0].length;
    }

    public int ySize() {
        return mData.length;
    }

    public int xSize() {
        return mData[0].length;
    }

    public int handleY(int y) {
        y %= mData.length;

        if (y < 0) {
            y = mData.length + y;
        }

        return y;
    }

    public int handleX(int x) {
        x %= mData.length;

        if (x < 0) {
            x = mData.length + x;
        }

        return x;
    }
}
