/*    */ package org.gcreator.refactoring;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Vector;
/*    */ import org.gcreator.fileclass.GFile;
/*    */ import org.gcreator.fileclass.res.Scene;
/*    */ 
/*    */ public class SceneDropImageMethod
/*    */   implements RefactoringMethod
/*    */ {
/*    */   public boolean accepts(RefactorContext context)
/*    */   {
/* 26 */     if (!(context instanceof DeleteRefactorContext))
/* 27 */       return false;
/* 28 */     DeleteRefactorContext delc = (DeleteRefactorContext)context;
/* 29 */     if ((delc.getRefactoringFile() == null) || (!delc.getRefactoringFile().type.equals("scene")))
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
/* 48 */     Scene scene = (Scene)refactoring.value;
/* 49 */     if (scene == null)
/* 50 */       return;
/* 51 */     Vector img = scene.backgrounds;
/* 52 */     for (Iterator i$ = img.iterator(); i$.hasNext(); ) { Object o = i$.next();
/* 53 */       if (o == deleted)
/* 54 */         while (scene.backgrounds.contains(o))
/* 55 */           scene.backgrounds.removeElement(o);
/*    */     }
/* 57 */     scene.backgrounds.trimToSize();
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.refactoring.SceneDropImageMethod
 * JD-Core Version:    0.6.2
 */