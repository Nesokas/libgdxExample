package com.badlogic.drop.components;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by support on 30/03/2017.
 */
public class Transform {
    public Vector2 position;
    public Vector2 scale;
    public Vector2 rotation;

    public Transform(){
        position = new Vector2(0,0);
        scale = new Vector2(0,0);
        rotation = new Vector2(0,0);
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }
}
