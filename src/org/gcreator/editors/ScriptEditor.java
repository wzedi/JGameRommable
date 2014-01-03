/*     */ package org.gcreator.editors;
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Dimension;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;

/*     */ import javax.swing.AbstractListModel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JSplitPane;
/*     */ import javax.swing.SwingUtilities;

/*     */ import org.gcreator.components.SyntaxHighlighter;
/*     */ import org.gcreator.components.TabPanel;
/*     */ import org.gcreator.fileclass.GFile;
/*     */ import org.gcreator.fileclass.Project;
/*     */ import org.gcreator.fileclass.res.Classes;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ScriptEditor extends TabPanel
/*     */ {
/*  30 */   public boolean changed = true;
/*     */   SyntaxHighlighter g;
/*     */   private JList jList1;
/*     */   private JPanel jPanel1;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JSplitPane jSplitPane1;
/*     */ 
/*     */   public boolean Save()
/*     */   {
/*  34 */     this.file.value = this.g.getText();
/*  35 */     if (this.file.value == null) {
/*  36 */       this.file.value = "";
/*     */     }
/*  38 */     return true;
/*     */   }
/*     */ 
/*     */   public ScriptEditor(GFile file, Project project)
/*     */   {
/*  43 */     initComponents();
/*     */ 
/*  45 */     if (file.value == null)
/*  46 */       file.value = new Classes("// Press CTRL + SPACE for code completion \n show_message(\"test\")\n");
/*  47 */     //Scanner scanner = new GScriptScanner();
/*  48 */     //this.g = new SyntaxHighlighter(100, 100, scanner, project);
/*  49 */     this.g.setText(((Classes)file.value).toString());
/*     */ 
/*  51 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*     */ 
/*  61 */     setLayout(new BorderLayout());
/*  62 */     add("Center", this.jScrollPane1);
/*  63 */     this.jScrollPane1.setViewportView(this.g);
/*     */ 
/*  65 */     this.g.addPropertyChangeListener(new PropertyChangeListener() {
/*     */       public void propertyChange(PropertyChangeEvent evt) {
/*  67 */         ScriptEditor.this.changed = true;
/*     */       }
/*     */     });
/*  71 */     SwingUtilities.invokeLater(new Runnable() {
/*     */       public void run() {
/*  73 */         ScriptEditor.this.g.requestFocusInWindow();
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  87 */     this.jSplitPane1 = new JSplitPane();
/*  88 */     this.jScrollPane1 = new JScrollPane();
/*  89 */     this.jList1 = new JList();
/*  90 */     this.jPanel1 = new JPanel();
/*     */ 
/*  92 */     setLayout(new BorderLayout());
/*     */ 
/*  94 */     this.jSplitPane1.setDividerLocation(244);
/*  95 */     this.jSplitPane1.setOrientation(0);
/*  96 */     this.jSplitPane1.setResizeWeight(1.0D);
/*  97 */     this.jSplitPane1.setLastDividerLocation(354);
/*     */ 
/*  99 */     this.jList1.setModel(new AbstractListModel() {
/* 100 */       String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
/*     */ 
/* 101 */       public int getSize() { return this.strings.length; } 
/* 102 */       public Object getElementAt(int i) { return this.strings[i]; }
/*     */ 
/*     */     });
/* 104 */     this.jList1.setSelectionMode(0);
/* 105 */     this.jList1.setToolTipText("GCL function list");
/* 106 */     this.jList1.setMaximumSize(new Dimension(33, 100));
/* 107 */     this.jList1.setMinimumSize(new Dimension(33, 10));
/* 108 */     this.jList1.setPreferredSize(new Dimension(33, 50));
/* 109 */     this.jList1.setValueIsAdjusting(true);
/* 110 */     this.jList1.setVisibleRowCount(3);
/* 111 */     this.jScrollPane1.setViewportView(this.jList1);
/*     */ 
/* 113 */     this.jSplitPane1.setRightComponent(this.jScrollPane1);
/*     */ 
/* 115 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 116 */     this.jPanel1.setLayout(jPanel1Layout);
/* 117 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(1).add(0, 398, 32767));
/*     */ 
/* 121 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(1).add(0, 243, 32767));
/*     */ 
/* 126 */     this.jSplitPane1.setLeftComponent(this.jPanel1);
/*     */ 
/* 128 */     add(this.jSplitPane1, "Center");
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.editors.ScriptEditor
 * JD-Core Version:    0.6.2
 */