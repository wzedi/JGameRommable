/*    */ package org.gcreator.components;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import javax.swing.ButtonGroup;
/*    */ import javax.swing.JTabbedPane;
/*    */ import org.jdesktop.layout.GroupLayout;
/*    */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*    */ 
/*    */ public class GlobalSettings extends TabPanel
/*    */ {
/*    */   private ButtonGroup buttonGroup1;
/*    */   private ButtonGroup buttonGroup2;
/*    */   public JTabbedPane jTabbedPane1;
/*    */ 
/*    */   public GlobalSettings(String[] settings)
/*    */   {
/* 22 */     initComponents();
/* 23 */     this.jTabbedPane1.add("Language", new LanguageTab());
/* 24 */     this.jTabbedPane1.add("Toolbar Editor", new ToolbarEditor());
/* 25 */     this.jTabbedPane1.add("Preferences", new PreferencesTab(settings));
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 36 */     this.buttonGroup1 = new ButtonGroup();
/* 37 */     this.buttonGroup2 = new ButtonGroup();
/* 38 */     this.jTabbedPane1 = new JTabbedPane();
/*    */ 
/* 40 */     this.jTabbedPane1.setTabPlacement(2);
/*    */ 
/* 42 */     GroupLayout layout = new GroupLayout(this);
/* 43 */     setLayout(layout);
/* 44 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(2, this.jTabbedPane1, -1, 358, 32767));
/*    */ 
/* 48 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(2, this.jTabbedPane1, -1, 275, 32767));
/*    */   }
/*    */ 
/*    */   public void dispose()
/*    */   {
/* 56 */     int len = this.jTabbedPane1.getTabCount();
/* 57 */     for (int i = 0; i < len; i++) {
/* 58 */       Component p = this.jTabbedPane1.getComponentAt(i);
/* 59 */       if (((p instanceof OptionPanel)) && 
/* 60 */         (!((OptionPanel)p).dispose()))
/* 61 */         return;
/*    */     }
/* 63 */     super.dispose();
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.GlobalSettings
 * JD-Core Version:    0.6.2
 */