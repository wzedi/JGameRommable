/*    */ package org.gcreator.events;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ public class KeyboardEvent extends Event
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/*    */   public int type;
/*    */   public int keycode;
/*    */   public ImageIcon icon;
/* 19 */   public String text = " key"; public String name = "";
/*    */ 
/*    */   KeyboardEvent()
/*    */   {
/*    */   }
/*    */ 
/*    */   public KeyboardEvent(int type, String name) {
/* 26 */     this.name = name;
/* 27 */     this.type = type;
/* 28 */     this.keycode = type;
/* 29 */     System.out.println("Keyboard Type:" + type);
/* 30 */     this.icon = new ImageIcon(getClass().getResource("/org/gcreator/resources/events/keyboard.png"));
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 39 */     return this.name + this.text;
/*    */   }
/*    */   public ImageIcon getImage() {
/* 42 */     if (this.icon == null)
/* 43 */       this.icon = new ImageIcon(getClass().getResource("/org/gcreator/resources/events/keyboard.png"));
/* 44 */     return this.icon;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.events.KeyboardEvent
 * JD-Core Version:    0.6.2
 */