/*    */ package org.gcreator.managers;
/*    */ 
/*    */ import org.gcreator.fileclass.GObject;
/*    */ 
/*    */ public class FilesClipboard
/*    */ {
/* 16 */   private static GObject obj = null;
/*    */ 
/*    */   public static void setClipboardObject(GObject object) {
/* 19 */     obj = object;
/*    */   }
/*    */ 
/*    */   public static GObject getCliboardObject() {
/* 23 */     return obj;
/*    */   }
/*    */ 
/*    */   public static GObject copyObject() {
/* 27 */     return obj.clone();
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.managers.FilesClipboard
 * JD-Core Version:    0.6.2
 */