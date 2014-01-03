/*    */ package org.gcreator.components.impl;
/*    */ 
/*    */ import java.util.Vector;
/*    */ import javax.swing.ComboBoxModel;
/*    */ 
/*    */ public class VectorComboBoxModel extends VectorListModel
/*    */   implements ComboBoxModel
/*    */ {
/* 16 */   private int selindex = -1;
/*    */ 
/* 18 */   public VectorComboBoxModel(Vector v) { super(v); }
/*    */ 
/*    */   public Object getSelectedItem() {
/* 21 */     if ((this.selindex < 0) || (this.selindex >= getSize()))
/* 22 */       return null;
/* 23 */     return getElementAt(this.selindex);
/*    */   }
/*    */   public void setSelectedItem(Object o) {
/* 26 */     this.selindex = getIndexOf(o);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.impl.VectorComboBoxModel
 * JD-Core Version:    0.6.2
 */