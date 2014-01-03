/*    */ package org.gcreator.actions.components;
/*    */ 
/*    */ import java.awt.GridLayout;
/*    */ import java.util.Vector;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JPanel;
/*    */ import org.gcreator.actions.extensible.Argument;
/*    */ 
/*    */ public class ArgumentListPanel extends JPanel
/*    */ {
/* 19 */   public Vector<JComponent> comp = new Vector();
/*    */ 
/*    */   public ArgumentListPanel() {
/* 22 */     initComponents();
/*    */   }
/*    */ 
/*    */   public void addArgument(Argument a)
/*    */   {
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 37 */     setLayout(new GridLayout(0, 2));
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.components.ArgumentListPanel
 * JD-Core Version:    0.6.2
 */