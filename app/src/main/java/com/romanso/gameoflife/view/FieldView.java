package com.romanso.gameoflife.view;

import android.app.Activity;
import android.content.Context;
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

import com.romanso.gameoflife.fragment.FieldFragment;
import com.romanso.gameoflife.game.GameEngine;
import com.romanso.gameoflife.game.GameState;

public class FieldView extends View {

    private static final String TAG = FieldView.class.getName();

    private static final int LINE_THICKNESS = 1;
    private static final int FIELD_SIZE = 20;

    private int mScreenWidth;
    private int mScreenHeight;
    private int mCellSize;

    private int mWidth, mHeight;
    private Paint mGridPaint;
    private Paint mCellPaint;
    private FieldFragment mFieldFragment;
    private GameEngine mGameEngine;

    public FieldView(Context context) {
        super(context);
    }

    public FieldView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

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

        if (mGameEngine.getGameState().equals(GameState.INITIALIZING)) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                invalidate();
            }
        }

        return super.onTouchEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mHeight = View.MeasureSpec.getSize(heightMeasureSpec);
        mWidth = View.MeasureSpec.getSize(widthMeasureSpec);

        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawField(canvas);
        drawCells(canvas);
        invalidate();
    }

    public void setFieldFragment(FieldFragment fieldFragment) {
        mFieldFragment = fieldFragment;

        DisplayMetrics dm = new DisplayMetrics();
        Activity parentActivity = mFieldFragment.getActivity();
        if (parentActivity != null) {
            mFieldFragment.getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        } else {
            throw new IllegalStateException("Parent activity of " + this.getClass().getName() + " is null!");
        }
        mScreenHeight = dm.heightPixels;
        mScreenWidth = dm.widthPixels;

        mCellSize = mScreenHeight < mScreenWidth
                ? mScreenHeight / FIELD_SIZE
                : mScreenWidth / FIELD_SIZE;

        Log.d(TAG,  String.format("Screen width: %d\nScreen height: %d\nCells: %d\nCell size: %d",
                mScreenWidth, mScreenHeight, FIELD_SIZE, mCellSize));
    }

    public void setGameEngine(GameEngine gameEngine) {
        mGameEngine = gameEngine;
    }

    private void drawField(Canvas canvas) {

        // one unit to see lines close to screen border
        int lOffset = 1;
        int tOffset = 1;

        Rect rect = new Rect();

        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
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
