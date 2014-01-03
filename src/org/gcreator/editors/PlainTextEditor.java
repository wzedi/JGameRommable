/*     */ package org.gcreator.editors;
/*     */ 
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextPane;
/*     */ import org.gcreator.components.TabPanel;
/*     */ import org.gcreator.fileclass.GFile;
/*     */ import org.gcreator.fileclass.Project;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ 
/*     */ public class PlainTextEditor extends TabPanel
/*     */ {
/*  22 */   public boolean changed = false;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JTextPane jTextPane1;
/*     */ 
/*     */   public PlainTextEditor(GFile file, Project project)
/*     */   {
/*  25 */     this.project = project;
/*  26 */     initComponents();
/*  27 */     this.jTextPane1.setText((String)file.value);
/*  28 */     this.file = file;
/*     */   }
/*     */ 
/*     */   public boolean canSave()
/*     */   {
/*  33 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean Save()
/*     */   {
/*  38 */     this.file.value = this.jTextPane1.getText();
/*  39 */     this.changed = false;
/*  40 */     return true;
/*     */   }
/*     */ 
/*     */   public void dispose()
/*     */   {
/*  45 */     if (!wasModified()) {
/*  46 */       super.dispose();
/*     */     } else {
/*  48 */       Object[] options = { "Yes", "No", "Cancel" };
/*     */ 
/*  51 */       int n = JOptionPane.showOptionDialog(this.frame, "You have unsaved changes in your document.\nDo you want to save it?", "Save document?", 1, 3, null, options, options[2]);
/*     */ 
/*  60 */       if ((n == 0) && 
/*  61 */         (Save())) {
/*  62 */         super.dispose();
/*     */       }
/*  64 */       if (n == 1)
/*  65 */         super.dispose();
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean wasModified()
/*     */   {
/*  72 */     return this.changed;
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  83 */     this.jScrollPane1 = new JScrollPane();
/*  84 */     this.jTextPane1 = new JTextPane();
/*     */ 
/*  86 */     this.jTextPane1.addPropertyChangeListener(new PropertyChangeListener() {
/*     */       public void propertyChange(PropertyChangeEvent evt) {
/*  88 */         PlainTextEditor.this.jTextPane1PropertyChange(evt);
/*     */       }
/*     */     });
/*  91 */     this.jTextPane1.addKeyListener(new KeyAdapter() {
/*     */       public void keyTyped(KeyEvent evt) {
/*  93 */         PlainTextEditor.this.jTextPane1KeyTyped(evt);
/*     */       }
/*     */     });
/*  96 */     this.jScrollPane1.setViewportView(this.jTextPane1);
/*     */ 
/*  98 */     GroupLayout layout = new GroupLayout(this);
/*  99 */     setLayout(layout);
/* 100 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(this.jScrollPane1, -1, 350, 32767));
/*     */ 
/* 104 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(this.jScrollPane1, -1, 165, 32767));
/*     */   }
/*     */ 
/*     */   private void jTextPane1KeyTyped(KeyEvent evt)
/*     */   {
/* 111 */     this.changed = true;
/*     */   }
/*     */ 
/*     */   private void jTextPane1PropertyChange(PropertyChangeEvent evt) {
/* 115 */     this.changed = true;
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.editors.PlainTextEditor
 * JD-Core Version:    0.6.2
 */