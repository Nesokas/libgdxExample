package com.badlogic.drop.api;

import com.badlogic.drop.components.Transform;
import com.badlogic.gdx.graphics.Camera;

import java.util.ArrayList;

/**
 * Created by support on 30/03/2017.
 */
public abstract class GameObject implements ApplicationCycle {

    public Transform transform;
    public Scene scene;

    private String tag;
    private ArrayList<Component> components;

    public GameObject(Scene scene){
        this.scene = scene;

        scene.registerGameObject(this);

        components = new ArrayList<Component>();
        transform = new Transform();
    }

    public void registerComponent(Component newComponent){
        components.add(newComponent);
    }

    public Camera getMainCamera(){
        return scene.mainCamera;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public final void create() {
        for (Component component : components) {
            component.create();
            component.start();
        }
    }

    @Override
    public final void render() {
        for (Component component : components) {
            component.render();
            component.update();
        }
    }

    @Override
    public final void resize(int width, int height) {
        for (Component component : components) {
            component.resize(width, height);
        }
    }

    @Override
    public final void pause() {
        for (Component component : components) {
            component.pause();
        }
    }

    @Override
    public final void resume() {
        for (Component component : components) {
            component.resume();
        }
    }

    @Override
    public final void dispose() {
        for (Component component : components) {
            component.dispose();
            component.destroy();
        }
    }
}
