package com.romanso.gameoflife.model.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import com.romanso.gameoflife.moxy.presenter.GameEnginePresenter;

import java.util.concurrent.TimeUnit;

public class GameStepWaiterTask extends AsyncTask<Void, Void, Void >{

    private static final String TAG = GameStepWaiterTask.class.getSimpleName();

    private GameEnginePresenter mGameEnginePresenter;

    public GameStepWaiterTask(GameEnginePresenter gameEnginePresenter) {
        mGameEnginePresenter = gameEnginePresenter;
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
                        TimeUnit.MILLISECONDS.sleep(50);
                        mGameEnginePresenter.getGameEngine().nextStep();
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
            publishProgress();
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        mGameEnginePresenter.updateStatisticsViews();
    }
}
