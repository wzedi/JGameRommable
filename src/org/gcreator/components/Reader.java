/*     */ package org.gcreator.components;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.GradientPaint;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Point;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ import java.util.Vector;
/*     */ import javax.swing.JPanel;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ 
/*     */ public class Reader extends JPanel
/*     */ {
/*  20 */   Vector<String[]> elements = new Vector();
/*     */ 
/*     */   public Reader(String url)
/*     */   {
/*  25 */     initComponents();
/*     */     try {
/*  27 */       System.out.println(url);
/*  28 */       URL _url = new URL(url);
/*  29 */       URLConnection con = _url.openConnection();
/*  30 */       System.out.println("connection was open");
/*  31 */       InputStream stream = con.getInputStream();
/*  32 */       System.out.println("Locating");
/*     */       while (true) {
/*  34 */         if ((stream.read() == 60) && 
/*  35 */           (stream.read() == 111) && 
/*  36 */           (stream.read() == 108) && 
/*  37 */           (stream.read() == 62)) {
/*  38 */           int qq = stream.read();
/*  39 */           if ((qq == 10) || ((qq == 13) && (stream.read() == 10)))
/*  40 */             qq = stream.read();
/*  41 */           if ((qq == 10) || ((qq == 13) && (stream.read() == 10)))
/*     */             break;
/*     */         }
/*     */       }
/*     */       while (true)
/*     */       {
/*  47 */         int fc = stream.read();
/*  48 */         int t = stream.read();
/*  49 */         if (t == 47) {
/*     */           break;
/*     */         }
/*  52 */         while (stream.read() != 97);
/*  54 */         while (stream.read() != 39);
/*  56 */         String link = "";
/*     */         int linkchar;
/*  58 */         while ((linkchar = stream.read()) != 39)
/*  59 */           link = link + (char)linkchar;
/*  60 */         while (stream.read() != 62);
/*  62 */         String x = "";
/*     */         int q;
/*  64 */         while ((q = stream.read()) != 60) {
/*  65 */           x = x + (char)q;
/*     */         }
/*  67 */         while (stream.read() != 10);
/*  69 */         x = x.replaceAll("&amp;", "&");
/*  70 */         x = x.replaceAll("&lt:", "<");
/*  71 */         x = x.replaceAll("&gt;", ">");
/*  72 */         x = x.replaceAll("&#39;", "'");
/*  73 */         x = x.replaceAll("&#33;", "!");
/*  74 */         System.out.println("Adding " + x + " with link " + link);
/*  75 */         this.elements.add(new String[] { x, link });
/*     */       }
/*  77 */       stream.close();
/*     */     }
/*     */     catch (Exception e) {
/*  80 */       System.out.println(e.toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void paint(Graphics g)
/*     */   {
/*  91 */     ((Graphics2D)g).setPaint(new GradientPaint(new Point(-100, -100), Color.PINK, new Point(getWidth() + 100, getHeight() + 100), Color.BLACK));
/*  92 */     g.fillRect(0, 0, getWidth(), getHeight());
/*  93 */     g.setColor(Color.WHITE);
/*  94 */     for (int i = 0; i < this.elements.size(); i++)
/*  95 */       g.drawString(((String[])this.elements.get(i))[0], 0, 15 * i);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 102 */     GroupLayout layout = new GroupLayout(this);
/* 103 */     setLayout(layout);
/* 104 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(0, 334, 32767));
/*     */ 
/* 108 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(0, 283, 32767));
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.Reader
 * JD-Core Version:    0.6.2
 */