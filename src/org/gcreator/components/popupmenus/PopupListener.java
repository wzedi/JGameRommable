/*    */ package org.gcreator.components.popupmenus;
/*    */ 
/*    */ import java.awt.Point;
/*    */ import java.awt.event.MouseAdapter;
/*    */ import java.awt.event.MouseEvent;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JPopupMenu;
/*    */ import org.gcreator.components.custom.MenuGenerator;
/*    */ 
/*    */ public class PopupListener extends MouseAdapter
/*    */ {
/* 24 */   public JPopupMenu listened = null;
/* 25 */   public MenuGenerator gen = null;
/*    */   public JComponent component;
/*    */   public boolean update;
/*    */ 
/*    */   public PopupListener(JComponent component, JPopupMenu listen)
/*    */   {
/* 28 */     this.listened = listen;
/* 29 */     this.component = component;
/*    */   }
/*    */ 
/*    */   public PopupListener(JComponent component, MenuGenerator listen) {
/* 33 */     this.gen = listen;
/* 34 */     this.component = component;
/*    */   }
/*    */ 
/*    */   public void mousePressed(MouseEvent e)
/*    */   {
/* 41 */     maybeShowPopup(e);
/* 42 */     if (this.update)
/* 43 */       this.component.updateUI();
/*    */   }
/*    */ 
/*    */   public void mouseReleased(MouseEvent e)
/*    */   {
/* 48 */     maybeShowPopup(e);
/* 49 */     if (this.update)
/* 50 */       this.component.updateUI();
/*    */   }
/*    */ 
/*    */   private void maybeShowPopup(MouseEvent e) {
/* 54 */     if (this.component.isShowing()) {
/* 55 */       Point p = this.component.getLocationOnScreen();
/* 56 */       if (e.isPopupTrigger()) {
/* 57 */         if (this.listened != null) {
/* 58 */           this.listened.show(this.component, e.getX(), e.getY());
/*    */         }
/* 60 */         if (this.gen != null)
/* 61 */           this.gen.show(this.component, e.getX(), e.getY());
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.popupmenus.PopupListener
 * JD-Core Version:    0.6.2
 */