/*    */ package org.gcreator.components;
/*    */ 
/*    */ import java.io.File;
/*    */ import javax.swing.filechooser.FileFilter;
/*    */ 
/*    */ public class JFileFilter extends FileFilter
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String filter;
/*    */   private String desc;
/*    */ 
/*    */   public JFileFilter(String a, String b)
/*    */   {
/* 23 */     this.filter = a;
/* 24 */     this.desc = b;
/*    */   }
/*    */ 
/*    */   public boolean accept(File f)
/*    */   {
/* 29 */     if (f.isDirectory()) return true;
/* 30 */     String fname = f.getName().toLowerCase();
/* 31 */     if (fname.matches(this.filter))
/* 32 */       return true;
/* 33 */     return false;
/*    */   }
/*    */ 
/*    */   public String getDescription()
/*    */   {
/* 38 */     return this.desc;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.JFileFilter
 * JD-Core Version:    0.6.2
 */