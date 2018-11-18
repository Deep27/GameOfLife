package com.romanso.gameoflife.moxy.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.romanso.gameoflife.model.game.GameEngine;
import com.romanso.gameoflife.moxy.view.GameView;

@InjectViewState
public class GameEnginePresenter extends MvpPresenter<GameView> {

    private GameEngine mGameEngine;

    public GameEnginePresenter(int fieldSize) {
        mGameEngine = new GameEngine(fieldSize);
    }

    public GameEngine getGameEngine() {
        return mGameEngine;
    }
}
