/*    */ package org.gcreator.components.resource;
/*    */ 
/*    */ import javax.swing.Icon;
/*    */ import javax.swing.JMenu;
/*    */ import org.gcreator.components.WorkspaceTree;
/*    */ import org.gcreator.components.impl.WorkspaceCellRenderer;
/*    */ import org.gcreator.core.Aurwindow;
/*    */ import org.gcreator.fileclass.Folder;
/*    */ 
/*    */ public class FolderMenuItem extends JMenu
/*    */ {
/* 18 */   public Folder file = null;
/*    */ 
/*    */   public String getText()
/*    */   {
/* 24 */     if (this.file == null)
/* 25 */       return "<none>";
/* 26 */     return this.file.name;
/*    */   }
/*    */ 
/*    */   public Icon getIcon() {
/* 30 */     if (this.file == null)
/* 31 */       return null;
/* 32 */     return ((WorkspaceCellRenderer)Aurwindow.workspace.getCellRenderer()).getImageFor(this.file.node);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.resource.FolderMenuItem
 * JD-Core Version:    0.6.2
 */