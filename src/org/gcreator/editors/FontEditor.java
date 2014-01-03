/*     */ package org.gcreator.editors;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class FontEditor extends JPanel
/*     */ {
/*     */   private JButton jButton1;
/*     */   private JCheckBox jCheckBox1;
/*     */   private JCheckBox jCheckBox2;
/*     */   private JComboBox jComboBox1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JTextField jTextField1;
/*     */   private JTextField jTextField2;
/*     */ 
/*     */   public FontEditor()
/*     */   {
/*  17 */     initComponents();
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  28 */     this.jLabel1 = new JLabel();
/*  29 */     this.jTextField1 = new JTextField();
/*  30 */     this.jButton1 = new JButton();
/*  31 */     this.jLabel2 = new JLabel();
/*  32 */     this.jTextField2 = new JTextField();
/*  33 */     this.jLabel3 = new JLabel();
/*  34 */     this.jComboBox1 = new JComboBox();
/*  35 */     this.jCheckBox1 = new JCheckBox();
/*  36 */     this.jCheckBox2 = new JCheckBox();
/*     */ 
/*  38 */     this.jLabel1.setText("Name:");
/*     */ 
/*  40 */     this.jTextField1.setText("jTextField1");
/*     */ 
/*  42 */     this.jButton1.setText("Rename");
/*  43 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  45 */         FontEditor.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  49 */     this.jLabel2.setText("Size:");
/*     */ 
/*  51 */     this.jTextField2.setText("10");
/*  52 */     this.jTextField2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  54 */         FontEditor.this.jTextField2ActionPerformed(evt);
/*     */       }
/*     */     });
/*  58 */     this.jLabel3.setText("Font:");
/*     */ 
/*  60 */     this.jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*     */ 
/*  62 */     this.jCheckBox1.setText("Bold");
/*  63 */     this.jCheckBox1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  65 */         FontEditor.this.jCheckBox1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  69 */     this.jCheckBox2.setText("Italic");
/*     */ 
/*  71 */     GroupLayout layout = new GroupLayout(this);
/*  72 */     setLayout(layout);
/*  73 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1, false).add(layout.createSequentialGroup().add(this.jCheckBox1, -2, 113, -2).addPreferredGap(1).add(this.jCheckBox2, -1, -1, 32767)).add(layout.createSequentialGroup().add(layout.createParallelGroup(1, false).add(layout.createSequentialGroup().add(this.jLabel1).addPreferredGap(0).add(this.jTextField1, -2, 110, -2)).add(layout.createSequentialGroup().add(this.jLabel2).addPreferredGap(1).add(this.jTextField2))).addPreferredGap(0).add(this.jButton1)).add(layout.createSequentialGroup().add(this.jLabel3).addPreferredGap(0).add(this.jComboBox1, 0, -1, 32767))).addContainerGap(-1, 32767)));
/*     */ 
/* 100 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(3).add(this.jLabel1).add(this.jButton1).add(this.jTextField1, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(1).add(this.jLabel2).add(this.jTextField2, -2, -1, -2)).addPreferredGap(1).add(layout.createParallelGroup(3).add(this.jLabel3).add(this.jComboBox1, -2, -1, -2)).addPreferredGap(1).add(layout.createParallelGroup(3).add(this.jCheckBox1).add(this.jCheckBox2)).addContainerGap(25, 32767)));
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jTextField2ActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jCheckBox1ActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.editors.FontEditor
 * JD-Core Version:    0.6.2
 */