/*    */ package org.gcreator.actions.mainactions;
/*    */ 
/*    */ import java.util.Vector;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JList;
/*    */ import org.gcreator.actions.Action;
/*    */ import org.gcreator.actions.ActionPattern;
/*    */ import org.gcreator.managers.LangSupporter;
/*    */ import org.gcreator.units.Dictionary;
/*    */ 
/*    */ public class PreviousScene extends ActionPattern
/*    */ {
/* 25 */   private static ImageIcon icon = new ImageIcon(PreviousScene.class.getResource("/org/gcreator/actions/images/Previous_Scene.png"));
/*    */ 
/*    */   public String getStandardText(JComponent panel)
/*    */   {
/* 32 */     return LangSupporter.activeLang.getEntry(228);
/*    */   }
/*    */   public void setStandardImage(ImageIcon icon) {
/* 35 */     icon = icon;
/*    */   }
/*    */ 
/*    */   public String generateGCL(JComponent panel) {
/* 39 */     return "room_goto_previous();\n";
/*    */   }
/*    */   public ImageIcon getStandardImage() {
/* 42 */     return icon;
/*    */   }
/*    */ 
/*    */   public boolean indents(JComponent comp, Vector<Action> indented, Vector<Action> unindented, JList list, boolean selected) {
/* 46 */     return false;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.mainactions.PreviousScene
 * JD-Core Version:    0.6.2
 */