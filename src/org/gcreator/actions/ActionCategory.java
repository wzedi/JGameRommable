/*    */ package org.gcreator.actions;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.util.Vector;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JList;
/*    */ 
/*    */ public class ActionCategory
/*    */ {
/* 20 */   public Vector patterns = new Vector();
/* 21 */   public String name = "";
/* 22 */   public ImageIcon icon = null;
/* 23 */   public Color foreground = Color.BLACK;
/* 24 */   public Color background = Color.WHITE;
/*    */ 
/*    */   public void add(ActionPattern pattern) {
/* 27 */     this.patterns.add(pattern);
/*    */   }
/*    */ 
/*    */   public Color getSelectedBackground(JList list) {
/* 31 */     return list.getSelectionBackground();
/*    */   }
/*    */ 
/*    */   public Color getSelectedForeground(JList list) {
/* 35 */     return list.getSelectionForeground();
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.ActionCategory
 * JD-Core Version:    0.6.2
 */