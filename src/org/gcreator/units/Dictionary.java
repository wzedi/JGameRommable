/*    */ package org.gcreator.units;
/*    */ 
/*    */ import org.gcreator.exceptions.NoLanguageNameException;
/*    */ import org.gcreator.exceptions.NullDictionaryException;
/*    */ 
/*    */ public class Dictionary
/*    */ {
/* 19 */   protected String[] entry = null;
/* 20 */   protected String[] authors = null;
/* 21 */   protected String status = null;
/* 22 */   protected String language = null;
/*    */ 
/*    */   protected void init()
/*    */     throws NoLanguageNameException, NullDictionaryException
/*    */   {
/* 27 */     if (this.language == null)
/* 28 */       throw new NoLanguageNameException();
/* 29 */     if (this.status == null)
/* 30 */       this.status = "";
/* 31 */     if (this.entry == null)
/* 32 */       throw new NullDictionaryException();
/*    */   }
/*    */ 
/*    */   public String getEntry(int num) {
/* 36 */     if (num == -1)
/* 37 */       return "";
/* 38 */     if (num >= this.entry.length)
/* 39 */       return "";
/* 40 */     if (this.entry[num] == null)
/* 41 */       return "";
/* 42 */     return this.entry[num];
/*    */   }
/*    */ 
/*    */   public String getLanguage() throws NoLanguageNameException {
/* 46 */     if (this.language == null)
/* 47 */       throw new NoLanguageNameException();
/* 48 */     return this.language;
/*    */   }
/*    */ 
/*    */   public String[] getAuthors() {
/* 52 */     return this.authors;
/*    */   }
/*    */ 
/*    */   public String getStatus() {
/* 56 */     return this.status;
/*    */   }
/*    */ 
/*    */   public String getSpecialEntry(String value) {
/* 60 */     return "";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.units.Dictionary
 * JD-Core Version:    0.6.2
 */