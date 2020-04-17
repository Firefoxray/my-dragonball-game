package com.rayco.dragonball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.rayco.dragonball.players.PlayerInit;
import org.mini2Dx.core.graphics.Graphics;

public class GameMap extends TiledMap {

    //
    public static TiledMap tiledMap;
    public static TiledMapRenderer tiledMapRenderer;
    public static TiledMapTileLayer tileLayer;
    public static TiledMapTileLayer.Cell cell;
    public static OrthographicCamera camera;
    public static int posX;
    public static int posY;

    //MapLayers
    public static MapLayer groundLayer;
    public static MapLayer middleLayer;
    public static MapLayer topLayer;
    public static MapLayer collObjectLayer;

    //Class Init
    public static AnimationEngine animationEngine;
    public static PlayerInit playerInit;
    public static Controls controls;

    public GameMap(){
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false,w,h);
        camera.update();
        tiledMap = new TmxMapLoader().load("maps/test4.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        int mapWidth = tiledMap.getProperties().get("width",Integer.class);
        int mapHeight = tiledMap.getProperties().get("height",Integer.class);
        tileLayer = new TiledMapTileLayer(mapWidth,mapHeight,32,32);
        cell = new TiledMapTileLayer.Cell();
    }
    public void update(){

    }

    public static boolean isCellBlocked(float a, float b, String direction){
        boolean isBlocked = false;


        int checkX = (Math.round(a) / 32);
        int checkY = (Math.round(b) / 32);

        TiledMapTileLayer collisionLayer = (TiledMapTileLayer)tiledMap.getLayers().get("TOP");

        TiledMapTileLayer.Cell cell = new TiledMapTileLayer.Cell();
        if(direction == "n"){
            cell = collisionLayer.getCell(checkX,checkY + 1);
        }
        if(direction == "s"){
            cell = collisionLayer.getCell(checkX,checkY - 1);
        }
        if(direction == "e"){
            cell = collisionLayer.getCell(checkX + 1,checkY);
        }
        if(direction == "w"){
            cell = collisionLayer.getCell(checkX - 1,checkY);
        }

        if(cell != null){
            TiledMapTile tile = cell.getTile();
            if (tile != null && tile.getProperties().containsKey("wall")) {
                isBlocked = true;
            }
        }
        return isBlocked;
    }

    public void render(Graphics g){
        posX = Controls.pointX;
        posY = Controls.pointY;


        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.position.x = posX;
        camera.position.y = posY;
        camera.update();
        tiledMapRenderer.setView(camera);
        animationEngine.spriteBatch.setProjectionMatrix(camera.combined);

        tiledMapRenderer.render();
        animationEngine.render(g);

    }

    public void dispose(){
        tiledMap.dispose();
    }


}
