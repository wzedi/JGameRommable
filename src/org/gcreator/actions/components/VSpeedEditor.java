/*    */ package org.gcreator.actions.components;
/*    */ 
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JTextField;
/*    */ import org.jdesktop.layout.GroupLayout;
/*    */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*    */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*    */ 
/*    */ public class VSpeedEditor extends JPanel
/*    */ {
/*    */   private JLabel jLabel1;
/*    */   private JLabel jLabel2;
/*    */   private JLabel jLabel3;
/*    */   public JTextField of;
/*    */   public JTextField to;
/*    */ 
/*    */   public VSpeedEditor()
/*    */   {
/* 17 */     initComponents();
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 28 */     this.jLabel1 = new JLabel();
/* 29 */     this.jLabel2 = new JLabel();
/* 30 */     this.of = new JTextField();
/* 31 */     this.jLabel3 = new JLabel();
/* 32 */     this.to = new JTextField();
/*    */ 
/* 34 */     this.jLabel1.setText("Set the vertical speed");
/*    */ 
/* 36 */     this.jLabel2.setText("Of:");
/*    */ 
/* 38 */     this.of.setText("this");
/*    */ 
/* 40 */     this.jLabel3.setText("To:");
/*    */ 
/* 42 */     this.to.setText("0");
/*    */ 
/* 44 */     GroupLayout layout = new GroupLayout(this);
/* 45 */     setLayout(layout);
/* 46 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(this.jLabel1).add(layout.createSequentialGroup().add(this.jLabel2).addPreferredGap(1).add(this.of, -1, 354, 32767)).add(layout.createSequentialGroup().add(this.jLabel3).addPreferredGap(1).add(this.to, -1, 354, 32767))).addContainerGap()));
/*    */ 
/* 62 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jLabel1).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jLabel2).add(this.of, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jLabel3).add(this.to, -2, -1, -2)).addContainerGap(-1, 32767)));
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.components.VSpeedEditor
 * JD-Core Version:    0.6.2
 */