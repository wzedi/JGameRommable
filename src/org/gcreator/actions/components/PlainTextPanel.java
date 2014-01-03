/*    */ package org.gcreator.actions.components;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JScrollPane;
/*    */ import javax.swing.JTextPane;
/*    */ import org.jdesktop.layout.GroupLayout;
/*    */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*    */ 
/*    */ public class PlainTextPanel extends JPanel
/*    */   implements Serializable
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/*    */   private JScrollPane jScrollPane1;
/*    */   public JTextPane text;
/*    */ 
/*    */   public PlainTextPanel()
/*    */   {
/* 22 */     initComponents();
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 33 */     this.jScrollPane1 = new JScrollPane();
/* 34 */     this.text = new JTextPane();
/*    */ 
/* 36 */     this.text.setText("Some Text");
/* 37 */     this.jScrollPane1.setViewportView(this.text);
/*    */ 
/* 39 */     GroupLayout layout = new GroupLayout(this);
/* 40 */     setLayout(layout);
/* 41 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(this.jScrollPane1, -1, 132, 32767));
/*    */ 
/* 45 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(this.jScrollPane1, -1, 67, 32767));
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.components.PlainTextPanel
 * JD-Core Version:    0.6.2
 */