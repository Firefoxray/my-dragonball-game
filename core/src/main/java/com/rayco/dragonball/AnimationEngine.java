package com.rayco.dragonball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.rayco.dragonball.players.PlayerInit;
import org.mini2Dx.core.graphics.Graphics;

public class AnimationEngine{

    //Global Init
    public static float stateTime;
    public static int posX;
    public static int posY;
    private static final int FRAME_COLS = 4;
    private static final int FRAME_ROWS = 4;

    //Texture Regions
    public static SpriteBatch spriteBatch;
    public static Texture spriteBase;
    public static Texture charWalkSheet;
    public static TextureRegion currentFrame;
    public static TextureRegion walkTR[][];


    //Animations
    public static Animation<TextureRegion> walkAnim;

    //Class Init
    public static PlayerInit playerInit;

    public AnimationEngine(){
        spriteBatch = new SpriteBatch();
        stateTime = 0f;

        spriteBase = playerInit.base;
        charWalkSheet = playerInit.spriteSheet;

        currentFrame = new TextureRegion(spriteBase, spriteBase.getWidth(), spriteBase.getHeight());
        currentFrame.flip(false,false);

    }

    public static void walkAnimation(float frameDuration, final int walkState){
        posX = Controls.pointX;
        posY = Controls.pointY;

        walkTR = TextureRegion.split(charWalkSheet,charWalkSheet.getWidth() / FRAME_COLS,
                charWalkSheet.getHeight() / FRAME_ROWS);

        walkAnim = new Animation<TextureRegion>(frameDuration, walkTR[walkState]);
        currentFrame = walkAnim.getKeyFrame(stateTime, true);

    }

    public static void render(Graphics g){
        stateTime += Gdx.graphics.getDeltaTime();
        spriteBatch.begin();
        spriteBatch.draw(currentFrame, posX,posY);
        spriteBatch.end();
    }

    public void dispose(){
        spriteBatch.dispose();
        spriteBase.dispose();
        charWalkSheet.dispose();
    }
}
