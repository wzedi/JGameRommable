/*     */ package org.gcreator.editors;
/*     */ 
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JSpinner;
/*     */ import javax.swing.JSplitPane;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.SpinnerNumberModel;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ import javax.swing.event.DocumentEvent;
/*     */ import javax.swing.event.DocumentListener;
/*     */ import javax.swing.text.Document;
/*     */ import org.gcreator.components.TabPanel;
/*     */ import org.gcreator.components.TilesetPreviewer;
/*     */ import org.gcreator.components.WorkspaceTree;
/*     */ import org.gcreator.components.resource.ResourceChooser;
/*     */ import org.gcreator.core.Aurwindow;
/*     */ import org.gcreator.fileclass.GFile;
/*     */ import org.gcreator.fileclass.Project;
/*     */ import org.gcreator.fileclass.res.Tileset;
/*     */ import org.gcreator.managers.LangSupporter;
/*     */ import org.gcreator.units.Dictionary;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class TilesetEditor extends TabPanel
/*     */ {
/*     */   public Tileset value;
/*     */   public ResourceChooser res;
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
/*     */   private JPanel jPanel2;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JSpinner jSpinner1;
/*     */   private JSpinner jSpinner2;
/*     */   private JSpinner jSpinner3;
/*     */   private JSpinner jSpinner4;
/*     */   private JSpinner jSpinner5;
/*     */   private JSpinner jSpinner6;
/*     */   private JSplitPane jSplitPane1;
/*     */   private JTextField jTextField1;
/*     */ 
/*     */   public String langPiece(int val)
/*     */   {
/*  33 */     return LangSupporter.activeLang.getEntry(val);
/*     */   }
/*     */ 
/*     */   public TilesetEditor(GFile file, Project project)
/*     */   {
/*  38 */     this.project = project;
/*  39 */     this.file = file;
/*  40 */     if ((file.value == null) || (!(file.value instanceof Tileset)))
/*  41 */       file.value = new Tileset(file.name);
/*  42 */     this.value = ((Tileset)file.value);
/*  43 */     initComponents();
/*  44 */     this.jPanel2.setLayout(new FlowLayout());
/*  45 */     String k = "<new image>";
/*  46 */     if ((this.value.image != null) && ((this.value.image.value instanceof ImageIcon)))
/*  47 */       k = this.value.image.name;
/*  48 */     this.jPanel2.add(this.res = new ResourceChooser(project, "image"));
/*  49 */     this.res.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  51 */         GFile n = TilesetEditor.this.res.getFile();
/*  52 */         if (n != null)
/*  53 */           TilesetEditor.this.value.image = n;
/*     */         else
/*  55 */           TilesetEditor.this.value.image = null;
/*  56 */         TilesetEditor.this.jScrollPane1.updateUI();
/*     */       }
/*     */     });
/*  59 */     this.jTextField1.setText(file.name);
/*  60 */     this.jTextField1.getDocument().addDocumentListener(new DocumentListener() {
/*     */       public void changedUpdate(DocumentEvent evt) {
/*  62 */         TilesetEditor.this.updateName();
/*     */       }
/*     */       public void removeUpdate(DocumentEvent evt) {
/*  65 */         TilesetEditor.this.updateName();
/*     */       }
/*     */       public void insertUpdate(DocumentEvent evt) {
/*  68 */         TilesetEditor.this.updateName();
/*     */       }
/*     */     });
/*  71 */     this.jSpinner1.setValue(Integer.valueOf(this.value.startx));
/*  72 */     this.jSpinner2.setValue(Integer.valueOf(this.value.starty));
/*  73 */     this.jSpinner3.setValue(Integer.valueOf(this.value.tilew));
/*  74 */     this.jSpinner4.setValue(Integer.valueOf(this.value.tileh));
/*  75 */     this.jSpinner5.setValue(Integer.valueOf(this.value.bwidth));
/*  76 */     this.jSpinner6.setValue(Integer.valueOf(this.value.bheight));
/*  77 */     this.jScrollPane1.setViewportView(new TilesetPreviewer(this));
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  88 */     this.jSplitPane1 = new JSplitPane();
/*  89 */     this.jScrollPane1 = new JScrollPane();
/*  90 */     this.jPanel1 = new JPanel();
/*  91 */     this.jLabel1 = new JLabel();
/*  92 */     this.jTextField1 = new JTextField();
/*  93 */     this.jLabel2 = new JLabel();
/*  94 */     this.jLabel3 = new JLabel();
/*  95 */     this.jSpinner1 = new JSpinner();
/*  96 */     this.jLabel4 = new JLabel();
/*  97 */     this.jSpinner2 = new JSpinner();
/*  98 */     this.jLabel5 = new JLabel();
/*  99 */     this.jLabel6 = new JLabel();
/* 100 */     this.jSpinner3 = new JSpinner();
/* 101 */     this.jLabel7 = new JLabel();
/* 102 */     this.jSpinner4 = new JSpinner();
/* 103 */     this.jLabel8 = new JLabel();
/* 104 */     this.jLabel9 = new JLabel();
/* 105 */     this.jSpinner5 = new JSpinner();
/* 106 */     this.jLabel10 = new JLabel();
/* 107 */     this.jSpinner6 = new JSpinner();
/* 108 */     this.jLabel11 = new JLabel();
/* 109 */     this.jPanel2 = new JPanel();
/*     */ 
/* 111 */     this.jSplitPane1.setDividerLocation(250);
/* 112 */     this.jSplitPane1.setDividerSize(3);
/*     */ 
/* 114 */     this.jScrollPane1.setBorder(BorderFactory.createBevelBorder(1));
/* 115 */     this.jSplitPane1.setRightComponent(this.jScrollPane1);
/*     */ 
/* 117 */     this.jPanel1.setBorder(BorderFactory.createBevelBorder(0));
/*     */ 
/* 119 */     this.jLabel1.setText(langPiece(191));
/*     */ 
/* 121 */     this.jTextField1.setText("jTextField1");
/*     */ 
/* 123 */     this.jLabel2.setText(langPiece(192));
/*     */ 
/* 125 */     this.jLabel3.setText("X");
/*     */ 
/* 127 */     this.jSpinner1.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
/* 128 */     this.jSpinner1.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent evt) {
/* 130 */         TilesetEditor.this.jSpinner1StateChanged(evt);
/*     */       }
/*     */     });
/* 134 */     this.jLabel4.setText("Y");
/*     */ 
/* 136 */     this.jSpinner2.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
/* 137 */     this.jSpinner2.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent evt) {
/* 139 */         TilesetEditor.this.jSpinner2StateChanged(evt);
/*     */       }
/*     */     });
/* 143 */     this.jLabel5.setText("Tile size");
/*     */ 
/* 145 */     this.jLabel6.setText("Width");
/*     */ 
/* 147 */     this.jSpinner3.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
/* 148 */     this.jSpinner3.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent evt) {
/* 150 */         TilesetEditor.this.jSpinner3StateChanged(evt);
/*     */       }
/*     */     });
/* 154 */     this.jLabel7.setText("Height");
/*     */ 
/* 156 */     this.jSpinner4.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
/* 157 */     this.jSpinner4.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent evt) {
/* 159 */         TilesetEditor.this.jSpinner4StateChanged(evt);
/*     */       }
/*     */     });
/* 163 */     this.jLabel8.setText("Separator");
/*     */ 
/* 165 */     this.jLabel9.setText("Horizontal");
/*     */ 
/* 167 */     this.jSpinner5.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
/* 168 */     this.jSpinner5.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent evt) {
/* 170 */         TilesetEditor.this.jSpinner5StateChanged(evt);
/*     */       }
/*     */     });
/* 174 */     this.jLabel10.setText("Vertical");
/*     */ 
/* 176 */     this.jSpinner6.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
/* 177 */     this.jSpinner6.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent evt) {
/* 179 */         TilesetEditor.this.jSpinner6StateChanged(evt);
/*     */       }
/*     */     });
/* 183 */     this.jLabel11.setText("Image:");
/*     */ 
/* 185 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 186 */     this.jPanel2.setLayout(jPanel2Layout);
/* 187 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(1).add(0, 225, 32767));
/*     */ 
/* 191 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(1).add(0, 25, 32767));
/*     */ 
/* 196 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 197 */     this.jPanel1.setLayout(jPanel1Layout);
/* 198 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().addContainerGap().add(jPanel1Layout.createParallelGroup(1).add(this.jPanel2, -1, -1, 32767).add(this.jLabel5).add(jPanel1Layout.createSequentialGroup().add(this.jLabel1).addPreferredGap(0).add(this.jTextField1, -1, 155, 32767)).add(jPanel1Layout.createSequentialGroup().add(jPanel1Layout.createParallelGroup(1).add(this.jLabel9).add(this.jLabel10)).addPreferredGap(0).add(jPanel1Layout.createParallelGroup(1).add(this.jSpinner6, -2, 51, -2).add(this.jSpinner5, -2, 51, -2))).add(this.jLabel8).add(jPanel1Layout.createSequentialGroup().add(this.jLabel6).addPreferredGap(0).add(this.jSpinner3, -2, 51, -2).addPreferredGap(0).add(this.jLabel7).addPreferredGap(0).add(this.jSpinner4, -2, 49, -2)).add(jPanel1Layout.createSequentialGroup().add(this.jLabel3).addPreferredGap(0).add(this.jSpinner1, -2, 39, -2).addPreferredGap(1).add(this.jLabel4).addPreferredGap(0).add(this.jSpinner2, -2, 39, -2)).add(this.jLabel11).add(this.jLabel2)).addContainerGap()));
/*     */ 
/* 238 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().addContainerGap().add(jPanel1Layout.createParallelGroup(3).add(this.jLabel1).add(this.jTextField1, -2, -1, -2)).addPreferredGap(0).add(this.jLabel11).addPreferredGap(0).add(this.jPanel2, -2, -1, -2).add(18, 18, 18).add(this.jLabel2).add(8, 8, 8).add(jPanel1Layout.createParallelGroup(3).add(this.jLabel3).add(this.jLabel4).add(this.jSpinner1, -2, -1, -2).add(this.jSpinner2, -2, -1, -2)).addPreferredGap(0).add(this.jLabel5).addPreferredGap(0).add(jPanel1Layout.createParallelGroup(3).add(this.jLabel6).add(this.jSpinner3, -2, -1, -2).add(this.jLabel7).add(this.jSpinner4, -2, -1, -2)).addPreferredGap(0).add(this.jLabel8).addPreferredGap(0).add(jPanel1Layout.createParallelGroup(3).add(this.jLabel9).add(this.jSpinner5, -2, -1, -2)).addPreferredGap(0).add(jPanel1Layout.createParallelGroup(3).add(this.jLabel10).add(this.jSpinner6, -2, -1, -2)).addContainerGap(125, 32767)));
/*     */ 
/* 278 */     this.jSplitPane1.setLeftComponent(this.jPanel1);
/*     */ 
/* 280 */     GroupLayout layout = new GroupLayout(this);
/* 281 */     setLayout(layout);
/* 282 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(this.jSplitPane1, -1, 517, 32767));
/*     */ 
/* 286 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(this.jSplitPane1, -1, 391, 32767));
/*     */   }
/*     */ 
/*     */   private void jSpinner1StateChanged(ChangeEvent evt)
/*     */   {
/* 293 */     this.jSpinner1.setValue(Integer.valueOf(Math.min(((Integer)this.jSpinner1.getValue()).intValue(), ((Integer)this.jSpinner3.getValue()).intValue())));
/* 294 */     this.value.startx = ((Integer)this.jSpinner1.getValue()).intValue();
/* 295 */     this.jScrollPane1.updateUI();
/*     */   }
/*     */ 
/*     */   private void jSpinner2StateChanged(ChangeEvent evt) {
/* 299 */     this.jSpinner2.setValue(Integer.valueOf(Math.min(((Integer)this.jSpinner2.getValue()).intValue(), ((Integer)this.jSpinner4.getValue()).intValue())));
/* 300 */     this.value.starty = ((Integer)this.jSpinner2.getValue()).intValue();
/* 301 */     this.jScrollPane1.updateUI();
/*     */   }
/*     */ 
/*     */   private void jSpinner3StateChanged(ChangeEvent evt) {
/* 305 */     this.jSpinner1.setValue(Integer.valueOf(Math.min(((Integer)this.jSpinner1.getValue()).intValue(), ((Integer)this.jSpinner3.getValue()).intValue())));
/* 306 */     this.value.tilew = ((Integer)this.jSpinner3.getValue()).intValue();
/* 307 */     this.jScrollPane1.updateUI();
/*     */   }
/*     */ 
/*     */   private void jSpinner4StateChanged(ChangeEvent evt) {
/* 311 */     this.jSpinner2.setValue(Integer.valueOf(Math.min(((Integer)this.jSpinner2.getValue()).intValue(), ((Integer)this.jSpinner4.getValue()).intValue())));
/* 312 */     this.value.tileh = ((Integer)this.jSpinner4.getValue()).intValue();
/* 313 */     this.jScrollPane1.updateUI();
/*     */   }
/*     */ 
/*     */   private void jSpinner5StateChanged(ChangeEvent evt) {
/* 317 */     this.value.bheight = ((Integer)this.jSpinner5.getValue()).intValue();
/* 318 */     this.jScrollPane1.updateUI();
/*     */   }
/*     */ 
/*     */   private void jSpinner6StateChanged(ChangeEvent evt) {
/* 322 */     this.value.bwidth = ((Integer)this.jSpinner6.getValue()).intValue();
/* 323 */     this.jScrollPane1.updateUI();
/*     */   }
/*     */ 
/*     */   public void updateName() {
/* 327 */     this.file.name = this.jTextField1.getText();
/* 328 */     this.value.name = this.file.name;
/* 329 */     Aurwindow.workspace.updateUI();
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.editors.TilesetEditor
 * JD-Core Version:    0.6.2
 */