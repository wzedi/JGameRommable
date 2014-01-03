/*    */ package org.gcreator.components;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.GradientPaint;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.Point;
/*    */ 
/*    */ public abstract class DarkGradientPainter
/*    */ {
/*    */   public static void paint(Graphics2D g, int width, int height)
/*    */   {
/* 16 */     g.setPaint(new GradientPaint(new Point(0, 0), Color.BLACK, new Point(width, height), Color.GRAY));
/* 17 */     g.fillRect(0, 0, width, height);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.DarkGradientPainter
 * JD-Core Version:    0.6.2
 */