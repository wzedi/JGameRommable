/*    */ package org.gcreator.actions.components;
/*    */ 
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JTextField;
/*    */ import org.gcreator.managers.LangSupporter;
/*    */ import org.gcreator.units.Dictionary;
/*    */ import org.jdesktop.layout.GroupLayout;
/*    */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*    */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*    */ 
/*    */ public class HSpeedEditor extends JPanel
/*    */ {
/*    */   private JLabel jLabel1;
/*    */   private JLabel jLabel2;
/*    */   private JLabel jLabel3;
/*    */   public JTextField of;
/*    */   public JTextField to;
/*    */ 
/*    */   public HSpeedEditor()
/*    */   {
/* 20 */     initComponents();
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 31 */     this.jLabel1 = new JLabel();
/* 32 */     this.jLabel2 = new JLabel();
/* 33 */     this.of = new JTextField();
/* 34 */     this.jLabel3 = new JLabel();
/* 35 */     this.to = new JTextField();
/*    */ 
/* 37 */     this.jLabel1.setText(LangSupporter.activeLang.getEntry(240));
/*    */ 
/* 39 */     this.jLabel2.setText(LangSupporter.activeLang.getEntry(241));
/*    */ 
/* 41 */     this.of.setText("this");
/*    */ 
/* 43 */     this.jLabel3.setText(LangSupporter.activeLang.getEntry(242));
/*    */ 
/* 45 */     this.to.setText("0");
/*    */ 
/* 47 */     GroupLayout layout = new GroupLayout(this);
/* 48 */     setLayout(layout);
/* 49 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(this.jLabel1).add(layout.createSequentialGroup().add(this.jLabel2).addPreferredGap(1).add(this.of, -1, 284, 32767)).add(layout.createSequentialGroup().add(this.jLabel3).addPreferredGap(1).add(this.to, -1, 284, 32767))).addContainerGap()));
/*    */ 
/* 65 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jLabel1).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jLabel2).add(this.of, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jLabel3).add(this.to, -2, -1, -2)).addContainerGap(-1, 32767)));
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.components.HSpeedEditor
 * JD-Core Version:    0.6.2
 */