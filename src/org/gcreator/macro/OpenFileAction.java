/*    */ package org.gcreator.macro;
/*    */ 
/*    */ import org.gcreator.core.Aurwindow;
/*    */ import org.gcreator.core.gcreator;
/*    */ import org.gcreator.fileclass.GFile;
/*    */ 
/*    */ public class OpenFileAction
/*    */   implements MacroAction
/*    */ {
/*    */   private GFile file;
/*    */ 
/*    */   public OpenFileAction(GFile file)
/*    */   {
/* 18 */     this.file = file;
/*    */   }
/*    */   public GFile getFile() {
/* 21 */     return this.file;
/*    */   }
/*    */   public void setFile(GFile file) {
/* 24 */     this.file = file;
/*    */   }
/*    */   public void play() {
/* 27 */     gcreator.window.Open(this.file);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.macro.OpenFileAction
 * JD-Core Version:    0.6.2
 */