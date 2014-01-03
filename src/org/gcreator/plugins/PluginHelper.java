/*     */ package org.gcreator.plugins;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.net.URL;
/*     */ import java.util.Vector;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JInternalFrame;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.JTree;
/*     */ import javax.swing.SwingUtilities;
/*     */ import org.gcreator.actions.ActionCategory;
/*     */ import org.gcreator.actions.ActionContainer;
/*     */ import org.gcreator.actions.ActionPattern;
/*     */ import org.gcreator.clipboard.ClipboardManager;
/*     */ import org.gcreator.components.GlobalSettings;
/*     */ import org.gcreator.core.Aurwindow;
/*     */ import org.gcreator.core.gcreator;
/*     */ import org.gcreator.core.utilities;
/*     */ import org.gcreator.fileclass.Folder;
/*     */ import org.gcreator.fileclass.GObject;
/*     */ import org.gcreator.fileclass.Project;
/*     */ import org.gcreator.managers.LangSupporter;
/*     */ import org.gcreator.managers.ProjectTree;
/*     */ import org.gcreator.units.Dictionary;
/*     */ 
/*     */ public class PluginHelper
/*     */ {
/*     */   public static Aurwindow getWindow()
/*     */   {
/*  29 */     return gcreator.window;
/*     */   }
/*     */ 
/*     */   public static JTree getWorkspace()
/*     */   {
/*  37 */     return Aurwindow.workspace;
/*     */   }
/*     */ 
/*     */   public static void println(String message)
/*     */   {
/*  45 */     utilities.addStringMessage(message);
/*     */   }
/*     */ 
/*     */   public static String getLanguageMessage(int num) {
/*  49 */     return LangSupporter.activeLang.getEntry(num);
/*     */   }
/*     */ 
/*     */   public static String getLanguageSpecialMessage(String value) {
/*  53 */     return LangSupporter.activeLang.getSpecialEntry(value);
/*     */   }
/*     */ 
/*     */   public static Project getCurrentProject() {
/*  57 */     return gcreator.window.getCurrentProject();
/*     */   }
/*     */ 
/*     */   public static Folder getCurrentFolder() {
/*  61 */     return gcreator.window.getCurrentFolder();
/*     */   }
/*     */ 
/*     */   public static GObject getCurrentObject() {
/*  65 */     return gcreator.window.getCurrentObject();
/*     */   }
/*     */ 
/*     */   public static void addMenu(JMenu menu) {
/*  69 */     gcreator.window.menubar.add(menu);
/*     */   }
/*     */ 
/*     */   public static void addMenuItem(int menu, JMenuItem item) {
/*  73 */     gcreator.window.menus[menu].add(item);
/*     */   }
/*     */ 
/*     */   public static void addMenuSeparator(int menu) {
/*  77 */     gcreator.window.menus[menu].addSeparator();
/*     */   }
/*     */ 
/*     */   public static void addSubMenu(int menu, JMenu submenu) {
/*  81 */     gcreator.window.menus[menu].add(submenu);
/*     */   }
/*     */ 
/*     */   public static String getClipboardContent() {
/*  85 */     return gcreator.clipboard.getClipboardContents();
/*     */   }
/*     */ 
/*     */   public static void setClipboardContent(String content) {
/*  89 */     gcreator.clipboard.setClipboardContents(content);
/*     */   }
/*     */ 
/*     */   public static void updateStyle() {
/*  93 */     SwingUtilities.updateComponentTreeUI(gcreator.window);
/*  94 */     if (gcreator.window.istabs)
/*  95 */       SwingUtilities.updateComponentTreeUI(gcreator.window.mdi);
/*     */     else {
/*  97 */       SwingUtilities.updateComponentTreeUI(Aurwindow.tabs);
/*     */     }
/*  99 */     SwingUtilities.updateComponentTreeUI(gcreator.window.consolepopup);
/* 100 */     SwingUtilities.updateComponentTreeUI(Aurwindow.newproject);
/* 101 */     SwingUtilities.updateComponentTreeUI(Aurwindow.newfilegroup);
/* 102 */     SwingUtilities.updateComponentTreeUI(Aurwindow.about);
/* 103 */     SwingUtilities.updateComponentTreeUI(Aurwindow.globalsettings);
/*     */   }
/*     */ 
/*     */   public static String encrypt(String str) {
/* 107 */     return utilities.encrypt(str);
/*     */   }
/*     */ 
/*     */   public static String decrypt(String str) {
/* 111 */     return utilities.decrypt(str);
/*     */   }
/*     */ 
/*     */   public static Component addGlobalTab(String name, JComponent comp) {
/* 115 */     return Aurwindow.globalsettings.jTabbedPane1.add(name, comp);
/*     */   }
/*     */ 
/*     */   public static void addNewActionPattern(ActionPattern pattern) {
/* 119 */     ((ActionCategory)ActionContainer.actionCats.get(0)).add(pattern);
/*     */   }
/*     */ 
/*     */   public static void addNewActionPattern(ActionCategory category, ActionPattern pattern) {
/* 123 */     category.add(pattern);
/*     */   }
/*     */ 
/*     */   public static void addNewActionCategory(ActionCategory category) {
/* 127 */     ActionContainer.actionCats.add(category);
/*     */   }
/*     */   public static void setMainProject(Project p) {
/* 130 */     Aurwindow.setMainProject(p);
/*     */   }
/*     */   public static Project getMainProject() {
/* 133 */     return Aurwindow.getMainProject();
/*     */   }
/*     */   public static void addToTree(Project p) {
/* 136 */     ProjectTree.importFolderToTree(p, gcreator.window.top);
/*     */   }
/*     */ 
/*     */   public static URL getResource(String value) {
/* 140 */     return PluginHelper.class.getResource(value);
/*     */   }
/*     */ 
/*     */   public static ImageIcon getImageResource(String value) {
/* 144 */     return new ImageIcon(getResource(value));
/*     */   }
/*     */ 
/*     */   public static JInternalFrame createPaletteFrame(String title) {
/* 148 */     JInternalFrame f = getWindow().createPaletteFrame();
/* 149 */     f.setTitle(title);
/* 150 */     return f;
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.plugins.PluginHelper
 * JD-Core Version:    0.6.2
 */