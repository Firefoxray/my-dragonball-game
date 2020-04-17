package com.rayco.dragonball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.rayco.dragonball.actions.attacks.Attacks;
import com.rayco.dragonball.players.PlayerInit;
import org.mini2Dx.core.graphics.Graphics;

public class AnimationEngine{

    //Global Init
    public static float stateTime;
    public static int posX;
    public static int posY;
    public static int attackPositionX = 0;
    public static int attackPositionY = 0;
    private static final int FRAME_COLS = 4;
    private static final int FRAME_ROWS = 4;

    //Texture Regions
    public static SpriteBatch spriteBatch;
    public static Texture spriteBase;
    public static Texture charWalkSheet;
    public static Texture charAttackSheet;
    public static Texture charAttackSprite;
    public static TextureRegion currentFrame;
    public static TextureRegion attackFrame;
    public static TextureRegion walkTR[][];
    public static TextureRegion attackTR[][];


    //Animations
    public static Animation<TextureRegion> walkAnim;
    public static Animation<TextureRegion> attackAnim;

    //Class Init
    public static PlayerInit playerInit;

    public AnimationEngine(){
        spriteBatch = new SpriteBatch();
        stateTime = 0f;

        spriteBase = playerInit.base;
        charWalkSheet = playerInit.spriteSheet;

        currentFrame = new TextureRegion(spriteBase, spriteBase.getWidth(), spriteBase.getHeight());
        currentFrame.flip(false,false);

        attackFrame = new TextureRegion(spriteBase,spriteBase.getWidth(), spriteBase.getHeight());
        attackFrame.flip(false,false);

    }

    public static void walkAnimation(float frameDuration, final int walkState){
        posX = Controls.pointX;
        posY = Controls.pointY;

        walkTR = TextureRegion.split(charWalkSheet,charWalkSheet.getWidth() / FRAME_COLS,
                charWalkSheet.getHeight() / FRAME_ROWS);

        walkAnim = new Animation<TextureRegion>(frameDuration, walkTR[walkState]);
        currentFrame = walkAnim.getKeyFrame(stateTime, true);

    }

    public static void attackAnimation(float frameDuration, final int walkState, String attackType, String attackSheet, String attackSprite){
        posX = Controls.pointX;
        posY = Controls.pointY;

        charAttackSheet = new Texture(attackSheet);
        charAttackSprite = new Texture(attackSprite);
        //charAttackSprite.w

        attackTR = TextureRegion.split(charAttackSheet,charAttackSheet.getWidth() / FRAME_COLS,
                charAttackSheet.getHeight() / FRAME_ROWS);

        if (attackType == "kiBlast"){
            attackAnim = new Animation<TextureRegion>(frameDuration, attackTR[walkState]); //Hand Movements
            int posState = walkState;
            attackFrame = new TextureRegion(charAttackSprite);
            //attackPositionY = attackPositionY - 4;
            if (posState == 0){ //Down
                attackPositionY = attackPositionY - 4;
            }
            if (posState == 1){ //Left
                attackPositionX = attackPositionX - 4;
            }
            if (posState == 2){ //Right
                attackPositionX = attackPositionX + 4;
            }
            if (posState == 3){ //UP
                attackPositionY = attackPositionY + 4;
            }
        }

        currentFrame = attackAnim.getKeyFrame(stateTime,false);
        //attackPositionX = 0;
        //attackPositionY = 0;
    }


    public static void render(Graphics g){
        stateTime += Gdx.graphics.getDeltaTime();
        spriteBatch.begin();
        spriteBatch.draw(currentFrame, posX,posY);
        spriteBatch.draw(attackFrame,attackPositionX,attackPositionY);
        spriteBatch.end();
    }

    public void dispose(){
        spriteBatch.dispose();
        spriteBase.dispose();
        charWalkSheet.dispose();
        charAttackSheet.dispose();
        charAttackSprite.dispose();
    }
}
