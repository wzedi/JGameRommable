/*     */ package org.gcreator.core;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;

/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.plaf.metal.DefaultMetalTheme;
/*     */ import javax.swing.plaf.metal.MetalLookAndFeel;
/*     */ import javax.swing.plaf.metal.OceanTheme;

/*     */ import org.gcreator.api.util.CreateApiList;
/*     */ import org.gcreator.clipboard.ClipboardManager;
/*     */ import org.gcreator.components.GlobalSettings;
/*     */ import org.gcreator.components.NewFileGroup;
/*     */ import org.gcreator.components.NewProject;
/*     */ import org.gcreator.components.impl.DefaultToolbarItem;
/*     */ import org.gcreator.components.impl.ToolbarButton;
/*     */ import org.gcreator.components.navigator.NoFileSelectedNavigator;
/*     */ import org.gcreator.components.navigator.UnknownResourceNavigator;
/*     */ import org.gcreator.help.AboutPanel;
/*     */ import org.gcreator.languages.English;
/*     */ import org.gcreator.managers.SettingsIO;
/*     */ import org.gcreator.managers.ToolbarManager;
/*     */ import org.gcreator.plugins.Plugger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class gcreator
/*     */ {
/*     */   private static String[] arguments;
/*     */   public static final String version = "1.01";
/*     */   public static Aurwindow window;
/*  40 */   public static String output = "";
/*     */   static SplashScreen splash;
/*  42 */   public static ClipboardManager clipboard = new ClipboardManager();
/*     */   public static String folder;
/*  44 */   private static String java_version = System.getProperty("java.version");
/*     */   protected static boolean applet;
/*  61 */   protected static boolean plugload = true;
/*     */ 
/*     */   public static String[] getargs()
/*     */   {
/*  47 */     return arguments;
/*     */   }
/*     */ 
/*     */   public static final String getJavaVersion() {
/*  51 */     return java_version;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*  57 */     applet = false;
/*  58 */     __main(args);
/*     */   }
/*     */ 
/*     */   public static void __main(String[] args, boolean plugload, boolean applet)
/*     */   {
/*  64 */     plugload = plugload;
/*  65 */     applet = applet;
/*  66 */     __main(args);
/*     */   }
/*     */ 
/*     */   public static void __main(String[] args) {
/*     */     try {
/*  71 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/*  77 */     boolean plugload = true;
/*  78 */     boolean ismdi = false;
/*  79 */     for (int i = 0; i < args.length; i++) {
/*  80 */       System.out.println("args[" + i + "] = " + args[i]);
/*  81 */       if (args[i].equals("-safe")) {
/*  82 */         plugload = false;
/*  83 */       } else if (args[i].matches("^-jemul:.*$")) {
/*  84 */         java_version = args[i].replaceFirst("^-jemul:(.*)$", "$1");
/*     */       }
/*  86 */       else if (args[i].equals("-mdi")) {
/*  87 */         ismdi = true;
/*  88 */       } else if (args[i].matches("^-(-?)help$")) {
/*  89 */         System.out.println("G-Creator version: 1.01");
/*  90 */         System.out.println("Licensed under LGPL v3. More information in README.txt and 'About'.");
/*  91 */         System.out.println("-safe\t\tStarts G-Creator in safe mode. (No plugins)");
/*  92 */         System.out.println("-jemul:version\tPretends the user is running G-Creator with version 'version'");
/*  93 */         System.out.println("-mdi\t\tStarts G-Creator in MDI mode");
/*  94 */         System.out.println("-help\t\tDisplays info about G-Creator");
/*  95 */         System.exit(0);
/*     */       }
/*     */     }
/*  98 */     int ver = Integer.parseInt(getJavaVersion().replaceAll("1\\.([0-9])\\..*", "$1"));
/*  99 */     System.out.println("Running Java version " + java_version);
/* 100 */     if (!applet) {
/* 101 */       folder = "" + gcreator.class.getProtectionDomain().getCodeSource().getLocation().getPath();
/* 102 */       int location = folder.lastIndexOf("/");
/* 103 */       folder = folder.substring(0, location + 1);
/* 104 */       folder = folder.replaceAll("file://", "");
/* 105 */       folder = folder.replaceAll("%20", " ");
/* 106 */       folder = folder.substring(1);
/* 107 */       folder = folder.replace("/", "\\");
/* 108 */       if (plugload) {
/* 109 */         Plugger.registerLoader();
/*     */       }
/*     */     }
/*     */ 
/* 113 */     if (ver <= 4)
/* 114 */       plugload = false;
/* 115 */     arguments = args;
/*     */ 
/* 117 */     String[] settings = null;
/*     */ 
/* 119 */     if (!applet) {
/* 120 */       settings = SettingsIO.loadSettings();
/*     */     }
/*     */ 
/* 123 */     if (settings == null) {
/* 124 */       settings = new String[7];
/* 125 */       settings[0] = "Native";
/* 126 */       settings[1] = "Tabs (Top)";
/* 127 */       settings[2] = "Visible";
/* 128 */       settings[3] = "English";
/* 129 */       settings[4] = "Visible";
/* 130 */       settings[5] = "Left";
/* 131 */       settings[6] = "800, 600";
/*     */     }
/*     */ 
/* 134 */     if ((ismdi) || (ver < 6)) {
/* 135 */       settings[1] = "MDI";
/*     */     }
/* 137 */     org.gcreator.managers.LangSupporter.activeLang = new English();
/*     */ 
/* 139 */     if (!settings[3].equals("English")) {
/* 140 */       //if (settings[3].equals("Portuguese (European)"))
/* 141 */         //org.gcreator.managers.LangSupporter.activeLang = new Portuguese();
/* 142 */       //else if (settings[3].equals("German"))
/* 143 */         //org.gcreator.managers.LangSupporter.activeLang = new German();
/* 144 */       //else if (settings[3].equals("German (Old)"))
/* 145 */         //org.gcreator.managers.LangSupporter.activeLang = new GermanOld();
/* 146 */       //else if (settings[3].equals("Russian"))
/* 147 */         //org.gcreator.managers.LangSupporter.activeLang = new Russian();
/* 148 */       //else if (settings[3].equals("Spanish"))
/* 149 */         //org.gcreator.managers.LangSupporter.activeLang = new Spanish();
/*     */       //else {
/* 151 */         //utilities.addError(36);
/*     */       //}
/*     */     }
/*     */ 
/* 155 */     ToolbarButton newp = new DefaultToolbarItem("std_newProject", new ImageIcon(gcreator.class.getResource("/org/gcreator/resources/toolbar/newproject.png")), 39);
/* 156 */     ToolbarButton opn = new DefaultToolbarItem("std_openProject", new ImageIcon(gcreator.class.getResource("/org/gcreator/resources/toolbar/openproject.png")), 40);
/* 157 */     ToolbarButton save = new DefaultToolbarItem("std_save", new ImageIcon(gcreator.class.getResource("/org/gcreator/resources/toolbar/save.png")), 41);
/* 158 */     ToolbarButton saveall = new DefaultToolbarItem("std_saveAll", new ImageIcon(gcreator.class.getResource("/org/gcreator/resources/toolbar/saveall.png")), 53);
/* 159 */     ToolbarButton addimg = new DefaultToolbarItem("std_addImage", new ImageIcon(gcreator.class.getResource("/org/gcreator/resources/toolbar/addimage.png")), 198);
/* 160 */     ToolbarButton addspr = new DefaultToolbarItem("std_addSprite", new ImageIcon(gcreator.class.getResource("/org/gcreator/resources/toolbar/addsprite.png")), 43);
/* 161 */     ToolbarButton addtls = new DefaultToolbarItem("std_addTileset", new ImageIcon(gcreator.class.getResource("/org/gcreator/resources/toolbar/addtileset.png")), 190);
/* 162 */     ToolbarButton addsnd = new DefaultToolbarItem("std_addSound", new ImageIcon(gcreator.class.getResource("/org/gcreator/resources/toolbar/addsound.png")), 44);
/* 163 */     ToolbarButton addtml = new DefaultToolbarItem("std_addTimeline", new ImageIcon(gcreator.class.getResource("/org/gcreator/resources/toolbar/addtimeline.png")), 204);
/* 164 */     ToolbarButton addact = new DefaultToolbarItem("std_addActor", new ImageIcon(gcreator.class.getResource("/org/gcreator/resources/toolbar/addactor.png")), 45);
/* 165 */     ToolbarButton addscn = new DefaultToolbarItem("std_addScene", new ImageIcon(gcreator.class.getResource("/org/gcreator/resources/toolbar/addroom.png")), 46);
/*     */ 
/* 167 */     //ToolbarButton addgs = new DefaultToolbarItem("std_addScript", new ImageIcon(gcreator.class.getResource("/org/gcreator/resources/toolbar/addscript.png")), 207);
/* 168 */     //ToolbarButton addgr = new DefaultToolbarItem("std_addGroup", new ImageIcon(gcreator.class.getResource("/org/gcreator/resources/toolbar/addgroup.png")), 245);
/*     */ 
/* 170 */     newp.setActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 172 */         gcreator.window.onToolbarActionPerformed(1, evt);
/*     */       }
/*     */     });
/* 176 */     opn.setActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 178 */         gcreator.window.onToolbarActionPerformed(2, evt);
/*     */       }
/*     */     });
/* 182 */     save.setActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 184 */         gcreator.window.onToolbarActionPerformed(3, evt);
/*     */       }
/*     */     });
/* 188 */     saveall.setActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 190 */         gcreator.window.onToolbarActionPerformed(4, evt);
/*     */       }
/*     */     });
/* 194 */     addimg.setActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 196 */         gcreator.window.onToolbarActionPerformed(10, evt);
/*     */       }
/*     */     });
/* 200 */     addspr.setActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 202 */         gcreator.window.onToolbarActionPerformed(5, evt);
/*     */       }
/*     */     });
/* 206 */     addtls.setActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 208 */         gcreator.window.onToolbarActionPerformed(11, evt);
/*     */       }
/*     */     });
/* 212 */     addsnd.setActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 214 */         gcreator.window.onToolbarActionPerformed(6, evt);
/*     */       }
/*     */     });
/* 218 */     addact.setActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 220 */         gcreator.window.onToolbarActionPerformed(8, evt);
/*     */       }
/*     */     });
/* 224 */     addscn.setActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 226 */         gcreator.window.onToolbarActionPerformed(9, evt);
/*     */       }
/*     */     });
/* 236 */     //addgs.setActionListener(new ActionListener() {
/*     */       //public void actionPerformed(ActionEvent evt) {
/* 238 */         //gcreator.window.onToolbarActionPerformed(13, evt);
/*     */       //}
/*     */     //});
/* 242 */     addtml.setActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 244 */         gcreator.window.onToolbarActionPerformed(12, evt);
/*     */       }
/*     */     });
/* 248 */     //addgr.setActionListener(new ActionListener() {
/*     */       //public void actionPerformed(ActionEvent evt) {
/* 250 */         //gcreator.window.onToolbarActionPerformed(14, evt);
/*     */       //}
/*     */     //});
/* 254 */     ToolbarManager.toolbuttons.add(newp);
/* 255 */     ToolbarManager.toolbuttons.add(opn);
/* 256 */     ToolbarManager.toolbuttons.add(save);
/* 257 */     ToolbarManager.toolbuttons.add(saveall);
/* 258 */     ToolbarManager.toolbuttons.add(addimg);
/* 259 */     ToolbarManager.toolbuttons.add(addspr);
/* 260 */     ToolbarManager.toolbuttons.add(addtls);
/* 261 */     ToolbarManager.toolbuttons.add(addsnd);
/* 262 */     ToolbarManager.toolbuttons.add(addtml);
/* 263 */     ToolbarManager.toolbuttons.add(addact);
/* 264 */     ToolbarManager.toolbuttons.add(addscn);
/*     */ 
/* 266 */     //ToolbarManager.toolbuttons.add(addgs);
/* 267 */     //ToolbarManager.toolbuttons.add(addgr);
/*     */ 
/* 288 */     if ((!applet) && (plugload)) {
/* 289 */       Plugger.onLoad();
/* 290 */       Plugger.onSplashStart();
/*     */     }
/* 292 */     splash = new SplashScreen(applet);
/*     */     try
/*     */     {
/* 295 */       ToolbarManager.parseToolbarFile("settings/toolbarList.gctl");
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/* 300 */     CreateApiList.setup();
/*     */     try
/*     */     {
/* 310 */       if ((settings != null) && (settings[0] != null) && (settings[0].equals("Native"))) {
/* 311 */         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/* 312 */       } else if ((settings == null) || (settings[0] == null) || (settings[0].equals("Cross-platform"))) {
/* 313 */         MetalLookAndFeel.setCurrentTheme(new OceanTheme());
/* 314 */         UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
/* 315 */       } else if (settings[0].equals("Motif")) {
/* 316 */         UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
/* 317 */       } else if (settings[0].equals("Metal")) {
/* 318 */         MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
/* 319 */         UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/*     */     }
/* 324 */     if (splash != null) {
/* 325 */       SwingUtilities.updateComponentTreeUI(splash);
/*     */     }
/* 327 */     if ((!applet) && (plugload)) {
/* 328 */       Plugger.onMainWindowStart();
/*     */     }
/* 330 */     window = new Aurwindow(settings);
/* 331 */     window.console.setText(output);
/* 332 */     Aurwindow.globalsettings = new GlobalSettings(settings);
/* 333 */     Aurwindow.newfilegroup = new NewFileGroup();
/* 334 */     Aurwindow.newproject = new NewProject();
/* 335 */     Aurwindow.about = new AboutPanel();
/* 336 */     Aurwindow.nofileselnavigator = new NoFileSelectedNavigator();
/* 337 */     Aurwindow.unkresnav = new UnknownResourceNavigator();
/*     */ 
/* 339 */     if (splash != null) {
/* 340 */       splash.dispose();
/* 341 */       if ((!applet) && (plugload))
/* 342 */         Plugger.onSplashDispose();
/* 343 */       window.menubar.updateUI();
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.core.gcreator
 * JD-Core Version:    0.6.2
 */