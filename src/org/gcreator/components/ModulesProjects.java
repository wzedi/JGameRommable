/*    */ package org.gcreator.components;
/*    */ 
/*    */ import java.awt.GridLayout;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.util.Vector;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JTextField;
/*    */ import org.gcreator.managers.LangSupporter;
/*    */ import org.gcreator.units.Dictionary;
/*    */ 
/*    */ public class ModulesProjects extends JPanel
/*    */ {
/*    */   private ProjectTypes ptypes;
/*    */   public int tnum;
/*    */   private JButton jButton1;
/*    */ 
/*    */   public int getSelectedProject()
/*    */   {
/* 23 */     if (this.jButton1.isSelected())
/* 24 */       return 4;
/* 25 */     return -1;
/*    */   }
/*    */ 
/*    */   public ModulesProjects(ProjectTypes ptypes) {
/* 29 */     this.ptypes = ptypes;
/* 30 */     initComponents();
/* 31 */     this.jButton1.setText(LangSupporter.activeLang.getEntry(205));
/* 32 */     ptypes.npro.ProjectButtons.add(this.jButton1);
/*    */   }
/*    */ 
/*    */   public void add(JComponent c) {
/* 36 */     GridLayout g = (GridLayout)getLayout();
/*    */ 
/* 38 */     if (getComponentCount() > 5)
/* 39 */       g.setRows(g.getRows() + 1);
/* 40 */     super.add(c);
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 45 */     this.jButton1 = new JButton();
/*    */ 
/* 47 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/toolbar/modules.png")));
/* 48 */     this.jButton1.setText("Empty Modules");
/* 49 */     this.jButton1.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent evt) {
/* 51 */         ModulesProjects.this.jButton1ActionPerformed(evt);
/*    */       }
/*    */     });
/* 54 */     setLayout(new GridLayout(5, 1));
/* 55 */     add(this.jButton1);
/*    */   }
/*    */ 
/*    */   public void setButton(int sel)
/*    */   {
/* 65 */     this.ptypes.npro.uncheckAll();
/* 66 */     if (sel == 4)
/* 67 */       this.jButton1.setSelected(true);
/*    */   }
/*    */ 
/*    */   public void turnOff() {
/* 71 */     setButton(0);
/*    */   }
/*    */ 
/*    */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 75 */     setButton(4);
/* 76 */     String str = this.jButton1.getText().replaceAll("\\s", "_").replaceAll("[\\.:?^(){}]", "").replaceAll("(\\[|\\])", "") + "1";
/*    */ 
/* 81 */     if (str.charAt(0) == '1')
/* 82 */       str = "p1";
/* 83 */     this.ptypes.npro.jTextField1.setText(str);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.ModulesProjects
 * JD-Core Version:    0.6.2
 */