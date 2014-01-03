/*     */ package org.gcreator.editors;
/*     */ 
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.JTextPane;
/*     */ import org.gcreator.components.TabPanel;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class ActionEditor extends TabPanel
/*     */ {
/*     */   private JButton jButton1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JPanel jPanel1;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JScrollPane jScrollPane2;
/*     */   private JTextField jTextField1;
/*     */   private JTextField jTextField2;
/*     */   private JTextField jTextField3;
/*     */   private JTextField jTextField4;
/*     */   private JTextField jTextField5;
/*     */   private JTextPane jTextPane1;
/*     */ 
/*     */   public ActionEditor()
/*     */   {
/*  19 */     initComponents();
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  30 */     this.jLabel1 = new JLabel();
/*  31 */     this.jTextField1 = new JTextField();
/*  32 */     this.jLabel2 = new JLabel();
/*  33 */     this.jTextField2 = new JTextField();
/*  34 */     this.jLabel3 = new JLabel();
/*  35 */     this.jTextField3 = new JTextField();
/*  36 */     this.jPanel1 = new JPanel();
/*  37 */     this.jTextField4 = new JTextField();
/*  38 */     this.jTextField5 = new JTextField();
/*  39 */     this.jButton1 = new JButton();
/*  40 */     this.jScrollPane1 = new JScrollPane();
/*  41 */     this.jLabel4 = new JLabel();
/*  42 */     this.jScrollPane2 = new JScrollPane();
/*  43 */     this.jTextPane1 = new JTextPane();
/*     */ 
/*  45 */     this.jLabel1.setText("Name:");
/*     */ 
/*  47 */     this.jTextField1.setText("jTextField1");
/*     */ 
/*  49 */     this.jLabel2.setText("Category:");
/*     */ 
/*  51 */     this.jTextField2.setText("jTextField2");
/*     */ 
/*  53 */     this.jLabel3.setText("Image:");
/*     */ 
/*  55 */     this.jTextField3.setText("jTextField3");
/*     */ 
/*  57 */     this.jPanel1.setBorder(BorderFactory.createTitledBorder("Arguments"));
/*     */ 
/*  59 */     this.jTextField4.setText("Name");
/*     */ 
/*  61 */     this.jTextField5.setText("Initial Value");
/*     */ 
/*  63 */     this.jButton1.setText("Add");
/*     */ 
/*  65 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  66 */     this.jPanel1.setLayout(jPanel1Layout);
/*  67 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().add(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().add(this.jTextField4, -2, 100, -2).addPreferredGap(0).add(this.jTextField5, -2, 109, -2).addPreferredGap(0).add(this.jButton1)).add(this.jScrollPane1, -1, 358, 32767)).addContainerGap()));
/*     */ 
/*  80 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().add(jPanel1Layout.createParallelGroup(3).add(this.jTextField4, -2, -1, -2).add(this.jTextField5, -2, -1, -2).add(this.jButton1)).addPreferredGap(0).add(this.jScrollPane1, -1, 159, 32767)));
/*     */ 
/*  91 */     this.jLabel4.setText("Code:");
/*     */ 
/*  93 */     this.jScrollPane2.setViewportView(this.jTextPane1);
/*     */ 
/*  95 */     GroupLayout layout = new GroupLayout(this);
/*  96 */     setLayout(layout);
/*  97 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(2, this.jScrollPane2, -1, 380, 32767).add(this.jPanel1, -1, -1, 32767).add(layout.createSequentialGroup().add(layout.createParallelGroup(1, false).add(layout.createSequentialGroup().add(this.jLabel1).addPreferredGap(0).add(this.jTextField1, -2, 120, -2)).add(layout.createSequentialGroup().add(this.jLabel3).addPreferredGap(0).add(this.jTextField3))).addPreferredGap(0).add(this.jLabel2).addPreferredGap(0).add(this.jTextField2, -2, 99, -2)).add(this.jLabel4)).addContainerGap()));
/*     */ 
/* 121 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(3).add(this.jLabel1).add(this.jTextField1, -2, -1, -2).add(this.jLabel2).add(this.jTextField2, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jLabel3).add(this.jTextField3, -2, -1, -2)).addPreferredGap(0).add(this.jPanel1, -2, -1, -2).addPreferredGap(0).add(this.jLabel4).addPreferredGap(0).add(this.jScrollPane2, -1, 72, 32767).addContainerGap()));
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.editors.ActionEditor
 * JD-Core Version:    0.6.2
 */