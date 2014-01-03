/*     */ package org.gcreator.components;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.AbstractListModel;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.JTree;
/*     */ import javax.swing.event.ListSelectionEvent;
/*     */ import javax.swing.event.ListSelectionListener;
/*     */ import javax.swing.tree.DefaultTreeSelectionModel;
/*     */ import org.gcreator.components.impl.Model;
/*     */ import org.gcreator.core.Aurwindow;
/*     */ import org.gcreator.core.gcreator;
/*     */ import org.gcreator.fileclass.Folder;
/*     */ import org.gcreator.fileclass.GObject;
/*     */ import org.gcreator.managers.LangSupporter;
/*     */ import org.gcreator.units.Dictionary;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class NewFileGroup extends TabPanel
/*     */ {
/*     */   public JTree tree;
/*     */   public Model a1;
/*     */   public Model a2;
/*     */   public Model a3;
/*     */   private JButton jButton1;
/*     */   private JLabel jLabel1;
/*     */   public JList jList1;
/*     */   public JList jList2;
/*     */   private JScrollPane jScrollPane2;
/*     */   private JScrollPane jScrollPane3;
/*     */   public JTextField jTextField1;
/*     */ 
/*     */   public NewFileGroup()
/*     */   {
/*  32 */     initComponents();
/*  33 */     this.tree = new JTree(gcreator.window.top);
/*     */ 
/*  35 */     DefaultTreeSelectionModel model = new DefaultTreeSelectionModel();
/*  36 */     model.setSelectionMode(1);
/*  37 */     this.tree.setSelectionModel(model);
/*  38 */     this.tree.setCellRenderer(Aurwindow.workspace.getCellRenderer());
/*  39 */     this.a1 = new Model() {
/*  40 */       String[] strings = { /*"Group",*/ "Text file" };
/*  41 */       String[] truenames = { /*"/",*/ "txt" };
/*     */ 
/*  42 */       public int getSize() { return this.strings.length; } 
/*  43 */       public Object getElementAt(int i) { return this.strings[i]; } 
/*  44 */       public String getTrueName(int i) { return this.truenames[i]; }
/*     */ 
/*     */     };
/*  46 */     this.a2 = new Model() {
/*  47 */       String[] strings = { "Sprite", "Tileset", "Object", "Level"}; //, "EGML Script" };
/*  48 */       String[] truenames = { "sprite", "tileset", "actor", "scene"}; //, "egml" };
/*     */ 
/*  49 */       public int getSize() { return this.strings.length; } 
/*  50 */       public Object getElementAt(int i) { return this.strings[i]; } 
/*  51 */       public String getTrueName(int i) { return this.truenames[i]; }
/*     */ 
/*     */     };
/*  53 */     this.a3 = new Model() {
/*  54 */       String[] strings = { "Java file", "C++ file", "C++ header file", "XML file" };
/*  55 */       String[] truenames = { "java", "cpp", "h", "xml" };
/*     */ 
/*  56 */       public int getSize() { return this.strings.length; } 
/*  57 */       public Object getElementAt(int i) { return this.strings[i]; } 
/*  58 */       public String getTrueName(int i) { return this.truenames[i]; }
/*     */ 
/*     */     };
/*  60 */     this.jList2.setModel(this.a1);
/*  61 */     this.jList1.setSelectedIndex(0);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  73 */     this.jLabel1 = new JLabel();
/*  74 */     this.jScrollPane2 = new JScrollPane();
/*  75 */     this.jList1 = new JList();
/*  76 */     this.jScrollPane3 = new JScrollPane();
/*  77 */     this.jList2 = new JList();
/*  78 */     this.jButton1 = new JButton();
/*  79 */     this.jTextField1 = new JTextField();
/*     */ 
/*  81 */     this.jLabel1.setText(LangSupporter.activeLang.getEntry(95));
/*     */ 
/*  83 */     this.jList1.setModel(new AbstractListModel() {
/*  84 */       String[] strings = { LangSupporter.activeLang.getEntry(97), "Game items" }; //, "Development items" };
/*     */ 
/*  85 */       public int getSize() { return this.strings.length; } 
/*  86 */       public Object getElementAt(int i) { return this.strings[i]; }
/*     */ 
/*     */     });
/*  88 */     this.jList1.setSelectionMode(0);
/*  89 */     this.jList1.addListSelectionListener(new ListSelectionListener() {
/*     */       public void valueChanged(ListSelectionEvent evt) {
/*  91 */         NewFileGroup.this.jList1ValueChanged(evt);
/*     */       }
/*     */     });
/*  94 */     this.jScrollPane2.setViewportView(this.jList1);
/*     */ 
/*  96 */     this.jList2.setSelectionMode(0);
/*  97 */     this.jScrollPane3.setViewportView(this.jList2);
/*     */ 
/*  99 */     this.jButton1.setText("jButton1");
/* 100 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 102 */         NewFileGroup.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 106 */     this.jTextField1.setText("jTextField1");
/*     */ 
/* 108 */     GroupLayout layout = new GroupLayout(this);
/* 109 */     setLayout(layout);
/* 110 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(0, 0, 0).add(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(this.jScrollPane2, -2, 174, -2).addPreferredGap(0).add(this.jScrollPane3, -1, 206, 32767)).add(2, layout.createSequentialGroup().add(this.jTextField1, -1, 307, 32767).addPreferredGap(0).add(this.jButton1)))).add(this.jLabel1)).addContainerGap()));
/*     */ 
/* 129 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(2, layout.createSequentialGroup().addContainerGap().add(this.jLabel1).addPreferredGap(0).add(layout.createParallelGroup(2).add(this.jScrollPane3, -1, 229, 32767).add(this.jScrollPane2, -1, 229, 32767)).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jButton1).add(this.jTextField1, -2, -1, -2)).addContainerGap()));
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/* 147 */     String val = ((Model)this.jList2.getModel()).getTrueName(this.jList2.getSelectedIndex());
/* 148 */     if (gcreator.window.getCurrentFolder() != null)
/* 149 */       add(val);
/*     */   }
/*     */ 
/*     */   private void jList1ValueChanged(ListSelectionEvent evt) {
/* 153 */     if (this.jList1.getSelectedIndex() == 0)
/* 154 */       this.jList2.setModel(this.a1);
/* 155 */     else if (this.jList1.getSelectedIndex() == 1)
/* 156 */       this.jList2.setModel(this.a2);
/* 157 */     else if (this.jList1.getSelectedIndex() == 2)
/* 158 */       this.jList2.setModel(this.a3);
/*     */   }
/*     */ 
/*     */   public Folder getCurrentFolder() {
/* 162 */     return gcreator.window.getCurrentFolder();
/*     */   }
/*     */ 
/*     */   public GObject getCurrentObject() {
/* 166 */     return gcreator.window.getCurrentObject();
/*     */   }
/*     */ 
/*     */   public void add(String val) {
/* 170 */     String name = this.jTextField1.getText();
/* 171 */     if (name.equals(""))
/* 172 */       name = "new";
/* 173 */     if (val.equals("/"))
/* 174 */       gcreator.window.addGroup(getCurrentFolder(), getCurrentFolder().newGroup(name));
/*     */     else
/* 176 */       gcreator.window.addFile(getCurrentFolder(), name, val);
/* 177 */     Aurwindow.workspace.updateUI();
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.NewFileGroup
 * JD-Core Version:    0.6.2
 */