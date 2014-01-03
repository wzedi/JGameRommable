/*     */ package org.gcreator.fileclass;
/*     */ 
/*     */ import java.util.Enumeration;
/*     */ import java.util.Vector;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.tree.TreeNode;
/*     */ import org.gcreator.fileclass.res.SettingsValues;
/*     */ import org.gcreator.units.ObjectNode;
/*     */ 
/*     */ public class GameProject extends Project
/*     */ {
/*  23 */   public int images = 1;
/*  24 */   public int sprites = 1;
/*  25 */   public int tilesets = 1;
/*  26 */   public int sounds = 1;
/*  27 */   public int timelines = 1;
/*  28 */   public int actors = 1;
/*  29 */   public int scenes = 1;
/*  30 */   public int classes = 1;
/*  31 */   public int scripts = 1;
/*     */ 
/* 224 */   private ImageIcon project_game = new ImageIcon(getClass().getResource("/org/gcreator/resources/toolbar/new_game_sm.png"));
/*     */ 
/*     */   public GameProject(String name, String location)
/*     */   {
/*  34 */     super(name, location);
/*     */   }
/*     */ 
/*     */   public GameProject() {
/*     */   }
/*     */ 
/*     */   public String getType() {
/*  41 */     return "Game";
/*     */   }
/*     */ 
/*     */   public static GameProject balance() {
/*  45 */     return (GameProject)balancedCreation();
/*     */   }
/*     */ 
/*     */   public Enumeration getEnum(String key) {
/*  49 */     Enumeration e = null;
/*  50 */     if (key.equals("actor"))
/*  51 */       e = this.node.getChildAt(5).children();
/*  52 */     else if (key.equals("scene"))
/*  53 */       e = this.node.getChildAt(6).children();
/*  54 */     else if (key.equals("timeline"))
/*  55 */       e = this.node.getChildAt(4).children();
/*  56 */     else if (key.equals("image"))
/*  57 */       e = this.node.getChildAt(0).children();
/*  58 */     else if (key.equals("sprite"))
/*  59 */       e = this.node.getChildAt(1).children();
/*  60 */     else if (key.equals("tileset"))
/*  61 */       e = this.node.getChildAt(2).children();
/*  62 */     else if (key.equals("sound"))
/*  63 */       e = this.node.getChildAt(3).children();
/*  64 */     else if (key.equals("class")) {
/*  65 */       e = this.node.getChildAt(7).children();
/*     */     }
/*  67 */     return e;
/*     */   }
/*     */ 
/*     */   public Folder getFolderFor(String key) {
/*  71 */     if (key.equals("actor"))
/*  72 */       return (Folder)((ObjectNode)this.node.getChildAt(5)).object;
/*  73 */     if (key.equals("scene"))
/*  74 */       return (Folder)((ObjectNode)this.node.getChildAt(6)).object;
/*  75 */     if (key.equals("timeline"))
/*  76 */       return (Folder)((ObjectNode)this.node.getChildAt(4)).object;
/*  77 */     if (key.equals("image"))
/*  78 */       return (Folder)((ObjectNode)this.node.getChildAt(0)).object;
/*  79 */     if (key.equals("sprite"))
/*  80 */       return (Folder)((ObjectNode)this.node.getChildAt(1)).object;
/*  81 */     if (key.equals("tileset"))
/*  82 */       return (Folder)((ObjectNode)this.node.getChildAt(2)).object;
/*  83 */     if (key.equals("sound"))
/*  84 */       return (Folder)((ObjectNode)this.node.getChildAt(3)).object;
/*  85 */     if (key.equals("class")) {
/*  86 */       return (Folder)((ObjectNode)this.node.getChildAt(7)).object;
/*     */     }
/*  88 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean validOfType(GObject obj, String key) {
/*  92 */     Vector v = this.childNodes;
/*  93 */     if (key.equals("parent"))
/*  94 */       return v.contains(obj);
/*  95 */     if (v.contains(obj)) {
/*  96 */       return false;
/*     */     }
/*     */ 
/*  99 */     if ((obj instanceof GFile)) {
/* 100 */       GFile f = (GFile)obj;
/* 101 */       if ((f.type.equals("actor")) || (f.type.equals("scene")) || (f.type.equals("timeline")) || (f.type.equals("sprite")) || (f.type.equals("tileset")))
/*     */       {
/* 103 */         return key.equals(f.type);
/*     */       }
/* 105 */       if (key.equals("image"))
/* 106 */         return (f.type.equals("png")) || (f.type.equals("gif")) || (f.type.equals("jpg"));
/* 107 */       if (key.equals("class")) {
/* 108 */         return (f.type.equals("egml")) || (f.type.equals("gcl")) || (f.type.equals("struct")) || (f.type.equals("gs"));
/*     */       }
/* 110 */       return false;
/*     */     }
/* 112 */     if ((obj instanceof Group)) {
/* 113 */       if (key.equals("actor"))
/* 114 */         return obj instanceof ActorGroup;
/* 115 */       if (key.equals("scene"))
/* 116 */         return obj instanceof SceneGroup;
/* 117 */       if (key.equals("sprite"))
/* 118 */         return obj instanceof SpriteGroup;
/* 119 */       if (key.equals("timeline"))
/* 120 */         return obj instanceof TimelineGroup;
/* 121 */       if (key.equals("tileset"))
/* 122 */         return obj instanceof TilesetGroup;
/* 123 */       if (key.equals("image"))
/* 124 */         return obj instanceof ImageGroup;
/* 125 */       if (key.equals("class"))
/* 126 */         return obj instanceof EGMLGroup;
/* 127 */       if (key.equals("sound"))
/* 128 */         return obj instanceof SoundGroup;
/*     */     }
/* 130 */     return false;
/*     */   }
/*     */ 
/*     */   public Folder magicAddition(String file)
/*     */   {
/*     */     try {
/* 136 */       if ((file.equals("png")) || (file.equals("gif")) || (file.equals("jpg")))
/* 137 */         return findFolder("$209");
/* 138 */       if (file.equals("sprite"))
/* 139 */         return findFolder("$210");
/* 140 */       if (file.equals("tileset"))
/* 141 */         return findFolder("$211");
/* 142 */       if (file.equals("actor"))
/* 143 */         return findFolder("$214");
/* 144 */       if (file.equals("scene"))
/* 145 */         return findFolder("$215");
/* 146 */       //if ((file.equals("egml")) || (file.equals("gcl")) || (file.equals("struct")) || (file.equals("gs")))
/* 147 */         //return findFolder("$216");
/* 148 */       if ((file.equals("mp3")) || (file.equals("ogg")) || (file.equals("wav")) || (file.equals("mid")) || (file.equals("midi")))
/*     */       {
/* 150 */         return findFolder("$212");
/* 151 */       }if (file.equals("timeline"))
/* 152 */         return findFolder("$213");
/* 153 */       //return findFolder("$217");
/*     */     } catch (Exception e) {
/*     */     }
/* 156 */     return null;
/*     */   }
/*     */ 
/*     */   public Folder magicAddition(Group folder)
/*     */   {
/*     */     try {
/* 162 */       if ((folder instanceof ImageGroup))
/* 163 */         return findFolder("$209");
/* 164 */       if ((folder instanceof SpriteGroup))
/* 165 */         return findFolder("$210");
/* 166 */       if ((folder instanceof ActorGroup))
/* 167 */         return findFolder("$214");
/* 168 */       if ((folder instanceof SceneGroup))
/* 169 */         return findFolder("$215");
/* 170 */       if ((folder instanceof TilesetGroup))
/* 171 */         return findFolder("$211");
/* 172 */       if ((folder instanceof SoundGroup))
/* 173 */         return findFolder("$212");
/* 174 */       if ((folder instanceof TimelineGroup))
/* 175 */         return findFolder("$213");
/* 176 */       //if ((folder instanceof EGMLGroup))
/* 177 */         //return findFolder("$216");
/* 178 */       //return findFolder("Distribution");
/*     */     } catch (Exception e) {
/*     */     }
/* 181 */     return null;
/*     */   }
/*     */ 
/*     */   private static Project balancedCreation()
/*     */   {
/* 186 */     Project project = new GameProject();
/* 187 */     project.add(new ImageGroup(project, "$209"));
/* 188 */     project.add(new SpriteGroup(project, "$210"));
/* 189 */     project.add(new TilesetGroup(project, "$211"));
/* 190 */     project.add(new SoundGroup(project, "$212"));
/* 191 */     project.add(new TimelineGroup(project, "$213"));
/* 192 */     project.add(new ActorGroup(project, "$214"));
/* 193 */     project.add(new SceneGroup(project, "$215"));
/* 194 */     //project.add(new EGMLGroup(project, "$216"));
/* 195 */     //project.add(new Group(project, "$217"));
/* 196 */     GFile a = new GFile(project, "$218", "settings", null);
/* 197 */     a.editable = false;
/* 198 */     a.value = new SettingsValues();
/* 199 */     return project;
/*     */   }
/*     */ 
/*     */   public boolean allowsFileType(String format) {
/* 203 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean allowsGroup(Group group)
/*     */   {
/* 208 */     return false;
/*     */   }
/*     */ 
/*     */   public Group newGroup(String name)
/*     */   {
/* 213 */     return null;
/*     */   }
/*     */ 
/*     */   public boolean allowsDelete(GObject o) {
/* 217 */     return false;
/*     */   }
/*     */ 
/*     */   public String getObjectType() {
/* 221 */     return "GameProject";
/*     */   }
/*     */ 
/*     */   public ImageIcon getImage()
/*     */   {
/* 227 */     return this.project_game;
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.GameProject
 * JD-Core Version:    0.6.2
 */