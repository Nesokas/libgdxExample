package com.badlogic.drop.game.objects;

import com.badlogic.drop.api.GameObject;
import com.badlogic.drop.api.Scene;
import com.badlogic.drop.components.SpriteRenderer;
import com.badlogic.drop.managers.GameObjectsManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Contact;

/**
 * Created by support on 30/03/2017.
 */
public class RainDrop extends GameObject {

    SpriteRenderer spriteRenderer;
    Bucket bucket;

    public RainDrop(Scene scene) {
        super(scene);
        spriteRenderer = new SpriteRenderer(this, "droplet.png", scene.width, scene.height);
    }

    @Override
    public void start() {
        bucket = (Bucket) GameObjectsManager.getGameObjectsManager().getGameObjectFromTag("Bucket");
    }

    @Override
    public void update() {
        transform.position.y -= 200 * Gdx.graphics.getDeltaTime();
    }

    @Override
    public void beginContact(Contact contact) {
        dropSound.play();
        iter.remove();
    }
}
