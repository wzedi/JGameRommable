/*    */ package org.gcreator.components.impl;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JList;
/*    */ import javax.swing.ListCellRenderer;
/*    */ import org.gcreator.fileclass.res.TimelineStep;
/*    */ 
/*    */ public class TimelineStepsCellRenderer extends JLabel
/*    */   implements ListCellRenderer
/*    */ {
/*    */   public TimelineStepsCellRenderer()
/*    */   {
/* 18 */     setOpaque(true);
/*    */   }
/*    */ 
/*    */   public Component getListCellRendererComponent(JList list, Object value, int index, boolean selected, boolean focus)
/*    */   {
/* 23 */     if (value == null) {
/* 24 */       setText("");
/*    */     }
/* 26 */     else if ((value instanceof TimelineStep)) {
/* 27 */       TimelineStep step = (TimelineStep)value;
/* 28 */       setText("Step " + step.stepnum);
/*    */     }
/*    */     else {
/* 31 */       setText("Invalid resource");
/*    */     }
/* 33 */     if (selected) {
/*    */       try {
/* 35 */         setForeground(list.getSelectionForeground());
/* 36 */         setBackground(list.getSelectionBackground());
/*    */       }
/*    */       catch (Exception e) {
/* 39 */         setForeground(Color.WHITE);
/* 40 */         setBackground(Color.BLACK);
/*    */       }
/*    */     }
/*    */     else {
/* 44 */       setForeground(Color.BLACK);
/* 45 */       setBackground(Color.WHITE);
/*    */     }
/* 47 */     return this;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.impl.TimelineStepsCellRenderer
 * JD-Core Version:    0.6.2
 */