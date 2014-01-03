/*    */ package org.gcreator.components.impl;
/*    */ 
/*    */ import javax.swing.ImageIcon;
/*    */ import org.gcreator.managers.LangSupporter;
/*    */ import org.gcreator.units.Dictionary;
/*    */ 
/*    */ public class DefaultToolbarItem extends ToolbarButton
/*    */ {
/*    */   public DefaultToolbarItem(String id, ImageIcon img, int lang)
/*    */   {
/* 17 */     super(id, LangSupporter.activeLang.getEntry(lang), img);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.impl.DefaultToolbarItem
 * JD-Core Version:    0.6.2
 */