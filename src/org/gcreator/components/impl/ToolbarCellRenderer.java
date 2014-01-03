/*    */ package org.gcreator.components.impl;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JList;
/*    */ import javax.swing.ListCellRenderer;
/*    */ 
/*    */ public class ToolbarCellRenderer extends JLabel
/*    */   implements ListCellRenderer
/*    */ {
/*    */   public ToolbarCellRenderer()
/*    */   {
/* 17 */     setOpaque(true);
/*    */   }
/*    */ 
/*    */   public Component getListCellRendererComponent(JList list, Object value, int position, boolean selected, boolean focus)
/*    */   {
/* 22 */     if (value == null) {
/* 23 */       return null;
/*    */     }
/* 25 */     if ((value instanceof Toolbar)) {
/* 26 */       Toolbar toolbar = (Toolbar)value;
/* 27 */       if (selected) {
/*    */         try {
/* 29 */           setBackground(list.getSelectionBackground());
/* 30 */           setForeground(list.getSelectionForeground());
/*    */         }
/*    */         catch (Exception e) {
/* 33 */           setBackground(Color.BLUE);
/* 34 */           setForeground(Color.WHITE);
/*    */         }
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/* 41 */         setForeground(Color.BLACK);
/* 42 */         setForeground(Color.WHITE);
/*    */       }
/*    */ 
/* 45 */       if (toolbar.name == null)
/* 46 */         setText("Untitled Toolbar");
/*    */       else
/* 48 */         setText(toolbar.name);
/*    */     }
/*    */     else {
/* 51 */       if (selected)
/* 52 */         setForeground(Color.PINK);
/*    */       else
/* 54 */         setForeground(Color.RED);
/* 55 */       setText("Invalid");
/*    */     }
/* 57 */     if (selected) {
/*    */       try {
/* 59 */         setBackground(list.getSelectionBackground());
/*    */       }
/*    */       catch (Exception e) {
/* 62 */         setBackground(Color.BLUE);
/*    */       }
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 69 */       setBackground(Color.WHITE);
/*    */     }
/* 71 */     return this;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.impl.ToolbarCellRenderer
 * JD-Core Version:    0.6.2
 */