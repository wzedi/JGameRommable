/*    */ package org.gcreator.macro;
/*    */ 
/*    */ public class PlayMacroAction
/*    */   implements MacroAction
/*    */ {
/*    */   private Macro macro;
/*    */ 
/*    */   public PlayMacroAction(Macro macro)
/*    */   {
/* 15 */     this.macro = macro;
/*    */   }
/*    */   public Macro getMacro() {
/* 18 */     return this.macro;
/*    */   }
/*    */   public void play() {
/* 21 */     this.macro.play();
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.macro.PlayMacroAction
 * JD-Core Version:    0.6.2
 */