package com.badlogic.drop.components.physics.collider.box;

import com.badlogic.drop.api.Component;
import com.badlogic.drop.api.GameObject;
import com.badlogic.drop.components.physics.collider.Collider;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by support on 31/03/2017.
 */
public abstract class BoxCollider extends Component implements Collider {

    protected BodyDef bodyDef;
    protected Body body;
    protected PolygonShape shape;

    public BoxCollider(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void start() {
        bodyDef = new BodyDef();
        setBodyType();

        bodyDef.position.set(gameObject.transform.position.x, gameObject.transform.position.y);

        body = gameObject.scene.world.createBody(bodyDef);

        shape = new PolygonShape();
    }

    public void setSize(float width, float height){
        shape.setAsBox(width/2, height/2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;

        body.createFixture(fixtureDef);

        shape.dispose();
    }

    @Override
    public void update() {
        gameObject.scene.world.step(Gdx.graphics.getDeltaTime(), 6, 2);
        updatePosition();
    }

    @Override
    public void destroy() {

    }

    public abstract void setBodyType();

    public abstract void updatePosition();
}
