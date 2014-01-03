/*    */ package org.gcreator.managers;
/*    */ 
/*    */ import javax.accessibility.AccessibleContext;
/*    */ import javax.swing.ButtonGroup;
/*    */ import javax.swing.JCheckBoxMenuItem;
/*    */ import javax.swing.JMenu;
/*    */ import javax.swing.JMenuBar;
/*    */ import javax.swing.JMenuItem;
/*    */ import javax.swing.JRadioButtonMenuItem;
/*    */ import org.gcreator.components.ExtendedCheckMenuItem;
/*    */ import org.gcreator.components.ExtendedMenu;
/*    */ import org.gcreator.components.ExtendedMenuItem;
/*    */ import org.gcreator.components.ExtendedRadioMenuItem;
/*    */ import org.gcreator.units.Dictionary;
/*    */ 
/*    */ public class MenuSupporter
/*    */ {
/*    */   public static final int MENULIMIT = 30;
/*    */   public static final int ITEMLIMIT = 30;
/*    */ 
/*    */   public static JMenu MakeMenu(JMenuBar menubar, int label, String description)
/*    */   {
/* 25 */     JMenu menu = new JMenu(LangSupporter.activeLang.getEntry(label));
/* 26 */     menu.getAccessibleContext().setAccessibleDescription(description);
/* 27 */     menu.setToolTipText(description);
/* 28 */     menubar.add(menu);
/* 29 */     return menu;
/*    */   }
/*    */ 
/*    */   public static JMenu MakeSubMenu(JMenu menu, int label, String description) {
/* 33 */     JMenu amenu = new ExtendedMenu(LangSupporter.activeLang.getEntry(label));
/* 34 */     menu.getAccessibleContext().setAccessibleDescription(description);
/* 35 */     menu.add(amenu);
/* 36 */     amenu.setToolTipText(description);
/* 37 */     return amenu;
/*    */   }
/*    */ 
/*    */   public static JMenuItem MakeMenuItem(JMenu menu, int label, String description) {
/* 41 */     JMenuItem item = new ExtendedMenuItem(LangSupporter.activeLang.getEntry(label));
/* 42 */     item.getAccessibleContext().setAccessibleDescription(description);
/* 43 */     item.setToolTipText(description);
/* 44 */     menu.add(item);
/* 45 */     return item;
/*    */   }
/*    */ 
/*    */   public static JRadioButtonMenuItem MakeRadioMenuItem(ButtonGroup group, JMenu menu, int label, String description) {
/* 49 */     JRadioButtonMenuItem item = new ExtendedRadioMenuItem(LangSupporter.activeLang.getEntry(label));
/* 50 */     item.getAccessibleContext().setAccessibleDescription(description);
/* 51 */     item.setToolTipText(description);
/* 52 */     group.add(item);
/* 53 */     menu.add(item);
/* 54 */     return item;
/*    */   }
/*    */ 
/*    */   public static JCheckBoxMenuItem MakeCheckMenuItem(JMenu menu, int label, String description) {
/* 58 */     JCheckBoxMenuItem item = new ExtendedCheckMenuItem(LangSupporter.activeLang.getEntry(label));
/* 59 */     item.getAccessibleContext().setAccessibleDescription(description);
/* 60 */     item.setToolTipText(description);
/* 61 */     menu.add(item);
/* 62 */     return item;
/*    */   }
/*    */ 
/*    */   public static void MakeSeparator(JMenu menu) {
/* 66 */     menu.addSeparator();
/*    */   }
/*    */ 
/*    */   public static int GenerateMenuItemId(int menu, int menuitem) {
/* 70 */     return menu * 30 + menuitem;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.managers.MenuSupporter
 * JD-Core Version:    0.6.2
 */