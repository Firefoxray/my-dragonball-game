package com.rayco.dragonball;

import com.rayco.dragonball.actions.attacks.Attacks;
import com.rayco.dragonball.players.PlayerInit;
import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.graphics.Graphics;

public class MyDragonballGame extends BasicGame {
	public static final String GAME_IDENTIFIER = "com.rayco.dragonball";

    //Class Init
    AnimationEngine animationEngine;
    PlayerInit playerInit;
    Controls controls;
    GameMap gameMap;
    public static Attacks attacks;

	@Override
    public void initialise() {
        playerInit = new PlayerInit();
        animationEngine = new AnimationEngine();
        controls = new Controls();
        gameMap = new GameMap();
        attacks = new Attacks();
    }
    
    @Override
    public void update(float delta) {
     controls.update();
     playerInit.update();
     attacks.update();
    }
    
    @Override
    public void interpolate(float alpha) {
    playerInit.interpolate(alpha);
    }
    
    @Override
    public void render(Graphics g) {
        gameMap.render(g);
    }

    @Override
    public void dispose(){
	    animationEngine.dispose();
    }
}
