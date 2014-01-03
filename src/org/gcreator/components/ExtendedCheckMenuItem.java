/*    */ package org.gcreator.components;
/*    */ 
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ import javax.swing.JCheckBoxMenuItem;
/*    */ import org.gcreator.core.Aurwindow;
/*    */ import org.gcreator.core.gcreator;
/*    */ 
/*    */ public class ExtendedCheckMenuItem extends JCheckBoxMenuItem
/*    */   implements MouseListener
/*    */ {
/*    */   public void mouseExited(MouseEvent evt)
/*    */   {
/* 18 */     gcreator.window.statusbar.restoreText();
/*    */   }
/*    */   public void mouseEntered(MouseEvent evt) {
/* 21 */     gcreator.window.statusbar.setText(getToolTipText());
/*    */   }
/*    */   public void mouseReleased(MouseEvent evt) {
/*    */   }
/*    */   public void mousePressed(MouseEvent evt) {  } 
/*    */   public void mouseClicked(MouseEvent evt) {  } 
/* 27 */   public ExtendedCheckMenuItem(String text) { super(text);
/* 28 */     addMouseListener(this);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.ExtendedCheckMenuItem
 * JD-Core Version:    0.6.2
 */