/*    */ package org.gcreator.autocomplete.impl;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ public abstract class Suggestion
/*    */   implements Comparable<Suggestion>
/*    */ {
/*    */   public abstract String getText();
/*    */ 
/*    */   public abstract ImageIcon getImage();
/*    */ 
/*    */   public abstract Color getForeground();
/*    */ 
/*    */   public abstract String confirm(String paramString1, String paramString2);
/*    */ 
/*    */   public String toString()
/*    */   {
/* 24 */     return getText();
/*    */   }
/*    */   public int compareTo(Suggestion s) {
/* 27 */     return getText().compareTo(s.getText());
/*    */   }
/*    */   public int retreat() {
/* 30 */     return 0;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.autocomplete.impl.Suggestion
 * JD-Core Version:    0.6.2
 */