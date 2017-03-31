package com.badlogic.drop.game.objects;

import com.badlogic.drop.api.GameObject;
import com.badlogic.drop.api.Scene;
import com.badlogic.drop.components.SpriteRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by support on 30/03/2017.
 */
public class Bucket extends GameObject {

    private SpriteRenderer spriteRenderer;

    public Bucket(Scene scene){
        super(scene);
        spriteRenderer = new SpriteRenderer(this, "bucket.png", 64, 64);
        setTag("Bucket");
    }

    @Override
    public void start() {
        transform.position.x = 800;
        transform.position.y = 20;
    }

    @Override
    public void update() {
        // process user input
        if(Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            getMainCamera().unproject(touchPos);
            transform.position.x = touchPos.x - 64 / 2;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) transform.position.x -= 200 * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) transform.position.x += 200 * Gdx.graphics.getDeltaTime();

        // make sure the bucket stays within the screen bounds
        if(transform.position.x < 0) transform.position.x = 0;
        if(transform.position.x > 800 - 64) transform.position.x = scene.mainCamera.viewportWidth - 64;
    }

    @Override
    public void destroy() {

    }
}
