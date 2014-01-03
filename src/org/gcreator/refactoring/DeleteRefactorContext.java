/*    */ package org.gcreator.refactoring;
/*    */ 
/*    */ import org.gcreator.fileclass.GFile;
/*    */ 
/*    */ public class DeleteRefactorContext
/*    */   implements RefactorContext
/*    */ {
/*    */   private GFile deleted;
/*    */   private GFile refactoring;
/*    */ 
/*    */   public DeleteRefactorContext(GFile deleted, GFile refactoring)
/*    */   {
/* 21 */     this.deleted = deleted;
/* 22 */     this.refactoring = refactoring;
/*    */   }
/*    */ 
/*    */   public GFile getRefactoringFile() {
/* 26 */     return this.refactoring;
/*    */   }
/*    */ 
/*    */   public GFile getModifiedFile() {
/* 30 */     return this.deleted;
/*    */   }
/*    */ 
/*    */   public String getRefactoringDescription() {
/* 34 */     return "A file was deleted.";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.refactoring.DeleteRefactorContext
 * JD-Core Version:    0.6.2
 */