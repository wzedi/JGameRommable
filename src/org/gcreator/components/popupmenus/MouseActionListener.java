/*    */ package org.gcreator.components.popupmenus;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ 
/*    */ class MouseActionListener
/*    */   implements ActionListener
/*    */ {
/*    */   MouseListPopup popmenu;
/*    */   int num;
/*    */ 
/*    */   public MouseActionListener(MouseListPopup popmenu, int num)
/*    */   {
/* 28 */     this.popmenu = popmenu;
/* 29 */     this.num = num;
/*    */   }
/*    */ 
/*    */   public void actionPerformed(ActionEvent evt) {
/* 33 */     this.popmenu.cause(this.num);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.popupmenus.MouseActionListener
 * JD-Core Version:    0.6.2
 */