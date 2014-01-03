/*    */ package org.gcreator.actions.extensible;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JTextField;
/*    */ 
/*    */ class XPanel extends JPanel
/*    */ {
/*    */   public JLabel label;
/*    */   public JTextField field;
/*    */ 
/*    */   public XPanel()
/*    */   {
/* 35 */     this.label = new JLabel();
/* 36 */     this.label.setVisible(true);
/*    */ 
/* 38 */     this.field = new JTextField();
/* 39 */     this.field.setVisible(true);
/*    */ 
/* 41 */     setVisible(true);
/* 42 */     setLayout(new BorderLayout());
/* 43 */     add(this.label, "West");
/* 44 */     add(this.field, "Center");
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.extensible.XPanel
 * JD-Core Version:    0.6.2
 */