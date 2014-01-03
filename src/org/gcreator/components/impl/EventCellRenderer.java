/*    */ package org.gcreator.components.impl;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JList;
/*    */ import javax.swing.ListCellRenderer;
/*    */ import org.gcreator.events.Event;
/*    */ 
/*    */ public class EventCellRenderer extends JLabel
/*    */   implements ListCellRenderer
/*    */ {
/*    */   public EventCellRenderer()
/*    */   {
/* 17 */     setOpaque(true);
/*    */   }
/*    */ 
/*    */   public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
/*    */   {
/* 26 */     setText(value.toString());
/*    */ 
/* 28 */     Color background = null;
/* 29 */     Color foreground = null;
/* 30 */     ImageIcon icon = null;
/*    */ 
/* 34 */     if ((isSelected) && ((value instanceof Event))) {
/*    */       try {
/* 36 */         background = list.getSelectionBackground();
/*    */       }
/*    */       catch (Exception e) {
/* 39 */         background = Color.BLUE;
/*    */       }
/*    */       try {
/* 42 */         foreground = list.getSelectionForeground();
/*    */       }
/*    */       catch (Exception e) {
/* 45 */         foreground = Color.WHITE;
/*    */       }
/* 47 */       icon = ((Event)value).getSelectedImage();
/*    */     }
/*    */     else {
/* 50 */       background = ((Event)value).getBackground();
/* 51 */       foreground = ((Event)value).getForeground();
/* 52 */       icon = ((Event)value).getImage();
/*    */     }
/*    */ 
/* 55 */     setIcon(icon);
/* 56 */     setBackground(background);
/* 57 */     setForeground(foreground);
/*    */ 
/* 59 */     return this;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.impl.EventCellRenderer
 * JD-Core Version:    0.6.2
 */