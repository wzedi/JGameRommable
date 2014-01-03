/*    */ package org.gcreator.components;
/*    */ 
/*    */ import javax.swing.JInternalFrame;
/*    */ 
/*    */ public class ExtendedFrame extends JInternalFrame
/*    */ {
/* 19 */   private TabPanel pane = null;
/*    */ 
/*    */   public void setPanel(TabPanel pane) {
/* 22 */     this.pane = pane;
/*    */   }
/*    */ 
/*    */   public TabPanel getPanel() {
/* 26 */     return this.pane;
/*    */   }
/*    */ 
/*    */   public void dispose()
/*    */   {
/* 32 */     if (this.pane != null)
/* 33 */       this.pane.dispose();
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.ExtendedFrame
 * JD-Core Version:    0.6.2
 */