package com.romanso.gameoflife.controller.activity;

import android.os.Bundle;
import android.util.Log;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.romanso.gameoflife.R;
import com.romanso.gameoflife.moxy.presenter.GameEnginePresenter;
import com.romanso.gameoflife.moxy.view.GameView;
import com.romanso.gameoflife.view.FieldView;

public class MainActivity extends MvpAppCompatActivity implements GameView {

    private final static String TAG = MainActivity.class.getSimpleName();

    @InjectPresenter
    GameEnginePresenter mGameEnginePresenter;

    private FieldView mFieldView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG, "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFieldView = findViewById(R.id.fieldview);
        mFieldView.setGameEngine(mGameEnginePresenter.getGameEngine());
    }

    @ProvidePresenter
    GameEnginePresenter provideGameEnginePresenter() {
        return new GameEnginePresenter(60);
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
        mGameEnginePresenter.resume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
        mGameEnginePresenter.pause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
