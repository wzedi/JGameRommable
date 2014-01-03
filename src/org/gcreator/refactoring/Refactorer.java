/*    */ package org.gcreator.refactoring;
/*    */ 
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class Refactorer
/*    */ {
/* 18 */   private static Vector<RefactoringMethod> collection = new Vector();
/*    */ 
/*    */   public static void addRefactoringMethod(RefactoringMethod method)
/*    */   {
/* 28 */     collection.add(method);
/*    */   }
/*    */ 
/*    */   public static RefactoringMethod getRefactoringMethod(RefactorContext context) {
/* 32 */     if (context == null)
/* 33 */       return null;
/* 34 */     for (RefactoringMethod m : collection) {
/* 35 */       if (m.accepts(context))
/* 36 */         return m;
/*    */     }
/* 38 */     return null;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 22 */     addRefactoringMethod(new SpriteDropImageMethod());
/* 23 */     addRefactoringMethod(new TilesetDropImageMethod());
/* 24 */     addRefactoringMethod(new SceneDropImageMethod());
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.refactoring.Refactorer
 * JD-Core Version:    0.6.2
 */