/*     */ package org.gcreator.core;
/*     */ 
/*     */ import javax.crypto.Cipher;
/*     */ import javax.swing.JTextPane;
/*     */ import org.gcreator.managers.LangSupporter;
/*     */ import org.gcreator.units.Dictionary;
/*     */ 
/*     */ public class utilities
/*     */ {
/*     */   static Cipher ecipher;
/*     */   static Cipher dcipher;
/*     */ 
/*     */   public static void addMessage(int message)
/*     */   {
/*  23 */     addFormatedMessage(message, null, false);
/*     */   }
/*     */ 
/*     */   public static void addStringMessage(String message) {
/*  27 */     addStringFormatedMessage(message, null, false);
/*     */   }
/*     */ 
/*     */   public static void addError(int message) {
/*  31 */     addFormatedMessage(message, "red", true);
/*     */   }
/*     */ 
/*     */   public static void addFormatedMessage(int message, String color, boolean bold) {
/*  35 */     addStringFormatedMessage(LangSupporter.activeLang.getEntry(message), color, bold);
/*     */   }
/*     */ 
/*     */   public static void addStringFormatedMessage(String message, String color, boolean bold) {
/*  39 */     String out = "";
/*  40 */     if (color != null) {
/*  41 */       out = out + "<font color='" + color + "'>";
/*     */     }
/*  43 */     if (bold) {
/*  44 */       out = out + "<b>";
/*     */     }
/*  46 */     out = out + message;
/*  47 */     if (bold) {
/*  48 */       out = out + "</b>";
/*     */     }
/*  50 */     if (color != null) {
/*  51 */       out = out + "</font>";
/*     */     }
/*  53 */     out = out + "<br/>";
/*     */ 
/*  55 */     gcreator.output += out;
/*  56 */     if ((gcreator.window != null) && (gcreator.window.console != null))
/*  57 */       gcreator.window.console.setText(gcreator.output);
/*     */   }
/*     */ 
/*     */   public static String encrypt(String str)
/*     */   {
/*  84 */     String output = "";
/*  85 */     int seed = (int)Math.floor(Math.random() * 100.0D);
/*  86 */     output = output + (char)seed;
/*     */ 
/*  88 */     for (int i = 0; i < str.length(); i++) {
/*  89 */       char t = str.charAt(i);
/*  90 */       int s = t;
/*  91 */       s += seed;
/*  92 */       s %= 65535;
/*  93 */       t = (char)s;
/*  94 */       output = output + t;
/*     */     }
/*  96 */     return output;
/*     */   }
/*     */ 
/*     */   public static String decrypt(String str) {
/* 100 */     String output = "";
/* 101 */     int seed = str.charAt(0);
/*     */ 
/* 103 */     for (int i = 1; i < str.length(); i++) {
/* 104 */       char t = str.charAt(i);
/* 105 */       int s = t;
/* 106 */       s += 65535 - seed;
/* 107 */       s %= 65535;
/* 108 */       t = (char)s;
/* 109 */       output = output + t;
/*     */     }
/* 111 */     return output;
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/*     */     try
/*     */     {
/*  64 */       ecipher = Cipher.getInstance("DES");
/*  65 */       dcipher = Cipher.getInstance("DES");
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.core.utilities
 * JD-Core Version:    0.6.2
 */