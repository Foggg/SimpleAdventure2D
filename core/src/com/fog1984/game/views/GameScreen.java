package com.fog1984.game.views;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class GameScreen implements Screen {

    private final Game game;
    private Texture gameImg;
    private final MainScreen mainScreen;

    public GameScreen(Game game, MainScreen mainScreen){
        this.game = game;
        this.mainScreen = mainScreen;
    }

    @Override
    public void show() {
        gameImg = new Texture("game.jpg");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mainScreen.batch.begin();
        mainScreen.batch.draw(gameImg, 0,0);
        mainScreen.batch.end();

        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
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
        mainScreen.dispose();
        gameImg.dispose();
        game.dispose();
    }
}
