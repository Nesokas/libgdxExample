package com.badlogic.drop.components.physics.collider.box;

import com.badlogic.drop.api.GameObject;
import com.badlogic.gdx.physics.box2d.BodyDef;

public class BoxColliderFactory {
    public enum Type {
        STATIC,
        DYNAMIC
    }

    public static BoxCollider getBoxCollider(GameObject gameObject, Type type){
        switch (type){
            case STATIC:
                return new StaticBoxCollider(gameObject);
            default:
                return new DynamicBoxCollider(gameObject);
        }
    }
}

class StaticBoxCollider extends BoxCollider {

    public StaticBoxCollider(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void setBodyType() {
        bodyDef.type = BodyDef.BodyType.StaticBody;
    }

    @Override
    public void updatePosition() {
        bodyDef.position.set(gameObject.transform.position.x, gameObject.transform.position.y);
    }
}

class DynamicBoxCollider extends BoxCollider {

    public DynamicBoxCollider(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void setBodyType() {
        bodyDef.type = BodyDef.BodyType.DynamicBody;
    }

    @Override
    public void updatePosition() {
        gameObject.transform.setPosition(body.getPosition());
    }
}
