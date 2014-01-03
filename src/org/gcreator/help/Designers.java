/*    */ package org.gcreator.help;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Color;
/*    */ import java.awt.Dimension;
/*    */ import javax.swing.JEditorPane;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JScrollPane;
/*    */ 
/*    */ public class Designers extends JPanel
/*    */ {
/*    */   private JEditorPane jEditorPane1;
/*    */   private JScrollPane jScrollPane1;
/*    */ 
/*    */   public Designers()
/*    */   {
/* 17 */     initComponents();
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 28 */     this.jScrollPane1 = new JScrollPane();
/* 29 */     this.jEditorPane1 = new JEditorPane();
/*    */ 
/* 31 */     setMaximumSize(new Dimension(2147483647, 1000));
/* 32 */     setLayout(new BorderLayout());
/*    */ 
/* 34 */     this.jEditorPane1.setBackground(Color.white);
/* 35 */     this.jEditorPane1.setContentType("text/html");
/* 36 */     this.jEditorPane1.setText("Luis Peregrina<br>\n&emsp;&emsp;New icon theme<br>");
/* 37 */     this.jEditorPane1.setMaximumSize(new Dimension(2147483647, 800));
/* 38 */     this.jScrollPane1.setViewportView(this.jEditorPane1);
/*    */ 
/* 40 */     add(this.jScrollPane1, "Center");
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.help.Designers
 * JD-Core Version:    0.6.2
 */