/*    */ package org.gcreator.fileclass;
/*    */ 
/*    */ public class StaticGroup extends Group
/*    */ {
/*    */   public StaticGroup()
/*    */   {
/*    */   }
/*    */ 
/*    */   public StaticGroup(Folder root, String name)
/*    */   {
/* 22 */     super(root, name);
/*    */   }
/*    */ 
/*    */   public boolean allowsFileType(String format)
/*    */   {
/* 27 */     return false;
/*    */   }
/*    */ 
/*    */   public boolean allowsGroup(Group group)
/*    */   {
/* 32 */     return false;
/*    */   }
/*    */ 
/*    */   public boolean allowsDelete(Object o) {
/* 36 */     return false;
/*    */   }
/*    */ 
/*    */   public Group newGroup(String name) {
/* 40 */     return null;
/*    */   }
/*    */ 
/*    */   public String getObjectType() {
/* 44 */     return "StaticGroup";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.StaticGroup
 * JD-Core Version:    0.6.2
 */