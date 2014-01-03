/*    */ package org.gcreator.managers;
/*    */ 
/*    */ import javax.swing.tree.DefaultMutableTreeNode;

/*    */ import org.gcreator.core.Aurwindow;
/*    */ import org.gcreator.fileclass.Folder;
/*    */ import org.gcreator.fileclass.GFile;
/*    */ import org.gcreator.fileclass.GObject;
/*    */ import org.gcreator.fileclass.Project;
/*    */ import org.gcreator.units.ObjectNode;
/*    */ 
/*    */ 
/*    */ public class ProjectTree
/*    */ {
/*    */   public static DefaultMutableTreeNode importFolderToTree(Folder folder, DefaultMutableTreeNode root)
/*    */   {
/* 25 */     return importFolderToTree(folder, root, true);
/*    */   }
/*    */ 
/*    */   public static DefaultMutableTreeNode importFolderToTree(Folder folder, DefaultMutableTreeNode root, boolean decnew)
/*    */   {
/*    */     DefaultMutableTreeNode froot;
/* 30 */     if (decnew) {
/* 31 */       froot = new ObjectNode(folder);
/* 32 */       root.add(froot);
/*    */     }
/*    */     else {
/* 35 */       froot = root;
/* 36 */     }if ((folder instanceof Project)) {
/* 37 */       ((Project)folder).froot = froot;
/*    */     }
/*    */ 
/* 41 */     for (int i = 0; i < folder.getChildArrayNum(); i++)
/*    */     {
/*    */       GObject childNode;
/* 42 */       if ((childNode = folder.childAt(i)) != null) {
/* 43 */         DefaultMutableTreeNode node = new ObjectNode(childNode);
/* 44 */         froot.add(node);
/* 45 */         if ((childNode instanceof GFile))
/* 46 */           node.setAllowsChildren(false);
/* 47 */         if ((childNode instanceof Folder)) {
/* 48 */           importFolderToTree((Folder)childNode, node, false);
/* 49 */           node.setAllowsChildren(true);
/*    */         }
/*    */       }
/*    */     }
/*    */     try {
/* 54 */       Aurwindow.workspace.updateUI();
/*    */     } catch (Exception e) {
/*    */     }
/* 57 */     return froot;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.managers.ProjectTree
 * JD-Core Version:    0.6.2
 */