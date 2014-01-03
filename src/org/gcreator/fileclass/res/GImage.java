/*    */ package org.gcreator.fileclass.res;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.io.PrintStream;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ public class GImage extends Resource
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/*    */   public ImageIcon image;
/*    */   public int width;
/*    */   public int height;
/*    */   public boolean transparent;
/*    */   public Color transparentColor;
/*    */ 
/*    */   public GImage(String name)
/*    */   {
/* 29 */     this.name = name;
/* 30 */     this.image = new ImageIcon();
/*    */   }
/*    */ 
/*    */   public ImageIcon getImage() {
/* 34 */     return this.image;
/*    */   }
/*    */ 
/*    */   public String writeXml() {
/* 38 */     String xml = "";
/* 39 */     xml = xml + "<?xml version=\"1.0\"?>\n";
/* 40 */     xml = xml + "<gimage>\n";
/* 41 */     xml = xml + "<transparent>" + this.transparent + "</transparent>\n";
/* 42 */     xml = xml + "<color>" + this.transparentColor.getRed() + ", " + this.transparentColor.getGreen() + ", " + this.transparentColor.getBlue() + "</color>\n";
/* 43 */     xml = xml + "</gimage>\n";
/* 44 */     return xml;
/*    */   }
/*    */ 
/*    */   public void readXml(String xml)
/*    */   {
/* 49 */     String[] lines = xml.split("\n");
/*    */ 
/* 51 */     if (!lines[0].matches("<\\?xml version=\"1\\.0\"\\?>"))
/* 52 */       return;
/* 53 */     if (!lines[1].matches("<gimage>"))
/* 54 */       return;
/* 55 */     if (lines.length < 3)
/* 56 */       return;
/* 57 */     int i = 3;
/* 58 */     while (i < lines.length) {
/* 59 */       String line = lines[i];
/* 60 */       System.out.println(line);
/* 61 */       if ((line != null) && (!line.equals("")))
/*    */       {
/* 63 */         if (line.equals("</gimage>"))
/*    */         {
/*    */           break;
/*    */         }
/* 67 */         if (line.matches("<transparent>(true|false)</transparent>")) {
/* 68 */           String trans = line.replaceAll("<transparent>(true|false)</transparent>", "$1");
/* 69 */           this.transparent = Boolean.parseBoolean(trans);
/*    */         }
/* 71 */         else if (line.matches("<color>[0-9]*, [0-9]*, [0-9]</color>")) {
/* 72 */           String sred = line.replaceAll("<color>([0-9]*), [0-9]*, [0-9]*</color>", "$1");
/* 73 */           String sgreen = line.replaceAll("<color>[0-9]*, ([0-9]*), [0-9]*</color>", "$1");
/* 74 */           String sblue = line.replaceAll("<color>[0-9]*, [0-9]*, ([0-9]*)</color>", "$1");
/* 75 */           int red = Integer.parseInt(sred);
/* 76 */           int green = Integer.parseInt(sgreen);
/* 77 */           int blue = Integer.parseInt(sblue);
/* 78 */           this.transparentColor = new Color(red, green, blue);
/*    */         }
/* 80 */         i++;
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public String exportToHtml(boolean xhtml) {
/* 86 */     return "";
/*    */   }
/*    */ 
/*    */   public Object clone() {
/* 90 */     GImage a = new GImage(this.name);
/* 91 */     a.height = this.height;
/* 92 */     a.width = this.width;
/* 93 */     a.transparent = this.transparent;
/* 94 */     a.transparentColor = this.transparentColor;
/* 95 */     return a;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.res.GImage
 * JD-Core Version:    0.6.2
 */