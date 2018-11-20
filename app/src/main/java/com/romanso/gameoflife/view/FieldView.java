package com.romanso.gameoflife.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.romanso.gameoflife.R;
import com.romanso.gameoflife.model.game.GameEngine;

public class FieldView extends View {

    private static final String TAG = FieldView.class.getName();

    private GameEngine mGameEngine;

    private static final int LINE_THICKNESS = 1;

    private int mScreenWidth;
    private int mScreenHeight;
    private int mCellSize;
    private int mFieldSize;

    private int mWidth, mHeight;
    private Paint mGridPaint;
    private Paint mCellPaint;

    public FieldView(Context context) {
        super(context);
    }

    public FieldView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FieldView, 0, 0);

        mFieldSize = a.getInteger(R.styleable.FieldView_size, 20);

        mGridPaint = new Paint();
        mGridPaint.setColor(Color.rgb(0, 0, 0));
        mGridPaint.setStrokeWidth(LINE_THICKNESS);
        mGridPaint.setStyle(Paint.Style.STROKE);

        mCellPaint = new Paint();
        mCellPaint.setColor(Color.rgb(127, 127, 127));
        mCellPaint.setStrokeWidth(LINE_THICKNESS);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return super.onTouchEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        mHeight = (int) (MeasureSpec.getSize(heightMeasureSpec) * 0.95);
        mWidth = (int) (MeasureSpec.getSize(widthMeasureSpec) * 0.95);

        if (mHeight < mWidth) {
            mWidth = mHeight;
        } else {
            mHeight = mWidth;
        }

        Log.d(TAG, String.format("FieldView height: %d, width: %d", mHeight, mWidth));

        DisplayMetrics dm = getContext().getResources().getDisplayMetrics();

        mScreenHeight = dm.heightPixels;
        mScreenWidth = dm.widthPixels;

        mCellSize = mScreenHeight < mScreenWidth
                ? mScreenHeight / mFieldSize
                : mScreenWidth / mFieldSize;

        Log.d(TAG,  String.format("Screen width: %d\nScreen height: %d\nCells: %d\nCell size: %d",
                mScreenWidth, mScreenHeight, mFieldSize, mCellSize));

        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawField(canvas);
        drawCells(canvas);
        invalidate();
    }

    public void setGameEngine(GameEngine gameEngine) {
        mGameEngine = gameEngine;
    }

    private void drawField(Canvas canvas) {

        // one unit to see lines close to screen border
        int lOffset = 1;
        int tOffset = 1;

        Rect rect = new Rect();

        for (int i = 0; i < mFieldSize; i++) {
            for (int j = 0; j < mFieldSize; j++) {
                rect.set(lOffset, tOffset, lOffset + mCellSize, tOffset + mCellSize);
                canvas.drawRect(rect, mGridPaint);
                lOffset += mCellSize;
            }
            lOffset = 1;
            tOffset += mCellSize;
        }
    }

    private void drawCells(Canvas canvas) {

        for (int i = 0; i < mGameEngine.getYSize(); i++) {
            for (int j = 0; j < mGameEngine.getXSize(); j++) {
                if (mGameEngine.isCellAlive(i, j)) {
                    drawCell(canvas, i, j);
                }
            }
        }
    }

    private void drawCell(Canvas canvas, int y, int x) {

        Rect rect = new Rect();

        int lOffset = 1 + mCellSize * x;
        int tOffset = 1 + mCellSize * y;

        rect.set(lOffset, tOffset, lOffset + mCellSize - 1, tOffset + mCellSize - 1);
        canvas.drawRect(rect, mCellPaint);
    }
}
