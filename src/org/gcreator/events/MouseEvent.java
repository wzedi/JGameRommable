/*    */ package org.gcreator.events;
/*    */ 
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ public class MouseEvent extends Event
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/*    */   public int type;
/*    */   public static ImageIcon icon;
/*    */ 
/*    */   public MouseEvent(int type)
/*    */   {
/* 23 */     this.type = type;
/* 24 */     icon = new ImageIcon(getClass().getResource("/org/gcreator/resources/events/mouse.png"));
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 28 */     switch (this.type) { case 5006:
/* 29 */       return "Left Button Clicked";
/*    */     case 5007:
/* 30 */       return "Left Button Pressed";
/*    */     case 5008:
/* 31 */       return "Left Button Released";
/*    */     case 5009:
/* 32 */       return "Global Left Button Clicked";
/*    */     case 5010:
/* 33 */       return "Global Left Button Pressed";
/*    */     case 5011:
/* 34 */       return "Global Left Button Released";
/*    */     case 5012:
/* 35 */       return "Right Button Clicked";
/*    */     case 5013:
/* 36 */       return "Right Button Pressed";
/*    */     case 5014:
/* 37 */       return "Right Button Released";
/*    */     case 5015:
/* 38 */       return "Global Right Button Clicked";
/*    */     case 5016:
/* 39 */       return "Global Right Button Pressed";
/*    */     case 5017:
/* 40 */       return "Global Right Button Released";
/*    */     case 5018:
/* 41 */       return "Mouse Entered (Over)";
/*    */     case 5019:
/* 42 */       return "Mouse Exited (Out)"; }
/* 43 */     return "Invalid Mouse Event";
/*    */   }
/*    */ 
/*    */   public ImageIcon getImage()
/*    */   {
/* 49 */     if (icon == null)
/* 50 */       icon = new ImageIcon(getClass().getResource("/org/gcreator/resources/events/mouse.png"));
/* 51 */     return icon;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.events.MouseEvent
 * JD-Core Version:    0.6.2
 */