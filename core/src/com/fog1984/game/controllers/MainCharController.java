package com.fog1984.game.controllers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class MainCharController implements InputProcessor {

    Sprite sprite;
    boolean checkKeyIsPressed;
    int keycode;

    public MainCharController(Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    public boolean keyDown(int keycode) {
        this.keycode = keycode;
        checkKeyIsPressed = true;
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        checkKeyIsPressed = false;
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public void move() {
        if (checkKeyIsPressed) {
            if (keycode == Input.Keys.A) {
                sprite.setPosition(sprite.getX() - 1f, sprite.getY());
            }
            if (keycode == Input.Keys.D) {
                sprite.setPosition(sprite.getX() + 1f, sprite.getY());
            }
            if (keycode == Input.Keys.W) {
                sprite.setPosition(sprite.getX(), sprite.getY() + 1f);
            }
            if (keycode == Input.Keys.S) {
                sprite.setPosition(sprite.getX(), sprite.getY() - 1f);
            }
        }
    }
}
