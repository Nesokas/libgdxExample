package com.badlogic.drop.managers;

import com.badlogic.drop.api.ApplicationCycle;
import com.badlogic.drop.components.SpriteRenderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by support on 30/03/2017.
 */
public class SpriteRendererManager implements ApplicationCycle {

    public static SpriteRendererManager spriteRenderManager;

    private ArrayList<SpriteRenderer> spriteRenderers;
    private SpriteBatch batch;
    private CameraManager cameraManager;

    SpriteRendererManager(){
        spriteRenderers = new ArrayList<SpriteRenderer>();
        cameraManager = CameraManager.getCameraManager();
    }

    public static SpriteRendererManager getSpriteRenderManager(){
        if(spriteRenderManager == null)
            spriteRenderManager = new SpriteRendererManager();

        return spriteRenderManager;
    }

    public void registerSpriteRender(SpriteRenderer newSpriteRender){
        spriteRenderers.add(newSpriteRender);
    }


    @Override
    public void create() {
        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        batch.setProjectionMatrix(cameraManager.getMainCamera().combined);
        batch.begin();
        for(SpriteRenderer spriteRenderer : spriteRenderers) {
            spriteRenderer.draw(batch);
        }
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void start() {

    }

    @Override
    public void update() {

    }

    @Override
    public void onDestroy() {

    }
}
