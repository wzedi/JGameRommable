/*    */ package org.gcreator.components;
/*    */ 
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import org.jdesktop.layout.GroupLayout;
/*    */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*    */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*    */ 
/*    */ public class RSSReader extends JPanel
/*    */ {
/*    */   private JLabel jLabel1;
/*    */ 
/*    */   public RSSReader(String url)
/*    */   {
/* 19 */     initComponents();
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 30 */     this.jLabel1 = new JLabel();
/*    */ 
/* 32 */     setOpaque(false);
/*    */ 
/* 34 */     this.jLabel1.setText("jLabel1");
/*    */ 
/* 36 */     GroupLayout layout = new GroupLayout(this);
/* 37 */     setLayout(layout);
/* 38 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jLabel1).addContainerGap(356, 32767)));
/*    */ 
/* 45 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jLabel1).addContainerGap(275, 32767)));
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.RSSReader
 * JD-Core Version:    0.6.2
 */