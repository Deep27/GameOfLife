package io.deep27soft.gameoflife.gameEngine;

import io.deep27soft.gameoflife.model.game.GameEngine;
import io.deep27soft.gameoflife.model.game.cell.BooleanCell;
import io.deep27soft.gameoflife.model.game.figure.figureType.lifeStealer.Block;

import org.junit.Before;
import org.junit.Test;

public class GameEngineTest {

    private GameEngine mGameEngine;

    @Before
    public void setUp() {
        mGameEngine = new GameEngine(10, 10);
    }

    @Test
    public void testGameEngineToString() {
        System.out.println(mGameEngine);
    }

    @Test
    public void testPutFigureNegativeY() {
        Block<BooleanCell> g = new Block<>(new BooleanCell(true), new BooleanCell(false));
        mGameEngine.putFigure(g, -11, 0);
        System.out.println(mGameEngine);
    }

    @Test
    public void testPutFigureNegativeX() {
        Block<BooleanCell> g = new Block<>(new BooleanCell(true), new BooleanCell(false));
        mGameEngine.putFigure(g, 0, -11);
        System.out.println(mGameEngine);
    }

    @Test
    public void testPutFigureOverflowY() {
        Block<BooleanCell> g = new Block<>(new BooleanCell(true), new BooleanCell(false));
        mGameEngine.putFigure(g, 10, 0);
        System.out.println(mGameEngine);
    }

    @Test
    public void testPutFigureOverflowX() {
        Block<BooleanCell> g = new Block<>(new BooleanCell(true), new BooleanCell(false));
        mGameEngine.putFigure(g, 0, 10);
        System.out.println(mGameEngine);
    }
}
