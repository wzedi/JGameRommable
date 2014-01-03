/*     */ package org.gcreator.actions;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.io.ObjectStreamField;
/*     */ import java.io.Serializable;
/*     */ import java.util.Vector;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JPanel;
/*     */ import org.gcreator.fileclass.Project;
/*     */ 
/*     */ public abstract class ActionPattern
/*     */   implements Serializable, Cloneable
/*     */ {
/*     */   static final long serialVersionUID = 1L;
/*  29 */   private static final ObjectStreamField[] serialPersistentFields = new ObjectStreamField[0];
/*     */ 
/*     */   public JComponent createNewPanel(Action action, Project project)
/*     */   {
/*  40 */     return new JPanel();
/*     */   }
/*     */ 
/*     */   public abstract void setStandardImage(ImageIcon paramImageIcon);
/*     */ 
/*     */   public abstract ImageIcon getStandardImage();
/*     */ 
/*     */   public String getStandardText(JComponent panel) {
/*  48 */     return "";
/*     */   }
/*     */ 
/*     */   public abstract String generateGCL(JComponent paramJComponent);
/*     */ 
/*     */   public Color getBackground(JList list) {
/*  54 */     return Color.WHITE;
/*     */   }
/*     */ 
/*     */   public Color getSelectedBackground(JList list) {
/*     */     try {
/*  59 */       return list.getSelectionBackground();
/*     */     } catch (Exception e) {
/*     */     }
/*  62 */     return Color.BLUE;
/*     */   }
/*     */ 
/*     */   public Color getForeground(JList list)
/*     */   {
/*  67 */     return Color.BLACK;
/*     */   }
/*     */ 
/*     */   public Color getSelectedForeground(JList list) {
/*     */     try {
/*  72 */       return list.getSelectionForeground();
/*     */     } catch (Exception e) {
/*     */     }
/*  75 */     return Color.WHITE;
/*     */   }
/*     */ 
/*     */   public String writeXml(JComponent panel)
/*     */   {
/*  80 */     return "";
/*     */   }
/*     */ 
/*     */   public void setLayout(Object o)
/*     */   {
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */   {
/*     */     try
/*     */     {
/*  96 */       return super.clone();
/*     */     }
/*     */     catch (CloneNotSupportedException e) {
/*  99 */       throw new InternalError(e.toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean indents(JComponent panel, Vector<Action> indented, Vector<Action> unindented, JList list, boolean selected) {
/* 104 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean unindents(JComponent panel, Vector<Action> indented, Vector<Action> unindented, JList list, boolean selected) {
/* 108 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean indentsNext(JComponent panel, Vector<Action> indented, Vector<Action> unindented, JList list, boolean selected) {
/* 112 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean unindentsNext(JComponent panel, Vector<Action> indented, Vector<Action> unindented, JList list, boolean selected) {
/* 116 */     return false;
/*     */   }
/*     */ 
/*     */   public void save(JComponent panel)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void load(JComponent panel)
/*     */   {
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.ActionPattern
 * JD-Core Version:    0.6.2
 */