package com.romanso.gameoflife.moxy.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface GameView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void startGame();
}
