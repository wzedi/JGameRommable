/*    */ package org.gcreator.components;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Graphics;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ import org.gcreator.editors.SpriteEditor;
/*    */ import org.gcreator.fileclass.res.Sprite;
/*    */ 
/*    */ public class SubimagePreview extends JLabel
/*    */ {
/*    */   private SpriteEditor editor;
/*    */ 
/*    */   public SubimagePreview(SpriteEditor editor)
/*    */   {
/* 29 */     this.editor = editor;
/*    */   }
/*    */ 
/*    */   public ImageIcon getCurrentImage() {
/* 33 */     return this.editor.getCurrentImage();
/*    */   }
/*    */ 
/*    */   public Dimension getPreferredSize()
/*    */   {
/* 38 */     ImageIcon img = getCurrentImage();
/* 39 */     if (img == null)
/* 40 */       return new Dimension(0, 0);
/* 41 */     return new Dimension(img.getIconWidth(), img.getIconHeight());
/*    */   }
/*    */ 
/*    */   public void paint(Graphics g)
/*    */   {
/* 46 */     ImageIcon img = getCurrentImage();
/* 47 */     drawBackground(g);
/* 48 */     if (img != null) {
/* 49 */       g.drawImage(img.getImage(), 0, 0, img.getImageObserver());
/*    */ 
/* 54 */       g.setColor(Color.WHITE);
/* 55 */       g.setXORMode(Color.BLACK);
/* 56 */       Sprite s = this.editor.sprite;
/* 57 */       byte width = 32;
/*    */ 
/* 59 */       if ((s.originX - width < s.width) && (s.originY < s.height)) {
/* 60 */         g.drawLine(s.originX - width, s.originY, Math.min(s.originX + width, s.width - 1), s.originY);
/*    */       }
/* 62 */       if ((s.originY - width < s.height) && (s.originX < s.width)) {
/* 63 */         g.drawLine(s.originX, s.originY - width, s.originX, Math.min(s.originY + width, s.height - 1));
/*    */       }
/*    */ 
/* 71 */       if (s.BBleft < s.width) {
/* 72 */         g.drawLine(s.BBleft, Math.min(s.BBTop + (s.BBTop < s.BBBottom ? 1 : -1), s.height - 1), s.BBleft, Math.min(s.BBBottom - (s.BBTop < s.BBBottom ? 1 : -1), s.height - 1));
/*    */       }
/* 74 */       if (s.BBRight < s.width) {
/* 75 */         g.drawLine(s.BBRight, Math.min(s.BBTop + (s.BBTop < s.BBBottom ? 1 : -1), s.height - 1), s.BBRight, Math.min(s.BBBottom - (s.BBTop < s.BBBottom ? 1 : -1), s.height - 1));
/*    */       }
/* 77 */       if (s.BBTop < s.height) {
/* 78 */         g.drawLine(Math.min(s.BBleft, s.width - 1), s.BBTop, Math.min(s.BBRight, s.width - 1), s.BBTop);
/*    */       }
/* 80 */       if (s.BBBottom < s.height)
/* 81 */         g.drawLine(Math.min(s.BBleft, s.width - 1), s.BBBottom, Math.min(s.BBRight, s.width - 1), s.BBBottom);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void drawBackground(Graphics g) {
/* 86 */     Dimension d = getPreferredSize();
/* 87 */     boolean white = false;
/* 88 */     boolean row = true;
/* 89 */     g.setColor(Color.WHITE);
/* 90 */     for (int i = 0; i <= d.width / 10; i++) {
/* 91 */       row = !row;
/* 92 */       white = row;
/* 93 */       g.setColor(white ? Color.WHITE : Color.DARK_GRAY);
/* 94 */       for (int j = 0; j <= d.height / 10; j++) {
/* 95 */         g.fillRect(i * 10, j * 10, Math.min(10, d.width - i * 10), Math.min(10, d.height - j * 10));
/* 96 */         if ((!white ? 1 : 0) != 0)
/* 97 */           g.setColor(Color.WHITE);
/*    */         else
/* 99 */           g.setColor(Color.DARK_GRAY);
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.SubimagePreview
 * JD-Core Version:    0.6.2
 */