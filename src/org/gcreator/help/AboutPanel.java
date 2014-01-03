/*     */ package org.gcreator.help;
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Font;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JEditorPane;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import org.gcreator.components.TabPanel;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class AboutPanel extends TabPanel
/*     */ {
/*     */   private JEditorPane jEditorPane1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JScrollPane jScrollPane2;
/*     */   private JScrollPane jScrollPane3;
/*     */   public JTabbedPane jTabbedPane1;
/*     */   private JTable jTable1;
/*     */ 
/*     */   public AboutPanel()
/*     */   {
/*  21 */     initComponents();
/*  22 */     this.jScrollPane1.setViewportView(new Programmers());
/*  23 */     this.jTabbedPane1.add("Designers", new Designers());
/*  24 */     this.jTabbedPane1.add("Others", new Others());
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  35 */     this.jTabbedPane1 = new JTabbedPane();
/*  36 */     this.jPanel1 = new JPanel();
/*  37 */     this.jLabel2 = new JLabel();
/*  38 */     this.jScrollPane3 = new JScrollPane();
/*  39 */     this.jEditorPane1 = new JEditorPane();
/*  40 */     this.jScrollPane1 = new JScrollPane();
/*  41 */     this.jPanel2 = new JPanel();
/*  42 */     this.jScrollPane2 = new JScrollPane();
/*  43 */     this.jTable1 = new JTable();
/*  44 */     this.jLabel1 = new JLabel();
/*     */ 
/*  46 */     this.jPanel1.setLayout(new BorderLayout());
/*     */ 
/*  48 */     this.jLabel2.setFont(new Font("Tahoma", 1, 14));
/*  49 */     this.jLabel2.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/GCreator.png")));
/*  50 */     this.jLabel2.setText("G-Creator 1.0 - Project \"Aurora\"");
/*  51 */     this.jPanel1.add(this.jLabel2, "North");
/*     */ 
/*  53 */     this.jEditorPane1.setEditable(false);
/*  54 */     this.jEditorPane1.setText("    G-Creator - Multiple languages and platforms game development.\n\n    Copyright (C) 2007-2008  Luís Reis\n    Copyright (C) 2007-2008  TGMG\n\n    This program is free software: you can redistribute it and/or modify\n    it under the terms of the GNU Lesser General Public License as published by\n    the Free Software Foundation, either version 3 of the License, or\n    (at your option) any later version.\n\n    This program is distributed in the hope that it will be useful,\n    but WITHOUT ANY WARRANTY; without even the implied warranty of\n    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\n    GNU Lesser General Public License for more details.\n\n    You should have received a copy of the GNU Lesser General Public License\n    along with this program.  If not, see <http://www.gnu.org/licenses/>.");
/*  55 */     this.jScrollPane3.setViewportView(this.jEditorPane1);
/*     */ 
/*  57 */     this.jPanel1.add(this.jScrollPane3, "Center");
/*     */ 
/*  59 */     this.jTabbedPane1.addTab("Main", this.jPanel1);
/*  60 */     this.jTabbedPane1.addTab("Programmers", this.jScrollPane1);
/*     */ 
/*  62 */     this.jPanel2.setLayout(new BorderLayout());
/*     */ 
/*  64 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { "Luís Reis", "Portuguese, English" }, { "B Biglari", "German" }, { "Jonathon Potapenko", "Russian" }, { "Peregrina", "Spanish (Most of it)" } }, new String[] { "Name", "Languages" })
/*     */     {
/*  75 */       Class[] types = { String.class, String.class };
/*     */ 
/*  78 */       boolean[] canEdit = { false, false };
/*     */ 
/*     */       public Class getColumnClass(int columnIndex)
/*     */       {
/*  83 */         return this.types[columnIndex];
/*     */       }
/*     */ 
/*     */       public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  87 */         return this.canEdit[columnIndex];
/*     */       }
/*     */     });
/*  90 */     this.jTable1.setEnabled(false);
/*  91 */     this.jScrollPane2.setViewportView(this.jTable1);
/*     */ 
/*  93 */     this.jPanel2.add(this.jScrollPane2, "Center");
/*     */ 
/*  95 */     this.jLabel1.setText("Listed in order of contribution(Newer contributions appear in the bottom)");
/*  96 */     this.jPanel2.add(this.jLabel1, "First");
/*     */ 
/*  98 */     this.jTabbedPane1.addTab("Translators", this.jPanel2);
/*     */ 
/* 100 */     GroupLayout layout = new GroupLayout(this);
/* 101 */     setLayout(layout);
/* 102 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jTabbedPane1, -1, 485, 32767).addContainerGap()));
/*     */ 
/* 109 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jTabbedPane1, -1, 343, 32767).addContainerGap()));
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.help.AboutPanel
 * JD-Core Version:    0.6.2
 */