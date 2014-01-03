/*     */ package org.gcreator.editors;
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseMotionAdapter;
/*     */ import java.beans.PropertyChangeEvent;
/*     */ import java.beans.PropertyChangeListener;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Vector;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JSpinner;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ import javax.swing.event.DocumentEvent;
/*     */ import javax.swing.event.DocumentListener;
/*     */ import javax.swing.text.Document;
/*     */ import org.gcreator.components.SubimagePreview;
/*     */ import org.gcreator.components.TabPanel;
/*     */ import org.gcreator.components.WorkspaceTree;
/*     */ import org.gcreator.components.resource.ResourceChooser;
/*     */ import org.gcreator.core.Aurwindow;
/*     */ import org.gcreator.fileclass.GFile;
/*     */ import org.gcreator.fileclass.Project;
/*     */ import org.gcreator.fileclass.res.GImage;
/*     */ import org.gcreator.fileclass.res.Sprite;
/*     */ import org.gcreator.managers.LangSupporter;
/*     */ import org.gcreator.units.Dictionary;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class SpriteEditor extends TabPanel
/*     */ {
/*     */   public Sprite sprite;
/*     */   boolean changed;
/*     */   private SubimagePreview prev;
/*     */   private ResourceChooser res;
/*  30 */   private boolean dragging = false;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JButton jButton3;
/*     */   private JButton jButton4;
/*     */   private JButton jButton6;
/*     */   private JButton jButton8;
/*     */   private JButton jButton9;
/*     */   private JCheckBox jCheckBox1;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel10;
/*     */   private JLabel jLabel11;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel7;
/*     */   private JLabel jLabel8;
/*     */   private JLabel jLabel9;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel13;
/*     */   private JPanel jPanel2;
/*     */   private JPanel jPanel4;
/*     */   private JPanel jPanel5;
/*     */   private JPanel jPanel6;
/*     */   private JScrollPane jScrollPane1;
/*     */   public JSpinner jSpinner1;
/*     */   public JSpinner jSpinner2;
/*     */   public JSpinner jSpinner3;
/*     */   public JSpinner jSpinner4;
/*     */   public JSpinner jSpinner5;
/*     */   public JSpinner jSpinner6;
/*     */   private JTabbedPane jTabbedPane1;
/*     */   private JTextField jTextField1;
/*     */   private JTextField jTextField2;
/*     */ 
/*     */   public SpriteEditor(GFile file, Project project)
/*     */   {
/*  34 */     this.project = project;
/*  35 */     this.file = file;
/*     */ 
/*  39 */     if (file.value != null) {
/*  40 */       if ((file.value instanceof String)) {
/*  41 */         Sprite spr = new Sprite(file.name);
/*  42 */         spr.readXml((String)file.value);
/*  43 */         file.value = spr;
/*     */       }
/*     */       else {
/*  46 */         this.sprite = ((Sprite)file.value);
/*     */       }
/*     */     }
/*  49 */     else this.sprite = ((Sprite)(file.value = new Sprite(file.name)));
/*  50 */     initComponents();
/*  51 */     load();
/*     */     try
/*     */     {
/*  58 */       this.jTextField1.setText(file.name);
/*     */     } catch (NullPointerException e) {
/*     */     }
/*  61 */     this.jScrollPane1.setViewportView(this.prev = new SubimagePreview(this));
/*     */ 
/*  63 */     this.jPanel13.add(this.res = new ResourceChooser(project, "image"));
/*     */ 
/*  65 */     this.jTextField1.getDocument().addDocumentListener(new DocumentListener() {
/*     */       public void changedUpdate(DocumentEvent evt) {
/*  67 */         SpriteEditor.this.updateName();
/*     */       }
/*     */       public void insertUpdate(DocumentEvent evt) {
/*  70 */         SpriteEditor.this.updateName();
/*     */       }
/*     */       public void removeUpdate(DocumentEvent evt) {
/*  73 */         SpriteEditor.this.updateName();
/*     */       }
/*     */     });
/*  77 */     this.jButton3.setText("");
/*  78 */     this.jButton3.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/subimageright.png")));
/*  79 */     this.jButton4.setText("");
/*  80 */     this.jButton4.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/subimageleft.png")));
/*     */   }
/*     */ 
/*     */   public void updateName() {
/*  84 */     this.file.name = this.jTextField1.getText();
/*  85 */     this.sprite.name = this.file.name;
/*  86 */     Aurwindow.workspace.updateUI();
/*     */   }
/*     */ 
/*     */   public boolean Save()
/*     */   {
/*  91 */     this.sprite.BBBottom = ((Integer)this.jSpinner6.getValue()).intValue();
/*  92 */     this.sprite.BBRight = ((Integer)this.jSpinner5.getValue()).intValue();
/*  93 */     this.sprite.BBTop = ((Integer)this.jSpinner4.getValue()).intValue();
/*  94 */     this.sprite.BBleft = ((Integer)this.jSpinner3.getValue()).intValue();
/*     */ 
/*  96 */     this.sprite.originX = ((Integer)this.jSpinner1.getValue()).intValue();
/*  97 */     this.sprite.originY = ((Integer)this.jSpinner2.getValue()).intValue();
/*     */ 
/*  99 */     this.sprite.precise = this.jCheckBox1.isSelected();
/* 100 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean wasModified()
/*     */   {
/* 106 */     return this.changed;
/*     */   }
/*     */ 
/*     */   public void load()
/*     */   {
/* 111 */     if (this.sprite == null)
/*     */     {
/* 113 */       this.sprite = new Sprite(this.file.name);
/* 114 */       return;
/*     */     }
/* 116 */     System.out.println("Loading");
/* 117 */     this.jSpinner1.setValue(Integer.valueOf(this.sprite.originX));
/* 118 */     this.jSpinner2.setValue(Integer.valueOf(this.sprite.originY));
/*     */ 
/* 120 */     this.jSpinner6.setValue(Integer.valueOf(this.sprite.BBBottom));
/* 121 */     this.jSpinner5.setValue(Integer.valueOf(this.sprite.BBRight));
/* 122 */     this.jSpinner4.setValue(Integer.valueOf(this.sprite.BBTop));
/* 123 */     this.jSpinner3.setValue(Integer.valueOf(this.sprite.BBleft));
/*     */ 
/* 125 */     this.jCheckBox1.setSelected(this.sprite.precise);
/* 126 */     this.jLabel2.setText("Width: " + this.sprite.width);
/* 127 */     this.jLabel3.setText("Height: " + this.sprite.height);
/* 128 */     this.jLabel4.setText("Subimages: " + this.sprite.countImages());
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 139 */     this.jLabel1 = new JLabel();
/* 140 */     this.jTextField1 = new JTextField();
/* 141 */     this.jScrollPane1 = new JScrollPane();
/* 142 */     this.jTabbedPane1 = new JTabbedPane();
/* 143 */     this.jPanel4 = new JPanel();
/* 144 */     this.jPanel13 = new JPanel();
/* 145 */     this.jButton2 = new JButton();
/* 146 */     this.jLabel3 = new JLabel();
/* 147 */     this.jLabel2 = new JLabel();
/* 148 */     this.jLabel4 = new JLabel();
/* 149 */     this.jButton3 = new JButton();
/* 150 */     this.jLabel5 = new JLabel();
/* 151 */     this.jButton4 = new JButton();
/* 152 */     this.jTextField2 = new JTextField();
/* 153 */     this.jButton1 = new JButton();
/* 154 */     this.jPanel5 = new JPanel();
/* 155 */     this.jPanel2 = new JPanel();
/* 156 */     this.jLabel8 = new JLabel();
/* 157 */     this.jLabel9 = new JLabel();
/* 158 */     this.jLabel10 = new JLabel();
/* 159 */     this.jLabel11 = new JLabel();
/* 160 */     this.jSpinner3 = new JSpinner();
/* 161 */     this.jSpinner4 = new JSpinner();
/* 162 */     this.jSpinner5 = new JSpinner();
/* 163 */     this.jSpinner6 = new JSpinner();
/* 164 */     this.jButton8 = new JButton();
/* 165 */     this.jButton9 = new JButton();
/* 166 */     this.jCheckBox1 = new JCheckBox();
/* 167 */     this.jPanel6 = new JPanel();
/* 168 */     this.jPanel1 = new JPanel();
/* 169 */     this.jLabel6 = new JLabel();
/* 170 */     this.jLabel7 = new JLabel();
/* 171 */     this.jButton6 = new JButton();
/* 172 */     this.jSpinner1 = new JSpinner();
/* 173 */     this.jSpinner2 = new JSpinner();
/*     */ 
/* 175 */     this.jLabel1.setText("Name:");
/*     */ 
/* 177 */     this.jTextField1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 179 */         SpriteEditor.this.jTextField1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 183 */     this.jScrollPane1.setBorder(BorderFactory.createEtchedBorder());
/* 184 */     this.jScrollPane1.addMouseListener(new MouseAdapter() {
/*     */       public void mousePressed(MouseEvent evt) {
/* 186 */         SpriteEditor.this.jScrollPane1MousePressed(evt);
/*     */       }
/*     */       public void mouseReleased(MouseEvent evt) {
/* 189 */         SpriteEditor.this.jScrollPane1MouseReleased(evt);
/*     */       }
/*     */     });
/* 192 */     this.jScrollPane1.addMouseMotionListener(new MouseMotionAdapter() {
/*     */       public void mouseDragged(MouseEvent evt) {
/* 194 */         SpriteEditor.this.jScrollPane1MouseDragged(evt);
/*     */       }
/*     */     });
/* 198 */     this.jPanel4.setBorder(BorderFactory.createTitledBorder("Image"));
/*     */ 
/* 200 */     this.jPanel13.setLayout(new BorderLayout());
/*     */ 
/* 202 */     this.jButton2.setText(LangSupporter.activeLang.getEntry(133));
/* 203 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 205 */         SpriteEditor.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 209 */     this.jLabel3.setText("Height:");
/*     */ 
/* 211 */     this.jLabel2.setText("Width:");
/*     */ 
/* 213 */     this.jLabel4.setText("Subimages:");
/*     */ 
/* 215 */     this.jButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 217 */         SpriteEditor.this.jButton3ActionPerformed(evt);
/*     */       }
/*     */     });
/* 221 */     this.jLabel5.setText("Show:");
/*     */ 
/* 223 */     this.jButton4.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 225 */         SpriteEditor.this.jButton4ActionPerformed(evt);
/*     */       }
/*     */     });
/* 229 */     this.jTextField2.setEditable(false);
/* 230 */     this.jTextField2.setHorizontalAlignment(0);
/* 231 */     this.jTextField2.setText("0");
/*     */ 
/* 233 */     this.jButton1.setText(LangSupporter.activeLang.getEntry(135));
/* 234 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 236 */         SpriteEditor.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 240 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 241 */     this.jPanel4.setLayout(jPanel4Layout);
/* 242 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(1).add(this.jPanel13, -1, 190, 32767).add(this.jButton2, -1, 190, 32767).add(jPanel4Layout.createSequentialGroup().add(this.jLabel2, -2, 57, -2).addPreferredGap(0).add(this.jLabel3, -1, 115, 32767).add(12, 12, 12)).add(2, jPanel4Layout.createSequentialGroup().add(2, 2, 2).add(this.jLabel4, -1, 178, 32767).addContainerGap()).add(jPanel4Layout.createSequentialGroup().add(81, 81, 81).add(this.jTextField2, -2, 26, -2).addPreferredGap(1).add(this.jButton4, -1, 71, 32767).add(2, 2, 2)).add(jPanel4Layout.createParallelGroup(1).add(jPanel4Layout.createSequentialGroup().add(2, 2, 2).add(jPanel4Layout.createParallelGroup(1).add(this.jLabel5).add(this.jButton1, -1, 186, 32767).add(this.jButton3, -2, 71, -2)).add(2, 2, 2))));
/*     */ 
/* 270 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(1).add(jPanel4Layout.createSequentialGroup().add(this.jPanel13, -2, 24, -2).addPreferredGap(0).add(this.jButton2).addPreferredGap(0).add(jPanel4Layout.createParallelGroup(3).add(this.jLabel2).add(this.jLabel3)).addPreferredGap(0).add(this.jLabel4).addPreferredGap(0, 145, 32767).add(this.jTextField2, -2, -1, -2).add(51, 51, 51)).add(jPanel4Layout.createParallelGroup(1).add(2, jPanel4Layout.createSequentialGroup().addContainerGap(216, 32767).add(this.jLabel5).addPreferredGap(0).add(jPanel4Layout.createParallelGroup(3).add(this.jButton3, -2, 22, -2).add(this.jButton4, -2, 22, -2)).addPreferredGap(0).add(this.jButton1).add(21, 21, 21))));
/*     */ 
/* 298 */     this.jTabbedPane1.addTab("General", this.jPanel4);
/*     */ 
/* 300 */     this.jPanel2.setBorder(BorderFactory.createTitledBorder("Bounding Box"));
/*     */ 
/* 302 */     this.jLabel8.setText("Left:");
/*     */ 
/* 304 */     this.jLabel9.setText("Right:");
/*     */ 
/* 306 */     this.jLabel10.setText("Top:");
/*     */ 
/* 308 */     this.jLabel11.setText("Bottom:");
/*     */ 
/* 310 */     this.jSpinner3.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent evt) {
/* 312 */         SpriteEditor.this.jSpinner3StateChanged(evt);
/*     */       }
/*     */     });
/* 316 */     this.jSpinner4.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent evt) {
/* 318 */         SpriteEditor.this.jSpinner4StateChanged(evt);
/*     */       }
/*     */     });
/* 322 */     this.jSpinner5.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent evt) {
/* 324 */         SpriteEditor.this.jSpinner5StateChanged(evt);
/*     */       }
/*     */     });
/* 328 */     this.jSpinner6.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent evt) {
/* 330 */         SpriteEditor.this.jSpinner6StateChanged(evt);
/*     */       }
/*     */     });
/* 334 */     this.jButton8.setText("Automatic");
/* 335 */     this.jButton8.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 337 */         SpriteEditor.this.jButton8ActionPerformed(evt);
/*     */       }
/*     */     });
/* 341 */     this.jButton9.setText("Full Image");
/* 342 */     this.jButton9.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 344 */         SpriteEditor.this.jButton9ActionPerformed(evt);
/*     */       }
/*     */     });
/* 348 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 349 */     this.jPanel2.setLayout(jPanel2Layout);
/* 350 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(1).add(jPanel2Layout.createSequentialGroup().addContainerGap().add(jPanel2Layout.createParallelGroup(1).add(jPanel2Layout.createSequentialGroup().add(jPanel2Layout.createParallelGroup(1).add(this.jLabel11).add(this.jLabel9).add(this.jLabel8).add(this.jLabel10)).add(31, 31, 31).add(jPanel2Layout.createParallelGroup(1).add(this.jSpinner6, -1, 81, 32767).add(this.jSpinner4, -1, 81, 32767).add(this.jSpinner3, -1, 81, 32767).add(this.jSpinner5, -1, 81, 32767))).add(this.jButton8, -1, 150, 32767).add(2, this.jButton9, -1, 150, 32767)).addContainerGap()));
/*     */ 
/* 371 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(1).add(jPanel2Layout.createSequentialGroup().add(this.jButton8).addPreferredGap(0).add(this.jButton9).addPreferredGap(0, 28, 32767).add(jPanel2Layout.createParallelGroup(3).add(this.jLabel10).add(this.jSpinner4, -2, -1, -2)).addPreferredGap(0).add(jPanel2Layout.createParallelGroup(3).add(this.jLabel11).add(this.jSpinner6, -2, -1, -2)).addPreferredGap(0).add(jPanel2Layout.createParallelGroup(3).add(this.jLabel9).add(this.jSpinner5, -2, -1, -2)).addPreferredGap(0).add(jPanel2Layout.createParallelGroup(3).add(this.jLabel8).add(this.jSpinner3, -2, -1, -2))));
/*     */ 
/* 395 */     this.jCheckBox1.setSelected(true);
/* 396 */     this.jCheckBox1.setText("Precise collision checking");
/* 397 */     this.jCheckBox1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 399 */         SpriteEditor.this.jCheckBox1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 402 */     this.jCheckBox1.addPropertyChangeListener(new PropertyChangeListener() {
/*     */       public void propertyChange(PropertyChangeEvent evt) {
/* 404 */         SpriteEditor.this.jCheckBox1PropertyChange(evt);
/*     */       }
/*     */     });
/* 408 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 409 */     this.jPanel5.setLayout(jPanel5Layout);
/* 410 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(1).add(jPanel5Layout.createSequentialGroup().addContainerGap().add(jPanel5Layout.createParallelGroup(1).add(this.jPanel2, -1, -1, 32767).add(this.jCheckBox1)).addContainerGap()));
/*     */ 
/* 419 */     jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(1).add(2, jPanel5Layout.createSequentialGroup().addContainerGap().add(this.jPanel2, -2, -1, -2).addPreferredGap(0, 90, 32767).add(this.jCheckBox1).addContainerGap()));
/*     */ 
/* 429 */     this.jTabbedPane1.addTab("Collision", this.jPanel5);
/*     */ 
/* 431 */     this.jPanel1.setBorder(BorderFactory.createTitledBorder("Origin"));
/*     */ 
/* 433 */     this.jLabel6.setText("X:");
/*     */ 
/* 435 */     this.jLabel7.setText("Y:");
/*     */ 
/* 437 */     this.jButton6.setText("Centre");
/* 438 */     this.jButton6.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 440 */         SpriteEditor.this.jButton6ActionPerformed(evt);
/*     */       }
/*     */     });
/* 444 */     this.jSpinner1.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 446 */         SpriteEditor.this.jSpinner1MouseClicked(evt);
/*     */       }
/*     */     });
/* 449 */     this.jSpinner1.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent evt) {
/* 451 */         SpriteEditor.this.jSpinner1StateChanged(evt);
/*     */       }
/*     */     });
/* 454 */     this.jSpinner1.addKeyListener(new KeyAdapter() {
/*     */       public void keyTyped(KeyEvent evt) {
/* 456 */         SpriteEditor.this.jSpinner1KeyTyped(evt);
/*     */       }
/*     */     });
/* 460 */     this.jSpinner2.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 462 */         SpriteEditor.this.jSpinner2MouseClicked(evt);
/*     */       }
/*     */     });
/* 465 */     this.jSpinner2.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent evt) {
/* 467 */         SpriteEditor.this.jSpinner2StateChanged(evt);
/*     */       }
/*     */     });
/* 471 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 472 */     this.jPanel1.setLayout(jPanel1Layout);
/* 473 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().add(this.jLabel6).addPreferredGap(0).add(this.jSpinner1, -2, 46, -2).addPreferredGap(0).add(jPanel1Layout.createParallelGroup(1).add(this.jButton6).add(jPanel1Layout.createSequentialGroup().add(12, 12, 12).add(this.jLabel7, -2, 18, -2).addPreferredGap(0).add(this.jSpinner2, -1, 60, 32767))).addContainerGap()));
/*     */ 
/* 489 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().add(jPanel1Layout.createParallelGroup(3).add(this.jLabel6).add(this.jSpinner2, -2, -1, -2).add(this.jLabel7).add(this.jSpinner1, -2, -1, -2)).addPreferredGap(0, -1, 32767).add(this.jButton6)));
/*     */ 
/* 501 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 502 */     this.jPanel6.setLayout(jPanel6Layout);
/* 503 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(1).add(jPanel6Layout.createSequentialGroup().addContainerGap().add(this.jPanel1, -1, -1, 32767).addContainerGap()));
/*     */ 
/* 510 */     jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(1).add(jPanel6Layout.createSequentialGroup().addContainerGap().add(this.jPanel1, -2, -1, -2).addContainerGap(249, 32767)));
/*     */ 
/* 518 */     this.jTabbedPane1.addTab("Other", this.jPanel6);
/*     */ 
/* 520 */     GroupLayout layout = new GroupLayout(this);
/* 521 */     setLayout(layout);
/* 522 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(this.jLabel1).addPreferredGap(0).add(this.jTextField1, -2, 111, -2)).add(this.jTabbedPane1, -2, 211, -2)).addPreferredGap(0).add(this.jScrollPane1, -1, 422, 32767).addContainerGap()));
/*     */ 
/* 536 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(2, layout.createSequentialGroup().add(layout.createParallelGroup(2).add(1, layout.createSequentialGroup().addContainerGap().add(this.jScrollPane1, -1, 394, 32767)).add(1, layout.createSequentialGroup().add(12, 12, 12).add(layout.createParallelGroup(3).add(this.jLabel1, -2, 17, -2).add(this.jTextField1, -2, 20, -2)).addPreferredGap(0).add(this.jTabbedPane1, -1, 367, 32767))).addContainerGap()));
/*     */   }
/*     */ 
/*     */   private void jTextField1ActionPerformed(ActionEvent evt)
/*     */   {
/* 555 */     this.file.name = this.jTextField1.getText();
/* 556 */     Aurwindow.workspace.updateUI();
/*     */   }
/*     */ 
/*     */   private void jSpinner1MouseClicked(MouseEvent evt) {
/* 560 */     this.changed = true;
/*     */   }
/*     */ 
/*     */   private void jSpinner1KeyTyped(KeyEvent evt) {
/* 564 */     this.changed = true;
/*     */   }
/*     */ 
/*     */   private void jSpinner2MouseClicked(MouseEvent evt) {
/* 568 */     this.changed = true;
/*     */   }
/*     */ 
/*     */   private void jCheckBox1ActionPerformed(ActionEvent evt) {
/* 572 */     this.sprite.precise = this.jCheckBox1.isSelected();
/*     */   }
/*     */ 
/*     */   private void jCheckBox1PropertyChange(PropertyChangeEvent evt) {
/* 576 */     this.sprite.precise = this.jCheckBox1.isSelected();
/*     */   }
/*     */ 
/*     */   private void jSpinner1StateChanged(ChangeEvent evt) {
/* 580 */     this.sprite.originX = ((Integer)this.jSpinner1.getValue()).intValue();
/* 581 */     this.jScrollPane1.updateUI();
/*     */   }
/*     */ 
/*     */   private void jSpinner2StateChanged(ChangeEvent evt) {
/* 585 */     this.sprite.originY = ((Integer)this.jSpinner2.getValue()).intValue();
/* 586 */     this.jScrollPane1.updateUI();
/*     */   }
/*     */ 
/*     */   private void jSpinner4StateChanged(ChangeEvent evt) {
/* 590 */     this.sprite.BBTop = ((Integer)this.jSpinner4.getValue()).intValue();
/* 591 */     this.jScrollPane1.updateUI();
/*     */   }
/*     */ 
/*     */   private void jSpinner6StateChanged(ChangeEvent evt) {
/* 595 */     this.sprite.BBBottom = ((Integer)this.jSpinner6.getValue()).intValue();
/* 596 */     this.jScrollPane1.updateUI();
/*     */   }
/*     */ 
/*     */   private void jSpinner5StateChanged(ChangeEvent evt) {
/* 600 */     this.sprite.BBRight = ((Integer)this.jSpinner5.getValue()).intValue();
/* 601 */     this.jScrollPane1.updateUI();
/*     */   }
/*     */ 
/*     */   private void jSpinner3StateChanged(ChangeEvent evt) {
/* 605 */     this.sprite.BBleft = ((Integer)this.jSpinner3.getValue()).intValue();
/* 606 */     this.jScrollPane1.updateUI();
/*     */   }
/*     */ 
/*     */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 610 */     this.jSpinner1.setValue(Integer.valueOf(this.sprite.width / 2));
/* 611 */     this.jSpinner2.setValue(Integer.valueOf(this.sprite.height / 2));
/*     */   }
/*     */ 
/*     */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 615 */     this.jSpinner3.setValue(Integer.valueOf(this.sprite.width - 1));
/* 616 */     this.jSpinner4.setValue(Integer.valueOf(0));
/* 617 */     this.jSpinner5.setValue(Integer.valueOf(0));
/* 618 */     this.jSpinner6.setValue(Integer.valueOf(this.sprite.height - 1));
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 622 */     GFile a = this.res.getFile();
/* 623 */     Object o = a.value;
/* 624 */     if (this.sprite.countImages() == 0) {
/* 625 */       this.sprite.width = ((GImage)o).image.getIconWidth();
/* 626 */       this.sprite.height = ((GImage)o).image.getIconHeight();
/* 627 */       this.jLabel2.setText("Width:" + this.sprite.width);
/* 628 */       this.jLabel3.setText("Height:" + this.sprite.height);
/* 629 */       jButton9ActionPerformed(evt);
/*     */     }
/*     */ 
/* 632 */     if ((this.sprite.width == ((GImage)o).image.getIconWidth()) && (this.sprite.height == ((GImage)o).image.getIconHeight()))
/* 633 */       this.sprite.addToList(this.res.getFile());
/*     */     else
/* 635 */       System.out.println("Image not right size!");
/* 636 */     this.jLabel4.setText("Subimages:" + this.sprite.countImages());
/* 637 */     this.jScrollPane1.updateUI();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 641 */     int id = getViewedId();
/* 642 */     this.sprite.Simages.remove(id);
/* 643 */     if (id >= this.sprite.countImages())
/* 644 */       id = 0;
/* 645 */     this.jLabel4.setText("Subimages: " + this.sprite.countImages());
/* 646 */     setViewedId(id);
/*     */   }
/*     */ 
/*     */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 650 */     int id = getViewedId() + 1;
/* 651 */     if (id >= this.sprite.countImages())
/* 652 */       id = 0;
/* 653 */     setViewedId(id);
/*     */   }
/*     */ 
/*     */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 657 */     int id = getViewedId() - 1;
/* 658 */     if (id < 0)
/* 659 */       id = Math.max(0, this.sprite.countImages() - 1);
/* 660 */     setViewedId(id);
/*     */   }
/*     */ 
/*     */   private void jScrollPane1MouseDragged(MouseEvent evt) {
/* 664 */     if (!this.dragging) {
/* 665 */       return;
/*     */     }
/* 667 */     int x = evt.getX() - 2;
/* 668 */     int y = evt.getY() - 2;
/* 669 */     this.sprite.originX = x;
/* 670 */     this.sprite.originY = y;
/* 671 */     this.jSpinner1.setValue(Integer.valueOf(x));
/* 672 */     this.jSpinner2.setValue(Integer.valueOf(y));
/* 673 */     this.prev.repaint();
/*     */   }
/*     */ 
/*     */   private void jScrollPane1MousePressed(MouseEvent evt) {
/* 677 */     if ((evt.getX() > this.sprite.width) || (evt.getY() > this.sprite.height))
/* 678 */       return;
/* 679 */     this.dragging = true;
/* 680 */     jScrollPane1MouseDragged(evt);
/*     */   }
/*     */ 
/*     */   private void jScrollPane1MouseReleased(MouseEvent evt) {
/* 684 */     this.dragging = false;
/*     */   }
/*     */ 
/*     */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 688 */     setAutomaticBounds();
/*     */   }
/*     */ 
/*     */   public int getViewedId() {
/*     */     try {
/* 693 */       return Integer.parseInt(this.jTextField2.getText());
/*     */     } catch (Throwable t) {
/*     */     }
/* 696 */     return -1;
/*     */   }
/*     */ 
/*     */   public void setViewedId(int id)
/*     */   {
/* 701 */     this.jTextField2.setText("" + id);
/* 702 */     this.jScrollPane1.updateUI();
/*     */   }
/*     */ 
/*     */   public ImageIcon getImageAt(int id)
/*     */   {
/* 708 */     return this.sprite.getImageAt(id);
/*     */   }
/*     */ 
/*     */   public ImageIcon getCurrentImage() {
/* 712 */     return getImageAt(getViewedId());
/*     */   }
/*     */ 
/*     */   private void setAutomaticBounds()
/*     */   {
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.editors.SpriteEditor
 * JD-Core Version:    0.6.2
 */