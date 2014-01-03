/*    */ package org.gcreator.components;
/*    */ 
/*    */ import javax.swing.DefaultComboBoxModel;
/*    */ import org.gcreator.core.Aurwindow;
/*    */ import org.gcreator.core.gcreator;
/*    */ 
/*    */ public class MyModel extends DefaultComboBoxModel
/*    */ {
/*    */   public Object getElementAt(int pos)
/*    */   {
/* 25 */     if (gcreator.window != null)
/* 26 */       return gcreator.window.getWindowListElementAt(pos);
/* 27 */     return null;
/*    */   }
/*    */   public int getSize() {
/* 30 */     if (gcreator.window != null)
/* 31 */       return gcreator.window.getWindowListSize();
/* 32 */     return 0;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.MyModel
 * JD-Core Version:    0.6.2
 */