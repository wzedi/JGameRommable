/*    */ package org.gcreator.macro;
/*    */ 
/*    */ import org.gcreator.components.WorkspaceTree;
/*    */ import org.gcreator.core.Aurwindow;
/*    */ import org.gcreator.core.gcreator;
/*    */ import org.gcreator.fileclass.GameProject;
/*    */ import org.gcreator.fileclass.Project;
/*    */ import org.gcreator.managers.ProjectTree;
/*    */ 
/*    */ public class NewProjectAction
/*    */   implements MacroAction
/*    */ {
/*    */   private String name;
/*    */ 
/*    */   public NewProjectAction(String name)
/*    */   {
/* 19 */     this.name = name;
/*    */   }
/*    */   public String getName() {
/* 22 */     return this.name;
/*    */   }
/*    */   public void setName(String name) {
/* 25 */     this.name = name;
/*    */   }
/*    */   public void play() {
/* 28 */     Project project = GameProject.balance();
/* 29 */     project.name = this.name;
/* 30 */     project.location = "";
/* 31 */     Aurwindow.setMainProject(project);
/* 32 */     if (project != null)
/* 33 */       ProjectTree.importFolderToTree(project, gcreator.window.top);
/*    */     try {
/* 35 */       Aurwindow.workspace.updateUI();
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/*    */     }
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.macro.NewProjectAction
 * JD-Core Version:    0.6.2
 */