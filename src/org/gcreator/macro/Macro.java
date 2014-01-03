/*    */ package org.gcreator.macro;
/*    */ 
/*    */ import java.util.Enumeration;
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class Macro
/*    */ {
/* 15 */   private Vector<MacroAction> actions = new Vector();
/*    */   private String name;
/* 17 */   public static Macro recordingMacro = null;
/*    */   public String author;
/*    */   public String description;
/*    */ 
/*    */   public Macro(String name)
/*    */   {
/* 23 */     this(name, "", "");
/*    */   }
/*    */ 
/*    */   public Macro(String name, String author) {
/* 27 */     this(name, author, "");
/*    */   }
/*    */ 
/*    */   public Macro(String name, String author, String description) {
/* 31 */     this.name = name;
/* 32 */     this.author = author;
/* 33 */     this.description = description;
/*    */   }
/*    */ 
/*    */   public String getName()
/*    */   {
/* 41 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void rename(String name)
/*    */   {
/* 50 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public static Macro record(String name)
/*    */   {
/* 58 */     return Macro.recordingMacro = new Macro(name);
/*    */   }
/*    */ 
/*    */   public static void macroAction(MacroAction action)
/*    */   {
/* 67 */     if (recordingMacro != null)
/* 68 */       recordingMacro.actions.add(action);
/*    */   }
/*    */ 
/*    */   public void play()
/*    */   {
/* 75 */     Enumeration gnum = this.actions.elements();
/*    */ 
/* 77 */     while (gnum.hasMoreElements()) {
/* 78 */       MacroAction macro = (MacroAction)gnum.nextElement();
/* 79 */       macro.play();
/*    */     }
/* 81 */     if (recordingMacro != this)
/* 82 */       macroAction(new PlayMacroAction(this));
/*    */   }
/*    */ 
/*    */   public static void play(Macro macro)
/*    */   {
/* 89 */     macro.play();
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.macro.Macro
 * JD-Core Version:    0.6.2
 */