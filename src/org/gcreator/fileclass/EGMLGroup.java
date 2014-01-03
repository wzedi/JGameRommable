/*    */ package org.gcreator.fileclass;
/*    */ 
/*    */ public class EGMLGroup extends Group
/*    */ {
/*    */   public EGMLGroup()
/*    */   {
/*    */   }
/*    */ 
/*    */   public EGMLGroup(Folder root, String name)
/*    */   {
/* 22 */     super(root, name);
/*    */   }
/*    */ 
/*    */   public boolean allowsFileType(String format)
/*    */   {
/* 27 */     if ((format.equals("egml")) || (format.equals("struct")) || (format.equals("gcl")) || (format.equals("gs")))
/* 28 */       return true;
/* 29 */     return false;
/*    */   }
/*    */ 
/*    */   public boolean allowsGroup(Group group)
/*    */   {
/* 34 */     if ((group instanceof EGMLGroup))
/* 35 */       return true;
/* 36 */     return false;
/*    */   }
/*    */ 
/*    */   public Group newGroup(String name)
/*    */   {
/* 41 */     Group group = new EGMLGroup(this, name);
/* 42 */     add(group);
/* 43 */     return group;
/*    */   }
/*    */ 
/*    */   public String getObjectType() {
/* 47 */     return "EGMLGroup";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.EGMLGroup
 * JD-Core Version:    0.6.2
 */