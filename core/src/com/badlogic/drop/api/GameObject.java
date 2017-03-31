package com.badlogic.drop.api;

import com.badlogic.drop.components.Transform;
import com.badlogic.drop.game.objects.Bucket;
import com.badlogic.drop.managers.GameObjectsManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.Manifold;

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

    public void beginContact(Contact contact) {}

    public void endContact(Contact contact) {}

    public void preSolve(Contact contact, Manifold oldManifold) {}

    public void postSolve(Contact contact, ContactImpulse impulse) {}

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
            component.onDestroy();
        }
    }

    @Override
    public void start() {}

    @Override
    public void update() {}

    @Override
    public void onDestroy() {}

    public void destroy() {}
}
