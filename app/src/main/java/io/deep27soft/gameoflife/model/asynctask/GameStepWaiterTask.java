package io.deep27soft.gameoflife.model.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import io.deep27soft.gameoflife.moxy.presenter.GameEnginePresenter;

import java.util.concurrent.TimeUnit;

public class GameStepWaiterTask extends AsyncTask<Void, Void, Void >{

    private static final String TAG = GameStepWaiterTask.class.getSimpleName();

    private GameEnginePresenter mGameEnginePresenter;
    private int mStepMillis;

    public GameStepWaiterTask(GameEnginePresenter gameEnginePresenter) {
        mGameEnginePresenter = gameEnginePresenter;
        setStepMillis(50);
    }

    public GameStepWaiterTask(GameEnginePresenter gameEnginePresenter, int stepMillis) {
        mGameEnginePresenter = gameEnginePresenter;
        setStepMillis(stepMillis);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Log.d(TAG, "doInBackground");
        while (true) {
            switch (mGameEnginePresenter.getGameEngine().getGameState()) {
                case RUNNING:
                    try {
                        publishProgress();
                        TimeUnit.MILLISECONDS.sleep(mStepMillis);
                        mGameEnginePresenter.nextStep();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case PAUSED:
                    break;
                case FINISHED:
                    return null;
                default:
                    break;
            }
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        mGameEnginePresenter.updateStatisticsViews();
    }

    public void setStepMillis(int stepMillis) {

        if (stepMillis < 25) {
            throw new IllegalArgumentException("Between steps should be >= 25 milliseconds!");
        }

        mStepMillis = stepMillis;
    }
}
