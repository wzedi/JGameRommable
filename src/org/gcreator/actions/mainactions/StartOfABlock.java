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
/*    */ public class StartOfABlock extends ActionPattern
/*    */ {
/* 25 */   private static ImageIcon icon = new ImageIcon(StartOfABlock.class.getResource("/org/gcreator/actions/images/Start_Block.png"));
/*    */ 
/*    */   public String getStandardText(JComponent panel)
/*    */   {
/* 32 */     return LangSupporter.activeLang.getEntry(219);
/*    */   }
/*    */   public void setStandardImage(ImageIcon icon) {
/* 35 */     icon = icon;
/*    */   }
/*    */ 
/*    */   public String generateGCL(JComponent panel) {
/* 39 */     return "{";
/*    */   }
/*    */   public ImageIcon getStandardImage() {
/* 42 */     return icon;
/*    */   }
/*    */ 
/*    */   public boolean indents(JComponent comp, Vector<Action> indented, Vector<Action> unindented, JList list, boolean selected) {
/* 46 */     return true;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.mainactions.StartOfABlock
 * JD-Core Version:    0.6.2
 */