/*     */ package org.gcreator.autocomplete;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Collections;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Vector;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JScrollBar;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.ListCellRenderer;
/*     */ import org.gcreator.autocomplete.impl.CKeywordSuggestion;
/*     */ import org.gcreator.autocomplete.impl.ClassSuggestion;
/*     */ import org.gcreator.autocomplete.impl.FunctionSuggestion;
/*     */ import org.gcreator.autocomplete.impl.KeywordSuggestion;
/*     */ import org.gcreator.autocomplete.impl.NKeywordSuggestion;
/*     */ import org.gcreator.autocomplete.impl.Suggestion;
/*     */ import org.gcreator.autocomplete.impl.SuggestionCellRenderer;
/*     */ import org.gcreator.autocomplete.impl.VKeywordSuggestion;
/*     */ import org.gcreator.components.SyntaxHighlighter;
/*     */ import org.gcreator.components.impl.VectorListModel;
/*     */ import org.gcreator.fileclass.GObject;
/*     */ import org.gcreator.fileclass.Project;
/*     */ import org.gcreator.units.ObjectNode;
/*     */ 
/*     */ public class GCLAutocomplete extends AutocompleteFrame
/*     */ {
/*     */   int selstart;
/*     */   int selend;
/*     */   SyntaxHighlighter editor;
/*     */   String prevWord;
/*     */   String context;
/*  35 */   boolean requestDie = false;
/*     */   Project p;
/*  38 */   Vector<String> actorTypes = new Vector();
/*  39 */   Vector<String> spriteTypes = new Vector();
/*  40 */   Vector<Suggestion> v = new Vector();
/*     */ 
/*     */   public GCLAutocomplete(final int selstart, final int selend, final SyntaxHighlighter editor, Project p) {
/*  43 */     super("GCL Autocomplete...");
/*  44 */     this.selstart = selstart;
/*  45 */     this.selend = selend;
/*  46 */     this.editor = editor;
/*  47 */     this.p = p;
/*  48 */     this.context = getContext();
/*  49 */     addKeyListener(new KeyListener() {
/*     */       public void keyPressed(KeyEvent evt) {
/*  51 */         if (evt.getKeyCode() == 40) {
/*  52 */           if (!GCLAutocomplete.this.list.isSelectionEmpty()) {
/*  53 */             int sh = GCLAutocomplete.this.list.getCellRenderer().getListCellRendererComponent(GCLAutocomplete.this.list, GCLAutocomplete.this.list.getSelectedValue(), GCLAutocomplete.this.list.getSelectedIndex(), false, false).getPreferredSize().height;
/*     */ 
/*  55 */             JScrollBar bar = GCLAutocomplete.this.scroll.getVerticalScrollBar();
/*  56 */             bar.setValue(bar.getValue() + sh);
/*     */           }
/*  58 */           GCLAutocomplete.this.list.setSelectedIndex(GCLAutocomplete.this.list.getSelectedIndex() + 1);
/*     */         }
/*  60 */         else if (evt.getKeyCode() == 38) {
/*  61 */           if (!GCLAutocomplete.this.list.isSelectionEmpty()) {
/*  62 */             int sh = GCLAutocomplete.this.list.getCellRenderer().getListCellRendererComponent(GCLAutocomplete.this.list, GCLAutocomplete.this.list.getSelectedValue(), GCLAutocomplete.this.list.getSelectedIndex(), false, false).getPreferredSize().height;
/*     */ 
/*  64 */             JScrollBar bar = GCLAutocomplete.this.scroll.getVerticalScrollBar();
/*  65 */             bar.setValue(bar.getValue() - sh);
/*     */           }
/*  67 */           GCLAutocomplete.this.list.setSelectedIndex(GCLAutocomplete.this.list.getSelectedIndex() - 1);
/*     */         }
/*  69 */         else if (evt.getKeyCode() == 37) {
/*  70 */           editor.setSelectionStart(selstart - 1);
/*  71 */           editor.setSelectionEnd(selstart - 1);
/*  72 */           GCLAutocomplete.this.dispose();
/*     */         }
/*  74 */         else if (evt.getKeyCode() == 39) {
/*  75 */           editor.setSelectionStart(selend + 1);
/*  76 */           editor.setSelectionEnd(selend + 1);
/*  77 */           GCLAutocomplete.this.dispose();
/*     */         }
/*  79 */         else if (evt.getKeyCode() == 10) {
/*  80 */           GCLAutocomplete.this.confirm();
/*     */         }
/*  82 */         else if ((evt.getKeyChar() != 65535) && (evt.getKeyChar() != '\b'))
/*     */         {
/*  84 */           System.out.println(evt.getKeyChar());
/*  85 */           editor.insert(selstart, selend, "" + evt.getKeyChar());
/*  86 */           editor.setSelectionStart(selstart + 1);
/*  87 */           editor.setSelectionEnd(selstart + 1);
/*  88 */           GCLAutocomplete.this.dispose();
/*  89 */           editor.callAutocomplete();
/*     */         }
/*  91 */         else if (evt.getKeyChar() == '\b') {
/*  92 */           if (selstart == selend) {
/*  93 */             editor.insert(selstart - 1, selstart, "");
/*     */           }
/*     */           else {
/*  96 */             editor.insert(selstart, selend, "");
/*     */           }
/*  98 */           GCLAutocomplete.this.dispose();
/*  99 */           editor.callAutocomplete();
/* 100 */           editor.setSelectionEnd(selstart);
/*     */         }
/*     */       }
/*     */ 
/*     */       public void keyReleased(KeyEvent evt)
/*     */       {
/*     */       }
/*     */ 
/*     */       public void keyTyped(KeyEvent evt)
/*     */       {
/*     */       }
/*     */     });
/* 106 */     useContext();
/*     */   }
/*     */ 
/*     */   public boolean requestDie()
/*     */   {
/* 111 */     return this.requestDie;
/*     */   }
/*     */ 
/*     */   private void confirm() {
/* 115 */     if (this.list.isSelectionEmpty()) {
/* 116 */       this.editor.insert(this.selstart, this.selend, "\n");
/*     */     }
/*     */     else {
/* 119 */       Suggestion s = (Suggestion)this.list.getSelectedValue();
/* 120 */       String t = s.confirm(this.context, this.prevWord);
/* 121 */       this.editor.insert(this.selstart, this.selend, t);
/* 122 */       this.editor.setSelectionStart(this.selstart + t.length() - s.retreat());
/* 123 */       this.editor.setSelectionEnd(this.selstart + t.length() - s.retreat());
/*     */     }
/* 125 */     dispose();
/*     */   }
/*     */ 
/*     */   private void applyClass(String val) {
/* 129 */     String res = "";
/* 130 */     for (int i = val.length() - 1; i >= 0; i--) {
/* 131 */       if (i == val.length() - 1) {
/* 132 */         res = "(" + val.charAt(i) + ")?";
/*     */       }
/*     */       else {
/* 135 */         res = "(" + val.charAt(i) + res + ")?";
/*     */       }
/*     */     }
/* 138 */     res = "^" + res + "$";
/* 139 */     if (this.context.matches(res))
/* 140 */       this.v.add(new ClassSuggestion(val));
/*     */   }
/*     */ 
/*     */   private void applyClassVector(Vector<String> vals)
/*     */   {
/* 145 */     for (String s : vals)
/* 146 */       applyClass(s);
/*     */   }
/*     */ 
/*     */   private void applyKeyword(String val) {
/* 150 */     String res = "";
/* 151 */     for (int i = val.length() - 1; i >= 0; i--) {
/* 152 */       if (i == val.length() - 1) {
/* 153 */         res = "(" + val.charAt(i) + ")?";
/*     */       }
/*     */       else {
/* 156 */         res = "(" + val.charAt(i) + res + ")?";
/*     */       }
/*     */     }
/* 159 */     res = "^" + res + "$";
/* 160 */     if (this.context.matches(res))
/* 161 */       this.v.add(new KeywordSuggestion(val));
/*     */   }
/*     */ 
/*     */   private void applyCKeyword(String val)
/*     */   {
/* 166 */     String res = "";
/* 167 */     for (int i = val.length() - 1; i >= 0; i--) {
/* 168 */       if (i == val.length() - 1) {
/* 169 */         res = "(" + val.charAt(i) + ")?";
/*     */       }
/*     */       else {
/* 172 */         res = "(" + val.charAt(i) + res + ")?";
/*     */       }
/*     */     }
/* 175 */     res = "^" + res + "$";
/* 176 */     if (this.context.matches(res))
/* 177 */       this.v.add(new CKeywordSuggestion(val));
/*     */   }
/*     */ 
/*     */   private void applyVKeyword(String val)
/*     */   {
/* 182 */     String res = "";
/* 183 */     for (int i = val.length() - 1; i >= 0; i--) {
/* 184 */       if (i == val.length() - 1) {
/* 185 */         res = "(" + val.charAt(i) + ")?";
/*     */       }
/*     */       else {
/* 188 */         res = "(" + val.charAt(i) + res + ")?";
/*     */       }
/*     */     }
/* 191 */     res = "^" + res + "$";
/* 192 */     if (this.context.matches(res))
/* 193 */       this.v.add(new VKeywordSuggestion(val));
/*     */   }
/*     */ 
/*     */   private void applyNKeyword(String val)
/*     */   {
/* 198 */     String res = "";
/* 199 */     for (int i = val.length() - 1; i >= 0; i--) {
/* 200 */       if (i == val.length() - 1) {
/* 201 */         res = "(" + val.charAt(i) + ")?";
/*     */       }
/*     */       else {
/* 204 */         res = "(" + val.charAt(i) + res + ")?";
/*     */       }
/*     */     }
/* 207 */     res = "^" + res + "$";
/* 208 */     if (this.context.matches(res))
/* 209 */       this.v.add(new NKeywordSuggestion(val));
/*     */   }
/*     */ 
/*     */   private void useContext()
/*     */   {
/* 214 */     this.scroll = new JScrollPane();
/* 215 */     this.scroll.setFocusable(false);
/* 216 */     this.scroll.setVisible(true);
/* 217 */     this.list = new JList();
/* 218 */     this.list.setFocusable(false);
/* 219 */     this.list.setVisible(true);
/* 220 */     this.scroll.setViewportView(this.list);
/* 221 */     add("Center", this.scroll);
/* 222 */     if (this.context == null) {
/* 223 */       dispose();
/* 224 */       return;
/*     */     }
/*     */ 
/* 227 */     this.actorTypes.add("Actor");
/* 228 */     Enumeration e = this.p.getEnum("actor");
/*     */ 
/* 230 */     while (e.hasMoreElements()) {
/* 231 */       Object o = e.nextElement();
/* 232 */       this.actorTypes.add(((ObjectNode)o).object.name);
/*     */     }
/* 234 */     this.actorTypes.add("Sprite");
/* 235 */     e = this.p.getEnum("sprite");
/* 236 */     while (e.hasMoreElements()) {
/* 237 */       Object o = e.nextElement();
/* 238 */       this.spriteTypes.add(((ObjectNode)o).object.name);
/*     */     }
/*     */ 
/* 241 */     applyClassVector(this.actorTypes);
/* 242 */     applyClassVector(this.spriteTypes);
/*     */ 
/* 244 */     applyKeyword("char");
/*     */ 
/* 246 */     applyClass("Clipboard");
/*     */ 
/* 248 */     applyClass("Common");
/*     */ 
/* 250 */     if (this.context.matches("^Common\\.(S(c(e(n(e)?)?)?)?)?$")) {
/* 251 */       this.v.add(new ClassSuggestion("Scene"));
/*     */     }
/* 253 */     applyKeyword("do");
/*     */ 
/* 255 */     applyKeyword("else");
/*     */ 
/* 257 */     applyCKeyword("for");
/*     */ 
/* 259 */     applyKeyword("getter");
/*     */ 
/* 261 */     if (this.context.matches("^Clipboard\\.(g(e(t(T(e(x(t)?)?)?)?)?)?)?$")) {
/* 262 */       this.v.add(new FunctionSuggestion("getText", ""));
/*     */     }
/* 264 */     applyCKeyword("if");
/*     */ 
/* 266 */     applyKeyword("int");
/*     */ 
/* 268 */     applyVKeyword("false");
/*     */ 
/* 270 */     applyKeyword("float");
/*     */ 
/* 272 */     if (this.context.matches("^Clipboard\\.(h(a(s(T(e(x(t)?)?)?)?)?)?)?$")) {
/* 273 */       this.v.add(new FunctionSuggestion("hasText", ""));
/*     */     }
/* 275 */     applyNKeyword("native");
/*     */ 
/* 277 */     applyKeyword("new");
/*     */ 
/* 279 */     applyVKeyword("null");
/*     */ 
/* 281 */     applyKeyword("private");
/*     */ 
/* 283 */     applyKeyword("protected");
/*     */ 
/* 285 */     applyKeyword("public");
/*     */ 
/* 287 */     if (this.context.matches("^Clipboard\\.(s(e(t(T(e(x(t)?)?)?)?)?)?)?$")) {
/* 288 */       this.v.add(new FunctionSuggestion("setText", "text"));
/*     */     }
/* 290 */     applyKeyword("return ");
/*     */ 
/* 292 */     applyKeyword("static");
/*     */ 
/* 294 */     applyVKeyword("this");
/*     */ 
/* 296 */     applyVKeyword("true");
/*     */ 
/* 298 */     if (this.context.matches("^Common\\.Scene\\.(g(o(t(o(N(e(x(t)?)?)?)?)?)?)?)?$")) {
/* 299 */       this.v.add(new FunctionSuggestion("gotoNext", ""));
/*     */     }
/* 301 */     if (this.context.matches("^Common\\.Scene\\.(g(o(t(o(P(r(e(v(i(o(u(s)?)?)?)?)?)?)?)?)?)?)?)?$")) {
/* 302 */       this.v.add(new FunctionSuggestion("gotoNext", ""));
/*     */     }
/* 304 */     applyKeyword("void");
/*     */ 
/* 306 */     applyCKeyword("while");
/*     */ 
/* 308 */     Collections.sort(this.v);
/*     */ 
/* 310 */     this.list.setModel(new VectorListModel(this.v));
/* 311 */     this.list.setCellRenderer(new SuggestionCellRenderer());
/*     */ 
/* 313 */     if (this.v.size() == 1) {
/* 314 */       this.list.setSelectedIndex(0);
/* 315 */       String t = ((Suggestion)this.list.getSelectedValue()).confirm(this.context, this.prevWord);
/* 316 */       this.editor.insert(this.selstart, this.selend, t);
/* 317 */       this.editor.setSelectionStart(this.selstart + t.length());
/* 318 */       this.editor.setSelectionEnd(this.selstart + t.length());
/* 319 */       dispose();
/* 320 */       this.requestDie = true;
/*     */     }
/*     */   }
/*     */ 
/*     */   private String getContext() {
/* 325 */     int NULL = 0;
/* 326 */     int SCOMMENT = 1;
/* 327 */     int MCOMMENT = 2;
/* 328 */     int STRING = 3;
/* 329 */     int BSTRING = 4;
/* 330 */     int CHAR = 5;
/* 331 */     int BCHAR = 6;
/* 332 */     int situation = 0;
/* 333 */     String word = "";
/* 334 */     String x = this.editor.getText();
/* 335 */     int selection = this.selend;
/* 336 */     this.prevWord = "";
/* 337 */     if ((selection < 0) || (selection > x.length()))
/* 338 */       return null;
/* 339 */     for (int i = 0; i < selection; i++) {
/*     */       try {
/* 341 */         if (situation == 0) {
/* 342 */           if ((x.charAt(i) == '/') && (x.charAt(i + 1) == '/')) {
/* 343 */             if (!word.equals(""))
/* 344 */               this.prevWord = word;
/* 345 */             word = "";
/* 346 */             situation = 1;
/*     */           }
/* 349 */           else if ((x.charAt(i) == '/') && (x.charAt(i + 1) == '*')) {
/* 350 */             if (!word.equals(""))
/* 351 */               this.prevWord = word;
/* 352 */             word = "";
/* 353 */             situation = 2;
/*     */           }
/* 356 */           else if (x.charAt(i) == '"') {
/* 357 */             if (!word.equals(""))
/* 358 */               this.prevWord = word;
/* 359 */             word = "";
/* 360 */             situation = 3;
/*     */           }
/* 363 */           else if (x.charAt(i) == '\'') {
/* 364 */             if (!word.equals(""))
/* 365 */               this.prevWord = word;
/* 366 */             word = "";
/* 367 */             situation = 5;
/*     */           }
/* 370 */           else if ((x.charAt(i) == ' ') || (x.charAt(i) == '\t') || (x.charAt(i) == '\n') || (x.charAt(i) == '+') || (x.charAt(i) == '-') || (x.charAt(i) == '*') || (x.charAt(i) == '/') || (x.charAt(i) == '%') || (x.charAt(i) == '&') || (x.charAt(i) == '|') || (x.charAt(i) == '(') || (x.charAt(i) == ')') || (x.charAt(i) == '{') || (x.charAt(i) == '}') || (x.charAt(i) == '!') || (x.charAt(i) == '^') || (x.charAt(i) == ',') || (x.charAt(i) == ';') || (x.charAt(i) == '<') || (x.charAt(i) == '>') || (x.charAt(i) == '=') || (x.charAt(i) == '?') || (x.charAt(i) == ':'))
/*     */           {
/* 392 */             if (!word.equals(""))
/* 393 */               this.prevWord = word;
/* 394 */             word = "";
/*     */           }
/*     */           else {
/* 397 */             word = word + x.charAt(i);
/*     */           }
/*     */         }
/* 400 */         else if ((situation == 1) && 
/* 401 */           (x.charAt(i) == '\n')) {
/* 402 */           situation = 0;
/*     */         }
/* 406 */         else if ((situation == 2) && 
/* 407 */           (x.charAt(i) == '*') && (x.charAt(i + 1) == '/')) {
/* 408 */           situation = 0;
/*     */         }
/*     */         else
/*     */         {
/* 413 */           if (situation == 3) {
/* 414 */             if (x.charAt(i) == '\\') {
/* 415 */               situation = 4;
/* 416 */               continue;
/*     */             }
/* 418 */             if (x.charAt(i) == '"') {
/* 419 */               situation = 0;
/* 420 */               continue;
/*     */             }
/*     */           }
/* 423 */           if (situation == 4) {
/* 424 */             situation = 3;
/*     */           }
/*     */           else {
/* 427 */             if (situation == 5) {
/* 428 */               if (x.charAt(i) == '\\') {
/* 429 */                 situation = 6;
/* 430 */                 continue;
/*     */               }
/* 432 */               if (x.charAt(i) == '"') {
/* 433 */                 situation = 0;
/* 434 */                 continue;
/*     */               }
/*     */             }
/* 437 */             if (situation == 6)
/* 438 */               situation = 5;
/*     */           }
/*     */         }
/*     */       }
/*     */       catch (Exception e) {
/* 443 */         break;
/*     */       }
/*     */     }
/* 446 */     if (situation == 0) {
/* 447 */       return word;
/*     */     }
/* 449 */     return null;
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.autocomplete.GCLAutocomplete
 * JD-Core Version:    0.6.2
 */