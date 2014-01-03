/*     */ package org.gcreator.components.impl;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.util.Vector;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.ListCellRenderer;
/*     */ import javax.swing.ListModel;
/*     */ import org.gcreator.actions.Action;
/*     */ 
/*     */ public class ActionsCellRenderer extends JLabel
/*     */   implements ListCellRenderer
/*     */ {
/*  25 */   public int indent = 0;
/*  26 */   public Vector<Action> indented = new Vector();
/*  27 */   public Vector<Action> unindented = new Vector();
/*     */   public JList list;
/*     */ 
/*     */   public ActionsCellRenderer()
/*     */   {
/*  22 */     setOpaque(true);
/*     */   }
/*     */ 
/*     */   public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
/*     */   {
/*  35 */     this.list = list;
/*  36 */     ImageIcon icon = null;
/*  37 */     String val = value.toString();
/*  38 */     if (list.getModel().getElementAt(0) == value)
/*     */     {
/*  40 */       this.indent = 0;
/*  41 */       this.indented.clear();
/*  42 */       this.unindented.clear();
/*     */     }
/*     */ 
/*  48 */     if ((value instanceof Action)) {
/*  49 */       Action act = (Action)value;
/*  50 */       icon = act.getImage();
/*  51 */       val = act.getLabel();
/*  52 */       if (val.indexOf("\n") != -1)
/*  53 */         val = val.substring(0, val.indexOf("\n")) + "\n...";
/*  54 */       if (isSelected) {
/*     */         try {
/*  56 */           setBackground(list.getSelectionBackground());
/*     */         }
/*     */         catch (Exception e) {
/*  59 */           setBackground(Color.BLUE);
/*     */         }
/*     */         try {
/*  62 */           setForeground(list.getSelectionForeground());
/*     */         }
/*     */         catch (Exception e) {
/*  65 */           setForeground(Color.WHITE);
/*     */         }
/*     */       }
/*     */       else {
/*  69 */         setBackground(act.getBackground(list));
/*  70 */         setForeground(act.getForeground(list));
/*     */       }
/*  72 */       if (act.indents(this.indented, this.unindented, list, isSelected)) {
/*  73 */         this.indented.add(act);
/*  74 */         this.indent += 1;
/*     */       }
/*  76 */       if (act.unindents(this.indented, this.unindented, list, isSelected)) {
/*  77 */         this.unindented.add(act);
/*  78 */         this.indent -= 1;
/*     */       }
/*     */     }
/*     */ 
/*  82 */     if (this.indent < 0) {
/*  83 */       this.indent = 0;
/*     */     }
/*  85 */     setText(val);
/*  86 */     setIcon(icon);
/*  87 */     setBorder(BorderFactory.createEmptyBorder(0, this.indent * 30, 0, 0));
/*     */ 
/*  89 */     if ((value instanceof Action)) {
/*  90 */       Action act = (Action)value;
/*  91 */       if (act.indentsNext(this.indented, this.unindented, list, isSelected)) {
/*  92 */         this.indented.add(act);
/*  93 */         this.indent += 1;
/*     */       }
/*  95 */       if (act.unindentsNext(this.indented, this.unindented, list, isSelected)) {
/*  96 */         this.unindented.add(act);
/*  97 */         this.indent -= 1;
/*     */       }
/*     */     }
/*     */ 
/* 101 */     return this;
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.impl.ActionsCellRenderer
 * JD-Core Version:    0.6.2
 */