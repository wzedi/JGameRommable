/*    */ package org.gcreator.components.impl;
/*    */ 
/*    */ import java.awt.Container;
/*    */ import java.util.Enumeration;
/*    */ import java.util.Vector;
/*    */ import javax.swing.JToolBar;
/*    */ import javax.swing.plaf.basic.BasicToolBarUI;
/*    */ import org.gcreator.components.ExtendedToolButton;
/*    */ import org.gcreator.components.popupmenus.PopupListener;
/*    */ import org.gcreator.core.Aurwindow;
/*    */ 
/*    */ public class Toolbar
/*    */ {
/* 20 */   public Vector<ToolbarItem> items = new Vector();
/* 21 */   public boolean horizontal = true;
/* 22 */   public boolean first = true;
/* 23 */   public boolean rollover = true;
/* 24 */   public boolean floatable = true;
/* 25 */   public String name = null;
/* 26 */   public Vector<JToolBar> toolbars = new Vector();
/*    */ 
/*    */   public void hideAll() {
/* 29 */     Enumeration e = this.toolbars.elements();
/* 30 */     while (e.hasMoreElements()) {
/* 31 */       JToolBar t = (JToolBar)e.nextElement();
/* 32 */       t.setVisible(false);
/*    */ 
/* 35 */       ((BasicToolBarUI)t.getUI()).setFloating(false, null);
/* 36 */       t.updateUI();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void showAll() {
/* 41 */     Enumeration e = this.toolbars.elements();
/* 42 */     while (e.hasMoreElements()) {
/* 43 */       JToolBar t = (JToolBar)e.nextElement();
/* 44 */       t.setVisible(true);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void make(Aurwindow window) {
/* 49 */     JToolBar toolbar = new JToolBar();
/* 50 */     this.toolbars.add(toolbar);
/* 51 */     if (this.name != null) {
/* 52 */       toolbar.setToolTipText(this.name);
/* 53 */       toolbar.setName(this.name);
/*    */     }
/* 55 */     for (ToolbarItem item : this.items) {
/* 56 */       if ((item instanceof ToolbarSeparator)) {
/* 57 */         toolbar.addSeparator();
/*    */       } else {
/* 59 */         ToolbarButton btn = (ToolbarButton)item;
/* 60 */         ExtendedToolButton button = new ExtendedToolButton();
/* 61 */         if (btn.isTextVisible())
/* 62 */           button.setText(btn.getText());
/* 63 */         button.setToolTipText(btn.getText());
/* 64 */         if (btn.isImageVisible())
/* 65 */           button.setIcon(btn.getImage());
/* 66 */         if (btn.isBold())
/* 67 */           button.setBold(true);
/* 68 */         button.addActionListener(btn.getActionListener());
/* 69 */         toolbar.add(button);
/*    */       }
/*    */     }
/* 72 */     toolbar.setFloatable(this.floatable);
/* 73 */     toolbar.setRollover(this.rollover);
/* 74 */     if (this.horizontal) {
/* 75 */       toolbar.setOrientation(0);
/* 76 */       if (this.first)
/* 77 */         window.topContainer.add(toolbar);
/*    */       else
/* 79 */         window.bottomContainer.add(toolbar);
/*    */     }
/*    */     else {
/* 82 */       toolbar.setOrientation(1);
/* 83 */       if (this.first)
/* 84 */         window.leftContainer.add(toolbar);
/*    */       else
/* 86 */         window.rightContainer.add(toolbar);
/*    */     }
/* 88 */     toolbar.addMouseListener(new PopupListener(toolbar, window.toolpopup));
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.impl.Toolbar
 * JD-Core Version:    0.6.2
 */