/*    */ package org.gcreator.components.impl;
/*    */ 
/*    */ import java.util.Vector;
/*    */ import javax.swing.AbstractListModel;
/*    */ 
/*    */ public class VectorListModel extends AbstractListModel
/*    */ {
/*    */   private Vector v;
/*    */ 
/*    */   public VectorListModel(Vector v)
/*    */   {
/* 18 */     this.v = v;
/*    */   }
/*    */ 
/*    */   public Object getElementAt(int pos) {
/* 22 */     return this.v.get(pos);
/*    */   }
/*    */ 
/*    */   public int getSize() {
/* 26 */     return this.v.size();
/*    */   }
/*    */ 
/*    */   public void setVector(Vector v) {
/* 30 */     this.v = v;
/*    */   }
/*    */ 
/*    */   public int getIndexOf(Object o) {
/* 34 */     return this.v.indexOf(o);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.impl.VectorListModel
 * JD-Core Version:    0.6.2
 */