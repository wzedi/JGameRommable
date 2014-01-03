/*    */ package org.gcreator.components.popupmenus;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Vector;
/*    */ import javax.swing.JList;
/*    */ import javax.swing.JPopupMenu;
/*    */ import org.gcreator.components.resource.FileMenuItem;
/*    */ import org.gcreator.components.resource.FolderMenuItem;
/*    */ import org.gcreator.editors.ActorEditor;
/*    */ import org.gcreator.events.CollisionEvent;
/*    */ import org.gcreator.events.Event;
/*    */ import org.gcreator.fileclass.Folder;
/*    */ import org.gcreator.fileclass.GFile;
/*    */ import org.gcreator.fileclass.GObject;
/*    */ import org.gcreator.fileclass.Project;
/*    */ import org.gcreator.fileclass.res.Actor;
/*    */ 
/*    */ public class CollisionListPopup extends JPopupMenu
/*    */ {
/*    */   private String key;
/*    */   private EventSelect selector;
/*    */ 
/*    */   public CollisionListPopup(EventSelect selector, String key)
/*    */   {
/* 25 */     Project p = selector.ae.project;
/* 26 */     this.key = key;
/* 27 */     this.selector = selector;
/* 28 */     folderToPopup(p, p.getFolderFor(key));
/*    */   }
/*    */ 
/*    */   public void folderToPopup(Project p, Folder f) {
/* 32 */     Vector v = f.getChildren();
/* 33 */     for (Iterator i$ = v.iterator(); i$.hasNext(); ) { Object o = i$.next();
/* 34 */       GObject g = (GObject)o;
/* 35 */       if (p.validOfType(g, this.key)) {
/* 36 */         if ((g instanceof GFile)) {
/* 37 */           FileMenuItem i = new FileMenuItem(this);
/* 38 */           i.setVisible(true);
/* 39 */           i.file = ((GFile)g);
/* 40 */           add(i);
/*    */         }
/*    */ 
/* 43 */         if ((g instanceof Folder)) {
/* 44 */           FolderMenuItem i = new FolderMenuItem();
/* 45 */           i.setVisible(true);
/* 46 */           i.file = ((Folder)g);
/* 47 */           folderToPopup(p, (Folder)g);
/* 48 */           add(i);
/*    */         }
/*    */       } }
/*    */   }
/*    */ 
/*    */   public void done(GFile file)
/*    */   {
/* 55 */     Vector e = ((Actor)this.selector.ae.file.value).events;
/* 56 */     boolean has = false;
/* 57 */     for (Iterator i$ = e.iterator(); i$.hasNext(); ) { Object o = i$.next();
/* 58 */       if (!(o instanceof Event))
/* 59 */         return;
/* 60 */       if ((((Event)o instanceof CollisionEvent)) && 
/* 61 */         (((CollisionEvent)o).other == file)) {
/* 62 */         has = true;
/* 63 */         break;
/*    */       }
/*    */     }
/* 66 */     if (!has) {
/* 67 */       e.add(new CollisionEvent(file));
/*    */     }
/* 69 */     this.selector.ae.jList1.updateUI();
/* 70 */     this.selector.dispose();
/* 71 */     this.selector = null;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.popupmenus.CollisionListPopup
 * JD-Core Version:    0.6.2
 */