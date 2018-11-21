package com.romanso.gameoflife.controller.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.romanso.gameoflife.R;
import com.romanso.gameoflife.moxy.presenter.GameEnginePresenter;
import com.romanso.gameoflife.moxy.view.GameView;
import com.romanso.gameoflife.view.FieldView;

public class MainActivity extends MvpAppCompatActivity implements GameView {

    private final static String TAG = MainActivity.class.getSimpleName();

    @InjectPresenter
    GameEnginePresenter mGameEnginePresenter;

    private FieldView mFieldView;
    private TextView mCellsTotalTV, mAliveCellsTV, mDeadCellsTV, mMaxAliveCellsTV, mMaxDeadCellsTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG, "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFieldView = findViewById(R.id.fieldview);
        mFieldView.setGameEngine(mGameEnginePresenter.getGameEngine());

        mCellsTotalTV = findViewById(R.id.tv_cells_total);
        mAliveCellsTV = findViewById(R.id.tv_cells_alive);
        mDeadCellsTV = findViewById(R.id.tv_cells_dead);
        mMaxAliveCellsTV = findViewById(R.id.tv_cells_alive_max);
        mMaxDeadCellsTV = findViewById(R.id.tv_cells_dead_max);
    }

    @ProvidePresenter
    GameEnginePresenter provideGameEnginePresenter() {
        return new GameEnginePresenter(60);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart");
        super.onStart();
        mGameEnginePresenter.start();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
        mGameEnginePresenter.resume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
        mGameEnginePresenter.pause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void updateStatisticsViews(int totalCells, int aliveCells, int deadCells, int maxAliveCells,
                                      int maxDeadCells) {
        mCellsTotalTV.setText(String.valueOf(totalCells));
        mAliveCellsTV.setText(String.valueOf(aliveCells));
        mDeadCellsTV.setText(String.valueOf(deadCells));
        mMaxAliveCellsTV.setText(String.valueOf(maxAliveCells));
        mMaxDeadCellsTV.setText(String.valueOf(maxDeadCells));
    }
}
