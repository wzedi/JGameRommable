/*    */ package org.gcreator.units;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import org.gcreator.fileclass.GFile;
/*    */ 
/*    */ public class BackgroundInScene
/*    */   implements Serializable
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/*    */   public String name;
/*    */   public GFile image;
/*    */   public static final int MODE_SINGLE = 0;
/*    */   public static final int MODE_REPEAT = 1;
/*    */   public static final int MODE_STRETCH = 2;
/* 25 */   public int hmode = 0;
/* 26 */   public int vmode = 0;
/* 27 */   public boolean visibleonstart = false;
/*    */ 
/*    */   public BackgroundInScene(String name) {
/* 30 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 34 */     return this.visibleonstart ? "<HTML><b>" + this.name : this.name;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.units.BackgroundInScene
 * JD-Core Version:    0.6.2
 */