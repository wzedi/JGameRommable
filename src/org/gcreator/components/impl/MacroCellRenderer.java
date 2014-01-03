/*    */ package org.gcreator.components.impl;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JList;
/*    */ import javax.swing.ListCellRenderer;
/*    */ import org.gcreator.macro.Macro;
/*    */ 
/*    */ public class MacroCellRenderer extends JLabel
/*    */   implements ListCellRenderer
/*    */ {
/* 21 */   public static ImageIcon recording = new ImageIcon();
/*    */ 
/*    */   public MacroCellRenderer()
/*    */   {
/* 18 */     setOpaque(true);
/*    */   }
/*    */ 
/*    */   public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
/*    */   {
/* 29 */     setText(value.toString());
/* 30 */     if ((value instanceof Macro)) {
/* 31 */       setText(((Macro)value).getName());
/*    */     }
/*    */ 
/* 34 */     Color background = null;
/* 35 */     Color foreground = null;
/*    */ 
/* 39 */     if ((value instanceof Macro)) {
/* 40 */       if (isSelected) {
/*    */         try {
/* 42 */           foreground = list.getSelectionForeground();
/*    */         }
/*    */         catch (Exception e) {
/* 45 */           foreground = Color.WHITE;
/*    */         }
/* 47 */         if (value == Macro.recordingMacro)
/* 48 */           background = new Color(0, 200, 0);
/*    */         else
/*    */           try {
/* 51 */             background = list.getBackground();
/*    */           }
/*    */           catch (Exception e) {
/* 54 */             background = Color.BLUE;
/*    */           }
/*    */       }
/*    */       else {
/* 58 */         foreground = Color.BLACK;
/* 59 */         if (value == Macro.recordingMacro)
/* 60 */           background = Color.YELLOW;
/*    */         else
/* 62 */           background = Color.WHITE;
/*    */       }
/*    */     }
/* 65 */     setIcon(null);
/* 66 */     setBackground(background);
/* 67 */     setForeground(foreground);
/*    */ 
/* 69 */     return this;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.impl.MacroCellRenderer
 * JD-Core Version:    0.6.2
 */