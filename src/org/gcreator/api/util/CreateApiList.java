/*    */ package org.gcreator.api.util;
/*    */ 
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class CreateApiList
/*    */ {
/* 14 */   public static Vector classes = new Vector();
/*    */   static ApiClass clas;
/*    */ 
/*    */   public static void setup()
/*    */   {
/* 19 */     clas = new ApiClass("Clipboard");
/* 20 */     clas.add(new ApiFunction("clipboard_has_text ()", "<b>double</b> clipboard_has_text <i>()</i><br><br>   Returns whether there is any text on the clipboard "));
/* 21 */     clas.add(new ApiFunction("clipboard_get_text ()", "<b>String</b> clipboard_get_text <i>()</i><br><br>   Returns the current text on the clipboard "));
/* 22 */     clas.add(new ApiFunction("clipboard_set_text (String s)", "<b>double</b> clipboard_set_text <i>(String s)</i><br><br>   Sets the string str on the clipboard "));
/* 23 */     classes.add(clas);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.api.util.CreateApiList
 * JD-Core Version:    0.6.2
 */