/*    */ package org.gcreator.components.popupmenus;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ 
/*    */ class KeyboardActionListener
/*    */   implements ActionListener
/*    */ {
/*    */   KeyboardListPopup popmenu;
/*    */   int num;
/*    */   String name;
/*    */ 
/*    */   public KeyboardActionListener(KeyboardListPopup popmenu, int num, String name)
/*    */   {
/* 24 */     this.popmenu = popmenu;
/* 25 */     this.num = num;
/* 26 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public void actionPerformed(ActionEvent evt) {
/* 30 */     this.popmenu.cause(this.num, this.name);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.popupmenus.KeyboardActionListener
 * JD-Core Version:    0.6.2
 */