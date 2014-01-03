/*    */ package org.gcreator.fileclass;
/*    */ 
/*    */ public class JavaRefGroup extends Group
/*    */ {
/*    */   public JavaRefGroup()
/*    */   {
/*    */   }
/*    */ 
/*    */   public JavaRefGroup(Folder root, String name)
/*    */   {
/* 22 */     super(root, name);
/*    */   }
/*    */ 
/*    */   public boolean allowsFileType(String format)
/*    */   {
/* 27 */     if (format.equals("class"))
/* 28 */       return true;
/* 29 */     return false;
/*    */   }
/*    */ 
/*    */   public boolean allowsGroup(Group group)
/*    */   {
/* 34 */     return false;
/*    */   }
/*    */ 
/*    */   public Group newGroup(String name)
/*    */   {
/* 39 */     Group group = new JavaGroup(this, name);
/* 40 */     add(group);
/* 41 */     return group;
/*    */   }
/*    */ 
/*    */   public String getObjectType() {
/* 45 */     return "JavaRefGroup";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.JavaRefGroup
 * JD-Core Version:    0.6.2
 */