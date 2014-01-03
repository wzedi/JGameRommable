/*    */ package org.gcreator.fileclass;
/*    */ 
/*    */ import javax.swing.ImageIcon;
/*    */ import org.gcreator.managers.FilesFinder;
/*    */ 
/*    */ public class ExtensionProject extends Project
/*    */ {
/* 60 */   private ImageIcon img = new ImageIcon(getClass().getResource("/org/gcreator/resources/extension.png"));
/*    */ 
/*    */   public ExtensionProject(String name, String location)
/*    */   {
/* 21 */     super(name, location);
/*    */   }
/*    */ 
/*    */   public ExtensionProject() {
/*    */   }
/*    */ 
/*    */   public boolean allowsFileType(String format) {
/* 28 */     return false;
/*    */   }
/*    */ 
/*    */   public boolean allowsGroup(Group group)
/*    */   {
/* 33 */     return false;
/*    */   }
/*    */ 
/*    */   public String getType()
/*    */   {
/* 38 */     return "Extension";
/*    */   }
/*    */ 
/*    */   public String getObjectType() {
/* 42 */     return "ExtensionProject";
/*    */   }
/*    */ 
/*    */   public Group newGroup(String name)
/*    */   {
/* 47 */     Group group = new Group(this, name);
/* 48 */     add(group);
/* 49 */     return group;
/*    */   }
/*    */ 
/*    */   public GFile[] getJavaFiles() {
/* 53 */     return FilesFinder.getFilesAt(this, "java");
/*    */   }
/*    */ 
/*    */   public GFile[] getCppFiles() {
/* 57 */     return FilesFinder.getFilesAt(this, "cpp");
/*    */   }
/*    */ 
/*    */   public ImageIcon getImage()
/*    */   {
/* 63 */     return this.img;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.ExtensionProject
 * JD-Core Version:    0.6.2
 */