/*    */ package org.gcreator.core;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Toolkit;
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JProgressBar;
/*    */ 
/*    */ public class SplashScreen extends JFrame
/*    */ {
/* 19 */   public static String message = "Loading...";
/*    */   ImageIcon i;
/*    */   private JProgressBar jProgress1;
/*    */ 
/*    */   public SplashScreen(boolean applet)
/*    */   {
/* 24 */     this.jProgress1 = new JProgressBar();
/*    */ 
/* 27 */     setTitle("Loading... Please Wait");
/* 28 */     if (!applet) {
/* 29 */       setAlwaysOnTop(true);
/*    */     }
/* 31 */     setResizable(false);
/* 32 */     setUndecorated(true);
/*    */ 
/* 34 */     this.i = new ImageIcon(getClass().getResource("/org/gcreator/resources/splashscreen20tf0.jpg"));
/*    */ 
/* 36 */     JPanel p = new JPanel() {
/*    */       public void paint(Graphics g) {
/* 38 */         g.drawImage(SplashScreen.this.i.getImage(), 0, 0, SplashScreen.this.i.getImageObserver());
/*    */ 
/* 40 */         g.setColor(Color.GRAY);
/* 41 */         g.drawString(SplashScreen.message, 5, 260);
/*    */ 
/* 43 */         setOpaque(false);
/* 44 */         super.paint(g);
/*    */       }
/*    */     };
/* 47 */     p.setVisible(true);
/* 48 */     setContentPane(p);
/*    */ 
/* 50 */     setLayout(null);
/*    */ 
/* 53 */     setSize(this.i.getIconWidth(), this.i.getIconHeight());
/* 54 */     add(this.jProgress1);
/* 55 */     this.jProgress1.setSize(getWidth(), 20);
/* 56 */     this.jProgress1.setLocation(0, 220);
/* 57 */     this.jProgress1.setVisible(true);
/* 58 */     this.jProgress1.setIndeterminate(true);
/* 59 */     Dimension m = Toolkit.getDefaultToolkit().getScreenSize();
/* 60 */     setLocation((m.width - getWidth()) / 2, (m.height - getHeight()) / 2);
/*    */ 
/* 63 */     addMouseListener(new MouseListener() {
/*    */       public void mouseExited(MouseEvent evt) {
/*    */       }
/*    */       public void mouseEntered(MouseEvent evt) {  } 
/* 67 */       public void mouseClicked(MouseEvent evt) { SplashScreen.this.setVisible(false); }
/*    */ 
/*    */       public void mouseReleased(MouseEvent evt) {
/* 70 */         SplashScreen.this.setVisible(false);
/*    */       }
/*    */       public void mousePressed(MouseEvent evt) {
/* 73 */         SplashScreen.this.setVisible(false);
/*    */       }
/*    */     });
/* 76 */     setVisible(true);
/*    */   }
/*    */ 
/*    */   public void dispose() {
/* 80 */     super.dispose();
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.core.SplashScreen
 * JD-Core Version:    0.6.2
 */