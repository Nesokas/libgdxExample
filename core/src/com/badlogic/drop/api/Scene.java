package com.badlogic.drop.api;

import com.badlogic.drop.Game;
import com.badlogic.drop.managers.CameraManager;
import com.badlogic.drop.managers.GameObjectsManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

/**
 * Created by support on 30/03/2017.
 */
public abstract class Scene implements ApplicationCycle {

    private Game game;
    private ArrayList<GameObject> gameObjects;

    public OrthographicCamera mainCamera;
    public float width;
    public float height;
    public World world;

    public Scene(Game game, float width, float height, World world){
        this.game = game;
        this.world = world;

        game.registerScene(this);
        gameObjects = new ArrayList<GameObject>();

        mainCamera = new OrthographicCamera();
        mainCamera.setToOrtho(false, width, height);

        CameraManager.getCameraManager().addCamera(mainCamera);
    }

    public void registerGameObject(GameObject newGameObject){
        gameObjects.add(newGameObject);
        GameObjectsManager.getGameObjectsManager().registerGameObject(newGameObject);
    }

    @Override
    public final void create() {
        for (GameObject gameObject : gameObjects) {
            gameObject.create();
            gameObject.start();
        }
    }

    @Override
    public final void render() {
        mainCamera.update();

        for (GameObject gameObject : gameObjects) {
            gameObject.render();
            gameObject.update();
        }
    }

    @Override
    public final void resize(int width, int height) {
        for (GameObject gameObject : gameObjects) {
            gameObject.resize(width, height);
        }
    }

    @Override
    public final void pause() {
        for (GameObject gameObject : gameObjects) {
            gameObject.pause();
        }
    }

    @Override
    public final void resume() {
        for (GameObject gameObject : gameObjects) {
            gameObject.resume();
        }
    }

    @Override
    public final void dispose() {
        for (GameObject gameObject : gameObjects) {
            gameObject.dispose();
            gameObject.destroy();
        }
    }
}
