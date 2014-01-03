/*    */ package org.gcreator.components.resource;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.Icon;
/*    */ import javax.swing.JMenuItem;
/*    */ import org.gcreator.components.WorkspaceTree;
/*    */ import org.gcreator.components.impl.WorkspaceCellRenderer;
/*    */ import org.gcreator.components.popupmenus.CollisionListPopup;
/*    */ import org.gcreator.core.Aurwindow;
/*    */ import org.gcreator.fileclass.GFile;
/*    */ 
/*    */ public class FileMenuItem extends JMenuItem
/*    */   implements ActionListener
/*    */ {
/* 20 */   public GFile file = null;
/* 21 */   private FileLabel l = null;
/* 22 */   private CollisionListPopup p = null;
/*    */ 
/*    */   public FileMenuItem(FileLabel l) {
/* 25 */     this.l = l;
/* 26 */     addActionListener(this);
/*    */   }
/*    */ 
/*    */   public FileMenuItem(CollisionListPopup p)
/*    */   {
/* 31 */     this.p = p;
/* 32 */     addActionListener(this);
/*    */   }
/*    */ 
/*    */   public void actionPerformed(ActionEvent evt) {
/* 36 */     if (this.l != null)
/* 37 */       this.l.setFile(this.file, true);
/* 38 */     if (this.p != null)
/* 39 */       this.p.done(this.file);
/*    */   }
/*    */ 
/*    */   public String getText() {
/* 43 */     if (this.file == null)
/* 44 */       return "<none>";
/* 45 */     return this.file.name;
/*    */   }
/*    */ 
/*    */   public Icon getIcon() {
/* 49 */     if (this.file == null)
/* 50 */       return null;
/* 51 */     return ((WorkspaceCellRenderer)Aurwindow.workspace.getCellRenderer()).getImageFor(this.file.node);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.resource.FileMenuItem
 * JD-Core Version:    0.6.2
 */