/*    */ package org.gcreator.components;
/*    */ 
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JScrollPane;
/*    */ import javax.swing.JTabbedPane;

/*    */ import org.gcreator.managers.LangSupporter;
/*    */ import org.jdesktop.layout.GroupLayout;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ProjectTypes extends JPanel
/*    */ {
/*    */   public GameProjects gmpro;
/*    */   //public ModulesProjects modpro;
/*    */   public NewProject npro;
/*    */   private JScrollPane jScrollPane1;
/*    */   //private JScrollPane jScrollPane2;
/*    */   public JTabbedPane jTabbedPane1;
/*    */ 
/*    */   public ProjectTypes(NewProject npro)
/*    */   {
/* 27 */     initComponents();
/* 28 */     this.npro = npro;
/* 29 */     this.gmpro = new GameProjects(this);
/* 30 */     //this.modpro = new ModulesProjects(this);
/* 31 */     this.gmpro.tnum = 1;
/* 32 */     //this.modpro.tnum = 0;
/*    */ 
/* 37 */     this.jScrollPane1.setViewportView(this.gmpro);
/* 38 */     //this.jScrollPane2.setViewportView(this.modpro);
/*    */   }
/*    */ 
/*    */   public int getProjectType()
/*    */   {
/* 46 */     if (this.gmpro.getSelectedProject() != -1)
/* 47 */       return this.gmpro.getSelectedProject();
/* 48 */     //if (this.modpro.getSelectedProject() != -1) {
/* 49 */       //return this.modpro.getSelectedProject();
/*    */     //}
/*    */ 
/* 54 */     return -1;
/*    */   }
/*    */ 
/*    */   public JTabbedPane getTabbedPane() {
/* 58 */     return this.jTabbedPane1;
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 69 */     this.jTabbedPane1 = new JTabbedPane();
/* 70 */     this.jScrollPane1 = new JScrollPane();
/* 71 */     //this.jScrollPane2 = new JScrollPane();
/*    */ 
/* 73 */     this.jScrollPane1.setHorizontalScrollBarPolicy(31);
/* 74 */     this.jTabbedPane1.addTab(LangSupporter.activeLang.getEntry(56), this.jScrollPane1);
/*    */ 
/* 76 */     //this.jScrollPane2.setHorizontalScrollBarPolicy(31);
/* 77 */     //this.jTabbedPane1.addTab(LangSupporter.activeLang.getEntry(206), this.jScrollPane2);
/*    */ 
/* 79 */     GroupLayout layout = new GroupLayout(this);
/* 80 */     setLayout(layout);
/* 81 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(this.jTabbedPane1, -1, 260, 32767));
/*    */ 
/* 85 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(this.jTabbedPane1, -1, 174, 32767));
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.ProjectTypes
 * JD-Core Version:    0.6.2
 */