/*    */ package org.gcreator.api.util;
/*    */ 
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class ApiClass
/*    */ {
/* 14 */   public String name = ""; public String doc = "";
/* 15 */   public Vector functions = new Vector();
/*    */ 
/*    */   ApiClass(String name)
/*    */   {
/* 19 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 25 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void add(ApiFunction af) {
/* 29 */     this.functions.add(af);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.api.util.ApiClass
 * JD-Core Version:    0.6.2
 */