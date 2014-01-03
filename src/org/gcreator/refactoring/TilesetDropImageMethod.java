/*    */ package org.gcreator.refactoring;
/*    */ 
/*    */ import org.gcreator.fileclass.GFile;
/*    */ import org.gcreator.fileclass.res.Tileset;
/*    */ 
/*    */ public class TilesetDropImageMethod
/*    */   implements RefactoringMethod
/*    */ {
/*    */   public boolean accepts(RefactorContext context)
/*    */   {
/* 26 */     if (!(context instanceof DeleteRefactorContext))
/* 27 */       return false;
/* 28 */     DeleteRefactorContext delc = (DeleteRefactorContext)context;
/* 29 */     if ((delc.getRefactoringFile() == null) || (!delc.getRefactoringFile().type.equals("tileset")))
/* 30 */       return false;
/* 31 */     if (delc.getModifiedFile() == null)
/* 32 */       return false;
/* 33 */     if ((!delc.getModifiedFile().type.equals("gif")) && (!delc.getModifiedFile().type.equals("jpg")) && (!delc.getModifiedFile().type.equals("png")))
/*    */     {
/* 36 */       return false;
/* 37 */     }return true;
/*    */   }
/*    */ 
/*    */   public void refactor(RefactorContext context) {
/* 41 */     if (!(context instanceof DeleteRefactorContext))
/* 42 */       return;
/* 43 */     DeleteRefactorContext delc = (DeleteRefactorContext)context;
/* 44 */     GFile refactoring = delc.getRefactoringFile();
/* 45 */     GFile deleted = delc.getModifiedFile();
/* 46 */     if ((refactoring == null) || (deleted == null))
/* 47 */       return;
/* 48 */     Tileset tileset = (Tileset)refactoring.value;
/* 49 */     if (tileset == null)
/* 50 */       return;
/* 51 */     if (tileset.image == deleted)
/* 52 */       tileset.image = null;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.refactoring.TilesetDropImageMethod
 * JD-Core Version:    0.6.2
 */