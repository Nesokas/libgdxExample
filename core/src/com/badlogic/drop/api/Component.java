package com.badlogic.drop.api;

/**
 * Created by support on 30/03/2017.
 */
public abstract class Component implements ApplicationCycle {

    protected GameObject gameObject;

    public Component(GameObject gameObject){
        this.gameObject = gameObject;
        this.gameObject.registerComponent(this);
    }

    @Override
    public void create() {

    }

    @Override
    public void render() {

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

    }
}
