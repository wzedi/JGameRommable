/*    */ package org.gcreator.autocomplete.impl;
/*    */ 
/*    */ public class NKeywordSuggestion extends KeywordSuggestion
/*    */ {
/*    */   public NKeywordSuggestion()
/*    */   {
/*    */   }
/*    */ 
/*    */   public NKeywordSuggestion(String text)
/*    */   {
/* 19 */     super(text);
/*    */   }
/*    */ 
/*    */   public String confirm(String context, String prevWord) {
/* 23 */     return (this.text + "(\"\")").substring(context.length());
/*    */   }
/*    */ 
/*    */   public int retreat() {
/* 27 */     return 2;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.autocomplete.impl.NKeywordSuggestion
 * JD-Core Version:    0.6.2
 */