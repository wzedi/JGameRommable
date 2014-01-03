package org.gcreator.plugins;

import javax.swing.ImageIcon;
import org.gcreator.fileclass.GFile;
import org.gcreator.fileclass.Project;

public abstract interface FileOpenListener
{
  public abstract String[] getFileFormats();

  public abstract boolean openNewFile(GFile paramGFile, Project paramProject, ImageIcon paramImageIcon);

  public abstract Object generateResource(GFile paramGFile, String paramString);
}

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.plugins.FileOpenListener
 * JD-Core Version:    0.6.2
 */