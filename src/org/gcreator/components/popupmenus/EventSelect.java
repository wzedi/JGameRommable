/*     */ package org.gcreator.components.popupmenus;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.Frame;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import org.gcreator.components.impl.EventSelectListener;
/*     */ import org.gcreator.editors.ActorEditor;
/*     */ import org.jdesktop.layout.GroupLayout;
/*     */ import org.jdesktop.layout.GroupLayout.ParallelGroup;
/*     */ import org.jdesktop.layout.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class EventSelect extends JDialog
/*     */ {
/*     */   EventSelectListener listener;
/*     */   ActorEditor ae;
/*     */   private JButton jButton1;
/*     */   private JButton jButton10;
/*     */   private JButton jButton11;
/*     */   private JButton jButton12;
/*     */   private JButton jButton2;
/*     */   private JButton jButton3;
/*     */   private JButton jButton4;
/*     */   private JButton jButton5;
/*     */   private JButton jButton6;
/*     */   private JButton jButton7;
/*     */   private JButton jButton8;
/*     */   private JButton jButton9;
/*     */ 
/*     */   public EventSelect(ActorEditor ae, Frame parent, boolean modal, int x, int y, EventSelectListener listener)
/*     */   {
/*  19 */     super(parent, modal);
/*  20 */     this.ae = ae;
/*  21 */     this.listener = listener;
/*  22 */     initComponents();
/*  23 */     setLocation(x, y);
/*  24 */     setVisible(true);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  35 */     this.jButton12 = new JButton();
/*  36 */     this.jButton10 = new JButton();
/*  37 */     this.jButton8 = new JButton();
/*  38 */     this.jButton7 = new JButton();
/*  39 */     this.jButton6 = new JButton();
/*  40 */     this.jButton5 = new JButton();
/*  41 */     this.jButton1 = new JButton();
/*  42 */     this.jButton2 = new JButton();
/*  43 */     this.jButton3 = new JButton();
/*  44 */     this.jButton4 = new JButton();
/*  45 */     this.jButton9 = new JButton();
/*  46 */     this.jButton11 = new JButton();
/*     */ 
/*  48 */     setDefaultCloseOperation(2);
/*  49 */     setTitle("Select an event");
/*  50 */     setResizable(false);
/*     */ 
/*  52 */     this.jButton12.setText("Cancel");
/*  53 */     this.jButton12.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  55 */         EventSelect.this.jButton12ActionPerformed(evt);
/*     */       }
/*     */     });
/*  59 */     this.jButton10.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/events/alarm.png")));
/*  60 */     this.jButton10.setText("Alarm");
/*  61 */     this.jButton10.addMouseListener(new MouseAdapter() {
/*     */       public void mouseReleased(MouseEvent evt) {
/*  63 */         EventSelect.this.jButton10MouseReleased(evt);
/*     */       }
/*     */     });
/*  66 */     this.jButton10.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  68 */         EventSelect.this.jButton10ActionPerformed(evt);
/*     */       }
/*     */     });
/*  72 */     this.jButton8.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/events/key_release.png")));
/*  73 */     this.jButton8.setText("Key release");
/*  74 */     this.jButton8.addMouseListener(new MouseAdapter() {
/*     */       public void mouseReleased(MouseEvent evt) {
/*  76 */         EventSelect.this.jButton8MouseReleased(evt);
/*     */       }
/*     */     });
/*  80 */     this.jButton7.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/events/key_press.png")));
/*  81 */     this.jButton7.setText("Key press");
/*  82 */     this.jButton7.addMouseListener(new MouseAdapter() {
/*     */       public void mouseReleased(MouseEvent evt) {
/*  84 */         EventSelect.this.jButton7MouseReleased(evt);
/*     */       }
/*     */     });
/*  88 */     this.jButton6.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/events/keyboard.png")));
/*  89 */     this.jButton6.setText("Keyboard");
/*  90 */     this.jButton6.addMouseListener(new MouseAdapter() {
/*     */       public void mouseReleased(MouseEvent evt) {
/*  92 */         EventSelect.this.jButton6MouseReleased(evt);
/*     */       }
/*     */     });
/*  95 */     this.jButton6.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  97 */         EventSelect.this.jButton6ActionPerformed(evt);
/*     */       }
/*     */     });
/* 101 */     this.jButton5.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/events/mouse.png")));
/* 102 */     this.jButton5.setText("Mouse");
/* 103 */     this.jButton5.addMouseListener(new MouseAdapter() {
/*     */       public void mouseReleased(MouseEvent evt) {
/* 105 */         EventSelect.this.jButton5MouseReleased(evt);
/*     */       }
/*     */     });
/* 109 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/events/create.png")));
/* 110 */     this.jButton1.setText("Create");
/* 111 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 113 */         EventSelect.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 117 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/events/destroy.png")));
/* 118 */     this.jButton2.setText("Destroy");
/* 119 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 121 */         EventSelect.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 125 */     this.jButton3.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/events/step.png")));
/* 126 */     this.jButton3.setText("Step");
/* 127 */     this.jButton3.addMouseListener(new MouseAdapter() {
/*     */       public void mousePressed(MouseEvent evt) {
/* 129 */         EventSelect.this.jButton3MousePressed(evt);
/*     */       }
/*     */       public void mouseReleased(MouseEvent evt) {
/* 132 */         EventSelect.this.jButton3MouseReleased(evt);
/*     */       }
/*     */     });
/* 136 */     this.jButton4.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/events/draw.png")));
/* 137 */     this.jButton4.setText("Draw");
/* 138 */     this.jButton4.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 140 */         EventSelect.this.jButton4ActionPerformed(evt);
/*     */       }
/*     */     });
/* 144 */     this.jButton9.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/events/collision.png")));
/* 145 */     this.jButton9.setText("Collision");
/* 146 */     this.jButton9.addMouseListener(new MouseAdapter() {
/*     */       public void mouseReleased(MouseEvent evt) {
/* 148 */         EventSelect.this.jButton9MouseReleased(evt);
/*     */       }
/*     */     });
/* 152 */     this.jButton11.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/events/other.png")));
/* 153 */     this.jButton11.setText("Other");
/*     */ 
/* 155 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 156 */     getContentPane().setLayout(layout);
/* 157 */     layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(this.jButton2, -1, 117, 32767).add(this.jButton1, -1, 117, 32767).add(this.jButton11, -1, 117, 32767).add(this.jButton9, -1, 117, 32767).add(this.jButton4, -1, 117, 32767).add(this.jButton3, -1, 117, 32767)).addPreferredGap(0).add(layout.createParallelGroup(1).add(this.jButton5, -1, 130, 32767).add(this.jButton12, -1, 130, 32767).add(2, this.jButton6, -1, 130, 32767).add(this.jButton8, -1, 130, 32767).add(this.jButton10, -1, 130, 32767).add(this.jButton7, -1, 130, 32767)).addContainerGap()));
/*     */ 
/* 178 */     layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(3).add(this.jButton1).add(this.jButton5, -2, 41, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jButton2).add(this.jButton6, -2, 41, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jButton7).add(this.jButton3)).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jButton4).add(this.jButton8)).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jButton9).add(this.jButton10)).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.jButton11).add(this.jButton12, -2, 41, -2)).addContainerGap(-1, 32767)));
/*     */ 
/* 208 */     pack();
/*     */   }
/*     */ 
/*     */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 212 */     dispose();
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 216 */     callEvent(1000);
/* 217 */     dispose();
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 221 */     callEvent(2000);
/* 222 */     dispose();
/*     */   }
/*     */ 
/*     */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 226 */     callEvent(4005);
/* 227 */     dispose();
/*     */   }
/*     */ 
/*     */   private void jButton3MousePressed(MouseEvent evt) {
/* 231 */     StepListPopup steps = new StepListPopup(this);
/* 232 */     steps.show(this.jButton3, evt.getX(), evt.getY());
/*     */   }
/*     */ 
/*     */   private void jButton3MouseReleased(MouseEvent evt) {
/* 236 */     jButton3MousePressed(evt);
/*     */   }
/*     */ 
/*     */   private void jButton5MouseReleased(MouseEvent evt) {
/* 240 */     MouseListPopup kb = new MouseListPopup(this);
/* 241 */     kb.show(this.jButton5, evt.getX(), evt.getY());
/*     */   }
/*     */ 
/*     */   private void jButton6ActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jButton6MouseReleased(MouseEvent evt) {
/* 249 */     KeyboardListPopup kb = new KeyboardListPopup(this, 6000);
/* 250 */     kb.show(this.jButton6, evt.getX(), evt.getY());
/*     */   }
/*     */ 
/*     */   private void jButton7MouseReleased(MouseEvent evt) {
/* 254 */     KeyboardListPopup kb = new KeyboardListPopup(this, 8000);
/* 255 */     kb.show(this.jButton7, evt.getX(), evt.getY());
/*     */   }
/*     */ 
/*     */   private void jButton8MouseReleased(MouseEvent evt) {
/* 259 */     KeyboardListPopup kb = new KeyboardListPopup(this, 9000);
/* 260 */     kb.show(this.jButton8, evt.getX(), evt.getY());
/*     */   }
/*     */ 
/*     */   private void jButton10ActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   private void jButton10MouseReleased(MouseEvent evt) {
/* 268 */     AlarmListPopup alarm = new AlarmListPopup(this);
/* 269 */     alarm.show(this.jButton10, evt.getX(), evt.getY());
/*     */   }
/*     */ 
/*     */   private void jButton9MouseReleased(MouseEvent evt) {
/* 273 */     CollisionListPopup col = new CollisionListPopup(this, "actor");
/* 274 */     col.show(this.jButton9, evt.getX(), evt.getY());
/*     */   }
/*     */ 
/*     */   public void callEvent(int type) {
/* 278 */     if (this.listener != null)
/* 279 */       this.listener.eventSelected(type, "");
/*     */   }
/*     */ 
/*     */   public void callEvent(int type, String name) {
/* 283 */     if (this.listener != null)
/* 284 */       this.listener.eventSelected(type, name);
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.popupmenus.EventSelect
 * JD-Core Version:    0.6.2
 */