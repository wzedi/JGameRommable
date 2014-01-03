/*     */ package org.gcreator.components;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JComponent;
/*     */ import org.gcreator.editors.TilesetEditor;
/*     */ import org.gcreator.fileclass.GFile;
/*     */ import org.gcreator.fileclass.res.GImage;
/*     */ import org.gcreator.fileclass.res.Tileset;
/*     */ 
/*     */ public class TilesetPreviewer extends JComponent
/*     */ {
/*     */   private TilesetEditor editor;
/*     */ 
/*     */   public TilesetPreviewer(TilesetEditor editor)
/*     */   {
/*  20 */     this.editor = editor;
/*     */   }
/*     */ 
/*     */   private ImageIcon getSourceImage() {
/*  24 */     if (this.editor == null)
/*  25 */       return null;
/*  26 */     if (this.editor.value.image == null)
/*  27 */       return null;
/*  28 */     GFile imgFile = this.editor.value.image;
/*  29 */     if (imgFile == null)
/*  30 */       return null;
/*  31 */     return ((GImage)imgFile.value).image;
/*     */   }
/*     */ 
/*     */   public int getPreferredWidth() {
/*  35 */     int w = 0;
/*     */     try {
/*  37 */       w = getSourceImage().getIconWidth();
/*     */     }
/*     */     catch (NullPointerException e) {
/*  40 */       return 0;
/*     */     }
/*  42 */     w -= this.editor.value.startx;
/*  43 */     int hsepcount = w % this.editor.value.tilew == 0 ? w / this.editor.value.tilew : w / this.editor.value.tilew + 1;
/*  44 */     return w + hsepcount * 2;
/*     */   }
/*     */ 
/*     */   public int getPreferredHeight() {
/*  48 */     int h = 0;
/*     */     try {
/*  50 */       h = getSourceImage().getIconHeight();
/*     */     }
/*     */     catch (NullPointerException e) {
/*  53 */       return 0;
/*     */     }
/*  55 */     h -= this.editor.value.starty;
/*  56 */     int vsepcount = h % this.editor.value.tileh == 0 ? h / this.editor.value.tileh : h / this.editor.value.tileh + 1;
/*  57 */     return h + vsepcount * 2;
/*     */   }
/*     */ 
/*     */   public int getWidth() {
/*  61 */     return getPreferredWidth();
/*     */   }
/*     */ 
/*     */   public int getHeight()
/*     */   {
/*  66 */     return getPreferredHeight();
/*     */   }
/*     */ 
/*     */   public Dimension getPreferredSize() {
/*  70 */     return new Dimension(getPreferredWidth(), getPreferredHeight());
/*     */   }
/*     */ 
/*     */   public void paint(Graphics g) {
/*  74 */     ImageIcon img = getSourceImage();
/*  75 */     g.clearRect(0, 0, getPreferredWidth(), getPreferredHeight());
/*  76 */     if (img == null)
/*  77 */       return;
/*  78 */     int imgw = img.getIconWidth();
/*  79 */     int imgh = img.getIconHeight();
/*  80 */     int bw = this.editor.value.bwidth;
/*  81 */     int bh = this.editor.value.bheight;
/*     */ 
/*  94 */     g.drawImage(img.getImage(), 0, 0, ((GImage)this.editor.value.image.value).transparentColor, img.getImageObserver());
/*  95 */     g.setColor(Color.WHITE);
/*  96 */     g.setXORMode(Color.BLACK);
/*  97 */     int i = this.editor.value.startx; for (int times = 0; i + bh * times < imgw - 1; times++) {
/*  98 */       g.drawLine(i + bh * times, 0, i + bh * times, imgh - 1);
/*  99 */       if ((bh > 0) && (i + bh * (times + 1) < imgw - 1))
/* 100 */         g.drawLine(i + bh * (times + 1), 0, i + bh * (times + 1), imgh - 1);
/*  97 */       i += this.editor.value.tilew;
/*     */     }
/*     */ 
/* 102 */     i = this.editor.value.starty; for (int times = 0; i + bw * times < imgh - 1; times++) {
/* 103 */       g.drawLine(0, i + bw * times, imgw - 1, i + bw * times);
/* 104 */       if ((bw > 0) && (i + bw * (times + 1) < imgh - 1))
/* 105 */         g.drawLine(0, i + bw * (times + 1), imgw - 1, i + bw * (times + 1));
/* 102 */       i += this.editor.value.tileh;
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.TilesetPreviewer
 * JD-Core Version:    0.6.2
 */