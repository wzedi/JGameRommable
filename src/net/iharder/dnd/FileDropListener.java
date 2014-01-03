package net.iharder.dnd;

import java.util.EventListener;

public abstract interface FileDropListener extends EventListener
{
  public abstract void filesDropped(FileDropEvent paramFileDropEvent);
}

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     net.iharder.dnd.FileDropListener
 * JD-Core Version:    0.6.2
 */