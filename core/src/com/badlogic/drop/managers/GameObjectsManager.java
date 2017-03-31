package com.badlogic.drop.managers;

import com.badlogic.drop.api.GameObject;

import java.util.ArrayList;

/**
 * Created by support on 30/03/2017.
 */
public class GameObjectsManager {

    public static GameObjectsManager gameObjectsManager;

    private ArrayList<GameObject> gameObjects;

    public static GameObjectsManager getGameObjectsManager(){
        if(gameObjectsManager == null)
            gameObjectsManager = new GameObjectsManager();

        return gameObjectsManager;
    }

    public GameObjectsManager(){
        gameObjects = new ArrayList<GameObject>();
    }

    public void registerGameObject(GameObject newGameObject){
        gameObjects.add(newGameObject);
    }

    public GameObject getGameObjectFromTag(String tag){
        for(GameObject gameObject : gameObjects){
            if(gameObject.getTag().equals(tag)){
                return gameObject;
            }
        }

        return null;
    }
}
