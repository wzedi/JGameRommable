/*    */ package org.gcreator.events;
/*    */ 
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ public class KeyReleased extends KeyboardEvent
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/*    */ 
/*    */   public KeyReleased(int type, String name)
/*    */   {
/* 18 */     this.name = name;
/* 19 */     this.text = " Released";
/* 20 */     this.type = type;
/* 21 */     this.icon = new ImageIcon(getClass().getResource("/org/gcreator/resources/events/key_release.png"));
/*    */   }
/*    */ 
/*    */   public ImageIcon getImage() {
/* 25 */     if (this.icon == null)
/* 26 */       this.icon = new ImageIcon(getClass().getResource("/org/gcreator/resources/events/key_release.png"));
/* 27 */     return this.icon;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.events.KeyReleased
 * JD-Core Version:    0.6.2
 */