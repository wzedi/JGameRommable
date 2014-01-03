/*    */ package org.gcreator.components.impl;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JList;
/*    */ import javax.swing.ListCellRenderer;
/*    */ import org.gcreator.fileclass.GFile;
/*    */ import org.gcreator.fileclass.res.Scene;
/*    */ 
/*    */ public class SceneCellRenderer extends JLabel
/*    */   implements ListCellRenderer
/*    */ {
/*    */   public SceneCellRenderer()
/*    */   {
/* 15 */     setOpaque(true);
/*    */   }
/*    */ 
/*    */   public Component getListCellRendererComponent(JList list, Object value, int i, boolean selected, boolean focus)
/*    */   {
/* 23 */     ImageIcon icon = null;
/* 24 */     String val = value.toString();
/*    */ 
/* 26 */     boolean invalid = false;
/* 27 */     if (!(value instanceof GFile)) {
/* 28 */       invalid = true;
/* 29 */       val = "Invalid scene";
/* 30 */       if (selected)
/* 31 */         setForeground(Color.YELLOW);
/*    */       else
/* 33 */         setForeground(Color.RED);
/*    */     }
/*    */     else {
/* 36 */       Object o = ((GFile)value).value;
/* 37 */       if (!(o instanceof Scene)) {
/* 38 */         invalid = true;
/* 39 */         val = "Invalid scene";
/* 40 */         setForeground(Color.RED);
/*    */       } else {
/* 42 */         val = ((Scene)((GFile)value).value).name;
/*    */       }
/*    */     }
/*    */ 
/* 46 */     if ((selected) && (!invalid))
/*    */       try {
/* 48 */         setBackground(list.getSelectionBackground());
/* 49 */         setForeground(list.getSelectionForeground());
/*    */       } catch (Exception e) {
/* 51 */         setBackground(Color.BLUE);
/* 52 */         setForeground(Color.WHITE);
/*    */       }
/*    */     else {
/*    */       try {
/* 56 */         setBackground(list.getBackground());
/* 57 */         setForeground(list.getForeground());
/*    */       } catch (Exception e) {
/* 59 */         setBackground(Color.WHITE);
/* 60 */         setForeground(Color.BLACK);
/*    */       }
/*    */     }
/*    */ 
/* 64 */     setText(val);
/* 65 */     setIcon(icon);
/*    */ 
/* 67 */     return this;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.impl.SceneCellRenderer
 * JD-Core Version:    0.6.2
 */