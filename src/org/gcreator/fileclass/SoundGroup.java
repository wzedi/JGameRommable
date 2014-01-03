/*    */ package org.gcreator.fileclass;
/*    */ 
/*    */ public class SoundGroup extends Group
/*    */ {
/*    */   public SoundGroup()
/*    */   {
/*    */   }
/*    */ 
/*    */   public SoundGroup(Folder root, String name)
/*    */   {
/* 22 */     super(root, name);
/*    */   }
/*    */ 
/*    */   public boolean allowsFileType(String format)
/*    */   {
/* 27 */     if ((format.equals("wav")) || (format.equals("mid")))
/* 28 */       return true;
/* 29 */     return false;
/*    */   }
/*    */ 
/*    */   public boolean allowsGroup(Group group)
/*    */   {
/* 34 */     if ((group instanceof SoundGroup))
/* 35 */       return true;
/* 36 */     return false;
/*    */   }
/*    */ 
/*    */   public Group newGroup(String name)
/*    */   {
/* 41 */     Group group = new SoundGroup(this, name);
/* 42 */     add(group);
/* 43 */     return group;
/*    */   }
/*    */ 
/*    */   public String getObjectType() {
/* 47 */     return "SoundGroup";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.SoundGroup
 * JD-Core Version:    0.6.2
 */