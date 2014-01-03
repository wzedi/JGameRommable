/*     */ package org.gcreator.managers;
/*     */ 
/*     */ /*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Vector;

/*     */ import org.gcreator.components.impl.Toolbar;
/*     */ import org.gcreator.components.impl.ToolbarButton;
/*     */ import org.gcreator.components.impl.ToolbarItem;
/*     */ import org.gcreator.components.impl.ToolbarSeparator;
/*     */ import org.gcreator.core.Aurwindow;
/*     */ import org.gcreator.core.gcreator;
/*     */ 
/*     */ 
/*     */ public class ToolbarManager
/*     */ {
/*  18 */   public static Vector<Toolbar> toolbars = new Vector<Toolbar>();
/*  19 */   public static Vector<ToolbarButton> toolbuttons = new Vector<ToolbarButton>();
/*     */ 
/*     */   public static void destroyToolbars() {
/*  22 */     hideAll();
/*  23 */     gcreator.window.topContainer.removeAll();
/*  24 */     gcreator.window.bottomContainer.removeAll();
/*  25 */     gcreator.window.leftContainer.removeAll();
/*  26 */     gcreator.window.rightContainer.removeAll();
/*     */   }
/*     */ 
/*     */   public static void hideAll() {
/*  30 */     Enumeration<Toolbar> e = toolbars.elements();
/*  31 */     while (e.hasMoreElements()) {
/*  32 */       Toolbar t = (Toolbar)e.nextElement();
/*  33 */       t.hideAll();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void showAll() {
/*  38 */     Enumeration<Toolbar> e = toolbars.elements();
/*  39 */     while (e.hasMoreElements()) {
/*  40 */       Toolbar t = (Toolbar)e.nextElement();
/*  41 */       t.showAll();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void makeToolbars(Aurwindow window) {
/*  46 */     for (Toolbar toolbar : toolbars)
/*  47 */       toolbar.make(window);
/*     */   }
/*     */ 
/*     */   public static void makeToolbars() {
/*  51 */     makeToolbars(gcreator.window);
/*     */   }
/*     */   public static void remakeToolbars() {
/*  54 */     destroyToolbars();
/*  55 */     makeToolbars();
/*     */   }
/*     */   public static void parseToolbarFile(String fname) throws IOException {
/*  58 */     File file = new File(fname);
/*  59 */     if ((!file.exists()) || (file.isDirectory()))
/*  60 */       return;
/*  61 */     String o = "";
/*  62 */     FileReader reader = new FileReader(file);
/*  63 */     int i = 0;
/*  64 */     while ((i = reader.read()) != -1) {
/*  65 */       o = o + (char)i;
/*     */     }
/*  67 */     reader.close();
/*  68 */     o = o.replaceAll("\r", "");
/*  69 */     o = o.replaceAll(";.+?\n", "\n");
/*  70 */     o = o.replaceAll("\n\n", "\n");
/*  71 */     String[] os = o.split("\n");
/*  72 */     boolean pfile = false;
/*  73 */     String v = null;
/*  74 */     Toolbar t = null;
/*  75 */     boolean tvisible = false;
/*  76 */     boolean ivisible = false;
/*  77 */     boolean bold = false;
/*  78 */     int version = 100;
/*  79 */     for (String line : os)
/*  80 */       if (!line.equals(""))
/*     */       {
/*  82 */         if (!pfile) {
/*  83 */           if (line.equals("[G-Creator Toolbar List]")) {
/*  84 */             pfile = true;
/*     */           }
/*     */           else
/*     */           {
/*  88 */             System.out.println("Not a G-Creator Toolbar List\n->" + line + "<-");
/*  89 */             break;
/*     */           }
/*     */         }
/*  92 */         else if ((v == null) && 
/*  93 */           (line.matches("^Version=[0-9]+(\\.[0-9]+)*$"))) {
/*  94 */           String ver = line.replaceAll("^Version=([0-9]+(\\.[0-9]+)*)$", "$1");
/*  95 */           if (ver.matches("1\\.0\\.0")) {
/*  96 */             version = 100;
/*     */           }
/*  99 */           else if (ver.matches("1\\.0\\.1")) {
/* 100 */             version = 101;
/*     */           }
/*     */           else
/*     */           {
/* 104 */             System.out.println("Unsupported version " + ver + "! Currently supported version is 1.0.0");
/* 105 */             break;
/*     */           }
/*     */ 
/*     */         }
/* 109 */         else if (t == null) {
/* 110 */           if (line.equals("[Toolbar]")) {
/* 111 */             t = new Toolbar();
/* 112 */             t.name = null;
/* 113 */             toolbars.add(t);
/* 114 */             tvisible = false;
/* 115 */             ivisible = false;
/* 116 */             bold = false;
/*     */           }
/*     */           else
/*     */           {
/* 120 */             System.out.println("Unexpected string");
/* 121 */             break;
/*     */           }
/*     */         }
/* 124 */         else if (line.equals("[Toolbar]")) {
/* 125 */           t = new Toolbar();
/* 126 */           t.name = null;
/* 127 */           toolbars.add(t);
/* 128 */           tvisible = false;
/* 129 */           ivisible = false;
/* 130 */           bold = false;
/*     */         }
/*     */         else {
/* 133 */           if (!line.matches("[a-zA-Z0-9_]+=[^;\\[\\]]+")) {
/* 134 */             System.out.println("Invalid format in " + t + "\nShould be in format 'Property=Value'");
/* 135 */             break;
/*     */           }
/* 137 */           String key = line.replaceAll("([a-zA-Z0-9_]+)=[^;\\[\\]]+", "$1");
/* 138 */           String value = line.replaceAll("[a-zA-Z0-9_]+=([^;\\[\\]]+)", "$1");
/* 139 */           if (key.equals("Name")) {
/* 140 */             t.name = value;
/*     */           }
/* 142 */           else if (key.equals("Position")) {
/* 143 */             if ((!value.equals("Top")) && (!value.equals("Bottom")) && (!value.equals("Left")) && (!value.equals("Right"))) {
/* 144 */               System.out.println("Invalid position " + value);
/* 145 */               break;
/*     */             }
/* 147 */             if ((value.equals("Top")) || (value.equals("Left")))
/* 148 */               t.first = true;
/*     */             else
/* 150 */               t.first = false;
/* 151 */             if ((value.equals("Top")) || (value.equals("Bottom")))
/* 152 */               t.horizontal = true;
/*     */             else
/* 154 */               t.horizontal = false;
/*     */           }
/* 156 */           else if (key.equals("Rollover")) {
/* 157 */             if (value.equals("True")) {
/* 158 */               t.rollover = true;
/* 159 */             } else if (value.equals("False")) {
/* 160 */               t.rollover = false;
/*     */             } else {
/* 162 */               System.out.println("Invalid boolean property: " + value);
/* 163 */               break;
/*     */             }
/*     */           }
/* 166 */           else if (key.equals("Floatable")) {
/* 167 */             if (value.equals("True")) {
/* 168 */               t.floatable = true;
/* 169 */             } else if (value.equals("False")) {
/* 170 */               t.floatable = false;
/*     */             } else {
/* 172 */               System.out.println("Invalid boolean property: " + value);
/* 173 */               break;
/*     */             }
/*     */           }
/* 176 */           else if (key.equals("TextVisible")) {
/* 177 */             if (value.equals("True")) {
/* 178 */               tvisible = true;
/* 179 */             } else if (value.equals("False")) {
/* 180 */               tvisible = false;
/*     */             } else {
/* 182 */               System.out.println("Invalid boolean property: " + value);
/* 183 */               break;
/*     */             }
/*     */           }
/* 186 */           else if (key.equals("ImageVisible")) {
/* 187 */             if (value.equals("True")) {
/* 188 */               ivisible = true;
/* 189 */             } else if (value.equals("False")) {
/* 190 */               ivisible = false;
/*     */             } else {
/* 192 */               System.out.println("Invalid boolean property: " + value);
/* 193 */               break;
/*     */             }
/*     */           }
/* 196 */           else if ((key.equals("Bold")) && (version >= 101)) {
/* 197 */             if (value.equals("True")) {
/* 198 */               bold = true;
/* 199 */             } else if (value.equals("False")) {
/* 200 */               bold = false;
/*     */             } else {
/* 202 */               System.out.println("Invalid boolean property: " + value);
/* 203 */               break;
/*     */             }
/*     */           }
/* 206 */           else if (key.equals("Item")) {
/* 207 */             boolean found = false;
/*     */ 
/* 209 */             for (ToolbarButton btn : toolbuttons) {
/* 210 */               if (btn.getID().equals(value)) {
/* 211 */                 btn.setTextVisible(tvisible);
/* 212 */                 btn.setImageVisible(ivisible);
/* 213 */                 btn.setBold(bold);
/* 214 */                 t.items.add(btn);
/* 215 */                 found = true;
/* 216 */                 break;
/*     */               }
/*     */             }
/* 219 */             if (!found)
/* 220 */               System.out.println("Unknown item " + value + "\nAre you missing a plugin?");
/*     */           }
/* 222 */           else if (key.equals("Separator")) {
/* 223 */             t.items.add(new ToolbarSeparator());
/*     */           }
/*     */           else {
/* 226 */             System.out.println("Unknown property: " + key);
/*     */           }
/*     */         }
/*     */       }
/*     */   }
/*     */ 
/* 232 */   public static void writeToolbarFile(String fname) throws IOException { File file = new File(fname);
/* 233 */     if (file.isDirectory())
/* 234 */       return;
/* 235 */     FileWriter writer = new FileWriter(file);
/* 236 */     writer.write(";Starting File\n");
/* 237 */     writer.write("[G-Creator Toolbar List]\n");
/* 238 */     writer.write(";Property=Value\n");
/* 239 */     writer.write("Version=1.0.1\n");
/* 240 */     writer.write("\n");
/* 241 */     for (Toolbar toolbar : toolbars) {
/* 242 */       writer.write("[Toolbar]\n");
/* 243 */       if (toolbar.name != null)
/* 244 */         writer.write("Name=" + toolbar.name + "\n");
/* 245 */       writer.write("Position=");
/* 246 */       writer.write((toolbar.first ? "Left" : toolbar.horizontal ? "Bottom" : toolbar.first ? "Top" : "Right") + "\n");
/* 247 */       writer.write("Rollover=" + (toolbar.rollover ? "True" : "False") + "\n");
/* 248 */       writer.write("Floatable=" + (toolbar.floatable ? "True" : "False") + "\n");
/* 249 */       toolbar.items.trimToSize();
/* 250 */       if (toolbar.items.capacity() != 0)
/*     */       {
/* 252 */         Boolean curtextvisible = null;
/* 253 */         Boolean curimgvisible = null;
/* 254 */         Boolean curbold = null;
/* 255 */         for (ToolbarItem item : toolbar.items) {
/* 256 */           if ((item instanceof ToolbarSeparator)) {
/* 257 */             writer.write("Separator=Standard\n");
/*     */           } else {
/* 259 */             ToolbarButton btn = (ToolbarButton)item;
/* 260 */             if ((curtextvisible == null) || (curtextvisible.booleanValue() != btn.isTextVisible()))
/* 261 */               writer.write("TextVisible=" + ((curtextvisible = Boolean.valueOf(btn.isTextVisible())).booleanValue() ? "True" : "False") + "\n");
/* 262 */             if ((curimgvisible == null) || (curimgvisible.booleanValue() != btn.isImageVisible()))
/* 263 */               writer.write("ImageVisible=" + ((curimgvisible = Boolean.valueOf(btn.isImageVisible())).booleanValue() ? "True" : "False") + "\n");
/* 264 */             if ((curbold == null) || (curbold.booleanValue() != btn.isBold()))
/* 265 */               writer.write("Bold=" + ((curbold = Boolean.valueOf(btn.isBold())).booleanValue() ? "True" : "False") + "\n");
/* 266 */             writer.write("Item=" + btn.getID() + "\n");
/*     */           }
/*     */         }
/* 269 */         writer.write("\n");
/*     */       }
/*     */     }
/* 271 */     writer.close();
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.managers.ToolbarManager
 * JD-Core Version:    0.6.2
 */