/*     */ package org.gcreator.editors;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Iterator;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.imageio.ImageReader;
/*     */ import javax.imageio.stream.FileImageInputStream;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.ButtonGroup;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JSpinner;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ import javax.swing.event.DocumentEvent;
/*     */ import javax.swing.event.DocumentListener;
/*     */ import javax.swing.text.Document;
/*     */ import org.gcreator.components.ColorSelection;
/*     */ import org.gcreator.components.ImageDisplayer;
/*     */ import org.gcreator.components.JFileFilter;
/*     */ import org.gcreator.components.TabPanel;
/*     */ import org.gcreator.components.WorkspaceTree;
/*     */ import org.gcreator.core.Aurwindow;
/*     */ import org.gcreator.fileclass.GFile;
/*     */ import org.gcreator.fileclass.Project;
/*     */ import org.gcreator.fileclass.res.GImage;
/*     */ import org.gcreator.managers.LangSupporter;
/*     */ import org.gcreator.units.Dictionary;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class ImageEditor extends TabPanel
/*     */ {
/*     */   private ImageDisplayer displayer;
/*     */   public GImage image;
/* 279 */   public static JFileChooser jFileChooser1 = null;
/*     */   private ButtonGroup buttonGroup1;
/*     */   private ColorSelection colorSelection1;
/*     */   private JLabel heightLabel;
/*     */   private JButton jButton1;
/*     */   private JCheckBox jCheckBox1;
/*     */   private JLabel jLabel1;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JSpinner jSpinner1;
/*     */   private JTextField jTextField1;
/*     */   private JLabel widthLabel;
/*     */ 
/*     */   public Color getTransparencyColor()
/*     */   {
/*  33 */     return this.colorSelection1.getBackground();
/*     */   }
/*     */ 
/*     */   public boolean getTransparent() {
/*  37 */     return this.jCheckBox1.isSelected();
/*     */   }
/*     */ 
/*     */   public ImageEditor(GFile file, Project project) {
/*  41 */     this.project = project;
/*  42 */     this.file = file;
/*  43 */     this.displayer = new ImageDisplayer(this, file);
/*  44 */     initComponents();
/*     */ 
/*  46 */     this.project = project;
/*  47 */     if (file.value == null) {
/*  48 */       this.image = new GImage(file.name);
/*  49 */       this.image.readXml(file.xml);
/*  50 */       file.value = this.image;
/*  51 */     } else if ((file.value instanceof GImage)) {
/*  52 */       this.image = ((GImage)file.value);
/*     */     }
/*  54 */     this.file = file;
/*     */ 
/*  56 */     this.jScrollPane1.setViewportView(this.displayer);
/*     */ 
/*  58 */     this.jTextField1.setText(file.name);
/*  59 */     this.jTextField1.getDocument().addDocumentListener(new DocumentListener() {
/*     */       public void changedUpdate(DocumentEvent evt) {
/*  61 */         ImageEditor.this.updateName();
/*     */       }
/*     */       public void insertUpdate(DocumentEvent evt) {
/*  64 */         ImageEditor.this.updateName();
/*     */       }
/*     */       public void removeUpdate(DocumentEvent evt) {
/*  67 */         ImageEditor.this.updateName();
/*     */       }
/*     */     });
/*  71 */     int w = 0;
/*  72 */     int h = 0;
/*     */     try {
/*  74 */       ImageIcon img = ((GImage)file.value).image;
/*  75 */       w = img.getIconWidth();
/*  76 */       h = img.getIconHeight();
/*     */     } catch (NullPointerException exc) {
/*     */     }
/*  79 */     this.widthLabel.setText("Width: " + w);
/*  80 */     this.heightLabel.setText("Height: " + h);
/*  81 */     load();
/*     */   }
/*     */ 
/*     */   public void load()
/*     */   {
/*  86 */     if (this.image == null)
/*     */     {
/*  88 */       this.image = new GImage(this.file.name);
/*  89 */       return;
/*     */     }
/*  91 */     this.colorSelection1.setBackground(this.image.transparentColor);
/*  92 */     this.jCheckBox1.setSelected(this.image.transparent);
/*     */   }
/*     */ 
/*     */   public boolean wasModified()
/*     */   {
/*  98 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean canSave()
/*     */   {
/* 104 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean Save()
/*     */   {
/* 110 */     return true;
/*     */   }
/*     */ 
/*     */   public void updateName() {
/* 114 */     this.file.name = this.jTextField1.getText();
/* 115 */     Aurwindow.workspace.updateUI();
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 126 */     this.buttonGroup1 = new ButtonGroup();
/* 127 */     this.jScrollPane1 = new JScrollPane();
/* 128 */     this.jPanel1 = new JPanel();
/* 129 */     this.colorSelection1 = new ColorSelection();
/* 130 */     this.jCheckBox1 = new JCheckBox();
/* 131 */     this.jPanel2 = new JPanel();
/* 132 */     this.jSpinner1 = new JSpinner();
/* 133 */     this.heightLabel = new JLabel();
/* 134 */     this.jLabel1 = new JLabel();
/* 135 */     this.widthLabel = new JLabel();
/* 136 */     this.jTextField1 = new JTextField();
/* 137 */     this.jButton1 = new JButton();
/*     */ 
/* 139 */     this.jScrollPane1.setBorder(BorderFactory.createEtchedBorder());
/*     */ 
/* 141 */     this.jPanel1.setBorder(BorderFactory.createTitledBorder("Transparency"));
/*     */ 
/* 143 */     this.colorSelection1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 144 */     this.colorSelection1.setToolTipText("Transparent Colour");
/* 145 */     this.colorSelection1.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 147 */         ImageEditor.this.colorSelection1MouseClicked(evt);
/*     */       }
/*     */     });
/* 151 */     GroupLayout colorSelection1Layout = new GroupLayout(this.colorSelection1);
/* 152 */     this.colorSelection1.setLayout(colorSelection1Layout);
/* 153 */     colorSelection1Layout.setHorizontalGroup(colorSelection1Layout.createParallelGroup(1).add(0, 36, 32767));
/*     */ 
/* 157 */     colorSelection1Layout.setVerticalGroup(colorSelection1Layout.createParallelGroup(1).add(0, 34, 32767));
/*     */ 
/* 162 */     this.jCheckBox1.setText("Transparent");
/* 163 */     this.jCheckBox1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 165 */         ImageEditor.this.jCheckBox1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 169 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 170 */     this.jPanel1.setLayout(jPanel1Layout);
/* 171 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().addContainerGap().add(this.colorSelection1, -2, -1, -2).add(18, 18, 18).add(this.jCheckBox1).addContainerGap(-1, 32767)));
/*     */ 
/* 180 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().add(jPanel1Layout.createParallelGroup(1).add(this.colorSelection1, -1, -1, 32767).add(this.jCheckBox1, -1, 36, 32767)).addContainerGap()));
/*     */ 
/* 189 */     this.jPanel2.setBorder(BorderFactory.createTitledBorder("Image"));
/*     */ 
/* 191 */     this.jSpinner1.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent evt) {
/* 193 */         ImageEditor.this.jSpinner1StateChanged(evt);
/*     */       }
/*     */     });
/* 197 */     this.heightLabel.setText("height");
/*     */ 
/* 199 */     this.jLabel1.setText(LangSupporter.activeLang.getEntry(119));
/*     */ 
/* 201 */     this.widthLabel.setText("width");
/*     */ 
/* 203 */     this.jTextField1.setText("jTextField1");
/* 204 */     this.jTextField1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 206 */         ImageEditor.this.jTextField1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 210 */     this.jButton1.setText(LangSupporter.activeLang.getEntry(118));
/* 211 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 213 */         ImageEditor.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 217 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 218 */     this.jPanel2.setLayout(jPanel2Layout);
/* 219 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(1).add(jPanel2Layout.createSequentialGroup().addContainerGap().add(jPanel2Layout.createParallelGroup(1).add(jPanel2Layout.createSequentialGroup().add(10, 10, 10).add(this.widthLabel).addPreferredGap(0).add(this.heightLabel)).add(jPanel2Layout.createSequentialGroup().add(this.jButton1).addPreferredGap(0).add(this.jTextField1, -2, 162, -2).addPreferredGap(0).add(this.jLabel1).add(10, 10, 10).add(this.jSpinner1, -2, 35, -2))).addContainerGap(-1, 32767)));
/*     */ 
/* 239 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(1).add(jPanel2Layout.createSequentialGroup().add(jPanel2Layout.createParallelGroup(3).add(this.jButton1).add(this.jTextField1, -2, -1, -2).add(this.jLabel1).add(this.jSpinner1, -2, 23, -2)).addPreferredGap(0, 10, 32767).add(jPanel2Layout.createParallelGroup(3).add(this.widthLabel).add(this.heightLabel))));
/*     */ 
/* 253 */     GroupLayout layout = new GroupLayout(this);
/* 254 */     setLayout(layout);
/* 255 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(this.jScrollPane1, -1, 611, 32767).add(layout.createSequentialGroup().add(this.jPanel2, -2, -1, -2).addPreferredGap(1).add(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)))));
/*     */ 
/* 267 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1, false).add(this.jPanel2, -1, -1, 32767).add(this.jPanel1, -1, -1, 32767)).addPreferredGap(1).add(this.jScrollPane1, -1, 287, 32767)));
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/* 282 */     if (jFileChooser1 == null) {
/* 283 */       jFileChooser1 = new JFileChooser();
/*     */     }
/*     */     try
/*     */     {
/* 287 */       jFileChooser1.resetChoosableFileFilters();
/* 288 */       JFileFilter filter = new JFileFilter(".*\\.gif|.*\\.jpg|.*\\.png", "Image Files (*.png, *.gif, *.jpg)");
/* 289 */       jFileChooser1.addChoosableFileFilter(filter);
/* 290 */       JFileFilter filter2 = new JFileFilter(".*\\.*", "Any Files (*.*)");
/* 291 */       jFileChooser1.addChoosableFileFilter(filter2);
/* 292 */       jFileChooser1.setFileFilter(filter);
/* 293 */       jFileChooser1.showDialog(this, "OK");
/* 294 */       if (jFileChooser1.getSelectedFile() != null) {
/* 295 */         File _file = jFileChooser1.getSelectedFile();
/* 296 */         this.file.type = _file.getName().substring(_file.getName().lastIndexOf(".") + 1);
/* 297 */         if (this.file.type.toLowerCase().equals("gif")) {
/* 298 */           System.out.println("GIF!");
/*     */ 
/* 300 */           ImageReader reader = (ImageReader)ImageIO.getImageReadersByFormatName("gif").next();
/*     */ 
/* 304 */           reader.setInput(new FileImageInputStream(_file));
/* 305 */           System.out.println("No: " + reader.getNumImages(true));
/* 306 */           BufferedImage[] b = new BufferedImage[reader.getNumImages(true)];
/*     */ 
/* 308 */           for (int i = 0; i < reader.getNumImages(true); i++) {
/* 309 */             b[i] = reader.read(i);
/*     */           }
/* 311 */           ((GImage)this.file.value).image = new ImageIcon(b[0]);
/*     */         }
/*     */         else {
/* 314 */           ((GImage)this.file.value).image = new ImageIcon(ImageIO.read(_file));
/*     */         }
/*     */ 
/* 317 */         Aurwindow.workspace.updateUI();
/* 318 */         this.jScrollPane1.updateUI();
/* 319 */         System.out.println(this.file.name + "." + this.file.type);
/*     */       }
/*     */     } catch (Exception e) {
/*     */     }
/* 323 */     int w = 0;
/* 324 */     int h = 0;
/* 325 */     if (this.file.value != null)
/*     */     {
/* 332 */       w = ((GImage)this.file.value).image.getIconWidth();
/* 333 */       h = ((GImage)this.file.value).image.getIconHeight();
/*     */     }
/*     */ 
/* 336 */     this.widthLabel.setText("Width: " + w);
/* 337 */     this.heightLabel.setText("Height: " + h);
/*     */   }
/*     */ 
/*     */   private void jTextField1ActionPerformed(ActionEvent evt) {
/* 341 */     this.file.name = this.jTextField1.getText();
/* 342 */     Aurwindow.workspace.updateUI();
/*     */   }
/*     */ 
/*     */   private void jSpinner1StateChanged(ChangeEvent evt) {
/* 346 */     updateScroll();
/*     */   }
/*     */ 
/*     */   private void colorSelection1MouseClicked(MouseEvent evt) {
/* 350 */     this.displayer.updateUI();
/* 351 */     this.image.transparentColor = this.colorSelection1.getBackground();
/*     */   }
/*     */ 
/*     */   private void jCheckBox1ActionPerformed(ActionEvent evt) {
/* 355 */     this.image.transparent = this.jCheckBox1.isSelected();
/*     */   }
/*     */ 
/*     */   public void updateScroll() {
/* 359 */     System.out.println("Update");
/* 360 */     if (((Integer)this.jSpinner1.getValue()).intValue() > 5)
/* 361 */       this.jSpinner1.setValue(Integer.valueOf(5));
/* 362 */     else if (((Integer)this.jSpinner1.getValue()).intValue() < -5) {
/* 363 */       this.jSpinner1.setValue(Integer.valueOf(-5));
/*     */     }
/* 365 */     this.displayer.zoom = getZoom();
/* 366 */     this.displayer.updateUI();
/* 367 */     this.jScrollPane1.updateUI();
/*     */   }
/*     */ 
/*     */   public double getZoom() {
/* 371 */     int x = ((Integer)this.jSpinner1.getValue()).intValue();
/* 372 */     switch (x) {
/*     */     case 5:
/* 374 */       return 6.0D;
/*     */     case 4:
/* 376 */       return 5.0D;
/*     */     case 3:
/* 378 */       return 4.0D;
/*     */     case 2:
/* 380 */       return 3.0D;
/*     */     case 1:
/* 382 */       return 2.0D;
/*     */     case 0:
/* 384 */       return 1.0D;
/*     */     case -1:
/* 386 */       return 0.5D;
/*     */     case -2:
/* 388 */       return 0.33D;
/*     */     case -3:
/* 390 */       return 0.25D;
/*     */     case -4:
/* 392 */       return 0.2D;
/*     */     }
/* 394 */     return 0.16D;
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.editors.ImageEditor
 * JD-Core Version:    0.6.2
 */