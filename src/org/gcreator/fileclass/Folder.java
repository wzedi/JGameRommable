/*     */ package org.gcreator.fileclass;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Vector;
/*     */ import javax.swing.ImageIcon;
/*     */ import org.gcreator.exceptions.NoSuchFolderException;
/*     */ 
/*     */ public class Folder extends GObject
/*     */   implements Serializable
/*     */ {
/*     */   protected Vector<GObject> childNodes;
/*     */   static final long serialVersionUID = 1L;
/*     */ 
/*     */   public Folder()
/*     */   {
/*     */   }
/*     */ 
/*     */   public Folder(String name)
/*     */   {
/*  28 */     super(name);
/*  29 */     this.childNodes = new Vector();
/*     */   }
/*     */ 
/*     */   public Vector getChildren() {
/*  33 */     return this.childNodes;
/*     */   }
/*     */ 
/*     */   public boolean add(GObject node) {
/*  37 */     int i = 0;
/*  38 */     return this.childNodes.add(node);
/*     */   }
/*     */ 
/*     */   public Folder magicAddition(GFile file)
/*     */   {
/*  43 */     return magicAddition(file.type);
/*     */   }
/*     */ 
/*     */   public Folder magicAddition(String type)
/*     */   {
/*  48 */     if (allowsFileType(type))
/*  49 */       return this;
/*  50 */     return null;
/*     */   }
/*     */ 
/*     */   public Folder magicAddition(Group folder) {
/*  54 */     if (allowsGroup(folder))
/*  55 */       return this;
/*  56 */     return null;
/*     */   }
/*     */ 
/*     */   public int find(GObject search) {
/*  60 */     if (this.childNodes == null)
/*  61 */       return -1;
/*  62 */     for (int i = 0; i < this.childNodes.size(); i++)
/*  63 */       if (this.childNodes.get(i) == search)
/*  64 */         return i;
/*  65 */     return -1;
/*     */   }
/*     */ 
/*     */   public int findFromName(String search) {
/*  69 */     if (this.childNodes == null)
/*  70 */       return -1;
/*  71 */     for (int i = 0; i < this.childNodes.size(); i++)
/*  72 */       if ((this.childNodes.get(i) != null) && (((GObject)this.childNodes.get(i)).name.equals(search)))
/*  73 */         return i;
/*  74 */     return -1;
/*     */   }
/*     */ 
/*     */   public GObject childAt(int pos) {
/*  78 */     return (GObject)this.childNodes.get(pos);
/*     */   }
/*     */ 
/*     */   public int getChildNum() {
/*  82 */     int num = 0;
/*  83 */     for (int i = 0; i < this.childNodes.size(); i++)
/*  84 */       if (this.childNodes.get(i) != null)
/*  85 */         num++;
/*  86 */     return num;
/*     */   }
/*     */ 
/*     */   public int getChildArrayNum() {
/*  90 */     return this.childNodes.size();
/*     */   }
/*     */ 
/*     */   public boolean allowsFileType(String format) {
/*  94 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean allowsGroup(Group group) {
/*  98 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean allowsDelete(GObject o) {
/* 102 */     return true;
/*     */   }
/*     */ 
/*     */   public void remove(GObject o) {
/* 106 */     this.childNodes.remove(o);
/*     */   }
/*     */ 
/*     */   public Group newGroup(String name) {
/* 110 */     Group group = new Group(this, name);
/* 111 */     add(group);
/* 112 */     return group;
/*     */   }
/*     */ 
/*     */   public Folder findFolder(String name) throws NoSuchFolderException {
/* 116 */     if (name == null)
/* 117 */       throw new NoSuchFolderException();
/* 118 */     if ((name.equals("")) || (name.equals("/")))
/* 119 */       return this;
/* 120 */     if (name.charAt(0) == '/')
/* 121 */       name = name.substring(1);
/* 122 */     if (name.indexOf("/") == -1) {
/* 123 */       if (!name.equals(this.name)) {
/* 124 */         throw new NoSuchFolderException();
/*     */       }
/* 126 */       return this;
/*     */     }
/*     */ 
/* 129 */     if (!name.substring(name.indexOf("/")).equals(name))
/* 130 */       throw new NoSuchFolderException();
/* 131 */     for (int i = 0; i < this.childNodes.size(); i++) {
/* 132 */       GObject o = (GObject)this.childNodes.get(i);
/* 133 */       if ((o != null) && ((o instanceof Folder)))
/*     */         try {
/* 135 */           return ((Folder)o).findFolder(name.substring(name.indexOf(name)));
/*     */         }
/*     */         catch (NoSuchFolderException e)
/*     */         {
/*     */         }
/*     */     }
/* 141 */     throw new NoSuchFolderException("Folder");
/*     */   }
/*     */ 
/*     */   public String getObjectType()
/*     */   {
/* 146 */     return "Folder";
/*     */   }
/*     */ 
/*     */   public ImageIcon getImage() {
/* 150 */     return null;
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.Folder
 * JD-Core Version:    0.6.2
 */