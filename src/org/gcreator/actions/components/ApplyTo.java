/*    */ package org.gcreator.actions.components;
/*    */ 
/*    */ import javax.swing.BorderFactory;
/*    */ import javax.swing.ButtonGroup;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JRadioButton;
/*    */ 
/*    */ public class ApplyTo extends JPanel
/*    */ {
/*    */   private ButtonGroup buttonGroup1;
/*    */   private JRadioButton jRadioButton1;
/*    */   private JRadioButton jRadioButton2;
/*    */   private JRadioButton jRadioButton3;
/*    */ 
/*    */   public ApplyTo()
/*    */   {
/* 19 */     initComponents();
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 30 */     this.buttonGroup1 = new ButtonGroup();
/* 31 */     this.jRadioButton1 = new JRadioButton();
/* 32 */     this.jRadioButton2 = new JRadioButton();
/* 33 */     this.jRadioButton3 = new JRadioButton();
/*    */ 
/* 35 */     setBorder(BorderFactory.createTitledBorder("Apply To..."));
/*    */ 
/* 37 */     this.buttonGroup1.add(this.jRadioButton1);
/* 38 */     this.jRadioButton1.setSelected(true);
/* 39 */     this.jRadioButton1.setText("this (self)");
/* 40 */     add(this.jRadioButton1);
/*    */ 
/* 42 */     this.buttonGroup1.add(this.jRadioButton2);
/* 43 */     this.jRadioButton2.setText("other");
/* 44 */     add(this.jRadioButton2);
/*    */ 
/* 46 */     this.buttonGroup1.add(this.jRadioButton3);
/* 47 */     this.jRadioButton3.setText("custom");
/* 48 */     add(this.jRadioButton3);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.components.ApplyTo
 * JD-Core Version:    0.6.2
 */