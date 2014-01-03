/*    */ package org.gcreator.components.popupmenus;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JMenuItem;
/*    */ import javax.swing.JPopupMenu;
/*    */ 
/*    */ public class StepListPopup extends JPopupMenu
/*    */ {
/*    */   JMenuItem begin;
/*    */   JMenuItem step;
/*    */   JMenuItem end;
/*    */   EventSelect selector;
/*    */ 
/*    */   public StepListPopup(EventSelect selector)
/*    */   {
/* 28 */     this.begin = new JMenuItem("Begin Step");
/* 29 */     this.step = new JMenuItem("Step");
/* 30 */     this.end = new JMenuItem("End Step");
/* 31 */     this.selector = selector;
/* 32 */     add(this.begin);
/* 33 */     this.begin.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent evt) {
/* 35 */         StepListPopup.this.beginstep();
/*    */       }
/*    */     });
/* 38 */     add(this.step);
/* 39 */     this.step.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent evt) {
/* 41 */         StepListPopup.this.stdstep();
/*    */       }
/*    */     });
/* 44 */     add(this.end);
/* 45 */     this.end.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent evt) {
/* 47 */         StepListPopup.this.endstep();
/*    */       }
/*    */     });
/* 50 */     updateUI();
/*    */   }
/*    */ 
/*    */   private void beginstep() {
/* 54 */     this.selector.callEvent(3001);
/* 55 */     setVisible(false);
/* 56 */     this.selector.dispose();
/* 57 */     this.selector = null;
/*    */   }
/*    */ 
/*    */   private void stdstep() {
/* 61 */     this.selector.callEvent(3002);
/* 62 */     setVisible(false);
/* 63 */     this.selector.dispose();
/* 64 */     this.selector = null;
/*    */   }
/*    */ 
/*    */   private void endstep() {
/* 68 */     this.selector.callEvent(3003);
/* 69 */     setVisible(false);
/* 70 */     this.selector.dispose();
/* 71 */     this.selector = null;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.popupmenus.StepListPopup
 * JD-Core Version:    0.6.2
 */