/*    */ package org.gcreator.fileclass;
/*    */ 
/*    */ public class ActorGroup extends Group
/*    */ {
/*    */   public ActorGroup()
/*    */   {
/*    */   }
/*    */ 
/*    */   public ActorGroup(Folder root, String name)
/*    */   {
/* 22 */     super(root, name);
/*    */   }
/*    */ 
/*    */   public boolean allowsFileType(String format)
/*    */   {
/* 27 */     if (format.equals("actor"))
/* 28 */       return true;
/* 29 */     return false;
/*    */   }
/*    */ 
/*    */   public boolean allowsGroup(Group group)
/*    */   {
/* 34 */     if ((group instanceof ActorGroup))
/* 35 */       return true;
/* 36 */     return false;
/*    */   }
/*    */ 
/*    */   public Group newGroup(String name)
/*    */   {
/* 41 */     Group group = new ActorGroup(this, name);
/* 42 */     add(group);
/* 43 */     return group;
/*    */   }
/*    */ 
/*    */   public String getObjectType() {
/* 47 */     return "ActorGroup";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.ActorGroup
 * JD-Core Version:    0.6.2
 */