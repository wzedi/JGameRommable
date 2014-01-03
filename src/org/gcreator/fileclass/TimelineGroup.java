/*    */ package org.gcreator.fileclass;
/*    */ 
/*    */ public class TimelineGroup extends Group
/*    */ {
/*    */   public TimelineGroup()
/*    */   {
/*    */   }
/*    */ 
/*    */   public TimelineGroup(Folder root, String name)
/*    */   {
/* 18 */     super(root, name);
/*    */   }
/*    */ 
/*    */   public boolean allowsFileType(String format) {
/* 22 */     if (format.equals("timeline"))
/* 23 */       return true;
/* 24 */     return false;
/*    */   }
/*    */ 
/*    */   public boolean allowsGroup(Group group) {
/* 28 */     if ((group instanceof TimelineGroup))
/* 29 */       return true;
/* 30 */     return false;
/*    */   }
/*    */ 
/*    */   public Group newGroup(String name) {
/* 34 */     Group group = new TimelineGroup(this, name);
/* 35 */     add(group);
/* 36 */     return group;
/*    */   }
/*    */ 
/*    */   public String getObjectType() {
/* 40 */     return "TimelineGroup";
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.TimelineGroup
 * JD-Core Version:    0.6.2
 */