/*     */ package org.gcreator.components;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.Frame;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipInputStream;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import org.gcreator.components.impl.CustomFileFilter;
/*     */ import org.gcreator.plugins.Plugin;
/*     */ import org.gcreator.plugins.PluginList;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class PluginDialog extends JDialog
/*     */ {
/*     */   public IconList list;
/*  98 */   private static JFileChooser fc = new JFileChooser();
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JPanel jPanel1;
/*     */   private JScrollPane jScrollPane1;
/*     */ 
/*     */   public PluginDialog(Frame parent, boolean modal)
/*     */   {
/*  25 */     super(parent, modal);
/*  26 */     initComponents();
/*  27 */     this.list = new IconList();
/*  28 */     this.list.setColumnWidth(100);
/*  29 */     this.list.setColumnHeight(100);
/*  30 */     this.list.setColumns(5);
/*  31 */     this.jScrollPane1.setViewportView(this.list);
/*  32 */     for (Plugin plugin : PluginList.stdlist.plugins) {
/*  33 */       System.out.println("Plugin: " + plugin.name);
/*  34 */       this.list.addElement(plugin.name, plugin.image, plugin);
/*     */     }
/*  36 */     pack();
/*  37 */     setMinimumSize(getSize());
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  48 */     this.jScrollPane1 = new JScrollPane();
/*  49 */     this.jPanel1 = new JPanel();
/*  50 */     this.jButton1 = new JButton();
/*  51 */     this.jButton2 = new JButton();
/*     */ 
/*  53 */     setDefaultCloseOperation(2);
/*  54 */     setTitle("Plugin Manager");
/*  55 */     setResizable(false);
/*  56 */     getContentPane().add(this.jScrollPane1, "Center");
/*     */ 
/*  58 */     this.jButton1.setText("Install new plugin");
/*  59 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  61 */         PluginDialog.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  65 */     this.jButton2.setText("Uninstall plugin");
/*  66 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  68 */         PluginDialog.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/*  72 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  73 */     this.jPanel1.setLayout(jPanel1Layout);
/*  74 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(1).add(2, jPanel1Layout.createSequentialGroup().addContainerGap().add(jPanel1Layout.createParallelGroup(2).add(1, this.jButton2, -1, 194, 32767).add(1, this.jButton1, -1, 194, 32767)).addContainerGap()));
/*     */ 
/*  83 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().addContainerGap().add(this.jButton1).addPreferredGap(0).add(this.jButton2).addContainerGap(254, 32767)));
/*     */ 
/*  93 */     getContentPane().add(this.jPanel1, "West");
/*     */ 
/*  95 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/* 101 */     JFileChooser fc = new JFileChooser();
/* 102 */     fc.setMultiSelectionEnabled(false);
/* 103 */     fc.setDialogTitle("Choose the file");
/* 104 */     fc.setApproveButtonText("OK");
/* 105 */     fc.setFileFilter(new CustomFileFilter(".jar", "Plugin archives (*.jar)"));
/* 106 */     fc.showOpenDialog(this);
/* 107 */     File f = fc.getSelectedFile();
/* 108 */     if (f == null)
/* 109 */       return;
/* 110 */     if (!f.exists())
/* 111 */       return;
/* 112 */     addPlugin(f);
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 116 */     Object o = this.list.getSelectedExtraContent();
/* 117 */     if (o == null)
/* 118 */       return;
/* 119 */     if ((o instanceof Plugin)) {
/* 120 */       uninstall((Plugin)o);
/* 121 */       this.list.removeElement(this.list.getSelectedIndex());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void uninstall(Plugin plugin) {
/* 126 */     System.out.println("Uninstall " + plugin.name);
/* 127 */     String s = "[G-Creator Plugin List]\n";
/* 128 */     for (Plugin plug : PluginList.stdlist.plugins)
/* 129 */       if (plug != plugin)
/*     */       {
/* 131 */         s = s + "[~Plugin~]\n";
/* 132 */         for (String author : plug.authors)
/* 133 */           s = s + "Author=" + author + "\n";
/* 134 */         s = s + "Core=" + plug.value.getClass().getName() + "\n";
/* 135 */         s = s + "License=" + plug.licenseLocation + "\n";
/* 136 */         s = s + "Name=" + plug.name + "\n";
/* 137 */         s = s + "Version=" + plug.version + "\n";
/* 138 */         s = s + "Image=" + plug.img_loc + "\n";
/* 139 */         for (String file : plug.files)
/* 140 */           s = s + "File=" + file + "\n";
/*     */       }
/* 142 */     File f = new File("./settings/pluglist");
/* 143 */     FileOutputStream stream = null;
/*     */     try {
/* 145 */       if (f.exists()) {
/* 146 */         f.delete();
/*     */       }
/* 148 */       stream = new FileOutputStream(f);
/* 149 */       BufferedOutputStream bstream = new BufferedOutputStream(stream);
/* 150 */       bstream.write(s.getBytes());
/* 151 */       bstream.close();
/*     */     }
/*     */     catch (Exception e) {
/* 154 */       System.out.println(e.toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   public void addPlugin(File f) {
/* 159 */     FileInputStream istream = null;
/* 160 */     ZipInputStream in = null;
/* 161 */     File f2 = new File("./settings/pluglist");
/* 162 */     FileOutputStream f2stream = null;
/* 163 */     String files = "";
/*     */     try {
/* 165 */       if (!f2.exists()) {
/* 166 */         f2.createNewFile();
/* 167 */         f2stream = new FileOutputStream(f2);
/* 168 */         BufferedOutputStream s = new BufferedOutputStream(f2stream);
/* 169 */         s.write("[G-Creator Plugin List]\n".getBytes());
/* 170 */         s.close();
/* 171 */         f2stream = null;
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */     try {
/* 178 */       f2stream = new FileOutputStream(f2, true);
/* 179 */       istream = new FileInputStream(f);
/* 180 */       in = new ZipInputStream(istream);
/*     */     }
/*     */     catch (Exception e) {
/* 183 */       return;
/*     */     }
/*     */     try
/*     */     {
/*     */       ZipEntry entry;
/* 187 */       while ((entry = in.getNextEntry()) != null) {
/* 188 */         if (entry.getName().equals("PLUGIN"))
/*     */         {
/*     */           int len;
/* 190 */           while ((len = in.read()) != -1) {
/* 191 */             f2stream.write(len);
/*     */           }
/* 193 */           f2stream.write(10);
/*     */         }
/* 196 */         else if (entry.isDirectory()) {
/* 197 */           new File("./plugins/" + entry.getName()).mkdirs();
/*     */         }
/*     */         else {
/* 200 */           File f3 = new File("./plugins/" + entry.getName());
/* 201 */           FileOutputStream ost = new FileOutputStream(f3);
/*     */           int len;
/* 203 */           while ((len = in.read()) != -1) {
/* 204 */             ost.write(len);
/*     */           }
/* 206 */           ost.close();
/* 207 */           files = files + "File=" + entry.getName() + "\n";
/*     */         }
/*     */       }
/*     */ 
/* 211 */       f2stream.write(files.getBytes());
/* 212 */       f2stream.close();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.PluginDialog
 * JD-Core Version:    0.6.2
 */