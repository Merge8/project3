package com.mikedepinto.robotgame;

import com.mikedepinto.framework.Game;
import com.mikedepinto.framework.Graphics;
import com.mikedepinto.framework.Graphics.ImageFormat;
import com.mikedepinto.framework.Screen;

public class LoadingScreen extends Screen {
	public LoadingScreen(Game game) {
		
		super(game);
	}

	@Override
	public void update(float deltaTime) {
		Graphics g = game.getGraphics();
		Assets.menu = g.newImage("menu.png", ImageFormat.RGB565);
		Assets.background = g.newImage("background.png", ImageFormat.RGB565);
		Assets.character = g.newImage("character.png", ImageFormat.ARGB4444);
		Assets.character2 = g.newImage("character2.png", ImageFormat.ARGB4444);
		Assets.character3  = g.newImage("character3.png", ImageFormat.ARGB4444);
		Assets.characterJump = g.newImage("jumped.png", ImageFormat.ARGB4444);
		Assets.characterDown = g.newImage("down.png", ImageFormat.ARGB4444);

        // import sword
       Assets.characterSword = g.newImage("sword1.png", ImageFormat.ARGB4444);
		
		Assets.heliboy = g.newImage("heliboy.png", ImageFormat.ARGB4444);
		Assets.heliboy2 = g.newImage("heliboy2.png", ImageFormat.ARGB4444);
		Assets.heliboy3  = g.newImage("heliboy3.png", ImageFormat.ARGB4444);
		Assets.heliboy4  = g.newImage("heliboy4.png", ImageFormat.ARGB4444);
		Assets.heliboy5  = g.newImage("heliboy5.png", ImageFormat.ARGB4444);


		
		Assets.tiledirt = g.newImage("tiledirt.png", ImageFormat.RGB565);
		Assets.tilegrassTop = g.newImage("tilegrasstop.png", ImageFormat.RGB565);
		Assets.tilegrassBot = g.newImage("tilegrassbot.png", ImageFormat.RGB565);
		Assets.tilegrassLeft = g.newImage("tilegrassleft.png", ImageFormat.RGB565);
		Assets.tilegrassRight = g.newImage("tilegrassright.png", ImageFormat.RGB565);


        // import UI
        Assets.rightArrow = g.newImage("arrow.png", ImageFormat.ARGB4444);
        Assets.attackButton = g.newImage("attackButton.png", ImageFormat.ARGB4444);
        Assets.jumpButton = g.newImage("jumpButton.png", ImageFormat.ARGB4444);
        Assets.attackButton2 = g.newImage("attackButton2.png", ImageFormat.ARGB4444);

		Assets.button = g.newImage("button.jpg", ImageFormat.RGB565);
        Assets.store = g.newImage("store.png", ImageFormat.RGB565);

		//This is how you would load a sound if you had one.
		//Assets.click = game.getAudio().createSound("explode.ogg");

		
		game.setScreen(new MainMenuScreen(game));

	}

	@Override
	public void paint(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawImage(Assets.splash, 0, 0);
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
	public void backButton() {

	}
}