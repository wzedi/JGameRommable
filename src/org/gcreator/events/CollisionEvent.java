/*    */ package org.gcreator.events;
/*    */ 
/*    */ import javax.swing.ImageIcon;
/*    */ import org.gcreator.fileclass.GFile;
/*    */ 
/*    */ public class CollisionEvent extends Event
/*    */ {
/*    */   static ImageIcon icon;
/*    */   public GFile other;
/*    */   static final long serialVersionUID = 1L;
/*    */ 
/*    */   public CollisionEvent()
/*    */   {
/*    */   }
/*    */ 
/*    */   public CollisionEvent(GFile other)
/*    */   {
/* 24 */     icon = new ImageIcon(getClass().getResource("/org/gcreator/resources/events/collision.png"));
/* 25 */     this.other = other;
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 30 */     return "Collision with " + this.other.name;
/*    */   }
/*    */ 
/*    */   public ImageIcon getImage()
/*    */   {
/* 35 */     if (icon == null)
/* 36 */       icon = new ImageIcon(getClass().getResource("/org/gcreator/resources/events/collision.png"));
/* 37 */     return icon;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.events.CollisionEvent
 * JD-Core Version:    0.6.2
 */