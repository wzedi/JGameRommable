/*    */ package org.gcreator.autocomplete.impl;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ public class KeywordSuggestion extends Suggestion
/*    */ {
/* 19 */   protected String text = "";
/*    */ 
/*    */   public KeywordSuggestion() {
/*    */   }
/* 23 */   public KeywordSuggestion(String text) { this.text = text; }
/*    */ 
/*    */   public Color getForeground()
/*    */   {
/* 27 */     return Color.BLUE;
/*    */   }
/*    */ 
/*    */   public ImageIcon getImage() {
/* 31 */     return null;
/*    */   }
/*    */ 
/*    */   public String getText() {
/* 35 */     return this.text;
/*    */   }
/*    */ 
/*    */   public String confirm(String context, String prevWord) {
/* 39 */     return (this.text + " ").substring(context.length());
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.autocomplete.impl.KeywordSuggestion
 * JD-Core Version:    0.6.2
 */