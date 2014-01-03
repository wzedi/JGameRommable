/*    */ package org.gcreator.fileclass;
/*    */ 
/*    */ public class TilesetGroup extends Group
/*    */ {
/*    */   public TilesetGroup()
/*    */   {
/*    */   }
/*    */ 
/*    */   public TilesetGroup(Folder root, String name)
/*    */   {
/* 18 */     super(root, name);
/*    */   }
/*    */ 
/*    */   public boolean allowsFileType(String format)
/*    */   {
/* 23 */     if (format.equals("tileset"))
/* 24 */       return true;
/* 25 */     return false;
/*    */   }
/*    */ 
/*    */   public boolean allowsGroup(Group group)
/*    */   {
/* 30 */     if ((group instanceof TilesetGroup))
/* 31 */       return true;
/* 32 */     return false;
/*    */   }
/*    */ 
/*    */   public Group newGroup(String name)
/*    */   {
/* 37 */     Group group = new TilesetGroup(this, name);
/* 38 */     add(group);
/* 39 */     return group;
/*    */   }
/*    */ 
/*    */   public String getObjectType() {
/* 43 */     return "TilesetGroup";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.TilesetGroup
 * JD-Core Version:    0.6.2
 */