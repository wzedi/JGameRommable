/*    */ package org.gcreator.fileclass;
/*    */ 
/*    */ public class SceneGroup extends Group
/*    */ {
/*    */   public SceneGroup()
/*    */   {
/*    */   }
/*    */ 
/*    */   public SceneGroup(Folder root, String name)
/*    */   {
/* 22 */     super(root, name);
/*    */   }
/*    */ 
/*    */   public boolean allowsFileType(String format)
/*    */   {
/* 27 */     if (format.equals("scene"))
/* 28 */       return true;
/* 29 */     return false;
/*    */   }
/*    */ 
/*    */   public boolean allowsGroup(Group group)
/*    */   {
/* 34 */     if ((group instanceof SceneGroup))
/* 35 */       return true;
/* 36 */     return false;
/*    */   }
/*    */ 
/*    */   public Group newGroup(String name)
/*    */   {
/* 41 */     Group group = new SceneGroup(this, name);
/* 42 */     add(group);
/* 43 */     return group;
/*    */   }
/*    */ 
/*    */   public String getObjectType() {
/* 47 */     return "SceneGroup";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.SceneGroup
 * JD-Core Version:    0.6.2
 */