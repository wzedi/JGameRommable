package org.gcreator.refactoring;

import org.gcreator.fileclass.GFile;

public abstract interface RefactorContext
{
  public abstract GFile getModifiedFile();

  public abstract GFile getRefactoringFile();

  public abstract String getRefactoringDescription();
}

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.refactoring.RefactorContext
 * JD-Core Version:    0.6.2
 */