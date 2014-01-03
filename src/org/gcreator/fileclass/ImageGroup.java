/*    */ package org.gcreator.fileclass;
/*    */ 
/*    */ public class ImageGroup extends Group
/*    */ {
/*    */   public ImageGroup()
/*    */   {
/*    */   }
/*    */ 
/*    */   public ImageGroup(Folder root, String name)
/*    */   {
/* 25 */     super(root, name);
/*    */   }
/*    */ 
/*    */   public boolean allowsFileType(String format)
/*    */   {
/* 30 */     if ((format.equals("gif") | format.equals("jpg") | format.equals("png")))
/* 31 */       return true;
/* 32 */     return false;
/*    */   }
/*    */ 
/*    */   public boolean allowsGroup(Group group)
/*    */   {
/* 37 */     if ((group instanceof ImageGroup))
/* 38 */       return true;
/* 39 */     return false;
/*    */   }
/*    */ 
/*    */   public Group newGroup(String name)
/*    */   {
/* 44 */     Group group = new ImageGroup(this, name);
/* 45 */     add(group);
/* 46 */     return group;
/*    */   }
/*    */ 
/*    */   public String getObjectType() {
/* 50 */     return "ImageGroup";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.ImageGroup
 * JD-Core Version:    0.6.2
 */