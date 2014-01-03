/*    */ package org.gcreator.components;
/*    */ 
/*    */ import java.awt.event.MouseAdapter;
/*    */ import java.awt.event.MouseEvent;
/*    */ import javax.swing.JColorChooser;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ public class ColorSelection extends JPanel
/*    */ {
/*    */   public ColorSelection()
/*    */   {
/* 20 */     initComponents();
/*    */   }
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 31 */     addMouseListener(new MouseAdapter() {
/*    */       public void mouseClicked(MouseEvent evt) {
/* 33 */         ColorSelection.this.formMouseClicked(evt);
/*    */       }
/*    */     });
/*    */   }
/*    */ 
/*    */   private void formMouseClicked(MouseEvent evt) {
/* 39 */     setBackground(JColorChooser.showDialog(this, "Select a color", getBackground()));
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.ColorSelection
 * JD-Core Version:    0.6.2
 */