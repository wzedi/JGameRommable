/*     */ package org.gcreator.components;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Vector;
/*     */ import javax.swing.AbstractButton;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTextField;
/*     */ import org.gcreator.core.Aurwindow;
/*     */ import org.gcreator.core.gcreator;
/*     */ import org.gcreator.core.utilities;
/*     */ import org.gcreator.fileclass.GameProject;
/*     */ import org.gcreator.fileclass.ModuleProject;
/*     */ import org.gcreator.fileclass.Project;
/*     */ import org.gcreator.macro.Macro;
/*     */ import org.gcreator.macro.NewProjectAction;
/*     */ import org.gcreator.managers.LangSupporter;
/*     */ import org.gcreator.managers.ProjectTree;
/*     */ import org.gcreator.units.Dictionary;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class NewProject extends TabPanel
/*     */ {
/*  31 */   public Vector ProjectButtons = new Vector();
/*     */   public JButton jButton1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   public ProjectTypes ptypes;
/*     */   public JTextField jTextField1;
/*     */ 
/*     */   public NewProject()
/*     */   {
/*  34 */     initComponents();
/*     */   }
/*     */ 
/*     */   public void uncheckAll()
/*     */   {
/*  41 */     Object[] btns = this.ProjectButtons.toArray();
/*     */ 
/*  43 */     for (int i = 0; i < btns.length; i++) {
/*  44 */       Object btn = btns[i];
/*  45 */       if ((btn != null) && ((btn instanceof AbstractButton)))
/*  46 */         ((JButton)btn).setSelected(false);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  52 */     this.jLabel1 = new JLabel();
/*  53 */     this.jLabel2 = new JLabel();
/*  54 */     this.jButton1 = new JButton();
/*  55 */     this.jTextField1 = new JTextField();
/*  56 */     this.ptypes = new ProjectTypes(this);
/*  57 */     this.jLabel3 = new JLabel();
/*     */ 
/*  59 */     this.jLabel1.setText(LangSupporter.activeLang.getEntry(54));
/*     */ 
/*  61 */     this.jLabel2.setText(LangSupporter.activeLang.getEntry(60));
/*     */ 
/*  63 */     this.jLabel3.setVisible(false);
/*     */ 
/*  65 */     this.jButton1.setText(LangSupporter.activeLang.getEntry(94));
/*  66 */     this.jButton1.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/*  69 */         NewProject.this.createProject();
/*     */       }
/*     */     });
/*  72 */     this.jTextField1.setText("");
/*     */ 
/*  74 */     this.jLabel3.setText("jLabel3");
/*     */ 
/*  76 */     GroupLayout layout = new GroupLayout(this);
/*  77 */     setLayout(layout);
/*  78 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(2, layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(2).add(this.ptypes, -1, -1, 32767).add(this.jLabel1).add(1, layout.createSequentialGroup().add(this.jLabel2).addPreferredGap(0).add(this.jTextField1, -1, 263, 32767).addPreferredGap(0).add(this.jButton1)).add(this.jLabel3)).addContainerGap()));
/*     */ 
/* 115 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jLabel1).addPreferredGap(0).add(this.ptypes, -1, -1, 32767).addPreferredGap(0).add(this.jLabel3).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jLabel2).add(this.jButton1).add(this.jTextField1, -2, -1, -2)).addContainerGap()));
/*     */   }
/*     */ 
/*     */   public int getProjectType()
/*     */   {
/* 148 */     return this.ptypes.getProjectType();
/*     */   }
/*     */ 
/*     */   public void createProject() {
/* 152 */     utilities.addStringMessage("create new project");
/* 153 */     Project project = null;
/* 154 */     int type = getProjectType();
/* 155 */     if (type == 0) {
/* 156 */       project = GameProject.balance();
/* 157 */       project.name = this.jTextField1.getText();
/* 158 */       project.location = "";
/* 159 */       Aurwindow.setMainProject(project);
/*     */     }
/* 161 */     else if (type == 1) {
/* 162 */       project = GameProject.balance();
/* 163 */       project.name = this.jTextField1.getText();
/* 164 */       project.location = "";
/* 165 */       Aurwindow.setMainProject(project);
/*     */     }
/* 167 */     else if (type == 2) {
/* 168 */       project = GameProject.balance();
/* 169 */       project.name = this.jTextField1.getText();
/* 170 */       project.location = "";
/* 171 */       Aurwindow.setMainProject(project);
/*     */     }
/* 173 */     else if (type == 3) {
/* 174 */       System.out.println("Game type 3");
/* 175 */       project = GameProject.balance();
/* 176 */       project.name = this.jTextField1.getText();
/* 177 */       project.location = "";
/* 178 */       Aurwindow.setMainProject(project);
/*     */     }
/* 180 */     else if (type == 4) {
/* 181 */       project = ModuleProject.balance();
/* 182 */       project.name = this.jTextField1.getText();
/* 183 */       project.location = "";
/* 184 */       Aurwindow.setMainProject(project);
/*     */     }
/*     */ 
/* 215 */     if (type != -1) {
/* 216 */       if (project != null) {
/* 217 */         ProjectTree.importFolderToTree(project, gcreator.window.top);
/* 218 */         Macro.macroAction(new NewProjectAction(project.name));
/*     */       }
/*     */       try {
/* 221 */         Aurwindow.workspace.updateUI();
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.NewProject
 * JD-Core Version:    0.6.2
 */