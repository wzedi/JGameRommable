/*    */ package publicdomain;
/*    */ 
/*    */ public abstract interface TokenTypes
/*    */ {
/*    */   public static final int UNRECOGNIZED = 0;
/*    */   public static final int WHITESPACE = 1;
/*    */   public static final int WORD = 2;
/*    */   public static final int NUMBER = 3;
/*    */   public static final int PUNCTUATION = 4;
/*    */   public static final int COMMENT = 5;
/*    */   public static final int START_COMMENT = 6;
/*    */   public static final int MID_COMMENT = 7;
/*    */   public static final int END_COMMENT = 8;
/*    */   public static final int TAG = 9;
/*    */   public static final int END_TAG = 10;
/*    */   public static final int KEYWORD = 11;
/*    */   public static final int KEYWORD2 = 12;
/*    */   public static final int IDENTIFIER = 13;
/*    */   public static final int LITERAL = 14;
/*    */   public static final int STRING = 15;
/*    */   public static final int CHARACTER = 16;
/*    */   public static final int OPERATOR = 17;
/*    */   public static final int BRACKET = 18;
/*    */   public static final int SEPARATOR = 19;
/*    */   public static final int URL = 20;
/* 59 */   public static final String[] typeNames = { "bad token", "whitespace", "word", "number", "punctuation", "comment", "start of comment", "middle of comment", "end of comment", "tag", "end tag", "keyword", "keyword 2", "identifier", "literal", "string", "character", "operator", "bracket", "separator", "url" };
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     publicdomain.TokenTypes
 * JD-Core Version:    0.6.2
 */