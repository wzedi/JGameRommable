/*    */ package org.gcreator.components;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JProgressBar;
/*    */ 
/*    */ public class ExtendedProgressBar extends JPanel
/*    */ {
/*    */   private JLabel jLabel1;
/*    */   private JProgressBar jProgressBar1;
/*    */ 
/*    */   public ExtendedProgressBar()
/*    */   {
/* 17 */     initComponents();
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 28 */     this.jProgressBar1 = new JProgressBar();
/* 29 */     this.jLabel1 = new JLabel();
/*    */ 
/* 31 */     setLayout(new BorderLayout());
/* 32 */     add(this.jProgressBar1, "Center");
/*    */ 
/* 34 */     this.jLabel1.setText("jLabel1");
/* 35 */     add(this.jLabel1, "Before");
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.ExtendedProgressBar
 * JD-Core Version:    0.6.2
 */