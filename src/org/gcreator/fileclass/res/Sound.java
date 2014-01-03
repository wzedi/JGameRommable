/*    */ package org.gcreator.fileclass.res;
/*    */ 
/*    */ public class Sound extends Resource
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/*    */   public byte[] sound;
/* 20 */   public String extension = "";
/*    */ 
/*    */   public Sound(String name) {
/* 23 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String exportToHtml(boolean xhtml)
/*    */   {
/* 29 */     return "";
/*    */   }
/*    */ 
/*    */   public Object clone() {
/* 33 */     throw new UnsupportedOperationException("Not supported yet.");
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.res.Sound
 * JD-Core Version:    0.6.2
 */