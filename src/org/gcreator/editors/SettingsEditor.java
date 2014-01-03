/*     */ package org.gcreator.editors;
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseMotionAdapter;
/*     */ import java.util.Vector;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.ButtonGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JRadioButton;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.border.TitledBorder;
/*     */ import org.gcreator.components.TabPanel;
/*     */ import org.gcreator.components.impl.SceneCellRenderer;
/*     */ import org.gcreator.components.impl.VectorListModel;
/*     */ import org.gcreator.components.resource.ResourceChooser;
/*     */ import org.gcreator.fileclass.GFile;
/*     */ import org.gcreator.fileclass.Project;
/*     */ import org.gcreator.fileclass.res.SettingsValues;
/*     */ import org.gcreator.fileclass.res.TabValues;
/*     */ import org.gcreator.managers.LangSupporter;
/*     */ import org.gcreator.plugins.SettingsManager;
/*     */ import org.gcreator.units.Dictionary;
/*     */ import org.gcreator.units.ObjectNode;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class SettingsEditor extends TabPanel
/*     */ {
/*     */   SettingsValues value;
/*     */   TabValues Graphics;
/*     */   TabValues Resolution;
/*     */   TabValues Other;
/*     */   TabValues SceneOrder;
/*     */   ResourceChooser scenes;
/*     */   int from;
/*  34 */   private static Vector<SettingsManager> managers = new Vector();
/*     */   private Vector<GFile> scenelist;
/*     */   private ButtonGroup buttonGroup1;
/*     */   private ButtonGroup buttonGroup2;
/*     */   private ButtonGroup buttonGroup3;
/*     */   private JButton jButton2;
/*     */   private JButton jButton3;
/*     */   private JButton jButton4;
/*     */   private JButton jButton5;
/*     */   private JCheckBox jCheckBox1;
/*     */   private JCheckBox jCheckBox10;
/*     */   private JCheckBox jCheckBox11;
/*     */   private JCheckBox jCheckBox2;
/*     */   private JCheckBox jCheckBox3;
/*     */   private JCheckBox jCheckBox4;
/*     */   private JCheckBox jCheckBox5;
/*     */   private JCheckBox jCheckBox6;
/*     */   private JCheckBox jCheckBox7;
/*     */   private JCheckBox jCheckBox8;
/*     */   private JCheckBox jCheckBox9;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JList jList1;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel10;
/*     */   private JPanel jPanel2;
/*     */   private JPanel jPanel3;
/*     */   private JPanel jPanel4;
/*     */   private JPanel jPanel5;
/*     */   private JPanel jPanel6;
/*     */   private JPanel jPanel7;
/*     */   private JPanel jPanel8;
/*     */   private JPanel jPanel9;
/*     */   private JRadioButton jRadioButton1;
/*     */   private JRadioButton jRadioButton10;
/*     */   private JRadioButton jRadioButton11;
/*     */   private JRadioButton jRadioButton12;
/*     */   private JRadioButton jRadioButton13;
/*     */   private JRadioButton jRadioButton14;
/*     */   private JRadioButton jRadioButton15;
/*     */   private JRadioButton jRadioButton16;
/*     */   private JRadioButton jRadioButton2;
/*     */   private JRadioButton jRadioButton3;
/*     */   private JRadioButton jRadioButton4;
/*     */   private JRadioButton jRadioButton5;
/*     */   private JRadioButton jRadioButton6;
/*     */   private JRadioButton jRadioButton7;
/*     */   private JRadioButton jRadioButton8;
/*     */   private JRadioButton jRadioButton9;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JTabbedPane jTabbedPane1;
/*     */   private JTextField jTextField1;
/*     */   private JTextField jTextField2;
/*     */ 
/*     */   public static void addManager(SettingsManager manager)
/*     */   {
/*  39 */     managers.add(manager);
/*     */   }
/*     */ 
/*     */   public SettingsEditor(Project project, GFile file)
/*     */   {
/*  45 */     this.scenelist = new Vector();
/*  46 */     this.file = file;
/*  47 */     this.project = project;
/*  48 */     if ((file.value == null) || (!(file.value instanceof SettingsValues))) {
/*  49 */       file.value = (this.value = new SettingsValues());
/*     */     }
/*     */     else {
/*  52 */       this.value = ((SettingsValues)file.value);
/*     */     }
/*  54 */     this.Graphics = this.value.getValue("Graphics");
/*  55 */     if (this.Graphics == null) {
/*  56 */       this.value.setVariable("Graphics", this.Graphics = new TabValues("Graphics"));
/*     */     }
/*  58 */     this.Resolution = this.value.getValue("Resolution");
/*  59 */     if (this.Resolution == null) {
/*  60 */       this.value.setVariable("Resolution", this.Resolution = new TabValues("Resolution"));
/*     */     }
/*  62 */     this.Other = this.value.getValue("Other");
/*  63 */     if (this.Other == null) {
/*  64 */       this.value.setVariable("Other", this.Other = new TabValues("Other"));
/*     */     }
/*  66 */     this.SceneOrder = this.value.getValue("Scene Order");
/*  67 */     if (this.SceneOrder == null) {
/*  68 */       this.value.setVariable("Scene Order", this.SceneOrder = new TabValues("Scene Order"));
/*     */     }
/*  70 */     Object resize = this.Graphics.getValue("resize");
/*  71 */     if ((resize == null) || (!(resize instanceof Boolean))) {
/*  72 */       this.Graphics.setVariable("resize", resize = Boolean.valueOf(false));
/*     */     }
/*  74 */     Object borderless = this.Graphics.getValue("borderless");
/*  75 */     if ((borderless == null) || (!(borderless instanceof Boolean))) {
/*  76 */       this.Graphics.setVariable("borderless", borderless = Boolean.valueOf(false));
/*     */     }
/*  78 */     Object setres = this.Resolution.getValue("setres");
/*  79 */     if ((setres == null) || (!(setres instanceof Boolean))) {
/*  80 */       this.Resolution.setVariable("setres", setres = Boolean.valueOf(false));
/*     */     }
/*  82 */     Object depth = this.Resolution.getValue("depth");
/*  83 */     if ((depth == null) || (!(depth instanceof Integer))) {
/*  84 */       this.Resolution.setVariable("depth", depth = Integer.valueOf(0));
/*     */     }
/*  86 */     Integer dep = (Integer)depth;
/*  87 */     if ((dep.intValue() != 0) && (dep.intValue() != 16) && (dep.intValue() != 32))
/*  88 */       this.Resolution.setVariable("depth", dep = Integer.valueOf(0));
/*  89 */     Object resol = this.Resolution.getValue("resol");
/*  90 */     if ((resol == null) || (!(resol instanceof Integer))) {
/*  91 */       this.Resolution.setVariable("resol", resol = Integer.valueOf(0));
/*     */     }
/*  93 */     Integer res = (Integer)resol;
/*  94 */     if ((res.intValue() < 0) || (res.intValue() > 6))
/*  95 */       this.Resolution.setVariable("resol", res = Integer.valueOf(0));
/*  96 */     if ((res.intValue() < 0) || (res.intValue() > 6))
/*  97 */       this.Resolution.setVariable("resol", res = Integer.valueOf(0));
/*  98 */     Object frequency = this.Resolution.getValue("frequency");
/*  99 */     if ((frequency == null) || (!(frequency instanceof Integer))) {
/* 100 */       this.Resolution.setVariable("frequency", frequency = Integer.valueOf(0));
/*     */     }
/* 102 */     Integer freq = (Integer)frequency;
/* 103 */     if ((freq.intValue() < 0) || (freq.intValue() > 5))
/* 104 */       this.Resolution.setVariable("frequency", freq = Integer.valueOf(0));
/* 105 */     Object esc = this.Other.getValue("ESC");
/* 106 */     if ((esc == null) || (!(esc instanceof Boolean))) {
/* 107 */       this.Other.setVariable("ESC", esc = Boolean.valueOf(false));
/*     */     }
/* 109 */     Object f4 = this.Other.getValue("F4");
/* 110 */     if ((f4 == null) || (!(f4 instanceof Boolean))) {
/* 111 */       this.Other.setVariable("F4", f4 = Boolean.valueOf(false));
/*     */     }
/* 113 */     initComponents();
/* 114 */     this.jCheckBox4.setSelected(((Boolean)resize).booleanValue());
/* 115 */     this.jCheckBox5.setSelected(((Boolean)borderless).booleanValue());
/* 116 */     this.jCheckBox7.setSelected(((Boolean)setres).booleanValue());
/* 117 */     this.jCheckBox8.setSelected(((Boolean)esc).booleanValue());
/* 118 */     this.jCheckBox9.setSelected(((Boolean)f4).booleanValue());
/* 119 */     if (dep.intValue() == 0)
/* 120 */       this.jRadioButton1.setSelected(true);
/* 121 */     else if (dep.intValue() == 16)
/* 122 */       this.jRadioButton2.setSelected(true);
/* 123 */     else if (dep.intValue() == 32)
/* 124 */       this.jRadioButton3.setSelected(true);
/* 125 */     if (res.intValue() == 0)
/* 126 */       this.jRadioButton4.setSelected(true);
/* 127 */     else if (res.intValue() == 1)
/* 128 */       this.jRadioButton5.setSelected(true);
/* 129 */     else if (res.intValue() == 2)
/* 130 */       this.jRadioButton6.setSelected(true);
/* 131 */     else if (res.intValue() == 3)
/* 132 */       this.jRadioButton7.setSelected(true);
/* 133 */     else if (res.intValue() == 4)
/* 134 */       this.jRadioButton8.setSelected(true);
/* 135 */     else if (res.intValue() == 5)
/* 136 */       this.jRadioButton9.setSelected(true);
/* 137 */     else if (res.intValue() == 6)
/* 138 */       this.jRadioButton10.setSelected(true);
/* 139 */     if (freq.intValue() == 0)
/* 140 */       this.jRadioButton11.setSelected(true);
/* 141 */     else if (freq.intValue() == 1)
/* 142 */       this.jRadioButton12.setSelected(true);
/* 143 */     else if (freq.intValue() == 2)
/* 144 */       this.jRadioButton13.setSelected(true);
/* 145 */     else if (freq.intValue() == 3)
/* 146 */       this.jRadioButton14.setSelected(true);
/* 147 */     else if (freq.intValue() == 4)
/* 148 */       this.jRadioButton15.setSelected(true);
/* 149 */     else if (freq.intValue() == 5)
/* 150 */       this.jRadioButton16.setSelected(true);
/* 151 */     Object scn = null;
/*     */     try {
/* 153 */       scn = this.SceneOrder.getValue("Scenes"); } catch (Exception e) {
/*     */     }
/* 155 */     if ((scn == null) || (!(scn instanceof Vector)))
/* 156 */       this.SceneOrder.setVariable("Scenes", scn = new Vector());
/* 157 */     this.scenelist = ((Vector)scn);
/* 158 */     checkres();
/* 159 */     this.jPanel10.setLayout(new FlowLayout());
/* 160 */     this.jPanel10.add(this.scenes = new ResourceChooser(project, "scene"));
/* 161 */     this.jList1.setModel(new VectorListModel(this.scenelist));
/* 162 */     this.jList1.setCellRenderer(new SceneCellRenderer());
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 173 */     this.buttonGroup1 = new ButtonGroup();
/* 174 */     this.buttonGroup2 = new ButtonGroup();
/* 175 */     this.buttonGroup3 = new ButtonGroup();
/* 176 */     this.jTabbedPane1 = new JTabbedPane();
/* 177 */     this.jPanel1 = new JPanel();
/* 178 */     this.jCheckBox3 = new JCheckBox();
/* 179 */     this.jCheckBox4 = new JCheckBox();
/* 180 */     this.jCheckBox5 = new JCheckBox();
/* 181 */     this.jCheckBox6 = new JCheckBox();
/* 182 */     this.jCheckBox1 = new JCheckBox();
/* 183 */     this.jCheckBox2 = new JCheckBox();
/* 184 */     this.jPanel2 = new JPanel();
/* 185 */     this.jCheckBox7 = new JCheckBox();
/* 186 */     this.jPanel3 = new JPanel();
/* 187 */     this.jRadioButton1 = new JRadioButton();
/* 188 */     this.jRadioButton2 = new JRadioButton();
/* 189 */     this.jRadioButton3 = new JRadioButton();
/* 190 */     this.jPanel4 = new JPanel();
/* 191 */     this.jRadioButton4 = new JRadioButton();
/* 192 */     this.jRadioButton5 = new JRadioButton();
/* 193 */     this.jRadioButton6 = new JRadioButton();
/* 194 */     this.jRadioButton7 = new JRadioButton();
/* 195 */     this.jRadioButton8 = new JRadioButton();
/* 196 */     this.jRadioButton9 = new JRadioButton();
/* 197 */     this.jRadioButton10 = new JRadioButton();
/* 198 */     this.jPanel5 = new JPanel();
/* 199 */     this.jRadioButton11 = new JRadioButton();
/* 200 */     this.jRadioButton12 = new JRadioButton();
/* 201 */     this.jRadioButton13 = new JRadioButton();
/* 202 */     this.jRadioButton14 = new JRadioButton();
/* 203 */     this.jRadioButton15 = new JRadioButton();
/* 204 */     this.jRadioButton16 = new JRadioButton();
/* 205 */     this.jPanel6 = new JPanel();
/* 206 */     this.jPanel7 = new JPanel();
/* 207 */     this.jCheckBox8 = new JCheckBox();
/* 208 */     this.jCheckBox9 = new JCheckBox();
/* 209 */     this.jCheckBox10 = new JCheckBox();
/* 210 */     this.jPanel8 = new JPanel();
/* 211 */     this.jCheckBox11 = new JCheckBox();
/* 212 */     this.jLabel1 = new JLabel();
/* 213 */     this.jTextField1 = new JTextField();
/* 214 */     this.jLabel2 = new JLabel();
/* 215 */     this.jTextField2 = new JTextField();
/* 216 */     this.jPanel9 = new JPanel();
/* 217 */     this.jScrollPane1 = new JScrollPane();
/* 218 */     this.jList1 = new JList();
/* 219 */     this.jPanel10 = new JPanel();
/* 220 */     this.jButton2 = new JButton();
/* 221 */     this.jButton3 = new JButton();
/* 222 */     this.jButton4 = new JButton();
/* 223 */     this.jButton5 = new JButton();
/*     */ 
/* 225 */     setLayout(new BorderLayout());
/*     */ 
/* 227 */     this.jTabbedPane1.setTabPlacement(2);
/*     */ 
/* 229 */     this.jCheckBox3.setText(LangSupporter.activeLang.getEntry(65));
/* 230 */     this.jCheckBox3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 231 */     this.jCheckBox3.setEnabled(false);
/*     */ 
/* 233 */     this.jCheckBox4.setText(LangSupporter.activeLang.getEntry(66));
/* 234 */     this.jCheckBox4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 235 */     this.jCheckBox4.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 237 */         SettingsEditor.this.jCheckBox4ActionPerformed(evt);
/*     */       }
/*     */     });
/* 241 */     this.jCheckBox5.setText(LangSupporter.activeLang.getEntry(67));
/* 242 */     this.jCheckBox5.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 243 */     this.jCheckBox5.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 245 */         SettingsEditor.this.jCheckBox5ActionPerformed(evt);
/*     */       }
/*     */     });
/* 249 */     this.jCheckBox6.setText(LangSupporter.activeLang.getEntry(68));
/* 250 */     this.jCheckBox6.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 251 */     this.jCheckBox6.setEnabled(false);
/*     */ 
/* 253 */     this.jCheckBox1.setText(LangSupporter.activeLang.getEntry(69));
/* 254 */     this.jCheckBox1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 255 */     this.jCheckBox1.setEnabled(false);
/*     */ 
/* 257 */     this.jCheckBox2.setText(LangSupporter.activeLang.getEntry(70));
/* 258 */     this.jCheckBox2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 259 */     this.jCheckBox2.setEnabled(false);
/*     */ 
/* 261 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 262 */     this.jPanel1.setLayout(jPanel1Layout);
/* 263 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().addContainerGap().add(jPanel1Layout.createParallelGroup(1).add(this.jCheckBox3).add(this.jCheckBox4).add(this.jCheckBox5).add(this.jCheckBox6).add(this.jCheckBox1).add(this.jCheckBox2)).addContainerGap(291, 32767)));
/*     */ 
/* 276 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().addContainerGap().add(this.jCheckBox3).addPreferredGap(1).add(this.jCheckBox4).addPreferredGap(1).add(this.jCheckBox5).addPreferredGap(1).add(this.jCheckBox6).addPreferredGap(1).add(this.jCheckBox1).addPreferredGap(1).add(this.jCheckBox2).addContainerGap(229, 32767)));
/*     */ 
/* 294 */     this.jTabbedPane1.addTab(LangSupporter.activeLang.getEntry(64), this.jPanel1);
/*     */ 
/* 296 */     this.jCheckBox7.setText(LangSupporter.activeLang.getEntry(72));
/* 297 */     this.jCheckBox7.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 298 */     this.jCheckBox7.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 300 */         SettingsEditor.this.jCheckBox7ActionPerformed(evt);
/*     */       }
/*     */     });
/* 304 */     this.jPanel3.setBorder(BorderFactory.createTitledBorder(LangSupporter.activeLang.getEntry(73)));
/*     */ 
/* 306 */     this.buttonGroup1.add(this.jRadioButton1);
/* 307 */     this.jRadioButton1.setText(LangSupporter.activeLang.getEntry(74));
/* 308 */     this.jRadioButton1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 309 */     this.jRadioButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 311 */         SettingsEditor.this.jRadioButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 315 */     this.buttonGroup1.add(this.jRadioButton2);
/* 316 */     this.jRadioButton2.setText("16-bit");
/* 317 */     this.jRadioButton2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 318 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 320 */         SettingsEditor.this.jRadioButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 324 */     this.buttonGroup1.add(this.jRadioButton3);
/* 325 */     this.jRadioButton3.setText("32-bit");
/* 326 */     this.jRadioButton3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 327 */     this.jRadioButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 329 */         SettingsEditor.this.jRadioButton3ActionPerformed(evt);
/*     */       }
/*     */     });
/* 333 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 334 */     this.jPanel3.setLayout(jPanel3Layout);
/* 335 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(1).add(jPanel3Layout.createSequentialGroup().add(jPanel3Layout.createParallelGroup(1).add(this.jRadioButton1).add(this.jRadioButton2).add(this.jRadioButton3)).addContainerGap(43, 32767)));
/*     */ 
/* 344 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(1).add(jPanel3Layout.createSequentialGroup().add(this.jRadioButton1).addPreferredGap(0).add(this.jRadioButton2).addPreferredGap(0).add(this.jRadioButton3)));
/*     */ 
/* 354 */     this.jPanel4.setBorder(BorderFactory.createTitledBorder(LangSupporter.activeLang.getEntry(71)));
/*     */ 
/* 356 */     this.buttonGroup2.add(this.jRadioButton4);
/* 357 */     this.jRadioButton4.setText(LangSupporter.activeLang.getEntry(74));
/* 358 */     this.jRadioButton4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 359 */     this.jRadioButton4.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 361 */         SettingsEditor.this.jRadioButton4ActionPerformed(evt);
/*     */       }
/*     */     });
/* 365 */     this.buttonGroup2.add(this.jRadioButton5);
/* 366 */     this.jRadioButton5.setText("320x240");
/* 367 */     this.jRadioButton5.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 368 */     this.jRadioButton5.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 370 */         SettingsEditor.this.jRadioButton5ActionPerformed(evt);
/*     */       }
/*     */     });
/* 374 */     this.buttonGroup2.add(this.jRadioButton6);
/* 375 */     this.jRadioButton6.setText("640x480");
/* 376 */     this.jRadioButton6.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 377 */     this.jRadioButton6.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 379 */         SettingsEditor.this.jRadioButton6ActionPerformed(evt);
/*     */       }
/*     */     });
/* 383 */     this.buttonGroup2.add(this.jRadioButton7);
/* 384 */     this.jRadioButton7.setText("800x600");
/* 385 */     this.jRadioButton7.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 386 */     this.jRadioButton7.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 388 */         SettingsEditor.this.jRadioButton7ActionPerformed(evt);
/*     */       }
/*     */     });
/* 392 */     this.buttonGroup2.add(this.jRadioButton8);
/* 393 */     this.jRadioButton8.setText("1024x768");
/* 394 */     this.jRadioButton8.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 395 */     this.jRadioButton8.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 397 */         SettingsEditor.this.jRadioButton8ActionPerformed(evt);
/*     */       }
/*     */     });
/* 401 */     this.buttonGroup2.add(this.jRadioButton9);
/* 402 */     this.jRadioButton9.setText("1280x1024");
/* 403 */     this.jRadioButton9.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 404 */     this.jRadioButton9.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 406 */         SettingsEditor.this.jRadioButton9ActionPerformed(evt);
/*     */       }
/*     */     });
/* 410 */     this.buttonGroup2.add(this.jRadioButton10);
/* 411 */     this.jRadioButton10.setText("1600x1200");
/* 412 */     this.jRadioButton10.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 413 */     this.jRadioButton10.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 415 */         SettingsEditor.this.jRadioButton10ActionPerformed(evt);
/*     */       }
/*     */     });
/* 419 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 420 */     this.jPanel4.setLayout(jPanel4Layout);
/* 421 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(1).add(jPanel4Layout.createSequentialGroup().add(jPanel4Layout.createParallelGroup(1).add(this.jRadioButton4).add(this.jRadioButton5).add(this.jRadioButton6).add(this.jRadioButton7).add(this.jRadioButton8).add(this.jRadioButton9).add(this.jRadioButton10)).addContainerGap(12, 32767)));
/*     */ 
/* 434 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(1).add(jPanel4Layout.createSequentialGroup().add(this.jRadioButton4).addPreferredGap(0).add(this.jRadioButton5).addPreferredGap(0).add(this.jRadioButton6).addPreferredGap(0).add(this.jRadioButton7).addPreferredGap(0).add(this.jRadioButton8).addPreferredGap(0).add(this.jRadioButton9).addPreferredGap(0).add(this.jRadioButton10)));
/*     */ 
/* 452 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(LangSupporter.activeLang.getEntry(120)));
/*     */ 
/* 454 */     this.buttonGroup3.add(this.jRadioButton11);
/* 455 */     this.jRadioButton11.setText(LangSupporter.activeLang.getEntry(74));
/* 456 */     this.jRadioButton11.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 457 */     this.jRadioButton11.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 459 */         SettingsEditor.this.jRadioButton11ActionPerformed(evt);
/*     */       }
/*     */     });
/* 463 */     this.buttonGroup3.add(this.jRadioButton12);
/* 464 */     this.jRadioButton12.setText("60");
/* 465 */     this.jRadioButton12.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 466 */     this.jRadioButton12.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 468 */         SettingsEditor.this.jRadioButton12ActionPerformed(evt);
/*     */       }
/*     */     });
/* 472 */     this.buttonGroup3.add(this.jRadioButton13);
/* 473 */     this.jRadioButton13.setText("70");
/* 474 */     this.jRadioButton13.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 475 */     this.jRadioButton13.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 477 */         SettingsEditor.this.jRadioButton13ActionPerformed(evt);
/*     */       }
/*     */     });
/* 481 */     this.buttonGroup3.add(this.jRadioButton14);
/* 482 */     this.jRadioButton14.setText("85");
/* 483 */     this.jRadioButton14.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 484 */     this.jRadioButton14.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 486 */         SettingsEditor.this.jRadioButton14ActionPerformed(evt);
/*     */       }
/*     */     });
/* 490 */     this.buttonGroup3.add(this.jRadioButton15);
/* 491 */     this.jRadioButton15.setText("100");
/* 492 */     this.jRadioButton15.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 493 */     this.jRadioButton15.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 495 */         SettingsEditor.this.jRadioButton15ActionPerformed(evt);
/*     */       }
/*     */     });
/* 499 */     this.buttonGroup3.add(this.jRadioButton16);
/* 500 */     this.jRadioButton16.setText("120");
/* 501 */     this.jRadioButton16.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 502 */     this.jRadioButton16.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 504 */         SettingsEditor.this.jRadioButton16ActionPerformed(evt);
/*     */       }
/*     */     });
/* 508 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 509 */     this.jPanel5.setLayout(jPanel5Layout);
/* 510 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(1).add(this.jRadioButton11).add(this.jRadioButton12).add(this.jRadioButton13).add(this.jRadioButton14).add(this.jRadioButton15).add(this.jRadioButton16));
/*     */ 
/* 519 */     jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(1).add(jPanel5Layout.createSequentialGroup().add(this.jRadioButton11).addPreferredGap(0).add(this.jRadioButton12).addPreferredGap(0).add(this.jRadioButton13).addPreferredGap(0).add(this.jRadioButton14).addPreferredGap(0).add(this.jRadioButton15).addPreferredGap(0).add(this.jRadioButton16)));
/*     */ 
/* 535 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 536 */     this.jPanel2.setLayout(jPanel2Layout);
/* 537 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(1).add(jPanel2Layout.createSequentialGroup().addContainerGap().add(jPanel2Layout.createParallelGroup(1).add(2, jPanel2Layout.createSequentialGroup().add(this.jPanel3, -1, -1, 32767).addPreferredGap(0).add(this.jPanel4, -2, -1, -2).addPreferredGap(0).add(this.jPanel5, -2, -1, -2)).add(this.jCheckBox7)).addContainerGap()));
/*     */ 
/* 551 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(1).add(jPanel2Layout.createSequentialGroup().addContainerGap().add(this.jCheckBox7).addPreferredGap(0).add(jPanel2Layout.createParallelGroup(1).add(this.jPanel4, -2, -1, -2).add(this.jPanel5, -2, -1, -2).add(this.jPanel3, -2, -1, -2)).addContainerGap(195, 32767)));
/*     */ 
/* 564 */     this.jTabbedPane1.addTab(LangSupporter.activeLang.getEntry(71), this.jPanel2);
/*     */ 
/* 566 */     this.jPanel7.setBorder(BorderFactory.createTitledBorder(LangSupporter.activeLang.getEntry(122)));
/*     */ 
/* 568 */     this.jCheckBox8.setText(LangSupporter.activeLang.getEntry(123));
/* 569 */     this.jCheckBox8.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 571 */         SettingsEditor.this.jCheckBox8ActionPerformed(evt);
/*     */       }
/*     */     });
/* 575 */     this.jCheckBox9.setText(LangSupporter.activeLang.getEntry(124));
/* 576 */     this.jCheckBox9.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 578 */         SettingsEditor.this.jCheckBox9ActionPerformed(evt);
/*     */       }
/*     */     });
/* 582 */     this.jCheckBox10.setText(LangSupporter.activeLang.getEntry(125));
/* 583 */     this.jCheckBox10.setEnabled(false);
/*     */ 
/* 585 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 586 */     this.jPanel7.setLayout(jPanel7Layout);
/* 587 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(1).add(this.jCheckBox9, -1, 360, 32767).add(this.jCheckBox8, -1, 360, 32767).add(jPanel7Layout.createSequentialGroup().add(this.jCheckBox10, -1, 352, 32767).addContainerGap()));
/*     */ 
/* 595 */     jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(1).add(jPanel7Layout.createSequentialGroup().add(this.jCheckBox8).addPreferredGap(0).add(this.jCheckBox9).addPreferredGap(0).add(this.jCheckBox10)));
/*     */ 
/* 605 */     this.jPanel8.setBorder(BorderFactory.createTitledBorder(LangSupporter.activeLang.getEntry(126)));
/*     */ 
/* 607 */     this.jCheckBox11.setText(LangSupporter.activeLang.getEntry(127));
/* 608 */     this.jCheckBox11.setEnabled(false);
/*     */ 
/* 610 */     this.jLabel1.setText(LangSupporter.activeLang.getEntry(128));
/*     */ 
/* 612 */     this.jTextField1.setEditable(false);
/* 613 */     this.jTextField1.setText("jTextField1");
/*     */ 
/* 615 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 616 */     this.jPanel8.setLayout(jPanel8Layout);
/* 617 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(1).add(jPanel8Layout.createSequentialGroup().add(this.jLabel1).addPreferredGap(0).add(this.jTextField1, -1, 274, 32767)).add(this.jCheckBox11, -1, 360, 32767));
/*     */ 
/* 625 */     jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(1).add(jPanel8Layout.createSequentialGroup().add(this.jCheckBox11).addPreferredGap(0).add(jPanel8Layout.createParallelGroup(3).add(this.jLabel1).add(this.jTextField1, -2, -1, -2))));
/*     */ 
/* 635 */     this.jLabel2.setText(LangSupporter.activeLang.getEntry(129));
/*     */ 
/* 637 */     this.jTextField2.setEditable(false);
/* 638 */     this.jTextField2.setText("jTextField2");
/*     */ 
/* 640 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 641 */     this.jPanel6.setLayout(jPanel6Layout);
/* 642 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(1).add(jPanel6Layout.createSequentialGroup().addContainerGap().add(jPanel6Layout.createParallelGroup(1).add(this.jPanel8, -1, -1, 32767).add(this.jPanel7, -1, -1, 32767).add(jPanel6Layout.createSequentialGroup().add(this.jLabel2).addPreferredGap(0).add(this.jTextField2, -1, 284, 32767))).addContainerGap()));
/*     */ 
/* 655 */     jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(1).add(jPanel6Layout.createSequentialGroup().addContainerGap().add(this.jPanel7, -2, -1, -2).addPreferredGap(0).add(this.jPanel8, -2, -1, -2).addPreferredGap(0).add(jPanel6Layout.createParallelGroup(3).add(this.jLabel2).add(this.jTextField2, -2, -1, -2)).addContainerGap(187, 32767)));
/*     */ 
/* 669 */     this.jTabbedPane1.addTab(LangSupporter.activeLang.getEntry(121), this.jPanel6);
/*     */ 
/* 671 */     this.jList1.setSelectionMode(0);
/* 672 */     this.jList1.addMouseListener(new MouseAdapter() {
/*     */       public void mousePressed(MouseEvent evt) {
/* 674 */         SettingsEditor.this.jList1MousePressed(evt);
/*     */       }
/*     */     });
/* 677 */     this.jList1.addMouseMotionListener(new MouseMotionAdapter() {
/*     */       public void mouseDragged(MouseEvent evt) {
/* 679 */         SettingsEditor.this.jList1MouseDragged(evt);
/*     */       }
/*     */     });
/* 682 */     this.jScrollPane1.setViewportView(this.jList1);
/*     */ 
/* 684 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 685 */     this.jPanel10.setLayout(jPanel10Layout);
/* 686 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(1).add(0, 101, 32767));
/*     */ 
/* 690 */     jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(1).add(0, 20, 32767));
/*     */ 
/* 695 */     this.jButton2.setText("Add");
/* 696 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 698 */         SettingsEditor.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 702 */     this.jButton3.setText("Remove");
/* 703 */     this.jButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 705 */         SettingsEditor.this.jButton3ActionPerformed(evt);
/*     */       }
/*     */     });
/* 709 */     this.jButton4.setText("Up");
/* 710 */     this.jButton4.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 712 */         SettingsEditor.this.jButton4ActionPerformed(evt);
/*     */       }
/*     */     });
/* 716 */     this.jButton5.setText("Down");
/* 717 */     this.jButton5.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 719 */         SettingsEditor.this.jButton5ActionPerformed(evt);
/*     */       }
/*     */     });
/* 723 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 724 */     this.jPanel9.setLayout(jPanel9Layout);
/* 725 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(1).add(jPanel9Layout.createSequentialGroup().addContainerGap().add(jPanel9Layout.createParallelGroup(1).add(this.jScrollPane1, -1, 370, 32767).add(2, jPanel9Layout.createSequentialGroup().add(this.jPanel10, -1, -1, 32767).addPreferredGap(0).add(this.jButton2).addPreferredGap(0).add(this.jButton3).addPreferredGap(0).add(this.jButton4).addPreferredGap(0).add(this.jButton5))).addContainerGap()));
/*     */ 
/* 743 */     jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(1).add(jPanel9Layout.createSequentialGroup().addContainerGap().add(jPanel9Layout.createParallelGroup(1).add(jPanel9Layout.createParallelGroup(3).add(this.jButton5).add(this.jButton4).add(this.jButton3).add(this.jButton2)).add(this.jPanel10, -2, -1, -2)).addPreferredGap(0).add(this.jScrollPane1, -1, 331, 32767).addContainerGap()));
/*     */ 
/* 759 */     this.jTabbedPane1.addTab("Scene Order", this.jPanel9);
/*     */ 
/* 761 */     add(this.jTabbedPane1, "Center");
/*     */   }
/*     */ 
/*     */   private void jCheckBox7ActionPerformed(ActionEvent evt) {
/* 765 */     checkres();
/* 766 */     this.Resolution.setVariable("setres", Boolean.valueOf(this.jCheckBox7.isSelected()));
/*     */   }
/*     */ 
/*     */   private void jCheckBox4ActionPerformed(ActionEvent evt) {
/* 770 */     this.Graphics.setVariable("resize", Boolean.valueOf(this.jCheckBox4.isSelected()));
/*     */   }
/*     */ 
/*     */   private void jRadioButton1ActionPerformed(ActionEvent evt) {
/* 774 */     this.Resolution.setVariable("depth", Integer.valueOf(0));
/*     */   }
/*     */ 
/*     */   private void jRadioButton2ActionPerformed(ActionEvent evt) {
/* 778 */     this.Resolution.setVariable("depth", Integer.valueOf(16));
/*     */   }
/*     */ 
/*     */   private void jRadioButton3ActionPerformed(ActionEvent evt) {
/* 782 */     this.Resolution.setVariable("depth", Integer.valueOf(32));
/*     */   }
/*     */ 
/*     */   private void jRadioButton4ActionPerformed(ActionEvent evt) {
/* 786 */     this.Resolution.setVariable("resol", Integer.valueOf(0));
/*     */   }
/*     */ 
/*     */   private void jRadioButton5ActionPerformed(ActionEvent evt) {
/* 790 */     this.Resolution.setVariable("resol", Integer.valueOf(1));
/*     */   }
/*     */ 
/*     */   private void jRadioButton6ActionPerformed(ActionEvent evt) {
/* 794 */     this.Resolution.setVariable("resol", Integer.valueOf(2));
/*     */   }
/*     */ 
/*     */   private void jRadioButton7ActionPerformed(ActionEvent evt) {
/* 798 */     this.Resolution.setVariable("resol", Integer.valueOf(3));
/*     */   }
/*     */ 
/*     */   private void jRadioButton8ActionPerformed(ActionEvent evt) {
/* 802 */     this.Resolution.setVariable("resol", Integer.valueOf(4));
/*     */   }
/*     */ 
/*     */   private void jRadioButton9ActionPerformed(ActionEvent evt) {
/* 806 */     this.Resolution.setVariable("resol", Integer.valueOf(5));
/*     */   }
/*     */ 
/*     */   private void jRadioButton10ActionPerformed(ActionEvent evt) {
/* 810 */     this.Resolution.setVariable("resol", Integer.valueOf(6));
/*     */   }
/*     */ 
/*     */   private void jCheckBox8ActionPerformed(ActionEvent evt) {
/* 814 */     this.Other.setVariable("ESC", Boolean.valueOf(this.jCheckBox8.isSelected()));
/*     */   }
/*     */ 
/*     */   private void jCheckBox9ActionPerformed(ActionEvent evt) {
/* 818 */     this.Other.setVariable("F4", Boolean.valueOf(this.jCheckBox9.isSelected()));
/*     */   }
/*     */ 
/*     */   private void jRadioButton11ActionPerformed(ActionEvent evt) {
/* 822 */     this.Resolution.setVariable("frequency", Integer.valueOf(0));
/*     */   }
/*     */ 
/*     */   private void jRadioButton12ActionPerformed(ActionEvent evt) {
/* 826 */     this.Resolution.setVariable("frequency", Integer.valueOf(1));
/*     */   }
/*     */ 
/*     */   private void jRadioButton13ActionPerformed(ActionEvent evt) {
/* 830 */     this.Resolution.setVariable("frequency", Integer.valueOf(2));
/*     */   }
/*     */ 
/*     */   private void jRadioButton14ActionPerformed(ActionEvent evt) {
/* 834 */     this.Resolution.setVariable("frequency", Integer.valueOf(3));
/*     */   }
/*     */ 
/*     */   private void jRadioButton15ActionPerformed(ActionEvent evt) {
/* 838 */     this.Resolution.setVariable("frequency", Integer.valueOf(4));
/*     */   }
/*     */ 
/*     */   private void jRadioButton16ActionPerformed(ActionEvent evt) {
/* 842 */     this.Resolution.setVariable("frequency", Integer.valueOf(5));
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 846 */     if (this.scenes.getCurrentObject() != null)
/* 847 */       addScene((GFile)this.scenes.getCurrentObject().object);
/*     */   }
/*     */ 
/*     */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 851 */     removeSelectedScene();
/*     */   }
/*     */ 
/*     */   private void jList1MouseDragged(MouseEvent evt) {
/* 855 */     int to = this.jList1.locationToIndex(evt.getPoint());
/* 856 */     if (to == this.from) return;
/* 857 */     GFile remove = (GFile)this.scenelist.remove(this.from);
/* 858 */     this.scenelist.add(to, remove);
/* 859 */     this.from = to;
/*     */   }
/*     */ 
/*     */   private void jList1MousePressed(MouseEvent evt) {
/* 863 */     this.from = this.jList1.locationToIndex(evt.getPoint());
/*     */   }
/*     */ 
/*     */   private void jButton4ActionPerformed(ActionEvent evt)
/*     */   {
/* 868 */     int pos = this.jList1.getSelectedIndex();
/* 869 */     if (pos <= 0)
/* 870 */       return;
/* 871 */     GFile o = (GFile)this.scenelist.get(pos);
/* 872 */     GFile p = (GFile)this.scenelist.get(pos - 1);
/* 873 */     this.scenelist.set(pos - 1, o);
/* 874 */     this.scenelist.set(pos, p);
/* 875 */     this.jList1.setSelectedIndex(pos - 1);
/* 876 */     this.jList1.updateUI();
/*     */   }
/*     */ 
/*     */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 880 */     int pos = this.jList1.getSelectedIndex();
/* 881 */     if ((pos < 0) || (pos >= this.scenelist.size() - 1))
/* 882 */       return;
/* 883 */     GFile o = (GFile)this.scenelist.get(pos);
/* 884 */     GFile p = (GFile)this.scenelist.get(pos + 1);
/* 885 */     this.scenelist.set(pos + 1, o);
/* 886 */     this.scenelist.set(pos, p);
/* 887 */     this.jList1.setSelectedIndex(pos + 1);
/* 888 */     this.jList1.updateUI();
/*     */   }
/*     */ 
/*     */   private void jCheckBox5ActionPerformed(ActionEvent evt) {
/* 892 */     this.Graphics.setVariable("borderless", Boolean.valueOf(this.jCheckBox5.isSelected()));
/*     */   }
/*     */ 
/*     */   public void addScene(GFile file) {
/* 896 */     this.scenelist.add(file);
/* 897 */     this.jList1.updateUI();
/*     */   }
/*     */ 
/*     */   public void removeSelectedScene() {
/* 901 */     if (this.jList1.getSelectedValue() != null)
/* 902 */       this.scenelist.remove(this.jList1.getSelectedIndex());
/* 903 */     this.scenelist.trimToSize();
/* 904 */     this.jList1.updateUI();
/*     */   }
/*     */ 
/*     */   void checkres() {
/* 908 */     if (this.jCheckBox7.isSelected()) {
/* 909 */       ((TitledBorder)this.jPanel3.getBorder()).setTitleColor(new Color(0, 70, 213));
/* 910 */       ((TitledBorder)this.jPanel4.getBorder()).setTitleColor(new Color(0, 70, 213));
/* 911 */       ((TitledBorder)this.jPanel5.getBorder()).setTitleColor(new Color(0, 70, 213));
/* 912 */       this.jPanel3.updateUI();
/* 913 */       this.jPanel4.updateUI();
/* 914 */       this.jPanel5.updateUI();
/* 915 */       this.jRadioButton1.setEnabled(true);
/* 916 */       this.jRadioButton2.setEnabled(true);
/* 917 */       this.jRadioButton3.setEnabled(true);
/* 918 */       this.jRadioButton4.setEnabled(true);
/* 919 */       this.jRadioButton5.setEnabled(true);
/* 920 */       this.jRadioButton6.setEnabled(true);
/* 921 */       this.jRadioButton7.setEnabled(true);
/* 922 */       this.jRadioButton8.setEnabled(true);
/* 923 */       this.jRadioButton9.setEnabled(true);
/* 924 */       this.jRadioButton10.setEnabled(true);
/* 925 */       this.jRadioButton11.setEnabled(true);
/* 926 */       this.jRadioButton12.setEnabled(true);
/* 927 */       this.jRadioButton13.setEnabled(true);
/* 928 */       this.jRadioButton14.setEnabled(true);
/* 929 */       this.jRadioButton15.setEnabled(true);
/* 930 */       this.jRadioButton16.setEnabled(true);
/*     */     }
/*     */     else {
/* 933 */       ((TitledBorder)this.jPanel3.getBorder()).setTitleColor(Color.GRAY);
/* 934 */       ((TitledBorder)this.jPanel4.getBorder()).setTitleColor(Color.GRAY);
/* 935 */       ((TitledBorder)this.jPanel5.getBorder()).setTitleColor(Color.GRAY);
/* 936 */       this.jPanel3.updateUI();
/* 937 */       this.jPanel4.updateUI();
/* 938 */       this.jPanel5.updateUI();
/* 939 */       this.jRadioButton1.setEnabled(false);
/* 940 */       this.jRadioButton2.setEnabled(false);
/* 941 */       this.jRadioButton3.setEnabled(false);
/* 942 */       this.jRadioButton4.setEnabled(false);
/* 943 */       this.jRadioButton5.setEnabled(false);
/* 944 */       this.jRadioButton6.setEnabled(false);
/* 945 */       this.jRadioButton7.setEnabled(false);
/* 946 */       this.jRadioButton8.setEnabled(false);
/* 947 */       this.jRadioButton9.setEnabled(false);
/* 948 */       this.jRadioButton10.setEnabled(false);
/* 949 */       this.jRadioButton11.setEnabled(false);
/* 950 */       this.jRadioButton12.setEnabled(false);
/* 951 */       this.jRadioButton13.setEnabled(false);
/* 952 */       this.jRadioButton14.setEnabled(false);
/* 953 */       this.jRadioButton15.setEnabled(false);
/* 954 */       this.jRadioButton16.setEnabled(false);
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.editors.SettingsEditor
 * JD-Core Version:    0.6.2
 */