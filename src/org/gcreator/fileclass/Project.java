/*    */ package org.gcreator.fileclass;
/*    */ 
/*    */ import java.util.Enumeration;
/*    */ import java.util.Vector;
/*    */ import javax.swing.tree.DefaultMutableTreeNode;
/*    */ import org.gcreator.exceptions.NoSuchFolderException;
/*    */ 
/*    */ public class Project extends Folder
/*    */ {
/* 30 */   public String location = "";
/*    */   public DefaultMutableTreeNode froot;
/*    */ 
/*    */   public Project()
/*    */   {
/* 40 */     super(null);
/*    */   }
/*    */ 
/*    */   public Project(String name, String location) {
/* 44 */     super(name);
/* 45 */     this.location = location;
/*    */   }
/*    */ 
/*    */   public String getType() {
/* 49 */     return null;
/*    */   }
/*    */ 
/*    */   public static Project balance() {
/* 53 */     return new Project();
/*    */   }
/*    */ 
/*    */   public String getObjectType() {
/* 57 */     return "Project";
/*    */   }
/*    */ 
/*    */   public Enumeration getEnum(String key) {
/* 61 */     return null;
/*    */   }
/*    */ 
/*    */   public boolean validOfType(GObject obj, String key) {
/* 65 */     return true;
/*    */   }
/*    */ 
/*    */   public Folder getFolderFor(String key) {
/* 69 */     return null;
/*    */   }
/*    */ 
/*    */   public Folder findFolder(String name) throws NoSuchFolderException {
/* 73 */     if (name == null)
/* 74 */       throw new NoSuchFolderException();
/* 75 */     if ((name.equals("")) || (name.equals("/")))
/* 76 */       return this;
/* 77 */     if (name.charAt(0) == '/')
/* 78 */       name = name.substring(1);
/* 79 */     for (int i = 0; i < this.childNodes.size(); i++) {
/* 80 */       Object o = this.childNodes.get(i);
/* 81 */       if ((o != null) && ((o instanceof Folder)))
/*    */         try {
/* 83 */           return ((Folder)o).findFolder(name.substring(name.indexOf(name)));
/*    */         }
/*    */         catch (NoSuchFolderException e)
/*    */         {
/*    */         }
/*    */     }
/* 89 */     throw new NoSuchFolderException("Project");
/*    */   }
/*    */ 
/*    */   public Project getProject() {
/* 93 */     return this;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.Project
 * JD-Core Version:    0.6.2
 */