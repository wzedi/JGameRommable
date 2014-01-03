/*    */ package org.gcreator.components.uiplus;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.util.Vector;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ public class DiscMenuContainer extends DiscMenuItem
/*    */ {
/*    */   private Vector<DiscMenuItem> items;
/* 18 */   public DiscMenuContainer prevcontainer = null;
/*    */ 
/* 20 */   public DiscMenuContainer(String label, ImageIcon image) { super(label, image);
/* 21 */     this.items = new Vector(); }
/*    */ 
/*    */   public void add(DiscMenuItem item)
/*    */   {
/* 25 */     this.items.add(item);
/*    */   }
/*    */ 
/*    */   public int count() {
/* 29 */     this.items.trimToSize();
/* 30 */     return this.items.capacity();
/*    */   }
/*    */ 
/*    */   public DiscMenuItem elementAt(int i) {
/* 34 */     return (DiscMenuItem)this.items.elementAt(i);
/*    */   }
/*    */ 
/*    */   protected void actionPerformed(ActionEvent evt, boolean back) {
/* 38 */     super.actionPerformed(evt, back);
/*    */ 
/* 40 */     Object o = evt.getSource();
/* 41 */     if ((o instanceof DiscMenu)) {
/* 42 */       if (!back)
/* 43 */         this.prevcontainer = ((DiscMenu)o).curcontainer;
/* 44 */       ((DiscMenu)o).curcontainer = this;
/* 45 */       ((DiscMenu)o).repaint();
/*    */     }
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.uiplus.DiscMenuContainer
 * JD-Core Version:    0.6.2
 */