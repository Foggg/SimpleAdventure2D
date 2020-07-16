package com.fog1984.game.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends MainScreen implements Screen {

    private Texture gameImg;
    private OrthographicCamera camera;

    float x = 512;

    public GameScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        gameImg = new Texture("game.jpg");
        gameImg.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(512, 384, 0);
        sprite = new Sprite(new Texture(Gdx.files.internal("chuk.png")));
        sprite.setBounds(0, 0, 250,500);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(gameImg, 0, 0, 2048, 1536);
        batch.draw(sprite, 1500,100 , 50,100);
        x++;
        camera.position.x = x;
        batch.end();

        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            pause();
            game.setScreen(new MainScreen(game));
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
        gameImg.dispose();
        game.dispose();
    }
}
