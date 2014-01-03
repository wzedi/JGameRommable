/*     */ package org.gcreator.fileclass.res;
/*     */ 
/*     */ import java.util.Enumeration;
/*     */ import java.util.Vector;
/*     */ import org.gcreator.events.Event;
/*     */ import org.gcreator.fileclass.GFile;
/*     */ 
/*     */ public class Actor extends Resource
/*     */ {
/*     */   static final long serialVersionUID = 1L;
/*     */   public boolean visible;
/*     */   public boolean solid;
/*     */   public boolean persistant;
/*     */   public GFile sprite;
/*     */   public GFile extend;
/*     */   public GFile mask;
/*     */   public int index;
/*     */   public int depth;
/*     */   public Vector events;
/*     */ 
/*     */   public Actor(String name)
/*     */   {
/*  31 */     this.name = name;
/*  32 */     this.events = new Vector();
/*     */   }
/*     */ 
/*     */   public String writeXml() {
/*  36 */     String xml = "";
/*  37 */     xml = xml + "<?xml version=\"1.0\"?>\n";
/*  38 */     xml = xml + "<actoreditor version=\"1.0\"/>\n";
/*  39 */     xml = xml + "<Solid>" + this.solid + "</Solid>\n";
/*  40 */     xml = xml + "<Visible>" + this.visible + "</Visible>\n";
/*  41 */     xml = xml + "<Persistant>" + this.persistant + "</Persistant>\n";
/*  42 */     if (this.sprite == null)
/*  43 */       xml = xml + "<Sprite>//!NULLSPRITE</Sprite>";
/*     */     else {
/*  45 */       xml = xml + "<Sprite>" + this.sprite + "</Sprite>";
/*     */     }
/*  47 */     for (Enumeration e = this.events.elements(); e.hasMoreElements(); ) {
/*  48 */       xml = xml + ((Event)e.nextElement()).writeXml();
/*     */     }
/*  50 */     return xml;
/*     */   }
/*     */ 
/*     */   public String exportToHtml(boolean xhtml)
/*     */   {
/*  85 */     String html = "";
/*  86 */     if (xhtml)
/*  87 */       html = html + "<!DOCTYPE html\nPUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">";
/*     */     else {
/*  89 */       html = html + "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n\"http://www.w3.org/TR/html4/loose.dtd\">";
/*     */     }
/*  91 */     html = html + "\n";
/*  92 */     html = html + "<html>\n";
/*  93 */     html = html + "<head>\n";
/*  94 */     html = html + "\t<title>" + this.name + "</title>\n";
/*  95 */     html = html + "</head>\n";
/*  96 */     html = html + "<body>\n";
/*     */ 
/*  98 */     html = html + "<table border=";
/*  99 */     if (xhtml) {
/* 100 */       html = html + "\"";
/*     */     }
/* 102 */     html = html + "1";
/* 103 */     if (xhtml) {
/* 104 */       html = html + "\"";
/*     */     }
/* 106 */     html = html + " width=";
/* 107 */     if (xhtml) {
/* 108 */       html = html + "\"";
/*     */     }
/* 110 */     html = html + "100%";
/* 111 */     if (xhtml) {
/* 112 */       html = html + "\"";
/*     */     }
/* 114 */     html = html + ">\n";
/* 115 */     html = html + "<tr>\n";
/* 116 */     html = html + "<td>\n";
/*     */ 
/* 118 */     html = html + "Name: " + this.name + "<br";
/* 119 */     if (xhtml) {
/* 120 */       html = html + "/";
/*     */     }
/* 122 */     html = html + ">\n";
/*     */ 
/* 124 */     html = html + "<fieldset>\n<legend>Sprite</legend>\n</fieldset>\n";
/*     */ 
/* 126 */     html = html + "<input type=\"checkbox\"";
/* 127 */     if (this.visible) {
/* 128 */       html = html + " checked";
/* 129 */       if (xhtml) {
/* 130 */         html = html + "=\"checked\"";
/*     */       }
/*     */     }
/* 133 */     html = html + " disabled";
/* 134 */     if (xhtml) {
/* 135 */       html = html + "=\"disabled\" /";
/*     */     }
/* 137 */     html = html + ">Visible<br";
/* 138 */     if (xhtml) {
/* 139 */       html = html + "/";
/*     */     }
/* 141 */     html = html + ">\n";
/*     */ 
/* 143 */     html = html + "<input type=\"checkbox\"";
/* 144 */     if (this.solid) {
/* 145 */       html = html + " checked";
/* 146 */       if (xhtml) {
/* 147 */         html = html + "=\"checked\"";
/*     */       }
/*     */     }
/* 150 */     html = html + " disabled";
/* 151 */     if (xhtml) {
/* 152 */       html = html + "=\"disabled\" /";
/*     */     }
/* 154 */     html = html + ">Solid<br";
/* 155 */     if (xhtml) {
/* 156 */       html = html + "/";
/*     */     }
/* 158 */     html = html + ">\n";
/*     */ 
/* 160 */     html = html + "<input type=\"checkbox\"";
/* 161 */     if (this.persistant) {
/* 162 */       html = html + " checked";
/* 163 */       if (xhtml) {
/* 164 */         html = html + "=\"checked\"";
/*     */       }
/*     */     }
/* 167 */     html = html + " disabled";
/* 168 */     if (xhtml) {
/* 169 */       html = html + "=\"disabled\" /";
/*     */     }
/* 171 */     html = html + ">Persistant<br";
/* 172 */     if (xhtml) {
/* 173 */       html = html + "/";
/*     */     }
/* 175 */     html = html + ">\n";
/*     */ 
/* 177 */     if (xhtml) {
/* 178 */       html = html + "</td>\n";
/*     */     }
/* 180 */     if (xhtml) {
/* 181 */       html = html + "</tr>\n";
/*     */     }
/* 183 */     html = html + "</table>\n";
/*     */ 
/* 185 */     html = html + "</body>\n";
/* 186 */     html = html + "</html>";
/*     */ 
/* 188 */     return html;
/*     */   }
/*     */ 
/*     */   public Object clone()
/*     */   {
/* 193 */     Actor a = new Actor(this.name);
/* 194 */     a.depth = this.depth;
/* 195 */     Object o = this.events.clone();
/* 196 */     if ((o != null) && ((o instanceof Vector)))
/* 197 */       a.events = ((Vector)o);
/*     */     else {
/* 199 */       a = null;
/*     */     }
/* 201 */     a.extend = this.extend;
/* 202 */     a.index = this.index;
/* 203 */     a.mask = this.mask;
/* 204 */     a.persistant = this.persistant;
/* 205 */     a.solid = this.solid;
/* 206 */     a.visible = this.visible;
/* 207 */     a.sprite = this.sprite;
/* 208 */     return a;
/*     */   }
/*     */ 
/*     */   public void readXml(String xml)
/*     */   {
/*     */   }
/*     */ }

/* Location:           /Users/wzedi/Downloads/M2/G-Creator.jar
 * Qualified Name:     org.gcreator.fileclass.res.Actor
 * JD-Core Version:    0.6.2
 */