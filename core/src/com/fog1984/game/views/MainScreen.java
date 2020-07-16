package com.fog1984.game.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainScreen implements Screen {

    public SpriteBatch batch;
    public Game game;
    private Texture mainTexture;
    private BitmapFont gameName;
    private BitmapFont pressEnter;
    public Sprite sprite;

    public MainScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        mainTexture = new Texture("cover.jpg");
        mainTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        gameName = new BitmapFont();
        pressEnter = new BitmapFont();
        sprite = new Sprite(mainTexture);
        sprite.setBounds(200, 200, 500,250);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite.draw(batch);
        gameName.draw(batch, "Simple Adventure 2D", 700, 700);
        pressEnter.draw(batch, "Press Enter to Start", 200, 200);
        gameName.setColor(1, 1, 0, 1);
        pressEnter.setColor(1, 0, 0, 1);
        batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            game.setScreen(new GameScreen(game));
        }
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
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        mainTexture.dispose();
        gameName.dispose();
        game.dispose();
    }
}
