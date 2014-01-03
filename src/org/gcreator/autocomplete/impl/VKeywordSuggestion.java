/*    */ package org.gcreator.autocomplete.impl;
/*    */ 
/*    */ public class VKeywordSuggestion extends KeywordSuggestion
/*    */ {
/*    */   public VKeywordSuggestion()
/*    */   {
/*    */   }
/*    */ 
/*    */   public VKeywordSuggestion(String text)
/*    */   {
/* 19 */     super(text);
/*    */   }
/*    */ 
/*    */   public String confirm(String context, String prevWord) {
/* 23 */     return this.text.substring(context.length());
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.autocomplete.impl.VKeywordSuggestion
 * JD-Core Version:    0.6.2
 */