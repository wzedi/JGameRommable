/*    */ package org.gcreator.fileclass.res;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class TabValues
/*    */   implements Serializable
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/*    */   public String name;
/*    */   private String[] names;
/*    */   private Object[] vars;
/*    */ 
/*    */   public TabValues(String name)
/*    */   {
/* 26 */     this.name = name;
/* 27 */     this.names = new String[50];
/* 28 */     this.vars = new Object[50];
/*    */   }
/*    */ 
/*    */   public String[] getKeys() {
/* 32 */     int a = 0;
/* 33 */     for (String name : this.names)
/* 34 */       if (name != null)
/* 35 */         a++;
/* 36 */     if (a == 0)
/* 37 */       return null;
/* 38 */     String[] x = new String[a];
/* 39 */     a = 0;
/* 40 */     for (String name : this.names)
/* 41 */       if (name != null)
/* 42 */         x[(a++)] = name;
/* 43 */     return x;
/*    */   }
/*    */ 
/*    */   public boolean setVariable(String name, Object var) {
/* 47 */     if (name == null)
/* 48 */       return false;
/* 49 */     int pos = -1;
/* 50 */     for (int i = 0; i < this.vars.length; i++)
/* 51 */       if (name.equals(this.names[i]))
/* 52 */         pos = i;
/* 53 */     if (pos != -1) {
/* 54 */       this.vars[pos] = var;
/* 55 */       return true;
/*    */     }
/*    */ 
/* 58 */     for (int i = 0; this.vars[i] != null; i++) {
/* 59 */       if (i == this.vars.length - 1)
/* 60 */         return false;
/* 61 */       this.names[i] = name;
/* 62 */       this.vars[i] = var;
             }
/* 63 */     return true;
/*    */   }
/*    */ 
/*    */   public Object getValue(String name) {
/* 67 */     if (name == null)
/* 68 */       return null;
/* 69 */     if (this.names == null)
/* 70 */       return null;
/* 71 */     int pos = -1;
/* 72 */     for (int i = 0; i < this.names.length; i++)
/* 73 */       if (name.equals(this.names[i]))
/* 74 */         pos = i;
/* 75 */     if (pos == -1)
/* 76 */       return null;
/* 77 */     return this.vars[pos];
/*    */   }
/*    */ 
/*    */   public String writeXml() {
/* 81 */     if (this.names == null)
/* 82 */       return null;
/* 83 */     String xml = "";
/* 84 */     for (int i = 0; i < this.names.length; i++) {
/* 85 */       if (this.names[i] != null) {
/* 86 */         xml = xml + "\t\t<option>\n\t\t\t<name>" + this.names[i] + "</name>\n\t\t\t<value>" + this.vars[i].toString().replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;") + "</value>\n\t\t</option>\n";
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 91 */     return xml;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.res.TabValues
 * JD-Core Version:    0.6.2
 */