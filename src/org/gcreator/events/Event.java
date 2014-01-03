/*    */ package org.gcreator.events;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.io.Serializable;
/*    */ import java.util.Vector;
/*    */ import javax.swing.ImageIcon;
/*    */ import org.gcreator.actions.Action;
/*    */ 
/*    */ public class Event
/*    */   implements Serializable
/*    */ {
/*    */   static final long serialVersionUID = 1L;
/*    */   public Vector<Action> actions;
/* 28 */   public EventCategory cat = null;
/*    */ 
/* 30 */   public Event() { this.actions = new Vector(); }
/*    */ 
/*    */   public ImageIcon getImage() {
/* 33 */     return null;
/*    */   }
/*    */   public ImageIcon getSelectedImage() {
/* 36 */     return getImage();
/*    */   }
/*    */   public Color getSelectedBackground() {
/* 39 */     return Color.BLUE;
/*    */   }
/*    */   public Color getSelectedForeground() {
/* 42 */     return Color.WHITE;
/*    */   }
/*    */   public Color getBackground() {
/* 45 */     return Color.WHITE;
/*    */   }
/*    */   public Color getForeground() {
/* 48 */     return Color.BLACK;
/*    */   }
/*    */   public boolean allowsOther() {
/* 51 */     return false;
/*    */   }
/*    */   public String writeXml() {
/* 54 */     String xml = "<event type=\"" + getClass().getName() + "\">\n";
/* 55 */     for (Action action : this.actions)
/* 56 */       xml = xml + action.writeXml();
/* 57 */     xml = xml + "</event>\n";
/* 58 */     return xml;
/*    */   }
/*    */   public static Event getNewEventFromName(String name) throws Exception {
/* 61 */     ClassLoader loader = ClassLoader.getSystemClassLoader();
/* 62 */     Class x = loader.loadClass(name);
/* 63 */     return (Event)x.newInstance();
/*    */   }
/*    */   public int readXml(String[] input, int initialpos) {
/* 66 */     return initialpos;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.events.Event
 * JD-Core Version:    0.6.2
 */