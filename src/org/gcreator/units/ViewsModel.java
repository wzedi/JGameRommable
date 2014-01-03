/*    */ package org.gcreator.units;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Vector;
/*    */ import javax.swing.AbstractListModel;
/*    */ 
/*    */ public class ViewsModel extends AbstractListModel
/*    */   implements Serializable
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/*    */   public Vector<ViewInScene> view;
/*    */ 
/*    */   public ViewsModel(Vector<ViewInScene> view)
/*    */   {
/* 25 */     this.view = view;
/* 26 */     if (view.size() == 0) {
/* 27 */       view.add(new ViewInScene("View 0"));
/* 28 */       view.add(new ViewInScene("View 1"));
/* 29 */       view.add(new ViewInScene("View 2"));
/* 30 */       view.add(new ViewInScene("View 3"));
/* 31 */       view.add(new ViewInScene("View 4"));
/* 32 */       view.add(new ViewInScene("View 5"));
/* 33 */       view.add(new ViewInScene("View 6"));
/* 34 */       view.add(new ViewInScene("View 7"));
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
/* 48 */     for (ViewInScene each : this.view)
/* 49 */       xml = xml + each.writeXml();
/* 50 */     return xml;
/*    */   }
/*    */ 
/*    */   public int readXml(int init, String[] xml)
/*    */   {
/* 55 */     int curview = 0;
/* 56 */     for (int i = init + 1; i < xml.length; i++) {
/* 57 */       String line = xml[i];
/* 58 */       if (line.equals("</views>"))
/* 59 */         return i;
/* 60 */       if (line.equals("<view>"))
/* 61 */         i = ((ViewInScene)this.view.get(curview++)).readXml(i, xml);
/*    */     }
/* 63 */     return init;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.units.ViewsModel
 * JD-Core Version:    0.6.2
 */