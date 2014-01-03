package com.cadreworks.jgame.rom;

import jgame.JGColor;
import jgame.JGFont;
import jgame.JGObject;
import jgame.platform.JGEngine;



/**
 * An interface through which a RomGame can retrieve a game definition.
 * 
 * A ROM is a game definition that can be stored in various ways.
 * @author wzedi
 *
 */
public interface Rom {
	/**
	 * Load the media definitions. This method reads the image, audio clip and animation
	 * definitions and calls the media definition functions in the engine.
	 * 
	 */
	void loadMedia(JGEngine aEngine);
	
	
	
	/**
	 * Returns the number of tiles horizontally and vertically.
	 * 
	 * @return an array with the number of tiles
	 */
	int[] getTileCount();
	
	
	
	/**
	 * Get the width and height of the tile.
	 * 
	 * @return an array containing the width and height.
	 */
	int[] getTileSize();
	
	
	
	/**
	 * Get the tile foreground colour.
	 * 
	 * @return The foreground colour of the tile.
	 */
	JGColor getTileColour();
	
	
	
	/**
	 * Get the tile background colour.
	 * 
	 * @return The background colour of the tile.
	 */
	JGColor getTileBackgroundColour();
	
	
	
	/**
	 * Get the game font
	 * 
	 * @return The font for messages and text in the game
	 */
	JGFont getGameFont();
	
	
	
	/**
	 * Get the minimum aspect ratio
	 * 
	 * @return the minimum aspect ratio for the display.
	 */
	double getMinAspectRatio();
	
	
	
	/**
	 * Get the maximum aspect ratio
	 * 
	 * @return the minimum aspect ratio for the display.
	 */
	double getMaxAspectRatio();

	
	
	/**
	 * Get crop margins for the display
	 * 
	 * @return an int array with the crop margins {top, left, bottom, right}
	 */
	int[] getCropMargins();
	
	
	
	/**
	 * Is Video Synced update enabled
	 * 
	 * @return true if Video Synced update must be enabled, otherwise false
	 */
	boolean isVideoSyncedUpdate();
	
	
	
	/**
	 * Should InGame state be retained when in the specified sequence state
	 * 
	 * @param aSequenceState the sequence state to test, e.g. LevelDone, StartGame, etc
	 * 
	 * @return true if InGame state should be retained, otherwise false
	 */
	boolean isSequenceStateInGame(String aSequenceState);
	
	
	
	/**
	 * Get the number of ticks to stay in each game state.
	 * 
	 * @param aGameState the game state to test
	 * 
	 * @return the number of ticks to stay in the specified game state
	 */
	int getGameStateTicks(String aGameState);
	
	
	
	/**
	 * Get the number of lives to start the game with.
	 * 
	 * @return the number of lives to start the game with.
	 */
	int getInitialLives();
	
	
	boolean isLevelDoneIngame=false,
            lifelost_ingame=false, gameover_ingame=false;
	/**
	 *  Get the game frame rate.
	 *  
	 *  @return the frame rate for the game
	 */
	double getFrameRate(Platform aPlatform);
	
	
	
	/**
	 * Get max frames to be skipped
	 * 
	 * @return maximum number of frames that can be skipped.
	 */
	double getMaxFrameSkip(Platform aPlatform);
	
	
	
	/**
	 * Get the game speed
	 * 
	 * @return the game speed
	 */
	double getGameSpeed(Platform aPlatform);
	
	
	
	/**
	 * Get a new instance of the object with the given name.
	 * 
	 * @return an instance of the named object if the object exists
	 */
	JGObject getObject(String aName, boolean aUniqueId);
}
