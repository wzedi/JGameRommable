/*    */ package org.gcreator.components.popupmenus;
/*    */ 
/*    */ import javax.swing.JMenuItem;
/*    */ import javax.swing.JPopupMenu;
/*    */ 
/*    */ public class AlarmListPopup extends JPopupMenu
/*    */ {
/*    */   JMenuItem[] items;
/*    */   EventSelect selector;
/*    */ 
/*    */   public AlarmListPopup(EventSelect selector)
/*    */   {
/* 41 */     this.items = new JMenuItem[12];
/* 42 */     for (int i = 0; i < 12; i++) {
/* 43 */       this.items[i] = new JMenuItem("Alarm " + i);
/* 44 */       add(this.items[i]);
/* 45 */       this.items[i].addActionListener(new AlarmActionListener(this, i));
/*    */     }
/* 47 */     this.selector = selector;
/* 48 */     updateUI();
/*    */   }
/*    */   public void cause(int num) {
/* 51 */     this.selector.callEvent(5020 + num);
/* 52 */     this.selector.dispose();
/* 53 */     this.selector = null;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.popupmenus.AlarmListPopup
 * JD-Core Version:    0.6.2
 */