package com.romanso.gameoflife.controller.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.romanso.gameoflife.R;
import com.romanso.gameoflife.model.game.GameEngine;
import com.romanso.gameoflife.view.FieldView;

public class MainActivity extends AppCompatActivity {

    private FieldView mFieldView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFieldView = findViewById(R.id.fieldview);
        mFieldView.setGameEngine(new GameEngine(60));
        mFieldView.startGame();
    }
}
