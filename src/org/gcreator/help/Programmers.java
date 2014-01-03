/*    */ package org.gcreator.help;
/*    */ 
/*    */ import javax.swing.JEditorPane;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JScrollPane;
/*    */ import org.jdesktop.layout.GroupLayout;
/*    */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*    */ 
/*    */ public class Programmers extends JPanel
/*    */ {
/*    */   private JEditorPane jEditorPane1;
/*    */   private JScrollPane jScrollPane1;
/*    */ 
/*    */   public Programmers()
/*    */   {
/* 18 */     initComponents();
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 29 */     this.jScrollPane1 = new JScrollPane();
/* 30 */     this.jEditorPane1 = new JEditorPane();
/*    */ 
/* 32 */     this.jEditorPane1.setEditable(false);
/* 33 */     this.jEditorPane1.setText("Listed in alphabetic order:\n\tLuís Reis\n\tSerge Humphrey (BobSerge or Bobistaken)\n\tTGMG");
/* 34 */     this.jScrollPane1.setViewportView(this.jEditorPane1);
/*    */ 
/* 36 */     GroupLayout layout = new GroupLayout(this);
/* 37 */     setLayout(layout);
/* 38 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(this.jScrollPane1, -1, 297, 32767));
/*    */ 
/* 42 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(this.jScrollPane1, -1, 78, 32767));
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.help.Programmers
 * JD-Core Version:    0.6.2
 */