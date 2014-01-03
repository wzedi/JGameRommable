/*    */ package org.gcreator.components.popupmenus;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JCheckBoxMenuItem;
/*    */ import javax.swing.JPopupMenu;
/*    */ import javax.swing.JToggleButton;
/*    */ import org.gcreator.components.ScenePanel;
/*    */ import org.gcreator.editors.SceneEditor;
/*    */ import org.gcreator.fileclass.GFile;
/*    */ import org.gcreator.fileclass.res.Scene;
/*    */ 
/*    */ public class ScenePopupMenu extends JPopupMenu
/*    */ {
/*    */   public JCheckBoxMenuItem grid;
/*    */   private SceneEditor res;
/*    */ 
/*    */   public ScenePopupMenu(SceneEditor res)
/*    */   {
/* 28 */     this.res = res;
/* 29 */     this.grid = new JCheckBoxMenuItem("Display grid");
/* 30 */     this.grid.setSelected(((Scene)res.file.value).grid);
/* 31 */     this.grid.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent evt) {
/* 33 */         ScenePopupMenu.this.grid();
/*    */       }
/*    */     });
/* 36 */     add(this.grid);
/* 37 */     updateUI();
/*    */   }
/*    */   public void setVisible(boolean v) {
/* 40 */     if (v == true)
/* 41 */       this.grid.setSelected(((Scene)this.res.file.value).grid);
/* 42 */     super.setVisible(v);
/*    */   }
/*    */   public void grid() {
/* 45 */     ((Scene)this.res.file.value).grid = this.grid.isSelected();
/* 46 */     this.res.jToggleButton1.setSelected(this.grid.isSelected());
/* 47 */     this.res.scene.updateUI();
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.popupmenus.ScenePopupMenu
 * JD-Core Version:    0.6.2
 */