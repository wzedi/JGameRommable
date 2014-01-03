/*     */ package org.gcreator.editors;
/*     */ 
/*     */ import javax.swing.AbstractListModel;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JSplitPane;
/*     */ import javax.swing.JTextField;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class PathEditor extends JPanel
/*     */ {
/*     */   private JButton jButton3;
/*     */   private JComboBox jComboBox1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JList jList1;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JSplitPane jSplitPane1;
/*     */   private JTextField jTextField1;
/*     */   private JTextField jTextField2;
/*     */   private JTextField jTextField3;
/*     */ 
/*     */   public PathEditor()
/*     */   {
/*  17 */     initComponents();
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  28 */     this.jSplitPane1 = new JSplitPane();
/*  29 */     this.jPanel1 = new JPanel();
/*  30 */     this.jLabel1 = new JLabel();
/*  31 */     this.jTextField1 = new JTextField();
/*  32 */     this.jScrollPane1 = new JScrollPane();
/*  33 */     this.jList1 = new JList();
/*  34 */     this.jButton3 = new JButton();
/*  35 */     this.jLabel2 = new JLabel();
/*  36 */     this.jLabel3 = new JLabel();
/*  37 */     this.jTextField2 = new JTextField();
/*  38 */     this.jTextField3 = new JTextField();
/*  39 */     this.jLabel4 = new JLabel();
/*  40 */     this.jComboBox1 = new JComboBox();
/*  41 */     this.jPanel2 = new JPanel();
/*     */ 
/*  43 */     this.jLabel1.setText("name:");
/*     */ 
/*  45 */     this.jTextField1.setText("jTextField1");
/*     */ 
/*  47 */     this.jList1.setModel(new AbstractListModel() {
/*  48 */       String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
/*     */ 
/*  49 */       public int getSize() { return this.strings.length; } 
/*  50 */       public Object getElementAt(int i) { return this.strings[i]; }
/*     */ 
/*     */     });
/*  52 */     this.jScrollPane1.setViewportView(this.jList1);
/*     */ 
/*  54 */     this.jButton3.setText("Delete");
/*     */ 
/*  56 */     this.jLabel2.setText("X:");
/*     */ 
/*  58 */     this.jLabel3.setText("Y:");
/*     */ 
/*  60 */     this.jTextField2.setText("jTextField2");
/*     */ 
/*  62 */     this.jTextField3.setText("jTextField3");
/*     */ 
/*  64 */     this.jLabel4.setText("Type:");
/*     */ 
/*  66 */     this.jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*     */ 
/*  68 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  69 */     this.jPanel1.setLayout(jPanel1Layout);
/*  70 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().add(jPanel1Layout.createParallelGroup(1).add(this.jScrollPane1, -1, 103, 32767).add(jPanel1Layout.createSequentialGroup().addContainerGap().add(this.jLabel1).addPreferredGap(0).add(this.jTextField1, -2, -1, -2)).add(this.jButton3, -1, 103, 32767).add(jPanel1Layout.createSequentialGroup().addContainerGap().add(this.jLabel2, -2, 10, -2).addPreferredGap(0).add(this.jTextField2, -2, -1, -2)).add(jPanel1Layout.createSequentialGroup().addContainerGap().add(this.jLabel3).addPreferredGap(0).add(this.jTextField3, -2, -1, -2)).add(jPanel1Layout.createSequentialGroup().addContainerGap().add(this.jLabel4).addPreferredGap(0).add(this.jComboBox1, -2, -1, -2))).addContainerGap()));
/*     */ 
/*  98 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().addContainerGap().add(jPanel1Layout.createParallelGroup(3).add(this.jLabel1).add(this.jTextField1, -2, -1, -2)).addPreferredGap(0).add(this.jScrollPane1, -2, 139, -2).addPreferredGap(0).add(this.jButton3).addPreferredGap(0).add(jPanel1Layout.createParallelGroup(3).add(this.jLabel2).add(this.jTextField2, -2, -1, -2)).addPreferredGap(0).add(jPanel1Layout.createParallelGroup(3).add(this.jLabel3).add(this.jTextField3, -2, -1, -2)).addPreferredGap(1).add(jPanel1Layout.createParallelGroup(3).add(this.jLabel4).add(this.jComboBox1, -2, -1, -2)).addContainerGap(-1, 32767)));
/*     */ 
/* 124 */     this.jSplitPane1.setLeftComponent(this.jPanel1);
/*     */ 
/* 126 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 127 */     this.jPanel2.setLayout(jPanel2Layout);
/* 128 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(1).add(0, 280, 32767));
/*     */ 
/* 132 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(1).add(0, 299, 32767));
/*     */ 
/* 137 */     this.jSplitPane1.setRightComponent(this.jPanel2);
/*     */ 
/* 139 */     GroupLayout layout = new GroupLayout(this);
/* 140 */     setLayout(layout);
/* 141 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(this.jSplitPane1, -1, 400, 32767));
/*     */ 
/* 145 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(this.jSplitPane1, -1, 301, 32767));
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.editors.PathEditor
 * JD-Core Version:    0.6.2
 */