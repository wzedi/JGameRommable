package com.cadreworks.jgame.rom;

import jgame.JGColor;
import jgame.JGFont;
import jgame.platform.StdGame;



/**
 * A ROM driven game.
 * 
 * @author wzedi
 *
 */
public class RomGame extends StdGame {

	/**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = -5707288238545069858L;

	
	
	/**
	 * The ROM containing the game definition.
	 */
	private final Rom mRom;
	
	
	
	/**
	 * Read the game definition from the provided ROM.
	 * 
	 * @param aRom
	 */
	public RomGame(Rom aRom) {
		mRom = aRom;
	}
	
	
	
	/**
	 * Launch the game as an Applet
	 */
	public void launchAsApplet() {
		initEngineApplet();
	}
	
	
	
	/**
	 * Launch the game as a full screen application.
	 */
	public void launch() {
		launch(0, 0);
	}
	

	
	/**
	 * Launch the game as an application with the specified screen size.
	 * 
	 * @param aWidth width of game screen
	 * @param aHeight height of game screen
	 */
	public void launch(int aWidth, int aHeight) {
		initEngine(aWidth, aHeight);
	}

	
	
	@Override
	public void initCanvas() {
		// TODO Auto-generated method stub
		int[] vTileCount = mRom.getTileCount();
		int[] vTileSize = mRom.getTileSize();
		JGColor vTileColour = mRom.getTileColour();
		JGColor vTileBackgroundColour = mRom.getTileBackgroundColour();
		JGFont vGameFont = mRom.getGameFont();

		setCanvasSettings(vTileCount[0],vTileCount[1],vTileSize[0],vTileSize[1],vTileColour,vTileBackgroundColour,vGameFont);
		
		double vMinAspectRatio = mRom.getMinAspectRatio();
		double vMaxAspectRatio = mRom.getMaxAspectRatio();
		int[] vCropMargins = mRom.getCropMargins();
		
		setScalingPreferences(vMinAspectRatio, vMaxAspectRatio, vCropMargins[0], vCropMargins[1], vCropMargins[2], vCropMargins[3]);
	}
	
	

	@Override
	public void initGame() {
		mRom.loadMedia(this);
		setVideoSyncedUpdate(mRom.isVideoSyncedUpdate());
		
		Platform vPlatform = Platform.GENERAL;
		if (isMidlet()) {
			vPlatform = Platform.MIDLET;
		} else if (isApplet()) {
			vPlatform = Platform.APPLET;
		} else if (isOpenGL()) {
			vPlatform = Platform.OPENGL;
		}
		
		double vFrameRate = mRom.getFrameRate(vPlatform);
		double vMaxFrameSkip = mRom.getMaxFrameSkip(vPlatform);
		double vGameSpeed = mRom.getGameSpeed(vPlatform);
		
		setFrameRate(vFrameRate, vMaxFrameSkip);
		setGameSpeed(vGameSpeed);

		//May want this to be more dynamic, potentially providing custom states like
		// levelintro, stagedone, stageintro, etc. WOuld have to move away from StdGame
		// for this.
		startgame_ingame = mRom.isSequenceStateInGame("StartGame");
		leveldone_ingame = mRom.isSequenceStateInGame("LevelDone");
	    lifelost_ingame = mRom.isSequenceStateInGame("LifeLost");
	    gameover_ingame = mRom.isSequenceStateInGame("GameOver");
	    
		startgame_ticks = mRom.getGameStateTicks("StartGame");
		leveldone_ticks = mRom.getGameStateTicks("LevelDone");
		lifelost_ticks = mRom.getGameStateTicks("LifeLost");
		gameover_ticks = mRom.getGameStateTicks("GameOver");

		initial_lives = mRom.getInitialLives();
	    
		//setHighscores(10,new Highscore(0,"nobody"),15);
		//startgame_ingame=true;
	}

}
