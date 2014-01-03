/*     */ package org.gcreator.components;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.Vector;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import org.gcreator.managers.LangSupporter;
/*     */ import org.gcreator.units.Dictionary;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class PackageProjects extends JPanel
/*     */ {
/*     */   private ProjectTypes ptypes;
/*     */   public int tnum;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */ 
/*     */   public PackageProjects(ProjectTypes ptypes)
/*     */   {
/*  23 */     this.ptypes = ptypes;
/*  24 */     initComponents();
/*  25 */     this.jButton1.setText(LangSupporter.activeLang.getEntry(59));
/*  26 */     this.jButton2.setText(LangSupporter.activeLang.getEntry(61));
/*  27 */     ptypes.npro.ProjectButtons.add(this.jButton1);
/*  28 */     ptypes.npro.ProjectButtons.add(this.jButton2);
/*     */   }
/*     */ 
/*     */   public int getSelectedProject() {
/*  32 */     if (this.jButton1.isSelected())
/*  33 */       return 1;
/*  34 */     if (this.jButton2.isSelected())
/*  35 */       return 2;
/*  36 */     return -1;
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  47 */     this.jButton1 = new JButton();
/*  48 */     this.jButton2 = new JButton();
/*     */ 
/*  50 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/toolbar/build.png")));
/*  51 */     this.jButton1.setText("Empty Package");
/*  52 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  54 */         PackageProjects.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  58 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/toolbar/build.png")));
/*  59 */     this.jButton2.setText("Organized Package");
/*  60 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  62 */         PackageProjects.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/*  66 */     GroupLayout layout = new GroupLayout(this);
/*  67 */     setLayout(layout);
/*  68 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(this.jButton1, -1, 189, 32767).add(this.jButton2, -1, 189, 32767));
/*     */ 
/*  73 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(this.jButton1).addPreferredGap(0).add(this.jButton2)));
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/*  83 */     setButton(1);
/*  84 */     String str = this.jButton1.getText().replaceAll("\\s", "_").replaceAll("[\\.:?^(){}]", "").replaceAll("(\\[|\\])", "") + "1";
/*     */ 
/*  89 */     if (str.charAt(0) == '1')
/*  90 */       str = "p1";
/*  91 */     this.ptypes.npro.jTextField1.setText(str);
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/*  95 */     setButton(2);
/*  96 */     String str = this.jButton2.getText().replaceAll("\\s", "_").replaceAll("[\\.:?^(){}]", "").replaceAll("(\\[|\\])", "") + "1";
/*     */ 
/* 101 */     if (str.charAt(0) == '1')
/* 102 */       str = "p1";
/* 103 */     this.ptypes.npro.jTextField1.setText(str);
/*     */   }
/*     */ 
/*     */   public void setButton(int sel) {
/* 107 */     this.ptypes.npro.uncheckAll();
/* 108 */     if (sel == 1)
/* 109 */       this.jButton1.setSelected(true);
/* 110 */     if (sel == 2)
/* 111 */       this.jButton2.setSelected(true);
/*     */   }
/*     */ 
/*     */   public void turnOff() {
/* 115 */     setButton(0);
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.PackageProjects
 * JD-Core Version:    0.6.2
 */