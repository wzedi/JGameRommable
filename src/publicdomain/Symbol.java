/*    */ package publicdomain;
/*    */ 
/*    */ public class Symbol
/*    */ {
/*    */   public int type;
/*    */   public String name;
/*    */ 
/*    */   public Symbol(int type, String name)
/*    */   {
/* 27 */     this.type = type;
/* 28 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 36 */     return this.name;
/*    */   }
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 44 */     return this.name.hashCode() + this.type;
/*    */   }
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 52 */     if (!(obj instanceof Symbol))
/* 53 */       return false;
/* 54 */     Symbol that = (Symbol)obj;
/* 55 */     return (this.name.equals(that.name)) && (this.type == that.type);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     publicdomain.Symbol
 * JD-Core Version:    0.6.2
 */