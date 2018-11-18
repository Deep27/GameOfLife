package com.romanso.gameoflife.moxy.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.romanso.gameoflife.model.game.GameEngine;
import com.romanso.gameoflife.moxy.view.GameView;

@InjectViewState
public class GameEnginePresenter extends MvpPresenter<GameView> {

    private GameEngine mGameEngine;

    public GameEnginePresenter() {
        mGameEngine = new GameEngine(60);
    }
}
