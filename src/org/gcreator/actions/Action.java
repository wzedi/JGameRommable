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
/*     */ import org.gcreator.editors.ActorEditor;
/*     */ import org.gcreator.editors.TimelineEditor;
/*     */ import org.gcreator.fileclass.Project;
/*     */ 
/*     */ public class Action
/*     */   implements Serializable
/*     */ {
/*     */   static final long serialVersionUID = 1L;
/*     */   public ActionPattern pattern;
/*     */   private JComponent panel;
/*     */   public Project project;
/*  42 */   private static final ObjectStreamField[] serialPersistentFields = { new ObjectStreamField("pattern", ActionPattern.class) };
/*     */ 
/*     */   public Action(ActionPattern pattern)
/*     */   {
/*  56 */     this.pattern = pattern;
/*  57 */     this.project = null;
/*  58 */     if (pattern != null)
/*  59 */       this.panel = pattern.createNewPanel(this, null);
/*     */   }
/*     */ 
/*     */   public Action(ActorEditor editor, ActionPattern pattern)
/*     */   {
/*  71 */     this.pattern = pattern;
/*  72 */     this.project = editor.project;
/*  73 */     if (pattern != null)
/*  74 */       this.panel = pattern.createNewPanel(this, this.project);
/*     */   }
/*     */ 
/*     */   public Action(TimelineEditor editor, ActionPattern pattern)
/*     */   {
/*  86 */     this.pattern = pattern;
/*  87 */     this.project = editor.project;
/*  88 */     if (pattern != null)
/*  89 */       this.panel = pattern.createNewPanel(this, this.project);
/*     */   }
/*     */ 
/*     */   public ImageIcon getImage()
/*     */   {
/*  98 */     return this.pattern.getStandardImage();
/*     */   }
/*     */ 
/*     */   public String getLabel()
/*     */   {
/* 106 */     return this.pattern.getStandardText(getPanel());
/*     */   }
/*     */ 
/*     */   public void setPanel(JPanel panel)
/*     */   {
/* 111 */     this.panel = panel;
/*     */   }
/*     */ 
/*     */   public JComponent getPanel() {
/* 115 */     if (this.panel == null)
/*     */     {
/* 118 */       this.panel = this.pattern.createNewPanel(this, this.project);
/* 119 */       this.pattern.load(this.panel);
/*     */     }
/* 121 */     return this.panel;
/*     */   }
/*     */ 
/*     */   public String getGCL() {
/* 125 */     return this.pattern.generateGCL(getPanel());
/*     */   }
/*     */ 
/*     */   public Color getBackground(JList list) {
/* 129 */     return this.pattern.getBackground(list);
/*     */   }
/*     */ 
/*     */   public Color getForeground(JList list) {
/* 133 */     return this.pattern.getForeground(list);
/*     */   }
/*     */ 
/*     */   public Color getSelectedBackground(JList list) {
/* 137 */     return this.pattern.getSelectedBackground(list);
/*     */   }
/*     */ 
/*     */   public Color getSelectedForeground(JList list) {
/* 141 */     return this.pattern.getSelectedForeground(list);
/*     */   }
/*     */ 
/*     */   public String writeXml() {
/* 145 */     String xml = "<action>\n";
/* 146 */     xml = xml + "<type>";
/* 147 */     xml = xml + this.pattern.getClass().getName();
/* 148 */     xml = xml + "</type>";
/* 149 */     xml = xml + this.pattern.writeXml(this.panel);
/* 150 */     xml = xml + "</action>\n";
/* 151 */     return xml;
/*     */   }
/*     */ 
/*     */   public Action clone() {
/* 155 */     Action a = new Action(this.pattern);
/* 156 */     return a;
/*     */   }
/*     */ 
/*     */   public boolean indents(Vector<Action> indented, Vector<Action> unindented, JList list, boolean selected) {
/* 160 */     return this.pattern.indents(this.panel, indented, unindented, list, selected);
/*     */   }
/*     */ 
/*     */   public boolean unindents(Vector<Action> indented, Vector<Action> unindented, JList list, boolean selected) {
/* 164 */     return this.pattern.unindents(this.panel, indented, unindented, list, selected);
/*     */   }
/*     */ 
/*     */   public boolean indentsNext(Vector<Action> indented, Vector<Action> unindented, JList list, boolean selected) {
/* 168 */     return this.pattern.indentsNext(this.panel, indented, unindented, list, selected);
/*     */   }
/*     */ 
/*     */   public boolean unindentsNext(Vector<Action> indented, Vector<Action> unindented, JList list, boolean selected) {
/* 172 */     return this.pattern.unindentsNext(this.panel, indented, unindented, list, selected);
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.Action
 * JD-Core Version:    0.6.2
 */