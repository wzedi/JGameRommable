/*     */ package org.gcreator.fileclass.res;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class Scene extends Resource
/*     */ {
/*     */   static final long serialVersionUID = 1L;
/*  23 */   public String caption = "";
/*  24 */   public String code = "//Do nothing";
/*     */ 
/*  26 */   public int width = 640; public int height = 480; public int speed = 60; public int snapX = 16; public int snapY = 16;
/*     */   public boolean persistant;
/*  27 */   public boolean grid = true;
/*     */   public boolean isometric;
/*  27 */   public boolean drawbackcolor = true;
/*     */   public Vector views;
/*     */   public Vector actors;
/*     */   public Vector tiles;
/*     */   public Vector backgrounds;
/*  32 */   public Color background = Color.lightGray;
/*     */ 
/*     */   public Scene(String name)
/*     */   {
/*  46 */     this.name = name;
/*  47 */     this.actors = new Vector();
/*  48 */     this.tiles = new Vector();
/*  49 */     this.views = new Vector();
/*  50 */     this.backgrounds = new Vector();
/*     */   }
/*     */ 
/*     */   public String writeXml()
/*     */   {
/*  73 */     String xml = "<scene version=\"1.0\">\n";
/*     */ 
/* 145 */     return xml;
/*     */   }
/*     */ 
/*     */   public void readXml(String xml)
/*     */   {
/* 150 */     String[] str = xml.split("\n");
/* 151 */     if ((str[0] == null) || (!str[0].equals("<scene version=\"1.0\">"))) {
/* 152 */       return;
/*     */     }
/* 154 */     for (int i = 1; i < str.length; i++) {
/* 155 */       String line = str[i];
/* 156 */       System.out.println("line: " + line);
/* 157 */       if ((line != null) && (!line.equals("")))
/*     */       {
/* 159 */         if (line.matches("<caption>.*</caption>")) {
/* 160 */           this.caption = line.replaceAll("<caption>(.*)</caption>", "$1").replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&quot;", "\"").replaceAll("&apos;", "'").replaceAll("&LINEBREAK;", "\n").replaceAll("&amp;", "&");
/*     */         }
/* 169 */         else if (line.matches("<code>.*</code>")) {
/* 170 */           this.code = line.replaceAll("<code>(.*)</code>", "$1").replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&quot;", "\"").replaceAll("&apos;", "'").replaceAll("&LINEBREAK;", "\n").replaceAll("&amp;", "&");
/*     */         }
/* 179 */         else if (line.matches("<dimensions>[0-9]+, [0-9]+</dimensions>")) {
/* 180 */           this.width = Integer.parseInt(line.replaceAll("<dimensions>([0-9]+), [0-9]+</dimensions>", "$1"));
/* 181 */           this.height = Integer.parseInt(line.replaceAll("<dimensions>[0-9]+, ([0-9]+)</dimensions>", "$1"));
/*     */         }
/* 184 */         else if (line.matches("<bgcolor>[0-9]+, [0-9]+, [0-9]+</bgcolor>")) {
/* 185 */           this.drawbackcolor = true;
/* 186 */           int r = Integer.parseInt(line.replaceAll("<bgcolor>([0-9]+), [0-9]+, [0-9]+</bgcolor>", "$1"));
/* 187 */           int g = Integer.parseInt(line.replaceAll("<bgcolor>[0-9]+, ([0-9]+), [0-9]+</bgcolor>", "$1"));
/* 188 */           int b = Integer.parseInt(line.replaceAll("<bgcolor>[0-9]+, [0-9]+, ([0-9]+)</bgcolor>", "$1"));
/* 189 */           this.background = new Color(r, g, b);
/*     */         }
/*     */         else {
/* 192 */           if (line.matches("<bgcolor>-</bgcolor>")) {
/* 193 */             this.drawbackcolor = false;
/*     */           }
/* 195 */           if (line.matches("<fps>[0-9]+</fps>")) {
/* 196 */             this.speed = Integer.parseInt(line.replaceAll("<fps>([0-9]+)</fps>", "$1"));
/*     */           }
/* 199 */           else if (line.matches("<snap>[0-9]+, [0-9]+</snap>")) {
/* 200 */             this.snapX = Integer.parseInt(line.replaceAll("<snap>([0-9]+), [0-9]+</snap>", "$1"));
/* 201 */             this.snapY = Integer.parseInt(line.replaceAll("<snap>[0-9]+, ([0-9]+)</snap>", "$1"));
/*     */           }
/* 204 */           else if (line.matches("<grid>(Visible|Hidden) (Standard|Isometric)</grid>")) {
/* 205 */             String x = line.replaceAll("<grid>(Visible|Hidden) (Standard|Isometric)</grid>", "$1");
/* 206 */             String y = line.replaceAll("<grid>(Visible|Hidden) (Standard|Isometric)</grid>", "$2");
/* 207 */             if (x.equals("Visible"))
/* 208 */               this.grid = true;
/*     */             else
/* 210 */               this.grid = false;
/* 211 */             if (y.equals("Standard"))
/* 212 */               this.isometric = false;
/*     */             else
/* 214 */               this.isometric = true;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String exportToHtml(boolean xhtml)
/*     */   {
/* 223 */     return "";
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */   {
/* 228 */     Scene a = new Scene(this.name);
/* 229 */     Object obj = this.actors.clone();
/* 230 */     if (obj == null)
/* 231 */       a.actors = null;
/*     */     else
/* 233 */       a.actors = ((Vector)obj);
/* 234 */     a.caption = this.caption;
/* 235 */     a.code = this.code;
/* 236 */     a.grid = this.grid;
/* 237 */     a.height = this.height;
/* 238 */     a.isometric = this.isometric;
/* 239 */     a.persistant = this.persistant;
/* 240 */     a.snapX = this.snapX;
/* 241 */     a.snapY = this.snapY;
/* 242 */     a.speed = this.speed;
/* 243 */     a.views = this.views;
/* 244 */     a.width = this.width;
/* 245 */     return a;
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.res.Scene
 * JD-Core Version:    0.6.2
 */