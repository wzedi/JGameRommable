/*    */ package org.gcreator.components.popupmenus;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JMenuItem;
/*    */ import javax.swing.JPopupMenu;
/*    */ import javax.swing.JTextPane;
/*    */ import org.gcreator.clipboard.ClipboardManager;
/*    */ import org.gcreator.core.Aurwindow;
/*    */ import org.gcreator.core.gcreator;
/*    */ import org.gcreator.managers.LangSupporter;
/*    */ import org.gcreator.units.Dictionary;
/*    */ 
/*    */ public class ConsolePopupMenu extends JPopupMenu
/*    */ {
/*    */   JMenuItem copymessage;
/*    */   JMenuItem clear;
/*    */   JMenuItem hide;
/*    */ 
/*    */   public ConsolePopupMenu()
/*    */   {
/* 28 */     this.copymessage = new JMenuItem(LangSupporter.activeLang.getEntry(115));
/* 29 */     this.copymessage.setIcon(new ImageIcon(getClass().getResource("/org/gcreator/resources/general/copy.png")));
/* 30 */     this.clear = new JMenuItem(LangSupporter.activeLang.getEntry(14));
/* 31 */     this.hide = new JMenuItem(LangSupporter.activeLang.getEntry(116));
/* 32 */     add(this.copymessage);
/* 33 */     this.copymessage.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent evt) {
/* 35 */         ConsolePopupMenu.this.copymessage();
/*    */       }
/*    */     });
/* 38 */     add(this.clear);
/* 39 */     this.clear.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent evt) {
/* 41 */         ConsolePopupMenu.this.clear();
/*    */       }
/*    */     });
/* 44 */     add(this.hide);
/* 45 */     this.hide.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent evt) {
/* 47 */         ConsolePopupMenu.this._hide();
/*    */       }
/*    */     });
/* 50 */     updateUI();
/*    */   }
/*    */ 
/*    */   private void copymessage() {
/* 54 */     String content = gcreator.window.console.getText();
/* 55 */     content = content.replaceAll("\n", "");
/* 56 */     content = content.replaceAll("<(b[^r]|[^b]).*?/?>", "");
/* 57 */     content = content.replaceAll("\\s+", " ");
/* 58 */     content = content.replaceAll("^\\s", "");
/* 59 */     content = content.replaceAll("<br/?>", "\n");
/* 60 */     gcreator.clipboard.setClipboardContents(content);
/*    */   }
/*    */ 
/*    */   private void clear() {
/* 64 */     gcreator.window.console.setText("");
/* 65 */     gcreator.output = "";
/*    */   }
/*    */ 
/*    */   private void _hide() {
/* 69 */     gcreator.window.items[org.gcreator.managers.MenuSupporter.GenerateMenuItemId(2, 0)].setSelected(false);
/* 70 */     gcreator.window.items[org.gcreator.managers.MenuSupporter.GenerateMenuItemId(2, 0)].getActionListeners()[0].actionPerformed(null);
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.popupmenus.ConsolePopupMenu
 * JD-Core Version:    0.6.2
 */