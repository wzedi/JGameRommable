/*     */ package org.gcreator.components;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;

/*     */ import javax.swing.JTextPane;
/*     */ import javax.swing.event.DocumentEvent;
/*     */ import javax.swing.event.DocumentListener;
/*     */ import javax.swing.text.BadLocationException;
/*     */ import javax.swing.text.DefaultStyledDocument;
/*     */ import javax.swing.text.Segment;
/*     */ import javax.swing.text.Style;
/*     */ import javax.swing.text.StyleConstants;
/*     */ import javax.swing.text.StyledDocument;

/*     */ import org.gcreator.autocomplete.AutocompleteFrame;
/*     */ import org.gcreator.components.impl.Token;
/*     */ import org.gcreator.fileclass.Project;

/*     */ import publicdomain.TokenTypes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SyntaxHighlighter extends JTextPane
/*     */   implements DocumentListener, TokenTypes
/*     */ {
/*     */   private StyledDocument doc;
/*     */   //private Scanner scanner;
/*     */   private int height;
/*     */   private int width;
/*     */   private Project project;
/*     */   Style[] styles;
/* 239 */   Segment text = new Segment();
/*     */   int firstRehighlightToken;
/* 241 */   int smallAmount = 100;
/*     */ 
/*     */   public SyntaxHighlighter(int height, int width, final Object scanner, Project project)
/*     */   {
/*  36 */     super(new DefaultStyledDocument());
/*  37 */     this.doc = ((StyledDocument)getDocument());
/*  38 */     this.height = height;
/*  39 */     this.width = width;
/*  40 */     //this.scanner = scanner;
/*  41 */     this.doc.addDocumentListener(this);
/*  42 */     Font font = new Font("Monospaced", 0, getFont().getSize());
/*  43 */     changeFont(font);
/*  44 */     initStyles();
/*  45 */     setBackground(Color.WHITE);
/*  46 */     this.project = project;
/*     */ 
/*  48 */     addKeyListener(new KeyListener()
/*     */     {
/*     */       public void keyReleased(KeyEvent evt) {
/*     */       }
/*     */ 
/*     */       public void keyPressed(KeyEvent evt) {
/*     */       }
/*     */ 
/*     */       public void keyTyped(KeyEvent evt) {
/*  57 */         if ((evt.getKeyChar() == ' ') && 
/*  58 */           (evt.isControlDown())) {
/*  59 */           SyntaxHighlighter.this.callAutocomplete();
/*     */         }
/*     */ 
/*  62 */         if ((!evt.isControlDown()) && 
/*  63 */           (scanner != null)) {
/*  64 */           int selstart = SyntaxHighlighter.this.getSelectionStart();
/*  65 */           int selend = SyntaxHighlighter.this.getSelectionEnd();
/*  66 */           //SyntaxHighlighter.this.insert(selstart, selend, scanner.symbolCompletion(evt.getKeyChar()));
/*  67 */           SyntaxHighlighter.this.setSelectionStart(selstart);
/*  68 */           SyntaxHighlighter.this.setSelectionEnd(selend);
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public void callAutocomplete()
/*     */   {
/*  77 */     AutocompleteFrame f = null; //this.scanner.callAutocomplete(getSelectionStart(), getSelectionEnd(), this, this.project);
/*  78 */     if ((f != null) && (!f.requestDie())) {
/*  79 */       f.setVisible(true);
/*  80 */       FontMetrics fm = getFontMetrics(getFont());
/*  81 */       int x = 0;
/*  82 */       int lh = fm.getHeight();
/*  83 */       int y = lh;
/*  84 */       int w = getWidth();
/*  85 */       String d = getText();
/*  86 */       for (int i = 0; i < getSelectionEnd(); i++) {
/*  87 */         char t = d.charAt(i);
/*  88 */         if ((t == '\r') || ((t == '\n') && ((i == 0) || (d.charAt(i - 1) != '\r')))) {
/*  89 */           x = 0;
/*  90 */           y += lh;
/*     */         }
/*     */         else
/*     */         {
/*     */           int cw;
/*  94 */           if (t != '\t')
/*  95 */             cw = fm.charWidth(t);
/*     */           else
/*  97 */             cw = fm.charWidth(' ') * 10;
/*  98 */           if (x + cw > w) {
/*  99 */             x = cw;
/* 100 */             y += lh;
/*     */           }
/*     */           else {
/* 103 */             x += cw;
/*     */           }
/*     */         }
/*     */       }
/* 105 */       f.setLocation(getLocationOnScreen().x + x, getLocationOnScreen().y + y);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void changeFont(Font font)
/*     */   {
/* 114 */     int borderOfJTextPane = 3;
/* 115 */     setFont(font);
/* 116 */     FontMetrics metrics = getFontMetrics(font);
/* 117 */     int paneWidth = this.width * metrics.charWidth('m') + 2 * borderOfJTextPane;
/* 118 */     int paneHeight = this.height * metrics.getHeight() + 2 * borderOfJTextPane;
/* 119 */     Dimension size = new Dimension(paneWidth, paneHeight);
/* 120 */     setMinimumSize(size);
/* 121 */     setPreferredSize(size);
/* 122 */     invalidate();
/*     */   }
/*     */ 
/*     */   public void read(Reader in, Object desc)
/*     */     throws IOException
/*     */   {
/* 131 */     int oldLength = getDocument().getLength();
/* 132 */     this.doc.removeDocumentListener(this);
/* 133 */     super.read(in, desc);
/* 134 */     this.doc = ((StyledDocument)getDocument());
/* 135 */     this.doc.addDocumentListener(this);
/* 136 */     int newLength = getDocument().getLength();
/* 137 */     this.firstRehighlightToken = 0; //this.scanner.change(0, oldLength, newLength);
/* 138 */     repaint();
/*     */   }
/*     */ 
/*     */   private void initStyles()
/*     */   {
/* 146 */     this.styles = new Style[typeNames.length];
/* 147 */     changeStyle(0, Color.red);
/* 148 */     changeStyle(1, Color.black);
/* 149 */     changeStyle(2, Color.black);
/* 150 */     changeStyle(3, Color.orange.darker());
/* 151 */     changeStyle(4, Color.orange.darker());
/* 152 */     changeStyle(5, Color.green.darker());
/* 153 */     changeStyle(6, Color.green.darker());
/* 154 */     changeStyle(7, Color.green.darker());
/* 155 */     changeStyle(8, Color.green.darker());
/* 156 */     changeStyle(9, Color.blue);
/* 157 */     changeStyle(10, Color.blue);
/* 158 */     changeStyle(11, Color.blue);
/* 159 */     changeStyle(12, Color.blue);
/* 160 */     changeStyle(13, Color.black);
/* 161 */     changeStyle(14, Color.blue);
/* 162 */     changeStyle(15, Color.red);
/* 163 */     changeStyle(16, Color.magenta);
/* 164 */     changeStyle(17, Color.black);
/* 165 */     changeStyle(18, Color.DARK_GRAY);
/* 166 */     changeStyle(19, Color.orange.darker());
/* 167 */     changeStyle(20, Color.blue.darker());
/*     */ 
/* 169 */     for (int i = 0; i < this.styles.length; i++)
/* 170 */       if (this.styles[i] == null)
/* 171 */         this.styles[i] = this.styles[1];
/*     */   }
/*     */ 
/*     */   public void changeStyle(int type, Color color)
/*     */   {
/* 180 */     Style style = addStyle(typeNames[type], null);
/* 181 */     StyleConstants.setForeground(style, color);
/* 182 */     this.styles[type] = style;
/*     */   }
/*     */ 
/*     */   public void changeStyle(int type, Color color, boolean underlined)
/*     */   {
/* 189 */     Style style = addStyle(typeNames[type], null);
/* 190 */     StyleConstants.setForeground(style, color);
/* 191 */     StyleConstants.setUnderline(style, underlined);
/* 192 */     this.styles[type] = style;
/*     */   }
/*     */ 
/*     */   public void changeStyle(int type, Color color, int fontStyle)
/*     */   {
/* 202 */     Style style = addStyle(typeNames[type], null);
/* 203 */     StyleConstants.setForeground(style, color);
/* 204 */     if ((fontStyle & 0x1) != 0) {
/* 205 */       StyleConstants.setBold(style, true);
/*     */     }
/* 207 */     if ((fontStyle & 0x2) != 0) {
/* 208 */       StyleConstants.setItalic(style, true);
/*     */     }
/* 210 */     this.styles[type] = style;
/*     */   }
/*     */ 
/*     */   public void insertUpdate(DocumentEvent e)
/*     */   {
/* 216 */     int offset = e.getOffset();
/* 217 */     int length = e.getLength();
/* 218 */     this.firstRehighlightToken = 0; //this.scanner.change(offset, 0, length);
/* 219 */     repaint();
/*     */   }
/*     */ 
/*     */   public void removeUpdate(DocumentEvent e)
/*     */   {
/* 225 */     int offset = e.getOffset();
/* 226 */     int length = e.getLength();
/* 227 */     this.firstRehighlightToken = 0; //this.scanner.change(offset, length, 0);
/* 228 */     repaint();
/*     */   }
/*     */ 
/*     */   public void changedUpdate(DocumentEvent e)
/*     */   {
/*     */   }
/*     */ 
/*     */   protected void paintComponent(Graphics g)
/*     */   {
/* 248 */     super.paintComponent(g);
/* 249 */     int offset = 0; //this.scanner.position();
/* 250 */     if (offset < 0) {
/* 251 */       return;
/*     */     }
/*     */ 
/* 254 */     int tokensToRedo = 0;
/* 255 */     int amount = this.smallAmount;
/* 256 */     while ((tokensToRedo == 0) && (offset >= 0)) {
/* 257 */       int length = this.doc.getLength() - offset;
/* 258 */       if (length > amount)
/* 259 */         length = amount;
/*     */       try
/*     */       {
/* 262 */         this.doc.getText(offset, length, this.text);
/*     */       } catch (BadLocationException e) {
/* 264 */         return;
/*     */       }
/* 266 */       tokensToRedo = 0; //this.scanner.scan(this.text.array, this.text.offset, this.text.count);
/* 267 */       offset = 0; //this.scanner.position();
/* 268 */       amount = 2 * amount;
/*     */     }
/* 270 */     for (int i = 0; i < tokensToRedo; i++) {
/* 271 */       Token t = null; //this.scanner.getToken(this.firstRehighlightToken + i);
/* 272 */       int length = t.symbol.name.length();
/* 273 */       int type = t.symbol.type;
/* 274 */       if (type < 0) {
/* 275 */         type = 0;
/*     */       }
/* 277 */       this.doc.setCharacterAttributes(t.position, length, this.styles[type], false);
/*     */     }
/* 279 */     this.firstRehighlightToken += tokensToRedo;
/* 280 */     if (offset >= 0)
/* 281 */       repaint(2L);
/*     */   }
/*     */ 
/*     */   public void insert(int selstart, int selend, String text)
/*     */   {
/* 286 */     String content = getText();
/* 287 */     String before = content.substring(0, selstart);
/* 288 */     String after = content.substring(selend);
/* 289 */     setText(before + text + after);
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.components.SyntaxHighlighter
 * JD-Core Version:    0.6.2
 */