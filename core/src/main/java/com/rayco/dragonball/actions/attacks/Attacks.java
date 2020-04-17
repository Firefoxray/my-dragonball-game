package com.rayco.dragonball.actions.attacks;

import com.rayco.dragonball.AnimationEngine;
import com.rayco.dragonball.Controls;
import com.rayco.dragonball.GameMap;
import com.rayco.dragonball.players.PlayerInit;

import javax.swing.*;

public class Attacks {
    //Objects
    public static int playerPosX;
    public static int playerPosY;

    //Class Inits
    AnimationEngine animationEngine;
    Controls controls;
    GameMap gameMap;
    PlayerInit playerInit;

    //Attacks
    KiBlast kiBlast;
    Punch punch;

    public Attacks(){

    }

    public static void update(){
        playerPosX = PlayerInit.playerPoint.getRenderX();
        playerPosY = PlayerInit.playerPoint.getRenderY();
    }

    public void attackDisplaySend(float frameDuration, final int walkState, String attackType, String attackSheet, String attackSprite){
        animationEngine.attackAnimation(frameDuration, walkState, attackType, attackSheet, attackSprite);
    }

    public void kiBlast(){
        //System.out.println("Redstone");
        String blastSprite = "attackSprites/kiblast.png";
        float frameDuration  = 0.15f;

        attackDisplaySend(frameDuration, Controls.lastDir, "kiBlast",PlayerInit.playerKiAttackSheet,blastSprite);
        //TODO
        //blastsprite
        //gokuKiAttackSprite
        //
    }


}
