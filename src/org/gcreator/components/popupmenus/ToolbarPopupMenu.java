/*    */ package org.gcreator.components.popupmenus;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JMenuItem;
/*    */ import javax.swing.JPopupMenu;
/*    */ import org.gcreator.managers.LangSupporter;
/*    */ import org.gcreator.units.Dictionary;
/*    */ 
/*    */ public class ToolbarPopupMenu extends JPopupMenu
/*    */ {
/*    */   JMenuItem hide;
/*    */ 
/*    */   public ToolbarPopupMenu()
/*    */   {
/* 25 */     this.hide = new JMenuItem(LangSupporter.activeLang.getEntry(117));
/* 26 */     add(this.hide);
/* 27 */     this.hide.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent evt) {
/* 29 */         ToolbarPopupMenu.this._hide();
/*    */       }
/*    */     });
/* 32 */     updateUI();
/*    */   }
/*    */   private void _hide() {
/* 35 */     org.gcreator.core.gcreator.window.items[org.gcreator.managers.MenuSupporter.GenerateMenuItemId(2, 1)].setSelected(false);
/* 36 */     org.gcreator.core.gcreator.window.items[org.gcreator.managers.MenuSupporter.GenerateMenuItemId(2, 1)].getActionListeners()[0].actionPerformed(null);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.popupmenus.ToolbarPopupMenu
 * JD-Core Version:    0.6.2
 */