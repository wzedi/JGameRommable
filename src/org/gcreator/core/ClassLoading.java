/*    */ package org.gcreator.core;
/*    */ 
/*    */ import java.util.Enumeration;
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class ClassLoading
/*    */ {
/* 15 */   public static ClassLoading classLoader = new ClassLoading();
/*    */   private Vector<ClassLoader> loaders;
/*    */ 
/*    */   private ClassLoading()
/*    */   {
/* 18 */     this.loaders = new Vector();
/* 19 */     add(getClass().getClassLoader());
/*    */   }
/*    */   public void add(ClassLoader loader) {
/* 22 */     if (loader != null)
/* 23 */       this.loaders.add(loader); 
/*    */   }
/*    */ 
/* 26 */   public void remove(ClassLoader loader) { this.loaders.remove(loader); }
/*    */ 
/*    */   public boolean contains(ClassLoader loader) {
/* 29 */     return this.loaders.contains(loader);
/*    */   }
/*    */   public Enumeration<ClassLoader> elements() {
/* 32 */     return this.loaders.elements();
/*    */   }
/*    */   public Class loadClass(String x) {
/* 35 */     Class cls = null;
/* 36 */     for (ClassLoader loader : this.loaders) {
/*    */       try {
/* 38 */         cls = loader.loadClass(x);
/*    */       }
/*    */       catch (ClassNotFoundException e)
/*    */       {
/* 42 */         cls = null;
/*    */       }
/*    */     }
/* 45 */     return cls;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.core.ClassLoading
 * JD-Core Version:    0.6.2
 */