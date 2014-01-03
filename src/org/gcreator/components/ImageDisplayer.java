/*     */ package org.gcreator.components;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JPanel;
/*     */ import org.gcreator.editors.ImageEditor;
/*     */ import org.gcreator.fileclass.GFile;
/*     */ import org.gcreator.fileclass.res.GImage;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ 
/*     */ public class ImageDisplayer extends JPanel
/*     */ {
/*     */   private GFile file;
/*  20 */   public double zoom = 1.0D;
/*     */   public ImageEditor e;
/*     */ 
/*     */   public ImageDisplayer(ImageEditor e, GFile file)
/*     */   {
/*  24 */     initComponents();
/*  25 */     this.file = file;
/*  26 */     this.e = e;
/*     */   }
/*     */ 
/*     */   public int getWidth()
/*     */   {
/*  32 */     if (this.file.value == null) {
/*  33 */       return 0;
/*     */     }
/*  35 */     ImageIcon img = ((GImage)this.file.value).image;
/*  36 */     return (int)(img.getIconWidth() * this.zoom);
/*     */   }
/*     */ 
/*     */   public int getHeight()
/*     */   {
/*  42 */     if (this.file.value == null) {
/*  43 */       return 0;
/*     */     }
/*  45 */     ImageIcon img = ((GImage)this.file.value).image;
/*  46 */     return (int)(img.getIconHeight() * this.zoom);
/*     */   }
/*     */ 
/*     */   public Dimension getPreferredSize()
/*     */   {
/*  52 */     return new Dimension(getWidth(), getHeight());
/*     */   }
/*     */ 
/*     */   public void paint(Graphics g)
/*     */   {
/*  60 */     boolean isBlack = true;
/*     */ 
/*  98 */     if (this.file.value != null)
/*  99 */       g.drawImage(((GImage)this.file.value).image.getImage(), 0, 0, getWidth(), getHeight(), this.e.getTransparencyColor(), ((GImage)this.file.value).image.getImageObserver());
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 116 */     GroupLayout layout = new GroupLayout(this);
/* 117 */     setLayout(layout);
/* 118 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(0, 134, 32767));
/*     */ 
/* 122 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(0, 132, 32767));
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.ImageDisplayer
 * JD-Core Version:    0.6.2
 */