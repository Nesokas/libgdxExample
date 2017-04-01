package com.badlogic.drop.managers;

import com.badlogic.drop.api.ApplicationCycle;
import com.badlogic.gdx.graphics.Camera;

import java.util.ArrayList;

/**
 * Created by support on 30/03/2017.
 */
public class CameraManager implements ApplicationCycle {

    public static CameraManager cameraManager;

    private Camera mainCamera;
    private ArrayList<Camera> cameras;

    CameraManager() {
        cameras = new ArrayList<Camera>();
    }

    public static CameraManager getCameraManager() {
        if(cameraManager == null)
            cameraManager = new CameraManager();

        return cameraManager;
    }

    public Camera getMainCamera() {
        return mainCamera;
    }

    public void setMainCamera(Camera mainCamera) {
        this.mainCamera = mainCamera;
    }

    public void addCamera(Camera newCamera) {
        if(!cameras.contains(newCamera))
            cameras.add(newCamera);

        setMainCamera(newCamera);
    }

    @Override
    public void create() {

    }

    @Override
    public void render() {
        for(Camera camera : cameras)
            camera.update();
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
