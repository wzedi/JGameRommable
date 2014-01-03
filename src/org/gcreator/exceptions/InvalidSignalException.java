/*    */ package org.gcreator.exceptions;
/*    */ 
/*    */ public class InvalidSignalException extends Exception
/*    */ {
/*    */   Object signal;
/*    */ 
/*    */   public InvalidSignalException(Object signal)
/*    */   {
/* 19 */     this.signal = signal;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 24 */     return "InvalidSignalException with signal " + this.signal.toString();
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.exceptions.InvalidSignalException
 * JD-Core Version:    0.6.2
 */