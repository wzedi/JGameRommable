package org.gcreator.plugins;

import org.gcreator.editors.SettingsEditor;

public abstract interface SettingsManager
{
  public abstract void open(SettingsEditor paramSettingsEditor);

  public abstract boolean close(SettingsEditor paramSettingsEditor);
}

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.plugins.SettingsManager
 * JD-Core Version:    0.6.2
 */