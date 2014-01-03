/*    */ package org.gcreator.components;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Dimension;
/*    */ import javax.swing.BorderFactory;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class Statusbar extends JPanel
/*    */ {
/* 22 */   private String text = "Text";
/*    */   private ExtendedProgressBar extendedProgressBar1;
/*    */   private JLabel jLabel1;
/*    */   private JLabel jLabel5;
/*    */   private JPanel jPanel1;
/*    */ 
/*    */   public Statusbar()
/*    */   {
/* 19 */     initComponents();
/*    */   }
/*    */ 
/*    */   public void setText(String text)
/*    */   {
/* 25 */     this.jLabel1.setText(text);
/*    */   }
/*    */ 
/*    */   public void restoreText() {
/* 29 */     this.jLabel1.setText(this.text);
/*    */   }
/*    */ 
/*    */   public void setStandardText(String text) {
/* 33 */     this.text = text;
/*    */   }
/*    */ 
/*    */   public String getStandardText() {
/* 37 */     return this.text;
/*    */   }
/*    */ 
/*    */   public ExtendedProgressBar getProgressBar() {
/* 41 */     return this.extendedProgressBar1;
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 52 */     this.jLabel5 = new JLabel();
/* 53 */     this.jLabel1 = new JLabel();
/* 54 */     this.jPanel1 = new JPanel();
/* 55 */     this.extendedProgressBar1 = new ExtendedProgressBar();
/*    */ 
/* 57 */     this.jLabel5.setText("jLabel5");
/*    */ 
/* 59 */     setBorder(BorderFactory.createBevelBorder(1));
/* 60 */     setMaximumSize(new Dimension(2147483647, 20));
/* 61 */     setMinimumSize(new Dimension(50, 20));
/* 62 */     setPreferredSize(new Dimension(175, 20));
/* 63 */     setLayout(new BorderLayout());
/*    */ 
/* 65 */     this.jLabel1.setText("Text");
/* 66 */     add(this.jLabel1, "Before");
/*    */ 
/* 68 */     this.jPanel1.setLayout(new BorderLayout());
/* 69 */     this.jPanel1.add(this.extendedProgressBar1, "After");
/*    */ 
/* 71 */     add(this.jPanel1, "After");
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.Statusbar
 * JD-Core Version:    0.6.2
 */