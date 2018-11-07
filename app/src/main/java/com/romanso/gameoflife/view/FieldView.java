package com.romanso.gameoflife.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.romanso.gameoflife.fragment.FieldFragment;
import com.romanso.gameoflife.logic.GameEngine;

public class FieldView extends View {

    private static final int LINE_THICKNESS = 1;

    private final int fFieldSize = 20;
    private final int fCellSize = 5;

    private int mWidth, mHeight;
    private Paint mGridPaint, mTakenPaint, mFreePaint;
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
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
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
    }

    public void setFieldFragment(FieldFragment fieldFragment) {
        mFieldFragment = fieldFragment;
    }

    public void setGameEngine(GameEngine gameEngine) {
        mGameEngine = gameEngine;
    }

    private void drawField(Canvas canvas) {
        canvas.drawRect(100, 100, 200, 200, mGridPaint);
    }
}
