/*     */ package org.gcreator.components;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.awt.event.MouseMotionListener;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Iterator;
/*     */ import java.util.Vector;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import org.gcreator.components.popupmenus.PopupListener;
/*     */ import org.gcreator.components.popupmenus.ScenePopupMenu;
/*     */ import org.gcreator.core.Colorfeel;
/*     */ import org.gcreator.editors.SceneEditor;
/*     */ import org.gcreator.fileclass.GFile;
/*     */ import org.gcreator.fileclass.res.Actor;
/*     */ import org.gcreator.fileclass.res.Scene;
/*     */ import org.gcreator.fileclass.res.Sprite;
/*     */ import org.gcreator.fileclass.res.Tileset;
/*     */ import org.gcreator.units.ActorInScene;
/*     */ import org.gcreator.units.BackgroundInScene;
/*     */ import org.gcreator.units.Tile;
/*     */ 
/*     */ public class ScenePanel extends JPanel
/*     */   implements MouseListener, MouseMotionListener
/*     */ {
/*     */   SceneEditor root;
/*     */   ScenePopupMenu popup;
/*     */ 
/*     */   public ScenePanel(SceneEditor root)
/*     */   {
/*  32 */     this.root = root;
/*  33 */     addMouseListener(this);
/*  34 */     this.popup = new ScenePopupMenu(root);
/*  35 */     addMouseListener(new PopupListener(this, this.popup));
/*  36 */     addMouseMotionListener(this);
/*     */   }
/*     */   public void mouseExited(MouseEvent evt) {
/*     */   }
/*     */   public void mouseEntered(MouseEvent evt) {
/*     */   }
/*     */   public void mouseReleased(MouseEvent evt) {  } 
/*     */   public void mousePressed(MouseEvent evt) {  } 
/*  44 */   public void mouseClicked(MouseEvent evt) { if (evt.getButton() == 1) {
/*  45 */       int a = this.root.mode();
/*  46 */       if (a == 0)
/*  47 */         return;
/*  48 */       int x = (int)(evt.getX() * this.root.getZoom());
/*  49 */       int y = (int)(evt.getY() * this.root.getZoom());
/*  50 */       if (a == 2)
/*  51 */         eraseActorsAt(x, y);
/*  52 */       if (a == 1)
/*  53 */         addActorAt(x, y);
/*  54 */       if (a == 3)
/*  55 */         addTileAt(x, y);
/*  56 */       this.root.updateScroll();
/*     */     } }
/*     */ 
/*     */   public void eraseActorsAt(int x, int y)
/*     */   {
/*  61 */     this.root.eraseActorsAt(x, y);
/*     */   }
/*     */ 
/*     */   public void eraseActorsAt(Rectangle r) {
/*  65 */     this.root.eraseActorsAt(r);
/*     */   }
/*     */ 
/*     */   public void addActorAt(int x, int y) {
/*  69 */     ActorInScene act = this.root.makeNewActor(x, y);
/*  70 */     if (this.root.eraseActorsBelow()) {
/*  71 */       Sprite s = (Sprite)act.Sactor.value;
/*  72 */       this.root.eraseActorsAt(new Rectangle(x, y, s.getImageAt(0).getIconWidth(), s.getImageAt(0).getIconHeight()));
/*     */     }
/*  74 */     if (this.root.snapToGrid()) {
/*  75 */       Scene s = (Scene)this.root.file.value;
/*  76 */       if (x % s.snapX > s.snapX / 2) {
/*  77 */         x /= s.snapX;
/*  78 */         x++;
/*  79 */         x *= s.snapX;
/*     */       }
/*     */       else {
/*  82 */         x /= s.snapX;
/*  83 */         x *= s.snapX;
/*     */       }
/*  85 */       if (y % s.snapY > s.snapY / 2) {
/*  86 */         y /= s.snapY;
/*  87 */         y++;
/*  88 */         y *= s.snapY;
/*     */       }
/*     */       else {
/*  91 */         y /= s.snapY;
/*  92 */         y *= s.snapY;
/*     */       }
/*     */     }
/*  95 */     ((Scene)this.root.file.value).actors.add(act);
/*     */   }
/*     */ 
/*     */   public void addTileAt(int x, int y) {
/*  99 */     Tile tile = this.root.makeNewTile(x, y);
/* 100 */     ((Scene)this.root.file.value).tiles.add(tile);
/*     */   }
/*     */ 
/*     */   public int getWidth() {
/* 104 */     double zoom = this.root.getZoom();
/* 105 */     return (int)(this.root.getMapWidth() / zoom + ((this.root.isGridVisible()) && (!this.root.isIsometric()) ? 1 : 0));
/*     */   }
/*     */ 
/*     */   public int getHeight()
/*     */   {
/* 110 */     double zoom = this.root.getZoom();
/* 111 */     return (int)(this.root.getMapHeight() / zoom + ((this.root.isGridVisible()) && (!this.root.isIsometric()) ? 1 : 0));
/*     */   }
/*     */ 
/*     */   public Dimension getSize()
/*     */   {
/* 116 */     return new Dimension(getWidth(), getHeight());
/*     */   }
/*     */ 
/*     */   public Dimension getPreferredSize()
/*     */   {
/* 121 */     return getSize();
/*     */   }
/*     */ 
/*     */   public Dimension getMinimumSize()
/*     */   {
/* 126 */     return getSize();
/*     */   }
/*     */ 
/*     */   public Dimension getMaximumSize()
/*     */   {
/* 131 */     return getSize();
/*     */   }
/*     */ 
/*     */   public int getMinimumDepth() {
/* 135 */     int result = 2147483647;
/* 136 */     Scene scn = (Scene)this.root.file.value;
/* 137 */     Enumeration e = scn.actors.elements();
/* 138 */     while (e.hasMoreElements()) {
/* 139 */       ActorInScene a = (ActorInScene)e.nextElement();
/* 140 */       Actor b = (Actor)a.Sactor.value;
/* 141 */       if (b.depth < result)
/* 142 */         result = b.depth;
/*     */     }
/* 144 */     e = scn.tiles.elements();
/* 145 */     while (e.hasMoreElements()) {
/* 146 */       Tile a = (Tile)e.nextElement();
/* 147 */       if (a.depth < result)
/* 148 */         result = a.depth;
/*     */     }
/* 150 */     return result;
/*     */   }
/*     */ 
/*     */   public int getMaximumDepth() {
/* 154 */     int result = -2147483648;
/* 155 */     Scene scn = (Scene)this.root.file.value;
/* 156 */     Enumeration e = scn.actors.elements();
/* 157 */     while (e.hasMoreElements()) {
/* 158 */       ActorInScene a = (ActorInScene)e.nextElement();
/* 159 */       Actor b = (Actor)a.Sactor.value;
/* 160 */       if (b.depth > result)
/* 161 */         result = b.depth;
/*     */     }
/* 163 */     e = scn.tiles.elements();
/* 164 */     while (e.hasMoreElements()) {
/* 165 */       Tile a = (Tile)e.nextElement();
/* 166 */       if (a.depth > result)
/* 167 */         result = a.depth;
/*     */     }
/* 169 */     return result;
/*     */   }
/*     */ 
/*     */   public int getNextDepth(int Depth) {
/* 173 */     int result = -2147483648;
/* 174 */     Scene scn = (Scene)this.root.file.value;
/* 175 */     Enumeration e = scn.actors.elements();
/* 176 */     while (e.hasMoreElements()) {
/* 177 */       ActorInScene a = (ActorInScene)e.nextElement();
/* 178 */       Actor b = (Actor)a.Sactor.value;
/* 179 */       if ((b.depth > result) && (b.depth < Depth))
/* 180 */         b.depth = result;
/*     */     }
/* 182 */     e = scn.tiles.elements();
/* 183 */     while (e.hasMoreElements()) {
/* 184 */       Tile a = (Tile)e.nextElement();
/* 185 */       if ((a.depth > result) && (a.depth < Depth))
/* 186 */         a.depth = result;
/*     */     }
/* 188 */     return result;
/*     */   }
/*     */ 
/*     */   public void update(Graphics g) {
/* 192 */     super.update(g);
/* 193 */     super.setSize(getWidth(), getHeight());
/*     */   }
/*     */ 
/*     */   public void paintComponent(Graphics g)
/*     */   {
/* 198 */     super.paintComponent(g);
/* 199 */     drawField(g);
/* 200 */     drawActors(g);
/* 201 */     if (this.root.isGridVisible())
/* 202 */       drawGrid(g);
/*     */   }
/*     */ 
/*     */   public void drawActors(Graphics g) {
/* 206 */     Scene scn = (Scene)this.root.file.value;
/* 207 */     if ((scn.actors.isEmpty()) && (scn.tiles.isEmpty())) {
/* 208 */       return;
/*     */     }
/* 210 */     int dep = getMaximumDepth();
/* 211 */     int mindep = getMinimumDepth();
/* 212 */     while (dep >= mindep) {
/* 213 */       Enumeration e = scn.actors.elements();
/* 214 */       while (e.hasMoreElements()) {
/* 215 */         ActorInScene ascn = (ActorInScene)e.nextElement();
/* 216 */         Actor b = (Actor)ascn.Sactor.value;
/* 217 */         if (b.depth == dep) {
/*     */           try {
/* 219 */             Sprite f = (Sprite)b.sprite.value;
/* 220 */             ImageIcon h = f.getImageAt(0);
/* 221 */             if (h != null) {
/* 222 */               g.drawImage(h.getImage(), (int)((ascn.x - f.originX) / this.root.getZoom()), (int)((ascn.y - f.originY) / this.root.getZoom()), (int)(h.getIconWidth() / this.root.getZoom()), (int)(h.getIconHeight() / this.root.getZoom()), h.getImageObserver());
/*     */             }
/*     */ 
/*     */           }
/*     */           catch (NullPointerException ex)
/*     */           {
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 234 */       e = scn.tiles.elements();
/* 235 */       while (e.hasMoreElements()) {
/* 236 */         Tile ascn = (Tile)e.nextElement();
/* 237 */         if (ascn.depth == dep) {
/*     */           try {
/* 239 */             ImageIcon h = ascn.getTilesetImage();
/* 240 */             if (h != null) {
/* 241 */               g.drawImage(h.getImage(), (int)(ascn.dx / this.root.getZoom()), (int)(ascn.dy / this.root.getZoom()), (int)(ascn.width / this.root.getZoom()), (int)(ascn.height / this.root.getZoom()), ascn.sx + ((Tileset)ascn.tileset.value).startx, ascn.sy + ((Tileset)ascn.tileset.value).starty, ascn.width, ascn.height, h.getImageObserver());
/*     */             }
/*     */ 
/*     */           }
/*     */           catch (NullPointerException ex)
/*     */           {
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 257 */       if (dep <= mindep)
/*     */         break;
/* 259 */       dep = getNextDepth(dep);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void drawField(Graphics g)
/*     */   {
/* 276 */     g.setColor(this.root.getMapBGColor());
/* 277 */     g.fillRect(0, 0, getWidth(), getHeight());
/*     */     Iterator i$;
/*     */     try
/*     */     {
/* 279 */       Scene scn = (Scene)this.root.file.value;
/* 280 */       for (i$ = scn.backgrounds.iterator(); i$.hasNext(); ) { Object o = i$.next();
/* 281 */         drawBackground(g, (BackgroundInScene)o); }
/*     */     }
/*     */     catch (NullPointerException e) {
/*     */     }
/*     */   }
/*     */ 
/*     */   public void drawBackground(Graphics g, BackgroundInScene bg) {
/* 288 */     ImageIcon i = (ImageIcon)bg.image.value;
/* 289 */     if (i == null)
/* 290 */       return;
/* 291 */     int hrep = bg.hmode;
/* 292 */     int vrep = bg.vmode;
/* 293 */     if ((hrep == 0) && (vrep == 0)) {
/* 294 */       g.drawImage(i.getImage(), 0, 0, (int)(i.getIconWidth() / this.root.getZoom()), (int)(i.getIconHeight() / this.root.getZoom()), i.getImageObserver());
/*     */     }
/* 296 */     else if ((hrep == 2) && (vrep == 0)) {
/* 297 */       g.drawImage(i.getImage(), 0, 0, (int)(((Scene)this.root.file.value).width / this.root.getZoom()), (int)(i.getIconHeight() / this.root.getZoom()), i.getImageObserver());
/*     */     }
/* 299 */     else if ((hrep == 2) && (vrep == 2)) {
/* 300 */       g.drawImage(i.getImage(), 0, 0, (int)(((Scene)this.root.file.value).width / this.root.getZoom()), (int)(((Scene)this.root.file.value).height / this.root.getZoom()), i.getImageObserver());
/*     */     }
/* 302 */     else if ((hrep == 0) && (vrep == 2)) {
/* 303 */       g.drawImage(i.getImage(), 0, 0, (int)(i.getIconWidth() / this.root.getZoom()), (int)(((Scene)this.root.file.value).height / this.root.getZoom()), i.getImageObserver());
/*     */     }
/* 305 */     else if ((hrep == 1) && (vrep == 0)) {
/* 306 */       for (int j = 0; j * i.getIconWidth() < ((Scene)this.root.file.value).width; j++)
/* 307 */         g.drawImage(i.getImage(), (int)(j * i.getIconWidth() / this.root.getZoom()), 0, (int)(i.getIconWidth() / this.root.getZoom()), (int)(i.getIconHeight() / this.root.getZoom()), i.getImageObserver());
/*     */     }
/* 309 */     else if ((hrep == 1) && (vrep == 2)) {
/* 310 */       for (int j = 0; j * i.getIconWidth() < ((Scene)this.root.file.value).width; j++)
/* 311 */         g.drawImage(i.getImage(), (int)(j * i.getIconWidth() / this.root.getZoom()), 0, (int)(i.getIconWidth() / this.root.getZoom()), (int)(((Scene)this.root.file.value).height / this.root.getZoom()), i.getImageObserver());
/*     */     }
/* 313 */     else if ((hrep == 0) && (vrep == 1)) {
/* 314 */       for (int j = 0; j * i.getIconHeight() < ((Scene)this.root.file.value).height; j++)
/* 315 */         g.drawImage(i.getImage(), 0, (int)(j * i.getIconHeight() / this.root.getZoom()), (int)(i.getIconWidth() / this.root.getZoom()), (int)(i.getIconHeight() / this.root.getZoom()), i.getImageObserver());
/*     */     }
/* 317 */     else if ((hrep == 2) && (vrep == 1)) {
/* 318 */       for (int j = 0; j * i.getIconHeight() < ((Scene)this.root.file.value).height; j++)
/* 319 */         g.drawImage(i.getImage(), 0, (int)(j * i.getIconHeight() / this.root.getZoom()), (int)(((Scene)this.root.file.value).width / this.root.getZoom()), (int)(i.getIconHeight() / this.root.getZoom()), i.getImageObserver());
/*     */     }
/* 321 */     else if ((hrep == 1) && (vrep == 1))
/* 322 */       for (int j = 0; j * i.getIconWidth() < ((Scene)this.root.file.value).width; j++)
/* 323 */         for (int k = 0; k * i.getIconHeight() < ((Scene)this.root.file.value).height; k++)
/* 324 */           g.drawImage(i.getImage(), (int)(j * i.getIconWidth() / this.root.getZoom()), (int)(k * i.getIconHeight() / this.root.getZoom()), (int)(i.getIconWidth() / this.root.getZoom()), (int)(i.getIconHeight() / this.root.getZoom()), i.getImageObserver());
/*     */   }
/*     */ 
/*     */   public void drawGrid(Graphics g)
/*     */   {
/* 329 */     Color c = this.root.getMapBGColor();
/* 330 */     int k = c.getRed() + c.getBlue() + c.getGreen();
/* 331 */     k /= 3;
/* 332 */     if (k > 150)
/* 333 */       g.setColor(Colorfeel.GridDarkColor);
/*     */     else
/* 335 */       g.setColor(Colorfeel.GridLightColor);
/* 336 */     int truew = this.root.getMapWidth();
/* 337 */     int trueh = this.root.getMapHeight();
/* 338 */     int snapx = this.root.getSnapX();
/* 339 */     int snapy = this.root.getSnapY();
/* 340 */     double zoom = this.root.getZoom();
/* 341 */     if (zoom == 0.0D)
/* 342 */       zoom = 0.5D;
/* 343 */     if (!this.root.isIsometric()) {
/* 344 */       for (int i = 0; i <= truew / snapx; i++) {
/* 345 */         g.drawLine((int)(i * snapx / zoom), 0, (int)(i * snapx / zoom), getHeight());
/*     */       }
/* 347 */       for (int i = 0; i <= trueh / snapy; i++) {
/* 348 */         g.drawLine(0, (int)(i * snapy / zoom), getWidth(), (int)(i * snapy / zoom));
/*     */       }
/*     */ 
/*     */     }
/* 352 */     else if (truew / snapx >= trueh / snapy) {
/* 353 */       for (int i = 0 - truew / snapx; i <= truew / snapx; i++) {
/* 354 */         g.drawLine((int)(i * snapx / zoom), 0, (int)(i * snapx / zoom) + getHeight(), getHeight());
/*     */       }
/* 356 */       for (int i = 0 - truew / snapx; i <= truew / snapx; i++)
/* 357 */         g.drawLine(getWidth(), (int)(i * snapy / zoom), 0, (int)(i * snapy / zoom) + getWidth());
/*     */     }
/*     */     else
/*     */     {
/* 361 */       for (int i = 0 - trueh / snapy - snapy / 2; i <= trueh / snapy + snapy / 2; i++) {
/* 362 */         g.drawLine((int)(i * snapx / zoom), 0, (int)(i * snapx / zoom) + getHeight(), getHeight());
/*     */       }
/* 364 */       for (int i = 0 - trueh / snapy - snapy / 2; i <= trueh / snapy + snapy / 2; i++)
/* 365 */         g.drawLine(getWidth(), (int)(i * snapy / zoom), 0, (int)(i * snapy / zoom) + getWidth());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void mouseDragged(MouseEvent e)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void mouseMoved(MouseEvent evt)
/*     */   {
/* 376 */     double zoom = this.root.getZoom();
/* 377 */     this.root.BottomLeft.setText("X:" + (int)(evt.getX() * zoom) + " Y:" + (int)(evt.getY() * zoom));
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.ScenePanel
 * JD-Core Version:    0.6.2
 */