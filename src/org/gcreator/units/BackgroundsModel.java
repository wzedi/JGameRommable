/*    */ package org.gcreator.units;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Vector;
/*    */ import javax.swing.AbstractListModel;
/*    */ 
/*    */ public class BackgroundsModel extends AbstractListModel
/*    */   implements Serializable
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/*    */   public Vector<BackgroundInScene> view;
/*    */ 
/*    */   public BackgroundsModel(Vector<BackgroundInScene> view)
/*    */   {
/* 25 */     this.view = view;
/* 26 */     if (view.size() == 0) {
/* 27 */       view.add(new BackgroundInScene("Background 0"));
/* 28 */       view.add(new BackgroundInScene("Background 1"));
/* 29 */       view.add(new BackgroundInScene("Background 2"));
/* 30 */       view.add(new BackgroundInScene("Background 3"));
/* 31 */       view.add(new BackgroundInScene("Background 4"));
/* 32 */       view.add(new BackgroundInScene("Background 5"));
/* 33 */       view.add(new BackgroundInScene("Background 6"));
/* 34 */       view.add(new BackgroundInScene("Background 7"));
/*    */     }
/*    */   }
/*    */ 
/*    */   public Object getElementAt(int pos) {
/* 39 */     return this.view.get(pos);
/*    */   }
/*    */ 
/*    */   public int getSize() {
/* 43 */     return 8;
/*    */   }
/*    */ 
/*    */   public String writeXml() {
/* 47 */     String xml = "";
/*    */ 
/* 50 */     return xml;
/*    */   }
/*    */ 
/*    */   public int readXml(int init, String[] xml)
/*    */   {
/* 63 */     return init;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.units.BackgroundsModel
 * JD-Core Version:    0.6.2
 */