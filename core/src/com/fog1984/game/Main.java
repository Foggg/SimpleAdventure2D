package com.fog1984.game;

import com.badlogic.gdx.Game;
import com.fog1984.game.views.MainScreen;

public class Main extends Game {

	@Override
	public void create () {
		setScreen(new MainScreen(this));
	}
}
