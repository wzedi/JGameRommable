/*     */ package net.iharder.dnd;
/*     */ 
/*     */ import java.awt.Image;
/*     */ import java.beans.EventSetDescriptor;
/*     */ import java.beans.MethodDescriptor;
/*     */ import java.beans.PropertyDescriptor;
/*     */ import java.beans.SimpleBeanInfo;
/*     */ 
/*     */ public class FileDropBeanBeanInfo extends SimpleBeanInfo
/*     */ {
/*   9 */   private static PropertyDescriptor[] properties = null;
/*     */ 
/*  16 */   private static EventSetDescriptor[] eventSets = null;
/*     */ 
/*  23 */   private static MethodDescriptor[] methods = null;
/*     */ 
/*  29 */   private static Image iconColor16 = null;
/*  30 */   private static Image iconColor32 = null;
/*  31 */   private static Image iconMono16 = null;
/*  32 */   private static Image iconMono32 = null;
/*  33 */   private static String iconNameC16 = null;
/*  34 */   private static String iconNameC32 = null;
/*  35 */   private static String iconNameM16 = null;
/*  36 */   private static String iconNameM32 = null;
/*     */ 
/*  38 */   private static int defaultPropertyIndex = -1;
/*  39 */   private static int defaultEventIndex = -1;
/*     */ 
/*     */   public PropertyDescriptor[] getPropertyDescriptors()
/*     */   {
/*  55 */     return properties;
/*     */   }
/*     */ 
/*     */   public EventSetDescriptor[] getEventSetDescriptors()
/*     */   {
/*  66 */     return eventSets;
/*     */   }
/*     */ 
/*     */   public MethodDescriptor[] getMethodDescriptors()
/*     */   {
/*  77 */     return methods;
/*     */   }
/*     */ 
/*     */   public int getDefaultPropertyIndex()
/*     */   {
/*  89 */     return defaultPropertyIndex;
/*     */   }
/*     */ 
/*     */   public int getDefaultEventIndex()
/*     */   {
/* 100 */     return defaultPropertyIndex;
/*     */   }
/*     */ 
/*     */   public Image getIcon(int iconKind)
/*     */   {
/* 125 */     switch (iconKind) {
/*     */     case 1:
/* 127 */       if (iconNameC16 == null) {
/* 128 */         return null;
/*     */       }
/* 130 */       if (iconColor16 == null)
/* 131 */         iconColor16 = loadImage(iconNameC16);
/* 132 */       return iconColor16;
/*     */     case 2:
/* 135 */       if (iconNameC32 == null) {
/* 136 */         return null;
/*     */       }
/* 138 */       if (iconColor32 == null)
/* 139 */         iconColor32 = loadImage(iconNameC32);
/* 140 */       return iconColor32;
/*     */     case 3:
/* 143 */       if (iconNameM16 == null) {
/* 144 */         return null;
/*     */       }
/* 146 */       if (iconMono16 == null)
/* 147 */         iconMono16 = loadImage(iconNameM16);
/* 148 */       return iconMono16;
/*     */     case 4:
/* 151 */       if (iconNameM32 == null) {
/* 152 */         return null;
/*     */       }
/* 154 */       if (iconNameM32 == null)
/* 155 */         iconMono32 = loadImage(iconNameM32);
/* 156 */       return iconMono32;
/*     */     }
/*     */ 
/* 159 */     return null;
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     net.iharder.dnd.FileDropBeanBeanInfo
 * JD-Core Version:    0.6.2
 */