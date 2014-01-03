/*    */ package org.gcreator.autocomplete;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.event.FocusEvent;
/*    */ import java.awt.event.FocusListener;
/*    */ import javax.swing.JDialog;
/*    */ import javax.swing.JEditorPane;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JList;
/*    */ import javax.swing.JScrollPane;
/*    */ 
/*    */ public class AutocompleteFrame extends JDialog
/*    */ {
/*    */   protected JList list;
/*    */   protected JScrollPane scroll;
/*    */   protected JEditorPane doc;
/*    */ 
/*    */   public AutocompleteFrame(String text)
/*    */   {
/* 25 */     setUndecorated(true);
/* 26 */     addFocusListener(new FocusListener() {
/*    */       public void focusLost(FocusEvent evt) {
/* 28 */         AutocompleteFrame.this.dispose();
/*    */       }
/*    */ 
/*    */       public void focusGained(FocusEvent evt)
/*    */       {
/*    */       }
/*    */     });
/* 33 */     setSize(350, 180);
/* 34 */     setLayout(new BorderLayout());
/* 35 */     JLabel label = new JLabel(text);
/* 36 */     label.setFocusable(false);
/* 37 */     label.setVisible(true);
/* 38 */     add("North", label);
/* 39 */     setTitle(text);
/*    */ 
/* 41 */     this.scroll = new JScrollPane();
/* 42 */     this.scroll.setFocusable(false);
/* 43 */     this.scroll.setVisible(true);
/* 44 */     this.list = new JList();
/* 45 */     this.list.setFocusable(false);
/* 46 */     this.list.setVisible(true);
/* 47 */     this.scroll.setViewportView(this.list);
/* 48 */     add("Center", this.scroll);
/*    */ 
/* 50 */     this.doc = new JEditorPane();
/* 51 */     this.doc.setFocusable(false);
/* 52 */     this.doc.setVisible(true);
/* 53 */     this.doc.setEditable(false);
/* 54 */     this.doc.setContentType("text/html");
/* 55 */     JScrollPane p = new JScrollPane() {
/*    */       public Dimension getPreferredSize() {
/* 57 */         Dimension d = super.getPreferredSize();
/* 58 */         d.width = 180;
/* 59 */         return d;
/*    */       }
/*    */     };
/* 62 */     p.setVisible(true);
/* 63 */     p.setViewportView(this.doc);
/* 64 */     add("After", p);
/*    */   }
/*    */ 
/*    */   public boolean requestDie() {
/* 68 */     return false;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.autocomplete.AutocompleteFrame
 * JD-Core Version:    0.6.2
 */