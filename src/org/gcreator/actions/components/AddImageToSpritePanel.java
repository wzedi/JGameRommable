/*    */ package org.gcreator.actions.components;
/*    */ 
/*    */ import javax.swing.DefaultComboBoxModel;
/*    */ import javax.swing.JComboBox;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JTextField;
/*    */ import org.gcreator.managers.LangSupporter;
/*    */ import org.gcreator.units.Dictionary;
/*    */ import org.jdesktop.layout.GroupLayout;
/*    */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*    */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*    */ 
/*    */ public class AddImageToSpritePanel extends JPanel
/*    */ {
/*    */   public JTextField Sprite;
/*    */   public JTextField URL;
/*    */   public JComboBox fails1;
/*    */   public JComboBox fails2;
/*    */   private JLabel jLabel1;
/*    */   private JLabel jLabel2;
/*    */   private JLabel jLabel3;
/*    */   private JLabel jLabel4;
/*    */   private JLabel jLabel5;
/*    */ 
/*    */   public AddImageToSpritePanel()
/*    */   {
/* 20 */     initComponents();
/*    */   }
/*    */ 
/*    */   public String[] retrieveComboModel() {
/* 24 */     return new String[] { LangSupporter.activeLang.getEntry(237), LangSupporter.activeLang.getEntry(238), LangSupporter.activeLang.getEntry(239) };
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 39 */     this.jLabel1 = new JLabel();
/* 40 */     this.URL = new JTextField();
/* 41 */     this.jLabel2 = new JLabel();
/* 42 */     this.jLabel3 = new JLabel();
/* 43 */     this.Sprite = new JTextField();
/* 44 */     this.jLabel4 = new JLabel();
/* 45 */     this.fails1 = new JComboBox();
/* 46 */     this.jLabel5 = new JLabel();
/* 47 */     this.fails2 = new JComboBox();
/*    */ 
/* 49 */     this.jLabel1.setText(LangSupporter.activeLang.getEntry(232));
/*    */ 
/* 51 */     this.URL.setText("\"\"");
/*    */ 
/* 53 */     this.jLabel2.setText("(" + LangSupporter.activeLang.getEntry(233) + ")");
/*    */ 
/* 55 */     this.jLabel3.setText(LangSupporter.activeLang.getEntry(234));
/*    */ 
/* 57 */     this.Sprite.setText("this.getSprite()");
/*    */ 
/* 59 */     this.jLabel4.setText(LangSupporter.activeLang.getEntry(235));
/*    */ 
/* 61 */     this.fails1.setModel(new DefaultComboBoxModel(retrieveComboModel()));
/*    */ 
/* 63 */     this.jLabel5.setText(LangSupporter.activeLang.getEntry(236));
/*    */ 
/* 65 */     this.fails2.setModel(new DefaultComboBoxModel(retrieveComboModel()));
/*    */ 
/* 67 */     GroupLayout layout = new GroupLayout(this);
/* 68 */     setLayout(layout);
/* 69 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(layout.createParallelGroup(1).add(this.jLabel1).add(layout.createSequentialGroup().add(this.jLabel5).add(18, 18, 18).add(this.fails2, 0, 428, 32767)).add(2, layout.createSequentialGroup().add(this.jLabel4).addPreferredGap(0).add(this.fails1, 0, 442, 32767)).add(layout.createSequentialGroup().add(this.jLabel3).addPreferredGap(0).add(this.Sprite, -1, 442, 32767))).addContainerGap()).add(layout.createSequentialGroup().add(this.URL, -1, 425, 32767).add(97, 97, 97)).add(layout.createSequentialGroup().add(this.jLabel2).addContainerGap(456, 32767)))));
/*    */ 
/* 97 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jLabel1).addPreferredGap(0).add(this.URL, -2, -1, -2).addPreferredGap(0).add(this.jLabel2).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jLabel3).add(this.Sprite, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.fails1, -2, -1, -2).add(this.jLabel4)).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jLabel5).add(this.fails2, -2, -1, -2)).addContainerGap()));
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.actions.components.AddImageToSpritePanel
 * JD-Core Version:    0.6.2
 */