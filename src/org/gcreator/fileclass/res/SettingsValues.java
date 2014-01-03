/*    */ package org.gcreator.fileclass.res;
/*    */ 
/*    */ public class SettingsValues extends Resource
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/* 18 */   private String[] keys = new String[20];
/* 19 */   private TabValues[] tabs = new TabValues[20];
/*    */ 
/*    */   public String[] getKeys() {
/* 22 */     int a = 0;
/* 23 */     for (String key : this.keys)
/* 24 */       if (key != null)
/* 25 */         a++;
/* 26 */     if (a == 0)
/* 27 */       return null;
/* 28 */     String[] x = new String[a];
/* 29 */     a = 0;
/* 30 */     for (String key : this.keys)
/* 31 */       if (key != null)
/* 32 */         x[(a++)] = key;
/* 33 */     return x;
/*    */   }
/*    */ 
/*    */   public boolean setVariable(String name, TabValues var) {
/* 37 */     if (name == null)
/* 38 */       return false;
/* 39 */     int pos = -1;
/* 40 */     for (int i = 0; i < this.tabs.length; i++)
/* 41 */       if (name.equals(this.keys[i]))
/* 42 */         pos = i;
/* 43 */     if (pos != -1) {
/* 44 */       this.tabs[pos] = var;
/* 45 */       return true;
/*    */     }
/*    */ 
/* 48 */     for (int i = 0; this.tabs[i] != null; i++) {
/* 49 */       if (i == this.keys.length - 1)
/* 50 */         return false;
/* 51 */       this.keys[i] = name;
/* 52 */       this.tabs[i] = var;
             }
/* 53 */     return true;
/*    */   }
/*    */ 
/*    */   public TabValues getValue(String name) {
/* 57 */     if (name == null)
/* 58 */       return null;
/* 59 */     int pos = -1;
/* 60 */     for (int i = 0; i < this.keys.length; i++)
/* 61 */       if (name.equals(this.keys[i]))
/* 62 */         pos = i;
/* 63 */     if (pos == -1)
/* 64 */       return null;
/* 65 */     return this.tabs[pos];
/*    */   }
/*    */ 
/*    */   public String writeXml() {
/* 69 */     String xml = "<settings>\n";
/* 70 */     for (int i = 0; i < this.keys.length; i++) {
/* 71 */       if (this.keys[i] != null) {
/* 72 */         xml = xml + "\t<tab name=\"" + this.keys[i] + "\">\n";
/* 73 */         xml = xml + this.tabs[i].writeXml();
/* 74 */         xml = xml + "\t</tab>\n";
/*    */       }
/*    */     }
/* 77 */     xml = xml + "</settings>\n";
/* 78 */     return xml;
/*    */   }
/*    */ 
/*    */   public void readXml(String xml) {
/*    */   }
/*    */ 
/*    */   public String exportToHtml(boolean xhtml) {
/* 85 */     return "";
/*    */   }
/*    */ 
/*    */   public Object clone() {
/* 89 */     SettingsValues a = new SettingsValues();
/*    */ 
/* 91 */     a.name = this.name;
/*    */ 
/* 93 */     return a;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.res.SettingsValues
 * JD-Core Version:    0.6.2
 */