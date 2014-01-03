/*    */ package org.gcreator.autocomplete.impl;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ public class FunctionSuggestion extends Suggestion
/*    */ {
/* 19 */   private String name = "";
/*    */   private String args;
/* 22 */   private static ImageIcon img = new ImageIcon(ClassSuggestion.class.getResource("/org/gcreator/resources/i_function.png"));
/*    */ 
/*    */   public FunctionSuggestion() {
/*    */   }
/* 26 */   public FunctionSuggestion(String name, String args) { this.name = name;
/*    */ 
/* 28 */     this.args = args; }
/*    */ 
/*    */   public Color getForeground()
/*    */   {
/* 32 */     return Color.DARK_GRAY;
/*    */   }
/*    */ 
/*    */   public ImageIcon getImage() {
/* 36 */     return img;
/*    */   }
/*    */ 
/*    */   public String getText()
/*    */   {
/* 47 */     return this.name + "(" + this.args + ")";
/*    */   }
/*    */ 
/*    */   public String confirm(String context, String prevWord) {
/*    */     try {
/* 52 */       return this.name.substring(context.substring(context.lastIndexOf('.') + 1).length()) + "(";
/*    */     } catch (Exception e) {
/*    */     }
/* 55 */     return "";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.autocomplete.impl.FunctionSuggestion
 * JD-Core Version:    0.6.2
 */