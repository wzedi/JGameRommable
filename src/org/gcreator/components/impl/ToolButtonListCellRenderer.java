/*    */ package org.gcreator.components.impl;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JList;
/*    */ import javax.swing.ListCellRenderer;
/*    */ 
/*    */ public class ToolButtonListCellRenderer extends JLabel
/*    */   implements ListCellRenderer
/*    */ {
/*    */   public ToolButtonListCellRenderer()
/*    */   {
/* 17 */     setOpaque(true);
/*    */   }
/*    */ 
/*    */   public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean hasFocus)
/*    */   {
/* 22 */     if ((value instanceof ToolbarSeparator)) {
/* 23 */       setText("----------------- [Separator]");
/* 24 */       setIcon(null);
/* 25 */       setForeground(Color.GRAY);
/*    */     }
/* 27 */     else if ((value instanceof ToolbarButton)) {
/* 28 */       ToolbarButton btn = (ToolbarButton)value;
/* 29 */       setText((btn.isBold() ? "<HTML><B>" : "") + btn.getText());
/* 30 */       setIcon(btn.getImage());
/*    */     }
/*    */     else {
/* 33 */       if (isSelected) {
/* 34 */         setForeground(Color.RED);
/* 35 */         setBackground(Color.BLACK);
/*    */       }
/*    */       else {
/* 38 */         setForeground(Color.BLACK);
/* 39 */         setBackground(Color.RED);
/*    */       }
/* 41 */       setText("Invalid component");
/* 42 */       setIcon(null);
/* 43 */       return this;
/*    */     }
/* 45 */     if (isSelected) {
/* 46 */       if (!(value instanceof ToolbarSeparator))
/*    */         try {
/* 48 */           setForeground(list.getSelectionForeground());
/*    */         }
/*    */         catch (Exception e) {
/* 51 */           setForeground(Color.WHITE);
/*    */         }
/*    */       try {
/* 54 */         setBackground(list.getSelectionBackground());
/*    */       }
/*    */       catch (Exception e) {
/* 57 */         setBackground(Color.BLUE);
/*    */       }
/*    */     }
/*    */     else {
/* 61 */       if (!(value instanceof ToolbarSeparator))
/* 62 */         setForeground(Color.BLACK);
/* 63 */       setBackground(Color.WHITE);
/*    */     }
/* 65 */     return this;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.impl.ToolButtonListCellRenderer
 * JD-Core Version:    0.6.2
 */