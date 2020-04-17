package com.rayco.dragonball.players;

import com.badlogic.gdx.graphics.Texture;
import com.rayco.dragonball.AnimationEngine;
import org.mini2Dx.core.engine.geom.CollisionPoint;

public class PlayerInit {

    //Object Init
    public static Texture base;
    public static Texture spriteSheet;
    public static CollisionPoint playerPoint;


    //Class Init
    AnimationEngine animationEngine;
    public static Goku goku;
    public static Vegeta vegeta;

    //Player Init
    public static int PLAYER_NUM = 0;
    public static final int GOKU = 0;
    public static final int VEGETA = 1;
    public static String playerKiAttackSheet;

    public PlayerInit(){
        playerPoint = new CollisionPoint();
        //playerPoint.set(Gdx.graphics.getWidth() / 2,Gdx.graphics.getHeight() / 2);
        playerPoint.set(1024,1024);



        goku.init();
    }

    public void update(){
        playerPoint.preUpdate();
    }

    public static void gokuInit(boolean currPlayer, String gokuBase, String gokuWalkSheet, String kiAttackSheet){
        if(currPlayer){
            currentPlayer(gokuBase, gokuWalkSheet);
            playerKiAttackSheet = kiAttackSheet;
        }
    }

    public static void currentPlayer(String playerBase, String playerSheet){
        base = new Texture(playerBase);
        spriteSheet = new Texture(playerSheet);
    }

    public void interpolate(float alpha){
        playerPoint.interpolate(null, alpha);
    }
}
