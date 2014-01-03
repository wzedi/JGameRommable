/*    */ package org.gcreator.events;
/*    */ 
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ public class StepEvent extends Event
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/*    */   static ImageIcon icon;
/*    */ 
/*    */   public StepEvent()
/*    */   {
/* 22 */     icon = new ImageIcon(getClass().getResource("/org/gcreator/resources/events/step.png"));
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 27 */     return "Step";
/*    */   }
/*    */ 
/*    */   public ImageIcon getImage()
/*    */   {
/* 32 */     if (icon == null)
/* 33 */       icon = new ImageIcon(getClass().getResource("/org/gcreator/resources/events/step.png"));
/* 34 */     return icon;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.events.StepEvent
 * JD-Core Version:    0.6.2
 */