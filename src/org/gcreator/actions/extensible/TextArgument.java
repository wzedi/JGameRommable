/*    */ package org.gcreator.actions.extensible;
/*    */ 
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JTextField;
/*    */ 
/*    */ public class TextArgument
/*    */   implements Argument
/*    */ {
/*    */   public JComponent generateComponent(int index)
/*    */   {
/* 21 */     return new XPanel();
/*    */   }
/*    */ 
/*    */   public Object getValue(JComponent c) {
/* 25 */     return ((XPanel)c).field.getText();
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.extensible.TextArgument
 * JD-Core Version:    0.6.2
 */