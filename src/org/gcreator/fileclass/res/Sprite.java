/*     */ package org.gcreator.fileclass.res;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.Vector;
/*     */ import javax.swing.ImageIcon;
/*     */ import org.gcreator.fileclass.GFile;
/*     */ 
/*     */ public class Sprite extends Resource
/*     */ {
/*     */   static final long serialVersionUID = 1L;
/*     */   public Vector Simages;
/*     */   public int width;
/*     */   public int height;
/*     */   public int originX;
/*     */   public int originY;
/*     */   public int BBleft;
/*     */   public int BBRight;
/*     */   public int BBTop;
/*     */   public int BBBottom;
/*  24 */   public boolean precise = true;
/*     */ 
/*     */   public Sprite(String name)
/*     */   {
/*  28 */     this.name = name;
/*     */ 
/*  30 */     this.Simages = new Vector();
/*     */   }
/*     */ 
/*     */   public ImageIcon getImageAt(int pos) {
/*  34 */     if (pos >= this.Simages.size()) {
/*  35 */       return null;
/*     */     }
/*  37 */     GFile a = (GFile)this.Simages.elementAt(pos);
/*  38 */     if (a == null)
/*  39 */       return null;
/*  40 */     return ((GImage)a.value).image;
/*     */   }
/*     */ 
/*     */   public GFile getAt(int pos) {
/*  44 */     if (pos >= this.Simages.size()) {
/*  45 */       return null;
/*     */     }
/*  47 */     GFile a = (GFile)this.Simages.elementAt(pos);
/*  48 */     return a;
/*     */   }
/*     */ 
/*     */   public int countImages() {
/*  52 */     return this.Simages.size();
/*     */   }
/*     */ 
/*     */   public void addToList(GFile i)
/*     */   {
/*  57 */     this.Simages.add(i);
/*     */   }
/*     */ 
/*     */   public String writeXml()
/*     */   {
/*  62 */     String xml = "";
/*  63 */     xml = xml + "<?xml version=\"1.0\"?>\n";
/*  64 */     xml = xml + "<sprite>\n";
/*  65 */     xml = xml + "<origin>" + this.originX + ", " + this.originY + "</origin>\n";
/*  66 */     xml = xml + "<BB>" + this.BBleft + ", " + this.BBRight + ", " + this.BBTop + ", " + this.BBBottom + "</BB>\n";
/*     */ 
/*  74 */     return xml;
/*     */   }
/*     */ 
/*     */   public void readXml(String xml)
/*     */   {
/*  79 */     String[] lines = xml.split("\n");
/*     */ 
/*  81 */     if (!lines[0].matches("<\\?xml version=\"1\\.0\"\\?>"))
/*  82 */       return;
/*  83 */     if (!lines[1].matches("<sprite>"))
/*  84 */       return;
/*  85 */     if (lines.length < 2)
/*  86 */       return;
/*  87 */     int i = 2;
/*  88 */     while (i < lines.length) {
/*  89 */       String line = lines[i];
/*  90 */       System.out.println(line);
/*  91 */       if ((line != null) && (!line.equals("")))
/*     */       {
/*  93 */         if (line.equals("</sprite>")) {
/*     */           break;
/*     */         }
/*  96 */         if (line.matches("<origin>[0-9]*, [0-9]*</origin>")) {
/*  97 */           String orx = line.replaceAll("<origin>([0-9]*), [0-9]*</origin>", "$1");
/*  98 */           String ory = line.replaceAll("<origin>[0-9]*, ([0-9]*)</origin>", "$1");
/*  99 */           this.originX = Integer.parseInt(orx);
/* 100 */           this.originY = Integer.parseInt(ory);
/*     */         }
/* 102 */         if (line.matches("<BB>[0-9]*, [0-9]*, [0-9]*, [0-9]*</BB>")) {
/* 103 */           String or1 = line.replaceAll("<BB>([0-9]*), [0-9]*, [0-9]*, [0-9]*</BB>", "$1");
/* 104 */           String or2 = line.replaceAll("<BB>[0-9]*, ([0-9]*), [0-9]*, [0-9]*</BB>", "$1");
/* 105 */           String or3 = line.replaceAll("<BB>[0-9]*, [0-9]*, ([0-9]*), [0-9]*</BB>", "$1");
/* 106 */           String or4 = line.replaceAll("<BB>[0-9]*, [0-9]*, [0-9]*, ([0-9]*)</BB>", "$1");
/* 107 */           this.BBleft = Integer.parseInt(or1);
/* 108 */           this.BBRight = Integer.parseInt(or2);
/* 109 */           this.BBTop = Integer.parseInt(or3);
/* 110 */           this.BBBottom = Integer.parseInt(or4);
/*     */         }
/* 112 */         i++;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public String exportToHtml(boolean xhtml) {
/* 118 */     return "";
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */   {
/* 123 */     Sprite a = new Sprite(this.name);
/* 124 */     a.BBBottom = this.BBBottom;
/* 125 */     a.BBRight = this.BBRight;
/* 126 */     a.BBTop = this.BBTop;
/* 127 */     a.BBleft = this.BBleft;
/* 128 */     a.height = this.height;
/* 129 */     a.Simages = ((Vector)this.Simages.clone());
/* 130 */     a.originX = this.originX;
/* 131 */     a.originY = this.originY;
/* 132 */     a.precise = this.precise;
/* 133 */     a.width = this.width;
/* 134 */     return a;
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.res.Sprite
 * JD-Core Version:    0.6.2
 */