/*     */ package org.gcreator.components.custom;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.Point;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JPopupMenu;
/*     */ import org.gcreator.components.uiplus.DiscMenu;
/*     */ import org.gcreator.components.uiplus.DiscMenuContainer;
/*     */ import org.gcreator.components.uiplus.DiscMenuItem;
/*     */ import org.gcreator.managers.LangSupporter;
/*     */ import org.gcreator.units.Dictionary;
/*     */ 
/*     */ public class MenuGenerator
/*     */ {
/*  19 */   private JPopupMenu std = null;
/*  20 */   private DiscMenu disc = null;
/*     */   public static final int TYPE_STD = 1;
/*     */   public static final int TYPE_DISC = 2;
/*  25 */   public static int type = 1;
/*     */   private int ltype;
/*     */   private Object parent;
/*     */ 
/*     */   public MenuGenerator()
/*     */   {
/*  31 */     this.ltype = type;
/*     */ 
/*  33 */     initMenu();
/*     */   }
/*     */ 
/*     */   public static void addActionListener(Object o, ActionListener a) {
/*  37 */     if ((o instanceof JMenuItem))
/*  38 */       ((JMenuItem)o).addActionListener(a);
/*  39 */     if ((o instanceof DiscMenuItem))
/*  40 */       ((DiscMenuItem)o).addActionListener(a);
/*     */   }
/*     */ 
/*     */   private void initMenu() {
/*  44 */     if (this.ltype == 1) {
/*  45 */       this.parent = (this.std = new JPopupMenu());
/*     */     }
/*     */     else {
/*  48 */       this.disc = new DiscMenu();
/*  49 */       this.parent = (this.disc.curcontainer = new DiscMenuContainer(null, null));
/*     */     }
/*     */   }
/*     */ 
/*     */   public Object addMenuItem(Object parent, int entry, ImageIcon img) {
/*  54 */     return addMenuItem(parent, entry, img, true);
/*     */   }
/*     */ 
/*     */   public Object addMenuItem(int entry, ImageIcon img) {
/*  58 */     return addMenuItem(entry, img, true);
/*     */   }
/*     */ 
/*     */   public Object addMenuItem(Object parent, int entry, ImageIcon img, boolean enabled) {
/*  62 */     String lang = LangSupporter.activeLang.getEntry(entry);
/*     */ 
/*  64 */     if (this.ltype == 1) {
/*  65 */       JMenuItem i = new JMenuItem(lang, img);
/*  66 */       i.setVisible(true);
/*  67 */       i.setEnabled(enabled);
/*  68 */       ((JMenu)parent).add(i);
/*  69 */       return i;
/*     */     }
/*     */ 
/*  72 */     DiscMenuItem i = new DiscMenuItem(lang, img);
/*  73 */     i.setEnabled(enabled);
/*  74 */     ((DiscMenuContainer)parent).add(i);
/*  75 */     return i;
/*     */   }
/*     */ 
/*     */   public Object addMenuItem(int entry, ImageIcon img, boolean enabled)
/*     */   {
/*  80 */     String lang = LangSupporter.activeLang.getEntry(entry);
/*     */ 
/*  82 */     if (this.ltype == 1) {
/*  83 */       JMenuItem i = new JMenuItem(lang, img);
/*  84 */       i.setVisible(true);
/*  85 */       i.setEnabled(enabled);
/*  86 */       ((JPopupMenu)this.parent).add(i);
/*  87 */       return i;
/*     */     }
/*     */ 
/*  90 */     DiscMenuItem i = new DiscMenuItem(lang, img);
/*  91 */     i.setEnabled(enabled);
/*  92 */     ((DiscMenuContainer)this.parent).add(i);
/*  93 */     return i;
/*     */   }
/*     */ 
/*     */   public Object addSubMenu(Object parent, int entry, ImageIcon img)
/*     */   {
/*  98 */     String lang = LangSupporter.activeLang.getEntry(entry);
/*     */ 
/* 100 */     if (this.ltype == 1) {
/* 101 */       JMenu i = new JMenu(lang);
/* 102 */       i.setVisible(true);
/* 103 */       i.setIcon(img);
/* 104 */       ((JMenu)parent).add(i);
/* 105 */       return i;
/*     */     }
/*     */ 
/* 108 */     DiscMenuItem i = new DiscMenuItem(lang, img);
/* 109 */     ((DiscMenuContainer)parent).add(i);
/* 110 */     return i;
/*     */   }
/*     */ 
/*     */   public Object addSubMenu(int entry, ImageIcon img)
/*     */   {
/* 115 */     String lang = LangSupporter.activeLang.getEntry(entry);
/*     */ 
/* 117 */     if (this.ltype == 1) {
/* 118 */       JMenu i = new JMenu(lang);
/* 119 */       i.setVisible(true);
/* 120 */       i.setIcon(img);
/* 121 */       ((JMenu)this.parent).add(i);
/* 122 */       return i;
/*     */     }
/*     */ 
/* 125 */     DiscMenuContainer i = new DiscMenuContainer(lang, img);
/* 126 */     ((DiscMenuContainer)this.parent).add(i);
/* 127 */     return i;
/*     */   }
/*     */ 
/*     */   public void show(Component invoker, int x, int y)
/*     */   {
/* 132 */     Point p = invoker.getLocationOnScreen();
/* 133 */     if (this.ltype == 1) {
/* 134 */       this.std.show(invoker, x, y);
/*     */     } else {
/* 136 */       this.disc.setLocation(x + p.x, y + p.y);
/* 137 */       this.disc.setVisible(true);
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.custom.MenuGenerator
 * JD-Core Version:    0.6.2
 */