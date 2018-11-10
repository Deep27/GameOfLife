package com.romanso.gameoflife.ds;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Toroid<D> {

    private final D[][] mData;

    public Toroid(Class<D> cls, int x, int y) {

        if (x < 2 || y < 2) {
            throw new IllegalArgumentException("Size of toroid must be 2x2 or more!");
        }

        mData = (D[][]) Array.newInstance(cls, y, x);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (D[] yData : mData) {
            for (int x = 0; x < mData[0].length; x++) {
                sb.append(yData[x]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void set(D data, int x, int y) {
        mData[y % mData.length][x % mData[0].length] = data;
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

        for (int i = 0; i < mData.length; i++) {
            mData[i][x] = data.get(i);
        }
    }

    public void setXData(int x, D... data) {
        setXData(x, new ArrayList<>(Arrays.asList(data)));
    }

    public D get(int y, int x) {
        return mData[y % mData.length][x % mData[0].length];
    }

    public ArrayList<D> getYData(int y) {
        return new ArrayList<>(Arrays.asList(mData[y % mData.length]));
    }

    public ArrayList<D> getXData(int x) {

        ArrayList<D> xData = new ArrayList<>(mData[0].length);
        for (int i = 0; i < mData.length; i++) {
            xData.add(mData[i][x % mData[0].length]);
        }
        return xData;
    }
}
