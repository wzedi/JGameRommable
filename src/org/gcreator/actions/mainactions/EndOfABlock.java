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
/*    */ public class EndOfABlock extends ActionPattern
/*    */ {
/* 25 */   private static ImageIcon icon = new ImageIcon(EndOfABlock.class.getResource("/org/gcreator/actions/images/End_Block.png"));
/*    */ 
/*    */   public String getStandardText(JComponent panel)
/*    */   {
/* 33 */     return LangSupporter.activeLang.getEntry(220);
/*    */   }
/*    */ 
/*    */   public String generateGCL(JComponent panel)
/*    */   {
/* 38 */     return "}\n";
/*    */   }
/*    */ 
/*    */   public void setStandardImage(ImageIcon icon) {
/* 42 */     icon = icon;
/*    */   }
/*    */ 
/*    */   public ImageIcon getStandardImage() {
/* 46 */     return icon;
/*    */   }
/*    */ 
/*    */   public boolean unindentsNext(JComponent comp, Vector<Action> indented, Vector<Action> unindented, JList list, boolean selected) {
/* 50 */     return true;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.mainactions.EndOfABlock
 * JD-Core Version:    0.6.2
 */