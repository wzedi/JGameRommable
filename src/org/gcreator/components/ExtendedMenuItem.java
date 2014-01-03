/*    */ package org.gcreator.components;
/*    */ 
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ import javax.swing.JMenuItem;
/*    */ import org.gcreator.core.Aurwindow;
/*    */ import org.gcreator.core.gcreator;
/*    */ 
/*    */ public class ExtendedMenuItem extends JMenuItem
/*    */   implements MouseListener
/*    */ {
/*    */   public static final String uiClassId = "MenuItemUI";
/*    */ 
/*    */   public void mouseExited(MouseEvent evt)
/*    */   {
/* 20 */     gcreator.window.statusbar.restoreText();
/*    */   }
/*    */   public void mouseEntered(MouseEvent evt) {
/* 23 */     gcreator.window.statusbar.setText(getToolTipText());
/*    */   }
/*    */   public void mouseReleased(MouseEvent evt) {
/*    */   }
/*    */   public void mousePressed(MouseEvent evt) {  } 
/*    */   public void mouseClicked(MouseEvent evt) {  } 
/* 29 */   public ExtendedMenuItem(String text) { super(text);
/* 30 */     addMouseListener(this); }
/*    */ 
/*    */   public String getUIClassID() {
/* 33 */     return "MenuItemUI";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.ExtendedMenuItem
 * JD-Core Version:    0.6.2
 */