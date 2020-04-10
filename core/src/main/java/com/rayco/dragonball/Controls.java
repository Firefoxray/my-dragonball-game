package com.rayco.dragonball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import static com.rayco.dragonball.players.PlayerInit.playerPoint;

public class Controls {

    //Movement ID's
    public static final int WALK_UP = 3;
    public static final int WALK_DOWN = 0;
    public static final int WALK_LEFT = 1;
    public static final int WALK_RIGHT = 2;

    //Movement Speeds
    public static float walk = 0.15f;

    //Class Init
    public static AnimationEngine animationEngine;
    public static GameMap gameMap;

    //Obj Init
    public static int pointX;
    public static int pointY;
    public static int lastDir = 0;

    public Controls(){

    }


    public void update() {
        pointX = playerPoint.getRenderX();
        pointY = playerPoint.getRenderY();
        movement();
    }

    public void movement(){

        //Button Press Inits
        boolean isRightPresed = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
        boolean isLeftPresed = Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean isUpPresed = Gdx.input.isKeyPressed(Input.Keys.UP);
        boolean isDownPresed = Gdx.input.isKeyPressed(Input.Keys.DOWN);
        boolean isNum1Pressed = Gdx.input.isKeyPressed(Input.Keys.NUM_1);
        boolean isNum2Pressed = Gdx.input.isKeyPressed(Input.Keys.NUM_2);
        boolean isNum3Pressed = Gdx.input.isKeyPressed(Input.Keys.NUM_3);
        boolean isButtonPressed = Gdx.input.isKeyPressed(Input.Keys.ANY_KEY);

        //
        if (!isButtonPressed){
            animationEngine.walkAnimation(100f,lastDir);
            //System.out.println(lastDir);
        }

        if (isRightPresed){
            animationEngine.walkAnimation(walk,WALK_RIGHT);
            lastDir = WALK_RIGHT;
            if(!gameMap.isCellBlocked(playerPoint.getX(), playerPoint.getY(), "e")){
                playerPoint.set(playerPoint.getX() + 4, playerPoint.getY());
                gameMap.camera.translate(4,0);
            }
        }
        if (isLeftPresed){
            animationEngine.walkAnimation(walk, WALK_LEFT);
            lastDir = WALK_LEFT;
            if(!gameMap.isCellBlocked(playerPoint.getX(), playerPoint.getY(), "w")) {
                playerPoint.set(playerPoint.getX() - 4, playerPoint.getY());
                gameMap.camera.translate(-4, 0);
            }
        }
        if (isUpPresed){
            animationEngine.walkAnimation(walk, WALK_UP);
            lastDir = WALK_UP;
            if(!gameMap.isCellBlocked(playerPoint.getX(), playerPoint.getY(), "n")) {
                playerPoint.set(playerPoint.getX(), playerPoint.getY() + 4);
                gameMap.camera.translate(0, 4);
            }
        }
        if (isDownPresed){
            animationEngine.walkAnimation(walk, WALK_DOWN);
            lastDir = WALK_DOWN;
            if(!gameMap.isCellBlocked(playerPoint.getX(), playerPoint.getY(), "s")) {
                playerPoint.set(playerPoint.getX(), playerPoint.getY() - 4);
                gameMap.camera.translate(0, -4);
            }
        }

        if(isNum1Pressed){
            gameMap.tiledMap.getLayers().get(0).setVisible(!gameMap.tiledMap.getLayers().get(0).isVisible());
        }
        if(isNum2Pressed){
            gameMap.tiledMap.getLayers().get(1).setVisible(!gameMap.tiledMap.getLayers().get(0).isVisible());
        }
        if(isNum3Pressed){
            gameMap.tiledMap.getLayers().get(1).setVisible(!gameMap.tiledMap.getLayers().get(0).isVisible());
        }


    }


}
