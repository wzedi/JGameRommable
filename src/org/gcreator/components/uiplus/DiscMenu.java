/*     */ package org.gcreator.components.uiplus;
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.SystemColor;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.FocusListener;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.awt.event.MouseMotionListener;
/*     */ import java.util.Vector;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JDialog;
/*     */ 
/*     */ public class DiscMenu extends JDialog
/*     */ {
/*  19 */   private int index = 0;
/*  20 */   private int selection = -1;
/*  21 */   public DiscMenuContainer curcontainer = null;
/*  22 */   private static ImageIcon prev = new ImageIcon(DiscMenu.class.getResource("/org/gcreator/resources/uiplus/prev.png"));
/*     */ 
/*  24 */   private static ImageIcon prevnot = new ImageIcon(DiscMenu.class.getResource("/org/gcreator/resources/uiplus/prevnot.png"));
/*     */ 
/*  26 */   private static ImageIcon next = new ImageIcon(DiscMenu.class.getResource("/org/gcreator/resources/uiplus/next.png"));
/*     */ 
/*  28 */   private static ImageIcon nextnot = new ImageIcon(DiscMenu.class.getResource("/org/gcreator/resources/uiplus/nextnot.png"));
/*     */ 
/*  31 */   private static Vector<DiscMenu> menus = new Vector();
/*     */ 
/*     */   public DiscMenu() {
/*     */     try {
/*  35 */       for (DiscMenu menu : menus) {
/*  36 */         menu.dispose();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*  42 */     menus.add(this);
/*  43 */     setLayout(new BorderLayout());
/*     */ 
/*  45 */     addFocusListener(new FocusListener()
/*     */     {
/*     */       public void focusLost(FocusEvent evt) {
/*  48 */         DiscMenu.this.dispose();
/*     */       }
/*     */ 
/*     */       public void focusGained(FocusEvent evt)
/*     */       {
/*     */       }
/*     */     });
/*  55 */     setSize(118, 114);
/*  56 */     setLocation(100, 100);
/*  57 */     setUndecorated(true);
/*  58 */     this.curcontainer = new DiscMenuContainer(null, null);
/*  59 */     addMouseListener(new MouseListener()
/*     */     {
/*     */       public void mouseExited(MouseEvent evt) {
/*  62 */         DiscMenu.this.motion(evt);
/*     */       }
/*     */ 
/*     */       public void mouseEntered(MouseEvent evt) {
/*  66 */         DiscMenu.this.motion(evt);
/*     */       }
/*     */ 
/*     */       public void mouseReleased(MouseEvent evt) {
/*  70 */         DiscMenu.this.press(evt);
/*     */       }
/*     */ 
/*     */       public void mousePressed(MouseEvent evt)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void mouseClicked(MouseEvent evt)
/*     */       {
/*     */       }
/*     */     });
/*  79 */     addMouseMotionListener(new MouseMotionListener()
/*     */     {
/*     */       public void mouseMoved(MouseEvent evt) {
/*  82 */         DiscMenu.this.motion(evt);
/*     */       }
/*     */ 
/*     */       public void mouseDragged(MouseEvent evt) {
/*  86 */         DiscMenu.this.motion(evt);
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   private void motion(MouseEvent evt) {
/*  92 */     int os = this.selection;
/*  93 */     int x = evt.getX();
/*  94 */     int y = evt.getY();
/*     */ 
/*  96 */     if ((x > -1) && (x < 34) && (y > 41) && (y < 76))
/*  97 */       this.selection = (this.index * 6);
/*  98 */     else if ((x > 5) && (x < 40) && (y > 5) && (y < 40))
/*  99 */       this.selection = (this.index * 6 + 1);
/* 100 */     else if ((x > 41) && (x < 76) && (y > -1) && (y < 34))
/* 101 */       this.selection = (this.index * 6 + 2);
/* 102 */     else if ((x > 77) && (x < 112) && (y > 5) && (y < 39))
/* 103 */       this.selection = (this.index * 6 + 3);
/* 104 */     else if ((x > 83) && (x < 118) && (y > 41) && (y < 76))
/* 105 */       this.selection = (this.index * 6 + 4);
/* 106 */     else if ((x > 41) && (x < 76) && (y > 79) && (y < 114))
/* 107 */       this.selection = (this.index * 6 + 5);
/*     */     else {
/* 109 */       this.selection = -1;
/*     */     }
/*     */ 
/* 112 */     if (os != this.selection)
/* 113 */       repaint();
/*     */   }
/*     */ 
/*     */   private void call(DiscMenuItem item)
/*     */   {
/* 118 */     call(item, false);
/*     */   }
/*     */ 
/*     */   private void call(DiscMenuItem item, boolean back) {
/* 122 */     ActionEvent evt = new ActionEvent(this, -1, "call");
/* 123 */     item.actionPerformed(evt, back);
/* 124 */     if (!(item instanceof DiscMenuContainer))
/* 125 */       dispose();
/*     */   }
/*     */ 
/*     */   private void press(MouseEvent evt) {
/* 129 */     int x = evt.getX();
/* 130 */     int y = evt.getY();
/*     */ 
/* 132 */     if ((x > 44) && (y > 42) && (x < 79) && (y < 77) && (this.curcontainer.prevcontainer != null)) {
/* 133 */       call(this.curcontainer.prevcontainer, true);
/*     */     }
/* 135 */     if ((x > -1) && (x < 34) && (y > 41) && (y < 76) && (this.index * 6 < this.curcontainer.count()))
/* 136 */       call(this.curcontainer.elementAt(this.index * 6));
/* 137 */     else if ((x > 5) && (x < 40) && (y > 5) && (y < 40) && (this.index * 6 + 1 < this.curcontainer.count()))
/* 138 */       call(this.curcontainer.elementAt(this.index * 6 + 1));
/* 139 */     else if ((x > 41) && (x < 76) && (y > -1) && (y < 34) && (this.index * 6 + 2 < this.curcontainer.count()))
/* 140 */       call(this.curcontainer.elementAt(this.index * 6 + 2));
/* 141 */     else if ((x > 77) && (x < 112) && (y > 5) && (y < 39) && (this.index * 6 + 3 < this.curcontainer.count()))
/* 142 */       call(this.curcontainer.elementAt(this.index * 6 + 3));
/* 143 */     else if ((x > 83) && (x < 118) && (y > 41) && (y < 76) && (this.index * 6 + 4 < this.curcontainer.count()))
/* 144 */       call(this.curcontainer.elementAt(this.index * 6 + 4));
/* 145 */     else if ((x > 41) && (x < 76) && (y > 79) && (y < 114) && (this.index * 6 + 5 < this.curcontainer.count())) {
/* 146 */       call(this.curcontainer.elementAt(this.index * 6 + 5));
/*     */     }
/*     */ 
/* 149 */     if ((y < 88) || (y > 105))
/* 150 */       return;
/* 151 */     if ((this.index != 0) && (x > 19) && (x < 38)) {
/* 152 */       this.index -= 1;
/* 153 */       repaint();
/* 154 */       return;
/*     */     }
/* 156 */     int size = 0;
/* 157 */     if (this.curcontainer != null) {
/* 158 */       size = this.curcontainer.count();
/*     */     }
/* 160 */     if (size % 6 == 0) {
/* 161 */       size /= 6;
/*     */     } else {
/* 163 */       size /= 6;
/* 164 */       size++;
/*     */     }
/*     */ 
/* 167 */     if ((this.index < size - 1) && (x > 79) && (x < 98)) {
/* 168 */       this.index += 1;
/* 169 */       repaint();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void paint(Graphics g)
/*     */   {
/* 175 */     super.paint(g);
/*     */ 
/* 177 */     Color t1 = Color.WHITE;
/* 178 */     Color t2 = Color.BLUE;
/*     */     try
/*     */     {
/* 181 */       t1 = SystemColor.menu;
/* 182 */       t2 = SystemColor.activeCaption;
/*     */     }
/*     */     catch (Exception e) {
/*     */     }
/* 186 */     if ((this.selection == this.index * 6) && (this.index * 6 < this.curcontainer.count()) && (this.curcontainer.elementAt(this.index * 6).isEnabled()))
/* 187 */       g.setColor(t2);
/*     */     else {
/* 189 */       g.setColor(t1);
/*     */     }
/* 191 */     g.fillRect(0, 42, 33, 33);
/*     */ 
/* 193 */     if ((this.selection == this.index * 6 + 1) && (this.index * 6 + 1 < this.curcontainer.count()) && (this.curcontainer.elementAt(this.index * 6 + 1).isEnabled()))
/* 194 */       g.setColor(t2);
/*     */     else {
/* 196 */       g.setColor(t1);
/*     */     }
/* 198 */     g.fillRect(6, 6, 33, 33);
/*     */ 
/* 200 */     if ((this.selection == this.index * 6 + 2) && (this.index * 6 + 2 < this.curcontainer.count()) && (this.curcontainer.elementAt(this.index * 6 + 2).isEnabled()))
/* 201 */       g.setColor(t2);
/*     */     else {
/* 203 */       g.setColor(t1);
/*     */     }
/* 205 */     g.fillRect(42, 0, 33, 33);
/*     */ 
/* 207 */     if ((this.selection == this.index * 6 + 3) && (this.index * 6 + 3 < this.curcontainer.count()) && (this.curcontainer.elementAt(this.index * 6 + 3).isEnabled()))
/* 208 */       g.setColor(t2);
/*     */     else {
/* 210 */       g.setColor(t1);
/*     */     }
/* 212 */     g.fillRect(78, 6, 33, 33);
/*     */ 
/* 214 */     if ((this.selection == this.index * 6 + 4) && (this.index * 6 + 4 < this.curcontainer.count()) && (this.curcontainer.elementAt(this.index * 6 + 4).isEnabled()))
/* 215 */       g.setColor(t2);
/*     */     else {
/* 217 */       g.setColor(t1);
/*     */     }
/* 219 */     g.fillRect(84, 42, 33, 33);
/*     */ 
/* 221 */     if ((this.selection == this.index * 6 + 5) && (this.index * 6 + 5 < this.curcontainer.count()) && (this.curcontainer.elementAt(this.index * 6 + 5).isEnabled()))
/* 222 */       g.setColor(t2);
/*     */     else {
/* 224 */       g.setColor(t1);
/*     */     }
/* 226 */     g.fillRect(42, 80, 33, 33);
/*     */ 
/* 228 */     g.setColor(Color.BLACK);
/* 229 */     g.drawRect(42, 0, 33, 33);
/* 230 */     g.drawRect(6, 6, 33, 33);
/* 231 */     g.drawRect(78, 6, 33, 33);
/* 232 */     g.drawRect(0, 42, 33, 33);
/* 233 */     g.drawRect(84, 42, 33, 33);
/* 234 */     g.drawRect(42, 80, 33, 33);
/*     */ 
/* 236 */     int size = 0;
/* 237 */     if (this.curcontainer != null) {
/* 238 */       size = this.curcontainer.count();
/*     */     }
/* 240 */     if (size % 6 == 0) {
/* 241 */       size /= 6;
/*     */     } else {
/* 243 */       size /= 6;
/* 244 */       size++;
/*     */     }
/* 246 */     if (this.index == 0)
/* 247 */       g.drawImage(prevnot.getImage(), 20, 88, prevnot.getImageObserver());
/*     */     else {
/* 249 */       g.drawImage(prev.getImage(), 20, 88, prev.getImageObserver());
/*     */     }
/*     */ 
/* 252 */     if (this.index > size - 2)
/* 253 */       g.drawImage(nextnot.getImage(), 80, 88, nextnot.getImageObserver());
/*     */     else {
/* 255 */       g.drawImage(next.getImage(), 80, 88, next.getImageObserver());
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 260 */       ImageIcon i = this.curcontainer.elementAt(this.index * 6).image;
/* 261 */       g.drawImage(i.getImage(), 1, 43, i.getImageObserver());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */     try {
/* 267 */       ImageIcon i = this.curcontainer.elementAt(this.index * 6 + 1).image;
/* 268 */       g.drawImage(i.getImage(), 7, 7, i.getImageObserver());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */     try {
/* 274 */       ImageIcon i = this.curcontainer.elementAt(this.index * 6 + 2).image;
/* 275 */       g.drawImage(i.getImage(), 43, 1, i.getImageObserver());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */     try {
/* 281 */       ImageIcon i = this.curcontainer.elementAt(this.index * 6 + 3).image;
/* 282 */       g.drawImage(i.getImage(), 79, 7, i.getImageObserver());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */     try {
/* 288 */       ImageIcon i = this.curcontainer.elementAt(this.index * 6 + 4).image;
/* 289 */       g.drawImage(i.getImage(), 85, 43, i.getImageObserver());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */     try {
/* 295 */       ImageIcon i = this.curcontainer.elementAt(this.index * 6 + 5).image;
/* 296 */       g.drawImage(i.getImage(), 43, 81, i.getImageObserver());
/*     */     }
/*     */     catch (Exception e) {
/*     */     }
/* 300 */     if ((this.curcontainer.prevcontainer != null) && (this.curcontainer.image != null)) {
/* 301 */       ImageIcon i = this.curcontainer.image;
/* 302 */       g.drawImage(i.getImage(), 45, 43, i.getImageObserver());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void dispose()
/*     */   {
/* 310 */     menus.remove(this);
/* 311 */     super.dispose();
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.uiplus.DiscMenu
 * JD-Core Version:    0.6.2
 */