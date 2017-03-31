package com.badlogic.drop.api;

/**
 * Created by support on 30/03/2017.
 */
public interface ApplicationCycle {

    public void create ();

    public void render ();

    public void resize (int width, int height);

    public void pause ();

    public void resume ();

    public void dispose ();

    public void start();

    public void update();

    public void onDestroy();
}
