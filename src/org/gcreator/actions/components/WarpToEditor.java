/*    */ package org.gcreator.actions.components;
/*    */ 
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JTextField;
/*    */ import org.jdesktop.layout.GroupLayout;
/*    */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*    */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*    */ 
/*    */ public class WarpToEditor extends JPanel
/*    */ {
/*    */   public JTextField X;
/*    */   public JTextField Y;
/*    */   private JLabel jLabel1;
/*    */   private JLabel jLabel2;
/*    */   private JLabel jLabel3;
/*    */   private JLabel jLabel4;
/*    */   public JTextField of;
/*    */ 
/*    */   public WarpToEditor()
/*    */   {
/* 19 */     initComponents();
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 30 */     this.jLabel1 = new JLabel();
/* 31 */     this.jLabel2 = new JLabel();
/* 32 */     this.of = new JTextField();
/* 33 */     this.jLabel3 = new JLabel();
/* 34 */     this.X = new JTextField();
/* 35 */     this.jLabel4 = new JLabel();
/* 36 */     this.Y = new JTextField();
/*    */ 
/* 38 */     this.jLabel1.setText("Warp To:");
/*    */ 
/* 40 */     this.jLabel2.setText("Who:");
/*    */ 
/* 42 */     this.of.setText("this");
/*    */ 
/* 44 */     this.jLabel3.setText("X:");
/*    */ 
/* 46 */     this.X.setText("0");
/*    */ 
/* 48 */     this.jLabel4.setText("Y");
/*    */ 
/* 50 */     this.Y.setText("0");
/*    */ 
/* 52 */     GroupLayout layout = new GroupLayout(this);
/* 53 */     setLayout(layout);
/* 54 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(this.jLabel1).add(layout.createSequentialGroup().add(this.jLabel2).addPreferredGap(1).add(this.of, -1, 324, 32767)).add(layout.createSequentialGroup().add(this.jLabel3).addPreferredGap(1).add(this.X, -2, 140, -2).addPreferredGap(0).add(this.jLabel4).addPreferredGap(0).add(this.Y, -1, 186, 32767))).addContainerGap()));
/*    */ 
/* 74 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jLabel1).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jLabel2).add(this.of, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jLabel3).add(this.Y, -2, -1, -2).add(this.jLabel4).add(this.X, -2, -1, -2)).addContainerGap(-1, 32767)));
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.components.WarpToEditor
 * JD-Core Version:    0.6.2
 */