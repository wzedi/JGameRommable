/*    */ package org.gcreator.components;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
/*    */ import java.awt.Graphics;
/*    */ import javax.swing.BorderFactory;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JScrollPane;
/*    */ 
/*    */ public class RSSReadPanel extends JPanel
/*    */ {
/*    */   private JScrollPane jScrollPane1;
/*    */ 
/*    */   public RSSReadPanel()
/*    */   {
/* 21 */     initComponents();
/* 22 */     this.jScrollPane1.setViewportView(new RSSReader(""));
/*    */   }
/*    */ 
/*    */   public void paint(Graphics g)
/*    */   {
/* 27 */     super.paint(g);
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 38 */     this.jScrollPane1 = new JScrollPane();
/*    */ 
/* 40 */     setBorder(BorderFactory.createTitledBorder(null, "G-Creator News", 0, 0, new Font("Tahoma", 1, 11), new Color(255, 255, 255)));
/* 41 */     setOpaque(false);
/* 42 */     setLayout(new BorderLayout());
/*    */ 
/* 44 */     this.jScrollPane1.setVerticalScrollBarPolicy(22);
/* 45 */     this.jScrollPane1.setOpaque(false);
/* 46 */     add(this.jScrollPane1, "Center");
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.RSSReadPanel
 * JD-Core Version:    0.6.2
 */