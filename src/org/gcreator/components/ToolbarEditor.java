/*     */ package org.gcreator.components;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.Vector;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.ListCellRenderer;
/*     */ import javax.swing.event.ListSelectionEvent;
/*     */ import javax.swing.event.ListSelectionListener;
/*     */ import org.gcreator.components.impl.ToolButtonListCellRenderer;
/*     */ import org.gcreator.components.impl.Toolbar;
/*     */ import org.gcreator.components.impl.ToolbarButton;
/*     */ import org.gcreator.components.impl.ToolbarCellRenderer;
/*     */ import org.gcreator.components.impl.ToolbarItem;
/*     */ import org.gcreator.components.impl.ToolbarSeparator;
/*     */ import org.gcreator.components.impl.VectorComboBoxModel;
/*     */ import org.gcreator.components.impl.VectorListModel;
/*     */ import org.gcreator.managers.ToolbarManager;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class ToolbarEditor extends JPanel
/*     */ {
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JButton jButton3;
/*     */   private JButton jButton5;
/*     */   private JButton jButton6;
/*     */   private JButton jButton7;
/*     */   private JButton jButton8;
/*     */   private JCheckBox jCheckBox1;
/*     */   private JCheckBox jCheckBox2;
/*     */   private JCheckBox jCheckBox3;
/*     */   private JCheckBox jCheckBox4;
/*     */   private JCheckBox jCheckBox5;
/*     */   private JComboBox jComboBox1;
/*     */   private JComboBox jComboBox2;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JList jList1;
/*     */   private JList jList2;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JScrollPane jScrollPane2;
/*     */ 
/*     */   public ToolbarEditor()
/*     */   {
/*  23 */     initComponents();
/*  24 */     this.jComboBox1.setModel(new VectorComboBoxModel(ToolbarManager.toolbars));
/*  25 */     this.jComboBox1.setRenderer(new ToolbarCellRenderer());
/*  26 */     this.jComboBox1.setBackground(Color.WHITE);
/*  27 */     if (ToolbarManager.toolbars.size() > 0)
/*  28 */       this.jComboBox1.setSelectedIndex(0);
/*     */     else
/*  30 */       this.jComboBox1.setSelectedIndex(-1);
/*  31 */     updateToolbar();
/*  32 */     ListCellRenderer r = new ToolButtonListCellRenderer();
/*  33 */     this.jList1.setCellRenderer(r);
/*  34 */     Vector v = new Vector();
/*  35 */     v.add(new ToolbarSeparator());
/*  36 */     v.addAll(ToolbarManager.toolbuttons);
/*  37 */     this.jList2.setModel(new VectorListModel(v));
/*  38 */     this.jList2.setCellRenderer(r);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  49 */     this.jLabel1 = new JLabel();
/*  50 */     this.jComboBox1 = new JComboBox();
/*  51 */     this.jButton1 = new JButton();
/*  52 */     this.jCheckBox1 = new JCheckBox();
/*  53 */     this.jCheckBox2 = new JCheckBox();
/*  54 */     this.jLabel2 = new JLabel();
/*  55 */     this.jComboBox2 = new JComboBox();
/*  56 */     this.jCheckBox3 = new JCheckBox();
/*  57 */     this.jCheckBox4 = new JCheckBox();
/*  58 */     this.jButton2 = new JButton();
/*  59 */     this.jButton3 = new JButton();
/*  60 */     this.jButton5 = new JButton();
/*  61 */     this.jButton6 = new JButton();
/*  62 */     this.jButton7 = new JButton();
/*  63 */     this.jButton8 = new JButton();
/*  64 */     this.jScrollPane2 = new JScrollPane();
/*  65 */     this.jList2 = new JList();
/*  66 */     this.jScrollPane1 = new JScrollPane();
/*  67 */     this.jList1 = new JList();
/*  68 */     this.jCheckBox5 = new JCheckBox();
/*     */ 
/*  70 */     this.jLabel1.setText("Select toolbar to edit:");
/*     */ 
/*  72 */     this.jComboBox1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  74 */         ToolbarEditor.this.jComboBox1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  78 */     this.jButton1.setText("Create new Toolbar");
/*  79 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  81 */         ToolbarEditor.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  85 */     this.jCheckBox1.setSelected(true);
/*  86 */     this.jCheckBox1.setText("Floatable");
/*  87 */     this.jCheckBox1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  89 */         ToolbarEditor.this.jCheckBox1ActionPerformed(evt);
/*     */       }
/*     */     });
/*  93 */     this.jCheckBox2.setSelected(true);
/*  94 */     this.jCheckBox2.setText("Rollover");
/*  95 */     this.jCheckBox2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  97 */         ToolbarEditor.this.jCheckBox2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 101 */     this.jLabel2.setText("Location:");
/*     */ 
/* 103 */     this.jComboBox2.setModel(new DefaultComboBoxModel(new String[] { "Top", "Bottom", "Left", "Right" }));
/* 104 */     this.jComboBox2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 106 */         ToolbarEditor.this.jComboBox2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 110 */     this.jCheckBox3.setText("Text Visible");
/* 111 */     this.jCheckBox3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 113 */         ToolbarEditor.this.jCheckBox3ActionPerformed(evt);
/*     */       }
/*     */     });
/* 117 */     this.jCheckBox4.setText("Image Visible");
/* 118 */     this.jCheckBox4.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 120 */         ToolbarEditor.this.jCheckBox4ActionPerformed(evt);
/*     */       }
/*     */     });
/* 124 */     this.jButton2.setText("Remove Item");
/* 125 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 127 */         ToolbarEditor.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 131 */     this.jButton3.setText("Add");
/* 132 */     this.jButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 134 */         ToolbarEditor.this.jButton3ActionPerformed(evt);
/*     */       }
/*     */     });
/* 138 */     this.jButton5.setText("Delete Toolbar");
/* 139 */     this.jButton5.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 141 */         ToolbarEditor.this.jButton5ActionPerformed(evt);
/*     */       }
/*     */     });
/* 145 */     this.jButton6.setText("Move Up");
/* 146 */     this.jButton6.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 148 */         ToolbarEditor.this.jButton6ActionPerformed(evt);
/*     */       }
/*     */     });
/* 152 */     this.jButton7.setText("Move Down");
/* 153 */     this.jButton7.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 155 */         ToolbarEditor.this.jButton7ActionPerformed(evt);
/*     */       }
/*     */     });
/* 159 */     this.jButton8.setText("Rename Toolbar");
/* 160 */     this.jButton8.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 162 */         ToolbarEditor.this.jButton8ActionPerformed(evt);
/*     */       }
/*     */     });
/* 166 */     this.jScrollPane2.setViewportView(this.jList2);
/*     */ 
/* 168 */     this.jList1.addListSelectionListener(new ListSelectionListener() {
/*     */       public void valueChanged(ListSelectionEvent evt) {
/* 170 */         ToolbarEditor.this.jList1ValueChanged(evt);
/*     */       }
/*     */     });
/* 173 */     this.jScrollPane1.setViewportView(this.jList1);
/*     */ 
/* 175 */     this.jCheckBox5.setText("Bold");
/* 176 */     this.jCheckBox5.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 178 */         ToolbarEditor.this.jCheckBox5ActionPerformed(evt);
/*     */       }
/*     */     });
/* 182 */     GroupLayout layout = new GroupLayout(this);
/* 183 */     setLayout(layout);
/* 184 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(2, layout.createSequentialGroup().add(this.jCheckBox1).addPreferredGap(0, 52, 32767).add(this.jButton8).addPreferredGap(0).add(this.jButton5).addPreferredGap(0).add(this.jButton1)).add(2, layout.createSequentialGroup().add(layout.createParallelGroup(1).add(layout.createParallelGroup(1, false).add(this.jLabel1, -1, -1, 32767).add(this.jLabel2).add(this.jCheckBox2)).add(this.jScrollPane1, -1, 144, 32767)).addPreferredGap(0).add(layout.createParallelGroup(1).add(this.jScrollPane2, -1, 324, 32767).add(2, this.jComboBox1, 0, 324, 32767).add(2, this.jComboBox2, 0, 324, 32767).add(layout.createSequentialGroup().add(layout.createParallelGroup(1).add(this.jCheckBox3).add(this.jCheckBox4)).addPreferredGap(0, 140, 32767).add(this.jButton2)).add(2, layout.createSequentialGroup().add(this.jCheckBox5).addPreferredGap(0, 204, 32767).add(this.jButton6)).add(2, layout.createSequentialGroup().add(this.jButton3).addPreferredGap(0, 184, 32767).add(this.jButton7))))).addContainerGap()));
/*     */ 
/* 225 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(3).add(this.jLabel1).add(this.jComboBox1, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jButton1).add(this.jCheckBox1).add(this.jButton5).add(this.jButton8)).addPreferredGap(0).add(this.jCheckBox2).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jLabel2).add(this.jComboBox2, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(this.jCheckBox3).addPreferredGap(0).add(this.jCheckBox4).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jButton6).add(this.jCheckBox5))).add(this.jButton2)).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jButton7).add(this.jButton3)).addPreferredGap(0).add(this.jScrollPane2, -1, 225, 32767)).add(this.jScrollPane1, -1, 331, 32767)).addContainerGap()));
/*     */   }
/*     */ 
/*     */   private void jCheckBox1ActionPerformed(ActionEvent evt)
/*     */   {
/* 269 */     Toolbar t = (Toolbar)this.jComboBox1.getSelectedItem();
/* 270 */     t.floatable = this.jCheckBox1.isSelected();
/*     */   }
/*     */ 
/*     */   private void jCheckBox2ActionPerformed(ActionEvent evt) {
/* 274 */     Toolbar t = (Toolbar)this.jComboBox1.getSelectedItem();
/* 275 */     t.rollover = this.jCheckBox2.isSelected();
/*     */   }
/*     */ 
/*     */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 279 */     updateToolbar();
/*     */   }
/*     */ 
/*     */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 283 */     int index = this.jComboBox2.getSelectedIndex();
/* 284 */     Toolbar t = (Toolbar)this.jComboBox1.getSelectedItem();
/* 285 */     if (index == 0) {
/* 286 */       t.horizontal = true;
/* 287 */       t.first = true;
/*     */     }
/* 289 */     if (index == 1) {
/* 290 */       t.horizontal = true;
/* 291 */       t.first = false;
/*     */     }
/* 293 */     if (index == 2) {
/* 294 */       t.horizontal = false;
/* 295 */       t.first = true;
/*     */     }
/* 297 */     if (index == 3) {
/* 298 */       t.horizontal = false;
/* 299 */       t.first = false;
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 304 */     int index = this.jList1.getSelectedIndex();
/* 305 */     if (index <= 0)
/* 306 */       return;
/* 307 */     Toolbar t = (Toolbar)this.jComboBox1.getSelectedItem();
/* 308 */     ToolbarItem before = (ToolbarItem)t.items.get(index - 1);
/* 309 */     ToolbarItem self = (ToolbarItem)t.items.get(index);
/* 310 */     t.items.set(index - 1, self);
/* 311 */     t.items.set(index, before);
/* 312 */     updateToolbar();
/* 313 */     this.jList1.setSelectedIndex(index - 1);
/*     */   }
/*     */ 
/*     */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 317 */     int index = this.jList1.getSelectedIndex();
/* 318 */     Toolbar t = (Toolbar)this.jComboBox1.getSelectedItem();
/* 319 */     t.items.trimToSize();
/* 320 */     if (index >= t.items.size())
/* 321 */       return;
/* 322 */     ToolbarItem after = (ToolbarItem)t.items.get(index + 1);
/* 323 */     ToolbarItem self = (ToolbarItem)t.items.get(index);
/* 324 */     t.items.set(index + 1, self);
/* 325 */     t.items.set(index, after);
/* 326 */     updateToolbar();
/* 327 */     this.jList1.setSelectedIndex(index + 1);
/*     */   }
/*     */ 
/*     */   private void jButton8ActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 335 */     Toolbar t = (Toolbar)this.jComboBox1.getSelectedItem();
/* 336 */     if (t != null) {
/* 337 */       ToolbarManager.toolbars.remove(t);
/* 338 */       updateToolbar();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 343 */     String name = JOptionPane.showInputDialog(this, "Toolbar name", "untitled");
/* 344 */     if (name == null)
/* 345 */       return;
/* 346 */     Toolbar t = new Toolbar();
/* 347 */     t.name = name;
/* 348 */     ToolbarManager.toolbars.add(t);
/* 349 */     updateToolbar();
/* 350 */     this.jComboBox1.setSelectedIndex(ToolbarManager.toolbars.indexOf(t));
/*     */   }
/*     */ 
/*     */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 354 */     Toolbar t = (Toolbar)this.jComboBox1.getSelectedItem();
/* 355 */     if (t == null)
/* 356 */       return;
/* 357 */     ToolbarItem item = (ToolbarItem)this.jList2.getSelectedValue();
/* 358 */     t.items.add(item);
/* 359 */     updateToolbar();
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 363 */     Toolbar t = (Toolbar)this.jComboBox1.getSelectedItem();
/* 364 */     if (t == null)
/* 365 */       return;
/* 366 */     ToolbarItem item = (ToolbarItem)this.jList2.getSelectedValue();
/* 367 */     if (item == null)
/* 368 */       return;
/* 369 */     t.items.remove(item);
/* 370 */     updateToolbar();
/*     */   }
/*     */ 
/*     */   private void jList1ValueChanged(ListSelectionEvent evt) {
/* 374 */     updateToolItem();
/*     */   }
/*     */ 
/*     */   private void jCheckBox3ActionPerformed(ActionEvent evt) {
/* 378 */     ToolbarItem item = (ToolbarItem)this.jList1.getSelectedValue();
/* 379 */     if ((item == null) || ((item instanceof ToolbarSeparator)))
/* 380 */       return;
/* 381 */     ((ToolbarButton)item).setTextVisible(this.jCheckBox3.isSelected());
/*     */   }
/*     */ 
/*     */   private void jCheckBox4ActionPerformed(ActionEvent evt) {
/* 385 */     ToolbarItem item = (ToolbarItem)this.jList1.getSelectedValue();
/* 386 */     if ((item == null) || ((item instanceof ToolbarSeparator)))
/* 387 */       return;
/* 388 */     ((ToolbarButton)item).setImageVisible(this.jCheckBox4.isSelected());
/*     */   }
/*     */ 
/*     */   private void jCheckBox5ActionPerformed(ActionEvent evt) {
/* 392 */     ToolbarItem item = (ToolbarItem)this.jList1.getSelectedValue();
/* 393 */     if ((item == null) || ((item instanceof ToolbarSeparator)))
/* 394 */       return;
/* 395 */     ((ToolbarButton)item).setBold(this.jCheckBox5.isSelected());
/*     */   }
/*     */ 
/*     */   public void updateToolbar() {
/* 399 */     Toolbar t = (Toolbar)this.jComboBox1.getSelectedItem();
/* 400 */     if (t == null) {
/* 401 */       this.jCheckBox1.setSelected(false);
/* 402 */       this.jCheckBox2.setSelected(false);
/* 403 */       this.jCheckBox1.setEnabled(false);
/* 404 */       this.jCheckBox2.setEnabled(false);
/* 405 */       this.jComboBox2.setEnabled(false);
/* 406 */       this.jList1.setModel(new VectorListModel(new Vector()));
/* 407 */       this.jList1.setEnabled(false);
/* 408 */       this.jButton5.setEnabled(false);
/* 409 */       this.jButton8.setEnabled(false);
/* 410 */       return;
/*     */     }
/* 412 */     this.jCheckBox1.setEnabled(true);
/* 413 */     this.jCheckBox2.setEnabled(true);
/* 414 */     this.jComboBox2.setEnabled(true);
/* 415 */     this.jButton5.setEnabled(true);
/* 416 */     this.jButton8.setEnabled(true);
/* 417 */     this.jCheckBox1.setSelected(t.floatable);
/* 418 */     this.jCheckBox2.setSelected(t.rollover);
/* 419 */     if ((t.first) && (t.horizontal))
/* 420 */       this.jComboBox2.setSelectedIndex(0);
/* 421 */     if ((!t.first) && (t.horizontal))
/* 422 */       this.jComboBox2.setSelectedIndex(1);
/* 423 */     if ((t.first) && (!t.horizontal))
/* 424 */       this.jComboBox2.setSelectedIndex(2);
/* 425 */     if ((!t.first) && (!t.horizontal))
/* 426 */       this.jComboBox2.setSelectedIndex(3);
/* 427 */     this.jList1.setEnabled(true);
/* 428 */     this.jList1.setModel(new VectorListModel(t.items));
/* 429 */     if (t.items.size() == 0)
/* 430 */       this.jList1.setSelectedIndex(-1);
/*     */     else
/* 432 */       this.jList1.setSelectedIndex(0);
/* 433 */     updateToolItem();
/*     */   }
/*     */ 
/*     */   public void updateToolItem() {
/* 437 */     ToolbarItem item = (ToolbarItem)this.jList1.getSelectedValue();
/* 438 */     if ((item == null) || ((item instanceof ToolbarSeparator))) {
/* 439 */       this.jCheckBox3.setSelected(false);
/* 440 */       this.jCheckBox4.setSelected(false);
/* 441 */       this.jCheckBox3.setEnabled(false);
/* 442 */       this.jCheckBox4.setEnabled(false);
/* 443 */       this.jCheckBox5.setEnabled(false);
/* 444 */       this.jCheckBox5.setSelected(false);
/* 445 */       return;
/*     */     }
/* 447 */     this.jCheckBox3.setEnabled(true);
/* 448 */     this.jCheckBox4.setEnabled(true);
/* 449 */     this.jCheckBox5.setEnabled(true);
/* 450 */     this.jCheckBox3.setSelected(((ToolbarButton)item).isTextVisible());
/* 451 */     this.jCheckBox4.setSelected(((ToolbarButton)item).isImageVisible());
/* 452 */     this.jCheckBox5.setSelected(((ToolbarButton)item).isBold());
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.ToolbarEditor
 * JD-Core Version:    0.6.2
 */