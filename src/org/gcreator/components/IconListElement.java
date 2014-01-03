/*     */ package org.gcreator.components;
/*     */ 
/*     */ import javax.swing.ImageIcon;
/*     */ 
/*     */ class IconListElement
/*     */ {
/* 319 */   public String text = "";
/* 320 */   public ImageIcon img = null;
/* 321 */   public boolean visible = true;
/* 322 */   public Object plus = null;
/*     */ 
/*     */   public IconListElement() {  } 
/* 325 */   public IconListElement(String text, ImageIcon img, Object plus) { this.text = text;
/* 326 */     this.img = img;
/* 327 */     this.plus = plus;
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.IconListElement
 * JD-Core Version:    0.6.2
 */