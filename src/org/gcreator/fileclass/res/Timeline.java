/*    */ package org.gcreator.fileclass.res;
/*    */ 
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class Timeline extends Resource
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/* 16 */   public Vector<TimelineStep> steps = new Vector<TimelineStep>();
/*    */ 
/* 18 */   public Timeline(String name) { this.name = name; }
/*    */ 
/*    */   public Object clone()
/*    */   {
/* 22 */     Timeline a = new Timeline(this.name);
/* 23 */     return a;
/*    */   }
/*    */ 
/*    */   public String exportToHtml(boolean xhtml) {
/* 27 */     return "";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.res.Timeline
 * JD-Core Version:    0.6.2
 */