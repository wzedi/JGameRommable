/*    */ package net.iharder.dnd;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.util.EventObject;
/*    */ 
/*    */ public class FileDropEvent extends EventObject
/*    */ {
/*    */   private File[] files;
/*    */ 
/*    */   public FileDropEvent(File[] files, Object source)
/*    */   {
/* 32 */     super(source);
/* 33 */     this.files = files;
/*    */   }
/*    */ 
/*    */   public File[] getFiles()
/*    */   {
/* 44 */     return this.files;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     net.iharder.dnd.FileDropEvent
 * JD-Core Version:    0.6.2
 */