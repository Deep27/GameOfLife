package io.deep27soft.gameoflife.moxy.presenter;

import android.os.AsyncTask;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import io.deep27soft.gameoflife.model.asynctask.GameStepWaiterTask;
import io.deep27soft.gameoflife.model.game.GameEngine;
import io.deep27soft.gameoflife.model.game.GameState;
import io.deep27soft.gameoflife.moxy.view.GameView;

@InjectViewState
public class GameEnginePresenter extends MvpPresenter<GameView> {

    private static final String TAG = GameEnginePresenter.class.getSimpleName();

    private GameEngine mGameEngine;
    private GameStepWaiterTask mGameStepWaiterTask;

    private boolean mPausedByUser;

    public GameEnginePresenter(int ySize, int xSize) {
        mGameEngine = new GameEngine(ySize, xSize);
        initTask();
    }

    public GameEnginePresenter(int ySize, int xSize, double fillPercentage) {
        mGameEngine = new GameEngine(ySize, xSize, fillPercentage);
        initTask();
    }

    private void initTask() {
        mGameStepWaiterTask = new GameStepWaiterTask(this);
        if (mGameStepWaiterTask.getStatus() != AsyncTask.Status.RUNNING) {
            mGameStepWaiterTask.execute();
        }
    }

    public GameEngine getGameEngine() {
        return mGameEngine;
    }

    public void updateStatisticsViews() {

        getViewState().updateStatisticsViews(mGameEngine.getTotalCells(),
                mGameEngine.getAliveCells(), mGameEngine.getDeadCells(),
                mGameEngine.getMaxAliveCells(), mGameEngine.getMaxDeadCells());
    }

    public GameState getGameState() {
        return mGameEngine.getGameState();
    }

    public void newGame() {
        mGameEngine.newGame();
        updateStatisticsViews();
        if (mPausedByUser) {
            mGameEngine.pause();
            handlePauseResumeButtonState();
            return;
        }
        mGameEngine.start();
        handlePauseResumeButtonState();
    }

    public void nextStep() {
        mGameEngine.nextStep();
    }

    public void start() {
        if (!mPausedByUser) {
            mGameEngine.start();
        }
    }

    public void pause() {
        Log.d(TAG, "To pause?");
        if (!mPausedByUser) {
            Log.d(TAG, "Paused.");
            mGameEngine.pause();
        }
        handlePauseResumeButtonState();
    }

    public void resume() {
        Log.d(TAG, "To resume?");
        if (!mPausedByUser) {
            Log.d(TAG, "Resumed.");
            mGameEngine.resume();
        }
        handlePauseResumeButtonState();
    }

    public void pauseByUser() {
        Log.d(TAG, "Paused by user.");
        mGameEngine.pause();
        mPausedByUser = true;
        handlePauseResumeButtonState();
    }

    public void resumeByUser() {
        Log.d(TAG, "Resumed by user");
        mGameEngine.resume();
        mPausedByUser = false;
        handlePauseResumeButtonState();
    }

    private void handlePauseResumeButtonState() {
        if (mPausedByUser) {
            getViewState().setPauseResumeButtonState(false);
            return;
        }
        getViewState().setPauseResumeButtonState(true);
    }
}
