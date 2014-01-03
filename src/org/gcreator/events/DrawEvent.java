/*    */ package org.gcreator.events;
/*    */ 
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ public class DrawEvent extends Event
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/*    */   static ImageIcon icon;
/*    */ 
/*    */   public DrawEvent()
/*    */   {
/* 22 */     icon = new ImageIcon(getClass().getResource("/org/gcreator/resources/events/draw.png"));
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 27 */     if (icon == null)
/* 28 */       icon = new ImageIcon(getClass().getResource("/org/gcreator/resources/events/draw.png"));
/* 29 */     return "Draw";
/*    */   }
/*    */ 
/*    */   public ImageIcon getImage()
/*    */   {
/* 34 */     return icon;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.events.DrawEvent
 * JD-Core Version:    0.6.2
 */