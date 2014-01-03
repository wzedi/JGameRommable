/*     */ package org.gcreator.components.impl;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.Graphics;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTree;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.tree.DefaultMutableTreeNode;
/*     */ import javax.swing.tree.TreeCellRenderer;
/*     */ import org.gcreator.core.Aurwindow;
/*     */ import org.gcreator.core.gcreator;
/*     */ import org.gcreator.fileclass.Folder;
/*     */ import org.gcreator.fileclass.GFile;
/*     */ import org.gcreator.fileclass.GObject;
/*     */ import org.gcreator.fileclass.Group;
/*     */ import org.gcreator.fileclass.Project;
/*     */ import org.gcreator.managers.LangSupporter;
/*     */ import org.gcreator.units.Dictionary;
/*     */ import org.gcreator.units.ObjectNode;
/*     */ 
/*     */ public class WorkspaceCellRenderer extends JLabel
/*     */   implements TreeCellRenderer
/*     */ {
/*     */   private boolean bSelected;
/*     */   private boolean isCurProject;
/*     */   boolean logfileDeleted;
/*     */   public ImageIcon workspace;
/*     */   public ImageIcon text;
/*     */   public ImageIcon image;
/*     */   public ImageIcon java;
/*     */   public ImageIcon actor;
/*     */   public ImageIcon tileset;
/*     */   public ImageIcon sprite;
/*     */   public ImageIcon GCL;
/*     */   public ImageIcon script;
/*     */   public ImageIcon timeline;
/*     */   public ImageIcon scene;
/*     */   public ImageIcon img;
/*     */   public ImageIcon sound;
/*     */   public ImageIcon settings;
/* 110 */   boolean edition = false;
/* 111 */   String val = "";
/*     */ 
/*     */   public WorkspaceCellRenderer()
/*     */   {
/*  47 */     this.workspace = new ImageIcon(getClass().getResource("/org/gcreator/resources/tree/workspace.png"));
/*  48 */     this.text = new ImageIcon(getClass().getResource("/org/gcreator/resources/tree/text.png"));
/*  49 */     this.image = new ImageIcon(getClass().getResource("/org/gcreator/resources/tree/img.png"));
/*  50 */     this.java = new ImageIcon(getClass().getResource("/org/gcreator/resources/tree/java.png"));
/*  51 */     this.actor = new ImageIcon(getClass().getResource("/org/gcreator/resources/tree/actor.png"));
/*  52 */     this.tileset = new ImageIcon(getClass().getResource("/org/gcreator/resources/tree/tile.png"));
/*  53 */     this.sprite = new ImageIcon(getClass().getResource("/org/gcreator/resources/tree/sprite.png"));
/*  54 */     this.GCL = new ImageIcon(getClass().getResource("/org/gcreator/resources/tree/class.png"));
/*  55 */     this.script = new ImageIcon(getClass().getResource("/org/gcreator/resources/tree/script.png"));
/*  56 */     this.timeline = new ImageIcon(getClass().getResource("/org/gcreator/resources/tree/timeline.png"));
/*  57 */     this.scene = new ImageIcon(getClass().getResource("/org/gcreator/resources/tree/scene.png"));
/*  58 */     this.img = new ImageIcon(getClass().getResource("/org/gcreator/resources/tree/img.png"));
/*  59 */     this.sound = new ImageIcon(getClass().getResource("/org/gcreator/resources/tree/sound.png"));
/*  60 */     this.settings = new ImageIcon(getClass().getResource("/org/gcreator/resources/tree/settings.png"));
/*     */   }
/*     */ 
/*     */   public ImageIcon getImageFor(ObjectNode noder) {
/*  64 */     if ((noder.object instanceof Group))
/*  65 */       return (ImageIcon)UIManager.get("Tree.openIcon");
/*  66 */     if (((GFile)noder.object).type.equals("txt"))
/*  67 */       return this.text;
/*  68 */     if (((GFile)noder.object).type.equals("gif"))
/*     */     {
/*  70 */       return this.img;
/*  71 */     }if (((GFile)noder.object).type.equals("jpg"))
/*     */     {
/*  73 */       return this.img;
/*  74 */     }if (((GFile)noder.object).type.equals("png"))
/*     */     {
/*  76 */       return this.img;
/*  77 */     }if (((GFile)noder.object).type.equals("java"))
/*  78 */       return this.java;
/*  79 */     if (((GFile)noder.object).type.equals("actor"))
/*  80 */       return this.actor;
/*  81 */     if (((GFile)noder.object).type.equals("tileset"))
/*  82 */       return this.tileset;
/*  83 */     if (((GFile)noder.object).type.equals("sprite"))
/*  84 */       return this.sprite;
/*  85 */     if (((GFile)noder.object).type.equals("egml"))
/*  86 */       return this.GCL;
/*  87 */     if (((GFile)noder.object).type.equals("gcl"))
/*  88 */       return this.GCL;
/*  89 */     if (((GFile)noder.object).type.equals("gs"))
/*  90 */       return this.script;
/*  91 */     if (((GFile)noder.object).type.equals("timeline"))
/*  92 */       return this.timeline;
/*  93 */     if (((GFile)noder.object).type.equals("scene"))
/*  94 */       return this.scene;
/*  95 */     if (((GFile)noder.object).type.equals("wav"))
/*  96 */       return this.sound;
/*  97 */     if (((GFile)noder.object).type.equals("mid"))
/*  98 */       return this.sound;
/*  99 */     if (((GFile)noder.object).type.equals("settings"))
/* 100 */       return this.settings;
/* 101 */     if (UIManager.get("Tree.leafIcon") != null) {
/* 102 */       return (ImageIcon)UIManager.get("Tree.leafIcon");
/*     */     }
/* 104 */     return null;
/*     */   }
/*     */ 
/*     */   public WorkspaceCellRenderer(boolean logfileDeleted) {
/* 108 */     this.logfileDeleted = logfileDeleted;
/*     */   }
/*     */ 
/*     */   public Component getTreeCellRendererComponent(JTree tree, Object value, boolean bSelected, boolean bExpanded, boolean bLeaf, int iRow, boolean bHasFocus)
/*     */   {
/* 115 */     DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
/* 116 */     String labelText = (String)node.getUserObject();
/* 117 */     if (((node instanceof ObjectNode)) && (((ObjectNode)node).object != null)) {
/* 118 */       ObjectNode noder = (ObjectNode)node;
/*     */ 
/* 122 */       labelText = noder.object.name;
/*     */     }
/*     */ 
/* 133 */     tree.setEditable(false);
/*     */ 
/* 135 */     this.edition = tree.isEditing();
/*     */     try {
/* 137 */       if ((gcreator.window != null) && 
/* 138 */         (gcreator.window.getCurrentObject() != null))
/* 139 */         this.val = gcreator.window.getCurrentObject().node.getUserObject().toString();
/*     */     }
/*     */     catch (NullPointerException e)
/*     */     {
/*     */     }
/* 144 */     this.bSelected = bSelected;
/*     */     try {
/* 146 */       this.isCurProject = (node == gcreator.window.getCurrentProject().node);
/*     */     } catch (NullPointerException e) {
/* 148 */       this.isCurProject = false;
/*     */     }
/*     */ 
/* 151 */     if (!(node instanceof ObjectNode)) {
/* 152 */       setIcon(this.workspace);
/*     */     } else {
/* 154 */       ObjectNode noder = (ObjectNode)node;
/* 155 */       if ((noder.object instanceof GFile)) {
/* 156 */         setIcon(getImageFor(noder));
/*     */       }
/* 158 */       else if (((noder.object instanceof Folder)) && (((Folder)noder.object).getImage() != null))
/* 159 */         setIcon(((Folder)noder.object).getImage());
/* 160 */       else if (bExpanded) {
/* 161 */         if (UIManager.get("Tree.openIcon") != null)
/* 162 */           setIcon((Icon)UIManager.get("Tree.openIcon"));
/*     */         else
/* 164 */           setIcon(null);
/*     */       }
/* 166 */       else if (UIManager.get("Tree.closedIcon") != null)
/* 167 */         setIcon((Icon)UIManager.get("Tree.closedIcon"));
/*     */       else {
/* 169 */         setIcon(null);
/*     */       }
/*     */     }
/*     */     try
/*     */     {
/* 174 */       if (labelText.startsWith("$")) {
/* 175 */         labelText = LangSupporter.activeLang.getEntry(Integer.parseInt(labelText.substring(1)));
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 182 */     if ((Aurwindow.getMainProject() != null) && (node == Aurwindow.getMainProject().node))
/* 183 */       setText("<HTML><B>" + labelText);
/*     */     else {
/* 185 */       setText(labelText);
/*     */     }
/* 187 */     if (bSelected) {
/* 188 */       setForeground(UIManager.getColor("Tree.selectionForeground"));
/* 189 */       setBackground(UIManager.getColor("Tree.selectionBackground"));
/*     */     }
/*     */     else {
/* 192 */       setForeground(UIManager.getColor("Tree.textForeground"));
/* 193 */       setBackground(UIManager.getColor("Tree.textBackground"));
/*     */     }
/* 195 */     return this;
/*     */   }
/*     */ 
/*     */   public void paint(Graphics g)
/*     */   {
/* 204 */     if (!UIManager.getLookAndFeel().getClass().getName().equals("com.sun.java.swing.plaf.gtk.GTKLookAndFeel")) {
/* 205 */       g.setColor(getBackground());
/* 206 */       g.fillRect(0, 0, getWidth(), getHeight());
/*     */     }
/* 208 */     g.setColor(getForeground());
/* 209 */     super.paint(g);
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.impl.WorkspaceCellRenderer
 * JD-Core Version:    0.6.2
 */