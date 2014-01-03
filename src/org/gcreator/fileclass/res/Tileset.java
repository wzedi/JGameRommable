/*    */ package org.gcreator.fileclass.res;
/*    */ 
/*    */ import javax.swing.ImageIcon;
/*    */ import org.gcreator.fileclass.GFile;
/*    */ 
/*    */ public class Tileset extends Resource
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/*    */   public GFile image;
/* 18 */   public int startx = 0; public int starty = 0; public int bwidth = 0; public int bheight = 0;
/* 19 */   public int tilew = 20; public int tileh = 20;
/*    */ 
/*    */   private Tileset() {
/* 22 */     this.image = null;
/*    */   }
/*    */ 
/*    */   public ImageIcon getImage() {
/* 26 */     if (this.image == null)
/* 27 */       return null;
/* 28 */     return ((GImage)this.image.value).image;
/*    */   }
/*    */ 
/*    */   public Tileset(String name) {
/* 32 */     this.name = name;
/* 33 */     this.image = null;
/*    */   }
/*    */ 
/*    */   public Resource clone() {
/* 37 */     Tileset x = new Tileset();
/* 38 */     x.image = this.image;
/* 39 */     x.startx = this.startx;
/* 40 */     x.starty = this.starty;
/* 41 */     x.bwidth = this.bwidth;
/* 42 */     x.bheight = this.bheight;
/* 43 */     x.tilew = this.tilew;
/* 44 */     x.tileh = this.tileh;
/* 45 */     return x;
/*    */   }
/*    */ 
/*    */   public String exportToHtml(boolean xhtml) {
/* 49 */     return "";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.res.Tileset
 * JD-Core Version:    0.6.2
 */