/*      */ package org.gcreator.editors;
/*      */ 
/*      */ import java.awt.Color;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.FlowLayout;
/*      */ import java.awt.Rectangle;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.AdjustmentEvent;
/*      */ import java.awt.event.AdjustmentListener;
/*      */ import java.awt.event.ComponentAdapter;
/*      */ import java.awt.event.ComponentEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.util.Enumeration;

/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.DefaultComboBoxModel;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JCheckBox;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JEditorPane;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JList;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSpinner;
/*      */ import javax.swing.JSplitPane;
/*      */ import javax.swing.JTabbedPane;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.JToggleButton;
/*      */ import javax.swing.JToolBar;
/*      */ import javax.swing.SpinnerNumberModel;
/*      */ import javax.swing.event.ChangeEvent;
/*      */ import javax.swing.event.ChangeListener;
/*      */ import javax.swing.event.DocumentEvent;
/*      */ import javax.swing.event.DocumentListener;
/*      */ import javax.swing.event.ListSelectionEvent;
/*      */ import javax.swing.event.ListSelectionListener;

/*      */ import org.gcreator.components.ColorSelection;
/*      */ import org.gcreator.components.ScenePanel;
/*      */ import org.gcreator.components.TabPanel;
/*      */ import org.gcreator.components.TileChooser;
/*      */ import org.gcreator.components.resource.ResourceChooser;
/*      */ import org.gcreator.core.Aurwindow;
/*      */ import org.gcreator.fileclass.GFile;
/*      */ import org.gcreator.fileclass.Project;
/*      */ import org.gcreator.fileclass.res.Actor;
/*      */ import org.gcreator.fileclass.res.Scene;
/*      */ import org.gcreator.fileclass.res.Sprite;
/*      */ import org.gcreator.fileclass.res.Tileset;
/*      */ import org.gcreator.managers.LangSupporter;
/*      */ import org.gcreator.units.ActorInScene;
/*      */ import org.gcreator.units.BackgroundInScene;
/*      */ import org.gcreator.units.BackgroundsModel;
/*      */ import org.gcreator.units.ObjectNode;
/*      */ import org.gcreator.units.Tile;
/*      */ import org.gcreator.units.ViewInScene;
/*      */ import org.gcreator.units.ViewsModel;
/*      */ import org.jdesktop.layout.GroupLayout;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class SceneEditor extends TabPanel
/*      */ {
/*      */   public ScenePanel scene;
/*      */   public ViewsModel model;
/*      */   public BackgroundsModel bgmodel;
/*   41 */   public boolean changed = false;
/*      */   public ResourceChooser curactor;
/*      */   public ResourceChooser curbg;
/*      */   public ResourceChooser curtileset;
/*   45 */   double instanceids = 0.0D;
/*      */   //public SyntaxHighlighter egml;
/*      */   public TileChooser tilechooser;
/*      */   public static final int INVALID = 0;
/*      */   public static final int PENCIL = 1;
/*      */   public static final int ERASE = 2;
/*      */   public static final int TILEADD = 3;
/*      */   public JLabel BottomLeft;
/*      */   private JLabel BottomRight;
/*      */   private ColorSelection colorSelection1;
/*      */   private JButton jButton1;
/*      */   private JButton jButton2;
/*      */   private JButton jButton3;
/*      */   private JButton jButton4;
/*      */   private JButton jButton5;
/*      */   private JButton jButton6;
/*      */   private JButton jButton7;
/*      */   private JButton jButton8;
/*      */   private JCheckBox jCheckBox1;
/*      */   private JCheckBox jCheckBox2;
/*      */   public JCheckBox jCheckBox3;
/*      */   private JCheckBox jCheckBox4;
/*      */   private JCheckBox jCheckBox5;
/*      */   private JComboBox jComboBox1;
/*      */   private JComboBox jComboBox2;
/*      */   public JEditorPane jEditorPane1;
/*      */   private JLabel jLabel1;
/*      */   private JLabel jLabel10;
/*      */   private JLabel jLabel11;
/*      */   private JLabel jLabel12;
/*      */   private JLabel jLabel13;
/*      */   private JLabel jLabel14;
/*      */   private JLabel jLabel15;
/*      */   private JLabel jLabel16;
/*      */   private JLabel jLabel17;
/*      */   private JLabel jLabel18;
/*      */   private JLabel jLabel19;
/*      */   private JLabel jLabel2;
/*      */   private JLabel jLabel20;
/*      */   private JLabel jLabel21;
/*      */   private JLabel jLabel22;
/*      */   private JLabel jLabel23;
/*      */   private JLabel jLabel24;
/*      */   private JLabel jLabel25;
/*      */   private JLabel jLabel26;
/*      */   private JLabel jLabel27;
/*      */   private JLabel jLabel28;
/*      */   private JLabel jLabel29;
/*      */   private JLabel jLabel3;
/*      */   private JLabel jLabel4;
/*      */   private JLabel jLabel5;
/*      */   private JLabel jLabel6;
/*      */   private JLabel jLabel7;
/*      */   private JLabel jLabel8;
/*      */   private JLabel jLabel9;
/*      */   public JList jList1;
/*      */   private JList jList2;
/*      */   private JPanel jPanel1;
/*      */   private JPanel jPanel10;
/*      */   private JPanel jPanel11;
/*      */   private JPanel jPanel12;
/*      */   private JPanel jPanel13;
/*      */   private JPanel jPanel14;
/*      */   private JPanel jPanel15;
/*      */   private JPanel jPanel2;
/*      */   private JPanel jPanel3;
/*      */   private JPanel jPanel4;
/*      */   private JPanel jPanel5;
/*      */   private JPanel jPanel6;
/*      */   private JPanel jPanel7;
/*      */   private JPanel jPanel8;
/*      */   private JPanel jPanel9;
/*      */   private JScrollPane jScrollPane1;
/*      */   private JScrollPane jScrollPane2;
/*      */   private JScrollPane jScrollPane3;
/*      */   private JScrollPane jScrollPane4;
/*      */   private JScrollPane jScrollPane5;
/*      */   private JScrollPane jScrollPane6;
/*      */   private JScrollPane jScrollPane7;
/*      */   private JScrollPane jScrollPane8;
/*      */   private JSpinner jSpinner1;
/*      */   private JSpinner jSpinner10;
/*      */   private JSpinner jSpinner11;
/*      */   private JSpinner jSpinner12;
/*      */   public JSpinner jSpinner13;
/*      */   public JSpinner jSpinner14;
/*      */   public JSpinner jSpinner15;
/*      */   public JSpinner jSpinner16;
/*      */   public JSpinner jSpinner17;
/*      */   private JSpinner jSpinner2;
/*      */   private JSpinner jSpinner3;
/*      */   private JSpinner jSpinner4;
/*      */   private JSpinner jSpinner5;
/*      */   private JSpinner jSpinner6;
/*      */   private JSpinner jSpinner7;
/*      */   private JSpinner jSpinner8;
/*      */   private JSpinner jSpinner9;
/*      */   private JSplitPane jSplitPane1;
/*      */   private JTabbedPane jTabbedPane1;
/*      */   private JTextField jTextField1;
/*      */   public JTextField jTextField2;
/*      */   public JTextField jTextField3;
/*      */   public JToggleButton jToggleButton1;
/*      */   private JToggleButton jToggleButton2;
/*      */   private JToggleButton jToggleButton3;
/*      */   private JToolBar jToolBar1;
/*      */ 
/*      */   public boolean snapToGrid()
/*      */   {
/*   52 */     return this.jToggleButton3.isSelected();
/*      */   }
/*      */ 
/*      */   public ActorInScene makeNewActor(int x, int y) {
/*   56 */     GFile a = this.curactor.getFile();
/*   57 */     this.instanceids += 1.0D;
/*   58 */     if (this.jToggleButton3.isSelected()) {
/*   59 */       Scene s = (Scene)this.file.value;
/*   60 */       if (x % s.snapX > s.snapX / 2) {
/*   61 */         x /= s.snapX;
/*   62 */         x++;
/*   63 */         x *= s.snapX;
/*      */       }
/*      */       else {
/*   66 */         x /= s.snapX;
/*   67 */         x *= s.snapX;
/*      */       }
/*   69 */       if (y % s.snapY > s.snapY / 2) {
/*   70 */         y /= s.snapY;
/*   71 */         y++;
/*   72 */         y *= s.snapY;
/*      */       }
/*      */       else {
/*   75 */         y /= s.snapY;
/*   76 */         y *= s.snapY;
/*      */       }
/*      */     }
/*   79 */     return new ActorInScene(a, x, y, this.instanceids);
/*      */   }
/*      */ 
/*      */   public void eraseActorsAt(int x, int y) {
/*   83 */     eraseActorsAt(new Rectangle(x, y, 1, 1));
/*      */   }
/*      */ 
/*      */   public Tileset getTileset()
/*      */   {
/*   91 */     return (Tileset)((GFile)this.curtileset.getCurrentObject().object).value;
/*      */   }
/*      */ 
/*      */   public void eraseActorsAt(Rectangle r)
/*      */   {
/*   99 */     Enumeration e = ((Scene)this.file.value).actors.elements();
/*  100 */     while (e.hasMoreElements()) {
/*  101 */       ActorInScene ais = (ActorInScene)e.nextElement();
/*      */ 
/*  103 */       int aisx = ais.x;
/*  104 */       int aisy = ais.y;
/*  105 */       GFile k = this.curactor.getFile();
/*  106 */       Sprite j = (Sprite)k.value;
/*  107 */       ImageIcon i = j.getImageAt(0);
/*  108 */       int aisw = i.getIconWidth();
/*  109 */       int aish = i.getIconHeight();
/*  110 */       if ((aisx <= r.x + r.width) && 
/*  111 */         (aisx + aisw >= r.x) && 
/*  112 */         (aisy <= r.y + r.height) && 
/*  113 */         (aisy + aish >= r.y))
/*  114 */         ((Scene)this.file.value).actors.remove(ais);
/*      */     }
/*      */   }
/*      */ 
/*      */   public boolean eraseActorsBelow() {
/*  119 */     return this.jCheckBox5.isSelected();
/*      */   }
/*      */ 
/*      */   public void updateImage() {
/*  123 */     Actor b = (Actor)this.curactor.getFile().value;
/*  124 */     GFile t = b.sprite;
/*  125 */     if (t == null)
/*  126 */       return;
/*  127 */     ObjectNode c = t.node;
/*  128 */     if (c != null) {
/*  129 */       GFile d = (GFile)c.object;
/*  130 */       Sprite f = (Sprite)d.value;
/*  131 */       ImageIcon h = f.getImageAt(0);
/*  132 */       this.jLabel18.setIcon(h);
/*      */     }
/*      */   }
/*      */ 
/*  136 */   public void updateBgImage() { if (this.curbg.getCurrentObject() == null) {
/*  137 */       this.jLabel23.setIcon(null);
/*      */ 
/*  139 */       this.scene.updateUI();
/*  140 */       return;
/*      */     }
/*      */ 
/*  147 */     this.scene.updateUI();
/*      */   }
/*      */ 
/*      */   public SceneEditor(final GFile file, Project project)
/*      */   {
/*  154 */     if (!(file.value instanceof Scene))
/*  155 */       file.value = new Scene(file.name);
/*  156 */     this.file = file;
/*  157 */     this.project = project;
/*  158 */     this.model = new ViewsModel(((Scene)file.value).views);
/*  159 */     this.bgmodel = new BackgroundsModel(((Scene)file.value).backgrounds);
/*  160 */     initComponents();
/*  161 */     this.scene = new ScenePanel(this);
/*  162 */     this.scene.setSize(500, 500);
/*  163 */     this.jScrollPane1.setViewportView(this.scene);
/*  164 */     this.file = file;
/*  165 */     //Scanner scanner = new GCLScanner();
/*  166 */     //this.egml = new SyntaxHighlighter(100, 100, scanner, project);
/*  167 */     //this.egml.setText(((Scene)file.value).code);
/*  168 */     this.tilechooser = new TileChooser(this);
/*  169 */     this.jList1.setSelectedIndex(0);
/*  170 */     setup();
/*  171 */     this.jTextField1.setText(file.name);
/*  172 */     this.jTextField1.getDocument().addDocumentListener(new DocumentListener() {
/*      */       public void changedUpdate(DocumentEvent evt) {
/*  174 */         SceneEditor.this.updateName();
/*      */       }
/*      */       public void insertUpdate(DocumentEvent evt) {
/*  177 */         SceneEditor.this.updateName();
/*      */       }
/*      */       public void removeUpdate(DocumentEvent evt) {
/*  180 */         SceneEditor.this.updateName();
/*      */       }
/*      */     });
/*  184 */     Load();
/*  185 */     this.jPanel11.setLayout(new FlowLayout());
/*  186 */     this.jPanel11.add(this.curactor = new ResourceChooser(project, "actor"));
/*  187 */     this.curactor.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  189 */         SceneEditor.this.updateImage();
/*      */       }
/*      */     });
/*  192 */     this.jPanel6.setLayout(new FlowLayout());
/*      */ 
/*  196 */     this.jPanel6.add(this.curbg = new ResourceChooser(project, "image"));
/*  197 */     this.curbg.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  199 */         Scene s = (Scene)file.value;
/*  200 */         BackgroundInScene bg = (BackgroundInScene)s.backgrounds.get(SceneEditor.this.jList2.getSelectedIndex());
/*  201 */         bg.image = ((GFile)SceneEditor.this.curbg.getCurrentObject().object);
/*  202 */         SceneEditor.this.updateBgImage();
/*      */       }
/*      */     });
/*  205 */     updateBgImage();
/*  206 */     this.jToggleButton1.setSelected(((Scene)file.value).grid);
/*  207 */     this.colorSelection1.setBackground(((Scene)file.value).background);
/*  208 */     this.jSpinner12.setValue(Integer.valueOf(((Scene)file.value).speed));
/*  209 */     //this.jScrollPane5.setViewportView(this.egml);
/*  210 */     this.jScrollPane1.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
/*      */       public void adjustmentValueChanged(AdjustmentEvent evt) {
/*  212 */         SceneEditor.this.jScrollPane1.updateUI();
/*      */       }
/*      */     });
/*  215 */     this.jScrollPane1.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {
/*      */       public void adjustmentValueChanged(AdjustmentEvent evt) {
/*  217 */         SceneEditor.this.jScrollPane1.updateUI();
/*      */       }
/*      */     });
/*  220 */     this.jScrollPane7.setViewportView(this.tilechooser);
/*  221 */     this.jPanel13.setLayout(new FlowLayout());
/*  222 */     this.jPanel13.add(this.curtileset = new ResourceChooser(project, "tileset"));
/*  223 */     this.curtileset.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  225 */         SceneEditor.this.jScrollPane7.updateUI();
/*  226 */         SceneEditor.this.tilechooser.updateUI();
/*      */       }
/*      */     });
/*  229 */     jList2ValueChanged(null);
/*      */   }
/*      */ 
/*      */   public boolean Load()
/*      */   {
/*  235 */     this.jEditorPane1.setText(((Scene)this.file.value).caption);
/*  236 */     if (((Scene)this.file.value).width == 0) {
/*  237 */       this.jTextField2.setText("600");
/*      */     }
/*      */     else {
/*  240 */       this.jTextField2.setText("" + ((Scene)this.file.value).width);
/*      */     }
/*  242 */     if (((Scene)this.file.value).height == 0) {
/*  243 */       this.jTextField3.setText("600");
/*      */     }
/*      */     else {
/*  246 */       this.jTextField3.setText("" + ((Scene)this.file.value).height);
/*      */     }
/*  248 */     this.jCheckBox1.setSelected(((Scene)this.file.value).drawbackcolor);
/*  249 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean Save()
/*      */   {
/*  255 */     Scene s = (Scene)this.file.value;
/*  256 */     s.caption = this.jEditorPane1.getText();
/*  257 */     s.width = Integer.parseInt(this.jTextField2.getText());
/*  258 */     s.height = Integer.parseInt(this.jTextField3.getText());
/*  259 */     s.speed = ((Integer)this.jSpinner12.getValue()).intValue();
/*  260 */     s.persistant = this.jCheckBox3.isSelected();
/*  261 */     s.snapX = ((Integer)this.jSpinner2.getValue()).intValue();
/*  262 */     s.snapY = ((Integer)this.jSpinner3.getValue()).intValue();
/*  263 */     s.background = getMapBGColor();
/*  264 */     s.drawbackcolor = this.jCheckBox1.isSelected();
/*      */ 
/*  266 */     return true;
/*      */   }
/*      */ 
/*      */   public boolean wasModified()
/*      */   {
/*  272 */     return this.changed;
/*      */   }
/*      */ 
/*      */   public void setup() {
/*      */     try {
/*  277 */       ViewInScene v = (ViewInScene)this.jList1.getSelectedValue();
/*  278 */       this.jCheckBox4.setSelected(v.visibleonstart);
/*  279 */       this.jSpinner4.setValue(Integer.valueOf(v.viewx));
/*  280 */       this.jSpinner5.setValue(Integer.valueOf(v.viewy));
/*  281 */       this.jSpinner6.setValue(Integer.valueOf(v.vieww));
/*  282 */       this.jSpinner7.setValue(Integer.valueOf(v.viewh));
/*  283 */       this.jSpinner8.setValue(Integer.valueOf(v.portx));
/*  284 */       this.jSpinner9.setValue(Integer.valueOf(v.porty));
/*  285 */       this.jSpinner10.setValue(Integer.valueOf(v.portw));
/*  286 */       this.jSpinner11.setValue(Integer.valueOf(v.porth));
/*      */     } catch (NullPointerException e) {
/*      */     }
/*      */   }
/*      */ 
/*      */   public boolean isGridVisible() {
/*  292 */     return this.jToggleButton1.isSelected();
/*      */   }
/*      */ 
/*      */   public boolean isIsometric() {
/*  296 */     return this.jToggleButton2.isSelected();
/*      */   }
/*      */ 
/*      */   public int getSnapX() {
/*  300 */     return ((Integer)this.jSpinner2.getValue()).intValue();
/*      */   }
/*      */ 
/*      */   public int getSnapY() {
/*  304 */     return ((Integer)this.jSpinner3.getValue()).intValue();
/*      */   }
/*      */ 
/*      */   public int getMapWidth()
/*      */   {
/*      */     try {
/*  310 */       return Integer.parseInt(this.jTextField2.getText());
/*      */     } catch (NumberFormatException e) {
/*      */     }
/*  313 */     return 0;
/*      */   }
/*      */ 
/*      */   public int getMapHeight()
/*      */   {
/*      */     try {
/*  319 */       return Integer.parseInt(this.jTextField3.getText());
/*      */     } catch (NumberFormatException e) {
/*      */     }
/*  322 */     return 0;
/*      */   }
/*      */ 
/*      */   public double getZoom()
/*      */   {
/*  327 */     int x = ((Integer)this.jSpinner1.getValue()).intValue();
/*  328 */     switch (x) { case -5:
/*  329 */       return 6.0D;
/*      */     case -4:
/*  330 */       return 5.0D;
/*      */     case -3:
/*  331 */       return 4.0D;
/*      */     case -2:
/*  332 */       return 3.0D;
/*      */     case -1:
/*  333 */       return 2.0D;
/*      */     case 0:
/*  334 */       return 1.0D;
/*      */     case 1:
/*  335 */       return 0.5D;
/*      */     case 2:
/*  336 */       return 0.33D;
/*      */     case 3:
/*  337 */       return 0.25D;
/*      */     case 4:
/*  338 */       return 0.2D; }
/*  339 */     return 0.16D;
/*      */   }
/*      */ 
/*      */   public void updateName()
/*      */   {
/*  344 */     this.file.name = this.jTextField1.getText();
/*  345 */     this.scene.setName(this.file.name);
/*  346 */     Aurwindow.workspace.updateUI();
/*      */   }
/*      */ 
/*      */   private void initComponents()
/*      */   {
/*  356 */     this.jPanel8 = new JPanel();
/*  357 */     this.jButton4 = new JButton();
/*  358 */     this.jButton5 = new JButton();
/*  359 */     this.jButton6 = new JButton();
/*  360 */     this.jToggleButton1 = new JToggleButton();
/*  361 */     this.jToggleButton2 = new JToggleButton();
/*  362 */     this.jLabel1 = new JLabel();
/*  363 */     this.jSpinner1 = new JSpinner();
/*  364 */     this.jLabel2 = new JLabel();
/*  365 */     this.jSpinner2 = new JSpinner();
/*  366 */     this.jLabel3 = new JLabel();
/*  367 */     this.jSpinner3 = new JSpinner();
/*  368 */     this.jToggleButton3 = new JToggleButton();
/*  369 */     this.jSplitPane1 = new JSplitPane();
/*  370 */     this.jTabbedPane1 = new JTabbedPane();
/*  371 */     this.jPanel2 = new JPanel();
/*  372 */     this.jScrollPane4 = new JScrollPane();
/*  373 */     this.jLabel18 = new JLabel();
/*  374 */     this.jPanel11 = new JPanel();
/*  375 */     this.jCheckBox5 = new JCheckBox();
/*  376 */     this.jButton7 = new JButton();
/*  377 */     this.jPanel1 = new JPanel();
/*  378 */     this.jLabel5 = new JLabel();
/*  379 */     this.jTextField1 = new JTextField();
/*  380 */     this.jLabel6 = new JLabel();
/*  381 */     this.jScrollPane2 = new JScrollPane();
/*  382 */     this.jEditorPane1 = new JEditorPane();
/*  383 */     this.jLabel7 = new JLabel();
/*  384 */     this.jTextField2 = new JTextField();
/*  385 */     this.jLabel8 = new JLabel();
/*  386 */     this.jTextField3 = new JTextField();
/*  387 */     this.jLabel9 = new JLabel();
/*  388 */     this.jCheckBox3 = new JCheckBox();
/*  389 */     this.jSpinner12 = new JSpinner();
/*  390 */     this.jLabel19 = new JLabel();
/*  391 */     this.jScrollPane5 = new JScrollPane();
/*  392 */     this.jPanel5 = new JPanel();
/*  393 */     this.jCheckBox1 = new JCheckBox();
/*  394 */     this.colorSelection1 = new ColorSelection();
/*  395 */     this.jPanel6 = new JPanel();
/*  396 */     this.jLabel20 = new JLabel();
/*  397 */     this.jLabel21 = new JLabel();
/*  398 */     this.jComboBox1 = new JComboBox();
/*  399 */     this.jLabel22 = new JLabel();
/*  400 */     this.jComboBox2 = new JComboBox();
/*  401 */     this.jScrollPane6 = new JScrollPane();
/*  402 */     this.jLabel23 = new JLabel();
/*  403 */     this.jScrollPane8 = new JScrollPane();
/*  404 */     this.jList2 = new JList();
/*  405 */     this.jPanel7 = new JPanel();
/*  406 */     this.jCheckBox2 = new JCheckBox();
/*  407 */     this.jScrollPane3 = new JScrollPane();
/*  408 */     this.jList1 = new JList();
/*  409 */     this.jCheckBox4 = new JCheckBox();
/*  410 */     this.jPanel9 = new JPanel();
/*  411 */     this.jLabel10 = new JLabel();
/*  412 */     this.jLabel11 = new JLabel();
/*  413 */     this.jLabel12 = new JLabel();
/*  414 */     this.jLabel13 = new JLabel();
/*  415 */     this.jSpinner4 = new JSpinner();
/*  416 */     this.jSpinner5 = new JSpinner();
/*  417 */     this.jSpinner6 = new JSpinner();
/*  418 */     this.jSpinner7 = new JSpinner();
/*  419 */     this.jPanel10 = new JPanel();
/*  420 */     this.jLabel14 = new JLabel();
/*  421 */     this.jLabel15 = new JLabel();
/*  422 */     this.jLabel16 = new JLabel();
/*  423 */     this.jLabel17 = new JLabel();
/*  424 */     this.jSpinner8 = new JSpinner();
/*  425 */     this.jSpinner9 = new JSpinner();
/*  426 */     this.jSpinner10 = new JSpinner();
/*  427 */     this.jSpinner11 = new JSpinner();
/*  428 */     this.jPanel12 = new JPanel();
/*  429 */     this.jScrollPane7 = new JScrollPane();
/*  430 */     this.jPanel15 = new JPanel();
/*  431 */     this.jPanel13 = new JPanel();
/*  432 */     this.jLabel4 = new JLabel();
/*  433 */     this.jSpinner13 = new JSpinner();
/*  434 */     this.jLabel26 = new JLabel();
/*  435 */     this.jSpinner14 = new JSpinner();
/*  436 */     this.jLabel27 = new JLabel();
/*  437 */     this.jSpinner15 = new JSpinner();
/*  438 */     this.jLabel28 = new JLabel();
/*  439 */     this.jSpinner16 = new JSpinner();
/*  440 */     this.jLabel29 = new JLabel();
/*  441 */     this.jSpinner17 = new JSpinner();
/*  442 */     this.jPanel3 = new JPanel();
/*  443 */     this.jPanel4 = new JPanel();
/*  444 */     this.BottomLeft = new JLabel();
/*  445 */     this.BottomRight = new JLabel();
/*  446 */     this.jToolBar1 = new JToolBar();
/*  447 */     this.jLabel24 = new JLabel();
/*  448 */     this.jButton2 = new JButton();
/*  449 */     this.jButton1 = new JButton();
/*  450 */     this.jButton3 = new JButton();
/*  451 */     this.jPanel14 = new JPanel();
/*  452 */     this.jLabel25 = new JLabel();
/*  453 */     this.jButton8 = new JButton();
/*  454 */     this.jScrollPane1 = new JScrollPane();
/*      */ 
/*  456 */     this.jButton4.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/general/undo.png")));
/*  457 */     this.jButton4.setFocusable(false);
/*  458 */     this.jButton4.setHorizontalTextPosition(0);
/*  459 */     this.jButton4.setVerticalTextPosition(3);
/*      */ 
/*  461 */     this.jButton5.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/toolbar/clearall.png")));
/*  462 */     this.jButton5.setToolTipText("Clear all instances");
/*  463 */     this.jButton5.setFocusable(false);
/*  464 */     this.jButton5.setHorizontalTextPosition(0);
/*  465 */     this.jButton5.setVerticalTextPosition(3);
/*      */ 
/*  467 */     this.jButton6.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/toolbar/shift.png")));
/*  468 */     this.jButton6.setToolTipText("Shift all instances");
/*  469 */     this.jButton6.setFocusable(false);
/*  470 */     this.jButton6.setHorizontalTextPosition(0);
/*  471 */     this.jButton6.setVerticalTextPosition(3);
/*      */ 
/*  473 */     this.jToggleButton1.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/toolbar/showgrid.png")));
/*  474 */     this.jToggleButton1.setSelected(true);
/*  475 */     this.jToggleButton1.setToolTipText("Show Grid");
/*  476 */     this.jToggleButton1.setFocusable(false);
/*  477 */     this.jToggleButton1.setHorizontalTextPosition(0);
/*  478 */     this.jToggleButton1.setVerticalTextPosition(3);
/*  479 */     this.jToggleButton1.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  481 */         SceneEditor.this.jToggleButton1ActionPerformed(evt);
/*      */       }
/*      */     });
/*  485 */     this.jToggleButton2.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/toolbar/iso.png")));
/*  486 */     this.jToggleButton2.setToolTipText("Isometric");
/*  487 */     this.jToggleButton2.setFocusable(false);
/*  488 */     this.jToggleButton2.setHorizontalTextPosition(0);
/*  489 */     this.jToggleButton2.setVerticalTextPosition(3);
/*  490 */     this.jToggleButton2.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  492 */         SceneEditor.this.jToggleButton1ActionPerformed(evt);
/*      */       }
/*      */     });
/*  496 */     this.jLabel1.setText(LangSupporter.activeLang.getEntry(119));
/*      */ 
/*  498 */     this.jSpinner1.setModel(new SpinnerNumberModel(0, -5, 5, 1));
/*  499 */     this.jSpinner1.addChangeListener(new ChangeListener() {
/*      */       public void stateChanged(ChangeEvent evt) {
/*  501 */         SceneEditor.this.jSpinner1StateChanged(evt);
/*      */       }
/*      */     });
/*  505 */     this.jLabel2.setText("Snap X");
/*      */ 
/*  507 */     this.jSpinner2.setModel(new SpinnerNumberModel(Integer.valueOf(20), Integer.valueOf(1), null, Integer.valueOf(2)));
/*  508 */     this.jSpinner2.addChangeListener(new ChangeListener() {
/*      */       public void stateChanged(ChangeEvent evt) {
/*  510 */         SceneEditor.this.jSpinner1StateChanged(evt);
/*      */       }
/*      */     });
/*  514 */     this.jLabel3.setText("Snap Y");
/*      */ 
/*  516 */     this.jSpinner3.setModel(new SpinnerNumberModel(Integer.valueOf(20), Integer.valueOf(1), null, Integer.valueOf(2)));
/*  517 */     this.jSpinner3.addChangeListener(new ChangeListener() {
/*      */       public void stateChanged(ChangeEvent evt) {
/*  519 */         SceneEditor.this.jSpinner1StateChanged(evt);
/*      */       }
/*      */     });
/*  523 */     this.jToggleButton3.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/Snap_To_Grid.png")));
/*  524 */     this.jToggleButton3.setToolTipText("Snap to grid");
/*      */ 
/*  526 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  527 */     this.jPanel8.setLayout(jPanel8Layout);
/*  528 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(1).add(jPanel8Layout.createSequentialGroup().add(this.jButton4).addPreferredGap(0).add(this.jButton5, -2, 29, -2).addPreferredGap(0).add(this.jButton6, -2, 29, -2).addPreferredGap(0).add(this.jToggleButton1, -2, 29, -2).addPreferredGap(0).add(this.jToggleButton2, -2, 25, -2).addPreferredGap(0).add(this.jToggleButton3).addPreferredGap(0).add(this.jLabel1).addPreferredGap(0).add(this.jSpinner1, -2, -1, -2).addPreferredGap(0).add(this.jLabel2).addPreferredGap(0).add(this.jSpinner2, -2, 47, -2).addPreferredGap(0).add(this.jLabel3).addPreferredGap(0).add(this.jSpinner3, -2, 41, -2).add(232, 232, 232)));
/*      */ 
/*  556 */     jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(1).add(jPanel8Layout.createSequentialGroup().add(jPanel8Layout.createParallelGroup(1).add(jPanel8Layout.createSequentialGroup().addContainerGap().add(jPanel8Layout.createParallelGroup(3).add(this.jLabel1).add(this.jSpinner1, -2, -1, -2).add(this.jLabel2).add(this.jSpinner2, -2, -1, -2).add(this.jLabel3).add(this.jSpinner3, -2, -1, -2))).add(this.jButton4, -2, 44, -2).add(jPanel8Layout.createSequentialGroup().addContainerGap().add(jPanel8Layout.createParallelGroup(1).add(this.jToggleButton2, -2, 23, -2).add(this.jToggleButton1, -2, 23, -2).add(this.jButton5, -2, 23, -2).add(this.jButton6, -2, 23, -2))).add(this.jToggleButton3)).addContainerGap(-1, 32767)));
/*      */ 
/*  581 */     this.jSplitPane1.setDividerLocation(250);
/*  582 */     this.jSplitPane1.addComponentListener(new ComponentAdapter() {
/*      */       public void componentResized(ComponentEvent evt) {
/*  584 */         SceneEditor.this.jSplitPane1ComponentResized(evt);
/*      */       }
/*      */     });
/*  588 */     this.jPanel2.setBorder(BorderFactory.createBevelBorder(1));
/*      */ 
/*  590 */     this.jScrollPane4.setViewportView(this.jLabel18);
/*      */ 
/*  592 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/*  593 */     this.jPanel11.setLayout(jPanel11Layout);
/*  594 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(1).add(0, 240, 32767));
/*      */ 
/*  598 */     jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(1).add(0, 24, 32767));
/*      */ 
/*  603 */     this.jCheckBox5.setText("Delete Instance Under");
/*  604 */     this.jCheckBox5.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  606 */         SceneEditor.this.jCheckBox5ActionPerformed(evt);
/*      */       }
/*      */     });
/*  610 */     this.jButton7.setText("<HTML>Delete all instances<bR>outside scene");
/*      */ 
/*  612 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  613 */     this.jPanel2.setLayout(jPanel2Layout);
/*  614 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(1).add(this.jScrollPane4, -1, 240, 32767).add(this.jPanel11, -1, -1, 32767).add(jPanel2Layout.createSequentialGroup().add(jPanel2Layout.createParallelGroup(2, false).add(1, jPanel2Layout.createSequentialGroup().addContainerGap().add(this.jButton7, -1, -1, 32767)).add(1, jPanel2Layout.createSequentialGroup().add(10, 10, 10).add(this.jCheckBox5, -1, -1, 32767))).addContainerGap()));
/*      */ 
/*  628 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(1).add(jPanel2Layout.createSequentialGroup().add(this.jScrollPane4, -2, 243, -2).addPreferredGap(0).add(this.jPanel11, -2, -1, -2).addPreferredGap(0).add(this.jCheckBox5).addPreferredGap(0).add(this.jButton7, -2, 41, -2).addContainerGap(139, 32767)));
/*      */ 
/*  641 */     this.jTabbedPane1.addTab(LangSupporter.activeLang.getEntry(147), this.jPanel2);
/*      */ 
/*  643 */     this.jPanel1.setBorder(BorderFactory.createBevelBorder(1));
/*      */ 
/*  645 */     this.jLabel5.setText(LangSupporter.activeLang.getEntry(159));
/*      */ 
/*  647 */     this.jTextField1.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  649 */         SceneEditor.this.jTextField1ActionPerformed(evt);
/*      */       }
/*      */     });
/*  653 */     this.jLabel6.setText(LangSupporter.activeLang.getEntry(160));
/*      */ 
/*  655 */     this.jEditorPane1.addKeyListener(new KeyAdapter() {
/*      */       public void keyTyped(KeyEvent evt) {
/*  657 */         SceneEditor.this.jEditorPane1KeyTyped(evt);
/*      */       }
/*      */     });
/*  660 */     this.jScrollPane2.setViewportView(this.jEditorPane1);
/*      */ 
/*  662 */     this.jLabel7.setText(LangSupporter.activeLang.getEntry(161));
/*      */ 
/*  664 */     this.jTextField2.setText("640");
/*  665 */     this.jTextField2.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  667 */         SceneEditor.this.jTextField2ActionPerformed(evt);
/*      */       }
/*      */     });
/*  670 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */       public void keyTyped(KeyEvent evt) {
/*  672 */         SceneEditor.this.jTextField2KeyTyped(evt);
/*      */       }
/*      */     });
/*  676 */     this.jLabel8.setText(LangSupporter.activeLang.getEntry(162));
/*      */ 
/*  678 */     this.jTextField3.setText("480");
/*  679 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */       public void keyTyped(KeyEvent evt) {
/*  681 */         SceneEditor.this.jTextField3KeyTyped(evt);
/*      */       }
/*      */     });
/*  685 */     this.jLabel9.setText(LangSupporter.activeLang.getEntry(163));
/*      */ 
/*  687 */     this.jCheckBox3.setText(LangSupporter.activeLang.getEntry(164));
/*  688 */     this.jCheckBox3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/*      */ 
/*  690 */     this.jSpinner12.setModel(new SpinnerNumberModel(Integer.valueOf(60), Integer.valueOf(1), null, Integer.valueOf(1)));
/*  691 */     this.jSpinner12.addChangeListener(new ChangeListener() {
/*      */       public void stateChanged(ChangeEvent evt) {
/*  693 */         SceneEditor.this.jSpinner12StateChanged(evt);
/*      */       }
/*      */     });
/*  697 */     this.jLabel19.setText(LangSupporter.activeLang.getEntry(165));
/*      */ 
/*  699 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  700 */     this.jPanel1.setLayout(jPanel1Layout);
/*  701 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().addContainerGap().add(jPanel1Layout.createParallelGroup(1).add(this.jScrollPane5, -1, 220, 32767).add(this.jScrollPane2).add(jPanel1Layout.createSequentialGroup().add(this.jLabel5).addPreferredGap(0).add(this.jTextField1, -1, 150, 32767)).add(this.jLabel6).add(this.jCheckBox3).add(jPanel1Layout.createSequentialGroup().add(this.jLabel7).addPreferredGap(0).add(this.jTextField2, -1, 150, 32767)).add(this.jLabel19).add(jPanel1Layout.createSequentialGroup().add(this.jLabel8).addPreferredGap(0).add(this.jTextField3, -1, 150, 32767)).add(jPanel1Layout.createSequentialGroup().add(this.jLabel9).addPreferredGap(0).add(this.jSpinner12, -1, 150, 32767))).addContainerGap()));
/*      */ 
/*  729 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().addContainerGap().add(jPanel1Layout.createParallelGroup(3).add(this.jLabel5).add(this.jTextField1, -2, -1, -2)).addPreferredGap(0).add(this.jLabel6).addPreferredGap(0).add(this.jScrollPane2, -2, 78, -2).addPreferredGap(0).add(jPanel1Layout.createParallelGroup(3).add(this.jLabel7).add(this.jTextField2, -2, -1, -2)).addPreferredGap(0).add(jPanel1Layout.createParallelGroup(3).add(this.jLabel8).add(this.jTextField3, -2, -1, -2)).addPreferredGap(1).add(jPanel1Layout.createParallelGroup(3).add(this.jLabel9).add(this.jSpinner12, -2, -1, -2)).addPreferredGap(1).add(this.jCheckBox3).addPreferredGap(0).add(this.jLabel19).addPreferredGap(0).add(this.jScrollPane5, -1, 199, 32767).addContainerGap()));
/*      */ 
/*  761 */     this.jTabbedPane1.addTab(LangSupporter.activeLang.getEntry(148), this.jPanel1);
/*      */ 
/*  763 */     this.jPanel5.setBorder(BorderFactory.createBevelBorder(1));
/*      */ 
/*  765 */     this.jCheckBox1.setSelected(true);
/*  766 */     this.jCheckBox1.setText(LangSupporter.activeLang.getEntry(157));
/*  767 */     this.jCheckBox1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/*  768 */     this.jCheckBox1.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  770 */         SceneEditor.this.jCheckBox1ActionPerformed(evt);
/*      */       }
/*      */     });
/*  774 */     this.colorSelection1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  775 */     this.colorSelection1.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  777 */         SceneEditor.this.colorSelection1MouseClicked(evt);
/*      */       }
/*      */       public void mousePressed(MouseEvent evt) {
/*  780 */         SceneEditor.this.colorSelection1MousePressed(evt);
/*      */       }
/*      */     });
/*  784 */     GroupLayout colorSelection1Layout = new GroupLayout(this.colorSelection1);
/*  785 */     this.colorSelection1.setLayout(colorSelection1Layout);
/*  786 */     colorSelection1Layout.setHorizontalGroup(colorSelection1Layout.createParallelGroup(1).add(0, 44, 32767));
/*      */ 
/*  790 */     colorSelection1Layout.setVerticalGroup(colorSelection1Layout.createParallelGroup(1).add(0, 16, 32767));
/*      */ 
/*  795 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  796 */     this.jPanel6.setLayout(jPanel6Layout);
/*  797 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(1).add(0, 220, 32767));
/*      */ 
/*  801 */     jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(1).add(0, 24, 32767));
/*      */ 
/*  806 */     this.jLabel20.setText("Background");
/*      */ 
/*  808 */     this.jLabel21.setText("Horizontal policy");
/*      */ 
/*  810 */     this.jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "Single", "Repeat", "Stretch" }));
/*  811 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  813 */         SceneEditor.this.jComboBox1ActionPerformed(evt);
/*      */       }
/*      */     });
/*  817 */     this.jLabel22.setText("Vertical policy");
/*      */ 
/*  819 */     this.jComboBox2.setModel(new DefaultComboBoxModel(new String[] { "Single", "Repeat", "Stretch" }));
/*  820 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  822 */         SceneEditor.this.jComboBox2ActionPerformed(evt);
/*      */       }
/*      */     });
/*  826 */     this.jScrollPane6.setViewportView(this.jLabel23);
/*      */ 
/*  828 */     this.jList2.setModel(this.bgmodel);
/*  829 */     this.jList2.setSelectionMode(0);
/*  830 */     this.jList2.addListSelectionListener(new ListSelectionListener() {
/*      */       public void valueChanged(ListSelectionEvent evt) {
/*  832 */         SceneEditor.this.jList2ValueChanged(evt);
/*      */       }
/*      */     });
/*  835 */     this.jScrollPane8.setViewportView(this.jList2);
/*      */ 
/*  837 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/*  838 */     this.jPanel5.setLayout(jPanel5Layout);
/*  839 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(1).add(2, jPanel5Layout.createSequentialGroup().addContainerGap().add(jPanel5Layout.createParallelGroup(2).add(1, this.jScrollPane6, -1, 220, 32767).add(1, this.jScrollPane8, -1, 220, 32767).add(1, jPanel5Layout.createSequentialGroup().add(this.jCheckBox1).addPreferredGap(0).add(this.colorSelection1, -2, -1, -2)).add(this.jComboBox2, 0, 220, 32767).add(1, this.jLabel22).add(1, this.jLabel21).add(1, this.jPanel6, -1, -1, 32767).add(this.jComboBox1, 0, 220, 32767).add(1, this.jLabel20)).addContainerGap()));
/*      */ 
/*  858 */     jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(1).add(jPanel5Layout.createSequentialGroup().addContainerGap().add(jPanel5Layout.createParallelGroup(1, false).add(this.jCheckBox1, -1, -1, 32767).add(this.colorSelection1, -1, -1, 32767)).addPreferredGap(0).add(this.jScrollPane8, -2, 100, -2).addPreferredGap(0).add(this.jLabel20).addPreferredGap(0).add(this.jPanel6, -2, -1, -2).add(7, 7, 7).add(this.jLabel21).addPreferredGap(0).add(this.jComboBox1, -2, -1, -2).addPreferredGap(0).add(this.jLabel22).addPreferredGap(0).add(this.jComboBox2, -2, -1, -2).addPreferredGap(0).add(this.jScrollPane6, -1, 185, 32767).addContainerGap()));
/*      */ 
/*  884 */     this.jTabbedPane1.addTab(LangSupporter.activeLang.getEntry(149), this.jPanel5);
/*      */ 
/*  886 */     this.jPanel7.setBorder(BorderFactory.createBevelBorder(1));
/*      */ 
/*  888 */     this.jCheckBox2.setText(LangSupporter.activeLang.getEntry(153));
/*  889 */     this.jCheckBox2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/*      */ 
/*  891 */     this.jList1.setModel(this.model);
/*  892 */     this.jList1.setSelectionMode(0);
/*  893 */     this.jList1.addListSelectionListener(new ListSelectionListener() {
/*      */       public void valueChanged(ListSelectionEvent evt) {
/*  895 */         SceneEditor.this.jList1ValueChanged(evt);
/*      */       }
/*      */     });
/*  898 */     this.jScrollPane3.setViewportView(this.jList1);
/*      */ 
/*  900 */     this.jCheckBox4.setText(LangSupporter.activeLang.getEntry(154));
/*  901 */     this.jCheckBox4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/*  902 */     this.jCheckBox4.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  904 */         SceneEditor.this.jCheckBox4ActionPerformed(evt);
/*      */       }
/*      */     });
/*  908 */     this.jPanel9.setBorder(BorderFactory.createTitledBorder(LangSupporter.activeLang.getEntry(155)));
/*      */ 
/*  910 */     this.jLabel10.setText("X");
/*      */ 
/*  912 */     this.jLabel11.setText("Y");
/*      */ 
/*  914 */     this.jLabel12.setText("W");
/*      */ 
/*  916 */     this.jLabel13.setText("H");
/*      */ 
/*  918 */     this.jSpinner4.setModel(new SpinnerNumberModel());
/*  919 */     this.jSpinner4.addChangeListener(new ChangeListener() {
/*      */       public void stateChanged(ChangeEvent evt) {
/*  921 */         SceneEditor.this.jSpinner4StateChanged(evt);
/*      */       }
/*      */     });
/*  925 */     this.jSpinner5.setModel(new SpinnerNumberModel());
/*  926 */     this.jSpinner5.addChangeListener(new ChangeListener() {
/*      */       public void stateChanged(ChangeEvent evt) {
/*  928 */         SceneEditor.this.jSpinner5StateChanged(evt);
/*      */       }
/*      */     });
/*  932 */     this.jSpinner6.setModel(new SpinnerNumberModel());
/*  933 */     this.jSpinner6.addChangeListener(new ChangeListener() {
/*      */       public void stateChanged(ChangeEvent evt) {
/*  935 */         SceneEditor.this.jSpinner6StateChanged(evt);
/*      */       }
/*      */     });
/*  939 */     this.jSpinner7.setModel(new SpinnerNumberModel());
/*  940 */     this.jSpinner7.addChangeListener(new ChangeListener() {
/*      */       public void stateChanged(ChangeEvent evt) {
/*  942 */         SceneEditor.this.jSpinner7StateChanged(evt);
/*      */       }
/*      */     });
/*  946 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  947 */     this.jPanel9.setLayout(jPanel9Layout);
/*  948 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(1).add(jPanel9Layout.createSequentialGroup().add(jPanel9Layout.createParallelGroup(2, false).add(this.jLabel10, -1, -1, 32767).add(this.jLabel11, -1, -1, 32767)).addPreferredGap(0).add(jPanel9Layout.createParallelGroup(1).add(this.jSpinner4, -2, 47, -2).add(this.jSpinner5, -2, 47, -2)).addPreferredGap(0, 77, 32767).add(jPanel9Layout.createParallelGroup(2).add(jPanel9Layout.createSequentialGroup().add(this.jLabel12).addPreferredGap(0).add(this.jSpinner6, -2, 46, -2)).add(jPanel9Layout.createSequentialGroup().add(this.jLabel13).addPreferredGap(0).add(this.jSpinner7, -2, 47, -2))).addContainerGap()));
/*      */ 
/*  970 */     jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(1).add(jPanel9Layout.createSequentialGroup().add(jPanel9Layout.createParallelGroup(2).add(jPanel9Layout.createSequentialGroup().add(jPanel9Layout.createParallelGroup(3).add(this.jSpinner4, -2, 23, -2).add(this.jSpinner6, -2, 23, -2).add(this.jLabel12)).addPreferredGap(1)).add(jPanel9Layout.createSequentialGroup().add(this.jLabel10, -2, 14, -2).add(17, 17, 17))).add(jPanel9Layout.createParallelGroup(3).add(this.jLabel11).add(this.jSpinner5, -2, 23, -2).add(this.jSpinner7, -2, 23, -2).add(this.jLabel13))));
/*      */ 
/*  990 */     this.jPanel10.setBorder(BorderFactory.createTitledBorder(LangSupporter.activeLang.getEntry(156)));
/*      */ 
/*  992 */     this.jLabel14.setText("X");
/*      */ 
/*  994 */     this.jLabel15.setText("Y");
/*      */ 
/*  996 */     this.jLabel16.setText("W");
/*      */ 
/*  998 */     this.jLabel17.setText("H");
/*      */ 
/* 1000 */     this.jSpinner8.setModel(new SpinnerNumberModel());
/* 1001 */     this.jSpinner8.addChangeListener(new ChangeListener() {
/*      */       public void stateChanged(ChangeEvent evt) {
/* 1003 */         SceneEditor.this.jSpinner8StateChanged(evt);
/*      */       }
/*      */     });
/* 1007 */     this.jSpinner9.setModel(new SpinnerNumberModel());
/* 1008 */     this.jSpinner9.addChangeListener(new ChangeListener() {
/*      */       public void stateChanged(ChangeEvent evt) {
/* 1010 */         SceneEditor.this.jSpinner9StateChanged(evt);
/*      */       }
/*      */     });
/* 1014 */     this.jSpinner10.setModel(new SpinnerNumberModel());
/* 1015 */     this.jSpinner10.addChangeListener(new ChangeListener() {
/*      */       public void stateChanged(ChangeEvent evt) {
/* 1017 */         SceneEditor.this.jSpinner10StateChanged(evt);
/*      */       }
/*      */     });
/* 1021 */     this.jSpinner11.setModel(new SpinnerNumberModel());
/* 1022 */     this.jSpinner11.addChangeListener(new ChangeListener() {
/*      */       public void stateChanged(ChangeEvent evt) {
/* 1024 */         SceneEditor.this.jSpinner11StateChanged(evt);
/*      */       }
/*      */     });
/* 1028 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1029 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1030 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(1).add(jPanel10Layout.createSequentialGroup().add(jPanel10Layout.createParallelGroup(2, false).add(this.jLabel14, -1, -1, 32767).add(this.jLabel15, -1, -1, 32767)).addPreferredGap(0).add(jPanel10Layout.createParallelGroup(1).add(this.jSpinner8, -2, 47, -2).add(this.jSpinner9, -2, 47, -2)).addPreferredGap(0, 77, 32767).add(jPanel10Layout.createParallelGroup(2).add(this.jLabel16).add(this.jLabel17)).addPreferredGap(0).add(jPanel10Layout.createParallelGroup(1).add(this.jSpinner10, -2, 47, -2).add(this.jSpinner11, -2, 47, -2)).addContainerGap()));
/*      */ 
/* 1050 */     jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(1).add(jPanel10Layout.createSequentialGroup().add(jPanel10Layout.createParallelGroup(2).add(jPanel10Layout.createSequentialGroup().add(jPanel10Layout.createParallelGroup(3).add(this.jSpinner8, -2, 23, -2).add(this.jSpinner10, -2, 23, -2).add(this.jLabel16)).addPreferredGap(1)).add(jPanel10Layout.createSequentialGroup().add(this.jLabel14, -2, 14, -2).add(17, 17, 17))).add(jPanel10Layout.createParallelGroup(3).add(this.jLabel15).add(this.jSpinner9, -2, 23, -2).add(this.jSpinner11, -2, 23, -2).add(this.jLabel17))));
/*      */ 
/* 1070 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 1071 */     this.jPanel7.setLayout(jPanel7Layout);
/* 1072 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(1).add(jPanel7Layout.createSequentialGroup().add(jPanel7Layout.createParallelGroup(1).add(jPanel7Layout.createSequentialGroup().addContainerGap().add(jPanel7Layout.createParallelGroup(1).add(this.jPanel9, -1, -1, 32767).add(this.jCheckBox4).add(this.jScrollPane3, -1, 220, 32767).add(this.jCheckBox2))).add(2, jPanel7Layout.createSequentialGroup().add(9, 9, 9).add(this.jPanel10, -1, -1, 32767))).addContainerGap()));
/*      */ 
/* 1088 */     jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(1).add(jPanel7Layout.createSequentialGroup().addContainerGap().add(this.jCheckBox2).addPreferredGap(0).add(this.jScrollPane3, -2, 76, -2).addPreferredGap(0).add(this.jCheckBox4).addPreferredGap(0).add(this.jPanel9, -2, -1, -2).addPreferredGap(0).add(this.jPanel10, -2, -1, -2).addContainerGap(165, 32767)));
/*      */ 
/* 1104 */     this.jTabbedPane1.addTab(LangSupporter.activeLang.getEntry(150), this.jPanel7);
/*      */ 
/* 1106 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/* 1107 */     this.jPanel13.setLayout(jPanel13Layout);
/* 1108 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout.createParallelGroup(1).add(0, 218, 32767));
/*      */ 
/* 1112 */     jPanel13Layout.setVerticalGroup(jPanel13Layout.createParallelGroup(1).add(0, 28, 32767));
/*      */ 
/* 1117 */     this.jLabel4.setText("X:");
/*      */ 
/* 1119 */     this.jSpinner13.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
/* 1120 */     this.jSpinner13.addChangeListener(new ChangeListener() {
/*      */       public void stateChanged(ChangeEvent evt) {
/* 1122 */         SceneEditor.this.jSpinner13StateChanged(evt);
/*      */       }
/*      */     });
/* 1126 */     this.jLabel26.setText("Y:");
/*      */ 
/* 1128 */     this.jSpinner14.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
/* 1129 */     this.jSpinner14.addChangeListener(new ChangeListener() {
/*      */       public void stateChanged(ChangeEvent evt) {
/* 1131 */         SceneEditor.this.jSpinner14StateChanged(evt);
/*      */       }
/*      */     });
/* 1135 */     this.jLabel27.setText("Width:");
/*      */ 
/* 1137 */     this.jSpinner15.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
/* 1138 */     this.jSpinner15.addChangeListener(new ChangeListener() {
/*      */       public void stateChanged(ChangeEvent evt) {
/* 1140 */         SceneEditor.this.jSpinner15StateChanged(evt);
/*      */       }
/*      */     });
/* 1144 */     this.jLabel28.setText("Height:");
/*      */ 
/* 1146 */     this.jSpinner16.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
/* 1147 */     this.jSpinner16.addChangeListener(new ChangeListener() {
/*      */       public void stateChanged(ChangeEvent evt) {
/* 1149 */         SceneEditor.this.jSpinner16StateChanged(evt);
/*      */       }
/*      */     });
/* 1153 */     this.jLabel29.setText("Depth:");
/*      */ 
/* 1155 */     this.jSpinner17.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
/*      */ 
/* 1157 */     GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
/* 1158 */     this.jPanel15.setLayout(jPanel15Layout);
/* 1159 */     jPanel15Layout.setHorizontalGroup(jPanel15Layout.createParallelGroup(1).add(jPanel15Layout.createSequentialGroup().addContainerGap().add(jPanel15Layout.createParallelGroup(1).add(this.jPanel13, -1, -1, 32767).add(jPanel15Layout.createSequentialGroup().add(this.jLabel4).addPreferredGap(0).add(this.jSpinner13, -2, -1, -2).addPreferredGap(0).add(this.jLabel26).addPreferredGap(0).add(this.jSpinner14, -2, -1, -2)).add(jPanel15Layout.createSequentialGroup().add(this.jLabel27).addPreferredGap(0).add(this.jSpinner15, -2, -1, -2).addPreferredGap(0).add(this.jLabel28).addPreferredGap(0).add(this.jSpinner16, -2, -1, -2)).add(jPanel15Layout.createSequentialGroup().add(this.jLabel29).addPreferredGap(0).add(this.jSpinner17, -2, -1, -2))).addContainerGap()));
/*      */ 
/* 1187 */     jPanel15Layout.setVerticalGroup(jPanel15Layout.createParallelGroup(1).add(jPanel15Layout.createSequentialGroup().addContainerGap().add(this.jPanel13, -2, -1, -2).addPreferredGap(0).add(jPanel15Layout.createParallelGroup(3).add(this.jLabel4).add(this.jSpinner13, -2, -1, -2).add(this.jLabel26).add(this.jSpinner14, -2, -1, -2)).addPreferredGap(0).add(jPanel15Layout.createParallelGroup(3).add(this.jLabel27).add(this.jSpinner15, -2, -1, -2).add(this.jLabel28).add(this.jSpinner16, -2, -1, -2)).addPreferredGap(0).add(jPanel15Layout.createParallelGroup(3).add(this.jLabel29).add(this.jSpinner17, -2, -1, -2)).addContainerGap(52, 32767)));
/*      */ 
/* 1211 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 1212 */     this.jPanel12.setLayout(jPanel12Layout);
/* 1213 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout.createParallelGroup(1).add(jPanel12Layout.createSequentialGroup().add(jPanel12Layout.createParallelGroup(2).add(1, this.jScrollPane7, 0, 0, 32767).add(1, this.jPanel15, -2, -1, -2)).addContainerGap(-1, 32767)));
/*      */ 
/* 1221 */     jPanel12Layout.setVerticalGroup(jPanel12Layout.createParallelGroup(1).add(jPanel12Layout.createSequentialGroup().add(this.jScrollPane7, -2, 309, -2).addPreferredGap(0).add(this.jPanel15, -1, -1, 32767)));
/*      */ 
/* 1229 */     this.jTabbedPane1.addTab("Tiles", this.jPanel12);
/*      */ 
/* 1231 */     this.jSplitPane1.setLeftComponent(this.jTabbedPane1);
/*      */ 
/* 1233 */     this.jPanel4.setBorder(BorderFactory.createEtchedBorder());
/*      */ 
/* 1235 */     this.BottomLeft.setText("Bottom-left content");
/*      */ 
/* 1237 */     this.BottomRight.setText("Bottom-right content");
/*      */ 
/* 1239 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 1240 */     this.jPanel4.setLayout(jPanel4Layout);
/* 1241 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(1).add(2, jPanel4Layout.createSequentialGroup().add(this.BottomLeft).addPreferredGap(0, 333, 32767).add(this.BottomRight)));
/*      */ 
/* 1248 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(1).add(jPanel4Layout.createParallelGroup(3).add(this.BottomRight).add(this.BottomLeft)));
/*      */ 
/* 1255 */     this.jToolBar1.setFloatable(false);
/* 1256 */     this.jToolBar1.setRollover(true);
/*      */ 
/* 1258 */     this.jLabel24.setText("<HTML><b>Objects");
/* 1259 */     this.jToolBar1.add(this.jLabel24);
/*      */ 
/* 1261 */     this.jButton2.setText(LangSupporter.activeLang.getEntry(151));
/* 1262 */     this.jButton2.setFocusable(false);
/* 1263 */     this.jButton2.setHorizontalTextPosition(0);
/* 1264 */     this.jButton2.setSelected(true);
/* 1265 */     this.jButton2.setVerticalTextPosition(3);
/* 1266 */     this.jButton2.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1268 */         SceneEditor.this.jButton2ActionPerformed(evt);
/*      */       }
/*      */     });
/* 1271 */     this.jToolBar1.add(this.jButton2);
/*      */ 
/* 1273 */     this.jButton1.setText("Edit");
/* 1274 */     this.jButton1.setFocusable(false);
/* 1275 */     this.jButton1.setHorizontalTextPosition(0);
/* 1276 */     this.jButton1.setVerticalTextPosition(3);
/* 1277 */     this.jButton1.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1279 */         SceneEditor.this.jButton1ActionPerformed(evt);
/*      */       }
/*      */     });
/* 1282 */     this.jToolBar1.add(this.jButton1);
/*      */ 
/* 1284 */     this.jButton3.setText(LangSupporter.activeLang.getEntry(152));
/* 1285 */     this.jButton3.setFocusable(false);
/* 1286 */     this.jButton3.setHorizontalTextPosition(0);
/* 1287 */     this.jButton3.setVerticalTextPosition(3);
/* 1288 */     this.jButton3.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1290 */         SceneEditor.this.jButton3ActionPerformed(evt);
/*      */       }
/*      */     });
/* 1293 */     this.jToolBar1.add(this.jButton3);
/*      */ 
/* 1295 */     this.jPanel14.setMaximumSize(new Dimension(100, 100));
/* 1296 */     this.jPanel14.setMinimumSize(new Dimension(20, 20));
/*      */ 
/* 1298 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 1299 */     this.jPanel14.setLayout(jPanel14Layout);
/* 1300 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout.createParallelGroup(1).add(0, 20, 32767));
/*      */ 
/* 1304 */     jPanel14Layout.setVerticalGroup(jPanel14Layout.createParallelGroup(1).add(0, 23, 32767));
/*      */ 
/* 1309 */     this.jToolBar1.add(this.jPanel14);
/*      */ 
/* 1311 */     this.jLabel25.setText("<HTML><b>Tiles");
/* 1312 */     this.jToolBar1.add(this.jLabel25);
/*      */ 
/* 1314 */     this.jButton8.setText("Add");
/* 1315 */     this.jButton8.setFocusable(false);
/* 1316 */     this.jButton8.setHorizontalTextPosition(0);
/* 1317 */     this.jButton8.setVerticalTextPosition(3);
/* 1318 */     this.jButton8.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1320 */         SceneEditor.this.jButton8ActionPerformed(evt);
/*      */       }
/*      */     });
/* 1323 */     this.jToolBar1.add(this.jButton8);
/*      */ 
/* 1325 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 1326 */     this.jPanel3.setLayout(jPanel3Layout);
/* 1327 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(1).add(this.jPanel4, -1, -1, 32767).add(this.jToolBar1, -1, 531, 32767).add(this.jScrollPane1, -1, 531, 32767));
/*      */ 
/* 1333 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(1).add(2, jPanel3Layout.createSequentialGroup().add(this.jToolBar1, -2, 25, -2).addPreferredGap(0).add(this.jScrollPane1, -1, 473, 32767).addPreferredGap(0).add(this.jPanel4, -2, -1, -2)));
/*      */ 
/* 1343 */     this.jSplitPane1.setRightComponent(this.jPanel3);
/*      */ 
/* 1345 */     GroupLayout layout = new GroupLayout(this);
/* 1346 */     setLayout(layout);
/* 1347 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(this.jPanel8, -1, 787, 32767).add(this.jSplitPane1, -1, 787, 32767));
/*      */ 
/* 1352 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(this.jPanel8, -2, -1, -2).addPreferredGap(0).add(this.jSplitPane1, -1, 530, 32767)));
/*      */   }
/*      */ 
/*      */   private void jSplitPane1ComponentResized(ComponentEvent evt)
/*      */   {
/* 1362 */     updateScroll();
/*      */   }
/*      */ 
/*      */   private void jToggleButton1ActionPerformed(ActionEvent evt) {
/* 1366 */     updateScroll();
/* 1367 */     ((Scene)this.file.value).grid = this.jToggleButton1.isSelected();
/*      */   }
/*      */ 
/*      */   private void jSpinner1StateChanged(ChangeEvent evt) {
/* 1371 */     updateScroll();
/*      */   }
/*      */ 
/*      */   private void jCheckBox1ActionPerformed(ActionEvent evt) {
/* 1375 */     ((Scene)this.file.value).drawbackcolor = this.jCheckBox1.isSelected();
/* 1376 */     updateScroll();
/*      */   }
/*      */ 
/*      */   private void jCheckBox4ActionPerformed(ActionEvent evt) {
/* 1380 */     ((ViewInScene)this.jList1.getSelectedValue()).visibleonstart = this.jCheckBox4.isSelected();
/* 1381 */     this.jList1.updateUI();
/*      */   }
/*      */ 
/*      */   private void jList1ValueChanged(ListSelectionEvent evt) {
/* 1385 */     setup();
/*      */   }
/*      */ 
/*      */   private void jTextField1ActionPerformed(ActionEvent evt)
/*      */   {
/* 1391 */     this.file.name = this.jTextField1.getText();
/* 1392 */     ((Scene)this.file.value).name = this.file.name;
/* 1393 */     Aurwindow.workspace.updateUI();
/*      */   }
/*      */ 
/*      */   private void jTextField2ActionPerformed(ActionEvent evt) {
/* 1397 */     this.changed = true;
/* 1398 */     this.jScrollPane1.updateUI();
/* 1399 */     this.scene.updateUI();
/*      */   }
/*      */ 
/*      */   private void jEditorPane1KeyTyped(KeyEvent evt) {
/* 1403 */     this.changed = true;
/*      */   }
/*      */ 
/*      */   private void jCheckBox5ActionPerformed(ActionEvent evt)
/*      */   {
/*      */   }
/*      */ 
/*      */   private void jTextField2KeyTyped(KeyEvent evt) {
/* 1411 */     this.changed = true;
/* 1412 */     this.jScrollPane1.updateUI();
/* 1413 */     this.scene.updateUI();
/*      */   }
/*      */ 
/*      */   private void jTextField3KeyTyped(KeyEvent evt) {
/* 1417 */     this.changed = true;
/* 1418 */     this.jScrollPane1.updateUI();
/* 1419 */     this.scene.updateUI();
/*      */   }
/*      */ 
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 1423 */     this.jButton2.setSelected(true);
/* 1424 */     this.jButton3.setSelected(false);
/* 1425 */     this.jButton8.setSelected(false);
/* 1426 */     this.jButton1.setSelected(false);
/*      */   }
/*      */ 
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 1430 */     this.jButton2.setSelected(false);
/* 1431 */     this.jButton3.setSelected(true);
/* 1432 */     this.jButton8.setSelected(false);
/* 1433 */     this.jButton1.setSelected(false);
/*      */   }
/*      */ 
/*      */   private void colorSelection1MousePressed(MouseEvent evt) {
/* 1437 */     this.changed = true;
/* 1438 */     ((Scene)this.file.value).background = this.colorSelection1.getBackground();
/* 1439 */     updateScroll();
/*      */   }
/*      */ 
/*      */   private void colorSelection1MouseClicked(MouseEvent evt) {
/* 1443 */     this.changed = true;
/* 1444 */     ((Scene)this.file.value).background = this.colorSelection1.getBackground();
/* 1445 */     updateScroll();
/*      */   }
/*      */ 
/*      */   private void jSpinner12StateChanged(ChangeEvent evt) {
/* 1449 */     ((Scene)this.file.value).speed = ((Integer)this.jSpinner12.getValue()).intValue();
/*      */   }
/*      */ 
/*      */   private void jSpinner4StateChanged(ChangeEvent evt) {
/* 1453 */     ViewInScene v = (ViewInScene)this.jList1.getSelectedValue();
/* 1454 */     v.viewx = ((Integer)this.jSpinner4.getValue()).intValue();
/*      */   }
/*      */ 
/*      */   private void jSpinner5StateChanged(ChangeEvent evt) {
/* 1458 */     ViewInScene v = (ViewInScene)this.jList1.getSelectedValue();
/* 1459 */     v.viewy = ((Integer)this.jSpinner5.getValue()).intValue();
/*      */   }
/*      */ 
/*      */   private void jSpinner6StateChanged(ChangeEvent evt) {
/* 1463 */     ViewInScene v = (ViewInScene)this.jList1.getSelectedValue();
/* 1464 */     v.vieww = ((Integer)this.jSpinner6.getValue()).intValue();
/*      */   }
/*      */ 
/*      */   private void jSpinner7StateChanged(ChangeEvent evt) {
/* 1468 */     ViewInScene v = (ViewInScene)this.jList1.getSelectedValue();
/* 1469 */     v.viewh = ((Integer)this.jSpinner7.getValue()).intValue();
/*      */   }
/*      */ 
/*      */   private void jSpinner8StateChanged(ChangeEvent evt) {
/* 1473 */     ViewInScene v = (ViewInScene)this.jList1.getSelectedValue();
/* 1474 */     v.portx = ((Integer)this.jSpinner8.getValue()).intValue();
/*      */   }
/*      */ 
/*      */   private void jSpinner9StateChanged(ChangeEvent evt) {
/* 1478 */     ViewInScene v = (ViewInScene)this.jList1.getSelectedValue();
/* 1479 */     v.porty = ((Integer)this.jSpinner9.getValue()).intValue();
/*      */   }
/*      */ 
/*      */   private void jSpinner10StateChanged(ChangeEvent evt) {
/* 1483 */     ViewInScene v = (ViewInScene)this.jList1.getSelectedValue();
/* 1484 */     v.portw = ((Integer)this.jSpinner10.getValue()).intValue();
/*      */   }
/*      */ 
/*      */   private void jSpinner11StateChanged(ChangeEvent evt) {
/* 1488 */     ViewInScene v = (ViewInScene)this.jList1.getSelectedValue();
/* 1489 */     v.porth = ((Integer)this.jSpinner11.getValue()).intValue();
/*      */   }
/*      */ 
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 1493 */     Scene s = (Scene)this.file.value;
/* 1494 */     BackgroundInScene bg = (BackgroundInScene)s.backgrounds.get(this.jList2.getSelectedIndex());
/* 1495 */     bg.hmode = this.jComboBox1.getSelectedIndex();
/* 1496 */     this.scene.updateUI();
/*      */   }
/*      */ 
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 1500 */     Scene s = (Scene)this.file.value;
/* 1501 */     BackgroundInScene bg = (BackgroundInScene)s.backgrounds.get(this.jList2.getSelectedIndex());
/* 1502 */     bg.vmode = this.jComboBox2.getSelectedIndex();
/* 1503 */     this.scene.updateUI();
/*      */   }
/*      */ 
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 1507 */     this.jButton1.setSelected(true);
/* 1508 */     this.jButton2.setSelected(false);
/* 1509 */     this.jButton3.setSelected(false);
/* 1510 */     this.jButton8.setSelected(false);
/*      */   }
/*      */ 
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 1514 */     this.jButton1.setSelected(false);
/* 1515 */     this.jButton2.setSelected(false);
/* 1516 */     this.jButton3.setSelected(false);
/* 1517 */     this.jButton8.setSelected(true);
/*      */   }
/*      */ 
/*      */   private void jList2ValueChanged(ListSelectionEvent evt) {
/* 1521 */     if (this.jList2.isSelectionEmpty()) {
/* 1522 */       this.curbg.setEnabled(false);
/* 1523 */       this.jComboBox1.setEnabled(false);
/* 1524 */       this.jComboBox2.setEnabled(false);
/*      */     }
/*      */     else {
/* 1527 */       this.curbg.setEnabled(true);
/* 1528 */       this.jComboBox1.setEnabled(true);
/* 1529 */       this.jComboBox2.setEnabled(true);
/*      */     }
/* 1531 */     if (this.jList2.getSelectedIndex() < 0)
/* 1532 */       return;
/* 1533 */     Scene s = (Scene)this.file.value;
/* 1534 */     BackgroundInScene bg = (BackgroundInScene)s.backgrounds.get(this.jList2.getSelectedIndex());
/* 1535 */     this.jComboBox1.setSelectedIndex(bg.hmode);
/* 1536 */     this.jComboBox2.setSelectedIndex(bg.vmode);
/* 1537 */     this.curbg.setFile(bg.image);
/* 1538 */     updateBgImage();
/*      */   }
/*      */ 
/*      */   private void jSpinner13StateChanged(ChangeEvent evt) {
/* 1542 */     this.tilechooser.updateUI();
/* 1543 */     this.jScrollPane7.updateUI();
/*      */   }
/*      */ 
/*      */   private void jSpinner14StateChanged(ChangeEvent evt) {
/* 1547 */     this.tilechooser.updateUI();
/* 1548 */     this.jScrollPane7.updateUI();
/*      */   }
/*      */ 
/*      */   private void jSpinner15StateChanged(ChangeEvent evt) {
/* 1552 */     this.tilechooser.updateUI();
/* 1553 */     this.jScrollPane7.updateUI();
/*      */   }
/*      */ 
/*      */   private void jSpinner16StateChanged(ChangeEvent evt) {
/* 1557 */     this.tilechooser.updateUI();
/* 1558 */     this.jScrollPane7.updateUI();
/*      */   }
/*      */ 
/*      */   public Tile makeNewTile(int x, int y)
/*      */   {
/* 1567 */     Tile tile = new Tile();
/* 1568 */     tile.dx = x;
/* 1569 */     tile.dy = y;
/* 1570 */     tile.sx = ((Integer)this.jSpinner13.getValue()).intValue();
/* 1571 */     tile.sy = ((Integer)this.jSpinner14.getValue()).intValue();
/* 1572 */     tile.width = ((Integer)this.jSpinner15.getValue()).intValue();
/* 1573 */     tile.height = ((Integer)this.jSpinner16.getValue()).intValue();
/* 1574 */     tile.tileset = ((GFile)this.curtileset.getCurrentObject().object);
/* 1575 */     tile.depth = ((Integer)this.jSpinner17.getValue()).intValue();
/* 1576 */     return tile;
/*      */   }
/*      */ 
/*      */   public int mode() {
/* 1580 */     if (this.jButton2.isSelected())
/* 1581 */       return 1;
/* 1582 */     if (this.jButton3.isSelected())
/* 1583 */       return 2;
/* 1584 */     if (this.jButton8.isSelected())
/* 1585 */       return 3;
/* 1586 */     return 0;
/*      */   }
/*      */ 
/*      */   public Color getMapBGColor() {
/* 1590 */     if (this.jCheckBox1.isSelected())
/* 1591 */       return this.colorSelection1.getBackground();
/* 1592 */     return Color.BLACK;
/*      */   }
/*      */ 
/*      */   public void updateScroll() {
/* 1596 */     if (((Integer)this.jSpinner1.getValue()).intValue() > 5)
/* 1597 */       this.jSpinner1.setValue(Integer.valueOf(5));
/* 1598 */     else if (((Integer)this.jSpinner1.getValue()).intValue() < -5)
/* 1599 */       this.jSpinner1.setValue(Integer.valueOf(-5));
/* 1600 */     ((Scene)this.file.value).snapX = ((Integer)this.jSpinner2.getValue()).intValue();
/* 1601 */     ((Scene)this.file.value).snapY = ((Integer)this.jSpinner3.getValue()).intValue();
/* 1602 */     this.scene.updateUI();
/* 1603 */     this.jScrollPane1.updateUI();
/*      */   }
/*      */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.editors.SceneEditor
 * JD-Core Version:    0.6.2
 */