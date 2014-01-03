/*     */ package org.gcreator.components;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import javax.swing.AbstractButton;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.ButtonModel;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.plaf.basic.BasicButtonUI;
/*     */ import org.gcreator.core.gcreator;
/*     */ 
/*     */ public class ButtonTabComponent extends JPanel
/*     */ {
/*     */   private final JTabbedPane pane;
/*  16 */   public static ImageIcon close = new ImageIcon(ButtonTabComponent.class.getResource("/org/gcreator/resources/close.png"));
/*  17 */   public static ImageIcon closehover = new ImageIcon(ButtonTabComponent.class.getResource("/org/gcreator/resources/closehover.png"));
/*  18 */   public static ImageIcon closepressed = new ImageIcon(ButtonTabComponent.class.getResource("/org/gcreator/resources/closepressed.png"));
/*     */ 
/* 135 */   private MouseListener buttonMouseListener = new MouseAdapter() {
/*     */     public void mouseEntered(MouseEvent e) {
/* 137 */       ButtonTabComponent.this.hover();
/* 138 */       Component component = e.getComponent();
/* 139 */       if ((component instanceof AbstractButton)) {
/* 140 */         AbstractButton button = (AbstractButton)component;
/* 141 */         button.setBorderPainted(true);
/*     */       }
/*     */     }
/*     */ 
/*     */     public void mouseExited(MouseEvent e) {
/* 146 */       ButtonTabComponent.this.out();
/* 147 */       Component component = e.getComponent();
/* 148 */       if ((component instanceof AbstractButton)) {
/* 149 */         AbstractButton button = (AbstractButton)component;
/* 150 */         button.setBorderPainted(false);
/*     */       }
/*     */     }
/* 135 */   };
/*     */ 
/*     */   public ButtonTabComponent(final JTabbedPane pane)
/*     */   {
/*  22 */     super(new FlowLayout(0, 0, 0));
/*  23 */     if (pane == null) {
/*  24 */       throw new NullPointerException("TabbedPane is null");
/*     */     }
/*  26 */     this.pane = pane;
/*  27 */     setOpaque(false);
/*     */ 
/*  30 */     JLabel label = new JLabel() {
/*     */       public String getText() {
/*  32 */         int ver = Integer.parseInt(gcreator.getJavaVersion().replaceAll("1\\.([0-9])\\..*", "$1"));
/*  33 */         if (ver >= 6) {
/*  34 */           int i = pane.indexOfTabComponent(ButtonTabComponent.this);
/*  35 */           if (i != -1) {
/*  36 */             return pane.getTitleAt(i);
/*     */           }
/*     */         }
/*  39 */         return null;
/*     */       }
/*     */       public Icon getIcon() {
/*  42 */         int ver = Integer.parseInt(gcreator.getJavaVersion().replaceAll("1\\.([0-9])\\..*", "$1"));
/*  43 */         if (ver >= 6) {
/*  44 */           int i = pane.indexOfTabComponent(ButtonTabComponent.this);
/*  45 */           if (i != -1) {
/*  46 */             return pane.getIconAt(i);
/*     */           }
/*     */         }
/*  49 */         return null;
/*     */       }
/*     */     };
/*  53 */     add(label);
/*     */ 
/*  55 */     label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
/*     */ 
/*  57 */     TabButton button = new TabButton();
/*  58 */     button.addActionListener(button);
/*  59 */     add(button);
/*     */ 
/*  61 */     setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
/*     */   }
/*     */   public void hover() {
/*     */   }
/*     */   public void out() {  } 
/*  66 */   private class TabButton extends JButton implements ActionListener { public TabButton() { int size = 17;
/*  67 */       setPreferredSize(new Dimension(size, size));
/*  68 */       setToolTipText("Close this tab");
/*     */ 
/*  70 */       setUI(new BasicButtonUI());
/*     */ 
/*  72 */       setContentAreaFilled(false);
/*     */ 
/*  74 */       setFocusable(false);
/*  75 */       setBorder(BorderFactory.createEtchedBorder());
/*  76 */       setBorderPainted(true);
/*  77 */       setBorder(null);
/*     */ 
/*  80 */       addMouseListener(ButtonTabComponent.this.buttonMouseListener);
/*  81 */       setRolloverEnabled(true);
/*     */     }
/*     */ 
/*     */     public void actionPerformed(ActionEvent e)
/*     */     {
/*  86 */       int ver = Integer.parseInt(gcreator.getJavaVersion().replaceAll("1\\.([0-9])\\..*", "$1"));
/*  87 */       if (ver >= 6) {
/*  88 */         int i = ButtonTabComponent.this.pane.indexOfTabComponent(ButtonTabComponent.this);
/*  89 */         if (i != -1) {
/*  90 */           TabPanel panel = (TabPanel)ButtonTabComponent.this.pane.getComponentAt(i);
/*  91 */           panel.dispose();
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*     */     public void updateUI()
/*     */     {
/*     */     }
/*     */ 
/*     */     protected void paintComponent(Graphics g)
/*     */     {
/* 102 */       super.paintComponent(g);
/* 103 */       Graphics2D g2 = (Graphics2D)g.create();
/*     */ 
/* 111 */       if (getModel().isPressed()) {
/* 112 */         g2.translate(1, 1);
/*     */       }
/* 114 */       if (getModel().isRollover())
/* 115 */         setBorder(BorderFactory.createEtchedBorder());
/*     */       else
/* 117 */         setBorder(null);
/* 118 */       g2.setStroke(new BasicStroke(2.0F));
/* 119 */       g2.setColor(Color.BLACK);
/* 120 */       int delta = 6;
/* 121 */       g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight() - delta - 1);
/* 122 */       g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight() - delta - 1);
/*     */ 
/* 124 */       g2.dispose();
/*     */     }
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.ButtonTabComponent
 * JD-Core Version:    0.6.2
 */