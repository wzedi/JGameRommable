package org.gcreator.refactoring;

public abstract interface RefactoringMethod
{
  public abstract boolean accepts(RefactorContext paramRefactorContext);

  public abstract void refactor(RefactorContext paramRefactorContext);
}

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.refactoring.RefactoringMethod
 * JD-Core Version:    0.6.2
 */