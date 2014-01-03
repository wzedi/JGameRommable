/*    */ package org.gcreator.units;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ import javax.swing.ImageIcon;
/*    */ import org.gcreator.fileclass.GFile;
/*    */ 
/*    */ public class Tile
/*    */ {
/* 18 */   public GFile tileset = null;
/* 19 */   public int sx = 0;
/* 20 */   public int sy = 0;
/* 21 */   public int width = 20;
/* 22 */   public int height = 20;
/* 23 */   public int dx = 0;
/* 24 */   public int dy = 0;
/* 25 */   public int depth = 0;
/*    */ 
/*    */   public ImageIcon getTilesetImage() {
/* 28 */     if (this.tileset == null)
/* 29 */       return null;
/* 30 */     if (this.tileset.value == null)
/* 31 */       return null;
/* 32 */     if ((this.tileset.value instanceof ImageIcon))
/* 33 */       return (ImageIcon)this.tileset.value;
/* 34 */     return null;
/*    */   }
/*    */ 
/*    */   public void drawTileImage(Graphics g) {
/* 38 */     if (g == null)
/* 39 */       return;
/* 40 */     ImageIcon img = getTilesetImage();
/* 41 */     if (img == null)
/* 42 */       return;
/* 43 */     g.drawImage(img.getImage(), this.dx, this.dy, this.dx + this.width, this.dy + this.height, this.sx, this.sy, this.sx + this.width, this.sy + this.height, img.getImageObserver());
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.units.Tile
 * JD-Core Version:    0.6.2
 */