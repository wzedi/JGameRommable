/*    */ package org.gcreator.components.uiplus;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.util.Vector;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ public class DiscMenuItem
/*    */ {
/* 17 */   public ImageIcon image = null;
/* 18 */   public String label = null;
/* 19 */   private Vector<ActionListener> action = new Vector();
/* 20 */   private boolean enabled = true;
/*    */ 
/*    */   public DiscMenuItem(String label, ImageIcon image) {
/* 23 */     this.image = image;
/* 24 */     this.label = label;
/*    */   }
/*    */ 
/*    */   public void addActionListener(ActionListener act) {
/* 28 */     this.action.add(act);
/*    */   }
/*    */ 
/*    */   protected void actionPerformed(ActionEvent evt) {
/* 32 */     actionPerformed(evt, false);
/*    */   }
/*    */ 
/*    */   protected void actionPerformed(ActionEvent evt, boolean back) {
/* 36 */     for (ActionListener l : this.action)
/* 37 */       l.actionPerformed(evt);
/*    */   }
/*    */ 
/*    */   public void setEnabled(boolean enabled) {
/* 41 */     this.enabled = enabled;
/*    */   }
/*    */ 
/*    */   public boolean isEnabled() {
/* 45 */     return this.enabled;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.uiplus.DiscMenuItem
 * JD-Core Version:    0.6.2
 */