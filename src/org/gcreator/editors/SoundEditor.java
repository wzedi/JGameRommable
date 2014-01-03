/*     */ package org.gcreator.editors;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.event.CaretEvent;
/*     */ import javax.swing.event.CaretListener;
/*     */ import org.gcreator.components.TabPanel;
/*     */ import org.gcreator.components.WorkspaceTree;
/*     */ import org.gcreator.core.Aurwindow;
/*     */ import org.gcreator.fileclass.GFile;
/*     */ import org.gcreator.fileclass.Project;
/*     */ import org.gcreator.fileclass.res.Sound;
/*     */ import org.gcreator.managers.LangSupporter;
/*     */ import org.gcreator.units.Dictionary;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class SoundEditor extends TabPanel
/*     */ {
/*  33 */   static int number = 0;
/*     */   public JButton jButton1;
/*     */   public JButton jButton2;
/*     */   public JButton jButton3;
/*     */   public JButton jButton5;
/*     */   public JCheckBox jCheckBox1;
/*     */   public JFileChooser jFileChooser1;
/*     */   public JLabel jLabel1;
/*     */   public JLabel jLabel2;
/*     */   public JTextField jTextField1;
/*     */ 
/*     */   public SoundEditor(GFile file, Project project)
/*     */   {
/*  41 */     if (!(file.value instanceof Sound))
/*  42 */       file.value = new Sound(file.name);
/*  43 */     this.project = project;
/*  44 */     this.file = file;
/*  45 */     initComponents();
/*  46 */     this.jTextField1.setText(file.name);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  60 */     this.jFileChooser1 = new JFileChooser();
/*  61 */     this.jLabel1 = new JLabel();
/*  62 */     this.jTextField1 = new JTextField();
/*  63 */     this.jButton1 = new JButton();
/*  64 */     this.jButton3 = new JButton();
/*  65 */     this.jButton5 = new JButton();
/*  66 */     this.jButton2 = new JButton();
/*  67 */     this.jCheckBox1 = new JCheckBox();
/*  68 */     this.jLabel2 = new JLabel();
/*     */ 
/*  70 */     this.jFileChooser1.setCurrentDirectory(new File("C:\\Program Files\\NetBeans 6.0"));
/*  71 */     this.jFileChooser1.setDialogTitle("Choose a sound");
/*     */ 
/*  73 */     this.jLabel1.setText(LangSupporter.activeLang.getEntry(166));
/*     */ 
/*  75 */     this.jTextField1.addCaretListener(new CaretListener() {
/*     */       public void caretUpdate(CaretEvent evt) {
/*  77 */         SoundEditor.this.jTextField1CaretUpdate(evt);
/*     */       }
/*     */     });
/*  81 */     this.jButton1.setText(LangSupporter.activeLang.getEntry(170));
/*  82 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  84 */         SoundEditor.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  88 */     this.jButton3.setText(LangSupporter.activeLang.getEntry(167));
/*  89 */     this.jButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  91 */         SoundEditor.this.jButton3ActionPerformed(evt);
/*     */       }
/*     */     });
/*  95 */     this.jButton5.setText(LangSupporter.activeLang.getEntry(169));
/*  96 */     this.jButton5.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  98 */         SoundEditor.this.jButton5ActionPerformed(evt);
/*     */       }
/*     */     });
/* 102 */     this.jButton2.setText(LangSupporter.activeLang.getEntry(168));
/* 103 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 105 */         SoundEditor.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 109 */     this.jCheckBox1.setSelected(true);
/* 110 */     this.jCheckBox1.setText("Stream");
/* 111 */     this.jCheckBox1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 113 */         SoundEditor.this.jCheckBox1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 117 */     this.jLabel2.setText("<html>If it is a large file (over 1mb) then make sure \"Stream\" is on, otherwise it will load the whole file into memory when playing. Only take \"Stream\" off if you are having trouble playing very small files.</html>");
/*     */ 
/* 119 */     GroupLayout layout = new GroupLayout(this);
/* 120 */     setLayout(layout);
/* 121 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(this.jLabel1).addPreferredGap(0).add(this.jTextField1, -1, 337, 32767)).add(layout.createSequentialGroup().add(this.jButton3).addPreferredGap(0).add(this.jButton2).addPreferredGap(0).add(this.jButton5)).add(layout.createSequentialGroup().add(this.jButton1).addPreferredGap(1).add(this.jCheckBox1)).add(this.jLabel2, -2, 407, -2)).addContainerGap()));
/*     */ 
/* 143 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(3).add(this.jLabel1).add(this.jTextField1, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jButton3).add(this.jButton2).add(this.jButton5)).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jButton1).add(this.jCheckBox1)).addPreferredGap(1).add(this.jLabel2, -2, 74, -2).addContainerGap(59, 32767)));
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/*     */     try
/*     */     {
/* 175 */       this.jFileChooser1.showDialog(this, null);
/*     */ 
/* 177 */       File f = this.jFileChooser1.getSelectedFile();
/* 178 */       System.out.println("Name:" + f.getName());
/* 179 */       System.out.println("path:" + f.getPath());
/* 180 */       if (f.getName().endsWith(".wav"))
/* 181 */         ((Sound)this.file.value).extension = ".wav";
/* 182 */       else if (f.getName().endsWith(".ogg"))
/* 183 */         ((Sound)this.file.value).extension = ".ogg";
/*     */       else
/* 185 */         return;
/* 186 */       InputStream is = new FileInputStream(f);
/*     */ 
/* 189 */       long length = f.length();
/*     */ 
/* 191 */       if (length > 2147483647L);
/* 196 */       byte[] bytes = new byte[(int)length];
/*     */ 
/* 199 */       int offset = 0;
/* 200 */       int numRead = 0;
/*     */ 
/* 202 */       while ((offset < bytes.length) && ((numRead = is.read(bytes, offset, bytes.length - offset)) >= 0)) {
/* 203 */         offset += numRead;
/*     */       }
/*     */ 
/* 207 */       if (offset < bytes.length) {
/* 208 */         System.out.println("Could not completely read file " + f.getName());
/*     */       }
/*     */ 
/* 212 */       is.close();
/* 213 */       ((Sound)this.file.value).sound = bytes;
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 220 */       System.out.println("Exception in load sound");
/* 221 */       Logger.getLogger(SoundEditor.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton3ActionPerformed(ActionEvent evt)
/*     */   {
/*     */     try
/*     */     {
/* 229 */       File ff = new File("./Sound/");
/* 230 */       if (!ff.exists())
/* 231 */         ff.mkdir();
/* 232 */       ff = new File("./Sound/play" + number + ".ogg");
/* 233 */       if (ff.exists())
/* 234 */         ff.delete();
/* 235 */       ff = new File("./Sound/play" + number + ".wav");
/* 236 */       if (ff.exists())
/* 237 */         ff.delete();
/* 238 */       number += 1;
/*     */ 
/* 240 */       FileOutputStream f = new FileOutputStream("./Sound/play" + number + ((Sound)this.file.value).extension);
/*     */ 
/* 243 */       byte[] b = ((Sound)this.file.value).sound;
/*     */ 
/* 245 */       f.write(b);
/* 246 */       f.close();
/*     */ 
/* 248 */       ff = new File("Sound/play" + number + ((Sound)this.file.value).extension);
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/* 260 */       System.out.println("" + ex);
/* 261 */       Logger.getLogger(SoundEditor.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton5ActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jTextField1CaretUpdate(CaretEvent evt)
/*     */   {
/* 286 */     this.file.name = this.jTextField1.getText();
/* 287 */     Aurwindow.workspace.updateUI();
/*     */   }
/*     */ 
/*     */   private void jCheckBox1ActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.editors.SoundEditor
 * JD-Core Version:    0.6.2
 */