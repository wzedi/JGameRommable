/*     */ package org.gcreator.units;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.gcreator.fileclass.GFile;
/*     */ 
/*     */ public class ViewInScene
/*     */   implements Serializable
/*     */ {
/*     */   static final long serialVersionUID = 1L;
/*  20 */   public boolean visibleonstart = false;
/*  21 */   public int viewx = 0;
/*  22 */   public int viewy = 0;
/*  23 */   public int vieww = 640;
/*  24 */   public int viewh = 480;
/*  25 */   public int portx = 0;
/*  26 */   public int porty = 0;
/*  27 */   public int portw = 640;
/*  28 */   public int porth = 480;
/*  29 */   public GFile follow = null;
/*  30 */   public int hbor = 32;
/*  31 */   public int vbor = 32;
/*  32 */   public int hsp = -1;
/*  33 */   public int vsp = -1;
/*     */   public String name;
/*     */ 
/*     */   public ViewInScene(String name)
/*     */   {
/*  37 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String writeXml() {
/*  41 */     String xml = "<view>\n";
/*     */ 
/*  43 */     xml = xml + "<visible>" + (this.visibleonstart ? "True" : "False") + "</visible>\n";
/*     */ 
/*  45 */     xml = xml + "<scenepos>";
/*  46 */     xml = xml + this.viewx;
/*  47 */     xml = xml + ", ";
/*  48 */     xml = xml + this.viewy;
/*  49 */     xml = xml + ", ";
/*  50 */     xml = xml + this.vieww;
/*  51 */     xml = xml + ", ";
/*  52 */     xml = xml + this.viewh;
/*  53 */     xml = xml + "</scenepos>\n";
/*     */ 
/*  55 */     xml = xml + "<portpos>";
/*  56 */     xml = xml + this.portx;
/*  57 */     xml = xml + ", ";
/*  58 */     xml = xml + this.porty;
/*  59 */     xml = xml + ", ";
/*  60 */     xml = xml + this.portw;
/*  61 */     xml = xml + ", ";
/*  62 */     xml = xml + this.porth;
/*  63 */     xml = xml + "</portpos>\n";
/*     */ 
/*  65 */     xml = xml + "</view>\n";
/*     */ 
/*  67 */     return xml;
/*     */   }
/*     */ 
/*     */   public int readXml(int init, String[] xml)
/*     */   {
/*  73 */     for (int i = init + 1; i < xml.length; i++) {
/*  74 */       String line = xml[i];
/*  75 */       if (line.equals("</view>"))
/*  76 */         return i;
/*  77 */       if (line.matches("<visible>(True|False)</visible>")) {
/*  78 */         this.visibleonstart = line.replaceAll("<visible>(True|False)</visible>", "$1").equals("True");
/*     */       }
/*  81 */       else if (line.matches("<scenepos>[0-9]+, [0-9]+, [0-9]+, [0-9]+</scenepos>")) {
/*  82 */         this.viewx = Integer.parseInt(line.replaceAll("<scenepos>([0-9]+), [0-9]+, [0-9]+, [0-9]+</scenepos>", "$1"));
/*  83 */         this.viewy = Integer.parseInt(line.replaceAll("<scenepos>[0-9]+, ([0-9]+), [0-9]+, [0-9]+</scenepos>", "$1"));
/*  84 */         this.vieww = Integer.parseInt(line.replaceAll("<scenepos>[0-9]+, [0-9]+, ([0-9]+), [0-9]+</scenepos>", "$1"));
/*  85 */         this.viewh = Integer.parseInt(line.replaceAll("<scenepos>[0-9]+, [0-9]+, [0-9]+, ([0-9]+)</scenepos>", "$1"));
/*     */       }
/*  88 */       else if (line.matches("<portpos>[0-9]+, [0-9]+, [0-9]+, [0-9]+</portpos>")) {
/*  89 */         this.portx = Integer.parseInt(line.replaceAll("<portpos>([0-9]+), [0-9]+, [0-9]+, [0-9]+</portpos>", "$1"));
/*  90 */         this.porty = Integer.parseInt(line.replaceAll("<portpos>[0-9]+, ([0-9]+), [0-9]+, [0-9]+</portpos>", "$1"));
/*  91 */         this.portw = Integer.parseInt(line.replaceAll("<portpos>[0-9]+, [0-9]+, ([0-9]+), [0-9]+</portpos>", "$1"));
/*  92 */         this.porth = Integer.parseInt(line.replaceAll("<portpos>[0-9]+, [0-9]+, [0-9]+, ([0-9]+)</portpos>", "$1"));
/*     */       }
/*     */     }
/*     */ 
/*  96 */     return init;
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 100 */     return (this.visibleonstart ? "<HTML><b>" : "") + this.name;
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.units.ViewInScene
 * JD-Core Version:    0.6.2
 */