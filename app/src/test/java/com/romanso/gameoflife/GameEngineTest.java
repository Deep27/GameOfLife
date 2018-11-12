package com.romanso.gameoflife;

import com.romanso.gameoflife.model.game.GameEngine;

import org.junit.Test;

public class GameEngineTest {

    @Test
    public void testGameEngineToString() {

        GameEngine gameEngine = new GameEngine(10, 10);
        System.out.println(gameEngine);
    }
}
