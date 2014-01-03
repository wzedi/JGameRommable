/*     */ package org.gcreator.autocomplete;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Collections;
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
/*     */ import org.gcreator.fileclass.Project;
/*     */ 
/*     */ public class GSAutocomplete extends AutocompleteFrame
/*     */ {
/*     */   int selstart;
/*     */   int selend;
/*     */   SyntaxHighlighter editor;
/*     */   String prevWord;
/*     */   String context;
/*  35 */   boolean requestDie = false;
/*     */   Project p;
/*  38 */   Vector<Suggestion> v = new Vector();
/*     */ 
/*     */   public GSAutocomplete(final int selstart, final int selend, final SyntaxHighlighter editor, Project p) {
/*  41 */     super("GS Autocomplete...");
/*  42 */     this.selstart = selstart;
/*  43 */     this.selend = selend;
/*  44 */     this.editor = editor;
/*  45 */     this.p = p;
/*  46 */     this.context = getContext();
/*  47 */     addKeyListener(new KeyListener() {
/*     */       public void keyPressed(KeyEvent evt) {
/*  49 */         if (evt.getKeyCode() == 40) {
/*  50 */           if (!GSAutocomplete.this.list.isSelectionEmpty()) {
/*  51 */             int sh = GSAutocomplete.this.list.getCellRenderer().getListCellRendererComponent(GSAutocomplete.this.list, GSAutocomplete.this.list.getSelectedValue(), GSAutocomplete.this.list.getSelectedIndex(), false, false).getPreferredSize().height;
/*     */ 
/*  53 */             JScrollBar bar = GSAutocomplete.this.scroll.getVerticalScrollBar();
/*  54 */             bar.setValue(bar.getValue() + sh);
/*     */           }
/*  56 */           GSAutocomplete.this.list.setSelectedIndex(GSAutocomplete.this.list.getSelectedIndex() + 1);
/*     */         }
/*  58 */         else if (evt.getKeyCode() == 38) {
/*  59 */           if (!GSAutocomplete.this.list.isSelectionEmpty()) {
/*  60 */             int sh = GSAutocomplete.this.list.getCellRenderer().getListCellRendererComponent(GSAutocomplete.this.list, GSAutocomplete.this.list.getSelectedValue(), GSAutocomplete.this.list.getSelectedIndex(), false, false).getPreferredSize().height;
/*     */ 
/*  62 */             JScrollBar bar = GSAutocomplete.this.scroll.getVerticalScrollBar();
/*  63 */             bar.setValue(bar.getValue() - sh);
/*     */           }
/*  65 */           GSAutocomplete.this.list.setSelectedIndex(GSAutocomplete.this.list.getSelectedIndex() - 1);
/*     */         }
/*  67 */         else if (evt.getKeyCode() == 37) {
/*  68 */           editor.setSelectionStart(selstart - 1);
/*  69 */           editor.setSelectionEnd(selstart - 1);
/*  70 */           GSAutocomplete.this.dispose();
/*     */         }
/*  72 */         else if (evt.getKeyCode() == 39) {
/*  73 */           editor.setSelectionStart(selend + 1);
/*  74 */           editor.setSelectionEnd(selend + 1);
/*  75 */           GSAutocomplete.this.dispose();
/*     */         }
/*  77 */         else if (evt.getKeyCode() == 10) {
/*  78 */           GSAutocomplete.this.confirm();
/*     */         }
/*  80 */         else if ((evt.getKeyChar() != 65535) && (evt.getKeyChar() != '\b'))
/*     */         {
/*  82 */           System.out.println(evt.getKeyChar());
/*  83 */           editor.insert(selstart, selend, "" + evt.getKeyChar());
/*  84 */           editor.setSelectionStart(selstart + 1);
/*  85 */           editor.setSelectionEnd(selstart + 1);
/*  86 */           GSAutocomplete.this.dispose();
/*  87 */           editor.callAutocomplete();
/*     */         }
/*  89 */         else if (evt.getKeyChar() == '\b') {
/*  90 */           if (selstart == selend) {
/*  91 */             editor.insert(selstart - 1, selstart, "");
/*     */           }
/*     */           else {
/*  94 */             editor.insert(selstart, selend, "");
/*     */           }
/*  96 */           GSAutocomplete.this.dispose();
/*  97 */           editor.callAutocomplete();
/*  98 */           editor.setSelectionEnd(selstart);
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
/* 104 */     useContext();
/*     */   }
/*     */ 
/*     */   public boolean requestDie()
/*     */   {
/* 109 */     return this.requestDie;
/*     */   }
/*     */ 
/*     */   private void confirm() {
/* 113 */     if (this.list.isSelectionEmpty()) {
/* 114 */       this.editor.insert(this.selstart, this.selend, "\n");
/*     */     }
/*     */     else {
/* 117 */       Suggestion s = (Suggestion)this.list.getSelectedValue();
/* 118 */       String t = s.confirm(this.context, this.prevWord);
/* 119 */       this.editor.insert(this.selstart, this.selend, t);
/* 120 */       this.editor.setSelectionStart(this.selstart + t.length() - s.retreat());
/* 121 */       this.editor.setSelectionEnd(this.selstart + t.length() - s.retreat());
/*     */     }
/* 123 */     dispose();
/*     */   }
/*     */ 
/*     */   private void applyClass(String val) {
/* 127 */     String res = "";
/* 128 */     for (int i = val.length() - 1; i >= 0; i--) {
/* 129 */       if (i == val.length() - 1) {
/* 130 */         res = "(" + val.charAt(i) + ")?";
/*     */       }
/*     */       else {
/* 133 */         res = "(" + val.charAt(i) + res + ")?";
/*     */       }
/*     */     }
/* 136 */     res = "^" + res + "$";
/* 137 */     if (this.context.matches(res))
/* 138 */       this.v.add(new ClassSuggestion(val));
/*     */   }
/*     */ 
/*     */   private void applyClassVector(Vector<String> vals)
/*     */   {
/* 143 */     for (String s : vals)
/* 144 */       applyClass(s);
/*     */   }
/*     */ 
/*     */   private void applyKeyword(String val) {
/* 148 */     String res = "";
/* 149 */     for (int i = val.length() - 1; i >= 0; i--) {
/* 150 */       if (i == val.length() - 1) {
/* 151 */         res = "(" + val.charAt(i) + ")?";
/*     */       }
/*     */       else {
/* 154 */         res = "(" + val.charAt(i) + res + ")?";
/*     */       }
/*     */     }
/* 157 */     res = "^" + res + "$";
/* 158 */     if (this.context.matches(res))
/* 159 */       this.v.add(new KeywordSuggestion(val));
/*     */   }
/*     */ 
/*     */   private void applyCKeyword(String val)
/*     */   {
/* 164 */     String res = "";
/* 165 */     for (int i = val.length() - 1; i >= 0; i--) {
/* 166 */       if (i == val.length() - 1) {
/* 167 */         res = "(" + val.charAt(i) + ")?";
/*     */       }
/*     */       else {
/* 170 */         res = "(" + val.charAt(i) + res + ")?";
/*     */       }
/*     */     }
/* 173 */     res = "^" + res + "$";
/* 174 */     if (this.context.matches(res))
/* 175 */       this.v.add(new CKeywordSuggestion(val));
/*     */   }
/*     */ 
/*     */   private void applyVKeyword(String val)
/*     */   {
/* 180 */     String res = "";
/* 181 */     for (int i = val.length() - 1; i >= 0; i--) {
/* 182 */       if (i == val.length() - 1) {
/* 183 */         res = "(" + val.charAt(i) + ")?";
/*     */       }
/*     */       else {
/* 186 */         res = "(" + val.charAt(i) + res + ")?";
/*     */       }
/*     */     }
/* 189 */     res = "^" + res + "$";
/* 190 */     if (this.context.matches(res))
/* 191 */       this.v.add(new VKeywordSuggestion(val));
/*     */   }
/*     */ 
/*     */   private void applyNKeyword(String val)
/*     */   {
/* 196 */     String res = "";
/* 197 */     for (int i = val.length() - 1; i >= 0; i--) {
/* 198 */       if (i == val.length() - 1) {
/* 199 */         res = "(" + val.charAt(i) + ")?";
/*     */       }
/*     */       else {
/* 202 */         res = "(" + val.charAt(i) + res + ")?";
/*     */       }
/*     */     }
/* 205 */     res = "^" + res + "$";
/* 206 */     if (this.context.matches(res))
/* 207 */       this.v.add(new NKeywordSuggestion(val));
/*     */   }
/*     */ 
/*     */   private void applyFunction(String val, String args)
/*     */   {
/* 212 */     String res = "";
/* 213 */     for (int i = val.length() - 1; i >= 0; i--) {
/* 214 */       if (i == val.length() - 1) {
/* 215 */         res = "(" + val.charAt(i) + ")?";
/*     */       }
/*     */       else {
/* 218 */         res = "(" + val.charAt(i) + res + ")?";
/*     */       }
/*     */     }
/* 221 */     res = "^" + res + "$";
/* 222 */     if (this.context.matches(res))
/* 223 */       this.v.add(new FunctionSuggestion(val, args));
/*     */   }
/*     */ 
/*     */   private void useContext()
/*     */   {
/* 228 */     if (this.context == null) {
/* 229 */       dispose();
/* 230 */       return;
/*     */     }
/*     */ 
/* 233 */     applyCKeyword("if");
/* 234 */     applyCKeyword("while");
/* 235 */     applyCKeyword("for");
/* 236 */     applyKeyword("else");
/* 237 */     applyKeyword("do");
/*     */ 
/* 239 */     applyKeyword("var");
/*     */ 
/* 241 */     applyFunction("room_goto_next", "");
/* 242 */     applyFunction("room_goto_previous", "");
/* 243 */     applyFunction("scene_goto_next", "");
/* 244 */     applyFunction("scene_goto_previous", "");
/* 245 */     applyFunction("random", "max");
/* 246 */     applyFunction("abs", "x");
/* 247 */     applyFunction("sign", "x");
/* 248 */     applyFunction("round", "x");
/* 249 */     applyFunction("floor", "x");
/* 250 */     applyFunction("ceil", "x");
/* 251 */     applyFunction("frac", "x");
/* 252 */     applyFunction("sqrt", "x");
/* 253 */     applyFunction("sqr", "x");
/* 254 */     applyFunction("power", "x");
/* 255 */     applyFunction("exp", "x");
/* 256 */     applyFunction("ln", "x");
/* 257 */     applyFunction("log2", "x");
/* 258 */     applyFunction("log10", "x");
/* 259 */     applyFunction("logn", "n, x");
/* 260 */     applyFunction("sin", "x");
/* 261 */     applyFunction("cos", "x");
/* 262 */     applyFunction("tan", "x");
/* 263 */     applyFunction("arcsin", "x");
/* 264 */     applyFunction("arccos", "x");
/* 265 */     applyFunction("arctan", "x");
/* 266 */     applyFunction("arctan2", "y, x");
/* 267 */     applyFunction("degtorad", "degrees");
/* 268 */     applyFunction("radtodeg", "radians");
/* 269 */     applyFunction("point_distance", "x1, y1, x2, y2");
/* 270 */     applyFunction("lengthdir_x", "len, dir");
/* 271 */     applyFunction("lengthdir_y", "len, dir");
/* 272 */     applyFunction("is_real", "x");
/* 273 */     applyFunction("is_string", "x");
/* 274 */     applyFunction("point_direction", "x1, y1, x2, y2");
/* 275 */     applyFunction("real", "str");
/* 276 */     applyFunction("string", "value");
/* 277 */     applyFunction("chr", "value");
/* 278 */     applyFunction("ord", "char");
/* 279 */     applyFunction("string_length", "text");
/* 280 */     applyFunction("string_pos", "substring, text");
/* 281 */     applyFunction("string_copy", "text, index, count");
/* 282 */     applyFunction("string_char_at", "text, index");
/* 283 */     applyFunction("string_delete", "text, index, count");
/* 284 */     applyFunction("string_insert", "substring, text, index");
/* 285 */     applyFunction("string_lower", "text");
/* 286 */     applyFunction("string_upper", "text");
/* 287 */     applyFunction("string_repeat", "text, times");
/* 288 */     applyFunction("string_letters", "text");
/* 289 */     applyFunction("string_digits", "text");
/* 290 */     applyFunction("string_lettersdigits", "text");
/* 291 */     applyFunction("string_replace", "text, find, replace");
/* 292 */     applyFunction("string_replaceall", "text, find, replace");
/* 293 */     applyFunction("string_count", "substring, text");
/* 294 */     applyFunction("string_format", "val, total, dec");
/* 295 */     applyFunction("clipboard_has_text", "");
/* 296 */     applyFunction("clipboard_get_text", "");
/* 297 */     applyFunction("clipboard_set_text", "text");
/* 298 */     applyFunction("date_current_date", "");
/* 299 */     applyFunction("move_snap", "hsnap, vsnap");
/* 300 */     applyFunction("place_snapped", "hsnap, vsnap");
/* 301 */     applyFunction("move_random", "hsnap, vsnap");
/* 302 */     applyFunction("move_wrap", "hsnap, vsnap");
/* 303 */     applyFunction("move_towards_point", "x, y, sp");
/* 304 */     applyFunction("distance_to_point", "x, y");
/* 305 */     applyFunction("sleep", "millisecond");
/* 306 */     applyFunction("game_end", "");
/* 307 */     applyFunction("draw_sprite", "sprite, subimg, x, y");
/* 308 */     applyFunction("draw_sprite_stretched", "sprite, subimg, x, y, w, h");
/* 309 */     applyFunction("draw_clear", "color");
/* 310 */     applyFunction("draw_point", "x, y");
/* 311 */     applyFunction("draw_line", "x1, y1, x2, y2");
/* 312 */     applyFunction("draw_rectangle", "x1, y1, x2, y2, outline");
/* 313 */     applyFunction("draw_roundrect", "x1, y1, x2, y2, outline");
/* 314 */     applyFunction("draw_set_color", "color");
/* 315 */     applyFunction("draw_get_color", "");
/* 316 */     applyFunction("draw_get_red", "");
/* 317 */     applyFunction("draw_get_green", "");
/* 318 */     applyFunction("draw_get_blue", "");
/* 319 */     applyFunction("make_color_rgb", "red, green, blue");
/* 320 */     applyFunction("draw_text", "x, y, string");
/* 321 */     applyFunction("surface_create", "w, h");
/* 322 */     applyFunction("surface_get_width", "id");
/* 323 */     applyFunction("surface_get_height", "id");
/* 324 */     applyFunction("surface_set_target", "id");
/* 325 */     applyFunction("surface_reset_target", "id");
/* 326 */     applyFunction("surface_save", "id, fname");
/* 327 */     applyFunction("draw_surface", "id, x, y");
/*     */ 
/* 329 */     applyFunction("display_get_width", "");
/* 330 */     applyFunction("display_get_height", "");
/* 331 */     applyFunction("display_get_frequency", "");
/* 332 */     applyFunction("display_get_colordepth", "");
/* 333 */     applyFunction("show_message", "text");
/* 334 */     applyFunction("show_error", "text, abort");
/* 335 */     applyFunction("file_text_open_read", "fname");
/* 336 */     applyFunction("file_text_open_write", "fname");
/* 337 */     applyFunction("file_text_close", "fileid");
/* 338 */     applyFunction("file_text_write_string", "fileid, str");
/* 339 */     applyFunction("file_text_write_real", "fileid, x");
/* 340 */     applyFunction("file_text_read_string", "fileid");
/* 341 */     applyFunction("ds_stack_create", "");
/* 342 */     applyFunction("ds_stack_destroy", "id");
/* 343 */     applyFunction("ds_stack_clear", "id");
/* 344 */     applyFunction("ds_stack_size", "id");
/* 345 */     applyFunction("ds_stack_empty", "id");
/* 346 */     applyFunction("ds_stack_push", "id, value");
/* 347 */     applyFunction("ds_stack_pop", "id");
/* 348 */     applyFunction("ds_stack_top", "id");
/* 349 */     applyFunction("ds_queue_create", "");
/* 350 */     applyFunction("ds_queue_destroy", "id");
/* 351 */     applyFunction("ds_queue_clear", "id");
/* 352 */     applyFunction("ds_queue_size", "id");
/* 353 */     applyFunction("ds_queue_empty", "id");
/* 354 */     applyFunction("ds_queue_enqueue", "id, val");
/* 355 */     applyFunction("ds_queue_dequeue", "id");
/* 356 */     applyFunction("ds_queue_head", "id");
/* 357 */     applyFunction("ds_queue_tail", "id");
/*     */ 
/* 360 */     applyFunction("window_set_visible", "visible");
/* 361 */     applyFunction("window_get_visible", "");
/* 362 */     applyFunction("window_set_fullscreen", "fullscreen");
/* 363 */     applyFunction("window_get_fullscreen", "");
/* 364 */     applyFunction("window_set_showborder", "showborder");
/* 365 */     applyFunction("window_get_showborder", "");
/* 366 */     applyFunction("window_set_sizeable", "sizeable");
/* 367 */     applyFunction("window_get_sizeable", "");
/* 368 */     applyFunction("window_set_caption", "caption");
/* 369 */     applyFunction("window_get_caption", "");
/*     */ 
/* 372 */     Collections.sort(this.v);
/*     */ 
/* 374 */     this.list.setModel(new VectorListModel(this.v));
/* 375 */     this.list.setCellRenderer(new SuggestionCellRenderer());
/*     */ 
/* 377 */     if (this.v.size() == 1) {
/* 378 */       this.list.setSelectedIndex(0);
/* 379 */       String t = ((Suggestion)this.list.getSelectedValue()).confirm(this.context, this.prevWord);
/* 380 */       this.editor.insert(this.selstart, this.selend, t);
/* 381 */       this.editor.setSelectionStart(this.selstart + t.length());
/* 382 */       this.editor.setSelectionEnd(this.selstart + t.length());
/* 383 */       dispose();
/* 384 */       this.requestDie = true;
/*     */     }
/*     */   }
/*     */ 
/*     */   private String getContext() {
/* 389 */     int NULL = 0;
/* 390 */     int SCOMMENT = 1;
/* 391 */     int MCOMMENT = 2;
/* 392 */     int STRING = 3;
/* 393 */     int BSTRING = 4;
/* 394 */     int CHAR = 5;
/* 395 */     int BCHAR = 6;
/* 396 */     int situation = 0;
/* 397 */     String word = "";
/* 398 */     String x = this.editor.getText();
/* 399 */     int selection = this.selend;
/* 400 */     this.prevWord = "";
/* 401 */     if ((selection < 0) || (selection > x.length()))
/* 402 */       return null;
/* 403 */     for (int i = 0; i < selection; i++) {
/*     */       try {
/* 405 */         if (situation == 0) {
/* 406 */           if ((x.charAt(i) == '/') && (x.charAt(i + 1) == '/')) {
/* 407 */             if (!word.equals(""))
/* 408 */               this.prevWord = word;
/* 409 */             word = "";
/* 410 */             situation = 1;
/*     */           }
/* 413 */           else if ((x.charAt(i) == '/') && (x.charAt(i + 1) == '*')) {
/* 414 */             if (!word.equals(""))
/* 415 */               this.prevWord = word;
/* 416 */             word = "";
/* 417 */             situation = 2;
/*     */           }
/* 420 */           else if (x.charAt(i) == '"') {
/* 421 */             if (!word.equals(""))
/* 422 */               this.prevWord = word;
/* 423 */             word = "";
/* 424 */             situation = 3;
/*     */           }
/* 427 */           else if (x.charAt(i) == '\'') {
/* 428 */             if (!word.equals(""))
/* 429 */               this.prevWord = word;
/* 430 */             word = "";
/* 431 */             situation = 5;
/*     */           }
/* 434 */           else if ((x.charAt(i) == ' ') || (x.charAt(i) == '\t') || (x.charAt(i) == '\n') || (x.charAt(i) == '+') || (x.charAt(i) == '-') || (x.charAt(i) == '*') || (x.charAt(i) == '/') || (x.charAt(i) == '%') || (x.charAt(i) == '&') || (x.charAt(i) == '|') || (x.charAt(i) == '(') || (x.charAt(i) == ')') || (x.charAt(i) == '{') || (x.charAt(i) == '}') || (x.charAt(i) == '!') || (x.charAt(i) == '^') || (x.charAt(i) == ',') || (x.charAt(i) == ';') || (x.charAt(i) == '<') || (x.charAt(i) == '>') || (x.charAt(i) == '=') || (x.charAt(i) == '?') || (x.charAt(i) == ':'))
/*     */           {
/* 456 */             if (!word.equals(""))
/* 457 */               this.prevWord = word;
/* 458 */             word = "";
/*     */           }
/*     */           else {
/* 461 */             word = word + x.charAt(i);
/*     */           }
/*     */         }
/* 464 */         else if ((situation == 1) && 
/* 465 */           (x.charAt(i) == '\n')) {
/* 466 */           situation = 0;
/*     */         }
/* 470 */         else if ((situation == 2) && 
/* 471 */           (x.charAt(i) == '*') && (x.charAt(i + 1) == '/')) {
/* 472 */           situation = 0;
/*     */         }
/*     */         else
/*     */         {
/* 477 */           if (situation == 3) {
/* 478 */             if (x.charAt(i) == '\\') {
/* 479 */               situation = 4;
/* 480 */               continue;
/*     */             }
/* 482 */             if (x.charAt(i) == '"') {
/* 483 */               situation = 0;
/* 484 */               continue;
/*     */             }
/*     */           }
/* 487 */           if (situation == 4) {
/* 488 */             situation = 3;
/*     */           }
/*     */           else {
/* 491 */             if (situation == 5) {
/* 492 */               if (x.charAt(i) == '\\') {
/* 493 */                 situation = 6;
/* 494 */                 continue;
/*     */               }
/* 496 */               if (x.charAt(i) == '"') {
/* 497 */                 situation = 0;
/* 498 */                 continue;
/*     */               }
/*     */             }
/* 501 */             if (situation == 6)
/* 502 */               situation = 5;
/*     */           }
/*     */         }
/*     */       }
/*     */       catch (Exception e) {
/* 507 */         break;
/*     */       }
/*     */     }
/* 510 */     if (situation == 0) {
/* 511 */       return word;
/*     */     }
/* 513 */     return null;
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.autocomplete.GSAutocomplete
 * JD-Core Version:    0.6.2
 */