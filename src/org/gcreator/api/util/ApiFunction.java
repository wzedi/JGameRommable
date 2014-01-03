/*    */ package org.gcreator.api.util;
/*    */ 
/*    */ public class ApiFunction
/*    */ {
/* 13 */   public String name = ""; public String doc = "";
/*    */ 
/*    */   ApiFunction(String name, String doc)
/*    */   {
/* 17 */     this.name = name;
/* 18 */     this.doc = doc;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 23 */     return this.name;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.api.util.ApiFunction
 * JD-Core Version:    0.6.2
 */