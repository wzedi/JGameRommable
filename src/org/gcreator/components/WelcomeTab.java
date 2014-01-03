/*    */ package org.gcreator.components;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Graphics2D;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ import org.gcreator.managers.LangSupporter;
/*    */ import org.gcreator.units.Dictionary;
/*    */ import org.jdesktop.layout.GroupLayout;
/*    */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*    */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*    */ 
/*    */ public class WelcomeTab extends TabPanel
/*    */ {
/* 31 */   private ImageIcon i = new ImageIcon(WelcomeTab.class.getResource("/org/gcreator/resources/initgrad.png"));
/*    */   private JLabel jLabel1;
/*    */   private JLabel jLabel2;
/*    */   private RSSBlogReadPanel rSSBlogReadPanel1;
/*    */   private RSSBlogReadPanel rSSBlogReadPanel2;
/*    */   private RSSReadPanel rSSReadPanel1;
/*    */ 
/*    */   public WelcomeTab()
/*    */   {
/* 22 */     initComponents();
/* 23 */     this.jLabel1.setText(LangSupporter.activeLang.getEntry(37));
/* 24 */     this.jLabel2.setText(LangSupporter.activeLang.getEntry(38));
/*    */   }
/*    */ 
/*    */   public void paint(Graphics _g)
/*    */   {
/* 34 */     Graphics2D g = (Graphics2D)_g;
/*    */ 
/* 40 */     g.drawImage(this.i.getImage(), 0, 0, getWidth(), getHeight(), this.i.getImageObserver());
/* 41 */     super.paintChildren(g);
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 52 */     this.rSSBlogReadPanel1 = new RSSBlogReadPanel();
/* 53 */     this.jLabel1 = new JLabel();
/* 54 */     this.jLabel2 = new JLabel();
/* 55 */     this.rSSReadPanel1 = new RSSReadPanel();
/* 56 */     this.rSSBlogReadPanel2 = new RSSBlogReadPanel();
/*    */ 
/* 58 */     this.jLabel1.setForeground(new Color(255, 255, 255));
/* 59 */     this.jLabel1.setText("Welcome to Aurora,");
/*    */ 
/* 61 */     this.jLabel2.setForeground(new Color(255, 255, 255));
/* 62 */     this.jLabel2.setText("The Next Generation of G-Creator");
/*    */ 
/* 64 */     GroupLayout layout = new GroupLayout(this);
/* 65 */     setLayout(layout);
/* 66 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(layout.createParallelGroup(1).add(this.jLabel1).add(this.jLabel2)).addPreferredGap(0, 23, 32767).add(this.rSSReadPanel1, -2, -1, -2)).add(2, this.rSSBlogReadPanel2, -1, 622, 32767)).addContainerGap()));
/*    */ 
/* 80 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(this.jLabel1).addPreferredGap(0).add(this.jLabel2)).add(this.rSSReadPanel1, -1, 322, 32767)).addPreferredGap(0).add(this.rSSBlogReadPanel2, -2, 170, -2).addContainerGap()));
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.WelcomeTab
 * JD-Core Version:    0.6.2
 */