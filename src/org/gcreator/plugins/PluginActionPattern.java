/*    */ package org.gcreator.plugins;
/*    */ 
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JComponent;
/*    */ import org.gcreator.actions.ActionPattern;
/*    */ 
/*    */ public class PluginActionPattern extends ActionPattern
/*    */ {
/*    */   public ImageIcon img;
/*    */ 
/*    */   public String generateGCL(JComponent comp)
/*    */   {
/* 19 */     return "";
/*    */   }
/*    */ 
/*    */   public ImageIcon getStandardImage() {
/* 23 */     return this.img;
/*    */   }
/*    */ 
/*    */   public void setStandardImage(ImageIcon img) {
/* 27 */     this.img = img;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.plugins.PluginActionPattern
 * JD-Core Version:    0.6.2
 */