/*    */ package org.gcreator.components;
/*    */ 
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ import javax.swing.JButton;
/*    */ import org.gcreator.core.Aurwindow;
/*    */ import org.gcreator.core.gcreator;
/*    */ 
/*    */ public class ExtendedToolButton extends JButton
/*    */   implements MouseListener
/*    */ {
/* 32 */   private boolean bold = false;
/*    */ 
/*    */   public void mouseExited(MouseEvent evt)
/*    */   {
/* 18 */     gcreator.window.statusbar.restoreText();
/*    */   }
/*    */   public void mouseEntered(MouseEvent evt) {
/*    */     try {
/* 22 */       gcreator.window.statusbar.setText(getToolTipText()); } catch (NullPointerException e) {
/*    */     }
/*    */   }
/*    */   public void mouseReleased(MouseEvent evt) {
/*    */   }
/*    */   public void mousePressed(MouseEvent evt) {
/*    */   }
/*    */   public void mouseClicked(MouseEvent evt) {  }
/*    */ 
/* 30 */   public ExtendedToolButton() { addMouseListener(this); }
/*    */ 
/*    */   public boolean isBold()
/*    */   {
/* 34 */     return this.bold;
/*    */   }
/*    */   public void setBold(boolean bold) {
/* 37 */     this.bold = bold;
/* 38 */     updateUI();
/*    */   }
/*    */   public String getText() {
/* 41 */     return (this.bold ? "<HTML><B>" : "") + super.getText();
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.ExtendedToolButton
 * JD-Core Version:    0.6.2
 */