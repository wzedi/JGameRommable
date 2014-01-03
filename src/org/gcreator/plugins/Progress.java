/*    */ package org.gcreator.plugins;
/*    */ 
/*    */ import java.awt.Container;
/*    */ import java.awt.Frame;
/*    */ import java.io.PrintStream;
/*    */ import javax.swing.JDialog;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JProgressBar;
/*    */ import org.gcreator.core.Aurwindow;
/*    */ import org.jdesktop.layout.GroupLayout;
/*    */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*    */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*    */ 
/*    */ public class Progress extends JDialog
/*    */ {
/*    */   public JLabel jLabel1;
/*    */   public JLabel jLabel2;
/*    */   public JProgressBar jProgressBar1;
/*    */ 
/*    */   public Progress()
/*    */   {
/*    */   }
/*    */ 
/*    */   public Progress(Frame parent, boolean modal, PlatformCore c)
/*    */   {
/* 23 */     super(parent, modal);
/*    */ 
/* 25 */     initComponents();
/* 26 */     c.p = this;
/* 27 */     this.jLabel1.setText("Converting to java..");
/* 28 */     setVisible(true);
/*    */   }
/*    */ 
/*    */   public void run(PlatformCore c)
/*    */   {
/* 34 */     final PlatformCore cc = c;
/* 35 */     System.out.println("run");
/* 36 */     new Thread()
/*    */     {
/*    */       public void run()
/*    */       {
/* 40 */         cc.run(Aurwindow.getMainProject());
/*    */       }
/*    */     }
/* 36 */     .run();
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 56 */     this.jLabel2 = new JLabel();
/* 57 */     this.jProgressBar1 = new JProgressBar();
/* 58 */     this.jLabel1 = new JLabel();
/*    */ 
/* 60 */     setDefaultCloseOperation(2);
/*    */ 
/* 62 */     this.jLabel2.setText("Task:");
/*    */ 
/* 64 */     this.jLabel1.setText("Converting to ");
/*    */ 
/* 66 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 67 */     getContentPane().setLayout(layout);
/* 68 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(this.jProgressBar1, -1, 380, 32767).add(this.jLabel1).add(this.jLabel2)).addContainerGap()));
/*    */ 
/* 78 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jLabel1).addPreferredGap(0).add(this.jProgressBar1, -2, 25, -2).addPreferredGap(0).add(this.jLabel2).addContainerGap(-1, 32767)));
/*    */ 
/* 90 */     pack();
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.plugins.Progress
 * JD-Core Version:    0.6.2
 */