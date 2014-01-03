/*    */ package org.gcreator.autocomplete.impl;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JList;
/*    */ import javax.swing.ListCellRenderer;
/*    */ 
/*    */ public class SuggestionCellRenderer extends JLabel
/*    */   implements ListCellRenderer
/*    */ {
/*    */   public SuggestionCellRenderer()
/*    */   {
/* 20 */     setOpaque(true);
/*    */   }
/*    */ 
/*    */   public JComponent getListCellRendererComponent(JList list, Object selection, int index, boolean selected, boolean hasFocus) {
/* 24 */     if ((selection instanceof Suggestion)) {
/* 25 */       Suggestion sel = (Suggestion)selection;
/* 26 */       setText(sel.getText());
/* 27 */       setForeground(sel.getForeground());
/* 28 */       setIcon(sel.getImage());
/*    */     }
/*    */     else {
/* 31 */       setText(selection.toString());
/* 32 */       setForeground(Color.RED);
/* 33 */       setIcon(null);
/*    */     }
/* 35 */     if (selected)
/*    */       try {
/* 37 */         setBackground(list.getSelectionBackground());
/* 38 */         setForeground(list.getSelectionForeground());
/*    */       }
/*    */       catch (Exception e) {
/* 41 */         setBackground(Color.BLUE);
/* 42 */         setForeground(Color.WHITE);
/*    */       }
/*    */     else
/* 45 */       setBackground(Color.WHITE);
/* 46 */     setFont(list.getFont());
/* 47 */     return this;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.autocomplete.impl.SuggestionCellRenderer
 * JD-Core Version:    0.6.2
 */