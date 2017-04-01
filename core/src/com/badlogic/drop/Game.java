package com.badlogic.drop;

import com.badlogic.drop.api.Scene;
import com.badlogic.drop.managers.CameraManager;
import com.badlogic.drop.managers.SpriteRendererManager;
import com.badlogic.drop.scenes.MainGameScene;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.math.Rectangle;

import java.util.Iterator;

public class Game extends ApplicationAdapter {

	//private Sound dropSound;
	//private Music rainMusic;

	private Array<Rectangle> raindrops;
	private long lastDropTime;

	private Array<Scene> scenes;
	private SpriteRendererManager spriteRendererManager;
	private CameraManager cameraManager;

	private Scene mainScene;
	private World world;

	public Game(){
		world = new World(new Vector2(0, -10), true);

		scenes = new Array<Scene>();
		spriteRendererManager = SpriteRendererManager.getSpriteRenderManager();
		cameraManager = CameraManager.getCameraManager();
		mainScene = new MainGameScene(this, 800, 500, world);
	}

	@Override
	public void create () {

/*		dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));

		rainMusic.setLooping(true);;
		rainMusic.play(); */

		raindrops = new Array<Rectangle>();
		spawnRaindrop();

		cameraManager.create();
		spriteRendererManager.create();

		for (Scene scene : scenes) {
			scene.create();
		}
	}

	@Override
	public void render () {

		world.step(1/60f, 6, 2);

		// clear the screen with a dark blue color. The
		// arguments to glClearColor are the red, green
		// blue and alpha component in the range [0,1]
		// of the color to be used to clear the screen.
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// begin a new batch and draw the bucket and
		// all drops
		/*batch.begin();
		for(Rectangle raindrop: raindrops) {
			batch.draw(dropImage, raindrop.x, raindrop.y);
		}
		batch.end();*/

		// check if we need to create a new raindrop
		//if(TimeUtils.nanoTime() - lastDropTime > 1000000000) spawnRaindrop();

		// move the raindrops, remove any that are beneath the bottom edge of
		// the screen or that hit the bucket. In the later case we play back
		// a sound effect as well.
		/*Iterator<Rectangle> iter = raindrops.iterator();
		while(iter.hasNext()) {
			Rectangle raindrop = iter.next();
			raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
			if(raindrop.y + 64 < 0) iter.remove();
			if(raindrop.overlaps(bucket)) {
				dropSound.play();
				iter.remove();
			}
		}*/

		cameraManager.render();
		spriteRendererManager.render();

		for (Scene scene : scenes) {
			scene.render();
		}
	}
	
	@Override
	public void dispose () {

		cameraManager.dispose();
		spriteRendererManager.dispose();

		//dropImage.dispose();
		//dropSound.dispose();
		//rainMusic.dispose();

		for (Scene scene : scenes) {
			scene.dispose();
		}
	}

	private void spawnRaindrop() {
		Rectangle raindrop = new Rectangle();
		raindrop.x = MathUtils.random(0, 800-64);
		raindrop.y = 480;
		raindrop.width = 64;
		raindrop.height = 64;
		raindrops.add(raindrop);
		lastDropTime = TimeUtils.nanoTime();
	}

	public void registerScene(Scene newScene){
		scenes.add(newScene);
	}
}
