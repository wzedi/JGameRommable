/*    */ package org.gcreator.autocomplete.impl;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ public class ClassSuggestion extends Suggestion
/*    */ {
/* 19 */   private String text = "";
/* 20 */   private static ImageIcon img = new ImageIcon(ClassSuggestion.class.getResource("/org/gcreator/resources/i_class.png"));
/*    */ 
/*    */   public ClassSuggestion() {
/*    */   }
/*    */   public ClassSuggestion(String text) {
/* 25 */     this.text = text;
/*    */   }
/*    */ 
/*    */   public Color getForeground() {
/* 29 */     return new Color(0, 150, 0);
/*    */   }
/*    */ 
/*    */   public ImageIcon getImage() {
/* 33 */     return img;
/*    */   }
/*    */ 
/*    */   public String getText() {
/* 37 */     return this.text;
/*    */   }
/*    */ 
/*    */   public String confirm(String context, String prevWord) {
/*    */     try {
/* 42 */       return (this.text + (prevWord.equals("new") ? "(" : "")).substring(context.substring(context.lastIndexOf('.') + 1).length());
/*    */     }
/*    */     catch (Exception e) {
/*    */     }
/* 46 */     return "";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.autocomplete.impl.ClassSuggestion
 * JD-Core Version:    0.6.2
 */