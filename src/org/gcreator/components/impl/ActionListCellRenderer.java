/*    */ package org.gcreator.components.impl;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JList;
/*    */ import javax.swing.ListCellRenderer;
/*    */ import org.gcreator.actions.ActionCategory;
/*    */ import org.gcreator.actions.ActionPattern;
/*    */ 
/*    */ public class ActionListCellRenderer extends JLabel
/*    */   implements ListCellRenderer
/*    */ {
/*    */   public ActionListCellRenderer()
/*    */   {
/* 17 */     setOpaque(true);
/*    */   }
/*    */ 
/*    */   public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
/*    */   {
/* 25 */     ImageIcon icon = null;
/* 26 */     String val = value.toString();
/*    */ 
/* 31 */     if ((value instanceof ActionPattern)) {
/* 32 */       icon = ((ActionPattern)value).getStandardImage();
/* 33 */       val = ((ActionPattern)value).getStandardText(null);
/* 34 */       if (isSelected) {
/* 35 */         setBackground(((ActionPattern)value).getSelectedBackground(list));
/* 36 */         setForeground(((ActionPattern)value).getSelectedForeground(list));
/*    */       }
/*    */       else {
/* 39 */         setBackground(((ActionPattern)value).getBackground(list));
/* 40 */         setForeground(((ActionPattern)value).getForeground(list));
/*    */       }
/*    */     }
/* 43 */     else if ((value instanceof ActionCategory)) {
/* 44 */       icon = ((ActionCategory)value).icon;
/* 45 */       val = ((ActionCategory)value).name;
/* 46 */       if (isSelected) {
/* 47 */         setBackground(((ActionCategory)value).getSelectedBackground(list));
/* 48 */         setForeground(((ActionCategory)value).getSelectedForeground(list));
/*    */       }
/*    */       else {
/* 51 */         setBackground(((ActionCategory)value).background);
/* 52 */         setForeground(((ActionCategory)value).foreground);
/*    */       }
/*    */     }
/* 55 */     setText(val);
/* 56 */     setIcon(icon);
/*    */ 
/* 58 */     return this;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.impl.ActionListCellRenderer
 * JD-Core Version:    0.6.2
 */