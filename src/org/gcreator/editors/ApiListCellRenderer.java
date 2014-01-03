/*     */ package org.gcreator.editors;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.ListCellRenderer;
/*     */ import org.gcreator.api.util.ApiClass;
/*     */ import org.gcreator.api.util.ApiFunction;
/*     */ 
/*     */ class ApiListCellRenderer extends JLabel
/*     */   implements ListCellRenderer
/*     */ {
/*     */   public ApiListCellRenderer()
/*     */   {
/* 107 */     setOpaque(true);
/*     */   }
/*     */ 
/*     */   public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
/*     */   {
/* 115 */     String val = "";
/*     */ 
/* 120 */     if ((value instanceof ApiFunction))
/*     */     {
/* 122 */       val = ((ApiFunction)value).name;
/*     */     }
/* 124 */     else if ((value instanceof ApiClass))
/*     */     {
/* 126 */       val = ((ApiClass)value).name;
/*     */     }
/*     */ 
/* 129 */     setText(val);
/*     */ 
/* 131 */     return this;
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.editors.ApiListCellRenderer
 * JD-Core Version:    0.6.2
 */