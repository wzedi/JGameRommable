/*    */ package org.gcreator.fileclass.res;
/*    */ 
/*    */ public class Script extends Resource
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/* 14 */   public String value = "";
/*    */ 
/*    */   public Script(String value) {
/* 17 */     this.value = value;
/*    */   }
/*    */ 
/*    */   public String exportToHtml(boolean xhtml)
/*    */   {
/* 22 */     throw new UnsupportedOperationException("Not supported yet.");
/*    */   }
/*    */ 
/*    */   public Object clone()
/*    */   {
/* 27 */     return new Script(this.value);
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 31 */     return this.value;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.res.Script
 * JD-Core Version:    0.6.2
 */