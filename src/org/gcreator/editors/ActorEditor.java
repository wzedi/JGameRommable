/*     */ package org.gcreator.editors;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.awt.event.MouseMotionAdapter;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Vector;
/*     */ import javax.swing.AbstractListModel;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JEditorPane;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JSpinner;
/*     */ import javax.swing.JSplitPane;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.JViewport;
/*     */ import javax.swing.SpinnerNumberModel;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ import javax.swing.event.DocumentEvent;
/*     */ import javax.swing.event.DocumentListener;
/*     */ import javax.swing.event.ListSelectionEvent;
/*     */ import javax.swing.event.ListSelectionListener;
/*     */ import javax.swing.text.Document;
/*     */ import org.gcreator.actions.Action;
/*     */ import org.gcreator.actions.ActionCategory;
/*     */ import org.gcreator.actions.ActionContainer;
/*     */ import org.gcreator.actions.ActionPattern;
/*     */ import org.gcreator.components.TabPanel;
/*     */ import org.gcreator.components.WorkspaceTree;
/*     */ import org.gcreator.components.impl.ActionListCellRenderer;
/*     */ import org.gcreator.components.impl.ActionsCellRenderer;
/*     */ import org.gcreator.components.impl.EventCellRenderer;
/*     */ import org.gcreator.components.impl.EventSelectListener;
/*     */ import org.gcreator.components.popupmenus.ActionPopupMenu;
/*     */ import org.gcreator.components.popupmenus.EventListModel;
/*     */ import org.gcreator.components.popupmenus.EventPopupMenu;
/*     */ import org.gcreator.components.popupmenus.EventSelect;
/*     */ import org.gcreator.components.popupmenus.PopupListener;
/*     */ import org.gcreator.components.resource.ResourceChooser;
/*     */ import org.gcreator.core.Aurwindow;
/*     */ import org.gcreator.core.gcreator;
/*     */ import org.gcreator.events.AlarmEvent;
/*     */ import org.gcreator.events.BeginStepEvent;
/*     */ import org.gcreator.events.CreateEvent;
/*     */ import org.gcreator.events.DestroyEvent;
/*     */ import org.gcreator.events.DrawEvent;
/*     */ import org.gcreator.events.EndStepEvent;
/*     */ import org.gcreator.events.Event;
/*     */ import org.gcreator.events.KeyPress;
/*     */ import org.gcreator.events.KeyReleased;
/*     */ import org.gcreator.events.KeyboardEvent;
/*     */ import org.gcreator.events.StepEvent;
/*     */ import org.gcreator.exceptions.WrongResourceException;
/*     */ import org.gcreator.fileclass.GFile;
/*     */ import org.gcreator.fileclass.Project;
/*     */ import org.gcreator.fileclass.res.Actor;
/*     */ import org.gcreator.managers.LangSupporter;
/*     */ import org.gcreator.units.Dictionary;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class ActorEditor extends TabPanel
/*     */ {
/*  28 */   public boolean changed = false;
/*     */   public EventListModel elist;
/*     */   Actor actor;
/*     */   int from;
/*  36 */   DefaultComboBoxModel actmodel = new DefaultComboBoxModel();
/*     */   ResourceChooser spriteres;
/*     */   ResourceChooser extendres;
/*     */   ResourceChooser maskres;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JButton jButton5;
/*     */   private JCheckBox jCheckBox1;
/*     */   private JCheckBox jCheckBox2;
/*     */   private JCheckBox jCheckBox3;
/*     */   private JComboBox jComboBox2;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   public JList jList1;
/*     */   public JList jList2;
/*     */   private JList jList3;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel11;
/*     */   private JPanel jPanel12;
/*     */   private JPanel jPanel13;
/*     */   private JPanel jPanel2;
/*     */   private JPanel jPanel3;
/*     */   private JPanel jPanel4;
/*     */   private JPanel jPanel5;
/*     */   private JPanel jPanel6;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JScrollPane jScrollPane2;
/*     */   public JScrollPane jScrollPane3;
/*     */   private JScrollPane jScrollPane4;
/*     */   private JSpinner jSpinner1;
/*     */   private JSplitPane jSplitPane1;
/*     */   private JSplitPane jSplitPane2;
/*     */   private JSplitPane jSplitPane3;
/*     */   private JTextField jTextField1;
/*     */ 
/*     */   public void updateNavigator()
/*     */   {
/*  41 */     System.out.println("Update navigator");
/*  42 */     Component c = gcreator.window.getNavigatorPanel();
/*  43 */     if ((c instanceof JPanel)) {
/*  44 */       System.out.println("Update c JPanel");
/*  45 */       ((JPanel)c).updateUI();
/*     */     }
/*  47 */     else if ((c instanceof JScrollPane)) {
/*  48 */       ((JScrollPane)c).updateUI();
/*  49 */       Component d = ((JScrollPane)c).getViewport().getView();
/*  50 */       if ((d instanceof JPanel)) {
/*  51 */         System.out.println("Update d JPanel");
/*  52 */         ((JPanel)d).updateUI();
/*     */       }
/*  54 */       else if ((d instanceof JEditorPane)) {
/*  55 */         System.out.println("Update d editor pane");
/*  56 */         ((JEditorPane)d).updateUI();
/*     */       }
/*     */       else {
/*  59 */         d.repaint();
/*     */       }
/*     */     }
/*  62 */     else if (c != null) {
/*  63 */       c.repaint();
/*     */     }
/*     */   }
/*     */ 
/*  67 */   public void spriteChanged() { ((Actor)this.file.value).sprite = this.spriteres.getFile();
/*  68 */     updateNavigator();
/*     */   }
/*     */ 
/*     */   protected ActorEditor getThis()
/*     */   {
/*  73 */     return this;
/*     */   }
/*     */ 
/*     */   public ActorEditor(GFile file, Project project) throws WrongResourceException
/*     */   {
/*  78 */     this.project = project;
/*  79 */     if (file.value == null) {
/*  80 */       this.actor = new Actor(file.name);
/*  81 */       this.actor.readXml(file.xml);
/*  82 */       file.value = this.actor;
/*  83 */       this.actor.events = new Vector();
/*  84 */     } else if ((file.value instanceof Actor)) {
/*  85 */       this.actor = ((Actor)file.value);
/*     */     } else {
/*  87 */       throw new WrongResourceException();
/*     */     }
/*  89 */     this.file = file;
/*  90 */     this.elist = new EventListModel(file);
/*  91 */     initComponents();
/*     */ 
/*  93 */     this.jList2.addMouseListener(new MouseListener() {
/*     */       public void mousePressed(java.awt.event.MouseEvent evt) {
/*     */       }
/*  96 */       public void mouseReleased(java.awt.event.MouseEvent evt) { if (evt.isPopupTrigger()) {
/*  97 */           ActionPopupMenu p = new ActionPopupMenu(ActorEditor.this.getThis());
/*  98 */           p.show(ActorEditor.this.jList2, evt.getX(), evt.getY());
/*     */         }
/*     */       }
/*     */ 
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void mouseExited(java.awt.event.MouseEvent evt)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void mouseEntered(java.awt.event.MouseEvent evt)
/*     */       {
/*     */       }
/*     */     });
/* 105 */     this.jList1.addMouseListener(new PopupListener(this.jList1, new EventPopupMenu(this)));
/*     */ 
/* 108 */     this.jComboBox2.setModel(new DefaultComboBoxModel(ActionContainer.actionCats));
/* 109 */     this.jComboBox2.setRenderer(new ActionListCellRenderer());
/*     */     try {
/* 111 */       this.jTextField1.setText(file.name);
/*     */     } catch (NullPointerException e) {
/*     */     }
/* 114 */     this.jTextField1.getDocument().addDocumentListener(new DocumentListener() {
/*     */       public void changedUpdate(DocumentEvent evt) {
/* 116 */         ActorEditor.this.updateName();
/*     */       }
/*     */       public void insertUpdate(DocumentEvent evt) {
/* 119 */         ActorEditor.this.updateName();
/*     */       }
/*     */       public void removeUpdate(DocumentEvent evt) {
/* 122 */         ActorEditor.this.updateName();
/*     */       }
/*     */     });
/* 126 */     this.jList1.setCellRenderer(new EventCellRenderer());
/* 127 */     this.jList3.setModel(new DefaultComboBoxModel(((ActionCategory)ActionContainer.actionCats.get(0)).patterns));
/* 128 */     this.jList3.setCellRenderer(new ActionListCellRenderer());
/* 129 */     this.jList2.setCellRenderer(new ActionsCellRenderer());
/* 130 */     this.jList2.setModel(this.actmodel);
/*     */ 
/* 133 */     this.jPanel13.setLayout(new FlowLayout());
/* 134 */     this.jPanel13.add(this.spriteres = new ResourceChooser(project, "sprite"));
/* 135 */     if (this.actor.sprite != null) {
/* 136 */       this.spriteres.setFile(this.actor.sprite);
/*     */     }
/* 138 */     this.spriteres.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 141 */         ActorEditor.this.spriteChanged();
/*     */       }
/*     */     });
/* 144 */     this.jPanel11.setLayout(new FlowLayout());
/* 145 */     this.jPanel11.add(this.extendres = new ResourceChooser(project, "actor"));
/* 146 */     this.jPanel12.setLayout(new FlowLayout());
/* 147 */     this.jPanel12.add(this.maskres = new ResourceChooser(project, "sprite"));
/*     */ 
/* 150 */     Load();
/*     */ 
/* 152 */     this.jList1.addMouseListener(new PopupListener(this.jList1, new EventPopupMenu(this)));
/* 153 */     this.jList2.addMouseListener(new PopupListener(this.jList2, new ActionPopupMenu(this)));
/* 154 */     this.jSpinner1.setValue(Integer.valueOf(this.actor.depth));
/*     */   }
/*     */ 
/*     */   public boolean wasModified() {
/* 158 */     return this.changed;
/*     */   }
/*     */ 
/*     */   public boolean Load() {
/* 162 */     this.jCheckBox1.setSelected(this.actor.visible);
/* 163 */     this.jCheckBox2.setSelected(this.actor.solid);
/* 164 */     this.jCheckBox3.setSelected(this.actor.persistant);
/* 165 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean Save() {
/* 169 */     this.jList2.updateUI();
/* 170 */     this.actor.visible = this.jCheckBox1.isSelected();
/* 171 */     this.actor.solid = this.jCheckBox2.isSelected();
/* 172 */     this.actor.persistant = this.jCheckBox3.isSelected();
/* 173 */     this.file.value = this.actor;
/*     */ 
/* 175 */     return true;
/*     */   }
/*     */ 
/*     */   public void updateName() {
/* 179 */     this.file.name = this.jTextField1.getText();
/* 180 */     this.actor.name = this.file.name;
/* 181 */     Aurwindow.workspace.updateUI();
/*     */   }
/*     */ 
/*     */   public static void setupActions()
/*     */   {
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 248 */     this.jSplitPane1 = new JSplitPane();
/* 249 */     this.jPanel1 = new JPanel();
/* 250 */     this.jSplitPane2 = new JSplitPane();
/* 251 */     this.jPanel4 = new JPanel();
/* 252 */     this.jSplitPane3 = new JSplitPane();
/* 253 */     this.jScrollPane2 = new JScrollPane();
/* 254 */     this.jList2 = new JList();
/* 255 */     this.jPanel6 = new JPanel();
/* 256 */     this.jScrollPane1 = new JScrollPane();
/* 257 */     this.jList1 = new JList();
/* 258 */     this.jButton5 = new JButton();
/* 259 */     this.jPanel5 = new JPanel();
/* 260 */     this.jButton1 = new JButton();
/* 261 */     this.jScrollPane3 = new JScrollPane();
/* 262 */     this.jComboBox2 = new JComboBox();
/* 263 */     this.jScrollPane4 = new JScrollPane();
/* 264 */     this.jList3 = new JList();
/* 265 */     this.jPanel2 = new JPanel();
/* 266 */     this.jLabel1 = new JLabel();
/* 267 */     this.jTextField1 = new JTextField();
/* 268 */     this.jPanel3 = new JPanel();
/* 269 */     this.jButton2 = new JButton();
/* 270 */     this.jPanel13 = new JPanel();
/* 271 */     this.jCheckBox1 = new JCheckBox();
/* 272 */     this.jCheckBox2 = new JCheckBox();
/* 273 */     this.jCheckBox3 = new JCheckBox();
/* 274 */     this.jLabel2 = new JLabel();
/* 275 */     this.jLabel3 = new JLabel();
/* 276 */     this.jLabel4 = new JLabel();
/* 277 */     this.jPanel11 = new JPanel();
/* 278 */     this.jPanel12 = new JPanel();
/* 279 */     this.jSpinner1 = new JSpinner();
/*     */ 
/* 281 */     this.jSplitPane1.setDividerLocation(140);
/* 282 */     this.jSplitPane1.setDividerSize(3);
/*     */ 
/* 284 */     this.jSplitPane2.setDividerLocation(260);
/* 285 */     this.jSplitPane2.setDividerSize(3);
/*     */ 
/* 287 */     this.jSplitPane3.setDividerLocation(100);
/* 288 */     this.jSplitPane3.setDividerSize(3);
/*     */ 
/* 290 */     this.jList2.setSelectionMode(0);
/* 291 */     this.jList2.setMaximumSize(new Dimension(250, 0));
/* 292 */     this.jList2.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 294 */         ActorEditor.this.jList2MouseClicked(evt);
/*     */       }
/*     */       public void mousePressed(java.awt.event.MouseEvent evt) {
/* 297 */         ActorEditor.this.jList2MousePressed(evt);
/*     */       }
/*     */     });
/* 300 */     this.jList2.addListSelectionListener(new ListSelectionListener() {
/*     */       public void valueChanged(ListSelectionEvent evt) {
/* 302 */         ActorEditor.this.jList2ValueChanged(evt);
/*     */       }
/*     */     });
/* 305 */     this.jList2.addMouseMotionListener(new MouseMotionAdapter() {
/*     */       public void mouseDragged(java.awt.event.MouseEvent evt) {
/* 307 */         ActorEditor.this.jList2MouseDragged(evt);
/*     */       }
/*     */     });
/* 310 */     this.jScrollPane2.setViewportView(this.jList2);
/*     */ 
/* 312 */     this.jSplitPane3.setRightComponent(this.jScrollPane2);
/*     */ 
/* 314 */     this.jList1.setModel(this.elist);
/* 315 */     this.jList1.setSelectionMode(0);
/* 316 */     this.jList1.addMouseListener(new MouseAdapter() {
/*     */       public void mousePressed(java.awt.event.MouseEvent evt) {
/* 318 */         ActorEditor.this.jList1MousePressed(evt);
/*     */       }
/*     */     });
/* 321 */     this.jList1.addListSelectionListener(new ListSelectionListener() {
/*     */       public void valueChanged(ListSelectionEvent evt) {
/* 323 */         ActorEditor.this.jList1ValueChanged(evt);
/*     */       }
/*     */     });
/* 326 */     this.jList1.addMouseMotionListener(new MouseMotionAdapter() {
/*     */       public void mouseDragged(java.awt.event.MouseEvent evt) {
/* 328 */         ActorEditor.this.jList1MouseDragged(evt);
/*     */       }
/*     */     });
/* 331 */     this.jScrollPane1.setViewportView(this.jList1);
/*     */ 
/* 333 */     this.jButton5.setText(LangSupporter.activeLang.getEntry(145));
/* 334 */     this.jButton5.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 336 */         ActorEditor.this.jButton5MouseClicked(evt);
/*     */       }
/*     */       public void mouseReleased(java.awt.event.MouseEvent evt) {
/* 339 */         ActorEditor.this.jButton5MouseReleased(evt);
/*     */       }
/*     */     });
/* 343 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 344 */     this.jPanel6.setLayout(jPanel6Layout);
/* 345 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(1).add(this.jButton5, -1, -1, 32767).add(this.jScrollPane1, -1, 99, 32767));
/*     */ 
/* 350 */     jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(1).add(2, jPanel6Layout.createSequentialGroup().add(this.jScrollPane1, -1, 411, 32767).addPreferredGap(0).add(this.jButton5)));
/*     */ 
/* 358 */     this.jSplitPane3.setLeftComponent(this.jPanel6);
/*     */ 
/* 360 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 361 */     this.jPanel4.setLayout(jPanel4Layout);
/* 362 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(1).add(this.jSplitPane3, -1, 259, 32767));
/*     */ 
/* 366 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(1).add(this.jSplitPane3, -1, 442, 32767));
/*     */ 
/* 371 */     this.jSplitPane2.setLeftComponent(this.jPanel4);
/*     */ 
/* 373 */     this.jPanel5.setMinimumSize(new Dimension(100, 0));
/*     */ 
/* 375 */     this.jButton1.setText(LangSupporter.activeLang.getEntry(146));
/* 376 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 378 */         ActorEditor.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 382 */     this.jComboBox2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 384 */         ActorEditor.this.jComboBox2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 388 */     this.jList3.setModel(new AbstractListModel() {
/* 389 */       String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
/*     */ 
/* 390 */       public int getSize() { return this.strings.length; } 
/* 391 */       public Object getElementAt(int i) { return this.strings[i]; }
/*     */ 
/*     */     });
/* 393 */     this.jList3.setSelectionMode(0);
/* 394 */     this.jScrollPane4.setViewportView(this.jList3);
/*     */ 
/* 396 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 397 */     this.jPanel5.setLayout(jPanel5Layout);
/* 398 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(1).add(this.jComboBox2, 0, 210, 32767).add(2, jPanel5Layout.createSequentialGroup().addContainerGap().add(this.jButton1)).add(2, this.jScrollPane4, -1, 210, 32767).add(this.jScrollPane3, -1, 210, 32767));
/*     */ 
/* 407 */     jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(1).add(jPanel5Layout.createSequentialGroup().add(this.jComboBox2, -2, -1, -2).addPreferredGap(0).add(this.jScrollPane4, -2, -1, -2).add(11, 11, 11).add(this.jButton1).addPreferredGap(0).add(this.jScrollPane3, -1, 246, 32767)));
/*     */ 
/* 419 */     this.jSplitPane2.setRightComponent(this.jPanel5);
/*     */ 
/* 421 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 422 */     this.jPanel1.setLayout(jPanel1Layout);
/* 423 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(1).add(this.jSplitPane2, -1, 474, 32767));
/*     */ 
/* 427 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(1).add(this.jSplitPane2, -1, 444, 32767));
/*     */ 
/* 432 */     this.jSplitPane1.setRightComponent(this.jPanel1);
/*     */ 
/* 434 */     this.jLabel1.setText(LangSupporter.activeLang.getEntry(136));
/*     */ 
/* 436 */     this.jTextField1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 438 */         ActorEditor.this.jTextField1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 442 */     this.jPanel3.setBorder(BorderFactory.createTitledBorder(LangSupporter.activeLang.getEntry(137)));
/*     */ 
/* 444 */     this.jButton2.setText(LangSupporter.activeLang.getEntry(138));
/*     */ 
/* 446 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/* 447 */     this.jPanel13.setLayout(jPanel13Layout);
/* 448 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout.createParallelGroup(1).add(0, 117, 32767));
/*     */ 
/* 452 */     jPanel13Layout.setVerticalGroup(jPanel13Layout.createParallelGroup(1).add(0, 23, 32767));
/*     */ 
/* 457 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 458 */     this.jPanel3.setLayout(jPanel3Layout);
/* 459 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(1).add(this.jButton2, -1, 117, 32767).add(this.jPanel13, -1, -1, 32767));
/*     */ 
/* 464 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(1).add(jPanel3Layout.createSequentialGroup().add(this.jPanel13, -2, -1, -2).addPreferredGap(0).add(this.jButton2)));
/*     */ 
/* 472 */     this.jCheckBox1.setSelected(true);
/* 473 */     this.jCheckBox1.setText(LangSupporter.activeLang.getEntry(139));
/* 474 */     this.jCheckBox1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 475 */     this.jCheckBox1.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 477 */         ActorEditor.this.jCheckBox1MouseClicked(evt);
/*     */       }
/*     */     });
/* 480 */     this.jCheckBox1.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent evt) {
/* 482 */         ActorEditor.this.jCheckBox1StateChanged(evt);
/*     */       }
/*     */     });
/* 485 */     this.jCheckBox1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 487 */         ActorEditor.this.jCheckBox1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 491 */     this.jCheckBox2.setSelected(true);
/* 492 */     this.jCheckBox2.setText(LangSupporter.activeLang.getEntry(140));
/* 493 */     this.jCheckBox2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 494 */     this.jCheckBox2.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 496 */         ActorEditor.this.jCheckBox2MouseClicked(evt);
/*     */       }
/*     */     });
/* 499 */     this.jCheckBox2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 501 */         ActorEditor.this.jCheckBox2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 505 */     this.jCheckBox3.setText(LangSupporter.activeLang.getEntry(141));
/* 506 */     this.jCheckBox3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 507 */     this.jCheckBox3.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 509 */         ActorEditor.this.jCheckBox3MouseClicked(evt);
/*     */       }
/*     */     });
/* 512 */     this.jCheckBox3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 514 */         ActorEditor.this.jCheckBox3ActionPerformed(evt);
/*     */       }
/*     */     });
/* 518 */     this.jLabel2.setText(LangSupporter.activeLang.getEntry(142));
/*     */ 
/* 520 */     this.jLabel3.setText(LangSupporter.activeLang.getEntry(143));
/*     */ 
/* 522 */     this.jLabel4.setText(LangSupporter.activeLang.getEntry(144));
/*     */ 
/* 524 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 525 */     this.jPanel11.setLayout(jPanel11Layout);
/* 526 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(1).add(0, 49, 32767));
/*     */ 
/* 530 */     jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(1).add(0, 15, 32767));
/*     */ 
/* 535 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 536 */     this.jPanel12.setLayout(jPanel12Layout);
/* 537 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout.createParallelGroup(1).add(0, 49, 32767));
/*     */ 
/* 541 */     jPanel12Layout.setVerticalGroup(jPanel12Layout.createParallelGroup(1).add(0, 15, 32767));
/*     */ 
/* 546 */     this.jSpinner1.setModel(new SpinnerNumberModel(Integer.valueOf(0), null, null, Integer.valueOf(10)));
/* 547 */     this.jSpinner1.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent evt) {
/* 549 */         ActorEditor.this.jSpinner1StateChanged(evt);
/*     */       }
/*     */     });
/* 553 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 554 */     this.jPanel2.setLayout(jPanel2Layout);
/* 555 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(1).add(jPanel2Layout.createSequentialGroup().addContainerGap().add(jPanel2Layout.createParallelGroup(1).add(this.jCheckBox2, -1, 129, 32767).add(this.jCheckBox1, -1, 129, 32767).add(this.jPanel3, -1, -1, 32767).add(jPanel2Layout.createSequentialGroup().add(jPanel2Layout.createParallelGroup(1).add(jPanel2Layout.createSequentialGroup().add(this.jLabel1).addPreferredGap(0).add(this.jTextField1, -1, 49, 32767)).add(this.jCheckBox3).add(jPanel2Layout.createSequentialGroup().add(this.jLabel2).addPreferredGap(0).add(this.jSpinner1, -1, 49, 32767)).add(jPanel2Layout.createSequentialGroup().add(this.jLabel4).addPreferredGap(0).add(this.jPanel12, -1, -1, 32767)).add(jPanel2Layout.createSequentialGroup().add(this.jLabel3).addPreferredGap(0).add(this.jPanel11, -1, -1, 32767))).addContainerGap()))));
/*     */ 
/* 584 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(1).add(jPanel2Layout.createSequentialGroup().addContainerGap().add(jPanel2Layout.createParallelGroup(3).add(this.jLabel1).add(this.jTextField1, -2, -1, -2)).addPreferredGap(0).add(this.jPanel3, -2, -1, -2).addPreferredGap(0).add(this.jCheckBox1).addPreferredGap(0).add(this.jCheckBox2).addPreferredGap(0).add(this.jCheckBox3).addPreferredGap(0).add(jPanel2Layout.createParallelGroup(3).add(this.jLabel2).add(this.jSpinner1, -2, -1, -2)).addPreferredGap(0).add(jPanel2Layout.createParallelGroup(1).add(this.jLabel3).add(this.jPanel11, -2, -1, -2)).addPreferredGap(0).add(jPanel2Layout.createParallelGroup(1).add(this.jLabel4).add(this.jPanel12, -2, -1, -2)).addContainerGap(197, 32767)));
/*     */ 
/* 614 */     this.jSplitPane1.setLeftComponent(this.jPanel2);
/*     */ 
/* 616 */     GroupLayout layout = new GroupLayout(this);
/* 617 */     setLayout(layout);
/* 618 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(this.jSplitPane1, -1, 618, 32767));
/*     */ 
/* 622 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(this.jSplitPane1, -1, 446, 32767));
/*     */   }
/*     */ 
/*     */   public void event(int type, String name)
/*     */   {
/* 629 */     System.out.println("Actor editor:event:type" + type);
/* 630 */     if (type == 1000)
/* 631 */       this.elist.add(new CreateEvent());
/* 632 */     else if (type == 2000)
/* 633 */       this.elist.add(new DestroyEvent());
/* 634 */     else if (type == 4005)
/* 635 */       this.elist.add(new DrawEvent());
/* 636 */     else if (type == 3001)
/* 637 */       this.elist.add(new BeginStepEvent());
/* 638 */     else if (type == 3002)
/* 639 */       this.elist.add(new StepEvent());
/* 640 */     else if (type == 3003)
/* 641 */       this.elist.add(new EndStepEvent());
/* 642 */     else if ((type >= 5006) && (type <= 5019))
/* 643 */       this.elist.add(new org.gcreator.events.MouseEvent(type));
/* 644 */     else if ((type >= 5020) && (type <= 5031)) {
/* 645 */       this.elist.add(new AlarmEvent(type - 5020));
/*     */     }
/* 647 */     else if ((type >= 6000) && (type <= 6999)) {
/* 648 */       this.elist.add(new KeyboardEvent(type - 6000, name));
/*     */     }
/* 650 */     else if ((type >= 8000) && (type <= 8999)) {
/* 651 */       this.elist.add(new KeyPress(type - 8000, name));
/*     */     }
/* 653 */     else if ((type >= 9000) && (type <= 9999)) {
/* 654 */       this.elist.add(new KeyReleased(type - 9000, name));
/*     */     }
/* 656 */     this.jScrollPane1.updateUI();
/* 657 */     this.jList1.updateUI();
/* 658 */     updateActionList();
/*     */   }
/*     */ 
/*     */   public void updateActionList() {
/* 662 */     this.actmodel.removeAllElements();
/* 663 */     if (this.jList1.getSelectedValue() == null) {
/* 664 */       return;
/*     */     }
/* 666 */     Vector actions = ((Event)this.jList1.getSelectedValue()).actions;
/* 667 */     for (int i = 0; i < actions.size(); i++)
/* 668 */       this.actmodel.addElement(actions.get(i));
/*     */   }
/*     */ 
/*     */   private void jButton5MouseClicked(java.awt.event.MouseEvent evt)
/*     */   {
/* 673 */     EventSelectListener listener = new EventSelectListener()
/*     */     {
/*     */       public void eventSelected(int type, String name) {
/* 676 */         ActorEditor.this.event(type, name);
/*     */       }
/*     */ 
/*     */       public void eventSelected(int type) {
/* 680 */         ActorEditor.this.event(type, "");
/*     */       }
/*     */     };
/* 683 */     EventSelect selector = new EventSelect(this, gcreator.window, true, evt.getX(), evt.getY(), listener);
/* 684 */     this.changed = true;
/*     */   }
/*     */ 
/*     */   private void jTextField1ActionPerformed(ActionEvent evt) {
/* 688 */     this.file.name = this.jTextField1.getText();
/* 689 */     this.actor.name = this.file.name;
/* 690 */     Aurwindow.workspace.updateUI();
/* 691 */     updateNavigator();
/*     */   }
/*     */ 
/*     */   private void jCheckBox1StateChanged(ChangeEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jCheckBox1MouseClicked(java.awt.event.MouseEvent evt) {
/* 699 */     this.changed = true;
/*     */   }
/*     */ 
/*     */   private void jCheckBox2MouseClicked(java.awt.event.MouseEvent evt) {
/* 703 */     this.changed = true;
/*     */   }
/*     */ 
/*     */   private void jCheckBox3MouseClicked(java.awt.event.MouseEvent evt) {
/* 707 */     this.changed = true;
/*     */   }
/*     */ 
/*     */   private void jButton5MouseReleased(java.awt.event.MouseEvent evt) {
/* 711 */     jButton5MouseClicked(evt);
/*     */   }
/*     */ 
/*     */   private void jList1ValueChanged(ListSelectionEvent evt) {
/* 715 */     updateActionList();
/* 716 */     this.jScrollPane3.setViewportView(null);
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/* 721 */     if (this.jList1.getSelectedValue() == null) {
/* 722 */       return;
/*     */     }
/* 724 */     if (this.jList3.getSelectedValue() == null) {
/* 725 */       return;
/*     */     }
/* 727 */     ActionPattern ap = (ActionPattern)((ActionPattern)this.jList3.getSelectedValue()).clone();
/*     */ 
/* 729 */     Action a = new Action(this, ap);
/* 730 */     ((Event)this.jList1.getSelectedValue()).actions.add(a);
/*     */ 
/* 732 */     updateActionList();
/*     */   }
/*     */ 
/*     */   private void jList2ValueChanged(ListSelectionEvent evt)
/*     */   {
/* 737 */     if (this.jList2.getSelectedValue() == null) {
/* 738 */       return;
/*     */     }
/*     */ 
/* 741 */     this.jScrollPane3.setViewportView(((Action)this.jList2.getSelectedValue()).getPanel());
/*     */   }
/*     */ 
/*     */   private void jCheckBox1ActionPerformed(ActionEvent evt) {
/* 745 */     this.actor.visible = this.jCheckBox1.isSelected();
/* 746 */     updateNavigator();
/*     */   }
/*     */ 
/*     */   private void jCheckBox2ActionPerformed(ActionEvent evt) {
/* 750 */     this.actor.solid = this.jCheckBox2.isSelected();
/* 751 */     updateNavigator();
/*     */   }
/*     */ 
/*     */   private void jCheckBox3ActionPerformed(ActionEvent evt) {
/* 755 */     this.actor.persistant = this.jCheckBox3.isSelected();
/* 756 */     updateNavigator();
/*     */   }
/*     */ 
/*     */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 760 */     this.jList3.setModel(new DefaultComboBoxModel(((ActionCategory)this.jComboBox2.getSelectedItem()).patterns));
/* 761 */     this.jList3.updateUI();
/*     */   }
/*     */ 
/*     */   private void jList2MouseDragged(java.awt.event.MouseEvent evt) {
/* 765 */     int to = this.jList2.locationToIndex(evt.getPoint());
/* 766 */     if (to == this.from) return;
/* 767 */     Action remove = (Action)((Event)this.jList1.getSelectedValue()).actions.remove(this.from);
/* 768 */     ((Event)this.jList1.getSelectedValue()).actions.add(to, remove);
/* 769 */     this.from = to;
/* 770 */     updateActionList();
/*     */   }
/*     */ 
/*     */   private void jList2MousePressed(java.awt.event.MouseEvent evt) {
/* 774 */     this.from = this.jList2.locationToIndex(evt.getPoint());
/*     */   }
/*     */ 
/*     */   private void jList1MouseDragged(java.awt.event.MouseEvent evt)
/*     */   {
/* 779 */     int to = this.jList1.locationToIndex(evt.getPoint());
/* 780 */     if (to == this.from) return;
/* 781 */     Event remove = (Event)this.elist.getEvents().remove(this.from);
/* 782 */     this.elist.getEvents().add(to, remove);
/* 783 */     this.from = to;
/*     */   }
/*     */ 
/*     */   private void jList1MousePressed(java.awt.event.MouseEvent evt)
/*     */   {
/* 788 */     this.from = this.jList1.locationToIndex(evt.getPoint());
/*     */   }
/*     */ 
/*     */   private void jList2MouseClicked(java.awt.event.MouseEvent evt) {
/* 792 */     this.jList2.setSelectedIndex(this.jList2.locationToIndex(evt.getPoint()));
/*     */   }
/*     */ 
/*     */   private void jSpinner1StateChanged(ChangeEvent evt) {
/* 796 */     this.actor.depth = ((Integer)this.jSpinner1.getValue()).intValue();
/* 797 */     updateNavigator();
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.editors.ActorEditor
 * JD-Core Version:    0.6.2
 */