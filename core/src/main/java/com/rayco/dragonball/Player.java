package com.rayco.dragonball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.mini2Dx.core.engine.geom.CollisionPoint;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;
import org.mini2Dx.core.graphics.TextureRegion;

public class Player extends Sprite{

    //Init


    //Class Init
    Controls controls;

    public Player(){

    }

    /**
    public void createAnimation(){


        baseFrame = currentFrame;

        walkSheet = new Texture(Gdx.files.internal(("gokuBaseWalking/gokuWalkingSpriteSheet.png")));
        com.badlogic.gdx.graphics.g2d.TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth() / FRAME_COLS,walkSheet.getHeight() / FRAME_ROWS);
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++){
            for (int j = 0; j < FRAME_COLS; j++){
                walkFrames[index++] = tmp[i][j];
            }
        }
        walkAnimation = new Animation<com.badlogic.gdx.graphics.g2d.TextureRegion>(0.25f, currentFrame);




    }
    **/

    public void update(float delta){

    }


    public void interpolate(float alpha){

    }

    public void render(Graphics g){

    }

    public void debug(){

    }


}

