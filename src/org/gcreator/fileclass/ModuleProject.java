/*    */ package org.gcreator.fileclass;
/*    */ 
/*    */ import java.util.Enumeration;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.tree.TreeNode;
/*    */ import org.gcreator.units.ObjectNode;
/*    */ 
/*    */ public class ModuleProject extends Project
/*    */ {
/* 17 */   public int classes = 1;
/* 18 */   public int scripts = 1;
/*    */ 
/* 87 */   private ImageIcon project_module = new ImageIcon(getClass().getResource("/org/gcreator/resources/extension.png"));
/*    */ 
/*    */   public ModuleProject(String name, String location)
/*    */   {
/* 21 */     super(name, location);
/*    */   }
/*    */   public ModuleProject() {
/*    */   }
/*    */ 
/*    */   public String getType() {
/* 27 */     return "Module";
/*    */   }
/*    */ 
/*    */   public static ModuleProject balance() {
/* 31 */     return (ModuleProject)balancedCreation();
/*    */   }
/*    */ 
/*    */   public Enumeration getEnum(String key) {
/* 35 */     Enumeration e = null;
/* 36 */     if (key.equals("class")) {
/* 37 */       e = this.node.getChildAt(0).children();
/*    */     }
/* 39 */     return e;
/*    */   }
/*    */ 
/*    */   public Folder magicAddition(String file)
/*    */   {
/*    */     try {
/* 45 */       if ((file.equals("egml")) || (file.equals("gcl")) || (file.equals("struct")) || (file.equals("gs")))
/* 46 */         return findFolder("$216");
/*    */     } catch (Exception e) {
/*    */     }
/* 49 */     return null;
/*    */   }
/*    */ 
/*    */   public Folder magicAddition(Group g) {
/*    */     try {
/* 54 */       if ((g instanceof EGMLGroup))
/* 55 */         return findFolder("$216");
/*    */     } catch (Exception e) {
/*    */     }
/* 58 */     return null;
/*    */   }
/*    */ 
/*    */   private static Project balancedCreation() {
/* 62 */     Project project = new ModuleProject();
/* 63 */     project.add(new EGMLGroup(project, "$216"));
/* 64 */     return project;
/*    */   }
/*    */ 
/*    */   public boolean allowsFileType(String format) {
/* 68 */     return false;
/*    */   }
/*    */ 
/*    */   public boolean allowsGroup(Group group) {
/* 72 */     return false;
/*    */   }
/*    */ 
/*    */   public Group newGroup(String name) {
/* 76 */     return null;
/*    */   }
/*    */ 
/*    */   public boolean allowsDelete(Object o) {
/* 80 */     return false;
/*    */   }
/*    */ 
/*    */   public String getObjectType() {
/* 84 */     return "ModuleProject";
/*    */   }
/*    */ 
/*    */   public ImageIcon getImage()
/*    */   {
/* 90 */     return this.project_module;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.ModuleProject
 * JD-Core Version:    0.6.2
 */