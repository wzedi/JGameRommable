/*     */ package org.gcreator.components;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.Frame;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.AbstractListModel;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JScrollPane;
/*     */ import org.gcreator.components.impl.MacroCellRenderer;
/*     */ import org.gcreator.macro.Macro;
/*     */ import org.gcreator.macro.MacroLibrary;
/*     */ import org.gcreator.managers.LangSupporter;
/*     */ import org.gcreator.units.Dictionary;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class PlayMacroDialog extends JDialog
/*     */ {
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JLabel jLabel1;
/*     */   private JList jList1;
/*     */   private JScrollPane jScrollPane1;
/*     */ 
/*     */   public PlayMacroDialog(Frame parent, boolean modal)
/*     */   {
/*  23 */     super(parent, modal);
/*  24 */     initComponents();
/*  25 */     this.jList1.setModel(new AbstractListModel() {
/*     */       public Object getElementAt(int pos) {
/*  27 */         return MacroLibrary.getMacroAt(pos);
/*     */       }
/*     */       public int getSize() {
/*  30 */         return MacroLibrary.getSize();
/*     */       }
/*     */     });
/*  33 */     this.jList1.setCellRenderer(new MacroCellRenderer());
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  44 */     this.jLabel1 = new JLabel();
/*  45 */     this.jScrollPane1 = new JScrollPane();
/*  46 */     this.jList1 = new JList();
/*  47 */     this.jButton1 = new JButton();
/*  48 */     this.jButton2 = new JButton();
/*     */ 
/*  50 */     setDefaultCloseOperation(2);
/*  51 */     setTitle(LangSupporter.activeLang.getEntry(181));
/*  52 */     setAlwaysOnTop(true);
/*  53 */     setResizable(false);
/*     */ 
/*  55 */     this.jLabel1.setText(LangSupporter.activeLang.getEntry(178));
/*     */ 
/*  57 */     this.jList1.setSelectionMode(0);
/*  58 */     this.jScrollPane1.setViewportView(this.jList1);
/*     */ 
/*  60 */     this.jButton1.setText(LangSupporter.activeLang.getEntry(180));
/*  61 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  63 */         PlayMacroDialog.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  67 */     this.jButton2.setText(LangSupporter.activeLang.getEntry(179));
/*  68 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  70 */         PlayMacroDialog.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/*  74 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  75 */     getContentPane().setLayout(layout);
/*  76 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(2).add(1, this.jScrollPane1, -1, 405, 32767).add(1, layout.createSequentialGroup().add(layout.createParallelGroup(2).add(layout.createSequentialGroup().add(this.jLabel1).addPreferredGap(0, 215, 32767)).add(layout.createSequentialGroup().add(this.jButton2).addPreferredGap(0))).add(this.jButton1))).addContainerGap()));
/*     */ 
/*  93 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jLabel1).addPreferredGap(0).add(this.jScrollPane1, -1, 229, 32767).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jButton1).add(this.jButton2)).addContainerGap()));
/*     */ 
/* 107 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 111 */     dispose();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 115 */     dispose();
/* 116 */     ((Macro)this.jList1.getSelectedValue()).play();
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.PlayMacroDialog
 * JD-Core Version:    0.6.2
 */