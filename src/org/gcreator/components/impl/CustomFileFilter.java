/*    */ package org.gcreator.components.impl;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FilenameFilter;
/*    */ import java.io.PrintStream;
/*    */ import javax.swing.filechooser.FileFilter;
/*    */ 
/*    */ public class CustomFileFilter extends FileFilter
/*    */   implements FilenameFilter
/*    */ {
/* 24 */   private String format = "";
/* 25 */   private String description = "";
/*    */ 
/*    */   public CustomFileFilter(String format, String description)
/*    */   {
/* 33 */     this.format = format;
/* 34 */     this.description = description;
/*    */   }
/*    */ 
/*    */   public String getAcceptedFormat()
/*    */   {
/* 42 */     return this.format;
/*    */   }
/*    */ 
/*    */   public void setAcceptedFormat(String format)
/*    */   {
/* 50 */     this.format = format;
/*    */   }
/*    */ 
/*    */   public String getDescription()
/*    */   {
/* 58 */     return this.description;
/*    */   }
/*    */ 
/*    */   public void setDescription(String description)
/*    */   {
/* 66 */     this.description = description;
/*    */   }
/*    */ 
/*    */   public boolean accept(File file)
/*    */   {
/* 77 */     if (file.isDirectory())
/* 78 */       return true;
/* 79 */     if (file.getAbsolutePath().endsWith(this.format)) {
/* 80 */       return true;
/*    */     }
/* 82 */     return false;
/*    */   }
/*    */ 
/*    */   public boolean accept(File dir, String name)
/*    */   {
/* 94 */     System.out.println(name);
/* 95 */     if (name.endsWith("." + this.format))
/* 96 */       return true;
/* 97 */     return false;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.impl.CustomFileFilter
 * JD-Core Version:    0.6.2
 */