/*     */ package org.gcreator.plugins;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.Vector;

/*     */ import javax.swing.ImageIcon;

/*     */ import org.gcreator.core.ClassLoading;
/*     */ 
/*     */ public class PluginList
/*     */ {
/*     */   public static final String PLUGLIST = "./settings/pluglist";
/*  26 */   public static final PluginList stdlist = new PluginList("./settings/pluglist");
/*     */ 
/*  29 */   public Vector<Plugin> plugins = new Vector<Plugin>();
/*     */ 
/*     */   private PluginList() {  } 
/*  31 */   public PluginList(String location) { File pluglist = new File(location);
/*     */     FileInputStream reader;
/*     */     try { reader = new FileInputStream(pluglist);
/*     */     } catch (IOException e)
/*     */     {
/*  37 */       return;
/*     */     }
/*  39 */     Vector<String> lines = new Vector<String>();
/*  40 */     String curstring = "";
/*     */     try {
/*     */       while (true) {
/*  43 */         int read = reader.read();
/*  44 */         if (read == -1)
/*     */           break;
/*  46 */         if (read != 13)
/*     */         {
/*  48 */           if (read == 10) {
/*  49 */             lines.add(curstring);
/*  50 */             curstring = "";
/*     */           }
/*     */           else {
/*  53 */             curstring = curstring + (char)read;
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (IOException e) {  }
/*     */ 
/*  58 */     curstring = null;
/*  59 */     boolean starter = false;
/*     */ 
/*  61 */     Plugin curplugin = null;
/*     */ 
/*  64 */     for (String line : lines) {
/*  65 */       line = line.replace("#(.*)^", "");
/*     */ 
/*  67 */       if (!line.equals(""))
/*     */       {
/*  70 */         if ((!starter) && (!line.equals("[G-Creator Plugin List]")))
/*     */           break;
/*  72 */         if (!starter) {
/*  73 */           starter = true;
/*     */         }
/*     */         else
/*     */         {
/*  77 */           if ((curplugin == null) && (!line.equals("[~Plugin~]")))
/*     */             break;
/*  79 */           if (curplugin == null) {
/*  80 */             curplugin = new Plugin();
/*     */           }
/*  84 */           else if (line.equals("[~Plugin~]")) {
/*  85 */             this.plugins.add(curplugin);
/*  86 */             curplugin = new Plugin();
/*     */           }
/*  90 */           else if (line.matches("^Author=.*$")) {
/*  91 */             curplugin.authors.add(line.replaceAll("^Author=(.*)$", "$1"));
/*     */           }
/*  95 */           else if (line.matches("^File=.*$")) {
/*  96 */             curplugin.files.add(line.replaceAll("^File=(.*)$", "$1"));
/*     */           }
/* 100 */           else if (line.matches("^License=.*$")) {
/* 101 */             curplugin.licenseLocation = line.replaceAll("^License=(.*)$", "$1");
/*     */           }
/* 105 */           else if (line.matches("^Name=.*$")) {
/* 106 */             curplugin.name = line.replaceAll("^Name=(.*)$", "$1");
/*     */           }
/* 110 */           else if (line.matches("^Version=.*$")) {
/* 111 */             curplugin.version = line.replaceAll("^Version=(.*)$", "$1");
/*     */           }
/* 115 */           else if (line.matches("^Image=.*$")) {
/* 116 */             String fname = "./plugins/" + line.replaceAll("^Image=(.*)$", "$1");
/* 117 */             curplugin.img_loc = fname;
/* 118 */             if ((new File(fname).exists()) && (!line.equals("Image=")))
/* 119 */               curplugin.image = new ImageIcon(fname);
/*     */             else {
/* 121 */               curplugin.image = new ImageIcon(getClass().getResource("/org/gcreator/resources/plugin.png"));
/*     */             }
/*     */ 
/*     */           }
/* 125 */           else if (line.matches("^Core=.*$")) {
/* 126 */             String t = line.replaceAll("^Core=(.*)$", "$1");
/*     */             try {
/* 128 */               curplugin.value = ((PluginCore)ClassLoading.classLoader.loadClass(t).newInstance());
/*     */             }
/*     */             catch (Exception e) {
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 136 */     if (curplugin != null)
/* 137 */       this.plugins.add(curplugin);
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.plugins.PluginList
 * JD-Core Version:    0.6.2
 */