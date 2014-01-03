/*    */ package org.gcreator.components.popupmenus;
/*    */ 
/*    */ import java.util.Enumeration;
/*    */ import java.util.Vector;
/*    */ import javax.swing.AbstractListModel;
/*    */ import javax.swing.ImageIcon;
/*    */ import org.gcreator.events.Event;
/*    */ import org.gcreator.fileclass.GFile;
/*    */ import org.gcreator.fileclass.res.Actor;
/*    */ 
/*    */ public class EventListModel extends AbstractListModel
/*    */ {
/*    */   Actor val;
/*    */ 
/*    */   public EventListModel(GFile file)
/*    */   {
/* 24 */     this.val = ((Actor)file.value);
/*    */   }
/*    */   public Object getElementAt(int pos) {
/* 27 */     return this.val.events.get(pos);
/*    */   }
/*    */   public ImageIcon getImageAt(int pos) {
/* 30 */     return ((Event)this.val.events.get(pos)).getImage();
/*    */   }
/*    */   public int getSize() {
/* 33 */     return this.val.events.size();
/*    */   }
/*    */   public void add(Event event) {
/* 36 */     if (!contains(event))
/* 37 */       this.val.events.add(event);
/*    */   }
/*    */ 
/*    */   public boolean contains(Event e) {
/* 41 */     for (Enumeration en = getEvents().elements(); en.hasMoreElements(); )
/*    */     {
/* 43 */       Event ev = (Event)en.nextElement();
/* 44 */       if (ev.toString().equals(e.toString()))
/* 45 */         return true;
/*    */     }
/* 47 */     return false;
/*    */   }
/*    */ 
/*    */   public void remove(Event event) {
/* 51 */     this.val.events.remove(event);
/*    */   }
/*    */   public Vector getEvents() {
/* 54 */     return this.val.events;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.popupmenus.EventListModel
 * JD-Core Version:    0.6.2
 */