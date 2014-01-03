/*     */ package org.gcreator.components.popupmenus;
/*     */ 
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JPopupMenu;
/*     */ 
/*     */ public class KeyboardListPopup extends JPopupMenu
/*     */ {
/*     */   JMenuItem[] items;
/*     */   EventSelect selector;
/*     */   int kcode;
/*     */ 
/*     */   public KeyboardListPopup(EventSelect selector, int code)
/*     */   {
/*  40 */     this.kcode = code;
/*  41 */     JMenu letters = new JMenu("Letters");
/*  42 */     JMenu fkeys = new JMenu("Function keys");
/*  43 */     JMenu digits = new JMenu("Digits");
/*  44 */     JMenu others = new JMenu("Others");
/*  45 */     JMenu keypad = new JMenu("Keypad");
/*  46 */     JMenu arrows = new JMenu("Arrows");
/*     */ 
/*  48 */     add(arrows);
/*  49 */     add(letters);
/*  50 */     add(fkeys);
/*  51 */     add(digits);
/*  52 */     add(keypad);
/*  53 */     add(others);
/*     */ 
/*  55 */     add(others, new JMenuItem("<Shift>"), 16);
/*  56 */     add(others, new JMenuItem("<Ctrl>"), 17);
/*  57 */     add(others, new JMenuItem("<Alt>"), 18);
/*  58 */     add(others, new JMenuItem("<Space>"), 32);
/*  59 */     add(others, new JMenuItem("<Enter>"), 10);
/*  60 */     add(others, new JMenuItem("<Backspace>"), 8);
/*  61 */     add(others, new JMenuItem("<Home>"), 36);
/*  62 */     add(others, new JMenuItem("<End>"), 35);
/*  63 */     add(others, new JMenuItem("<PageUP>"), 33);
/*  64 */     add(others, new JMenuItem("<PageDown>"), 34);
/*  65 */     add(others, new JMenuItem("<Delete>"), 127);
/*  66 */     add(others, new JMenuItem("<Insert>"), 155);
/*  67 */     add(others, new JMenuItem("<ESC>"), 27);
/*     */ 
/*  69 */     add(arrows, new JMenuItem("<left>"), 37);
/*  70 */     add(arrows, new JMenuItem("<right>"), 39);
/*  71 */     add(arrows, new JMenuItem("<up>"), 38);
/*  72 */     add(arrows, new JMenuItem("<down>"), 40);
/*     */ 
/*  74 */     add(fkeys, new JMenuItem("F1"), 112);
/*  75 */     add(fkeys, new JMenuItem("F2"), 113);
/*  76 */     add(fkeys, new JMenuItem("F3"), 114);
/*  77 */     add(fkeys, new JMenuItem("F4"), 115);
/*  78 */     add(fkeys, new JMenuItem("F5"), 116);
/*  79 */     add(fkeys, new JMenuItem("F6"), 117);
/*  80 */     add(fkeys, new JMenuItem("F7"), 118);
/*  81 */     add(fkeys, new JMenuItem("F8"), 119);
/*  82 */     add(fkeys, new JMenuItem("F9"), 120);
/*  83 */     add(fkeys, new JMenuItem("F10"), 121);
/*  84 */     add(fkeys, new JMenuItem("F11"), 122);
/*  85 */     add(fkeys, new JMenuItem("F12"), 123);
/*     */ 
/*  87 */     add(digits, new JMenuItem("0"), 48);
/*  88 */     add(digits, new JMenuItem("1"), 49);
/*  89 */     add(digits, new JMenuItem("2"), 50);
/*  90 */     add(digits, new JMenuItem("3"), 51);
/*  91 */     add(digits, new JMenuItem("4"), 52);
/*  92 */     add(digits, new JMenuItem("5"), 53);
/*  93 */     add(digits, new JMenuItem("6"), 54);
/*  94 */     add(digits, new JMenuItem("7"), 55);
/*  95 */     add(digits, new JMenuItem("8"), 56);
/*  96 */     add(digits, new JMenuItem("9"), 57);
/*     */ 
/*  98 */     add(letters, new JMenuItem("A"), 65);
/*  99 */     add(letters, new JMenuItem("B"), 66);
/* 100 */     add(letters, new JMenuItem("C"), 67);
/* 101 */     add(letters, new JMenuItem("D"), 68);
/* 102 */     add(letters, new JMenuItem("E"), 69);
/* 103 */     add(letters, new JMenuItem("F"), 70);
/* 104 */     add(letters, new JMenuItem("G"), 71);
/* 105 */     add(letters, new JMenuItem("H"), 72);
/* 106 */     add(letters, new JMenuItem("I"), 73);
/* 107 */     add(letters, new JMenuItem("J"), 74);
/* 108 */     add(letters, new JMenuItem("K"), 75);
/* 109 */     add(letters, new JMenuItem("L"), 76);
/* 110 */     add(letters, new JMenuItem("M"), 77);
/* 111 */     add(letters, new JMenuItem("N"), 78);
/* 112 */     add(letters, new JMenuItem("O"), 79);
/* 113 */     add(letters, new JMenuItem("P"), 80);
/* 114 */     add(letters, new JMenuItem("Q"), 81);
/* 115 */     add(letters, new JMenuItem("R"), 82);
/* 116 */     add(letters, new JMenuItem("S"), 83);
/* 117 */     add(letters, new JMenuItem("T"), 84);
/* 118 */     add(letters, new JMenuItem("U"), 85);
/* 119 */     add(letters, new JMenuItem("V"), 86);
/* 120 */     add(letters, new JMenuItem("W"), 87);
/* 121 */     add(letters, new JMenuItem("X"), 88);
/* 122 */     add(letters, new JMenuItem("Y"), 89);
/* 123 */     add(letters, new JMenuItem("Z"), 90);
/*     */ 
/* 125 */     this.selector = selector;
/* 126 */     updateUI();
/*     */   }
/*     */   public void add(JMenu j, JMenuItem m, int i) {
/* 129 */     j.add(m);
/* 130 */     m.addActionListener(new KeyboardActionListener(this, i, m.getText()));
/*     */   }
/*     */ 
/*     */   public void cause(int num, String name) {
/* 134 */     this.selector.callEvent(this.kcode + num, name);
/* 135 */     this.selector.dispose();
/* 136 */     this.selector = null;
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.popupmenus.KeyboardListPopup
 * JD-Core Version:    0.6.2
 */