package org.gcreator.actions.extensible;

import javax.swing.JComponent;

public abstract interface Argument
{
  public abstract JComponent generateComponent(int paramInt);

  public abstract Object getValue(JComponent paramJComponent);
}

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.extensible.Argument
 * JD-Core Version:    0.6.2
 */