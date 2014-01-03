/*    */ package org.gcreator.fileclass;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class Group extends Folder
/*    */   implements Serializable
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/*    */   public Folder root;
/*    */ 
/*    */   public Group()
/*    */   {
/* 22 */     super("");
/*    */   }
/*    */ 
/*    */   public Group(Folder root, String name) {
/* 26 */     super(name);
/* 27 */     this.root = root;
/*    */   }
/*    */ 
/*    */   public Folder magicAddition(String type) {
/* 31 */     if (allowsFileType(type))
/* 32 */       return this;
/* 33 */     return this.root.magicAddition(type);
/*    */   }
/*    */ 
/*    */   public Folder magicAddition(Group folder) {
/* 37 */     if (allowsGroup(folder))
/* 38 */       return this;
/* 39 */     return this.root.magicAddition(folder);
/*    */   }
/*    */ 
/*    */   public Group newGroup(String name) {
/* 43 */     Group group = new Group(this, name);
/* 44 */     add(group);
/* 45 */     return group;
/*    */   }
/*    */ 
/*    */   public String getObjectType()
/*    */   {
/* 50 */     return "Group";
/*    */   }
/*    */ 
/*    */   public String getPath()
/*    */   {
/* 55 */     return this.root.getPath() + "/" + super.getPath();
/*    */   }
/*    */ 
/*    */   public Project getProject() {
/* 59 */     return this.root.getProject();
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.Group
 * JD-Core Version:    0.6.2
 */