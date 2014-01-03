/*    */ package org.gcreator.components.popupmenus;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.util.Vector;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JList;
/*    */ import javax.swing.JMenuItem;
/*    */ import javax.swing.JPopupMenu;
/*    */ import org.gcreator.editors.ActorEditor;
/*    */ 
/*    */ public class EventPopupMenu extends JPopupMenu
/*    */ {
/*    */   private Vector array;
/*    */   private ActorEditor edit;
/*    */   private JMenuItem delete;
/*    */ 
/*    */   public EventPopupMenu(ActorEditor edit)
/*    */   {
/* 28 */     this.array = edit.elist.getEvents();
/* 29 */     this.edit = edit;
/* 30 */     this.delete = new JMenuItem("Delete");
/* 31 */     this.delete.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/general/delete.png")));
/* 32 */     this.delete.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent evt) {
/* 34 */         EventPopupMenu.this.onDelete();
/*    */       }
/*    */     });
/* 37 */     add(this.delete);
/*    */   }
/*    */ 
/*    */   public void onDelete() {
/* 41 */     int x = this.edit.jList1.getSelectedIndex();
/*    */     try {
/* 43 */       this.array.remove(x);
/*    */     } catch (Exception e) {
/*    */     }
/* 46 */     this.edit.updateUI();
/* 47 */     this.edit.updateActionList();
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.popupmenus.EventPopupMenu
 * JD-Core Version:    0.6.2
 */