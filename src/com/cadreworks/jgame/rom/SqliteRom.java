package com.cadreworks.jgame.rom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jgame.JGColor;
import jgame.JGFont;
import jgame.JGObject;
import jgame.impl.Animation;
import jgame.platform.JGEngine;



/**
 * A ROM that reads the definition from a SQLite database.
 * 
 * This implementation uses JDBC to connect to the SQLite database. This is of particular
 * interest for Android apps because the standard approach to SQLite interaction is to
 * use the provided SQLite API for Android.
 * 
 * This implementation aims to be cross-platform to the extent that it can at least be used
 * in Java desktop, Applet and on Android devices. JDBC makes this possible.
 * 
 * Since JDBC is used this class relies on the SQLDroid library for Android.
 * 
 * @author wzedi
 *
 */
public class SqliteRom implements Rom {
	private Connection mConnection = null;
	private Statement mStatement = null;
	
	
	
	public SqliteRom(String aUrl) {
		try {
			mConnection = DriverManager.getConnection(aUrl, null, null);
			mStatement = mConnection.createStatement();
		} catch (SQLException vException) {
			mConnection = null;
		}
	}
	
	

	private double getDoubleProperty(String aPropertyName, double aDefault) {
		double vValue = aDefault;
		
		try {
			String vSql = String.format("SELECT Value FROM GameProperties WHERE Property = '%@'", aPropertyName);
			ResultSet vResultSet = mStatement.executeQuery(vSql);
			if (vResultSet.next()) {
				vValue = Double.parseDouble(vResultSet.getString(1));
			}
			vResultSet.close();
		} catch (Exception vException) {
			
		}
		
		return vValue;
	
	}
	


	private boolean getBooleanProperty(String aPropertyName, boolean aDefault) {
		boolean vValue = aDefault;
		
		try {
			String vSql = String.format("SELECT Value FROM GameProperties WHERE Property = '%@'", aPropertyName);
			ResultSet vResultSet = mStatement.executeQuery(vSql);
			if (vResultSet.next()) {
				vValue = Boolean.parseBoolean(vResultSet.getString(1));
			}
			vResultSet.close();
		} catch (Exception vException) {
			
		}
		
		return vValue;
	}

	
	
	private int getIntProperty(String aPropertyName, int aDefault) {
		int vValue = aDefault;
		
		try {
			String vSql = String.format("SELECT Value FROM GameProperties WHERE Property = '%@'", aPropertyName);
			ResultSet vResultSet = mStatement.executeQuery(vSql);
			if (vResultSet.next()) {
				vValue = Integer.parseInt(vResultSet.getString(1));
			}
			vResultSet.close();
		} catch (Exception vException) {
			
		}
		
		return vValue;
	}


	
	@Override
	public void loadMedia(JGEngine aEngine) {
		try {
			String vSql = "SELECT Value FROM GameProperties WHERE Property = 'MediaFiles'";
			ResultSet vResultSet = mStatement.executeQuery(vSql);
			if (vResultSet.next()) {
				String[] vMediaFiles = vResultSet.getString(1).split(";");
				for (String vMediaFile : vMediaFiles) {
					aEngine.defineMedia(vMediaFile);
				}
			}
			vResultSet.close();

			vSql = "SELECT Name, URI, XOffset, YOffset, TileWidth, TileHeight, SkipX, SkipY FROM ImageMap";
			vResultSet = mStatement.executeQuery(vSql);
			while (vResultSet.next()) {
				aEngine.defineImageMap(
						vResultSet.getString(1), 
						vResultSet.getString(2), 
						vResultSet.getInt(3), 
						vResultSet.getInt(4), 
						vResultSet.getInt(5), 
						vResultSet.getInt(6), 
						vResultSet.getInt(7),
						vResultSet.getInt(8));
			}
			vResultSet.close();

			vSql = "SELECT Name, TileName, CollisionId, MapName, MapIdX, ImageOp, Top, Left, Width, Height FROM ImageFromMap";
			vResultSet = mStatement.executeQuery(vSql);
			while (vResultSet.next()) {
				aEngine.defineImage(
						vResultSet.getString(1), 
						vResultSet.getString(2), 
						vResultSet.getInt(3), 
						vResultSet.getString(4),
						vResultSet.getInt(5),
						vResultSet.getString(5),
						vResultSet.getInt(6), 
						vResultSet.getInt(7), 
						vResultSet.getInt(8), 
						vResultSet.getInt(9));
			}
			vResultSet.close();

			vSql = "SELECT Name, TileName, CollisionId, URI, ImageOp, Top, Left, Width, Height FROM Image";
			vResultSet = mStatement.executeQuery(vSql);
			while (vResultSet.next()) {
				aEngine.defineImage(
						vResultSet.getString(1), 
						vResultSet.getString(2), 
						vResultSet.getInt(3), 
						vResultSet.getString(4),
						vResultSet.getString(5), 
						vResultSet.getInt(6), 
						vResultSet.getInt(7), 
						vResultSet.getInt(8), 
						vResultSet.getInt(9));
			}
			vResultSet.close();
			
			vSql = "SELECT ClipId, URI FROM AudioClip";
			vResultSet = mStatement.executeQuery(vSql);
			while (vResultSet.next()) {
				aEngine.defineAudioClip(vResultSet.getString(1), vResultSet.getString(2));
			}
			vResultSet.close();
			
			vSql = "SELECT Name, Frames, Speed, PingPong, Increment FROM Animation";
			vResultSet = mStatement.executeQuery(vSql);
			while (vResultSet.next()) {
				String vName = vResultSet.getString(1);
				String[] vFrames = vResultSet.getString(2).split(";");
				boolean vPingPong = vResultSet.getInt(4) == 1 ? true : false;
				aEngine.defineAnimation(vName, vFrames, vResultSet.getDouble(3), vPingPong);
				
				Animation vAnimation = aEngine.getAnimation(vName);
				vAnimation.increment = vResultSet.getInt(5);
			}
			vResultSet.close();
		} catch (Exception vException) {
			
		}
	}
	
	
	
	@Override
	public int[] getTileCount() {
		int[] vTileCount = new int[]{0, 0};
		
		try {
			vTileCount[0] = getIntProperty("TileCountHorizontal", 0);
			vTileCount[1] = getIntProperty("TileCountVertical", 0);
		} catch (Exception vException) {
			
		}
		
		return vTileCount;
	}

	
	
	@Override
	public int[] getTileSize() {
		int[] vTileSize = new int[]{0, 0};
		
		try {
			vTileSize[0] = getIntProperty("TileWidth", 0);
			vTileSize[1] = getIntProperty("TileHeight", 0);
		} catch (Exception vException) {
			
		}
		
		return vTileSize;
	}

	
	
	@Override
	public JGColor getTileColour() {
		JGColor vTileColour = JGColor.white;
		
		try {
			String vSql = "SELECT Value FROM GameProperties WHERE Property = 'TileColour'";
			ResultSet vResultSet = mStatement.executeQuery(vSql);
			if (vResultSet.next()) {
				String vValue = vResultSet.getString(1);
				String[] vParts = vValue.split(",");
				int vRed = Integer.parseInt(vParts[0]);
				int vGreen = Integer.parseInt(vParts[1]);
				int vBlue = Integer.parseInt(vParts[2]);
				vTileColour = new JGColor(vRed, vGreen, vBlue);
			}
			vResultSet.close();
		} catch (Exception vException) {
			
		}
		
		return vTileColour;
	}

	
	
	@Override
	public JGColor getTileBackgroundColour() {
		JGColor vTileBackgroundColour = JGColor.black;
		
		try {
			String vSql = "SELECT Value FROM GameProperties WHERE Property = 'TileBackgroundColour'";
			ResultSet vResultSet = mStatement.executeQuery(vSql);
			if (vResultSet.next()) {
				String vValue = vResultSet.getString(1);
				String[] vParts = vValue.split(",");
				int vRed = Integer.parseInt(vParts[0]);
				int vGreen = Integer.parseInt(vParts[1]);
				int vBlue = Integer.parseInt(vParts[2]);
				vTileBackgroundColour = new JGColor(vRed, vGreen, vBlue);
			}
			vResultSet.close();
		} catch (Exception vException) {
			
		}
		
		return vTileBackgroundColour;
	}

	
	
	@Override
	public JGFont getGameFont() {
		JGFont vGameFont = null;
		
		try {
			String vSql = "SELECT Value FROM GameProperties WHERE Property = 'GameFont'";
			ResultSet vResultSet = mStatement.executeQuery(vSql);
			if (vResultSet.next()) {
				String vValue = vResultSet.getString(1);
				String[] vParts = vValue.split(",");
				String vName = vParts[0];
				int vStyle = Integer.parseInt(vParts[1]);
				double vSize = Double.parseDouble(vParts[2]);
				vGameFont = new JGFont(vName, vStyle, vSize);
			}
			vResultSet.close();
		} catch (Exception vException) {
			
		}
		
		return vGameFont;
	}

	
	
	@Override
	public double getMinAspectRatio() {
		return getDoubleProperty("MinAspectRatio", 0.75d);
	}



	@Override
	public double getMaxAspectRatio() {
		return getDoubleProperty("MaxAspectRatio", 1.333d);
	}



	@Override
	public int[] getCropMargins() {
		int[] vCropMargins = new int[] {0, 0, 0, 0};
		
		vCropMargins[0] = getIntProperty("CropMarginTop", 0);
		vCropMargins[1] = getIntProperty("CropMarginLeft", 0);
		vCropMargins[2] = getIntProperty("CropMarginBottom", 0);
		vCropMargins[3] = getIntProperty("CropMarginRight", 0);
		
		return vCropMargins;
	}



	@Override
	public boolean isVideoSyncedUpdate() {
		return getBooleanProperty("VideoSyncedUpdated", false);
	}
	
	
	
	@Override
	public boolean isSequenceStateInGame(String aSequenceState) {
		return getBooleanProperty(aSequenceState + "InGame", false);
	}



	@Override
	public int getGameStateTicks(String aGameState) {
		return getIntProperty(aGameState + "Ticks", 80);
	}



	@Override
	public int getInitialLives() {
		return getIntProperty("InitialLives", 4);
	}



	@Override
	public double getFrameRate(Platform aPlatform) {
		return getDoubleProperty("FrameRate", 40.0d);
	}

	
	
	@Override
	public double getMaxFrameSkip(Platform aPlatform) {
		return getDoubleProperty("MaxSkipFrame", 0.0d);
	}

	
	
	@Override
	public double getGameSpeed(Platform aPlatform) {
		return getDoubleProperty("GameSpeed", 1.0d);
	}

	
	
	@Override
	public JGObject getObject(String aName, boolean aUniqueId) {
		JGObject vObject = null;
		
		try {
			String vSql = String.format("SELECT go.CollisionId, go.ExpiryPolicy, go.PositionX, go.PositionY, go.SpeedX, go.SpeedY, go.DirectionX, go.DirectionY, go.TileBBoxX, go.TileBBoxY, go.TileBBoxWidth, go.TileBBoxHeight, m.Name, a.Name INNER JOIN Media m ON m.ID = do.Image INNER JOIN Animation a ON a.ID = go.Animation FROM GameObject go WHERE go.Name = '%s'", aName);
			ResultSet vResultSet = mStatement.executeQuery(vSql);
			if (vResultSet.next()) {
				int vCollisionId = vResultSet.getInt(1);
				int vExpiryPolicy = vResultSet.getInt(2);
				double vPosX = vResultSet.getDouble(3);
				double vPosY = vResultSet.getDouble(4);
				double vSpeedX = vResultSet.getDouble(5);
				double vSpeedY = vResultSet.getDouble(6);
				int vDirectionX = vResultSet.getInt(7);
				int vDirectionY = vResultSet.getInt(8);
				int vTileBBoxX = vResultSet.getInt(9);
				int vTileBBoxY = vResultSet.getInt(10);
				int vTileBBoxWidth = vResultSet.getInt(11);
				int vTileBBoxHeight = vResultSet.getInt(12);
				
				String vImageName = vResultSet.getString(13);
				String vAnimationName = vResultSet.getString(14);
				String vGfxName = vImageName == null || "null".equals(vImageName) ? vAnimationName : vImageName;
				
				vObject = new JGObject(aName, aUniqueId, vPosX, vPosY, vCollisionId, vGfxName, vTileBBoxX, vTileBBoxY, vTileBBoxWidth, vTileBBoxHeight, vDirectionX, vDirectionY, vSpeedX, vSpeedY, vExpiryPolicy);
				vObject.setGraphic(vGfxName);
			}
			vResultSet.close();
		} catch (Exception vException) {
			
		}
		
		return vObject;
	}
}
