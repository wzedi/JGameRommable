/*    */ package org.gcreator.actions.components;
/*    */ 
/*    */ import javax.swing.DefaultComboBoxModel;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JComboBox;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JTextField;
/*    */ import org.jdesktop.layout.GroupLayout;
/*    */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*    */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*    */ 
/*    */ public class SetVariableAction extends JPanel
/*    */ {
/*    */   private JButton jButton1;
/*    */   private JComboBox jComboBox1;
/*    */   private JLabel jLabel1;
/*    */   private JLabel jLabel2;
/*    */   private JLabel jLabel3;
/*    */   private JPanel jPanel1;
/*    */   private JTextField jTextField1;
/*    */   private JTextField jTextField2;
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 31 */     this.jComboBox1 = new JComboBox();
/* 32 */     this.jPanel1 = new JPanel();
/* 33 */     this.jLabel2 = new JLabel();
/* 34 */     this.jTextField1 = new JTextField();
/* 35 */     this.jLabel3 = new JLabel();
/* 36 */     this.jTextField2 = new JTextField();
/* 37 */     this.jLabel1 = new JLabel();
/* 38 */     this.jButton1 = new JButton();
/*    */ 
/* 40 */     this.jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "Create New variable", "Use existine variable" }));
/*    */ 
/* 42 */     this.jLabel2.setText("Variable Type:");
/*    */ 
/* 44 */     this.jTextField1.setText("String");
/*    */ 
/* 46 */     this.jLabel3.setText("Initial Value");
/*    */ 
/* 48 */     this.jTextField2.setText("\"\"");
/*    */ 
/* 50 */     this.jLabel1.setText("<html>This action will set the value of a variable. Select if you want to create the variable or not in the combo box, the panel below will update based on the decision.</html>");
/*    */ 
/* 52 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 53 */     this.jPanel1.setLayout(jPanel1Layout);
/* 54 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().addContainerGap().add(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().add(this.jLabel2).addPreferredGap(0).add(this.jTextField1, -1, 689, 32767)).add(jPanel1Layout.createSequentialGroup().add(this.jLabel3).add(18, 18, 18).add(this.jTextField2, -1, 689, 32767)).add(this.jLabel1)).addContainerGap()));
/*    */ 
/* 70 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().addContainerGap().add(jPanel1Layout.createParallelGroup(3).add(this.jLabel2).add(this.jTextField1, -2, -1, -2)).addPreferredGap(0).add(jPanel1Layout.createParallelGroup(3).add(this.jLabel3).add(this.jTextField2, -2, -1, -2)).addPreferredGap(1).add(this.jLabel1).addContainerGap(144, 32767)));
/*    */ 
/* 86 */     this.jButton1.setText("Done");
/*    */ 
/* 88 */     GroupLayout layout = new GroupLayout(this);
/* 89 */     setLayout(layout);
/* 90 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createParallelGroup(1).add(this.jPanel1, -1, -1, 32767).add(this.jButton1)).add(layout.createSequentialGroup().add(90, 90, 90).add(this.jComboBox1, -2, -1, -2)));
/*    */ 
/* 99 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(layout.createParallelGroup(1).add(this.jPanel1, -1, -1, 32767).add(this.jButton1)).add(8, 8, 8).add(this.jComboBox1, -2, -1, -2)));
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.components.SetVariableAction
 * JD-Core Version:    0.6.2
 */