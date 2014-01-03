/*    */ package org.gcreator.fileclass;
/*    */ 
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ public class PackageProject extends Project
/*    */ {
/* 34 */   private ImageIcon img = new ImageIcon(getClass().getResource("/org/gcreator/resources/package.png"));
/*    */ 
/*    */   public PackageProject(String name, String location)
/*    */   {
/* 20 */     super(name, location);
/*    */   }
/*    */ 
/*    */   public PackageProject() {
/*    */   }
/*    */ 
/*    */   public String getType() {
/* 27 */     return "Package";
/*    */   }
/*    */ 
/*    */   public String getObjectType() {
/* 31 */     return "PackageProject";
/*    */   }
/*    */ 
/*    */   public ImageIcon getImage()
/*    */   {
/* 37 */     return this.img;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.PackageProject
 * JD-Core Version:    0.6.2
 */