/*    */ package org.gcreator.actions.components;
/*    */ 
/*    */ import javax.swing.JCheckBox;
/*    */ import javax.swing.JPanel;
/*    */ import org.gcreator.managers.LangSupporter;
/*    */ import org.gcreator.units.Dictionary;
/*    */ import org.jdesktop.layout.GroupLayout;
/*    */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*    */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*    */ 
/*    */ public class YesOrNoIfPanel extends JPanel
/*    */ {
/*    */   public JCheckBox NotCheckbox;
/*    */ 
/*    */   public YesOrNoIfPanel()
/*    */   {
/* 19 */     initComponents();
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 30 */     this.NotCheckbox = new JCheckBox();
/*    */ 
/* 32 */     this.NotCheckbox.setText(LangSupporter.activeLang.getEntry(243));
/*    */ 
/* 34 */     GroupLayout layout = new GroupLayout(this);
/* 35 */     setLayout(layout);
/* 36 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.NotCheckbox).addContainerGap(-1, 32767)));
/*    */ 
/* 43 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.NotCheckbox).addContainerGap(-1, 32767)));
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.components.YesOrNoIfPanel
 * JD-Core Version:    0.6.2
 */