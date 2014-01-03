/*     */ package org.gcreator.components.impl;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class ToolbarButton extends ToolbarItem
/*     */ {
/*  19 */   private String id = null;
/*  20 */   private String text = null;
/*  21 */   private ImageIcon image = null;
/*  22 */   private ActionListener actionlistener = null;
/*  23 */   private boolean showImage = false;
/*  24 */   private boolean showText = false;
/*  25 */   private boolean bold = false;
/*     */ 
/*     */   public ToolbarButton()
/*     */   {
/*     */   }
/*     */ 
/*     */   public ToolbarButton(String id, String text, ImageIcon image)
/*     */   {
/*  39 */     setID(id);
/*  40 */     setText(text);
/*  41 */     setImage(image);
/*  42 */     if (image != null)
/*  43 */       this.showImage = true;
/*  44 */     else if (text != null)
/*  45 */       this.showText = true;
/*     */   }
/*     */ 
/*     */   public String getText()
/*     */   {
/*  53 */     return this.text;
/*     */   }
/*     */ 
/*     */   public void setText(String text)
/*     */   {
/*  61 */     this.text = text;
/*     */   }
/*     */ 
/*     */   public String getID()
/*     */   {
/*  69 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setID(String id)
/*     */   {
/*  77 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public ImageIcon getImage()
/*     */   {
/*  85 */     return this.image;
/*     */   }
/*     */ 
/*     */   public void setImage(ImageIcon image)
/*     */   {
/*  93 */     this.image = image;
/*     */   }
/*     */ 
/*     */   public void setTextVisible(boolean visible)
/*     */   {
/* 101 */     this.showText = visible;
/*     */   }
/*     */ 
/*     */   public void setImageVisible(boolean visible)
/*     */   {
/* 109 */     this.showImage = visible;
/*     */   }
/*     */ 
/*     */   public void setBold(boolean bold)
/*     */   {
/* 117 */     this.bold = bold;
/*     */   }
/*     */ 
/*     */   public boolean isTextVisible()
/*     */   {
/* 125 */     return this.showText;
/*     */   }
/*     */ 
/*     */   public boolean isImageVisible()
/*     */   {
/* 133 */     return this.showImage;
/*     */   }
/*     */ 
/*     */   public boolean isBold()
/*     */   {
/* 141 */     return this.bold;
/*     */   }
/*     */ 
/*     */   public void paint(Graphics g, int x, int height)
/*     */   {
/*     */   }
/*     */ 
/*     */   public int getWidth()
/*     */   {
/* 152 */     int size = 0;
/* 153 */     if (isImageVisible())
/* 154 */       size += this.image.getIconWidth();
/* 155 */     if (isTextVisible()) {
/* 156 */       size += (int)new JLabel(this.text).getPreferredSize().getWidth();
/*     */     }
/* 158 */     return size;
/*     */   }
/*     */ 
/*     */   public int getHeight()
/*     */   {
/* 165 */     int size = 0;
/* 166 */     if (isImageVisible())
/* 167 */       size += this.image.getIconHeight();
/* 168 */     if (isTextVisible()) {
/* 169 */       size += (int)new JLabel(this.text).getPreferredSize().getHeight();
/*     */     }
/* 171 */     return size;
/*     */   }
/*     */ 
/*     */   public ActionListener getActionListener() {
/* 175 */     return this.actionlistener;
/*     */   }
/*     */   public void setActionListener(ActionListener alisten) {
/* 178 */     this.actionlistener = alisten;
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.impl.ToolbarButton
 * JD-Core Version:    0.6.2
 */