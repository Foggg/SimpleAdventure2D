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
    private float logoX = 1500;
    private float logoY = 750;
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
        sprite.setBounds((float)Gdx.graphics.getWidth() / 2 - logoX / 2, (float)Gdx.graphics.getHeight() / 2 - logoY / 2, logoX, logoY);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite.draw(batch);
        gameName.draw(batch, "Simple Adventure 2D", (float)Gdx.graphics.getWidth() / 2 - 70, (float)Gdx.graphics.getHeight() / 2 + 100);
        pressEnter.draw(batch, "Press Enter to Start", (float)Gdx.graphics.getWidth() / 2 - 70, (float)Gdx.graphics.getHeight() / 2 - 350);
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
