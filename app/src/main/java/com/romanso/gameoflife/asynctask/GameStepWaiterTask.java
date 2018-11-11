package com.romanso.gameoflife.asynctask;

import android.os.AsyncTask;

import com.romanso.gameoflife.game.GameEngine;

import java.util.concurrent.TimeUnit;

public class GameStepWaiterTask extends AsyncTask<GameEngine, Void, Void >{


    @Override
    protected Void doInBackground(GameEngine... gameEngines) {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
                gameEngines[0].nextStep();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
