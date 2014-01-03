/*     */ package org.gcreator.components;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;

/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;

/*     */ import org.gcreator.core.Aurwindow;
/*     */ import org.gcreator.languages.English;
/*     */ import org.gcreator.managers.LangSupporter;
/*     */ import org.gcreator.units.Dictionary;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LanguageTab extends TabPanel
/*     */ {
/*     */   private JButton jButton1;
/*     */   private JComboBox jComboBox1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */ 
/*     */   public LanguageTab()
/*     */   {
/*  22 */     initComponents();
/*     */     try {
/*  24 */       if (LangSupporter.activeLang.getLanguage().equals(Aurwindow.lang))
/*  25 */         this.jLabel4.setVisible(false);
/*     */     } catch (Exception e) {
/*     */     }
/*  28 */     int l = 0;
/*  29 */     if (Aurwindow.lang.equals("German"))
/*  30 */       l = 1;
/*  31 */     if (Aurwindow.lang.equals("German (Old)"))
/*  32 */       l = 2;
/*  33 */     if (Aurwindow.lang.equals("Portuguese (European)"))
/*  34 */       l = 3;
/*  35 */     if (Aurwindow.lang.equals("Russian"))
/*  36 */       l = 4;
/*  37 */     if (Aurwindow.lang.equals("Spanish"))
/*  38 */       l = 5;
/*  39 */     this.jComboBox1.setSelectedIndex(l);
/*  40 */     updateLanguage();
/*     */   }
/*     */ 
/*     */   public void updateLanguage() {
/*  44 */     int l = this.jComboBox1.getSelectedIndex();
/*     */     Dictionary m = null;
/*  46 */     if (l == 0) {
/*  47 */       m = new English();
/*     */     }
/*     */     else
/*     */     {
/*     */       //Dictionary m;
/*  48 */       //if (l == 1) {
/*  49 */         //m = new German();
/*     */       //}
/*     */       //else
/*     */       //{
/*     */         //Dictionary m;
/*  50 */         //if (l == 2) {
/*  51 */           //m = new GermanOld();
/*     */         //}
/*     */         //else
/*     */         //{
/*     */           //Dictionary m;
/*  52 */           //if (l == 3) {
/*  53 */             //m = new Portuguese();
/*     */           //}
/*     */           //else
/*     */           //{
/*     */             //Dictionary m;
/*  54 */             //if (l == 4)
/*  55 */               //m = new Russian();
/*     */             //else
/*  57 */               //m = new Spanish(); 
/*     */           //}
/*     */         //}
/*     */       //}
/*     */     }
/*  58 */     this.jLabel1.setText(m.getEntry(47));
/*  59 */     this.jLabel2.setText(m.getEntry(48));
/*  60 */     this.jLabel3.setText(m.getStatus());
/*  61 */     this.jLabel4.setText(m.getEntry(50));
/*  62 */     this.jButton1.setText(m.getEntry(49));
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  73 */     this.jLabel1 = new JLabel();
/*  74 */     this.jComboBox1 = new JComboBox();
/*  75 */     this.jLabel2 = new JLabel();
/*  76 */     this.jLabel3 = new JLabel();
/*  77 */     this.jButton1 = new JButton();
/*  78 */     this.jLabel4 = new JLabel();
/*     */ 
/*  80 */     this.jLabel1.setText("Language");
/*     */ 
/*  82 */     this.jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "English" })); //, "German", "German (Old)", "Portuguese (European)", "Russian", "Spanish" }));
/*  83 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  85 */         LanguageTab.this.jComboBox1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  89 */     this.jLabel2.setText("Status");
/*     */ 
/*  91 */     this.jLabel3.setText("In Development");
/*     */ 
/*  93 */     this.jButton1.setText("Apply Language");
/*  94 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  96 */         LanguageTab.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 100 */     this.jLabel4.setFont(new Font("Tahoma", 1, 11));
/* 101 */     this.jLabel4.setForeground(new Color(255, 51, 51));
/* 102 */     this.jLabel4.setText("Restart the application to apply the changes");
/*     */ 
/* 104 */     GroupLayout layout = new GroupLayout(this);
/* 105 */     setLayout(layout);
/* 106 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(this.jLabel1).addPreferredGap(0).add(this.jComboBox1, 0, 329, 32767)).add(layout.createSequentialGroup().add(this.jLabel2).addPreferredGap(0).add(this.jLabel3)).add(2, this.jButton1).add(2, this.jLabel4)).addContainerGap()));
/*     */ 
/* 123 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(3).add(this.jLabel1).add(this.jComboBox1, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jLabel2).add(this.jLabel3, -2, 14, -2)).addPreferredGap(0, 195, 32767).add(this.jLabel4).addPreferredGap(0).add(this.jButton1).addContainerGap()));
/*     */   }
/*     */ 
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt)
/*     */   {
/* 143 */     updateLanguage();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 147 */     Aurwindow.lang = (String)this.jComboBox1.getSelectedItem();
/*     */     try {
/* 149 */       this.jLabel4.setVisible(!LangSupporter.activeLang.getLanguage().equals(Aurwindow.lang));
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.LanguageTab
 * JD-Core Version:    0.6.2
 */