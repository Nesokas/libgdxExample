package com.badlogic.drop.components;

import com.badlogic.drop.api.Component;
import com.badlogic.drop.api.GameObject;
import com.badlogic.drop.managers.SpriteRendererManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by support on 30/03/2017.
 */
public class SpriteRenderer extends Component {

    private String assetPath;

    public Texture texture;
    public Rectangle rectangle;

    public float width;
    public float height;

    public SpriteRenderer(GameObject gameObject, String assetPath, float width, float height) {
        super(gameObject);
        this.assetPath = assetPath;

        this.width = width;
        this.height = height;

        SpriteRendererManager.getSpriteRenderManager().registerSpriteRender(this);
    }

    public void draw(SpriteBatch batch){
        batch.draw(texture, rectangle.x, rectangle.y);
    }

    @Override
    public void start() {
        texture = new Texture(Gdx.files.internal(assetPath));

        rectangle = new Rectangle();
        rectangle.x = gameObject.transform.position.x / 2 - width / 2;
        rectangle.y = gameObject.transform.position.y;
        rectangle.width = width;
        rectangle.height = height;
    }

    @Override
    public void update() {
        rectangle.x = gameObject.transform.position.x / 2 - width / 2;
        rectangle.y = gameObject.transform.position.y;
    }

    @Override
    public void destroy() {
        texture.dispose();
    }
}
