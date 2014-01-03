/*    */ package org.gcreator.components.impl;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class ToolbarSeparator extends ToolbarItem
/*    */ {
/*    */   public int getWidth()
/*    */   {
/* 19 */     return 3;
/*    */   }
/*    */   public int getHeight() {
/* 22 */     return 10;
/*    */   }
/*    */   public void paint(Graphics g, int x, int width) {
/* 25 */     g.setColor(Color.BLACK);
/* 26 */     g.drawLine(x + 1, 1, x + 1, width - 1);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.impl.ToolbarSeparator
 * JD-Core Version:    0.6.2
 */