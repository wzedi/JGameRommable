/*     */ package org.gcreator.components;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JSpinner;
/*     */ import org.gcreator.editors.SceneEditor;
/*     */ import org.gcreator.fileclass.res.Tileset;
/*     */ 
/*     */ public class TileChooser extends JComponent
/*     */ {
/*     */   private SceneEditor sceneeditor;
/*     */ 
/*     */   public TileChooser(SceneEditor editor)
/*     */   {
/*  20 */     this.sceneeditor = editor;
/*     */   }
/*     */ 
/*     */   public Tileset getSourceTileset() {
/*     */     try {
/*  25 */       return this.sceneeditor.getTileset();
/*     */     } catch (NullPointerException e) {
/*     */     }
/*  28 */     return null;
/*     */   }
/*     */ 
/*     */   public ImageIcon getSourceImage()
/*     */   {
/*  33 */     Tileset t = getSourceTileset();
/*  34 */     if (t == null)
/*  35 */       return null;
/*  36 */     return t.getImage();
/*     */   }
/*     */ 
/*     */   public int getPreferredWidth() {
/*  40 */     int w = 0;
/*     */     try {
/*  42 */       w = getSourceImage().getIconWidth();
/*  43 */       w -= getSourceTileset().startx;
/*     */     }
/*     */     catch (NullPointerException e) {
/*  46 */       return 0;
/*     */     }
/*     */ 
/*  54 */     return w;
/*     */   }
/*     */ 
/*     */   public int getPreferredHeight() {
/*  58 */     int h = 0;
/*     */     try {
/*  60 */       h = getSourceImage().getIconHeight();
/*     */     }
/*     */     catch (NullPointerException e) {
/*  63 */       return 0;
/*     */     }
/*     */ 
/*  72 */     return h;
/*     */   }
/*     */ 
/*     */   public int getWidth() {
/*  76 */     return getPreferredWidth();
/*     */   }
/*     */ 
/*     */   public int getHeight()
/*     */   {
/*  81 */     return getPreferredHeight();
/*     */   }
/*     */ 
/*     */   public Dimension getPreferredSize() {
/*  85 */     return new Dimension(getPreferredWidth(), getPreferredHeight());
/*     */   }
/*     */ 
/*     */   public void paint(Graphics g) {
/*  89 */     ImageIcon img = getSourceImage();
/*  90 */     g.clearRect(0, 0, getPreferredWidth(), getPreferredHeight());
/*  91 */     if (img == null)
/*  92 */       return;
/*  93 */     g.drawImage(img.getImage(), 0, 0, img.getImageObserver());
/*  94 */     int x = ((Integer)this.sceneeditor.jSpinner13.getValue()).intValue();
/*  95 */     int y = ((Integer)this.sceneeditor.jSpinner14.getValue()).intValue();
/*  96 */     int w = ((Integer)this.sceneeditor.jSpinner15.getValue()).intValue();
/*  97 */     int h = ((Integer)this.sceneeditor.jSpinner16.getValue()).intValue();
/*  98 */     g.setColor(Color.WHITE);
/*  99 */     g.drawRect(x - 2, y - 2, w + 4, h + 4);
/* 100 */     g.drawRect(x, y, w, h);
/* 101 */     g.setColor(Color.BLACK);
/* 102 */     g.drawRect(x - 1, y - 1, w + 2, h + 2);
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.TileChooser
 * JD-Core Version:    0.6.2
 */