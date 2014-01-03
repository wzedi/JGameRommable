/*     */ package org.gcreator.components;
/*     */ 
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.event.ActionEvent;

/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JPanel;

/*     */ import org.gcreator.managers.LangSupporter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GameProjects extends JPanel
/*     */ {
/*     */   private ProjectTypes ptypes;
/*     */   public int tnum;
/*     */   private JButton jButton1;
/*     */   //private JButton jButton2;
/*     */   //private JButton jButton3;
/*     */   //private JButton jButton4;
/*     */ 
/*     */   public int getSelectedProject()
/*     */   {
/*  26 */     //if (this.jButton1.isSelected())
/*  27 */       //return 0;
/*  28 */     //if (this.jButton2.isSelected())
/*  29 */       //return 1;
/*  30 */     //if (this.jButton3.isSelected())
/*  31 */       //return 2;
/*  32 */     //if (this.jButton4.isSelected())
/*  33 */       //return 3;
/*  34 */     //return -1;
	          return 0;
/*     */   }
/*     */ 
/*     */   public GameProjects(ProjectTypes ptypes)
/*     */   {
/*  39 */     this.ptypes = ptypes;
/*  40 */     initComponents();
/*  41 */     this.jButton1.setText(LangSupporter.activeLang.getEntry(58));
/*  42 */     //ptypes.npro.ProjectButtons.add(this.jButton1);
/*  43 */     //ptypes.npro.ProjectButtons.add(this.jButton2);
/*  44 */     //ptypes.npro.ProjectButtons.add(this.jButton3);
/*  45 */     //ptypes.npro.ProjectButtons.add(this.jButton4);
/*     */   }
/*     */ 
/*     */   public void add(JComponent c) {
/*  49 */     GridLayout g = (GridLayout)getLayout();
/*     */ 
/*  51 */     if (getComponentCount() > 5)
/*  52 */       g.setRows(g.getRows() + 1);
/*  53 */     super.add(c);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  58 */     this.jButton1 = new JButton();
/*  59 */     //this.jButton2 = new JButton();
/*  60 */     //this.jButton3 = new JButton();
/*  61 */     //this.jButton4 = new JButton();
/*     */ 
/*  63 */     //this.jButton1.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/toolbar/new_game.png")));
/*  64 */     this.jButton1.setText("Empty Game");
/*  65 */     //this.jButton1.addActionListener(new ActionListener() {
/*     */       //public void actionPerformed(ActionEvent evt) {
/*  67 */         //GameProjects.this.jButton1ActionPerformed(evt);
/*     */       //}
/*     */     //});
/*  70 */     //this.jButton2.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/toolbar/new_rpg.png")));
/*  71 */     //this.jButton2.setText("RPG Game");
/*  72 */     //this.jButton2.addActionListener(new ActionListener() {
/*     */       //public void actionPerformed(ActionEvent evt) {
/*  74 */         //GameProjects.this.jButton2ActionPerformed(evt);
/*     */       //}
/*     */     //});
/*  77 */     //this.jButton3.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/toolbar/new_platform.png")));
/*  78 */     //this.jButton3.setText("Platform Game");
/*  79 */     //this.jButton3.addActionListener(new ActionListener() {
/*     */       //public void actionPerformed(ActionEvent evt) {
/*  81 */         //GameProjects.this.jButton3ActionPerformed(evt);
/*     */       //}
/*     */     //});
/*  84 */     //this.jButton4.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/toolbar/new_airbattle.png")));
/*  85 */     //this.jButton4.setText("Air Battle");
/*  86 */     //this.jButton4.addActionListener(new ActionListener() {
/*     */       //public void actionPerformed(ActionEvent evt) {
/*  88 */         //GameProjects.this.jButton4ActionPerformed(evt);
/*     */       //}
/*     */     //});
/*  92 */     setLayout(new GridLayout(5, 1));
/*  93 */     //add(this.jButton1);
/*  94 */     //add(this.jButton2);
/*  95 */     //add(this.jButton3);
/*  96 */     //add(this.jButton4);
              GameProjects.this.jButton1ActionPerformed(null);
/*     */   }
/*     */ 
/*     */   public void setButton(int sel)
/*     */   {
/* 109 */     this.ptypes.npro.uncheckAll();
/* 110 */     //if (sel == 1)
/* 111 */       //this.jButton1.setSelected(true);
/* 112 */     //else if (sel == 2)
/* 113 */       //this.jButton2.setSelected(true);
/* 114 */     //else if (sel == 3)
/* 115 */       //this.jButton3.setSelected(true);
/* 116 */     //else if (sel == 4)
/* 117 */       //this.jButton4.setSelected(true);
/*     */   }
/*     */ 
/*     */   public void turnOff() {
/* 121 */     setButton(0);
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 125 */     setButton(1);
/* 126 */     String str = this.jButton1.getText().replaceAll("\\s", "_").replaceAll("[\\.:?^(){}]", "").replaceAll("(\\[|\\])", "") + "1";
/*     */ 
/* 131 */     if (str.charAt(0) == '1')
/* 132 */       str = "p1";
/* 133 */     this.ptypes.npro.jTextField1.setText(str);
/*     */   }
/*     */ 
/*     */   //private void jButton2ActionPerformed(ActionEvent evt) {
/* 137 */     //setButton(2);
/* 138 */     //String str = this.jButton2.getText().replaceAll("\\s", "_").replaceAll("[\\.:?^(){}]", "").replaceAll("(\\[|\\])", "") + "1";
/*     */ 
/* 143 */     //if (str.charAt(0) == '1')
/* 144 */       //str = "p1";
/* 145 */     //this.ptypes.npro.jTextField1.setText(str);
/*     */   //}
/*     */ 
/*     */   //private void jButton3ActionPerformed(ActionEvent evt) {
/* 149 */     //setButton(3);
/* 150 */     //String str = this.jButton3.getText().replaceAll("\\s", "_").replaceAll("[\\.:?^(){}]", "").replaceAll("(\\[|\\])", "") + "1";
/*     */ 
/* 155 */     //if (str.charAt(0) == '1')
/* 156 */       //str = "p1";
/* 157 */     //this.ptypes.npro.jTextField1.setText(str);
/*     */   //}
/*     */ 
/*     */   //private void jButton4ActionPerformed(ActionEvent evt) {
/* 161 */     //setButton(4);
/* 162 */     //String str = this.jButton4.getText().replaceAll("\\s", "_").replaceAll("[\\.:?^(){}]", "").replaceAll("(\\[|\\])", "") + "1";
/*     */ 
/* 167 */     //if (str.charAt(0) == '1')
/* 168 */       //str = "p1";
/* 169 */     //this.ptypes.npro.jTextField1.setText(str);
/*     */   //}
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.GameProjects
 * JD-Core Version:    0.6.2
 */