/*     */ package org.gcreator.components.resource;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Iterator;
/*     */ import java.util.Vector;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JPopupMenu;
/*     */ import org.gcreator.components.WorkspaceTree;
/*     */ import org.gcreator.components.impl.WorkspaceCellRenderer;
/*     */ import org.gcreator.core.Aurwindow;
/*     */ import org.gcreator.fileclass.Folder;
/*     */ import org.gcreator.fileclass.GFile;
/*     */ import org.gcreator.fileclass.GObject;
/*     */ import org.gcreator.fileclass.Project;
/*     */ 
/*     */ class FileLabel extends JComponent
/*     */   implements MouseListener
/*     */ {
/*  21 */   private GFile file = null;
/*     */   private Project p;
/*     */   private String key;
/*  24 */   private Vector<ActionListener> a = new Vector();
/*     */ 
/*     */   public FileLabel(Project p, String key) {
/*  27 */     this.p = p;
/*  28 */     this.key = key;
/*  29 */     addMouseListener(this);
/*     */   }
/*     */ 
/*     */   public void folderToPopup(Project p, Folder f, JPopupMenu pop) {
/*  33 */     Vector v = f.getChildren();
/*  34 */     for (Iterator i$ = v.iterator(); i$.hasNext(); ) { Object o = i$.next();
/*  35 */       GObject g = (GObject)o;
/*  36 */       System.out.println("Object " + g.name);
/*  37 */       if (p.validOfType(g, this.key)) {
/*  38 */         System.out.println("Valid");
/*  39 */         if ((g instanceof GFile)) {
/*  40 */           FileMenuItem i = new FileMenuItem(this);
/*  41 */           i.setVisible(true);
/*  42 */           i.file = ((GFile)g);
/*  43 */           pop.add(i);
/*     */         }
/*     */ 
/*  46 */         if ((g instanceof Folder)) {
/*  47 */           FolderMenuItem i = new FolderMenuItem();
/*  48 */           i.setVisible(true);
/*  49 */           i.file = ((Folder)g);
/*  50 */           folderToPopup(p, (Folder)g, i);
/*  51 */           pop.add(i);
/*     */         }
/*     */       } }
/*     */   }
/*     */ 
/*     */   public void folderToPopup(Project p, Folder f, JMenuItem pop)
/*     */   {
/*  58 */     Vector v = f.getChildren();
/*  59 */     for (Iterator i$ = v.iterator(); i$.hasNext(); ) { Object o = i$.next();
/*  60 */       GObject g = (GObject)o;
/*  61 */       System.out.println("Object " + g.name);
/*  62 */       if (p.validOfType(g, this.key)) {
/*  63 */         System.out.println("Valid");
/*  64 */         if ((g instanceof GFile)) {
/*  65 */           FileMenuItem i = new FileMenuItem(this);
/*  66 */           i.setVisible(true);
/*  67 */           i.file = ((GFile)g);
/*  68 */           pop.add(i);
/*     */         }
/*     */ 
/*  71 */         if ((g instanceof Folder)) {
/*  72 */           FolderMenuItem i = new FolderMenuItem();
/*  73 */           i.setVisible(true);
/*  74 */           i.file = ((Folder)g);
/*  75 */           pop.add(i);
/*  76 */           folderToPopup(p, (Folder)g, i);
/*     */         }
/*     */       } } 
/*     */   }
/*     */ 
/*     */   public void mouseExited(MouseEvent evt) {  }
/*     */ 
/*     */ 
/*     */   public void mouseEntered(MouseEvent evt) {  }
/*     */ 
/*     */ 
/*  85 */   public void mousePressed(MouseEvent evt) { Folder f = this.p.getFolderFor(this.key);
/*  86 */     if (f == null)
/*  87 */       return;
/*  88 */     JPopupMenu pop = new JPopupMenu();
/*  89 */     FileMenuItem i = new FileMenuItem(this);
/*  90 */     i.setVisible(true);
/*  91 */     i.file = null;
/*  92 */     pop.add(i);
/*  93 */     folderToPopup(this.p, f, pop);
/*  94 */     pop.show(this, evt.getX(), evt.getY()); } 
/*     */   public void mouseReleased(MouseEvent evt) {
/*     */   }
/*     */   public void mouseClicked(MouseEvent evt) {
/*     */   }
/*     */   public void setFile(GFile file) {
/* 100 */     setFile(file, false);
/*     */   }
/*     */ 
/*     */   public void setFile(GFile file, boolean trigger) {
/* 104 */     this.file = file;
/* 105 */     repaint();
/* 106 */     if (trigger)
/* 107 */       for (ActionListener al : this.a)
/* 108 */         al.actionPerformed(null);
/*     */   }
/*     */ 
/*     */   public GFile getFile()
/*     */   {
/* 113 */     return this.file;
/*     */   }
/*     */ 
/*     */   public void addActionListener(ActionListener a) {
/* 117 */     this.a.add(a);
/*     */   }
/*     */ 
/*     */   public void paint(Graphics g) {
/* 121 */     super.paint(g);
/*     */ 
/* 123 */     Font f = getFont();
/* 124 */     FontMetrics fm = getFontMetrics(f);
/* 125 */     Color c = getForeground();
/*     */ 
/* 127 */     g.setColor(c);
/* 128 */     g.setFont(f);
/*     */ 
/* 130 */     if (this.file == null) {
/* 131 */       g.drawString("<none>", 1, fm.getHeight() + 1);
/* 132 */       return;
/*     */     }
/*     */ 
/* 135 */     int x = 1;
/*     */     try
/*     */     {
/* 138 */       WorkspaceCellRenderer r = (WorkspaceCellRenderer)Aurwindow.workspace.getCellRenderer();
/* 139 */       ImageIcon i = r.getImageFor(this.file.node);
/* 140 */       g.drawImage(i.getImage(), x, 1, i.getImageObserver());
/* 141 */       x += i.getIconWidth() + 1;
/*     */     }
/*     */     catch (Exception e) {
/*     */     }
/* 145 */     g.drawString(this.file.name, x, fm.getHeight() + 1);
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.resource.FileLabel
 * JD-Core Version:    0.6.2
 */