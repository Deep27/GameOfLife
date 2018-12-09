package io.deep27soft.gameoflife.moxy.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface GameView extends MvpView {

    @StateStrategyType(SingleStateStrategy.class)
    void updateStatisticsViews(int totalCells, int aliveCells, int deadCells,
                               int maxAliveCells, int maxDeadCells);
}
