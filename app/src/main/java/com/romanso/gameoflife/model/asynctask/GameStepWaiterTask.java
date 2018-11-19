package com.romanso.gameoflife.model.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import com.romanso.gameoflife.model.game.GameEngine;

import java.util.concurrent.TimeUnit;

public class GameStepWaiterTask extends AsyncTask<Void, Void, Void >{

    private static final String TAG = GameStepWaiterTask.class.getSimpleName();

    private GameEngine mGameEngine;

    public GameStepWaiterTask(GameEngine gameEngine) {
        mGameEngine = gameEngine;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Log.d(TAG, "doInBackground");
        while (true) {
            switch (mGameEngine.getGameState()) {
                case RUNNING:
                    try {
                        TimeUnit.MILLISECONDS.sleep(50);
                        mGameEngine.nextStep();
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
}
