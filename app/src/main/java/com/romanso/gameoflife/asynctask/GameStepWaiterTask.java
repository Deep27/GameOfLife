package com.romanso.gameoflife.asynctask;

import android.os.AsyncTask;

import com.romanso.gameoflife.game.GameEngine;

import java.util.concurrent.TimeUnit;

public class GameStepWaiterTask extends AsyncTask<Void, Void, Void >{

    private GameEngine mGameEngine;

    public GameStepWaiterTask(GameEngine gameEngine) {

        mGameEngine = gameEngine;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... gameEngines) {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(50);
                mGameEngine.nextStep();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
