/*    */ package org.gcreator.components.popupmenus;
/*    */ 
/*    */ import javax.swing.JMenuItem;
/*    */ import javax.swing.JPopupMenu;
/*    */ 
/*    */ public class MouseListPopup extends JPopupMenu
/*    */ {
/*    */   JMenuItem[] items;
/*    */   EventSelect selector;
/*    */ 
/*    */   public MouseListPopup(EventSelect selector)
/*    */   {
/* 41 */     this.items = new JMenuItem[14];
/* 42 */     this.items[0] = new JMenuItem("Left Button Clicked");
/* 43 */     this.items[1] = new JMenuItem("Left Button Pressed");
/* 44 */     this.items[2] = new JMenuItem("Left Button Released");
/* 45 */     this.items[3] = new JMenuItem("Global Left Button Clicked");
/* 46 */     this.items[4] = new JMenuItem("Global Left Button Pressed");
/* 47 */     this.items[5] = new JMenuItem("Global Left Button Released");
/* 48 */     this.items[6] = new JMenuItem("Right Button Clicked");
/* 49 */     this.items[7] = new JMenuItem("Right Button Pressed");
/* 50 */     this.items[8] = new JMenuItem("Right Button Released");
/* 51 */     this.items[9] = new JMenuItem("Global Right Button Clicked");
/* 52 */     this.items[10] = new JMenuItem("Global Right Button Pressed");
/* 53 */     this.items[11] = new JMenuItem("Global Right Button Released");
/* 54 */     this.items[12] = new JMenuItem("Mouse Entered (Over)");
/* 55 */     this.items[13] = new JMenuItem("Mouse Exited (Out)");
/* 56 */     add(this.items[0]);
/* 57 */     this.items[0].addActionListener(new MouseActionListener(this, 0));
/* 58 */     add(this.items[1]);
/* 59 */     this.items[1].addActionListener(new MouseActionListener(this, 1));
/* 60 */     add(this.items[2]);
/* 61 */     this.items[2].addActionListener(new MouseActionListener(this, 2));
/* 62 */     addSeparator();
/* 63 */     add(this.items[3]);
/* 64 */     this.items[3].addActionListener(new MouseActionListener(this, 3));
/* 65 */     add(this.items[4]);
/* 66 */     this.items[4].addActionListener(new MouseActionListener(this, 4));
/* 67 */     add(this.items[5]);
/* 68 */     this.items[5].addActionListener(new MouseActionListener(this, 5));
/* 69 */     addSeparator();
/* 70 */     add(this.items[6]);
/* 71 */     this.items[6].addActionListener(new MouseActionListener(this, 6));
/* 72 */     add(this.items[7]);
/* 73 */     this.items[7].addActionListener(new MouseActionListener(this, 7));
/* 74 */     add(this.items[8]);
/* 75 */     this.items[8].addActionListener(new MouseActionListener(this, 8));
/* 76 */     addSeparator();
/* 77 */     add(this.items[9]);
/* 78 */     this.items[9].addActionListener(new MouseActionListener(this, 9));
/* 79 */     add(this.items[10]);
/* 80 */     this.items[10].addActionListener(new MouseActionListener(this, 10));
/* 81 */     add(this.items[11]);
/* 82 */     this.items[11].addActionListener(new MouseActionListener(this, 11));
/* 83 */     addSeparator();
/* 84 */     add(this.items[12]);
/* 85 */     this.items[12].addActionListener(new MouseActionListener(this, 12));
/* 86 */     add(this.items[13]);
/* 87 */     this.items[13].addActionListener(new MouseActionListener(this, 13));
/* 88 */     this.selector = selector;
/* 89 */     updateUI();
/*    */   }
/*    */   public void cause(int num) {
/* 92 */     this.selector.callEvent(5006 + num);
/* 93 */     this.selector.dispose();
/* 94 */     this.selector = null;
/*    */   }
/*    */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.popupmenus.MouseListPopup
 * JD-Core Version:    0.6.2
 */