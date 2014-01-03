/*     */ package org.gcreator.components;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JScrollPane;
/*     */ import org.gcreator.core.Aurwindow;
/*     */ import org.gcreator.core.gcreator;
/*     */ import org.gcreator.externproject.StdImport;
/*     */ import org.gcreator.managers.LangSupporter;
/*     */ import org.gcreator.units.Dictionary;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class PowerPackImporter extends TabPanel
/*     */ {
/*  25 */   public IconList list = new IconList();
/*     */   private JButton jButton1;
/*     */   private JCheckBox jCheckBox1;
/*     */   private JCheckBox jCheckBox2;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JScrollPane jScrollPane1;
/*     */ 
/*     */   public PowerPackImporter()
/*     */   {
/*  29 */     initComponents();
/*  30 */     this.project = null;
/*  31 */     this.list.setColumns(5);
/*  32 */     File powerpack = new File("./powerpack");
/*  33 */     if (!powerpack.exists()) {
/*  34 */       this.jScrollPane1.setViewportView(new JLabel("Could not find PowerPack!"));
/*     */     }
/*  36 */     if (!powerpack.isDirectory()) {
/*  37 */       this.jScrollPane1.setViewportView(new JLabel("PowerPack must be a folder!"));
/*     */     }
/*  39 */     File[] files = powerpack.listFiles();
/*  40 */     for (int i = 0; i < files.length; i++)
/*  41 */       if ((files[i] != null) && (files[i].isFile()))
/*     */         try {
/*  43 */           this.list.addElement(files[i].getName(), new ImageIcon(ImageIO.read(files[i])), null);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */         }
/*  48 */     this.jScrollPane1.setViewportView(this.list);
/*  49 */     this.list.setBackground(Color.WHITE);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  60 */     this.jLabel1 = new JLabel();
/*  61 */     this.jLabel2 = new JLabel();
/*  62 */     this.jCheckBox1 = new JCheckBox();
/*  63 */     this.jCheckBox2 = new JCheckBox();
/*  64 */     this.jScrollPane1 = new JScrollPane();
/*  65 */     this.jButton1 = new JButton();
/*  66 */     this.jLabel3 = new JLabel();
/*  67 */     this.jLabel4 = new JLabel();
/*     */ 
/*  69 */     this.jLabel1.setText(LangSupporter.activeLang.getEntry(187));
/*     */ 
/*  71 */     this.jLabel2.setText(LangSupporter.activeLang.getEntry(188));
/*     */ 
/*  73 */     this.jCheckBox1.setSelected(true);
/*  74 */     this.jCheckBox1.setText("Show image files");
/*     */ 
/*  76 */     this.jCheckBox2.setSelected(true);
/*  77 */     this.jCheckBox2.setText("Show audio files");
/*     */ 
/*  79 */     this.jButton1.setText("Add");
/*  80 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  82 */         PowerPackImporter.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  86 */     this.jLabel3.setFont(new Font("DejaVu Sans", 1, 13));
/*  87 */     this.jLabel3.setForeground(Color.red);
/*  88 */     this.jLabel3.setText(LangSupporter.activeLang.getEntry(196));
/*     */ 
/*  90 */     this.jLabel4.setText(LangSupporter.activeLang.getEntry(197));
/*     */ 
/*  92 */     GroupLayout layout = new GroupLayout(this);
/*  93 */     setLayout(layout);
/*  94 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1, false).add(this.jLabel1, -1, -1, 32767).add(this.jLabel2, -1, -1, 32767).add(this.jButton1, -1, -1, 32767).add(this.jLabel3, 0, 0, 32767).add(this.jLabel4, -1, -1, 32767).add(this.jCheckBox2, 0, 0, 32767).add(this.jCheckBox1, 0, 0, 32767)).addPreferredGap(0).add(this.jScrollPane1, -1, 445, 32767).addContainerGap()));
/*     */ 
/* 110 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(2, this.jScrollPane1, -1, 369, 32767).add(layout.createSequentialGroup().add(this.jLabel1).addPreferredGap(0).add(this.jLabel2).addPreferredGap(0).add(this.jCheckBox1).addPreferredGap(0).add(this.jCheckBox2).addPreferredGap(0).add(this.jLabel3).addPreferredGap(0).add(this.jLabel4).addPreferredGap(0, 198, 32767).add(this.jButton1))).addContainerGap()));
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/* 135 */     String sel = this.list.getSelectedText();
/* 136 */     if (sel == null) {
/* 137 */       System.out.println("No selection");
/* 138 */       return;
/*     */     }
/* 140 */     sel = "." + File.separator + "powerpack" + File.separator + sel;
/*     */     try {
/* 142 */       StdImport.importImage(gcreator.window.getCurrentFolder(), sel);
/*     */     } catch (Exception e) {
/* 144 */       System.out.println(e.getMessage());
/*     */     }
/* 146 */     System.out.println("will update");
/* 147 */     Aurwindow.workspace.updateUI();
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.PowerPackImporter
 * JD-Core Version:    0.6.2
 */