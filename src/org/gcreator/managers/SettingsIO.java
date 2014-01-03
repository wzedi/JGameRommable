/*     */ package org.gcreator.managers;
/*     */ 
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import javax.swing.JSplitPane;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.JTextPane;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import org.gcreator.core.Aurwindow;
/*     */ import org.gcreator.core.gcreator;
/*     */ import org.gcreator.units.Dictionary;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class SettingsIO
/*     */ {
/*     */   public static JTextPane console;
/*     */ 
/*     */   private static void addError(int message)
/*     */   {
/*  29 */     addFormatedMessage(message, "red", true);
/*     */   }
/*     */ 
/*     */   private static void addStringMessage(String message) {
/*  33 */     addStringFormatedMessage(message, null, false);
/*     */   }
/*     */ 
/*     */   private static void addFormatedMessage(int message, String color, boolean bold) {
/*  37 */     addStringFormatedMessage(LangSupporter.activeLang.getEntry(message), color, bold);
/*     */   }
/*     */ 
/*     */   private static void addStringFormatedMessage(String message, String color, boolean bold) {
/*  41 */     String out = "";
/*  42 */     if (color != null) {
/*  43 */       out = out + "<font color='" + color + "'>";
/*     */     }
/*  45 */     if (bold) {
/*  46 */       out = out + "<b>";
/*     */     }
/*  48 */     out = out + message;
/*  49 */     if (bold) {
/*  50 */       out = out + "</b>";
/*     */     }
/*  52 */     if (color != null) {
/*  53 */       out = out + "</font>";
/*     */     }
/*  55 */     out = out + "<br/>";
/*  56 */     gcreator.output += out;
/*  57 */     if ((gcreator.output != null) && (console != null))
/*  58 */       console.setText(gcreator.output);
/*     */   }
/*     */ 
/*     */   public static void saveSettings(int look, boolean istabs, boolean scrollvisible) {
/*  62 */     File a = new File("settings.xml");
/*  63 */     if (!a.exists())
/*     */       try {
/*  65 */         a.createNewFile();
/*     */       } catch (IOException e) {
/*  67 */         addError(30);
/*     */       }
/*     */     try
/*     */     {
/*  71 */       FileWriter b = new FileWriter("settings.xml");
/*  72 */       BufferedWriter out = new BufferedWriter(b);
/*  73 */       out.write("<?xml version = \"1.0\"?>\n");
/*  74 */       out.write("<settings>");
/*  75 */       out.write("<style>");
/*  76 */       if (look == 0)
/*  77 */         out.write("Native");
/*  78 */       else if (look == 1)
/*  79 */         out.write("Cross-platform");
/*  80 */       else if (look == 2)
/*  81 */         out.write("Motif");
/*  82 */       else if (look == 3)
/*  83 */         out.write("Metal");
/*     */       else {
/*  85 */         out.write("Unknown");
/*     */       }
/*  87 */       out.write("</style>");
/*  88 */       out.write("<desktop>");
/*  89 */       if (istabs) {
/*  90 */         out.write("Tabs ");
/*  91 */         if (Aurwindow.tabs.getTabPlacement() == 1)
/*  92 */           out.write("(Top)");
/*  93 */         else if (Aurwindow.tabs.getTabPlacement() == 2)
/*  94 */           out.write("(Left)");
/*  95 */         else if (Aurwindow.tabs.getTabPlacement() == 3)
/*  96 */           out.write("(Bottom)");
/*     */         else
/*  98 */           out.write("(Right)");
/*     */       } else {
/* 100 */         out.write("MDI");
/*     */       }
/* 102 */       out.write("</desktop>");
/* 103 */       out.write("<console>");
/* 104 */       out.write(scrollvisible ? "Visible" : "Hidden");
/* 105 */       out.write("</console>");
/* 106 */       out.write("<language>");
/* 107 */       out.write(Aurwindow.lang);
/* 108 */       out.write("</language>");
/* 109 */       out.write("<toolbar>");
/* 110 */       out.write(Aurwindow.showToolbars ? "Visible" : "Hidden");
/* 111 */       out.write("</toolbar>");
/* 112 */       out.write("<tree>");
/* 113 */       if (gcreator.window.splitter2.getLeftComponent() == Aurwindow.treescroll) {
/* 114 */         out.write("Left");
/*     */       }
/* 116 */       else if (gcreator.window.splitter2.getRightComponent() == Aurwindow.treescroll) {
/* 117 */         out.write("Right");
/*     */       }
/*     */       else {
/* 120 */         addStringFormatedMessage("Invalid tree position-setting to Left", "red", false);
/* 121 */         out.write("Left");
/*     */       }
/* 123 */       out.write("</tree>");
/* 124 */       out.write("<size>");
/* 125 */       out.write(gcreator.window.getWidth() + ", " + gcreator.window.getHeight());
/* 126 */       out.write("</size>");
/* 127 */       out.write("</settings>");
/* 128 */       out.close();
/*     */     } catch (IOException e) {
/* 130 */       addError(31);
/* 131 */       addStringFormatedMessage(e.getMessage(), null, false);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static String[] loadSettings() {
/* 136 */     File target = new File("./settings.xml");
/* 137 */     if (!target.exists()) {
/* 138 */       addStringFormatedMessage(target.getAbsolutePath() + " does not exist", null, false);
/*     */       try {
/* 140 */         target.createNewFile();
/*     */       } catch (Exception e) {
/*     */       }
/* 143 */       return null;
/*     */     }
/* 145 */     String[] a = new String[7];
/* 146 */     a[0] = null;
/* 147 */     a[1] = null;
/* 148 */     a[2] = null;
/* 149 */     a[3] = null;
/* 150 */     a[4] = null;
/* 151 */     a[5] = null;
/* 152 */     a[6] = null;
/* 153 */     DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
/*     */     try
/*     */     {
/* 157 */       DocumentBuilder builder = fact.newDocumentBuilder();
/* 158 */       Document doc = builder.parse("settings.xml");
/* 159 */       Node node = doc.getDocumentElement();
/* 160 */       String root = node.getNodeName();
/* 161 */       if (!root.equals("settings")) {
/* 162 */         addError(33);
/* 163 */         return null;
/*     */       }
/* 165 */       NodeList childs = node.getChildNodes();
/*     */ 
/* 167 */       for (int i = 0; i < childs.getLength(); i++) {
/* 168 */         Node child = childs.item(i);
/* 169 */         String name = child.getNodeName();
/* 170 */         int id = -1;
/* 171 */         if (name.equals("style"))
/* 172 */           id = 0;
/* 173 */         else if (name.equals("desktop"))
/* 174 */           id = 1;
/* 175 */         else if (name.equals("console"))
/* 176 */           id = 2;
/* 177 */         else if (name.equals("language"))
/* 178 */           id = 3;
/* 179 */         else if (name.equals("toolbar"))
/* 180 */           id = 4;
/* 181 */         else if (name.equals("tree"))
/* 182 */           id = 5;
/* 183 */         else if (name.equals("size"))
/* 184 */           id = 6;
/* 185 */         if (id == -1) {
/* 186 */           addError(33);
/* 187 */           addStringFormatedMessage(name, null, true);
/* 188 */           return null;
/*     */         }
/* 190 */         if (a[id] != null)
/* 191 */           addError(34);
/* 192 */         a[id] = child.getTextContent();
/*     */       }
/* 194 */       if ((a[0] == null) || (a[1] == null) || (a[2] == null) || (a[3] == null) || (a[4] == null) || (a[5] == null) || (a[6] == null)) {
/* 195 */         addError(35);
/*     */       }
/* 197 */       return a;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 204 */     return null;
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.managers.SettingsIO
 * JD-Core Version:    0.6.2
 */