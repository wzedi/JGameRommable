/*    */ package org.gcreator.components;
/*    */ 
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ import javax.swing.JMenu;
/*    */ import org.gcreator.core.Aurwindow;
/*    */ import org.gcreator.core.gcreator;
/*    */ 
/*    */ public class ExtendedMenu extends JMenu
/*    */   implements MouseListener
/*    */ {
/* 17 */   private int lx = -1;
/* 18 */   private int ly = -1;
/*    */ 
/* 20 */   public void mouseExited(MouseEvent evt) { gcreator.window.statusbar.restoreText(); }
/*    */ 
/*    */   public void mouseEntered(MouseEvent evt) {
/* 23 */     gcreator.window.statusbar.setText(getToolTipText());
/*    */   }
/*    */   public void mouseReleased(MouseEvent evt) {
/*    */   }
/*    */   public void mousePressed(MouseEvent evt) {
/*    */   }
/*    */   public void mouseClicked(MouseEvent evt) {  } 
/* 30 */   public ExtendedMenu(String text) { super(text);
/* 31 */     addMouseListener(this);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.ExtendedMenu
 * JD-Core Version:    0.6.2
 */