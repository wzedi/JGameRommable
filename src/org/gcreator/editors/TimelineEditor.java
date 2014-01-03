/*     */ package org.gcreator.editors;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseMotionAdapter;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Vector;
/*     */ import javax.swing.AbstractListModel;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JSplitPane;
/*     */ import javax.swing.JTextField;
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
/*     */ import org.gcreator.components.impl.TimelineStepsCellRenderer;
/*     */ import org.gcreator.components.impl.VectorComboBoxModel;
/*     */ import org.gcreator.components.popupmenus.ActionPopupMenu;
/*     */ import org.gcreator.components.popupmenus.PopupListener;
/*     */ import org.gcreator.core.Aurwindow;
/*     */ import org.gcreator.events.Event;
/*     */ import org.gcreator.exceptions.WrongResourceException;
/*     */ import org.gcreator.fileclass.GFile;
/*     */ import org.gcreator.fileclass.Project;
/*     */ import org.gcreator.fileclass.res.Timeline;
/*     */ import org.gcreator.fileclass.res.TimelineStep;
/*     */ import org.gcreator.managers.LangSupporter;
/*     */ import org.gcreator.units.Dictionary;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class TimelineEditor extends TabPanel
/*     */ {
/*     */   private Timeline timeline;
/*     */   int from;
/*  31 */   DefaultComboBoxModel actmodel = new DefaultComboBoxModel();
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JButton jButton3;
/*     */   private JButton jButton4;
/*     */   private JButton jButton5;
/*     */   private JComboBox jComboBox2;
/*     */   public JComboBox jComboBox3;
/*     */   private JLabel jLabel1;
/*     */   public JList jList1;
/*     */   private JList jList2;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JPanel jPanel5;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JScrollPane jScrollPane2;
/*     */   public JScrollPane jScrollPane3;
/*     */   private JSplitPane jSplitPane1;
/*     */   private JSplitPane jSplitPane2;
/*     */   private JTextField jTextField1;
/*     */ 
/*     */   public TimelineEditor(GFile file, Project project)
/*     */     throws WrongResourceException
/*     */   {
/*  34 */     this.project = project;
/*  35 */     this.file = file;
/*  36 */     if (file.value == null) {
/*  37 */       this.timeline = new Timeline(file.name);
/*  38 */       file.value = this.timeline;
/*  39 */     } else if ((file.value instanceof Timeline)) {
/*  40 */       this.timeline = ((Timeline)file.value);
/*     */     } else {
/*  42 */       throw new WrongResourceException();
/*     */     }
/*  44 */     initComponents();
/*  45 */     PopupListener a = new PopupListener(this.jList1, new ActionPopupMenu(this));
/*  46 */     a.update = true;
/*  47 */     this.jList1.addMouseListener(a);
/*  48 */     this.jTextField1.setText(file.name);
/*  49 */     this.jTextField1.getDocument().addDocumentListener(new DocumentListener() {
/*     */       public void changedUpdate(DocumentEvent evt) {
/*  51 */         TimelineEditor.this.updateName();
/*     */       }
/*     */       public void insertUpdate(DocumentEvent evt) {
/*  54 */         TimelineEditor.this.updateName();
/*     */       }
/*     */       public void removeUpdate(DocumentEvent evt) {
/*  57 */         TimelineEditor.this.updateName();
/*     */       }
/*     */     });
/*  60 */     this.jComboBox3.setModel(new VectorComboBoxModel(this.timeline.steps));
/*  61 */     this.jComboBox3.setRenderer(new TimelineStepsCellRenderer());
/*  62 */     this.jComboBox2.setModel(new DefaultComboBoxModel(ActionContainer.actionCats));
/*  63 */     this.jComboBox2.setRenderer(new ActionListCellRenderer());
/*  64 */     this.jList2.setModel(new DefaultComboBoxModel(((ActionCategory)ActionContainer.actionCats.get(0)).patterns));
/*  65 */     this.jList2.setCellRenderer(new ActionListCellRenderer());
/*  66 */     this.jList1.setCellRenderer(new ActionsCellRenderer());
/*  67 */     this.jList1.setModel(this.actmodel);
/*     */   }
/*     */ 
/*     */   public void updateName() {
/*  71 */     this.file.name = this.jTextField1.getText();
/*  72 */     this.timeline.name = this.file.name;
/*  73 */     Aurwindow.workspace.updateUI();
/*     */   }
/*     */ 
/*     */   public void updateActionList() {
/*  77 */     this.actmodel.removeAllElements();
/*  78 */     if (this.jComboBox3.getSelectedItem() == null) {
/*  79 */       return;
/*     */     }
/*  81 */     Vector actions = (TimelineStep)this.jComboBox3.getSelectedItem();
/*  82 */     for (int i = 0; i < actions.size(); i++)
/*  83 */       this.actmodel.addElement(actions.get(i));
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  95 */     this.jSplitPane1 = new JSplitPane();
/*  96 */     this.jPanel1 = new JPanel();
/*  97 */     this.jLabel1 = new JLabel();
/*  98 */     this.jTextField1 = new JTextField();
/*  99 */     this.jButton2 = new JButton();
/* 100 */     this.jButton3 = new JButton();
/* 101 */     this.jButton4 = new JButton();
/* 102 */     this.jButton5 = new JButton();
/* 103 */     this.jSplitPane2 = new JSplitPane();
/* 104 */     this.jPanel5 = new JPanel();
/* 105 */     this.jButton1 = new JButton();
/* 106 */     this.jScrollPane3 = new JScrollPane();
/* 107 */     this.jComboBox2 = new JComboBox();
/* 108 */     this.jScrollPane1 = new JScrollPane();
/* 109 */     this.jList2 = new JList();
/* 110 */     this.jPanel2 = new JPanel();
/* 111 */     this.jComboBox3 = new JComboBox();
/* 112 */     this.jScrollPane2 = new JScrollPane();
/* 113 */     this.jList1 = new JList();
/*     */ 
/* 115 */     this.jSplitPane1.setDividerLocation(150);
/*     */ 
/* 117 */     this.jLabel1.setText(LangSupporter.activeLang.getEntry(136));
/*     */ 
/* 119 */     this.jTextField1.setText("jTextField1");
/*     */ 
/* 121 */     this.jButton2.setText("Add");
/* 122 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 124 */         TimelineEditor.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 128 */     this.jButton3.setText("Remove");
/*     */ 
/* 130 */     this.jButton4.setText("Change");
/*     */ 
/* 132 */     this.jButton5.setText("Duplicate");
/*     */ 
/* 134 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 135 */     this.jPanel1.setLayout(jPanel1Layout);
/* 136 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().addContainerGap().add(jPanel1Layout.createParallelGroup(1).add(this.jTextField1, -1, 129, 32767).add(this.jLabel1).add(this.jButton2).add(this.jButton3).add(this.jButton4).add(this.jButton5)).addContainerGap()));
/*     */ 
/* 149 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().addContainerGap().add(this.jLabel1).addPreferredGap(0).add(this.jTextField1, -2, -1, -2).addPreferredGap(0).add(this.jButton2).addPreferredGap(0).add(this.jButton3).addPreferredGap(0).add(this.jButton4).addPreferredGap(0).add(this.jButton5).addContainerGap(248, 32767)));
/*     */ 
/* 167 */     this.jSplitPane1.setLeftComponent(this.jPanel1);
/*     */ 
/* 169 */     this.jSplitPane2.setDividerLocation(130);
/*     */ 
/* 171 */     this.jPanel5.setMinimumSize(new Dimension(100, 0));
/*     */ 
/* 173 */     this.jButton1.setText(LangSupporter.activeLang.getEntry(146));
/* 174 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 176 */         TimelineEditor.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 180 */     this.jComboBox2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 182 */         TimelineEditor.this.jComboBox2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 186 */     this.jList2.setModel(new AbstractListModel() {
/* 187 */       String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
/*     */ 
/* 188 */       public int getSize() { return this.strings.length; } 
/* 189 */       public Object getElementAt(int i) { return this.strings[i]; }
/*     */ 
/*     */     });
/* 191 */     this.jScrollPane1.setViewportView(this.jList2);
/*     */ 
/* 193 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 194 */     this.jPanel5.setLayout(jPanel5Layout);
/* 195 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(1).add(this.jComboBox2, 0, 268, 32767).add(2, this.jScrollPane1, -1, 268, 32767).add(2, jPanel5Layout.createSequentialGroup().addContainerGap().add(this.jButton1)).add(2, this.jScrollPane3, -1, 268, 32767));
/*     */ 
/* 204 */     jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(1).add(jPanel5Layout.createSequentialGroup().add(this.jComboBox2, -2, -1, -2).addPreferredGap(0).add(this.jScrollPane1, -2, -1, -2).addPreferredGap(0).add(this.jButton1).addPreferredGap(0).add(this.jScrollPane3, -1, 222, 32767)));
/*     */ 
/* 216 */     this.jSplitPane2.setRightComponent(this.jPanel5);
/*     */ 
/* 218 */     this.jComboBox3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 220 */         TimelineEditor.this.jComboBox3ActionPerformed(evt);
/*     */       }
/*     */     });
/* 224 */     this.jList1.setSelectionMode(0);
/* 225 */     this.jList1.setMaximumSize(new Dimension(250, 0));
/* 226 */     this.jList1.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 228 */         TimelineEditor.this.jList1MouseClicked(evt);
/*     */       }
/*     */       public void mousePressed(MouseEvent evt) {
/* 231 */         TimelineEditor.this.jList1MousePressed(evt);
/*     */       }
/*     */     });
/* 234 */     this.jList1.addListSelectionListener(new ListSelectionListener() {
/*     */       public void valueChanged(ListSelectionEvent evt) {
/* 236 */         TimelineEditor.this.jList1ValueChanged(evt);
/*     */       }
/*     */     });
/* 239 */     this.jList1.addMouseMotionListener(new MouseMotionAdapter() {
/*     */       public void mouseDragged(MouseEvent evt) {
/* 241 */         TimelineEditor.this.jList1MouseDragged(evt);
/*     */       }
/*     */     });
/* 244 */     this.jScrollPane2.setViewportView(this.jList1);
/*     */ 
/* 246 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 247 */     this.jPanel2.setLayout(jPanel2Layout);
/* 248 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(1).add(this.jComboBox3, 0, 129, 32767).add(this.jScrollPane2, -1, 129, 32767));
/*     */ 
/* 253 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(1).add(jPanel2Layout.createSequentialGroup().add(this.jComboBox3, -2, -1, -2).addPreferredGap(0).add(this.jScrollPane2, -1, 387, 32767)));
/*     */ 
/* 261 */     this.jSplitPane2.setLeftComponent(this.jPanel2);
/*     */ 
/* 263 */     this.jSplitPane1.setRightComponent(this.jSplitPane2);
/*     */ 
/* 265 */     GroupLayout layout = new GroupLayout(this);
/* 266 */     setLayout(layout);
/* 267 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(this.jSplitPane1, -1, 560, 32767));
/*     */ 
/* 271 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(this.jSplitPane1, -1, 417, 32767));
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/* 279 */     System.out.println("adding");
/* 280 */     if (this.jComboBox3.getSelectedItem() == null) {
/* 281 */       return;
/*     */     }
/* 283 */     if (this.jList2.getSelectedValue() == null) {
/* 284 */       return;
/*     */     }
/* 286 */     System.out.println("creating ap");
/* 287 */     ActionPattern ap = (ActionPattern)this.jList2.getSelectedValue();
/* 288 */     System.out.println("proceeding");
/* 289 */     Action a = new Action(this, ap);
/* 290 */     System.out.println("Action: " + a.getLabel());
/* 291 */     TimelineStep step = (TimelineStep)this.jComboBox3.getSelectedItem();
/* 292 */     System.out.println("Step " + step.stepnum);
/* 293 */     step.add(a);
/* 294 */     System.out.println("added");
/* 295 */     updateActionList();
/*     */   }
/*     */ 
/*     */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 299 */     this.jList2.setModel(new DefaultComboBoxModel(((ActionCategory)this.jComboBox2.getSelectedItem()).patterns));
/* 300 */     this.jList2.updateUI();
/*     */   }
/*     */ 
/*     */   private void jList1MouseClicked(MouseEvent evt) {
/* 304 */     this.jList1.setSelectedIndex(this.jList1.locationToIndex(evt.getPoint()));
/*     */   }
/*     */ 
/*     */   private void jList1MousePressed(MouseEvent evt) {
/* 308 */     this.from = this.jList1.locationToIndex(evt.getPoint());
/*     */   }
/*     */ 
/*     */   private void jList1ValueChanged(ListSelectionEvent evt)
/*     */   {
/* 313 */     if (this.jList1.getSelectedValue() == null) {
/* 314 */       return;
/*     */     }
/*     */ 
/* 317 */     this.jScrollPane3.setViewportView(((Action)this.jList1.getSelectedValue()).getPanel());
/*     */   }
/*     */ 
/*     */   private void jList1MouseDragged(MouseEvent evt) {
/* 321 */     int to = this.jList1.locationToIndex(evt.getPoint());
/* 322 */     if (to == this.from) return;
/* 323 */     Action remove = (Action)((Event)this.jList1.getSelectedValue()).actions.remove(this.from);
/* 324 */     ((Event)this.jList1.getSelectedValue()).actions.add(to, remove);
/* 325 */     this.from = to;
/* 326 */     updateActionList();
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 330 */     String s = JOptionPane.showInputDialog(this, "Step number:", Integer.valueOf(0));
/* 331 */     if (s == null)
/* 332 */       return;
/*     */     try {
/* 334 */       int i = Integer.parseInt(s);
/* 335 */       if (i < 0)
/* 336 */         return;
/* 337 */       TimelineStep step = new TimelineStep();
/* 338 */       step.stepnum = i;
/* 339 */       this.timeline.steps.add(step);
/* 340 */       this.jList1.updateUI();
/* 341 */       this.jComboBox3.updateUI();
/*     */     } catch (Exception e) {
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 347 */     updateActionList();
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.editors.TimelineEditor
 * JD-Core Version:    0.6.2
 */