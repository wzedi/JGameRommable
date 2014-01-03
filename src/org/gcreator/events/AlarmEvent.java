/*    */ package org.gcreator.events;
/*    */ 
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ public class AlarmEvent extends Event
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/*    */   public int number;
/*    */   public static ImageIcon icon;
/*    */ 
/*    */   public AlarmEvent(int number)
/*    */   {
/* 19 */     this.number = number;
/* 20 */     icon = new ImageIcon(getClass().getResource("/org/gcreator/resources/events/alarm.png"));
/*    */   }
/*    */   public String toString() {
/* 23 */     return "Alarm " + this.number;
/*    */   }
/*    */   public ImageIcon getImage() {
/* 26 */     if (icon == null)
/* 27 */       icon = new ImageIcon(getClass().getResource("/org/gcreator/resources/events/alarm.png"));
/* 28 */     return icon;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.events.AlarmEvent
 * JD-Core Version:    0.6.2
 */