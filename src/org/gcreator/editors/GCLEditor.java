/*    */ package org.gcreator.editors;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import java.beans.PropertyChangeEvent;
/*    */ import java.beans.PropertyChangeListener;

/*    */ import javax.swing.JScrollPane;
/*    */ import javax.swing.SwingUtilities;

/*    */ import org.gcreator.components.SyntaxHighlighter;
/*    */ import org.gcreator.components.TabPanel;
/*    */ import org.gcreator.fileclass.GFile;
/*    */ import org.gcreator.fileclass.Project;
/*    */ import org.gcreator.fileclass.res.Classes;
/*    */ import org.jdesktop.layout.GroupLayout;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GCLEditor extends TabPanel
/*    */ {
/* 31 */   public boolean changed = true;
/*    */   private SyntaxHighlighter g;
/*    */   public JScrollPane jScrollPane1;
/*    */ 
/*    */   public boolean Save()
/*    */   {
/* 35 */     this.file.value = this.g.getText();
/* 36 */     if (this.file.value == null) {
/* 37 */       this.file.value = "";
/*    */     }
/* 39 */     return true;
/*    */   }
/*    */ 
/*    */   public GCLEditor(GFile file, Project project)
/*    */   {
/* 47 */     this.file = file;
/* 48 */     this.project = project;
/* 49 */     initComponents();
/* 50 */     if (file.value == null) {
/* 51 */       file.value = new Classes("String examplefield = \"\"; \npublic void exampleFunction(){\n\t\n}");
/*    */     }
/* 53 */     //Scanner scanner = new GCLScanner();
/* 54 */     //this.g = new SyntaxHighlighter(100, 100, scanner, project);
/* 55 */     this.g.setText(file.value.toString());
/*    */ 
/* 57 */     setLayout(new BorderLayout());
/* 58 */     add("Center", this.jScrollPane1);
/* 59 */     this.jScrollPane1.setViewportView(this.g);
/*    */ 
/* 61 */     this.g.addPropertyChangeListener(new PropertyChangeListener() {
/*    */       public void propertyChange(PropertyChangeEvent evt) {
/* 63 */         GCLEditor.this.changed = true;
/*    */       }
/*    */     });
/* 67 */     SwingUtilities.invokeLater(new Runnable() {
/*    */       public void run() {
/* 69 */         GCLEditor.this.g.requestFocusInWindow();
/*    */       }
/*    */     });
/*    */   }
/*    */ 
/*    */   public boolean wasModified() {
/* 75 */     return this.changed;
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 86 */     this.jScrollPane1 = new JScrollPane();
/*    */ 
/* 88 */     GroupLayout layout = new GroupLayout(this);
/* 89 */     setLayout(layout);
/* 90 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(this.jScrollPane1, -1, 349, 32767));
/*    */ 
/* 94 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(this.jScrollPane1, -1, 224, 32767));
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.editors.GCLEditor
 * JD-Core Version:    0.6.2
 */