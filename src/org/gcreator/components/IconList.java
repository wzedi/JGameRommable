/*     */ package org.gcreator.components;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Vector;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JComponent;
/*     */ 
/*     */ public class IconList extends JComponent
/*     */ {
/*  18 */   private int columns = 3;
/*  19 */   private Vector<IconListElement> elements = new Vector();
/*  20 */   private int columnWidth = 120;
/*  21 */   private int columnHeight = 120;
/*  22 */   private int selIndex = 0;
/*  23 */   private int wgap = 10;
/*  24 */   private int hgap = 10;
/*  25 */   private Color selectionColor = Color.BLUE;
/*     */ 
/*     */   public IconList()
/*     */   {
/*  29 */     addMouseListener(new MouseListener() {
/*     */       public void mouseEntered(MouseEvent evt) {
/*     */       }
/*     */       public void mouseExited(MouseEvent evt) {  } 
/*     */       public void mousePressed(MouseEvent evt) {  } 
/*  34 */       public void mouseReleased(MouseEvent evt) { IconList.this.mouseAction(evt); }
/*     */ 
/*     */       public void mouseClicked(MouseEvent evt) {
/*  37 */         IconList.this.mouseAction(evt);
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public void mouseAction(MouseEvent evt) {
/*  43 */     int x = evt.getX();
/*  44 */     int y = evt.getY();
/*  45 */     int b = evt.getButton();
/*  46 */     if (b != 1)
/*  47 */       return;
/*  48 */     x -= this.wgap;
/*  49 */     y -= this.hgap;
/*  50 */     if (x % (this.columnWidth + this.wgap) > this.columnWidth)
/*  51 */       return;
/*  52 */     if (y % (this.columnHeight + this.hgap) > this.columnHeight)
/*  53 */       return;
/*  54 */     x /= (this.columnWidth + this.wgap);
/*  55 */     y /= (this.columnHeight + this.hgap);
/*  56 */     int t = y * this.columns + x;
/*  57 */     if (t < countVisibleElements()) {
/*  58 */       this.selIndex = t;
/*  59 */       repaint();
/*     */     }
/*     */   }
/*     */ 
/*     */   public int countVisibleElements()
/*     */   {
/*  65 */     int cf = 0;
/*  66 */     Enumeration e = this.elements.elements();
/*  67 */     while (e.hasMoreElements()) {
/*  68 */       IconListElement element = (IconListElement)e.nextElement();
/*  69 */       if (element.visible)
/*  70 */         cf++;
/*     */     }
/*  72 */     return cf;
/*     */   }
/*     */ 
/*     */   public Color getSelectionColor() {
/*  76 */     return this.selectionColor;
/*     */   }
/*     */ 
/*     */   public void setSelectionColor(Color selectionColor) {
/*  80 */     this.selectionColor = selectionColor;
/*  81 */     updateUI();
/*     */   }
/*     */ 
/*     */   public int getWidthGap() {
/*  85 */     return this.wgap;
/*     */   }
/*     */ 
/*     */   public int getHeightGap() {
/*  89 */     return this.hgap;
/*     */   }
/*     */ 
/*     */   public void setWidthGap(int wgap) {
/*  93 */     this.wgap = wgap;
/*  94 */     updateUI();
/*     */   }
/*     */ 
/*     */   public void setHeightGap(int hgap) {
/*  98 */     this.hgap = hgap;
/*  99 */     updateUI();
/*     */   }
/*     */ 
/*     */   public int getSelectedIndex() {
/* 103 */     return this.selIndex;
/*     */   }
/*     */ 
/*     */   public void setSelectedIndex(int index) {
/* 107 */     this.selIndex = index;
/* 108 */     updateUI();
/*     */   }
/*     */ 
/*     */   public String getSelectedText() {
/* 112 */     return getTextAt(getSelectedIndex(), true);
/*     */   }
/*     */ 
/*     */   public Object getSelectedExtraContent() {
/* 116 */     return getExtraContentAt(getSelectedIndex(), true);
/*     */   }
/*     */ 
/*     */   public int getColumnWidth() {
/* 120 */     return this.columnWidth;
/*     */   }
/*     */ 
/*     */   public int getColumnHeight() {
/* 124 */     return this.columnHeight;
/*     */   }
/*     */ 
/*     */   public void setColumnWidth(int dim) {
/* 128 */     this.columnWidth = dim;
/* 129 */     updateUI();
/*     */   }
/*     */ 
/*     */   public void setColumnHeight(int dim) {
/* 133 */     this.columnHeight = dim;
/* 134 */     updateUI();
/*     */   }
/*     */ 
/*     */   public void addElement(String text, ImageIcon img, Object plus) {
/* 138 */     this.elements.add(new IconListElement(text, img, plus));
/*     */   }
/*     */ 
/*     */   public void removeElement(int i) {
/* 142 */     this.elements.removeElementAt(i);
/* 143 */     this.elements.trimToSize();
/* 144 */     updateUI();
/*     */   }
/*     */ 
/*     */   public int getColumns() {
/* 148 */     return this.columns;
/*     */   }
/*     */ 
/*     */   public void setColumns(int columns) {
/* 152 */     this.columns = columns;
/* 153 */     updateUI();
/*     */   }
/*     */ 
/*     */   public Object getExtraContentAt(int i) {
/* 157 */     return getExtraContentAt(i, false);
/*     */   }
/*     */ 
/*     */   public Object getExtraContentAt(int i, boolean visibleonly) {
/* 161 */     if ((i < 0) || (i >= this.elements.size()))
/* 162 */       return null;
/* 163 */     int x = i;
/* 164 */     if (visibleonly) {
/* 165 */       x = 0;
/* 166 */       Enumeration e = this.elements.elements();
/* 167 */       while (e.hasMoreElements()) {
/* 168 */         if (x == i)
/* 169 */           return ((IconListElement)e.nextElement()).plus;
/* 170 */         if (((IconListElement)e.nextElement()).visible == true)
/* 171 */           x++;
/*     */       }
/* 173 */       return null;
/*     */     }
/* 175 */     return ((IconListElement)this.elements.get(x)).plus;
/*     */   }
/*     */ 
/*     */   public String getTextAt(int i) {
/* 179 */     return getTextAt(i, false);
/*     */   }
/*     */ 
/*     */   public String getTextAt(int i, boolean visibleonly) {
/* 183 */     if ((i < 0) || (i >= this.elements.size()))
/* 184 */       return null;
/* 185 */     int x = i;
/* 186 */     if (visibleonly) {
/* 187 */       x = 0;
/* 188 */       Enumeration e = this.elements.elements();
/* 189 */       while (e.hasMoreElements()) {
/* 190 */         if (x == i)
/* 191 */           return ((IconListElement)e.nextElement()).text;
/* 192 */         if (((IconListElement)e.nextElement()).visible == true)
/* 193 */           x++;
/*     */       }
/* 195 */       return null;
/*     */     }
/* 197 */     return ((IconListElement)this.elements.get(x)).text;
/*     */   }
/*     */ 
/*     */   public ImageIcon getImageAt(int i) {
/* 201 */     if ((i < 0) || (i >= this.elements.size()))
/* 202 */       return null;
/* 203 */     return ((IconListElement)this.elements.get(i)).img;
/*     */   }
/*     */ 
/*     */   public boolean isElementVisible(int i) {
/* 207 */     if ((i < 0) || (i >= this.elements.size()))
/* 208 */       return false;
/* 209 */     return ((IconListElement)this.elements.get(i)).visible;
/*     */   }
/*     */ 
/*     */   public boolean elementExists(int i) {
/* 213 */     if ((i < 0) || (i >= this.elements.size()))
/* 214 */       return false;
/* 215 */     return true;
/*     */   }
/*     */ 
/*     */   public void setElementVisible(int i, boolean visible) {
/* 219 */     if ((i < 0) || (i >= this.elements.size()))
/* 220 */       return;
/* 221 */     ((IconListElement)this.elements.get(i)).visible = visible;
/* 222 */     updateUI();
/*     */   }
/*     */ 
/*     */   public void setElementText(int i, String text) {
/* 226 */     if ((i < 0) || (i >= this.elements.size()))
/* 227 */       return;
/* 228 */     ((IconListElement)this.elements.get(i)).text = text;
/* 229 */     updateUI();
/*     */   }
/*     */ 
/*     */   public void setElementImage(int i, ImageIcon img) {
/* 233 */     if ((i < 0) || (i >= this.elements.size()))
/* 234 */       return;
/* 235 */     ((IconListElement)this.elements.get(i)).img = img;
/* 236 */     updateUI();
/*     */   }
/*     */ 
/*     */   public void setElementExtraContent(int i, Object plus) {
/* 240 */     if ((i < 0) || (i >= this.elements.size()))
/* 241 */       return;
/* 242 */     ((IconListElement)this.elements.get(i)).plus = plus;
/* 243 */     updateUI();
/*     */   }
/*     */ 
/*     */   public int calcRows() {
/* 247 */     int cf = 0;
/* 248 */     Enumeration e = this.elements.elements();
/* 249 */     while (e.hasMoreElements()) {
/* 250 */       IconListElement element = (IconListElement)e.nextElement();
/* 251 */       if (element.visible)
/* 252 */         cf++;
/*     */     }
/* 254 */     if (cf % this.columns != 0) {
/* 255 */       return cf / this.columns + 1;
/*     */     }
/* 257 */     return cf / this.columns;
/*     */   }
/*     */ 
/*     */   public Dimension getPreferredSize() {
/* 261 */     int rows = calcRows();
/* 262 */     return new Dimension(this.columnWidth * this.columns + (this.columns + 1) * this.wgap, this.columnHeight * rows + (rows + 1) * this.hgap);
/*     */   }
/*     */ 
/*     */   private void paintComponent(Graphics g, IconListElement element, int r, int c, int i) {
/* 266 */     int wstart = c * this.columnWidth + (c + 1) * this.wgap;
/* 267 */     int hstart = r * this.columnHeight + (r + 1) * this.hgap;
/* 268 */     if (i == this.selIndex) {
/* 269 */       g.setColor(Color.BLUE);
/* 270 */       g.drawRect(wstart + 1, hstart + 1, this.columnWidth - 2, this.columnHeight - 2);
/*     */     }
/*     */     else {
/* 273 */       g.setColor(Color.GRAY);
/* 274 */     }g.drawRect(wstart, hstart, this.columnWidth, this.columnHeight);
/* 275 */     int imgw = this.columnWidth - 4;
/* 276 */     int imgh = this.columnHeight - 22;
/* 277 */     ImageIcon img = element.img;
/* 278 */     if (img == null)
/* 279 */       return;
/* 280 */     int iconh = img.getIconHeight();
/* 281 */     int iconw = img.getIconWidth();
/* 282 */     if ((iconw >= imgw) && (iconh >= imgh)) {
/* 283 */       g.drawImage(img.getImage(), wstart + 2, hstart + 2, imgw, imgh, img.getImageObserver());
/*     */     }
/* 285 */     if ((iconw >= imgw) && (iconh < imgh)) {
/* 286 */       g.drawImage(img.getImage(), wstart + 2, hstart + 2 + (imgh - iconh) / 2, imgw, iconh, img.getImageObserver());
/*     */     }
/* 288 */     if ((img.getIconWidth() < imgw) && (img.getIconHeight() >= imgh)) {
/* 289 */       g.drawImage(img.getImage(), wstart + 2 + (imgw - iconw) / 2, hstart + 2, iconw, imgh, img.getImageObserver());
/*     */     }
/* 291 */     if ((img.getIconWidth() < imgw) && (img.getIconHeight() < imgh)) {
/* 292 */       g.drawImage(img.getImage(), wstart + 2 + (imgw - iconw) / 2, hstart + 2 + (imgh - iconh) / 2, iconw, img.getIconHeight(), img.getImageObserver());
/*     */     }
/* 294 */     g.drawString(element.text, wstart + 3, hstart + imgh + 16);
/*     */   }
/*     */ 
/*     */   public void paint(Graphics g) {
/* 298 */     super.paint(g);
/* 299 */     int r = 0;
/* 300 */     int c = 0;
/* 301 */     int i = 0;
/* 302 */     Enumeration e = this.elements.elements();
/* 303 */     while (e.hasMoreElements()) {
/* 304 */       IconListElement element = (IconListElement)e.nextElement();
/* 305 */       if (element.visible) {
/* 306 */         paintComponent(g, element, r, c, i);
/* 307 */         c++;
/* 308 */         if (c >= this.columns) {
/* 309 */           c -= this.columns;
/* 310 */           r++;
/*     */         }
/*     */       }
/* 313 */       i++;
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.IconList
 * JD-Core Version:    0.6.2
 */