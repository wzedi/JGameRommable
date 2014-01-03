/*    */ package org.gcreator.editors;
/*    */ 
/*    */ import org.gcreator.components.TabPanel;
/*    */ import org.gcreator.fileclass.GFile;
/*    */ import org.gcreator.fileclass.Project;
/*    */ import org.jdesktop.layout.GroupLayout;
/*    */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*    */ 
/*    */ public class StructureEditor extends TabPanel
/*    */ {
/*    */   public StructureEditor(GFile file, Project project)
/*    */   {
/* 20 */     initComponents();
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 31 */     GroupLayout layout = new GroupLayout(this);
/* 32 */     setLayout(layout);
/* 33 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(0, 400, 32767));
/*    */ 
/* 37 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(0, 300, 32767));
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.editors.StructureEditor
 * JD-Core Version:    0.6.2
 */