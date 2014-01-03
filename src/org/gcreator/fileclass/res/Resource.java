package org.gcreator.fileclass.res;

import java.io.Serializable;

public abstract class Resource
  implements Serializable
{
  public String name;
  static final long serialVersionUID = 1L;

  public abstract String exportToHtml(boolean paramBoolean);

  public abstract Object clone();
}

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.res.Resource
 * JD-Core Version:    0.6.2
 */