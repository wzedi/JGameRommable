/*    */ package org.gcreator.macro;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Enumeration;
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class MacroLibrary
/*    */ {
/* 15 */   private static Vector<Macro> macros = new Vector();
/*    */ 
/*    */   public static boolean addMacro(Macro macro) {
/* 18 */     if (findMacro(macro.getName()) == null) {
/* 19 */       macros.add(macro);
/* 20 */       return true;
/*    */     }
/* 22 */     return false;
/*    */   }
/*    */ 
/*    */   public static Macro getMacroAt(int i) {
/* 26 */     return (Macro)macros.get(i);
/*    */   }
/*    */ 
/*    */   public static Macro findMacro(String name) {
/* 30 */     Enumeration menum = macros.elements();
/*    */ 
/* 32 */     while (menum.hasMoreElements()) {
/* 33 */       Macro m = (Macro)menum.nextElement();
/* 34 */       if (m.getName().equals(name))
/* 35 */         return m;
/*    */     }
/* 37 */     return null;
/*    */   }
/*    */ 
/*    */   public static int getSize() {
/* 41 */     return macros.size();
/*    */   }
/*    */ 
/*    */   public static String[] getMacroNames() {
/* 45 */     Vector x = new Vector();
/* 46 */     Enumeration menum = macros.elements();
/*    */ 
/* 48 */     while (menum.hasMoreElements()) {
/* 49 */       Macro m = (Macro)menum.nextElement();
/* 50 */       x.add(m.getName());
/*    */     }
/* 52 */     Object[] _ret = x.toArray();
/* 53 */     String[] ret = new String[_ret.length];
/* 54 */     for (int i = 0; i < _ret.length; i++) {
/* 55 */       ret[i] = _ret[i].toString();
/*    */     }
/* 57 */     Arrays.sort(ret);
/* 58 */     return ret;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.macro.MacroLibrary
 * JD-Core Version:    0.6.2
 */