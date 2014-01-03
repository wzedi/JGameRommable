/*    */ package org.gcreator.units;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import org.gcreator.fileclass.GFile;
/*    */ 
/*    */ public class ActorInScene
/*    */   implements Serializable
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/*    */   public GFile Sactor;
/*    */   public int x;
/*    */   public int y;
/*    */   public double id;
/*    */ 
/*    */   public ActorInScene(GFile actor, int x, int y, double id)
/*    */   {
/* 30 */     this.Sactor = actor;
/* 31 */     this.x = x;
/* 32 */     this.y = y;
/* 33 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String writeXml() {
/* 37 */     return "<actor type=\"" + this.Sactor + "\" x=" + this.x + " y=" + this.y + " id=" + this.id + " />";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.units.ActorInScene
 * JD-Core Version:    0.6.2
 */