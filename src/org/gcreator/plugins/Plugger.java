/*     */ package org.gcreator.plugins;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.net.URLClassLoader;
/*     */ import org.gcreator.core.ClassLoading;
/*     */ 
/*     */ public class Plugger
/*     */ {
/*  22 */   private static ClassLoader loader = null;
/*     */ 
/*     */   public static void registerLoader()
/*     */   {
/*  26 */     if (loader == null) {
/*  27 */       File x = new File("./plugins/");
/*     */       try {
/*  29 */         if (!x.exists()) {
/*  30 */           x.mkdir();
/*     */         }
/*  32 */         URL url = x.toURI().toURL();
/*  33 */         loader = new URLClassLoader(new URL[] { url });
/*  34 */         ClassLoading.classLoader.add(loader);
/*     */       }
/*     */       catch (Exception e) {
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static PluginCore[] getPlugList(String[] classFiles) {
/*  42 */     if (classFiles == null) {
/*  43 */       return null;
/*     */     }
/*  45 */     PluginCore[] plugins = new PluginCore[classFiles.length];
/*  46 */     for (int i = 0; i < plugins.length; i++) {
/*  47 */       if (classFiles[i] != null) {
/*     */         try {
/*  49 */           if (loader != null) {
/*  50 */             Class plugin = ClassLoading.classLoader.loadClass(classFiles[i]);
/*  51 */             Object instance = plugin.newInstance();
/*  52 */             if ((instance instanceof PluginCore))
/*  53 */               plugins[i] = ((PluginCore)instance);
/*     */           }
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */         }
/*     */       }
/*     */     }
/*  61 */     return plugins;
/*     */   }
/*     */ 
/*     */   public static ClassLoader getPluginClassLoader()
/*     */   {
/*  67 */     return loader;
/*     */   }
/*     */ 
/*     */   public static void onLoad() {
/*  71 */     for (Plugin plugin : PluginList.stdlist.plugins)
/*  72 */       if ((plugin != null) && (plugin.value != null))
/*  73 */         plugin.value.onLoad();
/*     */   }
/*     */ 
/*     */   public static void onSplashStart()
/*     */   {
/*  79 */     for (Plugin plugin : PluginList.stdlist.plugins)
/*  80 */       if ((plugin != null) && (plugin.value != null))
/*  81 */         plugin.value.onSplashStart();
/*     */   }
/*     */ 
/*     */   public static void onMainWindowStart()
/*     */   {
/*  87 */     for (Plugin plugin : PluginList.stdlist.plugins)
/*  88 */       if ((plugin != null) && (plugin.value != null))
/*  89 */         plugin.value.onMainWindowStart();
/*     */   }
/*     */ 
/*     */   public static void onSplashDispose()
/*     */   {
/*  95 */     for (Plugin plugin : PluginList.stdlist.plugins)
/*  96 */       if ((plugin != null) && (plugin.value != null))
/*  97 */         plugin.value.onSplashDispose();
/*     */   }
/*     */ 
/*     */   public static void onMainWindowDispose()
/*     */   {
/* 103 */     for (Plugin plugin : PluginList.stdlist.plugins)
/* 104 */       if ((plugin != null) && (plugin.value != null))
/* 105 */         plugin.value.onMainWindowDispose();
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.plugins.Plugger
 * JD-Core Version:    0.6.2
 */