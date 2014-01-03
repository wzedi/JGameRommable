/*    */ package org.gcreator.fileclass.res;
/*    */ 
/*    */ public class Classes extends Resource
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/* 18 */   public String value = "";
/*    */ 
/*    */   public Classes(String value) {
/* 21 */     this.value = value;
/*    */   }
/*    */ 
/*    */   public String writeXml() {
/* 25 */     return this.value;
/*    */   }
/*    */ 
/*    */   public void readXml(String xml)
/*    */   {
/* 30 */     this.value = xml;
/*    */   }
/*    */ 
/*    */   public String exportToHtml(boolean xhtml)
/*    */   {
/* 35 */     return "";
/*    */   }
/*    */ 
/*    */   public Object clone() {
/* 39 */     Classes a = new Classes(this.value);
/* 40 */     a.name = this.name;
/* 41 */     return a;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 46 */     return this.value;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.res.Classes
 * JD-Core Version:    0.6.2
 */