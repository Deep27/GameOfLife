package io.deep27soft.gameoflife.moxy.presenter;

import android.os.AsyncTask;

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

    public void nextStep() {
        mGameEngine.nextStep();
    }

    public void start() {
        mGameEngine.start();
    }

    public void pause() {
        mGameEngine.pause();
    }

    public void resume() {
        mGameEngine.resume();
    }
}
