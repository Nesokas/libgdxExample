package com.badlogic.drop.scenes;

import com.badlogic.drop.Game;
import com.badlogic.drop.api.Scene;
import com.badlogic.drop.game.objects.Bucket;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by support on 30/03/2017.
 */
public class MainGameScene extends Scene {

    public Bucket bucket;

    public MainGameScene(Game game, float width, float height, World world) {
        super(game, width, height, world);
        bucket = new Bucket(this);
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
