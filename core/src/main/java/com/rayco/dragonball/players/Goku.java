package com.rayco.dragonball.players;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.rayco.dragonball.AnimationEngine;
import com.rayco.dragonball.Controls;
import com.rayco.dragonball.MyDragonballGame;
import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;
import org.omg.CORBA.PUBLIC_MEMBER;

public class Goku extends PlayerInit{

    //Global Inits
    public static boolean isCurrentPlayer = true;

    //Texture Locations
    public static String gokuBase = "gokuBaseWalking/gokuBase.png";
    public static String walkSheet = "gokuBaseWalking/gokuWalkingSpriteSheet.png";
    public static String kiAttackSheet = "gokuBaseKiAttack/gokuBaseKiAttack.png";

    public static String gokuSSJ;
    //Class Init
    public static PlayerInit playerInit;


    public static void init(){
        playerInit.gokuInit(isCurrentPlayer,gokuBase, walkSheet, kiAttackSheet);
    }

    public void movement(){

    }


    public void animations(){

    }
}
