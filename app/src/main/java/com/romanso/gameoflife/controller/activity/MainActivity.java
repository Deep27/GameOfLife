package com.romanso.gameoflife.controller.activity;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.romanso.gameoflife.R;
import com.romanso.gameoflife.model.game.GameEngine;
import com.romanso.gameoflife.view.FieldView;

public class MainActivity extends MvpAppCompatActivity {

    private FieldView mFieldView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFieldView = findViewById(R.id.fieldview);
//        mFieldView.setGameEngine(new GameEngine(60));
        mFieldView.startGame();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFieldView.resumeGame();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFieldView.resumeGame();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mFieldView.pauseGame();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
