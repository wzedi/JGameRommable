/*     */ package org.gcreator.components;
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDesktopPane;
/*     */ import javax.swing.JInternalFrame;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JToolBar;
/*     */ import org.gcreator.managers.LangSupporter;
/*     */ import org.gcreator.units.Dictionary;
/*     */ 
/*     */ public class MdiPane extends JPanel
/*     */ {
/*     */   private JDesktopPane p;
/*     */   private JToolBar t;
/*     */ 
/*     */   public MdiPane()
/*     */   {
/*  26 */     setLayout(new BorderLayout());
/*  27 */     this.p = new JDesktopPane();
/*  28 */     this.p.setVisible(true);
/*  29 */     add(this.p, "Center");
/*  30 */     this.t = new JToolBar();
/*  31 */     Dictionary d = LangSupporter.activeLang;
/*  32 */     JButton minimize = new JButton(d.getEntry(247));
/*  33 */     minimize.setVisible(true);
/*  34 */     minimize.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  36 */         JInternalFrame f = MdiPane.this.p.getSelectedFrame();
/*  37 */         if (f != null)
/*     */           try {
/*  39 */             f.setIcon(true);
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */           }
/*     */       }
/*     */     });
/*  44 */     this.t.add(minimize);
/*  45 */     JButton restore = new JButton(d.getEntry(248));
/*  46 */     restore.setVisible(true);
/*  47 */     restore.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  49 */         JInternalFrame f = MdiPane.this.p.getSelectedFrame();
/*  50 */         if (f != null)
/*     */           try {
/*  52 */             f.setIcon(false);
/*  53 */             f.setMaximum(false);
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */           }
/*     */       }
/*     */     });
/*  58 */     this.t.add(restore);
/*  59 */     JButton maximize = new JButton(d.getEntry(249));
/*  60 */     maximize.setVisible(true);
/*  61 */     maximize.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  63 */         JInternalFrame f = MdiPane.this.p.getSelectedFrame();
/*  64 */         if (f != null)
/*     */           try {
/*  66 */             f.setIcon(false);
/*  67 */             f.setMaximum(true);
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */           }
/*     */       }
/*     */     });
/*  72 */     this.t.add(maximize);
/*  73 */     JButton cascade = new JButton(d.getEntry(250));
/*  74 */     cascade.setVisible(true);
/*  75 */     cascade.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  77 */         JInternalFrame[] fs = MdiPane.this.p.getAllFrames();
/*  78 */         int width = MdiPane.this.p.getWidth();
/*  79 */         int height = MdiPane.this.p.getHeight();
/*  80 */         int w = width / 2;
/*  81 */         int h = height / 2;
/*  82 */         int xg = width / 10;
/*  83 */         int yg = height / 10;
/*  84 */         if (xg < yg)
/*  85 */           yg = xg;
/*     */         else
/*  87 */           xg = yg;
/*  88 */         int cx = 0;
/*  89 */         int cy = 0;
/*  90 */         for (JInternalFrame f : fs) {
/*  91 */           f.setSize(w, h);
/*  92 */           f.setLocation(cx, cy);
/*  93 */           cx += xg;
/*  94 */           cy += yg;
/*  95 */           if ((cx + w > width) || (cy + h > height)) {
/*  96 */             cx = 0;
/*  97 */             cy = 0;
/*     */           }
/*     */         }
/*     */       }
/*     */     });
/* 102 */     this.t.add(cascade);
/* 103 */     this.t.setVisible(true);
/* 104 */     this.t.setFloatable(false);
/* 105 */     add(this.t, "North");
/*     */   }
/*     */ 
/*     */   public JInternalFrame getSelectedFrame() {
/* 109 */     return this.p.getSelectedFrame();
/*     */   }
/*     */ 
/*     */   public void add(JInternalFrame frame, Integer layer) {
/* 113 */     this.p.add(frame, layer);
/*     */   }
/*     */ 
/*     */   public JDesktopPane getDesktop() {
/* 117 */     return this.p;
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.MdiPane
 * JD-Core Version:    0.6.2
 */