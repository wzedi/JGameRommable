/*    */ package org.gcreator.events;
/*    */ 
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ public class KeyPress extends KeyboardEvent
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/*    */ 
/*    */   public KeyPress(int type, String name)
/*    */   {
/* 19 */     this.name = name;
/* 20 */     this.type = type;
/* 21 */     this.text = " Pressed";
/* 22 */     this.icon = new ImageIcon(getClass().getResource("/org/gcreator/resources/events/key_press.png"));
/*    */   }
/*    */ 
/*    */   public ImageIcon getImage() {
/* 26 */     if (this.icon == null)
/* 27 */       this.icon = new ImageIcon(getClass().getResource("/org/gcreator/resources/events/key_press.png"));
/* 28 */     return this.icon;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.events.KeyPress
 * JD-Core Version:    0.6.2
 */