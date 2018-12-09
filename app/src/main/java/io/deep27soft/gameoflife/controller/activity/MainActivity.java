package io.deep27soft.gameoflife.controller.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import io.deep27soft.gameoflife.R;
import io.deep27soft.gameoflife.moxy.presenter.GameEnginePresenter;
import io.deep27soft.gameoflife.moxy.view.GameView;
import io.deep27soft.gameoflife.view.FieldView;

public class MainActivity extends MvpAppCompatActivity implements GameView {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static String KEY_PAUSED = "PAUSED_BY_USER";

    @InjectPresenter
    GameEnginePresenter mGameEnginePresenter;

    private FieldView mFieldView;
    private TextView mCellsTotalTV, mAliveCellsTV, mDeadCellsTV, mMaxAliveCellsTV, mMaxDeadCellsTV;
    private Button mPauseResumeBtn, mNewGameBtn;

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

        mPauseResumeBtn = findViewById(R.id.btn_pause_resume);
        mPauseResumeBtn.setOnClickListener(this::btnPauseResumeClickHandler);
        mNewGameBtn = findViewById(R.id.btn_new_game);
    }

    @ProvidePresenter
    GameEnginePresenter provideGameEnginePresenter() {
        return new GameEnginePresenter(40, 40, 0.5);
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

        if (mPauseResumeBtn.getText().toString().equals(getString(R.string.pause))) {
            mGameEnginePresenter.resume();
        }
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();

        if (mPauseResumeBtn.getText().toString().equals(getString(R.string.pause))) {
            mGameEnginePresenter.pause();
        }
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (mPauseResumeBtn.getText().toString().equals(getString(R.string.pause))) {
            outState.putBoolean(KEY_PAUSED, true);
            return;
        }
        outState.putBoolean(KEY_PAUSED, false);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean(KEY_PAUSED)) {
                mPauseResumeBtn.setText(getString(R.string.resume));
            }
        }
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void updateStatisticsViews(int totalCells, int aliveCells, int deadCells, int maxAliveCells,
                                      int maxDeadCells) {
        mCellsTotalTV.setText(String.valueOf(totalCells));
        mAliveCellsTV.setText(String.format("%d (%.2f%%)", aliveCells, (double) aliveCells / totalCells * 100));
        mDeadCellsTV.setText(String.format("%d (%.2f%%)", deadCells, (double) deadCells / totalCells * 100));
        mMaxAliveCellsTV.setText(String.format("%d (%.2f%%)", maxAliveCells, (double) maxAliveCells / totalCells * 100));
        mMaxDeadCellsTV.setText(String.format("%d (%.2f%%)", maxDeadCells, (double) maxDeadCells / totalCells * 100));
    }

    private void btnPauseResumeClickHandler(View v) {

        Button clickedBtn = (Button) v;

        switch (mGameEnginePresenter.getGameState()) {
            case RUNNING:
                mGameEnginePresenter.pause();
                clickedBtn.setText(getString(R.string.resume));
                break;
            case PAUSED:
                mGameEnginePresenter.resume();
                clickedBtn.setText(getString(R.string.pause));
                break;
            default:
                break;
        }
    }
}
