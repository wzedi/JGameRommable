/*    */ package org.gcreator.components.navigator;
/*    */ 
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import org.jdesktop.layout.GroupLayout;
/*    */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*    */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*    */ 
/*    */ public class UnknownResourceNavigator extends JPanel
/*    */ {
/*    */   private JLabel jLabel1;
/*    */ 
/*    */   public UnknownResourceNavigator()
/*    */   {
/* 17 */     initComponents();
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 28 */     this.jLabel1 = new JLabel();
/*    */ 
/* 30 */     this.jLabel1.setText("No navigator");
/*    */ 
/* 32 */     GroupLayout layout = new GroupLayout(this);
/* 33 */     setLayout(layout);
/* 34 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jLabel1).addContainerGap(306, 32767)));
/*    */ 
/* 41 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jLabel1).addContainerGap(271, 32767)));
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.navigator.UnknownResourceNavigator
 * JD-Core Version:    0.6.2
 */